/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package JpanelForm;

import Services.IManagerKhachHangService;
import Services.ManagerKhachHangServicr;
import Utils.CheckData;
import ViewsModels.KhachHangModel;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author dytc0
 */
public class QLKhachHangPanel extends javax.swing.JPanel {

    private final IManagerKhachHangService _iManageKhachHang;
    private int _currentPage;
    private int _totalPages;
    private final int _pageSize;
    private long _totalProducts;
    int row = 0;
    CheckData _check;

    /**
     * Creates new form QLKhachHangForm
     */
    public QLKhachHangPanel() {
        initComponents();
        _iManageKhachHang = new ManagerKhachHangServicr();
        _currentPage = 1;
        _pageSize = 10;
        LoadDataTable(_iManageKhachHang.getKhachHang(_currentPage - 1, _pageSize));
//        txt_Ma.setText("KH" + String.valueOf(_iManageKhachHang.getmaKH()));
        txt_Ma.setEnabled(false);
        find();
    }

    private void LoadDataTable(List<KhachHangModel> lstKH) {
        List<KhachHangModel> KHmodel = _iManageKhachHang.getKhachHang(_currentPage - 1, _pageSize);
        DefaultTableModel dtm = (DefaultTableModel) this.tbl_khachhang.getModel();
        dtm.setRowCount(0);
        for (KhachHangModel d : KHmodel) {
            Object[] rowdata = {d.getMaKhachHang(), d.getHoTen(),  d.getSoDienThoai(), d.getDiaChi(),d.getEmail()};
            dtm.addRow(rowdata);

        }
    }

