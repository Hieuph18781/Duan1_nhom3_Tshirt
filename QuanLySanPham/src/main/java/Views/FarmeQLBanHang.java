/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Views;

import Services.HoaDonChiTietService;
import Services.HoaDonService;
import Services.IHoaDonService;
import Services.ISanPhamService;
import Services.SanPhamService;
import Services.IKhuyenMaiService;
import Services.IManagerKhachHangService;
import Utils.Auth;
import ViewsModels.HoaDonModel;
import ViewsModels.NhanVienModel;
import ViewsModels.KhachHangModel;
import ViewsModels.KhuyenMaiModel;
import ViewsModels.SanPhamModel;
import ViewsModels.HoaDonChiTietModel;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Services.IHoaDonChiTietService;
import Services.KhuyenMaiService;
import Services.ManagerKhachHangServicr;
import java.text.ParseException;
import java.util.Date;
import java.util.Properties;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author hieu
 */
public class FarmeQLBanHang extends javax.swing.JFrame {

    /**
     * Creates new form banhang
     */
    ISanPhamService _ISanPhamService;
    IHoaDonService _HoaDonService;
    IHoaDonChiTietService _HoaDonCTService;
    IKhuyenMaiService _IKhuyenMaiService;
    IManagerKhachHangService _IManagerKhachHangService;
    List<HoaDonModel> _lstHoaDonCho;
    List<KhuyenMaiModel> _lstKhuyenMai;
    int _soluongcu;
    int _randomCode = -1;
    KhachHangModel _khHangModel;

    public FarmeQLBanHang() {
        initComponents();
        _ISanPhamService = new SanPhamService();
        _HoaDonService = new HoaDonService();
        _lstHoaDonCho = new ArrayList<>();
        _IKhuyenMaiService = new KhuyenMaiService();
        _IManagerKhachHangService = new ManagerKhachHangServicr();
        _HoaDonCTService = new HoaDonChiTietService();
        _lstKhuyenMai = new ArrayList<>();
        _khHangModel = _IManagerKhachHangService.getAllKhachHang().get(0);
        cbcKhuyenMai();
        setrdb();
        cbcLoaiKhachHang();
        loadtableSanPham(_ISanPhamService.getlistsanpham());
        loadtableHoaThanhCong(_HoaDonService.getLstToDay(new java.util.Date()));
    }

    void setrdb() {
        ButtonGroup btn = new ButtonGroup();
        btn.add(rdb_dungdiem);
        btn.add(rdb_khongdungdiem);
        rdb_khongdungdiem.setSelected(true);
    }

    boolean tongTien() {
        if (tbl_taoHoaDon.getRowCount() < 0) {
            txt_thanhTien.setText("0");
            return false;
        }
        int soluongSanPhamDachon = tbl_sanPhamDaChon.getRowCount();//tổng dòng đang có trong bảng
        if (soluongSanPhamDachon == 0) {
            txt_thanhTien.setText("0");
            return false;
        }
        double tongtien = 0;
        for (int i = 0; i < soluongSanPhamDachon; i++) {
            tongtien = tongtien + Integer.parseInt(tbl_sanPhamDaChon.getModel().getValueAt(i, 9).toString());
        }
        System.out.println(rdb_dungdiem.isSelected());
        if (rdb_dungdiem.isSelected()) {
            tongtien = tongtien - Integer.parseInt(txt_diemTichMuaHang.getText());
            tongtien = tongtien - (tongtien * (_lstKhuyenMai.get(cbc_khuyenMai.getSelectedIndex()).getGiaKhuyenMai() / 100D));
            int tong = (int) tongtien;
            txt_thanhTien.setText(String.valueOf(tong));
            return true;
        }
        tongtien = tongtien - (tongtien * (_lstKhuyenMai.get(cbc_khuyenMai.getSelectedIndex()).getGiaKhuyenMai() / 100D));
        int tong = (int) tongtien;
        txt_thanhTien.setText(String.valueOf(tong));
        return true;
    }

    HoaDonModel getNewHoaDonModel() {
        KhachHangModel kh = new KhachHangModel();
        kh.setMaKhachHang(1);

        KhuyenMaiModel km = new KhuyenMaiModel();
        km.setIdKhuyenMai(1);
        return new HoaDonModel(0, new java.util.Date(), 0, Auth.user, kh, km);
    }

