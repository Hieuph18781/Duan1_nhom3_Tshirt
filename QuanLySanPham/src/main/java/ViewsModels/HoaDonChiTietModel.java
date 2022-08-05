/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewsModels;

import DomainModels.HoaDon;
import DomainModels.SanPham;
import ViewsModels.SanPhamModel;
import ViewsModels.HoaDonModel;
/**
 *
 * @author Admin
 */
public class HoaDonChiTietModel {
     private int MaHoaDonCT;
    private int SoLuong;
    private int donGia; 
     private SanPhamModel sanPhamModel;
     private HoaDonModel hoaDonModel;

    public HoaDonChiTietModel() {
    }

    public HoaDonChiTietModel(int MaHoaDonCT, int SoLuong, int donGia, SanPhamModel sanPhamModel, HoaDonModel hoaDonModel) {
        this.MaHoaDonCT = MaHoaDonCT;
        this.SoLuong = SoLuong;
        this.donGia = donGia;
        this.sanPhamModel = sanPhamModel;
        this.hoaDonModel = hoaDonModel;
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

    public SanPhamModel getSanPhamModel() {
        return sanPhamModel;
    }

    public void setSanPhamModel(SanPhamModel sanPhamModel) {
        this.sanPhamModel = sanPhamModel;
    }

    public HoaDonModel getHoaDonModel() {
        return hoaDonModel;
    }

    public void setHoaDonModel(HoaDonModel hoaDonModel) {
        this.hoaDonModel = hoaDonModel;
    }

    @Override
    public String toString() {
        return "HoaDonChiTietModel{" + "MaHoaDonCT=" + MaHoaDonCT + ", SoLuong=" + SoLuong + ", donGia=" + donGia + ", sanPhamModel=" + sanPhamModel.getTenSanPham() + ", hoaDonModel=" + hoaDonModel.getMaHoaDon() + '}';
    }

    
     
     
}