    private void find() {
        DefaultTableModel dtm = (DefaultTableModel) this.tbl_khachhang.getModel();
        dtm.setRowCount(0);
        try {
            String key = txt_timkiem.getText();

            List<KhachHangModel> timkiem = _iManageKhachHang.TimKiem(key);
            for (KhachHangModel d : timkiem) {
                Object[] rowdata = {d.getMaKhachHang(), d.getHoTen(), d.getEmail(), d.getSoDienThoai(), d.getDiaChi()};
                dtm.addRow(rowdata);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi tìm kiếm");
        }
    }

    KhachHangModel getdata() {
        return new KhachHangModel(Integer.parseInt(txt_Ma.getText()), txt_ten.getText(), txt_diachi.getText(), txt_email.getText(), txt_SDT.getText(),0);
    }

    private KhachHangModel getKhachHangFromInput() {
        KhachHangModel khachhangs = new KhachHangModel();

        String Hoten = txt_ten.getText();
        khachhangs.setHoTen(Hoten);
        String DiaChi = txt_diachi.getText();
        khachhangs.setDiaChi(DiaChi);
        String Email = txt_email.getText();
        khachhangs.setEmail(Email);
        String SDt = txt_SDT.getText();
        khachhangs.setSoDienThoai(SDt);
        return khachhangs;
    }

    private String getKHSelectRow() {
        int selectRowIndex = tbl_khachhang.getSelectedRow();
        return String.valueOf(tbl_khachhang.getValueAt(selectRowIndex, 0).toString());
    }

    boolean flag = false;

    boolean check() {
        if (txt_ten.getText().length() < 3) {
            if (txt_ten.getText().length() == 0) {
                JOptionPane.showMessageDialog(this, "Tên không được để trống");
                return false;

            } else if (txt_ten.getText().length() > 0 && txt_ten.getText().length() < 10) {
                JOptionPane.showMessageDialog(this, "Tên phải lớn hơn 5 ký tự");
                return false;

            }

        } else if (txt_SDT.getText().length() < 10) {

            if (txt_SDT.getText().length() == 0) {
                JOptionPane.showMessageDialog(this, "SDT không được để trống");
                return false;
            } else if (txt_SDT.getText().length() > 0 && txt_SDT.getText().length() < 10) {
                JOptionPane.showMessageDialog(this, "SDT phải là 10 số");
                return false;
            } else if (!txt_SDT.getText().matches("0\\d{2}\\d{2}\\d{5}")) {
                JOptionPane.showMessageDialog(this, "số điện thoại phải đúng định dạng");
                return false;
            }

        } else if (txt_email.getText().length() < 5) {
            if (txt_email.getText().length() == 0) {
                JOptionPane.showMessageDialog(this, "email không được để trống");
                return false;
            } else if (!txt_email.getText().matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
                JOptionPane.showMessageDialog(this, "Email phải đúng định dạng ");
                return false;

            }

        } else if (txt_diachi.getText().length() < 3) {
            if (txt_diachi.getText().length() == 0) {
                JOptionPane.showMessageDialog(this, "Địa chỉ không được để trống !");
                return false;
            }

        }
        return true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_tim = new javax.swing.JButton();
        txt_timkiem = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_khachhang = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_Ma = new javax.swing.JTextField();
        txt_ten = new javax.swing.JTextField();
        txt_email = new javax.swing.JTextField();
        txt_SDT = new javax.swing.JTextField();
        txt_diachi = new javax.swing.JTextField();
        btn_them = new javax.swing.JButton();
        btn_sua = new javax.swing.JButton();
        btn_clear = new javax.swing.JButton();
        btn_load = new javax.swing.JButton();

        btn_tim.setText("Tìm");
        btn_tim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_timActionPerformed(evt);
            }
        });

        txt_timkiem.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txt_timkiemCaretUpdate(evt);
            }
        });
        txt_timkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_timkiemActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(153, 255, 255));

        tbl_khachhang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã khách hàng", "Tên khách hàng", "EMAIL", "SDT", "Địa chỉ"
            }
        ));
        tbl_khachhang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_khachhangMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_khachhang);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 556, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(153, 255, 255));

        jLabel2.setText("Mã khách hàng");

        jLabel3.setText("Tên khách hàng");

        jLabel4.setText("Email");

        jLabel5.setText("Địa chỉ");

        jLabel6.setText("SDT");

        txt_Ma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_MaActionPerformed(evt);
            }
        });

        txt_ten.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_tenActionPerformed(evt);
            }
        });

        txt_email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_emailActionPerformed(evt);
            }
        });

        txt_SDT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_SDTActionPerformed(evt);
            }
        });

        txt_diachi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_diachiActionPerformed(evt);
            }
        });

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

        btn_load.setText("Load");
        btn_load.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_loadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_Ma))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_diachi))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_ten))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_email))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_SDT))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btn_load)
                            .addComponent(btn_them))
                        .addGap(18, 18, 18)
                        .addComponent(btn_sua)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                        .addComponent(btn_clear)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_Ma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_ten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txt_SDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_diachi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_them)
                    .addComponent(btn_sua)
                    .addComponent(btn_clear))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_load)
                .addContainerGap(61, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_tim)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_timkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_timkiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_tim))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_timActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_timActionPerformed
        find();
    }//GEN-LAST:event_btn_timActionPerformed

    private void txt_timkiemCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txt_timkiemCaretUpdate
        //        if (txt_timkiem.getText().isBlank()) {
        //        LoadDataTable(_iManageKhachHang.getKhachHang(_currentPage - 1, _pageSize));
        //            return;
        //        }
        //        List<KhachHangModel> lstTemp=new ArrayList<>();
        //        if (rbo_ten.isSelected()) {
        //            for (KhachHangModel x : _iManageKhachHang.getKhachHang(_currentPage - 1, _pageSize)) {
        //                if (_iManageKhachHang.timKiem2(x.getHoTen(),txt_timkiem.getText())) {
        //                    lstTemp.add(x);
        //                }
        //            }
        //
        //        }
        //        if (rbo_email.isSelected()) {
        //             for (KhachHangModel x : _iManageKhachHang.getKhachHang(_currentPage - 1, _pageSize)) {
        //                if (_iManageKhachHang.timKiem2(x.getEmail(),txt_timkiem.getText())) {
        //                    lstTemp.add(x);
        //                }
        //            }
        //
        //        }
        //         if (rbo_sdt.isSelected()) {
        //             for (KhachHangModel x : _iManageKhachHang.getKhachHang(_currentPage - 1, _pageSize)) {
        //                if (_iManageKhachHang.timKiem2(x.getSoDienThoai(),txt_timkiem.getText())) {
        //                    lstTemp.add(x);
        //                }
        //            }
        //
        //        }
        //         LoadDataTable(lstTemp);
    }//GEN-LAST:event_txt_timkiemCaretUpdate

    private void txt_timkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_timkiemActionPerformed

    }//GEN-LAST:event_txt_timkiemActionPerformed

    private void tbl_khachhangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_khachhangMouseClicked
        int row = tbl_khachhang.getSelectedRow();
        if (row == -1) {
            return;
        }
        String maKh = this.tbl_khachhang.getValueAt(row, 0).toString();
        String HoTen = this.tbl_khachhang.getValueAt(row, 1).toString();
        String DiaChi = this.tbl_khachhang.getValueAt(row, 4).toString();
        String Email = this.tbl_khachhang.getValueAt(row, 2).toString();
        String Sdt = this.tbl_khachhang.getValueAt(row, 3).toString();

        this.txt_Ma.setText(maKh);
        this.txt_ten.setText(HoTen);
        this.txt_diachi.setText(DiaChi);
        this.txt_email.setText(Email);
        this.txt_SDT.setText(Sdt);
    }//GEN-LAST:event_tbl_khachhangMouseClicked

    private void txt_MaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_MaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_MaActionPerformed

    private void txt_tenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_tenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_tenActionPerformed

    private void txt_emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_emailActionPerformed

    private void txt_SDTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_SDTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_SDTActionPerformed

    private void txt_diachiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_diachiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_diachiActionPerformed

    private void btn_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themActionPerformed

        if (check() == false) {
            return;
        }
        int xacnhan = JOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn thêm ?");
        if (xacnhan != JOptionPane.YES_OPTION) {
            return;
        }

        KhachHangModel newKH = getKhachHangFromInput();
        if (_iManageKhachHang.createNewKhachHang(newKH) != null) {

            JOptionPane.showMessageDialog(this, "Thêm thành công");
            return;

        } else {
            JOptionPane.showMessageDialog(this, "Thêm Thất bại !");

        }
        LoadDataTable(_iManageKhachHang.getKhachHang(_currentPage - 1, _pageSize));

    }//GEN-LAST:event_btn_themActionPerformed

    private void btn_suaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suaActionPerformed
        KhachHangModel updateKhachHang = getKhachHangFromInput();
        String updateKhBYid = getKHSelectRow();
        updateKhachHang.setMaKhachHang(Integer.parseInt(updateKhBYid));
        if (_iManageKhachHang.update(updateKhachHang) != null) {
            JOptionPane.showMessageDialog(this, "Thành công");
            return;
        } else {
            JOptionPane.showMessageDialog(this, "Thất bại");

        }
        LoadDataTable(_iManageKhachHang.getKhachHang(_currentPage - 1, _pageSize));

    }//GEN-LAST:event_btn_suaActionPerformed

    private void btn_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearActionPerformed
        this.txt_Ma.setText(String.valueOf(_iManageKhachHang.getmaKH()));
        this.txt_ten.setText("");
        this.txt_diachi.setText("");
        this.txt_email.setText("");
    }//GEN-LAST:event_btn_clearActionPerformed

    private void btn_loadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_loadActionPerformed

        LoadDataTable(_iManageKhachHang.getKhachHang(_currentPage - 1, _pageSize));
        this.txt_Ma.setText(String.valueOf(_iManageKhachHang.getmaKH()));
        this.txt_ten.setText("");
        this.txt_diachi.setText("");
        this.txt_email.setText("");
        this.txt_SDT.setText("");
    }//GEN-LAST:event_btn_loadActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_clear;
    private javax.swing.JButton btn_load;
    private javax.swing.JButton btn_sua;
    private javax.swing.JButton btn_them;
    private javax.swing.JButton btn_tim;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbl_khachhang;
    private javax.swing.JTextField txt_Ma;
    private javax.swing.JTextField txt_SDT;
    private javax.swing.JTextField txt_diachi;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_ten;
    private javax.swing.JTextField txt_timkiem;
    // End of variables declaration//GEN-END:variables
}
