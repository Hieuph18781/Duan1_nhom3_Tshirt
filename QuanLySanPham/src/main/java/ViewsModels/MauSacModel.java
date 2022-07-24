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
     private int MaMauSac;
     private String TenMauSac;
      private String Mota;

    public MauSacModel() {
    }

    public MauSacModel(int MaMauSac, String TenMauSac, String Mota) {
        this.MaMauSac = MaMauSac;
        this.TenMauSac = TenMauSac;
        this.Mota = Mota;
    }

    public int getMaMauSac() {
        return MaMauSac;
    }

    public void setMaMauSac(int MaMauSac) {
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
