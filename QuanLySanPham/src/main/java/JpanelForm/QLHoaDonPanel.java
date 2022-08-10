/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package JpanelForm;

import Repositories.IThongKeRepository;
import Repositories.ThongKeRepository;
import Services.IThongKeService;
import Services.ThongKeService;
import ViewsModels.HoaDonChiTietModel;
import ViewsModels.HoaDonModel;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author dytc0
 */
public class QLHoaDonPanel extends javax.swing.JPanel {

    DefaultTableModel _defaultTB;
    IThongKeService _IThongKeRepository;

    /**
     * Creates new form QLHoaDonPanel
     */
    public QLHoaDonPanel() {
        initComponents();
        _IThongKeRepository = new ThongKeService();
        loadtable(_IThongKeRepository.thongke5());
        setrdb();
        cbc_tg.setSelectedItem("Không");
    }

    void setrdb() {
        ButtonGroup btn = new ButtonGroup();
        btn.add(rdb_mahd);
        btn.add(rdb_makh);
        btn.add(rdb_manv);
        rdb_mahd.setSelected(true);
    }

    public void loadtable(List<HoaDonModel> hdmd) {
        DefaultTableModel _DefaultTableModel = new DefaultTableModel();
        _DefaultTableModel = (DefaultTableModel) tbl_hd.getModel();
        _DefaultTableModel.setRowCount(0);
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        for (HoaDonModel x : hdmd) {
            _DefaultTableModel.addRow(new Object[]{x.getMaHoaDon(), dateFormat.format(x.getThoiGianTao()),
                x.getTrangThai() == 0 ? "Đang Chờ" : x.getTrangThai() == 1 ? "Hủy" : "Thành Công",
                x.getKhachhang().getMaKhachHang() == 1 ? "Khách Lẻ" : x.getKhachhang().getMaKhachHang(), x.getKhuyenmai().getIdKhuyenMai(), x.getNhanvien().getMaNhanVien()});
        }
    }

    public void loadtable2(List<HoaDonChiTietModel> hdmd) {
        DefaultTableModel _DefaultTableModel = new DefaultTableModel();
        _DefaultTableModel = (DefaultTableModel) tbl_hdct.getModel();
        _DefaultTableModel.setRowCount(0);
        for (HoaDonChiTietModel x : hdmd) {
            _DefaultTableModel.addRow(new Object[]{x.getSanPhamModel().getMaSanPham(), x.getSoLuong(), x.getDonGia()});
        }
    }

