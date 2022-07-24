/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewsModels;

/**
 *
 * @author Admin
 */
public class MauSacModel {
     private String MaMauSac;
     private String TenMauSac;
      private String Mota;

    public MauSacModel() {
    }

    public MauSacModel(String MaMauSac, String TenMauSac, String Mota) {
        this.MaMauSac = MaMauSac;
        this.TenMauSac = TenMauSac;
        this.Mota = Mota;
    }

    public String getMaMauSac() {
        return MaMauSac;
    }

    public void setMaMauSac(String MaMauSac) {
        this.MaMauSac = MaMauSac;
    }

    public String getTenMauSac() {
        return TenMauSac;
    }

    public void setTenMauSac(String TenMauSac) {
        this.TenMauSac = TenMauSac;
    }

    public String getMota() {
        return Mota;
    }

    public void setMota(String Mota) {
        this.Mota = Mota;
    }
      
      
}
