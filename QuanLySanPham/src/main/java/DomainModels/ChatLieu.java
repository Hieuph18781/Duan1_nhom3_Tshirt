/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModels;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
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
@Table(name = "ChatLieu")
public class ChatLieu implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int MaChatLieu;
    
    @Nationalized
    private String TenChatLieu;
    
    @Nationalized
    private String Mota;
    
    @OneToMany(mappedBy = "chatlieu",
            cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<SanPham> lstSanPham;

    public ChatLieu() {
    }

    public ChatLieu(int MaChatLieu, String TenChatLieu, String Mota) {
        this.MaChatLieu = MaChatLieu;
        this.TenChatLieu = TenChatLieu;
        this.Mota = Mota;
    }

    public int getMaChatLieu() {
        return MaChatLieu;
    }

    public void setMaChatLieu(int MaChatLieu) {
        this.MaChatLieu = MaChatLieu;
    }

    public String getTenChatLieu() {
        return TenChatLieu;
    }

    public void setTenChatLieu(String TenChatLieu) {
        this.TenChatLieu = TenChatLieu;
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