    void fillTableTheoNgay(int a) {
        DefaultTableModel model = (DefaultTableModel) tbl_hdct.getModel();
        model.setRowCount(0);
        List<Object[]> list = _IThongKeRepository.thongke9(a);
        for (Object[] row : list) {
            model.addRow(row);
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

        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbc_trangthai = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        txt_timKiem = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cbc_tg = new javax.swing.JComboBox<>();
        btn_timkiem = new javax.swing.JButton();
        txt_ngay2 = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        txt_ngay1 = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        rdb_makh = new javax.swing.JRadioButton();
        rdb_manv = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        rdb_mahd = new javax.swing.JRadioButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_hdct = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_hd = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        lbl_tongtien = new javax.swing.JLabel();

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("HOÁ ĐƠN");

        jLabel2.setText("Trạng Thái");

        cbc_trangthai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đã Thanh Toán", "Đã Huỷ" }));
        cbc_trangthai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbc_trangthaiActionPerformed(evt);
            }
        });

        jLabel9.setText("Tìm Kiếm");

        txt_timKiem.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txt_timKiemCaretUpdate(evt);
            }
        });

        jLabel8.setText("Tìm Kiếm Theo Khoảng Thời Gian");

        cbc_tg.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Không", "Có", " " }));
        cbc_tg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbc_tgActionPerformed(evt);
            }
        });

        btn_timkiem.setText("Lọc Danh Sách");
        btn_timkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_timkiemActionPerformed(evt);
            }
        });

        txt_ngay2.setDateFormatString("yyyy-MM-dd");
        txt_ngay2.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                txt_ngay2InputMethodTextChanged(evt);
            }
        });
        txt_ngay2.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                txt_ngay2PropertyChange(evt);
            }
        });

        jLabel5.setText("Đến Ngày");

        txt_ngay1.setDateFormatString("yyyy-MM-dd");
        txt_ngay1.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                txt_ngay1InputMethodTextChanged(evt);
            }
        });
        txt_ngay1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                txt_ngay1PropertyChange(evt);
            }
        });

        jLabel6.setText("Từ Ngày");

        rdb_makh.setText("Theo Mã Khách Hàng");

        rdb_manv.setText("Theo Mã Nhân Viên");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Danh Sách Hoá Đơn");

        rdb_mahd.setText("Theo mã hoá đơn");

        tbl_hdct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã Sản Phẩm", "Tên Sản Phẩm", "Số Lượng", "Tổng tiền"
            }
        ));
        jScrollPane2.setViewportView(tbl_hdct);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Hoá Đơn Chi Tiết");

        tbl_hd.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Ma Hoa Don", "Thoi Gian", "Trang Thai", "Ma Khach Hang", "ID Khuyen Mai", "Ma Nhan Vien"
            }
        ));
        tbl_hd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_hdMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_hd);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel7.setText("Thành Tiền: ");

        lbl_tongtien.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbl_tongtien.setText("0 VND");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_tongtien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(lbl_tongtien))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(rdb_mahd)
                        .addGap(18, 18, 18)
                        .addComponent(rdb_makh)
                        .addGap(38, 38, 38)
                        .addComponent(rdb_manv))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel9))
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbc_trangthai, 0, 116, Short.MAX_VALUE)
                            .addComponent(txt_timKiem))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbc_tg, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn_timkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_ngay1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_ngay2, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jLabel1)))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 129, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addGap(129, 129, 129))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addGap(461, 461, 461)
                .addComponent(jLabel3)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbc_trangthai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(cbc_tg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_timkiem))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel9)
                                .addComponent(txt_timKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel6))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txt_ngay1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_ngay2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rdb_manv)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(rdb_mahd)
                                .addComponent(rdb_makh)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cbc_trangthaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbc_trangthaiActionPerformed
        //        if (cbc_trangthai.getSelectedItem().toString().equals("Đã Thanh Toán")) {
        //            loadtable(_IThongKeRepository.thongke5());
        //        } else {
        //            loadtable(_IThongKeRepository.thongke6());
        //        }
    }//GEN-LAST:event_cbc_trangthaiActionPerformed

    private void txt_timKiemCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txt_timKiemCaretUpdate

        List<HoaDonModel> lstTemp = new ArrayList<>();
        if (cbc_trangthai.getSelectedItem().toString().equals("Đã Thanh Toán")
                && cbc_tg.getSelectedItem().equals("Không")) {
            if (rdb_mahd.isSelected()) {
                for (HoaDonModel x : _IThongKeRepository.thongke5()) {
                    if (_IThongKeRepository.Timkiem(String.valueOf(x.getMaHoaDon()), txt_timKiem.getText())) {
                        lstTemp.add(x);

                    }
                }
            }
            if (rdb_makh.isSelected()) {
                for (HoaDonModel x : _IThongKeRepository.thongke5()) {
                    if (_IThongKeRepository.Timkiem(String.valueOf(x.getKhachhang().getMaKhachHang()), txt_timKiem.getText())) {
                        lstTemp.add(x);

                    }
                }
            }
            if (rdb_manv.isSelected()) {
                for (HoaDonModel x : _IThongKeRepository.thongke6()) {
                    if (_IThongKeRepository.Timkiem(x.getNhanvien().getMaNhanVien(), txt_timKiem.getText())) {
                        lstTemp.add(x);

                    }
                }
            }
            loadtable(lstTemp);
        } else if (cbc_trangthai.getSelectedItem().toString().equals("Đã Huỷ")
                && cbc_tg.getSelectedItem().toString().equals("Không")) {
            if (rdb_mahd.isSelected()) {
                for (HoaDonModel x : _IThongKeRepository.thongke6()) {
                    if (_IThongKeRepository.Timkiem(String.valueOf(x.getMaHoaDon()), txt_timKiem.getText())) {
                        lstTemp.add(x);

                    }
                }
            }
            if (rdb_makh.isSelected()) {
                for (HoaDonModel x : _IThongKeRepository.thongke6()) {
                    if (_IThongKeRepository.Timkiem(String.valueOf(x.getKhachhang().getMaKhachHang()), txt_timKiem.getText())) {
                        lstTemp.add(x);

                    }
                }
            }
            if (rdb_manv.isSelected()) {
                for (HoaDonModel x : _IThongKeRepository.thongke6()) {
                    if (_IThongKeRepository.Timkiem(x.getNhanvien().getMaNhanVien(), txt_timKiem.getText())) {
                        lstTemp.add(x);

                    }
                }
            }
            loadtable(lstTemp);
        } else if (cbc_trangthai.getSelectedItem().toString().equals("Đã Thanh Toán")
                && cbc_tg.getSelectedItem().toString().equals("Có")) {
            if (rdb_mahd.isSelected()) {
                for (HoaDonModel x : _IThongKeRepository.thongke7(txt_ngay1.getDate(), txt_ngay2.getDate())) {
                    if (_IThongKeRepository.Timkiem(String.valueOf(x.getMaHoaDon()), txt_timKiem.getText())) {
                        lstTemp.add(x);

                    }
                }
            }
            if (rdb_makh.isSelected()) {
                for (HoaDonModel x : _IThongKeRepository.thongke7(txt_ngay1.getDate(), txt_ngay2.getDate())) {
                    if (_IThongKeRepository.Timkiem(String.valueOf(x.getKhachhang().getMaKhachHang()), txt_timKiem.getText())) {
                        lstTemp.add(x);

                    }
                }
            }
            if (rdb_manv.isSelected()) {
                for (HoaDonModel x : _IThongKeRepository.thongke7(txt_ngay1.getDate(), txt_ngay2.getDate())) {
                    if (_IThongKeRepository.Timkiem(x.getNhanvien().getMaNhanVien(), txt_timKiem.getText())) {
                        lstTemp.add(x);

                    }
                }
            }
            loadtable(lstTemp);
        } else if (cbc_trangthai.getSelectedItem().toString().equals("Đã Huỷ")
                && cbc_tg.getSelectedItem().equals("Có")) {
            if (rdb_mahd.isSelected()) {
                for (HoaDonModel x : _IThongKeRepository.thongke8(txt_ngay1.getDate(), txt_ngay2.getDate())) {
                    if (_IThongKeRepository.Timkiem(String.valueOf(x.getMaHoaDon()), txt_timKiem.getText())) {
                        lstTemp.add(x);

                    }
                }
            }
            if (rdb_makh.isSelected()) {
                for (HoaDonModel x : _IThongKeRepository.thongke8(txt_ngay1.getDate(), txt_ngay2.getDate())) {
                    if (_IThongKeRepository.Timkiem(String.valueOf(x.getKhachhang().getMaKhachHang()), txt_timKiem.getText())) {
                        lstTemp.add(x);

                    }
                }
            }
            if (rdb_manv.isSelected()) {
                for (HoaDonModel x : _IThongKeRepository.thongke8(txt_ngay1.getDate(), txt_ngay2.getDate())) {
                    if (_IThongKeRepository.Timkiem(x.getNhanvien().getMaNhanVien(), txt_timKiem.getText())) {
                        lstTemp.add(x);

                    }
                }
            }
            loadtable(lstTemp);
        }
    }//GEN-LAST:event_txt_timKiemCaretUpdate

    private void btn_timkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_timkiemActionPerformed
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        if (cbc_trangthai.getSelectedItem().toString().equals("Đã Thanh Toán")
                && cbc_tg.getSelectedItem().equals("Không")) {
            loadtable(_IThongKeRepository.thongke5());
        } else if (cbc_trangthai.getSelectedItem().toString().equals("Đã Huỷ")
                && cbc_tg.getSelectedItem().equals("Không")) {
            loadtable(_IThongKeRepository.thongke6());
        } else if (cbc_trangthai.getSelectedItem().toString().equals("Đã Thanh Toán")
                && cbc_tg.getSelectedItem().equals("Có")) {
            try {
                txt_ngay1.getDate().toString().equals("");
                txt_ngay2.getDate().toString().equals("");

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Vui lòng chọn ngày");
                return;
            }
            loadtable(_IThongKeRepository.thongke7(txt_ngay1.getDate(), txt_ngay2.getDate()));
        } else if (cbc_trangthai.getSelectedItem().toString().equals("Đã Huỷ")
                && cbc_tg.getSelectedItem().equals("Có")) {
            try {
                txt_ngay1.getDate().toString().equals("");
                txt_ngay2.getDate().toString().equals("");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Vui lòng chọn ngày");
                return;
            }
            loadtable(_IThongKeRepository.thongke8(txt_ngay1.getDate(), txt_ngay2.getDate()));
        }
    }//GEN-LAST:event_btn_timkiemActionPerformed

    private void txt_ngay2InputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txt_ngay2InputMethodTextChanged

    }//GEN-LAST:event_txt_ngay2InputMethodTextChanged

    private void txt_ngay2PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_txt_ngay2PropertyChange

    }//GEN-LAST:event_txt_ngay2PropertyChange

    private void txt_ngay1InputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txt_ngay1InputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_ngay1InputMethodTextChanged

    private void txt_ngay1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_txt_ngay1PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_ngay1PropertyChange

    private void tbl_hdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_hdMouseClicked
        int row = tbl_hd.getSelectedRow();
        String s = NumberFormat.getIntegerInstance().format(_IThongKeRepository.TongTien4(Integer.parseInt(tbl_hd.getValueAt(row, 0).toString())));
        //        loadtable2(_IThongKeRepository.thongke9(Integer.parseInt(tbl_hd.getValueAt(row, 0).toString())));
        fillTableTheoNgay(Integer.parseInt(tbl_hd.getValueAt(row, 0).toString()));
        lbl_tongtien.setText(s +" VND");

//lbl_tongtien.setText(_IThongKeRepository.TongTien4(Integer.parseInt(tbl_hd.getValueAt(row, 0).toString()))+" VND");
    }//GEN-LAST:event_tbl_hdMouseClicked

    private void cbc_tgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbc_tgActionPerformed
        if (cbc_tg.getSelectedItem().toString().equals("Không")) {
            txt_ngay1.setEnabled(false);
            txt_ngay2.setEnabled(false);
        } else {
            txt_ngay1.setEnabled(true);
            txt_ngay2.setEnabled(true);
        }
    }//GEN-LAST:event_cbc_tgActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_timkiem;
    private javax.swing.JComboBox<String> cbc_tg;
    private javax.swing.JComboBox<String> cbc_trangthai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_tongtien;
    private javax.swing.JRadioButton rdb_mahd;
    private javax.swing.JRadioButton rdb_makh;
    private javax.swing.JRadioButton rdb_manv;
    private javax.swing.JTable tbl_hd;
    private javax.swing.JTable tbl_hdct;
    private com.toedter.calendar.JDateChooser txt_ngay1;
    private com.toedter.calendar.JDateChooser txt_ngay2;
    private javax.swing.JTextField txt_timKiem;
    // End of variables declaration//GEN-END:variables
}
