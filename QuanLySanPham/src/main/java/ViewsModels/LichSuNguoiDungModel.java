/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewsModels;

import DomainModels.NhanVien;
import java.util.Date;
import javax.swing.Icon;

/**
 *
 * @author Admin
 */
public class LichSuNguoiDungModel {
      private int IdLichSu;
    
    private String HanhDong;
     private String ChiTiet;
     private Date ThoiGian;
    private String DoiTuong;
     private String DuLieuCu;
      private NhanVien nhanvien;

    public LichSuNguoiDungModel() {
    }

    public LichSuNguoiDungModel(int IdLichSu, String HanhDong, String ChiTiet, Date ThoiGian, String DoiTuong, String DuLieuCu, NhanVien nhanvien) {
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
