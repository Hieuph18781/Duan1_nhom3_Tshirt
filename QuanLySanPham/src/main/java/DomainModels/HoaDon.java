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
import javax.persistence.Temporal;
import javax.xml.crypto.Data;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Nationalized;

/**
 *
 * @author Nguyen Van Thuan
 */
@Entity
@Table(name = "HoaDon")
public class HoaDon implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int MaHoaDon;

    private Date ThoiGianTao;

    @Nationalized
    private int TrangThai;//0: đang chờ, 1: Hủy, 2:Thành Công, 3: Đã trả hàng

    @ManyToOne
    @JoinColumn(name = "MaNhanVien")
    private NhanVien nhanvien;

    @ManyToOne
    @JoinColumn(name = "MaKhachHang")
    private KhachHang khachhang;

    @ManyToOne
    @JoinColumn(name = "IdKhuyenMai")
    private KhuyenMai khuyenmai;

    @OneToMany(mappedBy = "hoadon",
            cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<HoaDonChiTiet> lstHoaDonChitiet;

    @OneToMany(mappedBy = "hoadon",
            cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<HoaDonDoiTra> lstHoaDonDoiTras;

    public HoaDon() {
    }

    public HoaDon(int MaHoaDon) {
        this.MaHoaDon = MaHoaDon;
    }

    public HoaDon(int MaHoaDon, Date ThoiGianTao, int TrangThai, NhanVien nhanvien, KhachHang khachhang, KhuyenMai khuyenmai) {
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

    public NhanVien getNhanvien() {
        return nhanvien;
    }

    public void setNhanvien(NhanVien nhanvien) {
        this.nhanvien = nhanvien;
    }

    public KhachHang getKhachhang() {
        return khachhang;
    }

    public void setKhachhang(KhachHang khachhang) {
        this.khachhang = khachhang;
    }

    public KhuyenMai getKhuyenmai() {
        return khuyenmai;
    }

    public void setKhuyenmai(KhuyenMai khuyenmai) {
        this.khuyenmai = khuyenmai;
    }

    public List<HoaDonChiTiet> getLstHoaDonChitiet() {
        return lstHoaDonChitiet;
    }

    public void setLstHoaDonChitiet(List<HoaDonChiTiet> lstHoaDonChitiet) {
        this.lstHoaDonChitiet = lstHoaDonChitiet;
    }

    public List<HoaDonDoiTra> getLstHoaDonDoiTras() {
        return lstHoaDonDoiTras;
    }

    public void setLstHoaDonDoiTras(List<HoaDonDoiTra> lstHoaDonDoiTras) {
        this.lstHoaDonDoiTras = lstHoaDonDoiTras;
    }

    @Override
    public String toString() {
        return "HoaDon{" + "MaHoaDon=" + MaHoaDon + ", ThoiGianTao=" + ThoiGianTao + ", TrangThai=" + TrangThai + ", nhanvien=" + nhanvien.getHoTen() + ", khachhang=" + khachhang.getHoTen() + ", khuyenmai=" + khuyenmai.getTenKhuyenMai() + '}';
    }

}
