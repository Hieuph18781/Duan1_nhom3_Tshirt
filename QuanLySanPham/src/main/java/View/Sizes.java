/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Services.IManageSizeService;
import Services.ManageSizeServixe;
import DomainModels.Size;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hieu
 */
public class Sizes extends javax.swing.JFrame {
    private  final IManageSizeService _iManageSize;
 private int _currentPage;
    private int _totalPages;
    private final int _pageSize;
    private long _totalProducts;
    int row=0;
    /**
     * Creates new form Size
     */
    public Sizes() {
        initComponents();
        _iManageSize=new ManageSizeServixe();
        
        _currentPage = 1;
        _pageSize = 10;
        LoadDataTable();
    }
    
    private  void LoadDataTable(){
        List<Size> ds= _iManageSize.getSize(_currentPage - 1, _pageSize);
        DefaultTableModel dtm=(DefaultTableModel) this.tbl_size.getModel();
        dtm.setRowCount(0);
        for (Size d : ds) {
            Object[] rowdata={d.getMaSize(),d.getTenSize(),d.getMota()}; 
              dtm.addRow(rowdata);
        }
      
    }
    
    

    private  Size getSizeFromInput(){
        DomainModels.Size size=new DomainModels.Size();
        String maSize=txt_masize.getText();
        size.setMaSize(maSize);
        String tenSize=txt_tensize.getText();
        size.setTenSize(tenSize);
        String moTa=txt_mota.getText();
        size.setMota(moTa);
       
        return size;
    }
    
    private  String getSizeFromSelectdRow(){
        int selectRowIndex=tbl_size.getSelectedRow();
        return String.valueOf(tbl_size.getValueAt(selectRowIndex, 0).toString());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Size = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btn_them = new javax.swing.JButton();
        btn_sua = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txt_masize = new javax.swing.JTextField();
        txt_tensize = new javax.swing.JTextField();
        txt_mota = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_size = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Size.setText("Size");

        jLabel2.setText("Mã size");

        jLabel3.setText("Tên size");

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

        txt_tensize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_tensizeActionPerformed(evt);
            }
        });

        tbl_size.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ma Size", "Ten Size", "Mo Ta"
            }
        ));
        tbl_size.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_sizeMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbl_sizeMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_size);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(btn_them)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_sua))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(171, 171, 171)
                        .addComponent(Size, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 125, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_mota)
                            .addComponent(txt_tensize)
                            .addComponent(txt_masize))))
                .addGap(83, 83, 83))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(Size)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_masize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_tensize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_mota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_them)
                    .addComponent(btn_sua))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_tensizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_tensizeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_tensizeActionPerformed

    private void btn_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themActionPerformed
       Size newSize= getSizeFromInput();
        if (_iManageSize.createNewSize(newSize) !=null) {
            JOptionPane.showMessageDialog(this, "thanh cong");
            
        }else{
            JOptionPane.showMessageDialog(this, "that bai");
        }
        LoadDataTable();
    }//GEN-LAST:event_btn_themActionPerformed

    private void btn_suaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suaActionPerformed
      Size updateSize= getSizeFromInput();
      String updateMaSize=getSizeFromSelectdRow();
      updateSize.setMaSize(updateMaSize);
        if (_iManageSize.UpdateNewSize(updateSize)!=null) {
        JOptionPane.showMessageDialog(this, "thanh cong");
            
        }else{
            JOptionPane.showMessageDialog(this, "that bai");
        }
        LoadDataTable();
    }//GEN-LAST:event_btn_suaActionPerformed

    private void tbl_sizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_sizeMouseClicked
        int row=tbl_size.getSelectedRow();
        if (row == -1) {
            return;          
        }
        String maSize=this.tbl_size.getValueAt(row, 1).toString();
        String tenSize=this.tbl_size.getValueAt(row, 2).toString();
        String moTa=this.tbl_size.getValueAt(row, 3).toString();
        
        this.txt_masize.setText(maSize);
        this.txt_tensize.setText(tenSize);
        this.txt_mota.setText(moTa);
        

    }//GEN-LAST:event_tbl_sizeMouseClicked

    private void tbl_sizeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_sizeMousePressed
        // TODO add your handling code here:
//        
//        if (evt.getClickCount()== 2) {
//            this.row=tbl_size.rowAtPoint(evt.getPoint());
//            
//            
//            
//        }
    }//GEN-LAST:event_tbl_sizeMousePressed

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
            java.util.logging.Logger.getLogger(Size.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Size.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Size.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Size.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Sizes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Size;
    private javax.swing.JButton btn_sua;
    private javax.swing.JButton btn_them;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_size;
    private javax.swing.JTextField txt_masize;
    private javax.swing.JTextField txt_mota;
    private javax.swing.JTextField txt_tensize;
    // End of variables declaration//GEN-END:variables
}