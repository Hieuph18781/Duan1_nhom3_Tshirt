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
@Table(name = "KieuDang")
public class KieuDang implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int MaKieuDang;
    
    @Nationalized
    private String TenKieuDang;
    
    @Nationalized
    private String Mota;
    
    @Nationalized
    private String HinhAnh;
    
    @OneToMany(mappedBy = "chatlieu",
            cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<SanPham> lstSanPham;

    public KieuDang() {
    }

    public KieuDang(int MaKieuDang, String TenKieuDang, String Mota,String HinhAnh) {
        this.MaKieuDang = MaKieuDang;
        this.TenKieuDang = TenKieuDang;
        this.Mota = Mota;
        this.HinhAnh = HinhAnh;
    }

    public int getMaKieuDang() {
        return MaKieuDang;
    }

    public void setMaKieuDang(int MaKieuDang) {
        this.MaKieuDang = MaKieuDang;
    }

    public String getTenKieuDang() {
        return TenKieuDang;
    }

    public void setTenKieuDang(String TenKieuDang) {
        this.TenKieuDang = TenKieuDang;
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
     public String getHinhAnh() {
        return HinhAnh;
    }

    public void setHinhAnh(String HinhAnh) {
        this.HinhAnh = HinhAnh;
    }


    public void setLstSanPham(List<SanPham> lstSanPham) {
        this.lstSanPham = lstSanPham;
    }

    
}
