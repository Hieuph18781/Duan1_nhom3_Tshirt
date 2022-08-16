/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package JpanelForm;

import Services.HoaDonChiTietService;
import Services.HoaDonDoiTraChiTietService;
import Services.HoaDonDoiTraService;
import Services.HoaDonService;
import Services.IHoaDonChiTietService;
import Services.IHoaDonDoiTraChiTietService;
import Services.IHoaDonDoiTraService;
import Services.IHoaDonService;
import Services.ISanPhamService;
import Services.IThongKeService;
import Services.SanPhamService;
import Services.ThongKeService;
import Utils.Auth;
import Utils.CheckData;
import ViewsModels.HoaDonChiTietModel;
import ViewsModels.HoaDonDoiTraChiTietModel;
import ViewsModels.HoaDonDoiTraMoDel;
import ViewsModels.HoaDonModel;
import ViewsModels.KhachHangModel;
import ViewsModels.SanPhamModel;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Nguyen Van Thuan
 */
public class QLDoiHangPanel extends javax.swing.JPanel {

    /**
     * Creates new form QLDoiHangPanel
     */
    DefaultTableModel _defaultTB;
    IThongKeService _IThongKeRepository;
    CheckData _checkDt;
    IHoaDonChiTietService _HoaDonCTService;
    IHoaDonDoiTraService _hoaDonDoiTraService;
    IHoaDonDoiTraChiTietService _ihoadDoiTraChiTietService;
    NumberFormat _formatter = new DecimalFormat("#,###");
    IHoaDonService _iHoaDonService;
    ISanPhamService _ISanPhamService;

    public QLDoiHangPanel() {
        initComponents();
        _HoaDonCTService = new HoaDonChiTietService();
        _IThongKeRepository = new ThongKeService();
        _hoaDonDoiTraService = new HoaDonDoiTraService();
        _ihoadDoiTraChiTietService = new HoaDonDoiTraChiTietService();
        _iHoaDonService = new HoaDonService();
        _ISanPhamService = new SanPhamService();
        _checkDt = new CheckData();
        loadtable(_IThongKeRepository.thongke5());
        setlbl();
        String abcd = "ađas";
        new PrameChonSanPhamDoi(abcd).setVisible(true);
    }

    void setlbl() {
        lbl_hoadon.setText("");
        lbl_nhanVien.setText("");
        lbl_khachHang.setText("");
        lbl_tongtienhoantra.setText("0");
    }

    void tongTienTra() {
        long tongtien = 0;
        for (int i = 0; i < tbl_sanPhamTra.getRowCount(); i++) {
            tongtien = tongtien + (Long.parseLong(tbl_sanPhamTra.getModel().getValueAt(i, 8).toString()) * Long.parseLong(tbl_sanPhamTra.getModel().getValueAt(i, 9).toString()));
        }
        lbl_tongtienhoantra.setText(String.valueOf(_formatter.format(tongtien)));
    }

    public void loadtableSanPhamTra(int mahddt) {
        DefaultTableModel _DefaultTableModel = new DefaultTableModel();
        _DefaultTableModel = (DefaultTableModel) tbl_sanPhamTra.getModel();
        _DefaultTableModel.setRowCount(0);
        int stt = 1;
        for (HoaDonDoiTraChiTietModel x : _ihoadDoiTraChiTietService.getListFromDB(mahddt)) {
            _DefaultTableModel.addRow(new Object[]{
                stt++,
                x.getSanPhamModel().getMaSanPham(), x.getSanPhamModel().getTenSanPham(),
                x.getSanPhamModel().getChatlieuModel().getTenChatLieu(),
                x.getSanPhamModel().getDanhMucSanPhamModel().getTenDanhMuc(),
                x.getSanPhamModel().getKieudangModel().getTenKieuDang(),
                x.getSanPhamModel().getSizeModel().getTenSize(),
                x.getSanPhamModel().getMausacModel().getTenMauSac(),
                x.getSoLuong(), x.getDonGia()
            });
        }
    }

    public void loadtable(List<HoaDonModel> hdmd) {
        DefaultTableModel _DefaultTableModel = new DefaultTableModel();
        _DefaultTableModel = (DefaultTableModel) tbl_hd.getModel();
        _DefaultTableModel.setRowCount(0);
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        for (HoaDonModel x : hdmd) {
            _DefaultTableModel.addRow(new Object[]{x.getMaHoaDon(), dateFormat.format(x.getThoiGianTao()),
                x.getTrangThai() == 0 ? "Đang Chờ" : x.getTrangThai() == 1 ? "Hủy" : "Thành Công",
                x.getKhachhang().getMaKhachHang() == 1 ? "Khách Lẻ" : x.getKhachhang().getHoTen(), x.getKhuyenmai().getTenKhuyenMai(), x.getNhanvien().getHoTen()});
        }
    }

