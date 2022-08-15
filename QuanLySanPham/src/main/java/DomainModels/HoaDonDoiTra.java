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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.Nationalized;

/**
 *
 * @author Nguyen Van Thuan
 */
@Entity
@Table(name = "HoaDonDoiTra")
public class HoaDonDoiTra implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int MaHoaDonDoiTra;
    private int TongTienHoanTra;
    private Date NgayTaoHoaDon;
    @Nationalized
    private String MoTa;

    @ManyToOne
    @JoinColumn(name = "MaHoaDon")
    private HoaDon hoadon;

    @ManyToOne
    @JoinColumn(name = "MaKhachHang")
    private KhachHang khachhang;

    @ManyToOne
    @JoinColumn(name = "MaNhanVien")
    private NhanVien nhanvien;

    @OneToMany(mappedBy = "hoadondoitra",
            cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<HoaDonTraChiTiet> lstHoaDonDoiTraChiTiets;

    @OneToMany(mappedBy = "hoadondoitra",
            cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<HoaDonDoiChiTiet> lsthoaDoiChiTiets;

    public HoaDonDoiTra() {
    }

    public HoaDonDoiTra(int MaHoaDonDoiTra, int TongTienHoanTra, Date NgayTaoHoaDon, String MoTa, HoaDon hoadon, KhachHang khachhang, NhanVien nhanvien) {
        this.MaHoaDonDoiTra = MaHoaDonDoiTra;
        this.TongTienHoanTra = TongTienHoanTra;
        this.NgayTaoHoaDon = NgayTaoHoaDon;
        this.MoTa = MoTa;
        this.hoadon = hoadon;
        this.khachhang = khachhang;
        this.nhanvien = nhanvien;
    }

    public int getMaHoaDonDoiTra() {
        return MaHoaDonDoiTra;
    }

    public void setMaHoaDonDoiTra(int getMaHoaDonDoiTra) {
        this.MaHoaDonDoiTra = getMaHoaDonDoiTra;
    }

    public int getTongTienHoanTra() {
        return TongTienHoanTra;
    }

    public void setTongTienHoanTra(int TongTienHoanTra) {
        this.TongTienHoanTra = TongTienHoanTra;
    }

    public Date getNgayTaoHoaDon() {
        return NgayTaoHoaDon;
    }

    public void setNgayTaoHoaDon(Date NgayTaoHoaDon) {
        this.NgayTaoHoaDon = NgayTaoHoaDon;
    }

    public String getMoTa() {
        return MoTa;
    }

    public void setMoTa(String MoTa) {
        this.MoTa = MoTa;
    }

    public HoaDon getHoadon() {
        return hoadon;
    }

    public void setHoadon(HoaDon hoadon) {
        this.hoadon = hoadon;
    }

    public KhachHang getKhachhang() {
        return khachhang;
    }

    public void setKhachhang(KhachHang khachhang) {
        this.khachhang = khachhang;
    }

    public NhanVien getNhanvien() {
        return nhanvien;
    }

    public void setNhanvien(NhanVien nhanvien) {
        this.nhanvien = nhanvien;
    }

    public List<HoaDonTraChiTiet> getLstHoaDonDoiTraChiTiets() {
        return lstHoaDonDoiTraChiTiets;
    }

    public void setLstHoaDonDoiTraChiTiets(List<HoaDonTraChiTiet> lstHoaDonDoiTraChiTiets) {
        this.lstHoaDonDoiTraChiTiets = lstHoaDonDoiTraChiTiets;
    }

    public List<HoaDonDoiChiTiet> getLsthoaDoiChiTiets() {
        return lsthoaDoiChiTiets;
    }

    public void setLsthoaDoiChiTiets(List<HoaDonDoiChiTiet> lsthoaDoiChiTiets) {
        this.lsthoaDoiChiTiets = lsthoaDoiChiTiets;
    }

}
