/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Views;

import DomainModels.KieuDang;
import Services.IKieuDangService;
import Services.KieuDangService;
import ViewsModels.KieuDangModel;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hieu
 */
public class FarmeQLKieuDang extends javax.swing.JFrame {

    IKieuDangService _ikieudangService;
    KieuDangService _kieudangsevice;
    DefaultTableModel _default;
    ArrayList<KieuDang> _lstkd;
String đuongang="C:\\Users\\Dell\\Documents\\GitHub\\Duan1_nhom3_Tshirt\\Duan1_nhom3_Tshirt\\QuanLySanPham\\src\\main\\java\\img";
int vitri=-1;

    /**
     * Creates new form
     */
    public FarmeQLKieuDang() {
        initComponents();
        _ikieudangService = new KieuDangService();
        _lstkd=new ArrayList<>();
        txt_makieudang.setEnabled(false);
        loadtable();
        txt_makieudang.setText("KD" + _ikieudangService.getMaxIdKieuDang());
       
    }

    KieuDangModel getdata() {
        return new KieuDangModel(Integer.parseInt(txt_makieudang.getText().substring(2)), txt_tenkieudang.getText(),txt_mota.getText(),lbl_hinhanh.getText());
    }

    public void loadtable() {
        List<KieuDangModel> kd = _ikieudangService.getproduct();
        _default = (DefaultTableModel) tbl_kieudang.getModel();
        _default.setRowCount(0);
        for (KieuDangModel x : kd) {
            _default.addRow(new Object[]{"KD" +x.getMaKieuDang(), x.getTenKieuDang(), x.getMota()});
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btn_them = new javax.swing.JButton();
        btn_sua = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txt_makieudang = new javax.swing.JTextField();
        txt_tenkieudang = new javax.swing.JTextField();
        txt_mota = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_kieudang = new javax.swing.JTable();
        btn_clear = new javax.swing.JButton();
        btn_hinhanh = new javax.swing.JButton();
        txt_timkiem = new javax.swing.JTextField();
        btn_timkiem = new javax.swing.JButton();
        lbl_hinhanh = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Thông Tin Kiểu dáng");

        jLabel2.setText("Mã kiểu dáng");

        jLabel3.setText("Tên kiểu dáng");

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

        jLabel4.setText("Mô tả");

        tbl_kieudang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Mã kiểu dáng", "Tên kiểu dáng", "Mô tả"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_kieudang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_kieudangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_kieudang);
        if (tbl_kieudang.getColumnModel().getColumnCount() > 0) {
            tbl_kieudang.getColumnModel().getColumn(0).setResizable(false);
            tbl_kieudang.getColumnModel().getColumn(1).setResizable(false);
            tbl_kieudang.getColumnModel().getColumn(2).setResizable(false);
        }

        btn_clear.setText("Clear");
        btn_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clearActionPerformed(evt);
            }
        });

        btn_hinhanh.setBackground(new java.awt.Color(204, 255, 255));
        btn_hinhanh.setText("Chọn Ảnh");
        btn_hinhanh.setSelected(true);
        btn_hinhanh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hinhanhActionPerformed(evt);
            }
        });

        btn_timkiem.setText("Tìm kiếm theo kí tự của tên");
        btn_timkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_timkiemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addComponent(btn_hinhanh))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addComponent(jLabel1))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(btn_them)
                        .addGap(39, 39, 39)
                        .addComponent(btn_sua)
                        .addGap(75, 75, 75)
                        .addComponent(btn_clear))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_makieudang, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_mota, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_tenkieudang, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(lbl_hinhanh, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(txt_timkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_timkiem)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_timkiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_timkiem))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txt_makieudang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txt_tenkieudang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_mota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(53, 53, 53)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_them)
                            .addComponent(btn_sua)
                            .addComponent(btn_clear))
                        .addGap(18, 18, 18)
                        .addComponent(lbl_hinhanh, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_hinhanh)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themActionPerformed
        if (txt_tenkieudang.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không được để trống tên");
            return;
        }
        KieuDangModel kdmoi = getdata();
        if (_ikieudangService.createNewProduct(getdata()) != null) {
            JOptionPane.showMessageDialog(this, "Thêm thành công");
        } else {
            JOptionPane.showMessageDialog(this, "Không thêm được");
        }
        loadtable();
    }//GEN-LAST:event_btn_themActionPerformed
public ImageIcon ReziseIcon(String imgpath){
    ImageIcon MyIcon= new ImageIcon(imgpath);
    Image imgg=MyIcon.getImage();
    Image newimg=imgg.getScaledInstance(lbl_hinhanh.getWidth(), lbl_hinhanh.getHeight(), Image.SCALE_SMOOTH);
    ImageIcon image=new ImageIcon(newimg);
    return image;
}
    private void tbl_kieudangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_kieudangMouseClicked
        int row = tbl_kieudang.getSelectedRow();
        txt_makieudang.setText(tbl_kieudang.getValueAt(row, 0).toString());
        txt_tenkieudang.setText(tbl_kieudang.getValueAt(row, 1).toString());
        txt_mota.setText(tbl_kieudang.getValueAt(row, 2).toString());
        lbl_hinhanh.setIcon(ReziseIcon(String.valueOf(_lstkd.get(vitri).getHinhAnh())));
      //  txt_makieudang.setEnabled(false);
    }//GEN-LAST:event_tbl_kieudangMouseClicked

    private void btn_suaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suaActionPerformed

        if (txt_tenkieudang.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Không được để trống tên");
            return;
        }

        if (_ikieudangService.sua(getdata()) != null) {
            JOptionPane.showMessageDialog(this, "Sửa Thành Công ");
        }
        loadtable();
    }//GEN-LAST:event_btn_suaActionPerformed

    private void btn_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearActionPerformed
        txt_makieudang.setText("KD" + _ikieudangService.getMaxIdKieuDang());
        txt_tenkieudang.setText("");
        txt_mota.setText("");
        //lbl_hinhanh.setText("");
    }//GEN-LAST:event_btn_clearActionPerformed

    private void btn_hinhanhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hinhanhActionPerformed
        JFileChooser jf=new JFileChooser("C:\\Users\\Dell\\Documents\\GitHub\\Duan1_nhom3_Tshirt\\Duan1_nhom3_Tshirt\\QuanLySanPham\\src\\main\\java\\img");
        jf.showOpenDialog(null);
        File file=jf.getSelectedFile();
        if (file.getAbsoluteFile()!=null) {
          lbl_hinhanh.setIcon(ReziseIcon(String.valueOf(đuongang)));
        }else{
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn ảnh");
        }
// TODO add your handling code here:
    }//GEN-LAST:event_btn_hinhanhActionPerformed

    private void btn_timkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_timkiemActionPerformed
      _kieudangsevice.findKieuDang(txt_timkiem.getText());
      loadtable();
              
               
            
           
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_timkiemActionPerformed

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
            java.util.logging.Logger.getLogger(FarmeQLKieuDang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FarmeQLKieuDang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FarmeQLKieuDang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FarmeQLKieuDang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FarmeQLKieuDang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_clear;
    private javax.swing.JButton btn_hinhanh;
    private javax.swing.JButton btn_sua;
    private javax.swing.JButton btn_them;
    private javax.swing.JButton btn_timkiem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_hinhanh;
    private javax.swing.JTable tbl_kieudang;
    private javax.swing.JTextField txt_makieudang;
    private javax.swing.JTextField txt_mota;
    private javax.swing.JTextField txt_tenkieudang;
    private javax.swing.JTextField txt_timkiem;
    // End of variables declaration//GEN-END:variables
}
