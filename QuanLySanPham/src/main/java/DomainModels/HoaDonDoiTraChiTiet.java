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
@Table(name = "HoaDonDoiTraChiTiet")
public class HoaDonDoiTraChiTiet implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int MaHoaDonDoiTraChiTiet;
    private int SoLuong;
    private int DonGia;
    
    @ManyToOne   
    @JoinColumn(name = "MaHoaDonDoiTra")
    private HoaDonDoiTra hoadondoitra;
    
    @ManyToOne
    @JoinColumn(name = "MaSanPham")
    private SanPham sanpham;

    public HoaDonDoiTraChiTiet() {
    }

    public HoaDonDoiTraChiTiet(int MaHoaDonDoiTraChiTiet, int SoLuong, int DonGia, HoaDonDoiTra hoadondoitra, SanPham sanpham) {
        this.MaHoaDonDoiTraChiTiet = MaHoaDonDoiTraChiTiet;
        this.SoLuong = SoLuong;
        this.DonGia = DonGia;
        this.hoadondoitra = hoadondoitra;
        this.sanpham = sanpham;
    }

    public int getMaHoaDonDoiTraChiTiet() {
        return MaHoaDonDoiTraChiTiet;
    }

    public void setMaHoaDonDoiTraChiTiet(int MaHoaDonDoiTraChiTiet) {
        this.MaHoaDonDoiTraChiTiet = MaHoaDonDoiTraChiTiet;
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
