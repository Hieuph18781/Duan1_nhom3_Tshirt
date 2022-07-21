/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewsModel;

/**
 *
 * @author Admin
 */
public class ChatLieuModel {
     private String MaChatLieu;
     private String TenChatLieu;
      private String Mota;

    public ChatLieuModel() {
    }

    public ChatLieuModel(String MaChatLieu, String TenChatLieu, String Mota) {
        this.MaChatLieu = MaChatLieu;
        this.TenChatLieu = TenChatLieu;
        this.Mota = Mota;
    }

    public String getMaChatLieu() {
        return MaChatLieu;
    }

    public void setMaChatLieu(String MaChatLieu) {
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
      
      
    
}
