/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewsModels;

/**
 *
 * @author Admin
 */
public class KieuDangModel {
     private int MaKieuDang;
     private String TenKieuDang;
      private String Mota;

    public KieuDangModel() {
    }

    public KieuDangModel(int MaKieuDang, String TenKieuDang, String Mota) {
        this.MaKieuDang = MaKieuDang;
        this.TenKieuDang = TenKieuDang;
        this.Mota = Mota;
    }
    
    public int getMaKieuDang() {
        return MaKieuDang;
    }

    public void setMaKieuDang(int MaKieuDang) {
        this.MaKieuDang = MaKieuDang;
    }

    public String getTenKieuDang() {
        return TenKieuDang;
    }

    public void setTenKieuDang(String TenKieuDang) {
        this.TenKieuDang = TenKieuDang;
    }

    public String getMota() {
        return Mota;
    }

    public void setMota(String Mota) {
        this.Mota = Mota;
    }
      
      
    
    
}