    void fillTableTheoNgay(int a) {
        DefaultTableModel model = (DefaultTableModel) tbl_hdct.getModel();
        model.setRowCount(0);
        List<HoaDonChiTietModel> list = _HoaDonCTService.getListFromDB(a);
        for (HoaDonChiTietModel x : list) {
            model.addRow(new Object[]{
                x.getSanPhamModel().getMaSanPham(), x.getSanPhamModel().getTenSanPham(), x.getSoLuong(), x.getDonGia(), _formatter.format(x.getDonGia() * x.getSoLuong())
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

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_hd = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        txt_timkiem = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_hdct = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_sanPhamTra = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lbl_hoadon = new javax.swing.JLabel();
        lbl_nhanVien = new javax.swing.JLabel();
        lbl_khachHang = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tar_lydo = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        lbl_tongtienhoantra = new javax.swing.JLabel();
        btn_traHang = new javax.swing.JButton();

        jPanel2.setBackground(new java.awt.Color(204, 255, 255));
        jPanel2.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
                jPanel2AncestorRemoved(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "Danh Sách Hóa Đơn", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        tbl_hd.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ma Hoa Don", "Thoi Gian", "Trang Thai", "Tên Khach Hang", "Tên Khuyen Mai", "Tên Nhan Vien"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_hd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_hdMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_hd);

        jLabel6.setText("Tìm Kiếm :");

        txt_timkiem.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txt_timkiemCaretUpdate(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 467, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_timkiem)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txt_timkiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(204, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Hóa Đơn Chi Tiết", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        tbl_hdct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Sản Phẩm", "Tên Sản Phẩm", "Số Lượng", "Đơn Giá", "Tổng tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tbl_hdct);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 497, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(204, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh Sách Sản Phẩm Đổi", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        tbl_sanPhamTra.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_sanPhamTra.setInheritsPopupMenu(true);
        jScrollPane3.setViewportView(tbl_sanPhamTra);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 713, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        jPanel5.setBackground(new java.awt.Color(204, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông Tin Trả Hàng", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        jLabel1.setText("Nhân Viên :");

        jLabel2.setText("Hóa Đơn :");

        jLabel3.setText("Khách Hàng :");

        jLabel4.setText("Lý Do :");

        lbl_hoadon.setText("hoadon");

        lbl_nhanVien.setText("nhanvien");

        lbl_khachHang.setText("khách hàng");

        tar_lydo.setColumns(20);
        tar_lydo.setRows(5);
        jScrollPane4.setViewportView(tar_lydo);

        jLabel5.setText("Tổng tiền Hoàn Trả :");

        lbl_tongtienhoantra.setText("0");

        btn_traHang.setText("Đổi Hàng");
        btn_traHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_traHangActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_traHang)
                        .addGap(32, 32, 32))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbl_tongtienhoantra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(9, 9, 9)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lbl_nhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                                    .addComponent(lbl_hoadon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                                    .addComponent(lbl_khachHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lbl_hoadon))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lbl_nhanVien))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lbl_khachHang))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lbl_tongtienhoantra))
                .addGap(18, 18, 18)
                .addComponent(btn_traHang)
                .addGap(44, 44, 44))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tbl_hdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_hdMouseClicked
        //        if (tbl_sanPhamTra.getRowCount() > 0) {
        //            JOptionPane.showMessageDialog(this, "Bạn đang có hóa đơn đang trả");
        //            return;
        //        }
        int row = tbl_hd.getSelectedRow();
        if (row < 0) {
            return;
        }
        fillTableTheoNgay(Integer.parseInt(tbl_hd.getValueAt(row, 0).toString()));
        lbl_hoadon.setText(tbl_hd.getModel().getValueAt(row, 0).toString());
        lbl_nhanVien.setText(tbl_hd.getModel().getValueAt(row, 5).toString());
        lbl_khachHang.setText(tbl_hd.getModel().getValueAt(row, 3).toString());
        lbl_tongtienhoantra.setText("0");
    }//GEN-LAST:event_tbl_hdMouseClicked

    private void txt_timkiemCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txt_timkiemCaretUpdate

    }//GEN-LAST:event_txt_timkiemCaretUpdate

    private void btn_traHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_traHangActionPerformed
        int rowhdon = tbl_hd.getSelectedRow();
        if (rowhdon < 0) {
            JOptionPane.showMessageDialog(this, "Chọn hóa đơn cần trả hàng");
            return;
        }
        if (tbl_sanPhamTra.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "Chọn sản phẩm và số lượng cần trả hàng");
            return;
        }
        int temp = JOptionPane.showConfirmDialog(this, "Xác Nhận bạn muốn trả hàng? ");
        if (temp != 0) {
            return;
        }
