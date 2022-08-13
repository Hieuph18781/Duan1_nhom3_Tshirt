/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewsModels;

import DomainModels.HoaDonDoiTra;
import DomainModels.SanPham;

/**
 *
 * @author Nguyen Van Thuan
 */
public class HoaDonDoiTraChiTietModel {

    private int MaHoaDonDoiTraChiTiet;
    private int SoLuong;
    private int DonGia;

    private HoaDonDoiTraMoDel HoaDonDoiTraModel;
    private SanPhamModel sanPhamModel;

    public HoaDonDoiTraChiTietModel() {
    }

    public HoaDonDoiTraChiTietModel(int MaHoaDonDoiTraChiTiet, int SoLuong, int DonGia, HoaDonDoiTraMoDel HoaDonDoiTraModel, SanPhamModel sanPhamModel) {
        this.MaHoaDonDoiTraChiTiet = MaHoaDonDoiTraChiTiet;
        this.SoLuong = SoLuong;
        this.DonGia = DonGia;
        this.HoaDonDoiTraModel = HoaDonDoiTraModel;
        this.sanPhamModel = sanPhamModel;
    }

    public int getMaHoaDonDoiTraChiTiet() {
        return MaHoaDonDoiTraChiTiet;
    }

    public void setMaHoaDonDoiTraChiTiet(int HoaDonDoiTraChiTiet) {
        this.MaHoaDonDoiTraChiTiet = HoaDonDoiTraChiTiet;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public int getDonGia() {
        return DonGia;
    }

    public void setDonGia(int DonGia) {
        this.DonGia = DonGia;
    }

    public HoaDonDoiTraMoDel getHoaDonDoiTraModel() {
        return HoaDonDoiTraModel;
    }

    public void setHoaDonDoiTraModel(HoaDonDoiTraMoDel HoaDonDoiTraModel) {
        this.HoaDonDoiTraModel = HoaDonDoiTraModel;
    }

    public SanPhamModel getSanPhamModel() {
        return sanPhamModel;
    }

    public void setSanPhamModel(SanPhamModel sanPhamModel) {
        this.sanPhamModel = sanPhamModel;
    }
    
}
