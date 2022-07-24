/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewsModels;

import DomainModels.KhachHang;
import DomainModels.KhuyenMai;
import DomainModels.NhanVien;
import java.util.Date;

/**
 *
 * @author Admin
 */
public class HoaDonModel {
     private String MaHoaDon;
      private Date ThoiGianTao;
               private int TrangThai;
                 private NhanVien nhanvien;
                  private KhachHang khachhang;
                   private KhuyenMai khuyenmai;

    public HoaDonModel() {
    }

    public HoaDonModel(String MaHoaDon, Date ThoiGianTao, int TrangThai, NhanVien nhanvien, KhachHang khachhang, KhuyenMai khuyenmai) {
        this.MaHoaDon = MaHoaDon;
        this.ThoiGianTao = ThoiGianTao;
        this.TrangThai = TrangThai;
        this.nhanvien = nhanvien;
        this.khachhang = khachhang;
        this.khuyenmai = khuyenmai;
    }

    public String getMaHoaDon() {
        return MaHoaDon;
    }

    public void setMaHoaDon(String MaHoaDon) {
        this.MaHoaDon = MaHoaDon;
    }

    public Date getThoiGianTao() {
        return ThoiGianTao;
    }

    public void setThoiGianTao(Date ThoiGianTao) {
        this.ThoiGianTao = ThoiGianTao;
    }

    public int getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(int TrangThai) {
        this.TrangThai = TrangThai;
    }

    public NhanVien getNhanvien() {
        return nhanvien;
    }

    public void setNhanvien(NhanVien nhanvien) {
        this.nhanvien = nhanvien;
    }

    public KhachHang getKhachhang() {
        return khachhang;
    }

    public void setKhachhang(KhachHang khachhang) {
        this.khachhang = khachhang;
    }

    public KhuyenMai getKhuyenmai() {
        return khuyenmai;
    }

    public void setKhuyenmai(KhuyenMai khuyenmai) {
        this.khuyenmai = khuyenmai;
    }
                   
                   
                   
    

               
}
