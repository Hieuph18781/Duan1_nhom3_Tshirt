/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewsModels;

import DomainModels.NhanVien;
import java.util.Date;

/**
 *
 * @author Admin
 */
public class KhuyenMaiModel {
    
     private int IdKhuyenMai;
      private String TenKhuyenMai;
        private Date NgayBatDau;
         private Date NgayKetThuc;
    private int GiaKhuyenMai;
      private String MoTa;
     

    public KhuyenMaiModel() {
    }

    public KhuyenMaiModel(int IdKhuyenMai, String TenKhuyenMai, Date NgayBatDau, Date NgayKetThuc, int GiaKhuyenMai, String MoTa) {
        this.IdKhuyenMai = IdKhuyenMai;
        this.TenKhuyenMai = TenKhuyenMai;
        this.NgayBatDau = NgayBatDau;
        this.NgayKetThuc = NgayKetThuc;
        this.GiaKhuyenMai = GiaKhuyenMai;
        this.MoTa = MoTa;
        
    }

    public int getIdKhuyenMai() {
        return IdKhuyenMai;
    }

    public void setIdKhuyenMai(int IdKhuyenMai) {
        this.IdKhuyenMai = IdKhuyenMai;
    }

    public String getTenKhuyenMai() {
        return TenKhuyenMai;
    }

    public void setTenKhuyenMai(String TenKhuyenMai) {
        this.TenKhuyenMai = TenKhuyenMai;
    }

    public Date getNgayBatDau() {
        return NgayBatDau;
    }

    public void setNgayBatDau(Date NgayBatDau) {
        this.NgayBatDau = NgayBatDau;
    }

    public Date getNgayKetThuc() {
        return NgayKetThuc;
    }

    public void setNgayKetThuc(Date NgayKetThuc) {
        this.NgayKetThuc = NgayKetThuc;
    }

    public int getGiaKhuyenMai() {
        return GiaKhuyenMai;
    }

    public void setGiaKhuyenMai(int GiaKhuyenMai) {
        this.GiaKhuyenMai = GiaKhuyenMai;
    }

    public String getMoTa() {
        return MoTa;
    }

    public void setMoTa(String MoTa) {
        this.MoTa = MoTa;
    }

    @Override
    public String toString() {
        return "KhuyenMaiModel{" + "IdKhuyenMai=" + IdKhuyenMai + ", TenKhuyenMai=" + TenKhuyenMai + ", NgayBatDau=" + NgayBatDau + ", NgayKetThuc=" + NgayKetThuc + ", GiaKhuyenMai=" + GiaKhuyenMai + ", MoTa=" + MoTa + '}';
    }
     
}
