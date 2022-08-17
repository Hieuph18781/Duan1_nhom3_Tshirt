/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package JpanelForm;

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
import Utils.CheckData;
import Views.FarmeQLBanHang;
import java.text.DecimalFormat;
import java.text.NumberFormat;
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
 * @author dytc0
 */
public class QLBanHangPanel extends javax.swing.JPanel {

    ISanPhamService _ISanPhamService;
    IHoaDonService _HoaDonService;
    IHoaDonChiTietService _HoaDonCTService;
    IKhuyenMaiService _IKhuyenMaiService;
    IManagerKhachHangService _IManagerKhachHangService;
    List<HoaDonModel> _lstHoaDonCho;
    List<KhuyenMaiModel> _lstKhuyenMai;
    KhachHangModel _khHangModel;
    CheckData _checkDt;
    NumberFormat _formatter = new DecimalFormat("#,###");

    /**
     * Creates new form QLBanHangPanel
     */
    public QLBanHangPanel() {
        initComponents();
        _ISanPhamService = new SanPhamService();
        _HoaDonService = new HoaDonService();
        _lstHoaDonCho = new ArrayList<>();
        _IKhuyenMaiService = new KhuyenMaiService();
        _IManagerKhachHangService = new ManagerKhachHangServicr();
        _HoaDonCTService = new HoaDonChiTietService();
        _lstKhuyenMai = new ArrayList<>();
        _checkDt = new CheckData();
        _khHangModel = _IManagerKhachHangService.getAllKhachHang().get(0);
        cbcKhuyenMai();
        cbcLoaiKhachHang();
        loadtableSanPham(_ISanPhamService.getlistsanpham());
        loadtableHoaThanhCong(_HoaDonService.getLstToDay(new java.util.Date()));
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
        Long tongtien = 0L;
        for (int i = 0; i < soluongSanPhamDachon; i++) {
            tongtien = tongtien + Integer.parseInt(tbl_sanPhamDaChon.getModel().getValueAt(i, 9).toString());
        }
        String khuyemai1 = String.valueOf(tongtien * (_lstKhuyenMai.get(cbc_khuyenMai.getSelectedIndex()).getGiaKhuyenMai() / 100D));
        String khuyemai2 = khuyemai1.replace(".", "");
        String khuyemai = khuyemai2.substring(0, khuyemai2.length() - 1);

        tongtien = tongtien - Long.parseLong(String.valueOf(khuyemai));
        Long tong = (Long) tongtien;
        txt_thanhTien.setText(String.valueOf(_formatter.format(tong)));
        if (Utils.CheckData.checkNullString(txt_tienKhachDua.getText().replaceAll(",", ""))) {
            return false;
        }
        if (!Utils.CheckData.checkso(txt_tienKhachDua.getText())) {
            return true;
        }
        if (txt_thanhTien.getText().isBlank()) {
            return false;
        }
        Long tienthua = Long.parseLong(txt_tienKhachDua.getText().replaceAll(",", "")) - Integer.parseInt(txt_thanhTien.getText().replaceAll(",", ""));
        txt_tienThua.setText(String.valueOf(_formatter.format(tienthua)));
        return false;
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
            txt_soDienThoai.setEnabled(false);
            txt_tenKhachHang.setEnabled(false);
            txt_thanhTien.setEnabled(false);
            txt_tienThua.setEnabled(false);
            _khHangModel = new KhachHangModel();
            _khHangModel.setMaKhachHang(1);
        }
        if (!cbc_khachHang.getSelectedItem().equals("Khách Lẻ")) {
            txt_soDienThoai.setEnabled(true);
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

//    public void loadtableHoaDonCho(List<HoaDonModel> lstHoaDonModels) {
//        DefaultTableModel _DefaultTableModel = new DefaultTableModel();
//        _DefaultTableModel = (DefaultTableModel) tbl_taoHoaDon.getModel();
//        _DefaultTableModel.setRowCount(0);
//        int stt = 1;
//        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
//        for (HoaDonModel x : lstHoaDonModels) {
//            _DefaultTableModel.addRow(new Object[]{stt++, x.getMaHoaDon(), dateFormat.format(x.getThoiGianTao()),
//                x.getNhanvien().getHoTen(),
//                x.getTrangThai() == 0 ? "Đang Chờ" : "Đã Hủy"
//            });
//        }
//    }
    public void loadtableHoaThanhCong(List<HoaDonModel> lstHoaDonModels) {
        DefaultTableModel _DefaultTableModel = new DefaultTableModel();
        _DefaultTableModel = (DefaultTableModel) tbl_taoHoaDon.getModel();
        _DefaultTableModel.setRowCount(0);
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        int stt = 1;
        for (HoaDonModel x : lstHoaDonModels) {
            if (x.getTrangThai() == 0) {
                _lstHoaDonCho.add(x);
                _DefaultTableModel.addRow(new Object[]{stt++, x.getMaHoaDon(), dateFormat.format(x.getThoiGianTao()),
                    x.getNhanvien().getHoTen(),
                    x.getTrangThai() == 0 ? "Đang Chờ" : "Đã Hủy"
                });
            }
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

        pmv_sanPham = new javax.swing.JPopupMenu();
        mni_themSanPham = new javax.swing.JMenuItem();
        pmv_sanPhamDaChon = new javax.swing.JPopupMenu();
        mni_thayDoiSoLuong = new javax.swing.JMenuItem();
        mni_xoaSanPham = new javax.swing.JMenuItem();
        jPanel5 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        txt_timKiem = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_sanPham = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        rdb_theoMa = new javax.swing.JRadioButton();
        rdb_theoTen = new javax.swing.JRadioButton();
        rdb_theoSize = new javax.swing.JRadioButton();
        rdb_theoMau = new javax.swing.JRadioButton();
        rdb_theoDanMucSp = new javax.swing.JRadioButton();
        rdb_theoChatLieu = new javax.swing.JRadioButton();
        rdb_theoKieuDang = new javax.swing.JRadioButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_sanPhamDaChon = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        btn_taoHoaDon = new javax.swing.JButton();
        btn_huyHoaDon = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbl_taoHoaDon = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btn_thanhtoan = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txt_tienKhachDua = new javax.swing.JTextField();
        txt_soDienThoai = new javax.swing.JTextField();
        txt_thanhTien = new javax.swing.JTextField();
        txt_tienThua = new javax.swing.JTextField();
        cbc_khuyenMai = new javax.swing.JComboBox<>();
        cbc_khachHang = new javax.swing.JComboBox<>();
        txt_tenKhachHang = new javax.swing.JTextField();

        mni_themSanPham.setText("Thêm Sản Phẩm");
        mni_themSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mni_themSanPhamActionPerformed(evt);
            }
        });
        pmv_sanPham.add(mni_themSanPham);

