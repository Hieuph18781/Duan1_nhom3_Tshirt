/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewsModel;

/**
 *
 * @author Admin
 */
public class KieuDangModel {
     private String MaKieuDang;
     private String TenKieuDang;
      private String Mota;

    public KieuDangModel() {
    }

    public KieuDangModel(String MaKieuDang, String TenKieuDang, String Mota) {
        this.MaKieuDang = MaKieuDang;
        this.TenKieuDang = TenKieuDang;
        this.Mota = Mota;
    }

    public KieuDangModel(String tenKieuDang, String mota) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getMaKieuDang() {
        return MaKieuDang;
    }

    public void setMaKieuDang(String MaKieuDang) {
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