    void cbcKhuyenMai() {
        DefaultComboBoxModel cbx = new DefaultComboBoxModel();
        Date dateToday = new java.util.Date();
        //ngày bắt đầu phải bé hơn ngày hiện tại
        //ngày hiện tại bé hơn ngày kết thúc
        //ngày bắt đầu < ngày hiện tại < ngày kết thúc
        for (KhuyenMaiModel x : _IKhuyenMaiService.getListFromDB()) {
            if (!(x.getNgayBatDau().compareTo(dateToday) == 1) && !(dateToday.compareTo(x.getNgayKetThuc()) == 1)) {
                cbx.addElement(x.getTenKhuyenMai());
                _lstKhuyenMai.add(x);
            }
        }
        cbc_khuyenMai.setModel(cbx);
    }

//    public void sendemail(String email) {
//        try {
//            Random rand = new Random();
//            _randomCode = rand.nextInt(999999);
//            String user = "cuongdtph18984@fpt.edu.vn";
//            String pass = "abcd@@@@1";
//            String to = email;
//            String subject = "Reseting Code";
//            String message = "Your reset code is " + _randomCode;
//            boolean sessionDebug = false;
//            Properties pros = System.getProperties();
//            pros.put("mail.smtp.starttls.enable", "true");
//            pros.put("mail.smtp.starttls.required", "true");
//            pros.put("mail.smtp.host", "smtp.gmail.com");
//            pros.put("mail.smtp.port", "587");
//            pros.put("mail.smtp.auth", "true");
//
//            Session mailSession = Session.getDefaultInstance(pros, null);
//            mailSession.setDebug(sessionDebug);
//            Message msg = new MimeMessage(mailSession);
//            msg.setFrom(new InternetAddress(user));
//            InternetAddress[] address = {new InternetAddress(to)};
//            msg.setRecipients(Message.RecipientType.TO, address);
//            msg.setSubject(subject);
//            msg.setText(message);
//            Transport transport = mailSession.getTransport("smtp");
//            transport.connect("smtp.gmail.com", user, pass);
//            transport.sendMessage(msg, msg.getAllRecipients());
//            transport.close();
//            JOptionPane.showMessageDialog(this, "Gửi mã xác nhận thành công");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    void cbcLoaiKhachHang() {
        DefaultComboBoxModel cbx = new DefaultComboBoxModel();
        cbx.addElement("Khách Lẻ");
        cbx.addElement("Khách Thành Viên");
        cbc_khachHang.setModel(cbx);
        checkLoaiKhachHang();
    }

    void checkLoaiKhachHang() {
        if (cbc_khachHang.getSelectedItem().equals("Khách Lẻ")) {
            txt_soDienThoai.setText("");
            txt_tenKhachHang.setText("");
            txt_diemTichMuaHang.setText("0");
            txt_soDienThoai.setEnabled(false);
            txt_tenKhachHang.setEnabled(false);
            txt_diemTichMuaHang.setEnabled(false);
            btn_guima.setEnabled(false);
            btn_xacnhanMa.setEnabled(false);
            txt_xacnhanma.setEnabled(false);
            txt_thanhTien.setEnabled(false);
            txt_tienThua.setEnabled(false);
            rdb_dungdiem.setEnabled(false);
            rdb_khongdungdiem.setEnabled(false);
        }
        if (!cbc_khachHang.getSelectedItem().equals("Khách Lẻ")) {
            txt_soDienThoai.setEnabled(true);
//            txt_tenKhachHang.setEnabled(true);
            btn_guima.setEnabled(true);
            rdb_dungdiem.setEnabled(true);
            rdb_khongdungdiem.setEnabled(true);
        }
    }

    public void loadtableSanPham(List<SanPhamModel> lstSP) {
        DefaultTableModel _DefaultTableModel = new DefaultTableModel();
        _DefaultTableModel = (DefaultTableModel) tbl_sanPham.getModel();
        _DefaultTableModel.setRowCount(0);
        int stt = 1;
        for (SanPhamModel x : lstSP) {
            if (x.isTrangThai() == true) {
                _DefaultTableModel.addRow(new Object[]{stt++, x.getMaSanPham(), x.getTenSanPham(),
                    x.getChatlieuModel().getTenChatLieu(),
                    x.getDanhMucSanPhamModel().getTenDanhMuc(),
                    x.getKieudangModel().getTenKieuDang(),
                    x.getSizeModel().getTenSize(),
                    x.getMausacModel().getTenMauSac(),
                    x.getSoLuong(), x.getGia()
                });
            }
        }
    }

    public void loadtableHoaDonCho(List<HoaDonModel> lstHoaDonModels) {
        DefaultTableModel _DefaultTableModel = new DefaultTableModel();
        _DefaultTableModel = (DefaultTableModel) tbl_taoHoaDon.getModel();
        _DefaultTableModel.setRowCount(0);
        int stt = 1;
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        for (HoaDonModel x : lstHoaDonModels) {
            _DefaultTableModel.addRow(new Object[]{stt++, x.getMaHoaDon(), dateFormat.format(x.getThoiGianTao()),
                x.getNhanvien().getHoTen(),
                x.getTrangThai() == 0 ? "Đang Chờ" : "Đã Hủy"
            });
        }
    }

    public void loadtableHoaThanhCong(List<HoaDonModel> lstHoaDonModels) {
        DefaultTableModel _DefaultTableModel = new DefaultTableModel();
        _DefaultTableModel = (DefaultTableModel) tbl_hoaDonThanhCong.getModel();
        _DefaultTableModel.setRowCount(0);
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        for (HoaDonModel x : lstHoaDonModels) {
            _DefaultTableModel.addRow(new Object[]{x.getMaHoaDon(), dateFormat.format(x.getThoiGianTao()),
                x.getNhanvien().getHoTen(),
                x.getTrangThai() == 0 ? "Đang Chờ" : x.getTrangThai() == 1 ? "Hủy" : "Thành Công"
            });
        }
    }

    public void loadtableSanPhamDaChon(List<HoaDonChiTietModel> lstHoaDonModels) {
        DefaultTableModel _DefaultTableModel = new DefaultTableModel();
        _DefaultTableModel = (DefaultTableModel) tbl_sanPhamDaChon.getModel();
        _DefaultTableModel.setRowCount(0);
        int stt = 1;
        for (HoaDonChiTietModel x : lstHoaDonModels) {
            _DefaultTableModel.addRow(new Object[]{stt++, x.getSanPhamModel().getMaSanPham(), x.getSanPhamModel().getTenSanPham(),
                x.getSanPhamModel().getChatlieuModel().getTenChatLieu(),
                x.getSanPhamModel().getDanhMucSanPhamModel().getTenDanhMuc(),
                x.getSanPhamModel().getKieudangModel().getTenKieuDang(),
                x.getSanPhamModel().getSizeModel().getTenSize(),
                x.getSanPhamModel().getMausacModel().getTenMauSac(),
                x.getSoLuong(), x.getSanPhamModel().getGia() * x.getSoLuong()
            });
        }
    }

    public HoaDonModel getHoaDonCho() {
        int indexHdCho = tbl_taoHoaDon.getSelectedRow();
        return new HoaDonModel(Integer.parseInt(tbl_taoHoaDon.getModel().getValueAt(indexHdCho, 1).toString()));
    }

    public SanPhamModel getSp() {
        int indexSp = tbl_sanPham.getSelectedRow();
        return new SanPhamModel(tbl_sanPham.getModel().getValueAt(indexSp, 1).toString(), tbl_sanPham.getModel().getValueAt(indexSp, 2).toString(), Integer.parseInt(tbl_sanPham.getModel().getValueAt(indexSp, 8).toString()));
    }

    public boolean checkIndexTable(int index) {
        if (index < 0) {
            return true;
        }
        return false;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_sanPham = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_sanPhamDaChon = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btn_thanhtoan = new javax.swing.JButton();
        btn_inhoadon = new javax.swing.JButton();
        btn_huy = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txt_tienKhachDua = new javax.swing.JTextField();
        txt_soDienThoai = new javax.swing.JTextField();
        txt_diemTichMuaHang = new javax.swing.JTextField();
        txt_thanhTien = new javax.swing.JTextField();
        txt_tienThua = new javax.swing.JTextField();
        cbc_khuyenMai = new javax.swing.JComboBox<>();
        cbc_khachHang = new javax.swing.JComboBox<>();
        txt_tenKhachHang = new javax.swing.JTextField();
        btn_guima = new javax.swing.JButton();
        txt_xacnhanma = new javax.swing.JTextField();
        btn_xacnhanMa = new javax.swing.JButton();
        rdb_dungdiem = new javax.swing.JRadioButton();
        rdb_khongdungdiem = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbl_hoaDonThanhCong = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        btn_taoHoaDon = new javax.swing.JButton();
        btn_huyHoaDon = new javax.swing.JButton();
        btn_xoaSanPham = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbl_taoHoaDon = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản Lý Bán Hàng");

        jPanel5.setBackground(new java.awt.Color(204, 255, 255));

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách sản phẩm", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        tbl_sanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã sản phẩm", "Tên sản phẩm", "Chẩt Liệu", "Danh Mục", "Kiểu dáng", "Size", "Màu Sắc", "Số lượng", "Giá tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_sanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tbl_sanPhamMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_sanPham);
        if (tbl_sanPham.getColumnModel().getColumnCount() > 0) {
            tbl_sanPham.getColumnModel().getColumn(0).setResizable(false);
            tbl_sanPham.getColumnModel().getColumn(1).setHeaderValue("Mã sản phẩm");
            tbl_sanPham.getColumnModel().getColumn(2).setResizable(false);
            tbl_sanPham.getColumnModel().getColumn(2).setHeaderValue("Tên sản phẩm");
            tbl_sanPham.getColumnModel().getColumn(3).setHeaderValue("Chẩt Liệu");
            tbl_sanPham.getColumnModel().getColumn(4).setHeaderValue("Danh Mục");
            tbl_sanPham.getColumnModel().getColumn(5).setHeaderValue("Kiểu dáng");
            tbl_sanPham.getColumnModel().getColumn(6).setHeaderValue("Size");
            tbl_sanPham.getColumnModel().getColumn(7).setHeaderValue("Màu Sắc");
            tbl_sanPham.getColumnModel().getColumn(8).setHeaderValue("Số lượng");
            tbl_sanPham.getColumnModel().getColumn(9).setHeaderValue("Giá tiền");
        }

        jLabel1.setText("Tìm Kiếm :");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 638, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 278, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(204, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách sản phẩm đã chọn", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        tbl_sanPhamDaChon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã sản phẩm", "Tên sản phẩm", "Chẩt Liệu", "Danh Mục", "Kiểu dáng", "Size", "Màu Sắc", "Số lượng", "Thành Tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_sanPhamDaChon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tbl_sanPhamDaChonMouseReleased(evt);
            }
        });
        tbl_sanPhamDaChon.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tbl_sanPhamDaChonKeyReleased(evt);
            }
        });
        jScrollPane3.setViewportView(tbl_sanPhamDaChon);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(204, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Hóa Đơn", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Tổng Tiền");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Tiền khách đưa");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Khuyễn mãi ");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Loại khách hàng");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Tiền thừa");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Điểm tích mua hàng");

        btn_thanhtoan.setText("Thanh toán");
        btn_thanhtoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_thanhtoanActionPerformed(evt);
            }
        });

        btn_inhoadon.setText("In hoá đơn");

        btn_huy.setText("Huỷ");
        btn_huy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_huyActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Số điện thoại");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setText("Tên Khách Hàng");

        txt_tienKhachDua.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txt_tienKhachDuaCaretUpdate(evt);
            }
        });

        txt_soDienThoai.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txt_soDienThoaiCaretUpdate(evt);
            }
        });

        txt_thanhTien.setForeground(new java.awt.Color(255, 0, 0));

        txt_tienThua.setText("0");

        cbc_khuyenMai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbc_khuyenMai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbc_khuyenMaiActionPerformed(evt);
            }
        });

        cbc_khachHang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbc_khachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbc_khachHangActionPerformed(evt);
            }
        });

        btn_guima.setText("Gửi Mã Xác Nhận");
        btn_guima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guimaActionPerformed(evt);
            }
        });

        btn_xacnhanMa.setText("Xác Nhận Mã");
        btn_xacnhanMa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xacnhanMaActionPerformed(evt);
            }
        });

        rdb_dungdiem.setText("Dùng Điểm");
        rdb_dungdiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdb_dungdiemActionPerformed(evt);
            }
        });

        rdb_khongdungdiem.setText("Không Dùng Điểm");
        rdb_khongdungdiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdb_khongdungdiemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_xacnhanMa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_tienThua)
                            .addComponent(txt_thanhTien)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(txt_soDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 10, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txt_diemTichMuaHang, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbc_khachHang, javax.swing.GroupLayout.Alignment.LEADING, 0, 136, Short.MAX_VALUE)
                                    .addComponent(txt_tenKhachHang, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_xacnhanma, javax.swing.GroupLayout.Alignment.LEADING))
                                .addContainerGap())
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_tienKhachDua)
                                    .addComponent(cbc_khuyenMai, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btn_thanhtoan)
                        .addGap(18, 18, 18)
                        .addComponent(btn_inhoadon)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_huy, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_guima, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(rdb_dungdiem)
                                .addGap(65, 65, 65)
                                .addComponent(rdb_khongdungdiem)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_tienKhachDua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbc_khuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cbc_khachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txt_soDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txt_tenKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_guima)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_xacnhanMa)
                    .addComponent(txt_xacnhanma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txt_diemTichMuaHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdb_dungdiem)
                    .addComponent(rdb_khongdungdiem))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_thanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txt_tienThua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_thanhtoan)
                    .addComponent(btn_inhoadon)
                    .addComponent(btn_huy))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(204, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Hóa Đơn", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        tbl_hoaDonThanhCong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Hóa Đơn", "Ngày Tạo", "Người Tạo", "Trạng Thái"
            }
        ));
        jScrollPane5.setViewportView(tbl_hoaDonThanhCong);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        jPanel6.setBackground(new java.awt.Color(204, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 14))); // NOI18N

        btn_taoHoaDon.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btn_taoHoaDon.setText("Tạo Hóa Đơn");
        btn_taoHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_taoHoaDonActionPerformed(evt);
            }
        });

        btn_huyHoaDon.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btn_huyHoaDon.setText("Hủy Hóa Đơn");
        btn_huyHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_huyHoaDonActionPerformed(evt);
            }
        });

        btn_xoaSanPham.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btn_xoaSanPham.setText("Xóa Sản Phẩm");
        btn_xoaSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoaSanPhamActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_xoaSanPham, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_huyHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_taoHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(20, Short.MAX_VALUE))
            .addComponent(jSeparator1)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(btn_taoHoaDon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_huyHoaDon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_xoaSanPham)
                .addContainerGap())
        );

        jPanel7.setBackground(new java.awt.Color(204, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Hóa Đơn", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 14))); // NOI18N

        tbl_taoHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "MÃ HĐ", "Thời Gian Tạo", "Người Tạo", "Trạng Thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_taoHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tbl_taoHoaDonMouseReleased(evt);
            }
        });
        jScrollPane4.setViewportView(tbl_taoHoaDon);
        if (tbl_taoHoaDon.getColumnModel().getColumnCount() > 0) {
            tbl_taoHoaDon.getColumnModel().getColumn(0).setResizable(false);
        }

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_huyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_huyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_huyActionPerformed

    private void btn_huyHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_huyHoaDonActionPerformed
        try {
            int indexHdCho = tbl_taoHoaDon.getSelectedRow();
            if (checkIndexTable(indexHdCho)) {
                JOptionPane.showMessageDialog(this, "Không tìm thấy Hóa đơn muốn hủy");
                return;
            }
            //xử lý trạng thái hóa đơn
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
            KhachHangModel kh = new KhachHangModel();
            kh.setMaKhachHang(1);
            KhuyenMaiModel km = new KhuyenMaiModel();
            km.setIdKhuyenMai(1);
            HoaDonModel hdmd = new HoaDonModel(Integer.parseInt(tbl_taoHoaDon.getModel().getValueAt(indexHdCho, 1).toString()), dateFormat.parse(tbl_taoHoaDon.getModel().getValueAt(indexHdCho, 2).toString()), 1, Auth.user, kh, km);
            _HoaDonService.sua(hdmd);//cập nhật trạng thái hóa đơn
            _lstHoaDonCho.remove(indexHdCho);//remove hóa đơn khỏi list
            // xử lý Hóa đơn chi tiết
            for (HoaDonChiTietModel x : _HoaDonCTService.getListFromDB(hdmd.getMaHoaDon())) {
                for (SanPhamModel y : _ISanPhamService.getlistsanpham()) {
                    if (x.getSanPhamModel().getMaSanPham().equals(y.getMaSanPham())) {
                        _ISanPhamService.suaSoLuongSP(y.getMaSanPham(), (y.getSoLuong() + x.getSoLuong()));
                    }
                }
                x.setSoLuong(0);
                _HoaDonCTService.sua(x);
            }

            loadtableHoaThanhCong(_HoaDonService.getLstToDay(new java.util.Date()));
            loadtableHoaDonCho(_lstHoaDonCho);
            loadtableSanPhamDaChon(_HoaDonCTService.getListFromDB(-1));
            loadtableSanPham(_ISanPhamService.getlistsanpham());
        } catch (ParseException ex) {
            Logger.getLogger(FarmeQLBanHang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_huyHoaDonActionPerformed

    private void btn_xoaSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaSanPhamActionPerformed
        int indexSp = tbl_sanPhamDaChon.getSelectedRow();
        if (checkIndexTable(indexSp)) {
            JOptionPane.showMessageDialog(this, "Không tìm thấy sản phẩm đã chọn");
            return;
        }
        SanPhamModel spmodel = new SanPhamModel(tbl_sanPhamDaChon.getModel().getValueAt(indexSp, 1).toString(), tbl_sanPhamDaChon.getModel().getValueAt(indexSp, 2).toString(), 0);

        HoaDonChiTietModel hdct = new HoaDonChiTietModel(0, Integer.parseInt(tbl_sanPhamDaChon.getModel().getValueAt(indexSp, 8).toString()), 0, spmodel, getHoaDonCho());

        for (SanPhamModel x : _ISanPhamService.getlistsanpham()) {
            if (x.getMaSanPham().equals(tbl_sanPhamDaChon.getModel().getValueAt(indexSp, 1).toString())) {
                _ISanPhamService.suaSoLuongSP(tbl_sanPhamDaChon.getValueAt(indexSp, 1).toString(), x.getSoLuong() + Integer.parseInt(tbl_sanPhamDaChon.getModel().getValueAt(indexSp, 8).toString()));//update so luong san pham
            }
        }
        _HoaDonCTService.xoa(hdct);
        loadtableSanPhamDaChon(_HoaDonCTService.getListFromDB(hdct.getHoaDonModel().getMaHoaDon()));//load sản phẩm đã chọn
        loadtableSanPham(_ISanPhamService.getlistsanpham());//load lại số lượng sản phẩm
        tongTien();
    }//GEN-LAST:event_btn_xoaSanPhamActionPerformed

    private void btn_thanhtoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_thanhtoanActionPerformed
        tongTien();
        int indexHoaDOn = tbl_taoHoaDon.getSelectedRow();
        if (indexHoaDOn < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn hóa đơn cần thanh toán");
            return;
        }
        if (tbl_sanPhamDaChon.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "Hóa Đơn chưa có sản phẩm nào");
            return;
        }
        if (Utils.CheckData.checkNullString(txt_tienKhachDua.getText()) && !Utils.CheckData.checkso(txt_tienKhachDua.getText())) {
            JOptionPane.showMessageDialog(this, "Tiền Khách đưa không được để trống và phải là số");
            return;
        }
        if (cbc_khachHang.getSelectedIndex() != 0 && Utils.CheckData.checkNullString(txt_tenKhachHang.getText())) {
            JOptionPane.showMessageDialog(this, "Chưa nhập thông tin khách hàng");
            return;
        }
        System.out.println(_randomCode == -1);
        if (!Utils.CheckData.checkNullString(txt_tenKhachHang.getText()) && _randomCode != -1) {
            JOptionPane.showMessageDialog(this, "Bạn Chưa xác nhận khách hàng");
            return;
        }
        if (Integer.parseInt(txt_tienKhachDua.getText()) < Integer.parseInt(txt_thanhTien.getText())) {
            JOptionPane.showMessageDialog(this, "Tiền Khách đưa không đủ");
            return;
        }
        JOptionPane.showMessageDialog(this, "đã qua");
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        try {
            HoaDonModel hoaDonModel = new HoaDonModel(Integer.parseInt(tbl_taoHoaDon.getModel().getValueAt(indexHoaDOn, 1).toString()), dateFormat.parse(tbl_taoHoaDon.getModel().getValueAt(indexHoaDOn, 2).toString()), 3, Auth.user, _khHangModel, _lstKhuyenMai.get(cbc_khuyenMai.getSelectedIndex()));
            _HoaDonService.sua(hoaDonModel);
            _lstHoaDonCho.remove(indexHoaDOn);
            loadtableHoaThanhCong(_HoaDonService.getLstToDay(new java.util.Date()));
            loadtableHoaDonCho(_lstHoaDonCho);
            loadtableSanPhamDaChon(_HoaDonCTService.getListFromDB(-1));
            txt_tienKhachDua.setText("0");
        } catch (ParseException ex) {
            Logger.getLogger(FarmeQLBanHang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_thanhtoanActionPerformed

    private void btn_taoHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_taoHoaDonActionPerformed
        _lstHoaDonCho.add(_HoaDonService.them(getNewHoaDonModel()));
        loadtableHoaDonCho(_lstHoaDonCho);
    }//GEN-LAST:event_btn_taoHoaDonActionPerformed

    private void tbl_sanPhamMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_sanPhamMouseReleased
        int indexHdCho = tbl_taoHoaDon.getSelectedRow();
        int indexSp = tbl_sanPham.getSelectedRow();
        if (indexHdCho < 0) {
            JOptionPane.showMessageDialog(this, "Không tìm thấy hóa đơn muốn thêm sản phẩm");
            return;
        }

        if (Integer.parseInt(tbl_sanPham.getValueAt(indexSp, 8).toString()) <= 0) {//check số lượng sản phẩm
            JOptionPane.showMessageDialog(this, "Sản Phẩm đã hết");
            return;
        }
        _ISanPhamService.suaSoLuongSP(tbl_sanPham.getValueAt(indexSp, 1).toString(), Integer.parseInt(tbl_sanPham.getValueAt(indexSp, 8).toString()) - 1);//update so luong san pham

        HoaDonChiTietModel hdct = new HoaDonChiTietModel(0, 1, Integer.parseInt(tbl_sanPham.getValueAt(indexSp, 9).toString()), getSp(), getHoaDonCho());//tạo hóa đơn chi tiết
        _HoaDonCTService.them(hdct);//thêm hóa đơn chi tiết vào bd

        loadtableSanPhamDaChon(_HoaDonCTService.getListFromDB(hdct.getHoaDonModel().getMaHoaDon()));//load sản phẩm đã chọn
        loadtableSanPham(_ISanPhamService.getlistsanpham());//load lại số lượng sản phẩm
        tongTien();
    }//GEN-LAST:event_tbl_sanPhamMouseReleased

    private void tbl_taoHoaDonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_taoHoaDonMouseReleased
        int indexHdCho = tbl_taoHoaDon.getSelectedRow();
        loadtableSanPhamDaChon(_HoaDonCTService.getListFromDB(Integer.parseInt(tbl_taoHoaDon.getModel().getValueAt(indexHdCho, 1).toString())));
        tongTien();
        txt_xacnhanma.setText("");
    }//GEN-LAST:event_tbl_taoHoaDonMouseReleased

    private void tbl_sanPhamDaChonKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbl_sanPhamDaChonKeyReleased
        int indexSp = tbl_sanPhamDaChon.getSelectedRow();
        int indexHdCho = tbl_taoHoaDon.getSelectedRow();
        System.out.println(tbl_sanPhamDaChon.getModel().getValueAt(indexSp, 8));
        if (Utils.CheckData.checkNullString(tbl_sanPhamDaChon.getModel().getValueAt(indexSp, 8).toString())
                || !Utils.CheckData.checkso(tbl_sanPhamDaChon.getModel().getValueAt(indexSp, 8).toString())) {
            tbl_sanPhamDaChon.getModel().setValueAt(_soluongcu, indexSp, 8);
            JOptionPane.showMessageDialog(this, "Số lượng phải là số và không được để trống");
            return;
        }
        HoaDonChiTietModel hdct = null;
        for (SanPhamModel x : _ISanPhamService.getlistsanpham()) {
            if (x.getMaSanPham().equals(tbl_sanPhamDaChon.getModel().getValueAt(indexSp, 1).toString())) {
                if (x.getSoLuong() < Integer.parseInt(tbl_sanPhamDaChon.getModel().getValueAt(indexSp, 8).toString())) {
                    JOptionPane.showMessageDialog(this, "Số Lượng của sản phẩm chỉ còn :" + x.getSoLuong());
                    tbl_sanPhamDaChon.getModel().setValueAt(_soluongcu, indexSp, 8);
                    return;
                }
                if (x.getSoLuong() <= 0) {
                    JOptionPane.showMessageDialog(this, "Sản phẩm đã hết hàng");
                    tbl_sanPhamDaChon.getModel().setValueAt(_soluongcu, indexSp, 8);
                    return;
                }
                _ISanPhamService.suaSoLuongSP(tbl_sanPhamDaChon.getValueAt(indexSp, 1).toString(), (x.getSoLuong() + _soluongcu) - Integer.parseInt(tbl_sanPhamDaChon.getModel().getValueAt(indexSp, 8).toString()));//update so luong san pham
                hdct = new HoaDonChiTietModel(Integer.parseInt(tbl_taoHoaDon.getModel().getValueAt(indexHdCho, 1).toString()), Integer.parseInt(tbl_sanPhamDaChon.getModel().getValueAt(indexSp, 8).toString()), 0, x, getHoaDonCho());
            }
        }
        _HoaDonCTService.sua(hdct);
        loadtableSanPhamDaChon(_HoaDonCTService.getListFromDB(hdct.getHoaDonModel().getMaHoaDon()));//load sản phẩm đã chọn
        loadtableSanPham(_ISanPhamService.getlistsanpham());//load lại số lượng sản phẩm
        _soluongcu = 0;
        tongTien();
    }//GEN-LAST:event_tbl_sanPhamDaChonKeyReleased

    private void tbl_sanPhamDaChonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_sanPhamDaChonMouseReleased
        int indexSp = tbl_sanPhamDaChon.getSelectedRow();
        _soluongcu = Integer.parseInt(tbl_sanPhamDaChon.getModel().getValueAt(indexSp, 8).toString());
        tongTien();
    }//GEN-LAST:event_tbl_sanPhamDaChonMouseReleased

    private void cbc_khachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbc_khachHangActionPerformed
        _randomCode = -1;
        checkLoaiKhachHang();
        txt_xacnhanma.setText("");
    }//GEN-LAST:event_cbc_khachHangActionPerformed

    private void btn_xacnhanMaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xacnhanMaActionPerformed

        if (Utils.CheckData.checkNullString(txt_xacnhanma.getText()) || !Utils.CheckData.checkso(txt_xacnhanma.getText())) {
            JOptionPane.showMessageDialog(this, "Mã Xác Nhận phải là số và không được để trống");
        }
        if (!(Integer.parseInt(txt_xacnhanma.getText()) == _randomCode)) {
            JOptionPane.showMessageDialog(this, "Mã Xác Nhận Không đúng");
            return;
        }
        txt_diemTichMuaHang.setText(String.valueOf(_khHangModel.getDiem()));
        tongTien();
        _randomCode = -1;
        txt_xacnhanma.setText("");
    }//GEN-LAST:event_btn_xacnhanMaActionPerformed

    private void btn_guimaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guimaActionPerformed
        btn_xacnhanMa.setEnabled(true);
        txt_xacnhanma.setEnabled(true);
