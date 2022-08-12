/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DomainModels.HoaDon;
import DomainModels.HoaDonDoiTra;
import DomainModels.KhachHang;
import DomainModels.KhuyenMai;
import DomainModels.NhanVien;
import Repositories.HoaDonRepository;
import Repositories.HoaDonTraRepositories;
import Repositories.IHoaDonRepository;
import Repositories.IHoaDonTraRepositories;
import ViewsModels.HoaDonDoiTraMoDel;
import ViewsModels.HoaDonModel;
import ViewsModels.KhachHangModel;
import ViewsModels.KhuyenMaiModel;
import ViewsModels.NhanVienModel;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Nguyen Van Thuan
 */
public class HoaDonDoiTraService implements IHoaDonDoiTraService {

    List<HoaDonDoiTraMoDel> _lsthoaDoiTraMoDels;
    IHoaDonTraRepositories _IHoaDonTraRepositories;
    IHoaDonRepository _IHoaDonRepository;

    public HoaDonDoiTraService() {
        _IHoaDonTraRepositories = new HoaDonTraRepositories();
        _IHoaDonRepository = new HoaDonRepository();
    }

    public HoaDonDoiTra getHoaDonDoiTra(HoaDonDoiTraMoDel x) {
        NhanVien nv = new NhanVien();
        nv.setMaNhanVien(x.getNhanVienModel().getMaNhanVien());
        nv.setHoTen(x.getNhanVienModel().getHoTen());
        
        KhachHang kh = new KhachHang();
        kh.setMaKhachHang(x.getKhachHangModel().getMaKhachHang());
        
        HoaDon hd = new HoaDon();
        hd.setMaHoaDon(x.getHoaDonModel().getMaHoaDon());
        
        return new HoaDonDoiTra(x.getMaHoaDonDoiHang(), x.getTongTienHoanTra(), x.getNgayTaoHoaDon(), x.getMoTa(), hd, kh, nv);
    }

    @Override
    public HoaDonDoiTraMoDel them(HoaDonDoiTraMoDel HoaDonDoiTraMoDel) {
        HoaDonDoiTra hoaDonDoiTra = _IHoaDonTraRepositories.insert(getHoaDonDoiTra(HoaDonDoiTraMoDel));
        if (hoaDonDoiTra == null) {
            return null;
        }
        HoaDon dmsp = _IHoaDonRepository.getHoadonById(HoaDonDoiTraMoDel.getHoaDonModel().getMaHoaDon());
        
        NhanVienModel nhanVienModel = new NhanVienModel(dmsp.getNhanvien().getMaNhanVien(), dmsp.getNhanvien().getHoTen(), dmsp.getNhanvien().getNgaySinh(), dmsp.getNhanvien().isGioiTinh(), dmsp.getNhanvien().getSoDienThoai(), dmsp.getNhanvien().getEmail(), dmsp.getNhanvien().getDiaChi(), dmsp.getNhanvien().getCCCD(), dmsp.getNhanvien().getChucVu(), dmsp.getNhanvien().getTrangThai(), dmsp.getNhanvien().getMatKhau());
        
        KhachHangModel kdmd = new KhachHangModel(dmsp.getKhachhang().getMaKhachHang(), dmsp.getKhachhang().getHoTen(), dmsp.getKhachhang().getSoDienThoai(), dmsp.getKhachhang().getDiaChi(), dmsp.getKhachhang().getEmail(), dmsp.getKhachhang().getDiem());
        KhuyenMaiModel kmmd = new KhuyenMaiModel(dmsp.getKhuyenmai().getIdKhuyenMai(), dmsp.getKhuyenmai().getTenKhuyenMai(), dmsp.getKhuyenmai().getNgayBatDau(), dmsp.getKhuyenmai().getNgayKetThuc(), dmsp.getKhuyenmai().getGiaKhuyenMai(), dmsp.getKhuyenmai().getMoTa());
        HoaDonModel hoaDonModel = new HoaDonModel(dmsp.getMaHoaDon(), dmsp.getThoiGianTao(), dmsp.getTrangThai(), nhanVienModel, kdmd, kmmd);
        
        return new HoaDonDoiTraMoDel(hoaDonDoiTra.getMaHoaDonDoiTra(), hoaDonDoiTra.getTongTienHoanTra(), hoaDonDoiTra.getNgayTaoHoaDon(), hoaDonDoiTra.getMoTa(), hoaDonModel, kdmd, HoaDonDoiTraMoDel.getNhanVienModel());
    }

    @Override
    public HoaDonDoiTraMoDel sua(HoaDonDoiTraMoDel HoaDonDoiTraMoDel) {
        boolean checkhd = _IHoaDonTraRepositories.update(getHoaDonDoiTra(HoaDonDoiTraMoDel));
        if (checkhd == false) {
            return null;
        }
        return HoaDonDoiTraMoDel;
    }

    @Override
    public List<HoaDonDoiTraMoDel> getListFromDB() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<HoaDonDoiTraMoDel> getLstToDay(Date ngay) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean xoa(int mahoadontra) {
         return _IHoaDonTraRepositories.delete(mahoadontra);
    }

}
