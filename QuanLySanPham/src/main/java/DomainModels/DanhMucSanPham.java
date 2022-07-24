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
 * @author chung
 */
@Entity
@Table(name = "DanhMucSanPham")
public class DanhMucSanPham implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int MaDanhMuc;

    @Nationalized
    private String TenDanhMuc;

    @Nationalized
    private String Mota;

    @OneToMany(mappedBy = "danhMucSanPham",
            cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<SanPham> lstSanPham;

    public DanhMucSanPham() {
    }

    public DanhMucSanPham(int MaDanhMuc, String TenTheLoai, String Mota) {
        this.MaDanhMuc = MaDanhMuc;
        this.TenDanhMuc = TenTheLoai;
        this.Mota = Mota;
    }

    public int getMaDanhMuc() {
        return MaDanhMuc;
    }

    public void setMaDanhMuc(int MaDanhMuc) {
        this.MaDanhMuc = MaDanhMuc;
    }

    public String getTenDanhMuc() {
        return TenDanhMuc;
    }

    public void setTenDanhMuc(String TenTheLoai) {
        this.TenDanhMuc = TenTheLoai;
    }

    public String getMota() {
        return Mota;
    }

    public void setMota(String Mota) {
        this.Mota = Mota;
    }

    public List<SanPham> getLstSanPham() {
        return lstSanPham;
    }

    public void setLstSanPham(List<SanPham> lstSanPham) {
        this.lstSanPham = lstSanPham;
    }

}
