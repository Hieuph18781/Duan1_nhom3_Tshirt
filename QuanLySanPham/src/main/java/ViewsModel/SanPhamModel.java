/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewsModel;

import DomainModels.ChatLieu;
import DomainModels.DanhMucSanPham;
import DomainModels.KieuDang;
import DomainModels.MauSac;
import DomainModels.Size;

/**
 *
 * @author Admin
 */
public class SanPhamModel {

    private String MaSanPham;
    private String TenSanPham;
    private int SoLuong;
    private double gia;
    private String Mota;
    private boolean TrangThai;
    private ChatLieu chatlieu;
    private KieuDang kieudang;
    private DanhMucSanPham danhMucSanPham;
    private MauSac mausac;
    private Size size;

    public SanPhamModel() {
    }

    public SanPhamModel(String MaSanPham, String TenSanPham, int SoLuong, double gia, String Mota, boolean TrangThai, ChatLieu chatlieu, KieuDang kieudang, DanhMucSanPham danhMucSanPham, MauSac mausac, Size size) {
        this.MaSanPham = MaSanPham;
        this.TenSanPham = TenSanPham;
        this.SoLuong = SoLuong;
        this.gia = gia;
        this.Mota = Mota;
        this.TrangThai = TrangThai;
        this.chatlieu = chatlieu;
        this.kieudang = kieudang;
        this.danhMucSanPham = danhMucSanPham;
        this.mausac = mausac;
        this.size = size;
    }

    public String getMaSanPham() {
        return MaSanPham;
    }

    public void setMaSanPham(String MaSanPham) {
        this.MaSanPham = MaSanPham;
    }

    public String getTenSanPham() {
        return TenSanPham;
    }

    public void setTenSanPham(String TenSanPham) {
        this.TenSanPham = TenSanPham;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public String getMota() {
        return Mota;
    }

    public void setMota(String Mota) {
        this.Mota = Mota;
    }

    public boolean isTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(boolean TrangThai) {
        this.TrangThai = TrangThai;
    }

    public ChatLieu getChatlieu() {
        return chatlieu;
    }

    public void setChatlieu(ChatLieu chatlieu) {
        this.chatlieu = chatlieu;
    }

    public KieuDang getKieudang() {
        return kieudang;
    }

    public void setKieudang(KieuDang kieudang) {
        this.kieudang = kieudang;
    }

    public DanhMucSanPham getDanhMucSanPham() {
        return danhMucSanPham;
    }

    public void setDanhMucSanPham(DanhMucSanPham danhMucSanPham) {
        this.danhMucSanPham = danhMucSanPham;
    }

    public MauSac getMausac() {
        return mausac;
    }

    public void setMausac(MauSac mausac) {
        this.mausac = mausac;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

}
