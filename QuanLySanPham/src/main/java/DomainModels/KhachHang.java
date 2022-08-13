/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModels;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.Nationalized;

/**
 *
 * @author Nguyen Van Thuan
 */
@Entity
@Table(name = "KhachHang")
public class KhachHang implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int MaKhachHang;

    @Nationalized
    private String HoTen;

    private String SoDienThoai;

    @Nationalized
    private String DiaChi;

    private String Email;

    private int Diem;
    @OneToMany(mappedBy = "khachhang",
            cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<HoaDon> lstHoaDon;

    @OneToMany(mappedBy = "khachhang",
            cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<HoaDonDoiTra> lstHoaDonDoiTras;

    public KhachHang() {
    }

    public KhachHang(int MaKhachHang, String HoTen, String SoDienThoai, String DiaChi, String Email, int Diem) {
        this.MaKhachHang = MaKhachHang;
        this.HoTen = HoTen;
        this.SoDienThoai = SoDienThoai;
        this.DiaChi = DiaChi;
        this.Email = Email;
        this.Diem = Diem;
    }

    public int getMaKhachHang() {
        return MaKhachHang;
    }

    public void setMaKhachHang(int MaKhachHang) {
        this.MaKhachHang = MaKhachHang;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public String getSoDienThoai() {
        return SoDienThoai;
    }

    public void setSoDienThoai(String SoDienThoai) {
        this.SoDienThoai = SoDienThoai;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public int getDiem() {
        return Diem;
    }

    public void setDiem(int Diem) {
        this.Diem = Diem;
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

    @Override
    public String toString() {
        return "KhachHang{" + "MaKhachHang=" + MaKhachHang + ", HoTen=" + HoTen + ", SoDienThoai=" + SoDienThoai + ", DiaChi=" + DiaChi + ", Email=" + Email + ", Diem=" + Diem + ", lstHoaDon=" + '}';
    }

}
