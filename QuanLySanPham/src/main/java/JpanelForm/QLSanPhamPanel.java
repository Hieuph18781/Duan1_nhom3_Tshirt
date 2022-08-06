/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package JpanelForm;

import DomainModels.ChatLieu;
import DomainModels.DanhMucSanPham;
import DomainModels.KieuDang;
import DomainModels.MauSac;
import DomainModels.Size;
import JdialogForm.QLChatLieuJDialog;
import JdialogForm.QLDanhMucSanPhamJDialog;
import JdialogForm.QLKieuDangJDialog;
import JdialogForm.QLMauSacJDialog;
import JdialogForm.QLSizeJDialog;
import Repositories.ChatLieuRepository;
import Repositories.IChatLieuRepository;
import Repositories.IMauSacRepository;
import Repositories.MauSacRepository;
import Services.DanhMucSanPhamService;
import Services.IDanhMucSanPhamService;
import Services.IKieuDangService;
import Services.IManageChatLieuService;
import Services.IManageSizeService;
import Services.IMauSacService;
import Services.ISanPhamService;
import Services.KieuDangService;
import Services.ManageChatLieuService;
import Services.ManageSizeService;
import Services.MauSacService;
import Services.SanPhamService;
import Utils.CheckData;
import ViewsModels.ChatLieuModel;
import ViewsModels.DanhMucSanPhamModel;
import ViewsModels.KieuDangModel;
import ViewsModels.MauSacModel;
import ViewsModels.SanPhamModel;
import ViewsModels.SizeModel;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author dytc0
 */
public class QLSanPhamPanel extends javax.swing.JPanel {

    ISanPhamService _ISanPhamService;
    IMauSacService _IMauSacService;
    IDanhMucSanPhamService _DanhMucSanPhamService;
    IManageChatLieuService _ChatLieuService;
    IManageSizeService _IManageSizeService;
    IKieuDangService _KieuDangService;
    DefaultTableModel _DefaultTableModel;
    CheckData _checkDt;

    /**
     * Creates new form QLSanPhamPanel
     */
    public QLSanPhamPanel() {
        initComponents();
        _ISanPhamService = new SanPhamService();
        _ChatLieuService = new ManageChatLieuService();
        _DanhMucSanPhamService = new DanhMucSanPhamService();
        _IManageSizeService = new ManageSizeService();
        _KieuDangService = new KieuDangService();
        _IMauSacService = new MauSacService();
        _checkDt = new CheckData();
        cbxmausac();
        cbxchatlieu();
        cbxdanhmuc();
        cbxkieudang();
        cbxsize();
        cbcTrangThai();
        setrdb();
        loadtable(_ISanPhamService.getlistsanpham());
        txt_maSanPham.setText(_ISanPhamService.getMaSanPham());
        txt_maSanPham.setEnabled(false);
    }

    void setrdb() {
        ButtonGroup btn = new ButtonGroup();
        btn.add(rdb_theoMa);
        btn.add(rdb_theoTen);
        btn.add(rdb_theoSize);
        btn.add(rdb_theoMau);
        btn.add(rdb_theoDanMucSp);
        btn.add(rdb_theoChatLieu);
        btn.add(rdb_theoKieuDang);
        rdb_theoTen.setSelected(true);
    }

    void cbcTrangThai() {
        DefaultComboBoxModel cbx = new DefaultComboBoxModel();
        cbx.addElement("Đang Bán");
        cbx.addElement("Ngưng Bán");
        cbc_trangThai.setModel(cbx);
    }

    public void cbxmausac() {
        DefaultComboBoxModel cbx = new DefaultComboBoxModel();
        for (MauSacModel x : _IMauSacService.getproduct()) {
            cbx.addElement(x.getTenMauSac());
        }
        cbc_mauSanPham.setModel(cbx);
    }

    public void cbxsize() {
        DefaultComboBoxModel cbx = new DefaultComboBoxModel();
        for (SizeModel x : _IManageSizeService.getfullize()) {
            cbx.addElement(x.getTenSize());
        }
        cbc_size.setModel(cbx);
    }

