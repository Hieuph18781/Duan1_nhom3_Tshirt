/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Views;

import DomainModels.KhuyenMai;
import Services.IKhuyenMaiService;
import Services.KhuyenMaiService;
import Utils.CheckData;
import ViewsModels.KhuyenMaiModel;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Nguyen Van Thuan
 */
public class FarmeQLKhuyenMai extends javax.swing.JFrame {

    IKhuyenMaiService _IKhuyenMaiService;
    CheckData _check;
    List<KhuyenMaiModel> _lstKhuyenMaiModel;

    public FarmeQLKhuyenMai() {
        initComponents();
        _IKhuyenMaiService = new KhuyenMaiService();
        _lstKhuyenMaiModel = new ArrayList<>();
        _check = new CheckData();
        
        SimpleDateFormat date = new SimpleDateFormat();
        loadtable(_IKhuyenMaiService.getListFromDB());
        txt_makm.setText("KM" + String.valueOf(_IKhuyenMaiService.getMaDanhMuc()));
        //txt_giakm.setText(String.valueOf(txt_giakm.getText()) + "%");
        txt_makm.setEnabled(false);
        

    }

    KhuyenMaiModel getdata() {
        return new KhuyenMaiModel(Integer.parseInt(txt_makm.getText().substring(2)), txt_tenkm.getText(), dc_ngaybatdau.getDate(), dc_ngaykt.getDate(), Integer.parseInt(txt_giakm.getText()), txt_mota.getText());
    }

    public void loadtable(List<KhuyenMaiModel> ks) {
        DefaultTableModel _DefaultTableModel = new DefaultTableModel();
        _DefaultTableModel = (DefaultTableModel) tbl_khuyenmai.getModel();
        _DefaultTableModel.setRowCount(0);
        int stt = 1;
        for (KhuyenMaiModel x : ks) {
            _DefaultTableModel.addRow(new Object[]{stt++, "KM" + x.getIdKhuyenMai(), x.getTenKhuyenMai(), x.getNgayBatDau(), x.getNgayKetThuc(), x.getGiaKhuyenMai() , x.getMoTa()});
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
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_tenkm = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_makm = new javax.swing.JTextField();
        txt_giakm = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_mota = new javax.swing.JTextArea();
        btn_them = new javax.swing.JButton();
        btn_sua = new javax.swing.JButton();
        btn_clear = new javax.swing.JButton();
        dc_ngaybatdau = new com.toedter.calendar.JDateChooser();
        dc_ngaykt = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_khuyenmai = new javax.swing.JTable();
        txt_timkieems = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản Lý Khuyễn Mãi");
        setLocationByPlatform(true);

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1140, 620));

