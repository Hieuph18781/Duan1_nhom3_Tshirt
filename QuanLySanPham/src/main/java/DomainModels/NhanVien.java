/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModels;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import org.hibernate.annotations.Nationalized;

/**
 *
 * @author Nguyen Van Thuan
 */
@Entity
@Table(name = "NhanVien")
public class NhanVien implements Serializable {

    @Id
    private String MaNhanVien;

    @Nationalized
    private String HoTen;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date NgaySinh;

    @Nationalized
    private boolean GioiTinh;
    private String SoDienThoai;
    private String Email;

    @Nationalized
    private String DiaChi;
    private String CCCD;

    @Nationalized
    private String ChucVu;
    @Nationalized
    private String TrangThai;
    @Nationalized
    private String MatKhau;

    @OneToMany(mappedBy = "nhanvien",
            cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<LichSuNguoiDung> lstLichSuNguoiDung;

    @OneToMany(mappedBy = "nhanvien",
            cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<HoaDon> lstHoaDon;

    @OneToMany(mappedBy = "nhanvien",
            cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<HoaDonDoiTra> lstHoaDonDoiTras;

    public NhanVien() {
    }

    public NhanVien(String MaNhanVien, String HoTen, Date NgaySinh, boolean GioiTinh, String SoDienThoai, String Email, String DiaChi, String CCCD, String ChucVu, String TrangThai, String MatKhau) {
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

    public List<LichSuNguoiDung> getLstLichSuNguoiDung() {
        return lstLichSuNguoiDung;
    }

    public void setLstLichSuNguoiDung(List<LichSuNguoiDung> lstLichSuNguoiDung) {
        this.lstLichSuNguoiDung = lstLichSuNguoiDung;
    }

    public List<HoaDon> getLstHoaDon() {
        return lstHoaDon;
    }

    public void setLstHoaDon(List<HoaDon> lstHoaDon) {
        this.lstHoaDon = lstHoaDon;
    }

    public List<HoaDonDoiTra> getLstHoaDonDoiTras() {
        return lstHoaDonDoiTras;
    }

    public void setLstHoaDonDoiTras(List<HoaDonDoiTra> lstHoaDonDoiTras) {
        this.lstHoaDonDoiTras = lstHoaDonDoiTras;
    }

}