    public void cbxchatlieu() {
        DefaultComboBoxModel cbx = new DefaultComboBoxModel();
        for (ChatLieuModel x : _ChatLieuService.getProducts()) {
            cbx.addElement(x.getTenChatLieu());
        }
        cbc_chatLieu.setModel(cbx);
    }

    String gettenchatlieu(String ten) {
        for (ChatLieuModel x : _ChatLieuService.getProducts()) {
            if (x.getMaChatLieu() == Integer.parseInt(ten)) {
                return x.getTenChatLieu();
            }
        }
        return "";
    }

    public void cbxkieudang() {
        DefaultComboBoxModel cbx = new DefaultComboBoxModel();
        for (KieuDangModel x : _KieuDangService.getproduct()) {
            cbx.addElement(x.getTenKieuDang());
        }
        cbc_kieuDang.setModel(cbx);
    }

    public void cbxdanhmuc() {
        DefaultComboBoxModel cbx = new DefaultComboBoxModel();
        for (DanhMucSanPhamModel x : _DanhMucSanPhamService.getListFromDB()) {
            cbx.addElement(x.getTenDanhMuc());
        }
        cbc_danhMucSanPham.setModel(cbx);
    }

    SanPhamModel getdata() {
        return new SanPhamModel(txt_maSanPham.getText(), txt_tenSanPham.getText(), Integer.parseInt(txt_soLuong.getText()), Integer.parseInt(txt_giiaban.getText()), tar_mota.getText(), cbc_trangThai.getSelectedItem().equals("Đang Bán"),
                _ChatLieuService.getProducts().get(cbc_chatLieu.getSelectedIndex()),
                _KieuDangService.getproduct().get(cbc_kieuDang.getSelectedIndex()),
                _DanhMucSanPhamService.getListFromDB().get(cbc_danhMucSanPham.getSelectedIndex()),
                _IMauSacService.getproduct().get(cbc_mauSanPham.getSelectedIndex()),
                _IManageSizeService.getfullize().get(cbc_size.getSelectedIndex()));
    }

