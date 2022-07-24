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
@Table(name = "MauSac")
public class MauSac implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int MaMauSac;
    
    @Nationalized
    private String TenMauSac;
    
    @Nationalized
    private String Mota;
    @OneToMany(mappedBy = "mausac",
            cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<SanPham> lstSanPham;

    public MauSac() {
    }

    public MauSac(int MaMauSac, String TenMauSac, String Mota) {
        this.MaMauSac = MaMauSac;
        this.TenMauSac = TenMauSac;
        this.Mota = Mota;
    }

    public int getMaMauSac() {
        return MaMauSac;
    }

    public void setMaMauSac(int MaMauSac) {
        this.MaMauSac = MaMauSac;
    }

    public String getTenMauSac() {
        return TenMauSac;
    }

    public void setTenMauSac(String TenMauSac) {
        this.TenMauSac = TenMauSac;
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
