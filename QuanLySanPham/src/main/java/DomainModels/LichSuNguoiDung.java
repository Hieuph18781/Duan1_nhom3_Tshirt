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
import org.hibernate.annotations.Nationalized;

/**
 *
 * @author Nguyen Van Thuan
 */
@Entity
@Table(name = "LichSuNguoiDung")
public class LichSuNguoiDung implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int IdLichSu;
    
    private String HanhDong;
    
    @Nationalized
    private String ChiTiet;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date ThoiGian;
    private String DoiTuong;
    
    @Nationalized
    private String DuLieuCu;
    
    @ManyToOne
    @JoinColumn(name = "MaNhanVien")
    private NhanVien nhanvien;

    public LichSuNguoiDung() {
        
    }

    public LichSuNguoiDung(int IdLichSu, String HanhDong, String ChiTiet, Date ThoiGian, String DoiTuong, String DuLieuCu, NhanVien nhanvien) {
        this.IdLichSu = IdLichSu;
        this.HanhDong = HanhDong;
        this.ChiTiet = ChiTiet;
        this.ThoiGian = ThoiGian;
        this.DoiTuong = DoiTuong;
        this.DuLieuCu = DuLieuCu;
        this.nhanvien = nhanvien;
    }

    public int getIdLichSu() {
        return IdLichSu;
    }

    public void setIdLichSu(int IdLichSu) {
        this.IdLichSu = IdLichSu;
    }

    public String getHanhDong() {
        return HanhDong;
    }

    public void setHanhDong(String HanhDong) {
        this.HanhDong = HanhDong;
    }

    public String getChiTiet() {
        return ChiTiet;
    }

    public void setChiTiet(String ChiTiet) {
        this.ChiTiet = ChiTiet;
    }

    public Date getThoiGian() {
        return ThoiGian;
    }

    public void setThoiGian(Date ThoiGian) {
        this.ThoiGian = ThoiGian;
    }

    public String getDoiTuong() {
        return DoiTuong;
    }

    public void setDoiTuong(String DoiTuong) {
        this.DoiTuong = DoiTuong;
    }

    public String getDuLieuCu() {
        return DuLieuCu;
    }

    public void setDuLieuCu(String DuLieuCu) {
        this.DuLieuCu = DuLieuCu;
    }

    public NhanVien getNhanvien() {
        return nhanvien;
    }

    public void setNhanvien(NhanVien nhanvien) {
        this.nhanvien = nhanvien;
    }
    
    
}
