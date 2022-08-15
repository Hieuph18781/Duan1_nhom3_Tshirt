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
@Table(name = "SanPham")
public class SanPham implements Serializable {

    @Id
    private String MaSanPham;
    
    @Nationalized
    private String TenSanPham;
    private int SoLuong;
    private int gia;
    
    @Nationalized
    private String Mota;
    
    private boolean TrangThai;

    @ManyToOne
    @JoinColumn(name = "MaChatLieu")
    private ChatLieu chatlieu;

    @ManyToOne
    @JoinColumn(name = "MaKieuDang")
    private KieuDang kieudang;

    @ManyToOne
    @JoinColumn(name = "MaDanhMuc")
    private DanhMucSanPham danhMucSanPham;

    @ManyToOne
    @JoinColumn(name = "MaMauSac")
    private MauSac mausac;

    @ManyToOne
    @JoinColumn(name = "MaSize")
    private Size size;

    @OneToMany(mappedBy = "sanpham",
            cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<HoaDonChiTiet> lstHoaDonChiTiet;
    
    @OneToMany(mappedBy = "sanpham",
            cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<HoaDonTraChiTiet> lstHoaDonDoiTraChiTiets;
    
    @OneToMany(mappedBy = "sanpham",
            cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<HoaDonDoiChiTiet> lsthoaDoiChiTiets;

    public SanPham() {
    }

    public SanPham(String MaSanPham) {
        this.MaSanPham = MaSanPham;
    }

    public SanPham(String MaSanPham, String TenSanPham, int SoLuong, int gia, String Mota, boolean TrangThai, ChatLieu chatlieu, KieuDang kieudang, DanhMucSanPham danhMucSanPham, MauSac mausac, Size size) {
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

    public boolean getTrangThai() {
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

    public List<HoaDonChiTiet> getLstHoaDonChiTiet() {
        return lstHoaDonChiTiet;
    }

    public void setLstHoaDonChiTiet(List<HoaDonChiTiet> lstHoaDonChiTiet) {
        this.lstHoaDonChiTiet = lstHoaDonChiTiet;
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