        mni_thayDoiSoLuong.setText("Thay Đổi Số Lượng Sản Phẩm");
        mni_thayDoiSoLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mni_thayDoiSoLuongActionPerformed(evt);
            }
        });
        pmv_sanPhamDaChon.add(mni_thayDoiSoLuong);

        mni_xoaSanPham.setText("Xóa Sản Phẩm");
        mni_xoaSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mni_xoaSanPhamActionPerformed(evt);
            }
        });
        pmv_sanPhamDaChon.add(mni_xoaSanPham);

        jPanel5.setBackground(new java.awt.Color(204, 255, 255));

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách sản phẩm", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        txt_timKiem.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txt_timKiemCaretUpdate(evt);
            }
        });

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
        tbl_sanPham.setComponentPopupMenu(pmv_sanPham);
        tbl_sanPham.setInheritsPopupMenu(true);
        jScrollPane1.setViewportView(tbl_sanPham);

        jLabel1.setText("Tìm Kiếm :");

        rdb_theoMa.setText("Theo Mã");
        rdb_theoMa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdb_theoMaActionPerformed(evt);
            }
        });

        rdb_theoTen.setText("Theo Tên");
        rdb_theoTen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdb_theoTenActionPerformed(evt);
            }
        });

        rdb_theoSize.setText("Theo Size");
        rdb_theoSize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdb_theoSizeActionPerformed(evt);
            }
        });

        rdb_theoMau.setText("Theo Màu");
        rdb_theoMau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdb_theoMauActionPerformed(evt);
            }
        });

        rdb_theoDanMucSp.setText("Theo Danh Mục Sản phẩm");
        rdb_theoDanMucSp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdb_theoDanMucSpActionPerformed(evt);
            }
        });

        rdb_theoChatLieu.setText("Theo Chất Liệu");
        rdb_theoChatLieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdb_theoChatLieuActionPerformed(evt);
            }
        });

        rdb_theoKieuDang.setText("Theo Kiểu Dáng");
        rdb_theoKieuDang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdb_theoKieuDangActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1053, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_timKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(rdb_theoMa)
                        .addGap(18, 18, 18)
                        .addComponent(rdb_theoTen)
                        .addGap(18, 18, 18)
                        .addComponent(rdb_theoSize)
                        .addGap(18, 18, 18)
                        .addComponent(rdb_theoMau)
                        .addGap(18, 18, 18)
                        .addComponent(rdb_theoDanMucSp)
                        .addGap(18, 18, 18)
                        .addComponent(rdb_theoChatLieu)
                        .addGap(18, 18, 18)
                        .addComponent(rdb_theoKieuDang)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_timKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(rdb_theoMa)
                    .addComponent(rdb_theoTen)
                    .addComponent(rdb_theoSize)
                    .addComponent(rdb_theoMau)
                    .addComponent(rdb_theoDanMucSp)
                    .addComponent(rdb_theoChatLieu)
                    .addComponent(rdb_theoKieuDang))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE))
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
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_sanPhamDaChon.setComponentPopupMenu(pmv_sanPhamDaChon);
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

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_huyHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                    .addComponent(btn_taoHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(btn_taoHoaDon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_huyHoaDon)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                false, false, false, false, false
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

        btn_thanhtoan.setText("Thanh toán");
        btn_thanhtoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_thanhtoanActionPerformed(evt);
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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txt_soDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 24, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txt_tienKhachDua, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbc_khuyenMai, 0, 136, Short.MAX_VALUE)
                            .addComponent(cbc_khachHang, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_tenKhachHang, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_thanhTien, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_tienThua, javax.swing.GroupLayout.Alignment.LEADING))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(111, 111, 111)
                .addComponent(btn_thanhtoan)
                .addGap(0, 0, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txt_thanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_tienThua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addComponent(btn_thanhtoan)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(0, 2, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41)))
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tbl_taoHoaDonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_taoHoaDonMouseReleased
        int indexHdCho = tbl_taoHoaDon.getSelectedRow();
        loadtableSanPhamDaChon(_HoaDonCTService.getListFromDB(Integer.parseInt(tbl_taoHoaDon.getModel().getValueAt(indexHdCho, 1).toString())));
        Long temp = 0L;
        txt_tienKhachDua.setText(String.valueOf(temp));
        System.out.println(String.valueOf(temp));
        cbc_khachHang.setSelectedIndex(0);
        tongTien();
    }//GEN-LAST:event_tbl_taoHoaDonMouseReleased

    private void mni_themSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mni_themSanPhamActionPerformed
        int indexHdCho = tbl_taoHoaDon.getSelectedRow();
        int indexSp = tbl_sanPham.getSelectedRow();
        if (indexSp < 0) {
            JOptionPane.showMessageDialog(this, "Vui Lòng chọn sản phẩm cần thêm");
            return;
        }
        if (indexHdCho < 0) {
            JOptionPane.showMessageDialog(this, "Không tìm thấy hóa đơn muốn thêm sản phẩm");
            return;
        }
        for (HoaDonChiTietModel x : _HoaDonCTService.getListFromDB(Integer.parseInt(tbl_taoHoaDon.getModel().getValueAt(indexHdCho, 1).toString()))) {
            if (x.getSanPhamModel().getMaSanPham().equals(tbl_sanPham.getModel().getValueAt(indexSp, 1))) {
                JOptionPane.showMessageDialog(this, "Sản phẩm đã được chọn");
                return;
            }
        }

        String temp = JOptionPane.showInputDialog(this, "Nhập Số Lượng Muốn Thêm");
        if (temp == null) {
            return;
        }
        if (temp.isBlank()) {
            JOptionPane.showMessageDialog(this, "Không được để trống");
            return;
        }
        if (_checkDt.chekcKhoangTrang(temp)) {
            JOptionPane.showMessageDialog(this, "Không được để khoảng trắng");
            return;
        }
        if (temp.length() > 6) {
            JOptionPane.showMessageDialog(this, "Nhập tối đa 5 kí tự số");
            return;
        }
        if (!_checkDt.checkso(temp)) {
            JOptionPane.showMessageDialog(this, "Bạn Phải nhập số và phải > 0 , không chứa kí tự");
            return;
        }
        if (Long.parseLong(temp) > 99999) {
            JOptionPane.showMessageDialog(this, "số lượng tối đa có thể nhập là là 99 999");
            return;
        }

        if (Integer.parseInt(tbl_sanPham.getModel().getValueAt(indexSp, 8).toString()) < Long.parseLong(temp)) {
            JOptionPane.showMessageDialog(this, "Số Lượng của sản phẩm chỉ còn :" + tbl_sanPham.getModel().getValueAt(indexSp, 8).toString());
            return;
        }//check số lượng muốn thêm và số lượng còn
        HoaDonChiTietModel hdct = null;
        for (SanPhamModel x : _ISanPhamService.getlistsanpham()) {
            if (x.getMaSanPham().equals(tbl_sanPham.getModel().getValueAt(indexSp, 1).toString())) {
                if (x.getSoLuong() <= 0) {
                    JOptionPane.showMessageDialog(this, "Sản phẩm đã hết");
                    return;
                }
                _ISanPhamService.suaSoLuongSP(tbl_sanPham.getValueAt(indexSp, 1).toString(), x.getSoLuong() - Integer.parseInt(temp));//update so luong san pham
                hdct = new HoaDonChiTietModel(Integer.parseInt(tbl_taoHoaDon.getModel().getValueAt(indexHdCho, 1).toString()), Integer.parseInt(temp), Integer.parseInt(tbl_sanPham.getValueAt(indexSp, 9).toString()), x, getHoaDonCho());

            }
        }
        _HoaDonCTService.them(hdct);//thêm hóa đơn chi tiết vào bd
        loadtableSanPhamDaChon(_HoaDonCTService.getListFromDB(hdct.getHoaDonModel().getMaHoaDon()));//load sản phẩm đã chọn
        loadtableSanPham(_ISanPhamService.getlistsanpham());//load lại số lượng sản phẩm
        tongTien();
    }//GEN-LAST:event_mni_themSanPhamActionPerformed

    private void mni_xoaSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mni_xoaSanPhamActionPerformed
        int indexSp = tbl_sanPhamDaChon.getSelectedRow();
        if (checkIndexTable(indexSp)) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn sản phẩm cần xóa");
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
    }//GEN-LAST:event_mni_xoaSanPhamActionPerformed

    private void mni_thayDoiSoLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mni_thayDoiSoLuongActionPerformed
        int indexSp = tbl_sanPhamDaChon.getSelectedRow();
        int indexHdCho = tbl_taoHoaDon.getSelectedRow();
        if (indexSp < 0) {
            JOptionPane.showMessageDialog(this, "Vui Lòng chọn sản phẩm cần thay đổi số lượng");
            return;
        }
        if (indexHdCho < 0) {
            JOptionPane.showMessageDialog(this, "Không tìm thấy hóa đơn muốn thay đổi số lượng sản phẩm");
            return;
        }
        String temp = JOptionPane.showInputDialog(this, "Nhập Số Lượng Muốn thay đổi");
        if (temp == null) {
            return;
        }
        if (temp.isBlank()) {
            JOptionPane.showMessageDialog(this, "Không được để trống");
            return;
        }
        if (_checkDt.chekcKhoangTrang(temp)) {
            JOptionPane.showMessageDialog(this, "Không được để khoảng trắng");
            return;
        }
        if (temp.length() > 6) {
            JOptionPane.showMessageDialog(this, "Nhập tối đa 5 kí tự số");
            return;
        }
        if (!_checkDt.checkso(temp) || Integer.parseInt(temp) <= 0) {
            JOptionPane.showMessageDialog(this, "Bạn Phải nhập số và phải > 0 , không chứa kí tự");
            return;
        }
        if (Long.parseLong(temp) > 99999) {
            JOptionPane.showMessageDialog(this, "số lượng tối đa có thể nhập là là 99,999");
            return;
        }

        HoaDonChiTietModel hdct = null;
        for (SanPhamModel x : _ISanPhamService.getlistsanpham()) {
            if (x.getMaSanPham().equals(tbl_sanPhamDaChon.getModel().getValueAt(indexSp, 1).toString())) {
                if ((x.getSoLuong() + Integer.parseInt((tbl_sanPhamDaChon.getValueAt(indexSp, 8).toString()))) < Integer.parseInt(temp)) {
                    JOptionPane.showMessageDialog(this, "Số Lượng của sản phẩm chỉ còn :" + (x.getSoLuong() + Integer.parseInt((tbl_sanPhamDaChon.getValueAt(indexSp, 8).toString()))));
                    return;
                }
                _ISanPhamService.suaSoLuongSP(tbl_sanPhamDaChon.getValueAt(indexSp, 1).toString(),
                        (x.getSoLuong() + Integer.parseInt((tbl_sanPhamDaChon.getValueAt(indexSp, 8).toString()))) - Integer.parseInt(temp));//update so luong san pham
                hdct = new HoaDonChiTietModel(Integer.parseInt(tbl_taoHoaDon.getModel().getValueAt(indexHdCho, 1).toString()), Integer.parseInt(temp), 0, x, getHoaDonCho());
            }
        }
        _HoaDonCTService.sua(hdct);
        loadtableSanPhamDaChon(_HoaDonCTService.getListFromDB(hdct.getHoaDonModel().getMaHoaDon()));//load sản phẩm đã chọn
        loadtableSanPham(_ISanPhamService.getlistsanpham());//load lại số lượng sản phẩm
        tongTien();
    }//GEN-LAST:event_mni_thayDoiSoLuongActionPerformed

    private void btn_huyHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_huyHoaDonActionPerformed
        try {
            int indexHdCho = tbl_taoHoaDon.getSelectedRow();
            if (checkIndexTable(indexHdCho)) {
                JOptionPane.showMessageDialog(this, "Không tìm thấy Hóa đơn muốn hủy");
                return;
            }
            int temp = JOptionPane.showConfirmDialog(this, "Bạn có chắc muồn hủy hóa đơn có mã : " + tbl_taoHoaDon.getModel().getValueAt(indexHdCho, 1).toString());
            if (temp != 0) {
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
            // xử lý Hóa đơn chi tiết
            for (int i = 0; i < tbl_sanPhamDaChon.getRowCount(); i++) {
                for (SanPhamModel x : _ISanPhamService.getlistsanpham()) {
                    if (x.getMaSanPham().equals(tbl_sanPhamDaChon.getModel().getValueAt(i, 1).toString())) {
                        _ISanPhamService.suaSoLuongSP(tbl_sanPhamDaChon.getValueAt(i, 1).toString(), x.getSoLuong() + Integer.parseInt(tbl_sanPhamDaChon.getModel().getValueAt(i, 8).toString()));//update so luong san pham
                        HoaDonChiTietModel hdct = new HoaDonChiTietModel(0, Integer.parseInt(tbl_sanPhamDaChon.getModel().getValueAt(i, 8).toString()), 0, x, getHoaDonCho());
                        _HoaDonCTService.xoa(hdct);
                    }
                }
            }
            loadtableHoaThanhCong(_HoaDonService.getLstToDay(new java.util.Date()));
//            loadtableHoaDonCho(_lstHoaDonCho);
            loadtableSanPhamDaChon(_HoaDonCTService.getListFromDB(-1));
            loadtableSanPham(_ISanPhamService.getlistsanpham());
            loadtableHoaThanhCong(_HoaDonService.getLstToDay(new java.util.Date()));
            cbc_khachHang.setSelectedIndex(0);
            txt_thanhTien.setText("0");
            txt_tienKhachDua.setText("0");
            txt_tienThua.setText("0");
        } catch (ParseException ex) {
            Logger.getLogger(QLBanHangPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_huyHoaDonActionPerformed

    private void btn_taoHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_taoHoaDonActionPerformed
        _HoaDonService.them(getNewHoaDonModel());
        txt_tienKhachDua.setText("0");
        txt_thanhTien.setText("0");
        cbc_khachHang.setSelectedIndex(0);
        tongTien();
        loadtableHoaThanhCong(_HoaDonService.getLstToDay(new java.util.Date()));
    }//GEN-LAST:event_btn_taoHoaDonActionPerformed

    private void btn_thanhtoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_thanhtoanActionPerformed
        int indexHoaDOn = tbl_taoHoaDon.getSelectedRow();
        if (indexHoaDOn < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn hóa đơn cần thanh toán");
            return;
        }
        if (tbl_sanPhamDaChon.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "Hóa Đơn chưa có sản phẩm nào");
            return;
        }
        int temp = JOptionPane.showConfirmDialog(this, "Bạn có chắc muồn Thanh Toán hóa đơn có mã : " + tbl_taoHoaDon.getModel().getValueAt(indexHoaDOn, 1).toString());
        if (temp != 0) {
            return;
        }
        if (Utils.CheckData.chekcKhoangTrang2(txt_tienKhachDua.getText())) {
            JOptionPane.showMessageDialog(this, "Tiền khách đưa không được nhập khoảng trắng");
            return;
        }
        if (tongTien() == true) {
            JOptionPane.showMessageDialog(this, "Tiền Khách đưa phải là số");
            return;
        }

        if (Utils.CheckData.checkNullString(txt_tienKhachDua.getText()) && !Utils.CheckData.checkso(txt_tienKhachDua.getText())) {
            JOptionPane.showMessageDialog(this, "Tiền Khách đưa không được để trống và phải là số");
            return;
        }
        if (!Utils.CheckData.checkso(txt_tienKhachDua.getText())) {
            JOptionPane.showMessageDialog(this, "Tiền Khách đưa phải là số");
            return;
        }
        if (cbc_khachHang.getSelectedIndex() != 0 && Utils.CheckData.checkNullString(txt_tenKhachHang.getText())) {
            JOptionPane.showMessageDialog(this, "Chưa nhập thông tin khách hàng");
            return;
        }
        if (Integer.parseInt(txt_tienKhachDua.getText()) < Integer.parseInt(txt_thanhTien.getText().replaceAll(",", ""))) {
            JOptionPane.showMessageDialog(this, "Tiền Khách đưa không đủ");
            return;
        }

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        try {
            HoaDonModel hoaDonModel = new HoaDonModel(Integer.parseInt(tbl_taoHoaDon.getModel().getValueAt(indexHoaDOn, 1).toString()), dateFormat.parse(tbl_taoHoaDon.getModel().getValueAt(indexHoaDOn, 2).toString()), 2, Auth.user, _khHangModel, _lstKhuyenMai.get(cbc_khuyenMai.getSelectedIndex()));
            _HoaDonService.sua(hoaDonModel);
            _lstHoaDonCho.remove(indexHoaDOn);
            loadtableHoaThanhCong(_HoaDonService.getLstToDay(new java.util.Date()));
            loadtableSanPhamDaChon(_HoaDonCTService.getListFromDB(-1));
            txt_tienKhachDua.setText("0");
            txt_tienThua.setText("0");
            cbc_khachHang.setSelectedIndex(0);
            tongTien();
        } catch (ParseException ex) {
            Logger.getLogger(FarmeQLBanHang.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(this, "Thanh Cong");
    }//GEN-LAST:event_btn_thanhtoanActionPerformed

    private void txt_tienKhachDuaCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txt_tienKhachDuaCaretUpdate
        if (Utils.CheckData.checkNullString(txt_tienKhachDua.getText())) {
            return;
        }
        if (Utils.CheckData.chekcKhoangTrang2(txt_tienKhachDua.getText())) {
            JOptionPane.showMessageDialog(this, "Không được nhập khoảng trắng");
            return;
        }
        if (!Utils.CheckData.checkso(txt_tienKhachDua.getText())) {
            JOptionPane.showMessageDialog(this, "Tiền Khách đưa phải là số");
            return;
        }
        if (txt_tienKhachDua.getText().length() > 10) {
            JOptionPane.showMessageDialog(this, "Không được nhập quá 10 số");
            return;
        }
        if (txt_thanhTien.getText().isBlank()) {
            return;
        }
        Long tienthua = Long.parseLong(txt_tienKhachDua.getText().replaceAll(",", "")) - Integer.parseInt(txt_thanhTien.getText().replaceAll(",", ""));
        txt_tienThua.setText(String.valueOf(_formatter.format(tienthua)));
    }//GEN-LAST:event_txt_tienKhachDuaCaretUpdate

    private void txt_soDienThoaiCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txt_soDienThoaiCaretUpdate
        for (KhachHangModel x : _IManagerKhachHangService.getAllKhachHang()) {
            if (x.getSoDienThoai().equals(txt_soDienThoai.getText())) {
                txt_tenKhachHang.setText(x.getHoTen());
                _khHangModel = x;
                System.out.println(_khHangModel.getMaKhachHang());
                return;
            }
        }
        txt_tenKhachHang.setText("");
        _khHangModel = null;
    }//GEN-LAST:event_txt_soDienThoaiCaretUpdate

    private void cbc_khuyenMaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbc_khuyenMaiActionPerformed
        tongTien();
    }//GEN-LAST:event_cbc_khuyenMaiActionPerformed

    private void cbc_khachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbc_khachHangActionPerformed
        checkLoaiKhachHang();
    }//GEN-LAST:event_cbc_khachHangActionPerformed

    private void txt_timKiemCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txt_timKiemCaretUpdate
        if (txt_timKiem.getText().isBlank()) {
            loadtableSanPham(_ISanPhamService.getlistsanpham());
            return;
        }

        List<SanPhamModel> lstTemp = new ArrayList<>();
        if (rdb_theoMa.isSelected()) {
            for (SanPhamModel x : _ISanPhamService.getlistsanpham()) {
                if (_ISanPhamService.Timkiem(x.getMaSanPham(), txt_timKiem.getText())) {
                    lstTemp.add(x);
                }
            }
        }
        if (rdb_theoTen.isSelected()) {
            for (SanPhamModel x : _ISanPhamService.getlistsanpham()) {
                if (_ISanPhamService.Timkiem(x.getTenSanPham(), txt_timKiem.getText())) {
                    lstTemp.add(x);
                }
            }
        }
        if (rdb_theoSize.isSelected()) {
            for (SanPhamModel x : _ISanPhamService.getlistsanpham()) {
                if (_ISanPhamService.Timkiem(x.getSizeModel().getTenSize(), txt_timKiem.getText())) {
                    lstTemp.add(x);
                }
            }
        }
        if (rdb_theoMau.isSelected()) {
            for (SanPhamModel x : _ISanPhamService.getlistsanpham()) {
                if (_ISanPhamService.Timkiem(x.getMausacModel().getTenMauSac(), txt_timKiem.getText())) {
                    lstTemp.add(x);
                }
            }
        }
        if (rdb_theoDanMucSp.isSelected()) {
            for (SanPhamModel x : _ISanPhamService.getlistsanpham()) {
                if (_ISanPhamService.Timkiem(x.getDanhMucSanPhamModel().getTenDanhMuc(), txt_timKiem.getText())) {
                    lstTemp.add(x);
                }
            }
        }
        if (rdb_theoChatLieu.isSelected()) {
            for (SanPhamModel x : _ISanPhamService.getlistsanpham()) {
                if (_ISanPhamService.Timkiem(x.getChatlieuModel().getTenChatLieu(), txt_timKiem.getText())) {
                    lstTemp.add(x);
                }
            }
        }
        if (rdb_theoKieuDang.isSelected()) {
            for (SanPhamModel x : _ISanPhamService.getlistsanpham()) {
                if (_ISanPhamService.Timkiem(x.getKieudangModel().getTenKieuDang(), txt_timKiem.getText())) {
                    lstTemp.add(x);
                }
            }
        }

        loadtableSanPham(lstTemp);
    }//GEN-LAST:event_txt_timKiemCaretUpdate

    private void rdb_theoMaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdb_theoMaActionPerformed
        if (txt_timKiem.getText().isBlank()) {
            loadtableSanPham(_ISanPhamService.getlistsanpham());
            return;
        }
        List<SanPhamModel> lstTemp = new ArrayList<>();
        for (SanPhamModel x : _ISanPhamService.getlistsanpham()) {
            if (_ISanPhamService.Timkiem(x.getMaSanPham(), txt_timKiem.getText())) {
                lstTemp.add(x);
            }
        }
        loadtableSanPham(lstTemp);
    }//GEN-LAST:event_rdb_theoMaActionPerformed

    private void rdb_theoTenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdb_theoTenActionPerformed
        if (txt_timKiem.getText().isBlank()) {
            loadtableSanPham(_ISanPhamService.getlistsanpham());
            return;
        }
        List<SanPhamModel> lstTemp = new ArrayList<>();
        for (SanPhamModel x : _ISanPhamService.getlistsanpham()) {
            if (_ISanPhamService.Timkiem(x.getTenSanPham(), txt_timKiem.getText())) {
                lstTemp.add(x);
            }
        }
        loadtableSanPham(lstTemp);
    }//GEN-LAST:event_rdb_theoTenActionPerformed

    private void rdb_theoSizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdb_theoSizeActionPerformed
        if (txt_timKiem.getText().isBlank()) {
            loadtableSanPham(_ISanPhamService.getlistsanpham());
            return;
        }
        List<SanPhamModel> lstTemp = new ArrayList<>();
        for (SanPhamModel x : _ISanPhamService.getlistsanpham()) {
            if (_ISanPhamService.Timkiem(x.getSizeModel().getTenSize(), txt_timKiem.getText())) {
                lstTemp.add(x);
            }
        }
        loadtableSanPham(lstTemp);
    }//GEN-LAST:event_rdb_theoSizeActionPerformed

    private void rdb_theoMauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdb_theoMauActionPerformed
        if (txt_timKiem.getText().isBlank()) {
            loadtableSanPham(_ISanPhamService.getlistsanpham());
            return;
        }
        List<SanPhamModel> lstTemp = new ArrayList<>();
        for (SanPhamModel x : _ISanPhamService.getlistsanpham()) {
            if (_ISanPhamService.Timkiem(x.getMausacModel().getTenMauSac(), txt_timKiem.getText())) {
                lstTemp.add(x);
            }
        }
        loadtableSanPham(lstTemp);
    }//GEN-LAST:event_rdb_theoMauActionPerformed

    private void rdb_theoDanMucSpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdb_theoDanMucSpActionPerformed
        if (txt_timKiem.getText().isBlank()) {
            loadtableSanPham(_ISanPhamService.getlistsanpham());
            return;
        }
        List<SanPhamModel> lstTemp = new ArrayList<>();
        for (SanPhamModel x : _ISanPhamService.getlistsanpham()) {
            if (_ISanPhamService.Timkiem(x.getDanhMucSanPhamModel().getTenDanhMuc(), txt_timKiem.getText())) {
                lstTemp.add(x);
            }
        }
        loadtableSanPham(lstTemp);
    }//GEN-LAST:event_rdb_theoDanMucSpActionPerformed

    private void rdb_theoChatLieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdb_theoChatLieuActionPerformed
        if (txt_timKiem.getText().isBlank()) {
            loadtableSanPham(_ISanPhamService.getlistsanpham());
            return;
        }
        List<SanPhamModel> lstTemp = new ArrayList<>();
        for (SanPhamModel x : _ISanPhamService.getlistsanpham()) {
            if (_ISanPhamService.Timkiem(x.getChatlieuModel().getTenChatLieu(), txt_timKiem.getText())) {
                lstTemp.add(x);
            }
        }
        loadtableSanPham(lstTemp);
    }//GEN-LAST:event_rdb_theoChatLieuActionPerformed

    private void rdb_theoKieuDangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdb_theoKieuDangActionPerformed
        if (txt_timKiem.getText().isBlank()) {
            loadtableSanPham(_ISanPhamService.getlistsanpham());
            return;
        }
        List<SanPhamModel> lstTemp = new ArrayList<>();
        for (SanPhamModel x : _ISanPhamService.getlistsanpham()) {
            if (_ISanPhamService.Timkiem(x.getKieudangModel().getTenKieuDang(), txt_timKiem.getText())) {
                lstTemp.add(x);
            }
        }
        loadtableSanPham(lstTemp);
    }//GEN-LAST:event_rdb_theoKieuDangActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_huyHoaDon;
    private javax.swing.JButton btn_taoHoaDon;
    private javax.swing.JButton btn_thanhtoan;
    private javax.swing.JComboBox<String> cbc_khachHang;
    private javax.swing.JComboBox<String> cbc_khuyenMai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JMenuItem mni_thayDoiSoLuong;
    private javax.swing.JMenuItem mni_themSanPham;
    private javax.swing.JMenuItem mni_xoaSanPham;
    private javax.swing.JPopupMenu pmv_sanPham;
    private javax.swing.JPopupMenu pmv_sanPhamDaChon;
    private javax.swing.JRadioButton rdb_theoChatLieu;
    private javax.swing.JRadioButton rdb_theoDanMucSp;
    private javax.swing.JRadioButton rdb_theoKieuDang;
    private javax.swing.JRadioButton rdb_theoMa;
    private javax.swing.JRadioButton rdb_theoMau;
    private javax.swing.JRadioButton rdb_theoSize;
    private javax.swing.JRadioButton rdb_theoTen;
    private javax.swing.JTable tbl_sanPham;
    private javax.swing.JTable tbl_sanPhamDaChon;
    private javax.swing.JTable tbl_taoHoaDon;
    private javax.swing.JTextField txt_soDienThoai;
    private javax.swing.JTextField txt_tenKhachHang;
    private javax.swing.JTextField txt_thanhTien;
    private javax.swing.JTextField txt_tienKhachDua;
    private javax.swing.JTextField txt_tienThua;
    private javax.swing.JTextField txt_timKiem;
    // End of variables declaration//GEN-END:variables
}
