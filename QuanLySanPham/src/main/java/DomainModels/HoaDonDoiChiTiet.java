/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModels;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Nguyen Van Thuan
 */
@Entity
@Table(name = "HoaDonDoiChiTiet")
public class HoaDonDoiChiTiet implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int MaHoaDonDoiChiTiet;
    private int SoLuong;
    private int DonGia;
    
    @ManyToOne   
    @JoinColumn(name = "MaHoaDonDoiTra")
    private HoaDonDoiTra hoadondoitra;
    
    @ManyToOne
    @JoinColumn(name = "MaSanPham")
    private SanPham sanpham;

    public HoaDonDoiChiTiet() {
    }

    public HoaDonDoiChiTiet(int MaHoaDonDoiChiTiet, int SoLuong, int DonGia, HoaDonDoiTra hoadondoitra, SanPham sanpham) {
        this.MaHoaDonDoiChiTiet = MaHoaDonDoiChiTiet;
        this.SoLuong = SoLuong;
        this.DonGia = DonGia;
        this.hoadondoitra = hoadondoitra;
        this.sanpham = sanpham;
    }

    public int getMaHoaDonDoiChiTiet() {
        return MaHoaDonDoiChiTiet;
    }

    public void setMaHoaDonDoiChiTiet(int MaHoaDonDoiChiTiet) {
        this.MaHoaDonDoiChiTiet = MaHoaDonDoiChiTiet;
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

    public HoaDonDoiTra getHoadondoitra() {
        return hoadondoitra;
    }

    public void setHoadondoitra(HoaDonDoiTra hoadondoitra) {
        this.hoadondoitra = hoadondoitra;
    }

    public SanPham getSanpham() {
        return sanpham;
    }

    public void setSanpham(SanPham sanpham) {
        this.sanpham = sanpham;
    }
    
}