//        sendemail(_khHangModel.getEmail());
    }//GEN-LAST:event_btn_guimaActionPerformed

    private void txt_soDienThoaiCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txt_soDienThoaiCaretUpdate
        for (KhachHangModel x : _IManagerKhachHangService.getAllKhachHang()) {
            if (x.getSoDienThoai().equals(txt_soDienThoai.getText())) {
                txt_tenKhachHang.setText(x.getHoTen());
                _khHangModel = x;
                _randomCode = 0;
            }
        }
    }//GEN-LAST:event_txt_soDienThoaiCaretUpdate

    private void cbc_khuyenMaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbc_khuyenMaiActionPerformed
        tongTien();
    }//GEN-LAST:event_cbc_khuyenMaiActionPerformed

    private void txt_tienKhachDuaCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txt_tienKhachDuaCaretUpdate
        if (Utils.CheckData.checkNullString(txt_tienKhachDua.getText())) {
            return;
        }
        if (!Utils.CheckData.checkso(txt_tienKhachDua.getText())) {
            JOptionPane.showMessageDialog(this, "Tiền Khách đưa phải là số");
            return;
        }
        int tienthua = Integer.parseInt(txt_tienKhachDua.getText()) - Integer.parseInt(txt_thanhTien.getText());
        txt_tienThua.setText(String.valueOf(tienthua));
    }//GEN-LAST:event_txt_tienKhachDuaCaretUpdate

    private void rdb_dungdiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdb_dungdiemActionPerformed
        tongTien();
    }//GEN-LAST:event_rdb_dungdiemActionPerformed

    private void rdb_khongdungdiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdb_khongdungdiemActionPerformed
        tongTien();
    }//GEN-LAST:event_rdb_khongdungdiemActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FarmeQLBanHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FarmeQLBanHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FarmeQLBanHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FarmeQLBanHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FarmeQLBanHang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_guima;
    private javax.swing.JButton btn_huy;
    private javax.swing.JButton btn_huyHoaDon;
    private javax.swing.JButton btn_inhoadon;
    private javax.swing.JButton btn_taoHoaDon;
    private javax.swing.JButton btn_thanhtoan;
    private javax.swing.JButton btn_xacnhanMa;
    private javax.swing.JButton btn_xoaSanPham;
    private javax.swing.JComboBox<String> cbc_khachHang;
    private javax.swing.JComboBox<String> cbc_khuyenMai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JRadioButton rdb_dungdiem;
    private javax.swing.JRadioButton rdb_khongdungdiem;
    private javax.swing.JTable tbl_hoaDonThanhCong;
    private javax.swing.JTable tbl_sanPham;
    private javax.swing.JTable tbl_sanPhamDaChon;
    private javax.swing.JTable tbl_taoHoaDon;
    private javax.swing.JTextField txt_diemTichMuaHang;
    private javax.swing.JTextField txt_soDienThoai;
    private javax.swing.JTextField txt_tenKhachHang;
    private javax.swing.JTextField txt_thanhTien;
    private javax.swing.JTextField txt_tienKhachDua;
    private javax.swing.JTextField txt_tienThua;
    private javax.swing.JTextField txt_xacnhanma;
    // End of variables declaration//GEN-END:variables
}
