/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Views;

import JpanelForm.QLBanHangPanel;
import JpanelForm.QLKhachHangPanel;
import JpanelForm.QLKhuyenMaiPanel;
import JpanelForm.QLNhanVienPanel;
import JpanelForm.QLSanPhamPanel;
import JpanelForm.ThongKeNVPanel;
import JpanelForm.ThongKeQLPanel;
import Utils.Auth;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author hieu
 */
public class MainTrue extends javax.swing.JFrame {

    /**
     * Creates new form MainTrue
     */
      void init() {
        new Timer(1000, new ActionListener() {
            SimpleDateFormat fomat = new SimpleDateFormat("hh:mm:ss a");
            @Override
            public void actionPerformed(ActionEvent e) {
                lbl_time.setText(fomat.format(new Date()));
            }
        }).start();
           
    }
    public MainTrue() {
        initComponents();
        setLocationRelativeTo(null);
        init();
    }

    public void show(JPanel j) {
        lbl_form.removeAll();
        lbl_form.add(j);
        lbl_form.validate();
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
        btn_thongke = new javax.swing.JButton();
        btn_sanpham = new javax.swing.JButton();
        btn_hoadon = new javax.swing.JButton();
        btn_nhanvien = new javax.swing.JButton();
        btn_khachhang = new javax.swing.JButton();
        btn_khuyenmai = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        lbl_time = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbl_form = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(245, 244, 244));

        jPanel1.setBackground(new java.awt.Color(0, 255, 255));