        jButton1.setText("HOME");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(204, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 102), 2), "Thông Tin Khuyến Mãi", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(51, 51, 51))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Mã Khuyến Mãi :");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Tên Khuyến Mãi :");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Ngày bắt đầu :");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Ngày kết thúc :");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Giá Khuyến mãi :");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Mô tả :");

        txt_mota.setColumns(20);
        txt_mota.setRows(5);
        jScrollPane1.setViewportView(txt_mota);

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

        dc_ngaybatdau.setDateFormatString("yyyy-MM-dd");

        dc_ngaykt.setDateFormatString("yyyy-MM-dd");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("%");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txt_makm, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(30, 30, 30))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(dc_ngaykt, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                            .addComponent(dc_ngaybatdau, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txt_tenkm)
                                .addContainerGap())))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(btn_them)
                        .addGap(64, 64, 64)
                        .addComponent(btn_sua)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                        .addComponent(btn_clear))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jLabel6)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txt_giakm, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel8)))))
                .addContainerGap(80, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_makm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_tenkm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(dc_ngaybatdau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(dc_ngaykt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_giakm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(39, 39, 39)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_clear)
                    .addComponent(btn_sua)
                    .addComponent(btn_them))
                .addGap(52, 52, 52))
        );

        jPanel3.setBackground(new java.awt.Color(204, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "Danh Sách Khuyến Mãi", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(51, 51, 51))); // NOI18N
        jPanel3.setPreferredSize(new java.awt.Dimension(719, 719));

        tbl_khuyenmai.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã Khuyễn Mãi", "Tên Khuyễn Mãi", "Ngày bắt đầu", "Ngày kết thúc", "Giá Khuyễn Mãi", "Mô tả"
            }
        ));
        tbl_khuyenmai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_khuyenmaiMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_khuyenmai);
        if (tbl_khuyenmai.getColumnModel().getColumnCount() > 0) {
            tbl_khuyenmai.getColumnModel().getColumn(5).setResizable(false);
        }

        txt_timkieems.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txt_timkieemsCaretUpdate(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Tìm kiếm:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 694, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(44, 44, 44)
                        .addComponent(txt_timkieems, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_timkieems, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 487, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 743, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 568, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1154, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themActionPerformed
        if (!_check.checkso(txt_giakm.getText())) {
            JOptionPane.showMessageDialog(this, "không nhập chữ");
            return;
        }
        if (Integer.parseInt(txt_giakm.getText()) > 100) {
            JOptionPane.showMessageDialog(this, "không nhập qua 100%");
            return;
        }
        if (_check.checkNullString(txt_tenkm.getText()) || _check.checkNullString(txt_giakm.getText())
                 || _check.checkNullString(dc_ngaybatdau.getDateFormatString())
                || _check.checkNullString(dc_ngaykt.getDateFormatString())) {
            JOptionPane.showMessageDialog(this, "Không được để trống");
            return;
        }
        SimpleDateFormat date = new SimpleDateFormat("yyyy-mm-dd");

        if (dc_ngaybatdau.getDate().after(dc_ngaykt.getDate())) {
            JOptionPane.showMessageDialog(this, "ngày bắt đầu phải bé hơn ngày kết thúc");
            return;
        }
        
        int xacnhan = JOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn thêm ?");
        if (xacnhan != JOptionPane.YES_OPTION) {
            return;
        }
        JOptionPane.showMessageDialog(this, _IKhuyenMaiService.them(getdata()));
        loadtable(_IKhuyenMaiService.getListFromDB());
    }//GEN-LAST:event_btn_themActionPerformed

    private void btn_suaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suaActionPerformed
        if (_check.checkNullString(txt_tenkm.getText()) || _check.checkNullString(txt_giakm.getText())
                 || _check.checkNullString(dc_ngaybatdau.getDateFormatString())
                || _check.checkNullString(dc_ngaykt.getDateFormatString())) {
            JOptionPane.showMessageDialog(this, "Không được để trống Tên");
            return;
        }
        if (Integer.parseInt(txt_giakm.getText()) > 100) {
            JOptionPane.showMessageDialog(this, "không nhập qua 100%");
            return;
        }
        if (!_check.checkso(txt_giakm.getText())) {
            JOptionPane.showMessageDialog(this, "không nhập chữ");
            return;
        }
        if (dc_ngaybatdau.getDate().after(dc_ngaykt.getDate())) {
            JOptionPane.showMessageDialog(this, "ngày bắt đầu phải bé hơn ngày kết thúc");
            return;
        }
        int xacnhan = JOptionPane.showConfirmDialog(this, "Bạn có muốn thay đổi không?");
        if (xacnhan != JOptionPane.YES_OPTION) {
            return;
        }
        JOptionPane.showMessageDialog(this, _IKhuyenMaiService.sua(getdata()));
        loadtable(_IKhuyenMaiService.getListFromDB());
    }//GEN-LAST:event_btn_suaActionPerformed

    private void tbl_khuyenmaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_khuyenmaiMouseClicked
        int row = tbl_khuyenmai.getSelectedRow();
        txt_makm.setText(tbl_khuyenmai.getValueAt(row, 1).toString());
        txt_tenkm.setText(tbl_khuyenmai.getValueAt(row, 2).toString());
        txt_mota.setText(tbl_khuyenmai.getValueAt(row, 6).toString());
        txt_giakm.setText(tbl_khuyenmai.getValueAt(row, 5).toString());
        dc_ngaybatdau.setDate((Date) tbl_khuyenmai.getValueAt(row, 3));
        dc_ngaykt.setDate((Date) tbl_khuyenmai.getValueAt(row, 4));
    }//GEN-LAST:event_tbl_khuyenmaiMouseClicked

    private void btn_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearActionPerformed
        txt_makm.setText("KM" + String.valueOf(_IKhuyenMaiService.getMaDanhMuc()));
        txt_tenkm.setText("");
        txt_mota.setText("");
        txt_giakm.setText("");

    }//GEN-LAST:event_btn_clearActionPerformed

    private void txt_timkieemsCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txt_timkieemsCaretUpdate
        loadtable(_IKhuyenMaiService.findDanhMucSp(txt_timkieems.getText()));
    }//GEN-LAST:event_txt_timkieemsCaretUpdate

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      new MainTrue().setVisible(true); 
      dispose();// TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(FarmeQLKhuyenMai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FarmeQLKhuyenMai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FarmeQLKhuyenMai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FarmeQLKhuyenMai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FarmeQLKhuyenMai().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_clear;
    private javax.swing.JButton btn_sua;
    private javax.swing.JButton btn_them;
    private com.toedter.calendar.JDateChooser dc_ngaybatdau;
    private com.toedter.calendar.JDateChooser dc_ngaykt;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbl_khuyenmai;
    private javax.swing.JTextField txt_giakm;
    private javax.swing.JTextField txt_makm;
    private javax.swing.JTextArea txt_mota;
    private javax.swing.JTextField txt_tenkm;
    private javax.swing.JTextField txt_timkieems;
    // End of variables declaration//GEN-END:variables
}
