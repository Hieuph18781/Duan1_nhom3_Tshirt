/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewsModels;

/**
 *
 * @author Admin
 */
public class KhachHangModel {

    private int MaKhachHang;
    private String HoTen;
    private String SoDienThoai;
    private String DiaChi;
    private String Email;
    private int Diem;

    public KhachHangModel() {
    }

    public KhachHangModel(int MaKhachHang, String HoTen, String SoDienThoai, String DiaChi, String Email, int Diem) {
        this.MaKhachHang = MaKhachHang;
        this.HoTen = HoTen;
        this.SoDienThoai = SoDienThoai;
        this.DiaChi = DiaChi;
        this.Email = Email;
        this.Diem = Diem;
    }

    public int getMaKhachHang() {
        return MaKhachHang;
    }

    public void setMaKhachHang(int MaKhachHang) {
        this.MaKhachHang = MaKhachHang;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public String getSoDienThoai() {
        return SoDienThoai;
    }

    public void setSoDienThoai(String SoDienThoai) {
        this.SoDienThoai = SoDienThoai;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public int getDiem() {
        return Diem;
    }

    public void setDiem(int Diem) {
        this.Diem = Diem;
    }

    @Override
    public String toString() {
        return "KhachHangModel{" + "MaKhachHang=" + MaKhachHang + ", HoTen=" + HoTen + ", SoDienThoai=" + SoDienThoai + ", DiaChi=" + DiaChi + ", Email=" + Email + ", Diem=" + Diem + '}';
    }

}