    public void loadtable(List<SanPhamModel> lstSP) {
        _DefaultTableModel = new DefaultTableModel();
        _DefaultTableModel = (DefaultTableModel) tbl_sanpham.getModel();
        _DefaultTableModel.setRowCount(0);
        for (SanPhamModel x : lstSP) {
            _DefaultTableModel.addRow(new Object[]{x.getMaSanPham(), x.getTenSanPham(),
                x.getKieudangModel().getTenKieuDang(),
                x.getSizeModel().getTenSize(),
                x.getMausacModel().getTenMauSac(),
                x.getDanhMucSanPhamModel().getTenDanhMuc(),
                x.getChatlieuModel().getTenChatLieu(),
                x.getSoLuong(), x.getGia(), x.isTrangThai() == true ? "Đang Bán" : "Ngưng Bán", x.getMota()
            });
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_sanpham = new javax.swing.JTable();
        txt_timKiem = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        rdb_theoMa = new javax.swing.JRadioButton();
        rdb_theoTen = new javax.swing.JRadioButton();
        rdb_theoSize = new javax.swing.JRadioButton();
        rdb_theoMau = new javax.swing.JRadioButton();
        rdb_theoDanMucSp = new javax.swing.JRadioButton();
        rdb_theoChatLieu = new javax.swing.JRadioButton();
        rdb_theoKieuDang = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        Mota = new javax.swing.JLabel();
        Mota1 = new javax.swing.JLabel();
        txt_maSanPham = new javax.swing.JTextField();
        txt_soLuong = new javax.swing.JTextField();
        cbc_kieuDang = new javax.swing.JComboBox<>();
        cbc_size = new javax.swing.JComboBox<>();
        cbc_danhMucSanPham = new javax.swing.JComboBox<>();
        cbc_chatLieu = new javax.swing.JComboBox<>();
        txt_giiaban = new javax.swing.JTextField();
        cbc_mauSanPham = new javax.swing.JComboBox<>();
        cbc_trangThai = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tar_mota = new javax.swing.JTextArea();
        btn_them = new javax.swing.JButton();
        btn_sua = new javax.swing.JButton();
        btn_clear = new javax.swing.JButton();
        txt_tenSanPham = new javax.swing.JTextField();
        btl_themSoLuong = new javax.swing.JButton();
        btn_truSoLuong = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(153, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tbl_sanpham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã SP", "Tên SP", "Kiểu dáng SP", "Size ", "Màu Sp", "Danh mục SP", "Chất liệu", "Số Lượng ", "Giá bán", "Tinh trang", "Mô Tả"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_sanpham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tbl_sanphamMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_sanpham);

        txt_timKiem.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txt_timKiemCaretUpdate(evt);
            }
        });
        txt_timKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_timKiemActionPerformed(evt);
            }
        });

        jLabel12.setText("Tìm Kiếm");

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
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
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
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txt_timKiem)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 901, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_timKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdb_theoMa)
                    .addComponent(rdb_theoTen)
                    .addComponent(rdb_theoSize)
                    .addComponent(rdb_theoMau)
                    .addComponent(rdb_theoDanMucSp)
                    .addComponent(rdb_theoChatLieu)
                    .addComponent(rdb_theoKieuDang))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(153, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setForeground(new java.awt.Color(102, 255, 255));

        jLabel3.setText("Mã sản phẩm");

        jLabel4.setText("Tên sản phẩm");

        jLabel5.setText("kiểu dáng");

        jLabel6.setText("Size");

        jLabel7.setText("Màu SP");

        jLabel8.setText("Danh Mục SP");

        jLabel9.setText("Chất liệu");

        jLabel10.setText("Số lượng");

        jLabel11.setText("Giá bán");

        Mota.setText("Mô Tả");

        Mota1.setText("Trạng Thái");

        txt_soLuong.setText("100");

        cbc_kieuDang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbc_size.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbc_danhMucSanPham.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbc_chatLieu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txt_giiaban.setText("90000");

        cbc_mauSanPham.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbc_trangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        tar_mota.setColumns(20);
        tar_mota.setRows(5);
        jScrollPane2.setViewportView(tar_mota);

        btn_them.setText("Thêm");
        btn_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themActionPerformed(evt);
            }
        });

        btn_sua.setText("Sửa");
        btn_sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_suaActionPerformed(evt);
            }
        });

        btn_clear.setText("Clear");
        btn_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clearActionPerformed(evt);
            }
        });

        btl_themSoLuong.setText("+");
        btl_themSoLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btl_themSoLuongActionPerformed(evt);
            }
        });

        btn_truSoLuong.setText("-");
        btn_truSoLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_truSoLuongActionPerformed(evt);
            }
        });

        jButton6.setText("Load");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_giiaban, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Mota1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Mota, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(txt_soLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btl_themSoLuong)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btn_truSoLuong))
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                        .addComponent(cbc_trangThai, javax.swing.GroupLayout.Alignment.LEADING, 0, 139, Short.MAX_VALUE)
                                        .addComponent(btn_clear, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                                        .addComponent(btn_sua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_maSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cbc_kieuDang, 0, 139, Short.MAX_VALUE)
                                    .addComponent(cbc_size, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbc_danhMucSanPham, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbc_chatLieu, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txt_tenSanPham)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbc_mauSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_them, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_maSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_tenSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbc_kieuDang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cbc_size, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cbc_mauSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cbc_danhMucSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(cbc_chatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txt_soLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btl_themSoLuong)
                    .addComponent(btn_truSoLuong))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_giiaban, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Mota1)
                    .addComponent(cbc_trangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Mota)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_sua)
                    .addComponent(btn_them))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton6)
                    .addComponent(btn_clear))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton1.setText("Chất Liệu");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Màu Sắc");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton4.setText("Size");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Danh Mục");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton3.setText("Kiểu Dáng");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1)
                        .addGap(40, 40, 40)
                        .addComponent(jButton2)
                        .addGap(50, 50, 50)
                        .addComponent(jButton3)
                        .addGap(60, 60, 60)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65)
                        .addComponent(jButton5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(jButton4)
                    .addComponent(jButton2)
                    .addComponent(jButton1)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tbl_sanphamMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_sanphamMouseReleased
        int index = tbl_sanpham.getSelectedRow();
        txt_maSanPham.setText(tbl_sanpham.getModel().getValueAt(index, 0).toString());
        txt_tenSanPham.setText(tbl_sanpham.getModel().getValueAt(index, 1).toString());
        txt_soLuong.setText(tbl_sanpham.getModel().getValueAt(index, 7).toString());
        txt_giiaban.setText(tbl_sanpham.getModel().getValueAt(index, 8).toString());
        tar_mota.setText(tbl_sanpham.getModel().getValueAt(index, 10).toString());

        cbc_kieuDang.setSelectedItem(tbl_sanpham.getModel().getValueAt(index, 2).toString());
        cbc_size.setSelectedItem(tbl_sanpham.getModel().getValueAt(index, 3).toString());
        cbc_mauSanPham.setSelectedItem(tbl_sanpham.getModel().getValueAt(index, 4).toString());
        cbc_danhMucSanPham.setSelectedItem(tbl_sanpham.getModel().getValueAt(index, 5).toString());
        cbc_chatLieu.setSelectedItem(tbl_sanpham.getModel().getValueAt(index, 6).toString());
        cbc_trangThai.setSelectedItem(tbl_sanpham.getModel().getValueAt(index, 9).toString());
    }//GEN-LAST:event_tbl_sanphamMouseReleased

    private void txt_timKiemCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txt_timKiemCaretUpdate
        if (txt_timKiem.getText().isBlank()) {
            loadtable(_ISanPhamService.getlistsanpham());
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

        loadtable(lstTemp);
    }//GEN-LAST:event_txt_timKiemCaretUpdate

    private void txt_timKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_timKiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_timKiemActionPerformed

    private void rdb_theoMaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdb_theoMaActionPerformed
        if (txt_timKiem.getText().isBlank()) {
            loadtable(_ISanPhamService.getlistsanpham());
            return;
        }
        List<SanPhamModel> lstTemp = new ArrayList<>();
        for (SanPhamModel x : _ISanPhamService.getlistsanpham()) {
            if (_ISanPhamService.Timkiem(x.getMaSanPham(), txt_timKiem.getText())) {
                lstTemp.add(x);
            }
        }
        loadtable(lstTemp);
    }//GEN-LAST:event_rdb_theoMaActionPerformed

    private void rdb_theoTenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdb_theoTenActionPerformed
        if (txt_timKiem.getText().isBlank()) {
            loadtable(_ISanPhamService.getlistsanpham());
            return;
        }
        List<SanPhamModel> lstTemp = new ArrayList<>();
        for (SanPhamModel x : _ISanPhamService.getlistsanpham()) {
            if (_ISanPhamService.Timkiem(x.getTenSanPham(), txt_timKiem.getText())) {
                lstTemp.add(x);
            }
        }
        loadtable(lstTemp);
    }//GEN-LAST:event_rdb_theoTenActionPerformed

    private void rdb_theoSizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdb_theoSizeActionPerformed
        if (txt_timKiem.getText().isBlank()) {
            loadtable(_ISanPhamService.getlistsanpham());
            return;
        }
        List<SanPhamModel> lstTemp = new ArrayList<>();
        for (SanPhamModel x : _ISanPhamService.getlistsanpham()) {
            if (_ISanPhamService.Timkiem(x.getSizeModel().getTenSize(), txt_timKiem.getText())) {
                lstTemp.add(x);
            }
        }
        loadtable(lstTemp);
    }//GEN-LAST:event_rdb_theoSizeActionPerformed

    private void rdb_theoMauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdb_theoMauActionPerformed
        if (txt_timKiem.getText().isBlank()) {
            loadtable(_ISanPhamService.getlistsanpham());
            return;
        }
        List<SanPhamModel> lstTemp = new ArrayList<>();
        for (SanPhamModel x : _ISanPhamService.getlistsanpham()) {
            if (_ISanPhamService.Timkiem(x.getMausacModel().getTenMauSac(), txt_timKiem.getText())) {
                lstTemp.add(x);
            }
        }
        loadtable(lstTemp);
    }//GEN-LAST:event_rdb_theoMauActionPerformed

    private void rdb_theoDanMucSpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdb_theoDanMucSpActionPerformed
        if (txt_timKiem.getText().isBlank()) {
            loadtable(_ISanPhamService.getlistsanpham());
            return;
        }
        List<SanPhamModel> lstTemp = new ArrayList<>();
        for (SanPhamModel x : _ISanPhamService.getlistsanpham()) {
            if (_ISanPhamService.Timkiem(x.getDanhMucSanPhamModel().getTenDanhMuc(), txt_timKiem.getText())) {
                lstTemp.add(x);
            }
        }
        loadtable(lstTemp);
    }//GEN-LAST:event_rdb_theoDanMucSpActionPerformed

    private void rdb_theoChatLieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdb_theoChatLieuActionPerformed
        if (txt_timKiem.getText().isBlank()) {
            loadtable(_ISanPhamService.getlistsanpham());
            return;
        }
        List<SanPhamModel> lstTemp = new ArrayList<>();
        for (SanPhamModel x : _ISanPhamService.getlistsanpham()) {
            if (_ISanPhamService.Timkiem(x.getChatlieuModel().getTenChatLieu(), txt_timKiem.getText())) {
                lstTemp.add(x);
            }
        }
        loadtable(lstTemp);
    }//GEN-LAST:event_rdb_theoChatLieuActionPerformed

    private void rdb_theoKieuDangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdb_theoKieuDangActionPerformed
        if (txt_timKiem.getText().isBlank()) {
            loadtable(_ISanPhamService.getlistsanpham());
            return;
        }
        List<SanPhamModel> lstTemp = new ArrayList<>();
        for (SanPhamModel x : _ISanPhamService.getlistsanpham()) {
            if (_ISanPhamService.Timkiem(x.getKieudangModel().getTenKieuDang(), txt_timKiem.getText())) {
                lstTemp.add(x);
            }
        }
        loadtable(lstTemp);
    }//GEN-LAST:event_rdb_theoKieuDangActionPerformed

    private void btn_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themActionPerformed