        btn_thongke.setBackground(new java.awt.Color(51, 255, 255));
        btn_thongke.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_thongke.setForeground(new java.awt.Color(255, 255, 255));
        btn_thongke.setText("Thống Kê");
        btn_thongke.setBorder(null);
        btn_thongke.setBorderPainted(false);
        btn_thongke.setContentAreaFilled(false);
        btn_thongke.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_thongkeActionPerformed(evt);
            }
        });

        btn_sanpham.setBackground(new java.awt.Color(51, 255, 255));
        btn_sanpham.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_sanpham.setForeground(new java.awt.Color(255, 255, 255));
        btn_sanpham.setText("Sản Phẩm");
        btn_sanpham.setBorder(null);
        btn_sanpham.setBorderPainted(false);
        btn_sanpham.setContentAreaFilled(false);
        btn_sanpham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_sanphamActionPerformed(evt);
            }
        });

        btn_hoadon.setBackground(new java.awt.Color(51, 255, 255));
        btn_hoadon.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_hoadon.setForeground(new java.awt.Color(255, 255, 255));
        btn_hoadon.setText("Hoá Đơn");
        btn_hoadon.setBorder(null);
        btn_hoadon.setBorderPainted(false);
        btn_hoadon.setContentAreaFilled(false);
        btn_hoadon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hoadonActionPerformed(evt);
            }
        });

        btn_nhanvien.setBackground(new java.awt.Color(51, 255, 255));
        btn_nhanvien.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_nhanvien.setForeground(new java.awt.Color(255, 255, 255));
        btn_nhanvien.setText("Nhân Viên");
        btn_nhanvien.setBorder(null);
        btn_nhanvien.setBorderPainted(false);
        btn_nhanvien.setContentAreaFilled(false);
        btn_nhanvien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nhanvienActionPerformed(evt);
            }
        });

        btn_khachhang.setBackground(new java.awt.Color(51, 255, 255));
        btn_khachhang.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_khachhang.setForeground(new java.awt.Color(255, 255, 255));
        btn_khachhang.setText("Khách Hàng");
        btn_khachhang.setBorder(null);
        btn_khachhang.setBorderPainted(false);
        btn_khachhang.setContentAreaFilled(false);
        btn_khachhang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_khachhangActionPerformed(evt);
            }
        });

        btn_khuyenmai.setBackground(new java.awt.Color(51, 255, 255));
        btn_khuyenmai.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_khuyenmai.setForeground(new java.awt.Color(255, 255, 255));
        btn_khuyenmai.setText("Khuyến Mãi");
        btn_khuyenmai.setBorder(null);
        btn_khuyenmai.setBorderPainted(false);
        btn_khuyenmai.setContentAreaFilled(false);
        btn_khuyenmai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_khuyenmaiActionPerformed(evt);
            }
        });

        jButton16.setBackground(new java.awt.Color(51, 255, 255));
        jButton16.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton16.setForeground(new java.awt.Color(255, 255, 255));
        jButton16.setText("Đăng Xuất");
        jButton16.setBorder(null);
        jButton16.setBorderPainted(false);
        jButton16.setContentAreaFilled(false);
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn_thongke, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btn_sanpham, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btn_hoadon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btn_nhanvien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btn_khachhang, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)
            .addComponent(btn_khuyenmai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(btn_thongke, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_sanpham, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_hoadon, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_nhanvien, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_khachhang, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_khuyenmai, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(182, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(0, 255, 255));
        jPanel2.setForeground(new java.awt.Color(153, 255, 255));

        lbl_time.setIcon(new javax.swing.ImageIcon("C:\\java3\\Edusys\\src\\icon\\Alarm.png")); // NOI18N
        lbl_time.setText("12:12:12 am");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(992, Short.MAX_VALUE)
                .addComponent(lbl_time, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(86, 86, 86))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_time)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(0, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Shop Bán Áo");

        jLabel2.setText("Hình ảnh");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        lbl_form.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbl_form, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_form, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_thongkeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_thongkeActionPerformed
        if (Auth.isManager().equals("Nhân Viên")) {
            show(new ThongKeNVPanel());
        }
        else{
            show(new ThongKeQLPanel());
        }
    }//GEN-LAST:event_btn_thongkeActionPerformed

    private void btn_sanphamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sanphamActionPerformed
//        if (Auth.isManager().equals("Quản Lý")) {
//            show(new QLSanPhamPanel());
//        } else {
//            JOptionPane.showMessageDialog(this, "Ban phai la quan ly de dung cn nay");
//        }
        show(new QLSanPhamPanel());

// TODO add your handling code here:
    }//GEN-LAST:event_btn_sanphamActionPerformed

    private void btn_hoadonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hoadonActionPerformed
        show(new QLBanHangPanel());
    }//GEN-LAST:event_btn_hoadonActionPerformed

    private void btn_nhanvienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nhanvienActionPerformed
        try {
            if (Auth.isManager().equals("Quản Lý")) {
                show(new QLNhanVienPanel());
            } else {
                JOptionPane.showMessageDialog(this, "Ban phai la quan ly de dung cn nay");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "khong");
        }
// TODO add your handling code here:
    }//GEN-LAST:event_btn_nhanvienActionPerformed

    private void btn_khachhangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_khachhangActionPerformed
//        if (Auth.isManager().equals("Quản Lý")) {
//            show(new QLNhanVienPanel());
//        } else {
//            JOptionPane.showMessageDialog(this, "Ban phai la quan ly de dung cn nay");
//        }
        show(new QLKhachHangPanel());
    }//GEN-LAST:event_btn_khachhangActionPerformed

    private void btn_khuyenmaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_khuyenmaiActionPerformed

        show(new QLKhuyenMaiPanel());
    }//GEN-LAST:event_btn_khuyenmaiActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        new FrameLogin().setVisible(true);
        dispose();// TODO add your handling code here:
    }//GEN-LAST:event_jButton16ActionPerformed

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
            java.util.logging.Logger.getLogger(MainTrue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainTrue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainTrue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainTrue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainTrue().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_hoadon;
    private javax.swing.JButton btn_khachhang;
    private javax.swing.JButton btn_khuyenmai;
    private javax.swing.JButton btn_nhanvien;
    private javax.swing.JButton btn_sanpham;
    private javax.swing.JButton btn_thongke;
    private javax.swing.JButton jButton16;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel lbl_form;
    private javax.swing.JLabel lbl_time;
    // End of variables declaration//GEN-END:variables

}
