/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewsModels;

/**
 *
 * @author Admin
 */
public class DanhMucSanPhamModel {
     private String MaDanhMuc;
    private String TenTheLoai;
      private String Mota;

    public DanhMucSanPhamModel() {
    }

    public DanhMucSanPhamModel(String MaDanhMuc, String TenTheLoai, String Mota) {
        this.MaDanhMuc = MaDanhMuc;
        this.TenTheLoai = TenTheLoai;
        this.Mota = Mota;
    }

    public String getMaDanhMuc() {
        return MaDanhMuc;
    }

    public void setMaDanhMuc(String MaDanhMuc) {
        this.MaDanhMuc = MaDanhMuc;
    }

    public String getTenTheLoai() {
        return TenTheLoai;
    }

    public void setTenTheLoai(String TenTheLoai) {
        this.TenTheLoai = TenTheLoai;
    }

    public String getMota() {
        return Mota;
    }

    public void setMota(String Mota) {
        this.Mota = Mota;
    }
      
      
}
