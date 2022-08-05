/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewsModels;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class NhanVienModel {

    private String MaNhanVien;
    private String HoTen;
    private Date NgaySinh;
    private boolean GioiTinh;
    private String SoDienThoai;
    private String Email;
    private String DiaChi;
    private String CCCD;
    private String ChucVu;

    private String TrangThai;

    private String MatKhau;

    public NhanVienModel() {
    }

    public NhanVienModel(String MaNhanVien, String HoTen, Date NgaySinh, boolean GioiTinh, String SoDienThoai, String Email, String DiaChi, String CCCD, String ChucVu, String TrangThai, String MatKhau) {
        this.MaNhanVien = MaNhanVien;
        this.HoTen = HoTen;
        this.NgaySinh = NgaySinh;
        this.GioiTinh = GioiTinh;
        this.SoDienThoai = SoDienThoai;
        this.Email = Email;
        this.DiaChi = DiaChi;
        this.CCCD = CCCD;
        this.ChucVu = ChucVu;
        this.TrangThai = TrangThai;
        this.MatKhau = MatKhau;
    }

    public NhanVienModel(String MaNhanVien, String HoTen, String Email, String ChucVu, String TrangThai, String MatKhau) {
        this.MaNhanVien = MaNhanVien;
        this.HoTen = HoTen;
        this.Email = Email;
        this.ChucVu = ChucVu;
        this.TrangThai = TrangThai;
        this.MatKhau = MatKhau;
    }

    public NhanVienModel(String MaNhanVien, String MatKhau) {
        this.MaNhanVien = MaNhanVien;
        this.MatKhau = MatKhau;
    }

    public String getMaNhanVien() {
        return MaNhanVien;
    }

    public void setMaNhanVien(String MaNhanVien) {
        this.MaNhanVien = MaNhanVien;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public Date getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(Date NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public boolean isGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(boolean GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public String getSoDienThoai() {
        return SoDienThoai;
    }

    public void setSoDienThoai(String SoDienThoai) {
        this.SoDienThoai = SoDienThoai;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getCCCD() {
        return CCCD;
    }

    public void setCCCD(String CCCD) {
        this.CCCD = CCCD;
    }

    public String getChucVu() {
        return ChucVu;
    }

    public void setChucVu(String ChucVu) {
        this.ChucVu = ChucVu;
    }

    public String getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(String TrangThai) {
        this.TrangThai = TrangThai;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String MatKhau) {
        this.MatKhau = MatKhau;
    }

    @Override
    public String toString() {
        return "NhanVienModel{" + "MaNhanVien=" + MaNhanVien + ", HoTen=" + HoTen + ", NgaySinh=" + NgaySinh + ", GioiTinh=" + GioiTinh + ", SoDienThoai=" + SoDienThoai + ", Email=" + Email + ", DiaChi=" + DiaChi + ", CCCD=" + CCCD + ", ChucVu=" + ChucVu + ", TrangThai=" + TrangThai + ", MatKhau=" + MatKhau + '}';
    }

}
