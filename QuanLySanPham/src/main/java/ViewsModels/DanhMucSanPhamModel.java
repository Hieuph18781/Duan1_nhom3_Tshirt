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
     private int MaDanhMuc;
    private String TenDanhMuc;
      private String Mota;

    public DanhMucSanPhamModel() {
    }

    public DanhMucSanPhamModel(int MaDanhMuc, String TenTheLoai, String Mota) {
        this.MaDanhMuc = MaDanhMuc;
        this.TenDanhMuc = TenTheLoai;
        this.Mota = Mota;
    }

    public int getMaDanhMuc() {
        return MaDanhMuc;
    }

    public void setMaDanhMuc(int MaDanhMuc) {
        this.MaDanhMuc = MaDanhMuc;
    }

    public String getTenDanhMuc() {
        return TenDanhMuc;
    }

    public void setTenDanhMuc(String TenTheLoai) {
        this.TenDanhMuc = TenTheLoai;
    }

    public String getMota() {
        return Mota;
    }

    public void setMota(String Mota) {
        this.Mota = Mota;
    }
      
      
}
