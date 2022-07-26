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
import org.hibernate.annotations.Nationalized;

/**
 *
 * @author Nguyen Van Thuan
 */
@Entity
@Table(name = "KhuyenMai")
public class KhuyenMai implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int IdKhuyenMai;

    @Nationalized
    private String TenKhuyenMai;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date NgayBatDau;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date NgayKetThuc;
    private int GiaKhuyenMai;

    @Nationalized
    private String MoTa;

    @OneToMany(mappedBy = "khuyenmai",
            cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<HoaDon> lstHoaDon;

    public KhuyenMai() {
    }

    public KhuyenMai(int IdKhuyenMai, String TenKhuyenMai, Date NgayBatDau, Date NgayKetThuc, int GiaKhuyenMai, String MoTa ) {
        this.IdKhuyenMai = IdKhuyenMai;
        this.TenKhuyenMai = TenKhuyenMai;
        this.NgayBatDau = NgayBatDau;
        this.NgayKetThuc = NgayKetThuc;
        this.GiaKhuyenMai = GiaKhuyenMai;
        this.MoTa = MoTa;
    }

    public int getIdKhuyenMai() {
        return IdKhuyenMai;
    }

    public void setIdKhuyenMai(int IdKhuyenMai) {
        this.IdKhuyenMai = IdKhuyenMai;
    }

    public String getTenKhuyenMai() {
        return TenKhuyenMai;
    }

    public void setTenKhuyenMai(String TenKhuyenMai) {
        this.TenKhuyenMai = TenKhuyenMai;
    }

    public Date getNgayBatDau() {
        return NgayBatDau;
    }

    public void setNgayBatDau(Date NgayBatDau) {
        this.NgayBatDau = NgayBatDau;
    }

    public Date getNgayKetThuc() {
        return NgayKetThuc;
    }

    public void setNgayKetThuc(Date NgayKetThuc) {
        this.NgayKetThuc = NgayKetThuc;
    }

    public int getGiaKhuyenMai() {
        return GiaKhuyenMai;
    }

    public void setGiaKhuyenMai(int GiaKhuyenMai) {
        this.GiaKhuyenMai = GiaKhuyenMai;
    }

    public String getMoTa() {
        return MoTa;
    }

    public void setMoTa(String MoTa) {
        this.MoTa = MoTa;
    }

    public List<HoaDon> getLstHoaDon() {
        return lstHoaDon;
    }

    public void setLstHoaDon(List<HoaDon> lstHoaDon) {
        this.lstHoaDon = lstHoaDon;
    }

}