//        HoaDonModel hdmodel = new HoaDonModel();
//        hdmodel.setMaHoaDon(Integer.parseInt(tbl_hd.getModel().getValueAt(rowhdon, 0).toString()));
//
//        KhachHangModel khmodel = new KhachHangModel();
//        khmodel.setMaKhachHang(1);
//
//        hdmodel.setMaHoaDon(Integer.parseInt(tbl_hd.getModel().getValueAt(rowhdon, 0).toString()));
//        HoaDonDoiTraMoDel hoaDonDoiTraMoDel = _hoaDonDoiTraService.them(new HoaDonDoiTraMoDel(0, 0, new java.util.Date(), "", hdmodel, khmodel, Auth.user));
//        hoaDonDoiTraMoDel.setTongTienHoanTra(Integer.parseInt(lbl_tongtienhoantra.getText().replaceAll(",", "")));
//        hoaDonDoiTraMoDel.setNgayTaoHoaDon(new java.util.Date());
//        hoaDonDoiTraMoDel.setMoTa(tar_lydo.getText());
//        _hoaDonDoiTraService.sua(hoaDonDoiTraMoDel);
//        hdmodel = hoaDonDoiTraMoDel.getHoaDonModel();
//        hdmodel.setTrangThai(3);
//        _iHoaDonService.sua(hdmodel);
//
//        for (int i = 0; i < tbl_sanPhamTra.getRowCount(); i++) {
//            for (SanPhamModel x : _ISanPhamService.getlistsanpham()) {
//                if (x.getMaSanPham().equals(tbl_sanPhamTra.getModel().getValueAt(i, 1).toString())) {
//                    _ISanPhamService.suaSoLuongSP(tbl_sanPhamTra.getValueAt(i, 1).toString(), x.getSoLuong() + Integer.parseInt(tbl_sanPhamTra.getModel().getValueAt(i, 8).toString()));//update so luong san pham
//                }
//            }
//        }
//        fillTableTheoNgay(-1);
//        loadtableSanPhamTra(-1);
//        tongTienTra();
//        loadtable(_IThongKeRepository.thongke5());
    }//GEN-LAST:event_btn_traHangActionPerformed

    private void jPanel2AncestorRemoved(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jPanel2AncestorRemoved
        //Sự Kiện đóng JPane
        //        int row = tbl_sanPhamTra.getSelectedRow();
        int rowhdon = tbl_hd.getSelectedRow();
        //        if (row < 0) {
        //            JOptionPane.showMessageDialog(this, "Vui lòng chọn sản phẩm cần xóa");
        //            return;
        //        }
//        for (int i = 0; i < tbl_sanPhamTra.getRowCount(); i++) {
//            HoaDonModel hdmodel = new HoaDonModel();
//            hdmodel.setMaHoaDon(Integer.parseInt(tbl_hd.getModel().getValueAt(rowhdon, 0).toString()));
//
//            KhachHangModel khmodel = new KhachHangModel();
//            khmodel.setMaKhachHang(1);
//
//            SanPhamModel sanPhamModel = new SanPhamModel();
//            sanPhamModel.setMaSanPham(tbl_hdct.getModel().getValueAt(i, 0).toString());
//
//            HoaDonDoiTraMoDel hoaDonDoiTraMoDel = _hoaDonDoiTraService.them(new HoaDonDoiTraMoDel(0, 0, new java.util.Date(), "", hdmodel, khmodel, Auth.user));
//            int soluong = 0;
//            for (HoaDonChiTietModel x : _HoaDonCTService.getListFromDB(Integer.parseInt(tbl_hd.getValueAt(rowhdon, 0).toString()))) {
//                if (x.getSanPhamModel().getMaSanPham().equals(tbl_sanPhamTra.getModel().getValueAt(i, 1).toString())) {
//                    soluong = x.getSoLuong() + Integer.parseInt(tbl_sanPhamTra.getModel().getValueAt(i, 8).toString());
//                    x.setSoLuong(soluong);
//                    _HoaDonCTService.sua(x);
//                }
//            }
//            for (HoaDonDoiTraChiTietModel x : _ihoadDoiTraChiTietService.getListFromDB(hoaDonDoiTraMoDel.getMaHoaDonDoiHang())) {
//                if (x.getSanPhamModel().getMaSanPham().equals(tbl_sanPhamTra.getModel().getValueAt(i, 1).toString())) {
//                    _ihoadDoiTraChiTietService.xoa(x);
//                }
//            }
//
//            fillTableTheoNgay(Integer.parseInt(tbl_hd.getValueAt(rowhdon, 0).toString()));
//            loadtableSanPhamTra(hoaDonDoiTraMoDel.getMaHoaDonDoiHang());
//            tongTienTra();
//            if (tbl_sanPhamTra.getRowCount() == 0) {
//                _hoaDonDoiTraService.xoa(hoaDonDoiTraMoDel.getMaHoaDonDoiHang());
//            }
//        }
    }//GEN-LAST:event_jPanel2AncestorRemoved


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_traHang;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lbl_hoadon;
    private javax.swing.JLabel lbl_khachHang;
    private javax.swing.JLabel lbl_nhanVien;
    private javax.swing.JLabel lbl_tongtienhoantra;
    private javax.swing.JTextArea tar_lydo;
    private javax.swing.JTable tbl_hd;
    private javax.swing.JTable tbl_hdct;
    private javax.swing.JTable tbl_sanPhamTra;
    private javax.swing.JTextField txt_timkiem;
    // End of variables declaration//GEN-END:variables
}
