/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewsModels;

/**
 *
 * @author Admin
 */
public class SizeModel {
     private int MaSize;
     private String TenSize;
      private String Mota;

    public SizeModel() {
    }

    public SizeModel(int MaSize, String TenSize, String Mota) {
        this.MaSize = MaSize;
        this.TenSize = TenSize;
        this.Mota = Mota;
    }

    public int getMaSize() {
        return MaSize;
    }

    public void setMaSize(int MaSize) {
        this.MaSize = MaSize;
    }

    public String getTenSize() {
        return TenSize;
    }

    public void setTenSize(String TenSize) {
        this.TenSize = TenSize;
    }

    public String getMota() {
        return Mota;
    }

    public void setMota(String Mota) {
        this.Mota = Mota;
    }
      
      
    
    
}
