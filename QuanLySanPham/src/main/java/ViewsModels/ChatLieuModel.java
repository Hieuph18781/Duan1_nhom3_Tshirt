/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewsModels;

/**
 *
 * @author Admin
 */
public class ChatLieuModel {

    private int MaChatLieu;
    private String TenChatLieu;
    private String Mota;

    public ChatLieuModel() {
    }

    public ChatLieuModel(int MaChatLieu, String Mota, String TenChatLieu) {
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

}
