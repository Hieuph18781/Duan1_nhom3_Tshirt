/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Views;

import DomainModels.NhanVien;
import Repositories.INhanVienRepostiory;
import Services.INhanVienService;
import Services.NhanVienService;
import ViewsModels.NhanVienModel;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;

/**
 *
 * @author Bùi Công Minh
 */
public class FrameQLynhanvien extends javax.swing.JFrame {

    INhanVienService _inhanvienservice;
    DefaultTableModel _defaultTB;
    DefaultComboBoxModel _Combobox;
    List<NhanVien> _lstnv;
    SimpleDateFormat format_date = new SimpleDateFormat("yyyy-MM-dd");
    NhanVienService _nvsv;

    public FrameQLynhanvien() {
        initComponents();
        _inhanvienservice = new NhanVienService();
        txt_manv.setEditable(false);
        txt_manv.setText("NV" + _inhanvienservice.getMaxIdNhanVien());

        loadtable();
        btn();

    }

    NhanVienModel getdata() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        NhanVienModel nvmd = new NhanVienModel();
        nvmd.setMaNhanVien(txt_manv.getText());
        nvmd.setHoTen(txt_hoten.getText());
        nvmd.setNgaySinh(txt_ngaysinh.getDate());
        nvmd.setGioiTinh(rdb_nam.isSelected() ? true : false);

//        nvmd.setGioiTinh(rdb_nu.getText());
        nvmd.setSoDienThoai(txt_sdt.getText());
        nvmd.setEmail(txt_email.getText());
        nvmd.setDiaChi(txt_diachi.getText());
        nvmd.setCCCD(txt_cccd.getText());
        nvmd.setChucVu((String) cbc_chucvu.getSelectedItem());
        nvmd.setTrangThai((String) cbc_trangthai.getSelectedItem());
        nvmd.setMatKhau(txt_matkhau.getText());
        return nvmd;
    }

    public void loadtable() {
        List<NhanVienModel> nvmd = _inhanvienservice.getproduct();
        _defaultTB = (DefaultTableModel) tbl_nhanvien.getModel();
        _defaultTB.setRowCount(0);
        for (NhanVienModel x : nvmd) {
            _defaultTB.addRow(new Object[]{x.getMaNhanVien(), x.getHoTen(), x.getNgaySinh(), x.isGioiTinh() == true ? "Nam" : "Nữ", x.getSoDienThoai(), x.getEmail(), x.getDiaChi(), x.getCCCD(), x.getChucVu(), x.getTrangThai(), x.getMatKhau()});
        }
    }

    void btn() {
        ButtonGroup btn = new ButtonGroup();
        btn.add(rdb_nam);
        btn.add(rdb_nu);
        rdb_nam.setSelected(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_nhanvien = new javax.swing.JTable();
        txt_timkiem = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txt_manv = new javax.swing.JTextField();
        txt_hoten = new javax.swing.JTextField();
        txt_sdt = new javax.swing.JTextField();
        txt_email = new javax.swing.JTextField();
        txt_diachi = new javax.swing.JTextField();
        txt_cccd = new javax.swing.JTextField();
        cbc_chucvu = new javax.swing.JComboBox<>();
        btn_them = new javax.swing.JButton();
        btn_sua = new javax.swing.JButton();
        btn_moi = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        txt_matkhau = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        cbc_trangthai = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        txt_ngaysinh = new com.toedter.calendar.JDateChooser();
        rdb_nu = new javax.swing.JRadioButton();
        rdb_nam = new javax.swing.JRadioButton();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Quản lý nhân viên");

        jPanel1.setBackground(new java.awt.Color(102, 255, 255));

        tbl_nhanvien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã NV", "Họ Và Tên", "Ngày Sinh", "Giới tính", "SDT", "Email", "Địa chỉ", "CCCD", "Chức vụ", "Trạng Thái", "Mật Khẩu"
            }
        ));
        tbl_nhanvien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_nhanvienMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_nhanvien);

        txt_timkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_timkiemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1096, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txt_timkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 978, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt_timkiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 502, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(102, 255, 255));
        jPanel2.setForeground(new java.awt.Color(102, 255, 255));

        jLabel2.setText("Mã nhân viên");

        jLabel3.setText("Họ Tên ");

        jLabel5.setText("Giới tính");

        jLabel6.setText("SĐT");

        jLabel7.setText("Email");

        jLabel8.setText("CCCD");

        jLabel9.setText("Địa chỉ");

        jLabel10.setText("Chức vụ");

        txt_sdt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_sdtActionPerformed(evt);
            }
        });

        txt_email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_emailActionPerformed(evt);
            }
        });

        cbc_chucvu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Quản Lý", "Nhân Viên", " ", " " }));
        cbc_chucvu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbc_chucvuActionPerformed(evt);
            }
        });

        btn_them.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_them.setText("Thêm");
        btn_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themActionPerformed(evt);
            }
        });

        btn_sua.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_sua.setText("Sửa");
        btn_sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_suaActionPerformed(evt);
            }
        });

        btn_moi.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_moi.setText("Mới");
        btn_moi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_moiActionPerformed(evt);
            }
        });

        jLabel11.setText("Trạng Thái");

        jLabel12.setText("Mật Khẩu");

        cbc_trangthai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đang Làm Việc", "Đã Nghỉ Việc", " ", " " }));
        cbc_trangthai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbc_trangthaiActionPerformed(evt);
            }
        });

        jLabel13.setText("Ngày Sinh");

        txt_ngaysinh.setDateFormatString("yyyy-MM-dd");

        buttonGroup1.add(rdb_nu);
        rdb_nu.setText("Nữ");

        buttonGroup1.add(rdb_nam);
        rdb_nam.setText("Nam");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel9))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(btn_them, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(btn_sua, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                                .addComponent(btn_moi, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                                        .addGap(7, 7, 7)
                                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(jLabel5)
                                                            .addComponent(jLabel6)
                                                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(jLabel3)))
                                                    .addComponent(jLabel10))
                                                .addGap(26, 26, 26))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jLabel11)
                                                    .addComponent(jLabel12)
                                                    .addComponent(jLabel13))
                                                .addGap(18, 18, 18)))
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(cbc_trangthai, javax.swing.GroupLayout.Alignment.TRAILING, 0, 199, Short.MAX_VALUE)
                                            .addComponent(cbc_chucvu, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txt_cccd, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txt_diachi, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txt_email, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txt_sdt, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txt_matkhau)
                                            .addComponent(txt_hoten)
                                            .addComponent(txt_ngaysinh, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                .addComponent(rdb_nam, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(rdb_nu, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addComponent(jLabel8)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txt_manv)))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_manv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_hoten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(rdb_nu)
                    .addComponent(rdb_nam))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txt_sdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_diachi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_cccd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(cbc_chucvu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbc_trangthai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txt_matkhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_ngaysinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_them)
                    .addComponent(btn_sua)
                    .addComponent(btn_moi))
                .addGap(33, 33, 33))
        );

        jButton6.setBackground(new java.awt.Color(255, 51, 102));
        jButton6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton6.setText("HOME");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(549, 549, 549)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButton6))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_suaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suaActionPerformed
        try {
            System.out.println(getdata().toString());
            try {
                if (txt_hoten.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Không được để trống tên");
                    return;
                }

                if (_inhanvienservice.sua(getdata()) != null) {
                    JOptionPane.showMessageDialog(this, "Sửa Thành Công ");
                }
                loadtable();  // TODO add your handling code here:
            } catch (ParseException ex) {
                Logger.getLogger(FrameQLynhanvien.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ParseException ex) {
            Logger.getLogger(FrameQLynhanvien.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_suaActionPerformed

    private void txt_sdtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_sdtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_sdtActionPerformed

    private void txt_emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_emailActionPerformed

    private void cbc_chucvuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbc_chucvuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbc_chucvuActionPerformed

    private void cbc_trangthaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbc_trangthaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbc_trangthaiActionPerformed

    private void btn_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themActionPerformed
        try {
            System.out.println(getdata().toString());
        } catch (ParseException ex) {
            Logger.getLogger(FrameQLynhanvien.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            if (txt_hoten.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Không được để trống tên");
                return;
            }
            NhanVienModel nv = getdata();
            if (_inhanvienservice.createNewProduct(getdata()) != null) {
                JOptionPane.showMessageDialog(this, "Thêm thành công");
            } else {
                JOptionPane.showMessageDialog(this, "Không thêm được");
            }
            loadtable();
            // TODO add your handling code here:
        } catch (ParseException ex) {
            Logger.getLogger(FrameQLynhanvien.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btn_themActionPerformed

    private void tbl_nhanvienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_nhanvienMouseClicked
        try {
            int row = tbl_nhanvien.getSelectedRow();
            txt_manv.setText(tbl_nhanvien.getValueAt(row, 0).toString());
            txt_hoten.setText(tbl_nhanvien.getValueAt(row, 1).toString());
            txt_ngaysinh.setDate(format_date.parse(tbl_nhanvien.getValueAt(row, 2).toString()));
            rdb_nam.setSelected(true);
            if (tbl_nhanvien.getModel().getValueAt(row, 3).toString().equals("Nữ")) {
                rdb_nu.setSelected(true);
            }
//          rdb_nam.setSelected(_lstnv.get(row).getGioiTinh().equals("Nam") ? true : false);
//            rdb_nu.setSelected(_lstnv.get(row).getGioiTinh().equals("Nữ") ? true : false);
            txt_sdt.setText(tbl_nhanvien.getValueAt(row, 4).toString());
            txt_email.setText(tbl_nhanvien.getValueAt(row, 5).toString());
            txt_diachi.setText(tbl_nhanvien.getValueAt(row, 6).toString());
            txt_cccd.setText(tbl_nhanvien.getValueAt(row, 7).toString());
            cbc_chucvu.setSelectedItem(tbl_nhanvien.getValueAt(row, 8).toString());
            cbc_trangthai.setSelectedItem(tbl_nhanvien.getValueAt(row, 9).toString());
            txt_matkhau.setText(tbl_nhanvien.getValueAt(row, 10).toString());
            // TODO add your handling code here:
        } catch (ParseException ex) {
            Logger.getLogger(FrameQLynhanvien.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tbl_nhanvienMouseClicked

    private void btn_moiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_moiActionPerformed
        txt_manv.setText("NV" + _inhanvienservice.getMaxIdNhanVien());
        txt_hoten.setText("");
        txt_cccd.setText("");
        txt_diachi.setText("");
        txt_email.setText("");
        txt_matkhau.setText("");
        txt_sdt.setText("");

// TODO add your handling code here:
    }//GEN-LAST:event_btn_moiActionPerformed

    private void txt_timkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_timkiemActionPerformed

        //  loadtable(_nvsv.getListByHoTen(txt_timkiem.getText()));// TODO add your handling code here:
    }//GEN-LAST:event_txt_timkiemActionPerformed

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
            java.util.logging.Logger.getLogger(FrameQLynhanvien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameQLynhanvien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameQLynhanvien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameQLynhanvien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameQLynhanvien().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_moi;
    private javax.swing.JButton btn_sua;
    private javax.swing.JButton btn_them;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbc_chucvu;
    private javax.swing.JComboBox<String> cbc_trangthai;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdb_nam;
    private javax.swing.JRadioButton rdb_nu;
    private javax.swing.JTable tbl_nhanvien;
    private javax.swing.JTextField txt_cccd;
    private javax.swing.JTextField txt_diachi;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_hoten;
    private javax.swing.JTextField txt_manv;
    private javax.swing.JTextField txt_matkhau;
    private com.toedter.calendar.JDateChooser txt_ngaysinh;
    private javax.swing.JTextField txt_sdt;
    private javax.swing.JTextField txt_timkiem;
    // End of variables declaration//GEN-END:variables
}
