/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewsModels;

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
    private int gia;
    private String Mota;
    private boolean TrangThai;

    private ChatLieuModel chatlieuModel;
    private KieuDangModel kieudangModel;
    private DanhMucSanPhamModel danhMucSanPhamModel;
    private MauSacModel mausacModel;
    private SizeModel sizeModel;

    public SanPhamModel() {
    }

    public SanPhamModel(String MaSanPham, String TenSanPham, int gia) {
        this.MaSanPham = MaSanPham;
        this.TenSanPham = TenSanPham;
        this.SoLuong = SoLuong;
        this.gia = gia;
    }

    public SanPhamModel(String MaSanPham, String TenSanPham, int SoLuong, int gia, String Mota, boolean TrangThai, ChatLieuModel chatlieuModel, KieuDangModel kieudangModel, DanhMucSanPhamModel danhMucSanPhamModel, MauSacModel mausacModel, SizeModel sizeModel) {
        this.MaSanPham = MaSanPham;
        this.TenSanPham = TenSanPham;
        this.SoLuong = SoLuong;
        this.gia = gia;
        this.Mota = Mota;
        this.TrangThai = TrangThai;
        this.chatlieuModel = chatlieuModel;
        this.kieudangModel = kieudangModel;
        this.danhMucSanPhamModel = danhMucSanPhamModel;
        this.mausacModel = mausacModel;
        this.sizeModel = sizeModel;
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

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
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

    public ChatLieuModel getChatlieuModel() {
        return chatlieuModel;
    }

    public void setChatlieuModel(ChatLieuModel chatlieuModel) {
        this.chatlieuModel = chatlieuModel;
    }

    public KieuDangModel getKieudangModel() {
        return kieudangModel;
    }

    public void setKieudangModel(KieuDangModel kieudangModel) {
        this.kieudangModel = kieudangModel;
    }

    public DanhMucSanPhamModel getDanhMucSanPhamModel() {
        return danhMucSanPhamModel;
    }

    public void setDanhMucSanPhamModel(DanhMucSanPhamModel danhMucSanPhamModel) {
        this.danhMucSanPhamModel = danhMucSanPhamModel;
    }

    public MauSacModel getMausacModel() {
        return mausacModel;
    }

    public void setMausacModel(MauSacModel mausacModel) {
        this.mausacModel = mausacModel;
    }

    public SizeModel getSizeModel() {
        return sizeModel;
    }

    public void setSizeModel(SizeModel sizeModel) {
        this.sizeModel = sizeModel;
    }

    @Override
    public String toString() {
        return "SanPhamModel{" + "MaSanPham=" + MaSanPham + ", TenSanPham=" + TenSanPham + ", SoLuong=" + SoLuong + ", gia=" + gia + ", Mota=" + Mota + ", TrangThai=" + TrangThai + ", chatlieuModel=" + chatlieuModel + ", kieudangModel=" + kieudangModel + ", danhMucSanPhamModel=" + danhMucSanPhamModel + ", mausacModel=" + mausacModel + ", sizeModel=" + sizeModel + '}';
    }

}
