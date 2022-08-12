/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewsModels;

import java.util.Date;

/**
 *
 * @author Nguyen Van Thuan
 */
public class HoaDonDoiTraMoDel {
    private int MaHoaDonDoiHang;
    private int TongTienHoanTra;
    private Date NgayTaoHoaDon;
    private String MoTa;
    
    private HoaDonModel HoaDonModel;
    private KhachHangModel KhachHangModel;
    private NhanVienModel NhanVienModel;

    public HoaDonDoiTraMoDel() {
    }

    public HoaDonDoiTraMoDel(int MaHoaDonDoiHang, int TongTienHoanTra, Date NgayTaoHoaDon, String MoTa, HoaDonModel HoaDonModel, KhachHangModel KhachHangModel, NhanVienModel NhanVienModel) {
        this.MaHoaDonDoiHang = MaHoaDonDoiHang;
        this.TongTienHoanTra = TongTienHoanTra;
        this.NgayTaoHoaDon = NgayTaoHoaDon;
        this.MoTa = MoTa;
        this.HoaDonModel = HoaDonModel;
        this.KhachHangModel = KhachHangModel;
        this.NhanVienModel = NhanVienModel;
    }

    public int getMaHoaDonDoiHang() {
        return MaHoaDonDoiHang;
    }

    public void setMaHoaDonDoiHang(int MaHoaDonDoiHang) {
        this.MaHoaDonDoiHang = MaHoaDonDoiHang;
    }

    public int getTongTienHoanTra() {
        return TongTienHoanTra;
    }

    public void setTongTienHoanTra(int TongTienHoanTra) {
        this.TongTienHoanTra = TongTienHoanTra;
    }

    public Date getNgayTaoHoaDon() {
        return NgayTaoHoaDon;
    }

    public void setNgayTaoHoaDon(Date NgayTaoHoaDon) {
        this.NgayTaoHoaDon = NgayTaoHoaDon;
    }

    public String getMoTa() {
        return MoTa;
    }

    public void setMoTa(String MoTa) {
        this.MoTa = MoTa;
    }

    public HoaDonModel getHoaDonModel() {
        return HoaDonModel;
    }

    public void setHoaDonModel(HoaDonModel HoaDonModel) {
        this.HoaDonModel = HoaDonModel;
    }

    public KhachHangModel getKhachHangModel() {
        return KhachHangModel;
    }

    public void setKhachHangModel(KhachHangModel KhachHangModel) {
        this.KhachHangModel = KhachHangModel;
    }

    public NhanVienModel getNhanVienModel() {
        return NhanVienModel;
    }

    public void setNhanVienModel(NhanVienModel NhanVienModel) {
        this.NhanVienModel = NhanVienModel;
    }

    @Override
    public String toString() {
        return "HoaDonDoiTraMoDel{" + "MaHoaDonDoiHang=" + MaHoaDonDoiHang + ", TongTienHoanTra=" + TongTienHoanTra + ", NgayTaoHoaDon=" + NgayTaoHoaDon + ", MoTa=" + MoTa + ", HoaDonModel=" + HoaDonModel + ", KhachHangModel=" + KhachHangModel.getMaKhachHang() + ", NhanVienModel=" + NhanVienModel.getMaNhanVien() + '}';
    }
    
}