if (_checkDt.checkNullString(txt_tenSanPham.getText()) || _checkDt.checkNullString(txt_soLuong.getText()) || _checkDt.checkNullString(txt_giiaban.getText())) {
            JOptionPane.showMessageDialog(this, "Không được để trống tên,Giá bán,Số Lượng");
            return;
        }
        if (!_checkDt.checksoThuc(txt_giiaban.getText()) || !_checkDt.checkso(txt_soLuong.getText())) {
            JOptionPane.showMessageDialog(this, "Số lượng và giá bán phải là số");
            return;
        }
          int xacnhan = JOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn thêm ?");
        if (xacnhan != JOptionPane.YES_OPTION) {
            return;
        }
        _ISanPhamService.them(getdata());
        loadtable(_ISanPhamService.getlistsanpham());
    }//GEN-LAST:event_btn_themActionPerformed

    private void btn_suaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suaActionPerformed
        if (_checkDt.checkNullString(txt_tenSanPham.getText()) || _checkDt.checkNullString(txt_soLuong.getText()) || _checkDt.checkNullString(txt_giiaban.getText())) {
            JOptionPane.showMessageDialog(this, "Không được để trống tên,Giá bán,Số Lượng");
            return;
        }
        if (!_checkDt.checksoThuc(txt_giiaban.getText()) || !_checkDt.checkso(txt_soLuong.getText())) {
            JOptionPane.showMessageDialog(this, "Số lượng và giá bán phải là số");
            return;
        }
        _ISanPhamService.sua(getdata());
        loadtable(_ISanPhamService.getlistsanpham());
    }//GEN-LAST:event_btn_suaActionPerformed

    private void btn_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearActionPerformed

        txt_maSanPham.setText(_ISanPhamService.getMaSanPham());
        txt_tenSanPham.setText("");
        //        txt_soLuong.setText("1000");
        //        txt_giiaban.setText("90000");
        //        tar_mota.setText("Không có");

        //        cbc_kieuDang.setSelectedIndex(0);
        //        cbc_size.setSelectedIndex(0);
        //        cbc_mauSanPham.setSelectedIndex(0);
        //        cbc_danhMucSanPham.setSelectedIndex(0);
        //        cbc_chatLieu.setSelectedIndex(0);
        //        cbc_trangThai.setSelectedIndex(0);
    }//GEN-LAST:event_btn_clearActionPerformed

    private void btl_themSoLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btl_themSoLuongActionPerformed
        String temp = JOptionPane.showInputDialog(this, "Nhập Số Lượng Muốn Thêm");
        if (!_checkDt.checkso(temp)) {
            JOptionPane.showMessageDialog(this, "Bạn Phải nhập số và phải > 0");
            return;
        }
        txt_soLuong.setText(String.valueOf(Integer.parseInt(txt_soLuong.getText()) + Integer.parseInt(temp)));
    }//GEN-LAST:event_btl_themSoLuongActionPerformed

    private void btn_truSoLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_truSoLuongActionPerformed
        String temp = JOptionPane.showInputDialog(this, "Nhập Số Lượng Muốn Thêm");
        if (!_checkDt.checkso(temp)) {
            JOptionPane.showMessageDialog(this, "Bạn Phải nhập số và phải > 0");
            return;
        }
        if (Integer.parseInt(txt_soLuong.getText()) < Integer.parseInt(temp)) {
            JOptionPane.showMessageDialog(this, "Số lượng muốn trừ phải nhỏ hơn số lượng đang có");
            return;
        }
        txt_soLuong.setText(String.valueOf(Integer.parseInt(txt_soLuong.getText()) - Integer.parseInt(temp)));
    }//GEN-LAST:event_btn_truSoLuongActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new QLChatLieuJDialog(null, true).setVisible(true);
        cbxchatlieu();
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        new QLMauSacJDialog(null, true).setVisible(true);
        cbxmausac();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        new QLKieuDangJDialog(null, true).setVisible(true);
        cbxkieudang();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        new QLSizeJDialog(null, true).setVisible(true);
        cbxsize();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        new QLDanhMucSanPhamJDialog(null, true).setVisible(true);
        cbxdanhmuc();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        cbxmausac();
        cbxchatlieu();
        cbxdanhmuc();
        cbxkieudang();
        cbxsize();
        cbcTrangThai();
    }//GEN-LAST:event_jButton6ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Mota;
    private javax.swing.JLabel Mota1;
    private javax.swing.JButton btl_themSoLuong;
    private javax.swing.JButton btn_clear;
    private javax.swing.JButton btn_sua;
    private javax.swing.JButton btn_them;
    private javax.swing.JButton btn_truSoLuong;
    private javax.swing.JComboBox<String> cbc_chatLieu;
    private javax.swing.JComboBox<String> cbc_danhMucSanPham;
    private javax.swing.JComboBox<String> cbc_kieuDang;
    private javax.swing.JComboBox<String> cbc_mauSanPham;
    private javax.swing.JComboBox<String> cbc_size;
    private javax.swing.JComboBox<String> cbc_trangThai;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton rdb_theoChatLieu;
    private javax.swing.JRadioButton rdb_theoDanMucSp;
    private javax.swing.JRadioButton rdb_theoKieuDang;
    private javax.swing.JRadioButton rdb_theoMa;
    private javax.swing.JRadioButton rdb_theoMau;
    private javax.swing.JRadioButton rdb_theoSize;
    private javax.swing.JRadioButton rdb_theoTen;
    private javax.swing.JTextArea tar_mota;
    private javax.swing.JTable tbl_sanpham;
    private javax.swing.JTextField txt_giiaban;
    private javax.swing.JTextField txt_maSanPham;
    private javax.swing.JTextField txt_soLuong;
    private javax.swing.JTextField txt_tenSanPham;
    private javax.swing.JTextField txt_timKiem;
    // End of variables declaration//GEN-END:variables
}
