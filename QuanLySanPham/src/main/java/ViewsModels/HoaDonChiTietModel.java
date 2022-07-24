/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewsModels;

import DomainModels.HoaDon;
import DomainModels.SanPham;

/**
 *
 * @author Admin
 */
public class HoaDonChiTietModel {
     private int MaHoaDonCT;
    private int SoLuong;
    private int donGia; 
     private SanPham sanpham;
     private HoaDon hoadon;

    public HoaDonChiTietModel() {
    }

    public HoaDonChiTietModel(int MaHoaDonCT, int SoLuong, int donGia, SanPham sanpham, HoaDon hoadon) {
        this.MaHoaDonCT = MaHoaDonCT;
        this.SoLuong = SoLuong;
        this.donGia = donGia;
        this.sanpham = sanpham;
        this.hoadon = hoadon;
    }

    public int getMaHoaDonCT() {
        return MaHoaDonCT;
    }

    public void setMaHoaDonCT(int MaHoaDonCT) {
        this.MaHoaDonCT = MaHoaDonCT;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public int getDonGia() {
        return donGia;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }

    public SanPham getSanpham() {
        return sanpham;
    }

    public void setSanpham(SanPham sanpham) {
        this.sanpham = sanpham;
    }

    public HoaDon getHoadon() {
        return hoadon;
    }

    public void setHoadon(HoaDon hoadon) {
        this.hoadon = hoadon;
    }
     
     
}
