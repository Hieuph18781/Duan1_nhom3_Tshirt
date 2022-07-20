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
@Table(name = "HoaDonChiTiet")
public class HoaDonChiTiet implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int MaHoaDonCT;
    private int SoLuong;
    private int donGia; 
    
    @ManyToOne
    @JoinColumn(name = "MaHoaDon")
    private HoaDon hoadon;
    
    @ManyToOne
    @JoinColumn(name = "MaSanPham")
    private SanPham sanpham;

    public HoaDonChiTiet() {
    }

    public HoaDonChiTiet(int MaHoaDonCT, int SoLuong, int donGia, HoaDon hoadon, SanPham sanpham) {
        this.MaHoaDonCT = MaHoaDonCT;
        this.SoLuong = SoLuong;
        this.donGia = donGia;
        this.hoadon = hoadon;
        this.sanpham = sanpham;
    }

    public int getMaHoaDonCT() {
        return MaHoaDonCT;
    }

    public void setMaHoaDonCT(int MaHoaDonCT) {
        this.MaHoaDonCT = MaHoaDonCT;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public int getDonGia() {
        return donGia;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }

    public HoaDon getHoadon() {
        return hoadon;
    }

    public void setHoadon(HoaDon hoadon) {
        this.hoadon = hoadon;
    }

    public SanPham getSanpham() {
        return sanpham;
    }

    public void setSanpham(SanPham sanpham) {
        this.sanpham = sanpham;
    }
    
    
}
