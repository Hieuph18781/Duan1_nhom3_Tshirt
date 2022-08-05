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

    private int MaHoaDon;
    private Date ThoiGianTao;
    private int TrangThai;
    private NhanVienModel nhanvien;
    private KhachHangModel khachhang;
    private KhuyenMaiModel khuyenmai;

    public HoaDonModel() {
    }

    public HoaDonModel(int MaHoaDon ) {
        this.MaHoaDon = MaHoaDon;
    }

    public HoaDonModel(int MaHoaDon, int TrangThai) {
        this.MaHoaDon = MaHoaDon;
        this.TrangThai = TrangThai;
    }
    
    
    public HoaDonModel(int MaHoaDon, Date ThoiGianTao, int TrangThai, NhanVienModel nhanvien, KhachHangModel khachhang, KhuyenMaiModel khuyenmai) {
        this.MaHoaDon = MaHoaDon;
        this.ThoiGianTao = ThoiGianTao;
        this.TrangThai = TrangThai;
        this.nhanvien = nhanvien;
        this.khachhang = khachhang;
        this.khuyenmai = khuyenmai;
    }

    public int getMaHoaDon() {
        return MaHoaDon;
    }

    public void setMaHoaDon(int MaHoaDon) {
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

    public NhanVienModel getNhanvien() {
        return nhanvien;
    }

    public void setNhanvien(NhanVienModel nhanvien) {
        this.nhanvien = nhanvien;
    }

    public KhachHangModel getKhachhang() {
        return khachhang;
    }

    public void setKhachhang(KhachHangModel khachhang) {
        this.khachhang = khachhang;
    }

    public KhuyenMaiModel getKhuyenmai() {
        return khuyenmai;
    }

    public void setKhuyenmai(KhuyenMaiModel khuyenmai) {
        this.khuyenmai = khuyenmai;
    }

    @Override
    public String toString() {
        return "HoaDonModel{" + "MaHoaDon=" + MaHoaDon + ", ThoiGianTao=" + ThoiGianTao + ", TrangThai=" + TrangThai + ", nhanvien=" + nhanvien + ", khachhang=" + khachhang + ", khuyenmai=" + khuyenmai + '}';
    }

}
