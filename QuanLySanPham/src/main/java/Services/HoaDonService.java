/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DomainModels.DanhMucSanPham;
import Repositories.HoaDonRepository;
import Repositories.IHoaDonRepository;
import DomainModels.HoaDon;
import DomainModels.KhachHang;
import DomainModels.NhanVien;
import DomainModels.KhachHang;
import DomainModels.KhuyenMai;
import ViewsModels.DanhMucSanPhamModel;
import ViewsModels.HoaDonModel;
import ViewsModels.NhanVienModel;
import ViewsModels.KhuyenMaiModel;
import ViewsModels.KhachHangModel;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Nguyen Van Thuan
 */
public class HoaDonService implements IHoaDonService {

    List<HoaDonModel> _lsthoaDonSpModels;
    IHoaDonRepository _IHoaDonRepository;

    public HoaDonService() {
        _IHoaDonRepository = new HoaDonRepository();
    }

    HoaDon getHonDon(HoaDonModel hdModel) {
        HoaDon hd = new HoaDon();
        hd.setMaHoaDon(hdModel.getMaHoaDon());
        hd.setThoiGianTao(hdModel.getThoiGianTao());
        hd.setTrangThai(hdModel.getTrangThai());

        NhanVien nv = new NhanVien();
        nv.setMaNhanVien(hdModel.getNhanvien().getMaNhanVien());
        nv.setHoTen(hdModel.getNhanvien().getHoTen());
        hd.setNhanvien(nv);
        
        KhachHang kh = new KhachHang();
        kh.setMaKhachHang(hdModel.getKhachhang().getMaKhachHang());
        hd.setKhachhang(kh);

        KhuyenMai km = new KhuyenMai();
        km.setIdKhuyenMai(hdModel.getKhuyenmai().getIdKhuyenMai());
        hd.setKhuyenmai(km);

        return hd;
    }

    @Override
    public HoaDonModel them(HoaDonModel HoaDonModel) {
        HoaDon dmsp = _IHoaDonRepository.insert(getHonDon(HoaDonModel));
        if (dmsp == null) {
            return null;
        }
        NhanVienModel nhanVienModel = new NhanVienModel(dmsp.getNhanvien().getMaNhanVien(), dmsp.getNhanvien().getHoTen(), dmsp.getNhanvien().getNgaySinh(), dmsp.getNhanvien().isGioiTinh(), dmsp.getNhanvien().getSoDienThoai(), dmsp.getNhanvien().getEmail(), dmsp.getNhanvien().getDiaChi(), dmsp.getNhanvien().getCCCD(), dmsp.getNhanvien().getChucVu(), dmsp.getNhanvien().getTrangThai(), dmsp.getNhanvien().getMatKhau());
        KhachHangModel kdmd = new KhachHangModel(dmsp.getKhachhang().getMaKhachHang(), dmsp.getKhachhang().getHoTen(), dmsp.getKhachhang().getSoDienThoai(), dmsp.getKhachhang().getDiaChi(), dmsp.getKhachhang().getEmail(),dmsp.getKhachhang().getDiem());
        KhuyenMaiModel kmmd = new KhuyenMaiModel(dmsp.getKhuyenmai().getIdKhuyenMai(), dmsp.getKhuyenmai().getTenKhuyenMai(), dmsp.getKhuyenmai().getNgayBatDau(), dmsp.getKhuyenmai().getNgayKetThuc(), dmsp.getKhuyenmai().getGiaKhuyenMai(), dmsp.getKhuyenmai().getMoTa());
        return new HoaDonModel(dmsp.getMaHoaDon(), dmsp.getThoiGianTao(), dmsp.getTrangThai(), nhanVienModel, kdmd, kmmd);
    }

    @Override
    public HoaDonModel sua(HoaDonModel HoaDonModel) {
        
        boolean checkhd = _IHoaDonRepository.update(getHonDon(HoaDonModel));
        if (checkhd == false) {
            return null;
        }
        return HoaDonModel;
    }

    @Override
    public List<HoaDonModel> getListFromDB() {
        _lsthoaDonSpModels = new ArrayList<>();
        List<HoaDon> lstdanhMucSp = new ArrayList<>();
        lstdanhMucSp = _IHoaDonRepository.selectAll();
        for (HoaDon x : lstdanhMucSp) {
            NhanVienModel nhanVienModel = new NhanVienModel(x.getNhanvien().getMaNhanVien(), x.getNhanvien().getHoTen(), x.getNhanvien().getNgaySinh(), x.getNhanvien().isGioiTinh(), x.getNhanvien().getSoDienThoai(), x.getNhanvien().getEmail(), x.getNhanvien().getDiaChi(), x.getNhanvien().getCCCD(), x.getNhanvien().getChucVu(), x.getNhanvien().getTrangThai(), x.getNhanvien().getMatKhau());
            KhachHangModel kdmd = new KhachHangModel(x.getKhachhang().getMaKhachHang(), x.getKhachhang().getHoTen(), x.getKhachhang().getSoDienThoai(), x.getKhachhang().getDiaChi(), x.getKhachhang().getEmail(),x.getKhachhang().getDiem());
            KhuyenMaiModel kmmd = new KhuyenMaiModel(x.getKhuyenmai().getIdKhuyenMai(), x.getKhuyenmai().getTenKhuyenMai(), x.getKhuyenmai().getNgayBatDau(), x.getKhuyenmai().getNgayKetThuc(), x.getKhuyenmai().getGiaKhuyenMai(), x.getKhuyenmai().getMoTa());
            _lsthoaDonSpModels.add(new HoaDonModel(x.getMaHoaDon(), x.getThoiGianTao(), x.getTrangThai(), nhanVienModel, kdmd, kmmd));
        }
        return _lsthoaDonSpModels;
    }

    @Override
    public List<HoaDonModel> getLstToDay(Date ngay) {
        _lsthoaDonSpModels = new ArrayList<>();
        List<HoaDon> lstdanhMucSp = new ArrayList<>();
        lstdanhMucSp = _IHoaDonRepository.selectHoaDonToDate(ngay);
        for (HoaDon x : lstdanhMucSp) {
            NhanVienModel nhanVienModel = new NhanVienModel(x.getNhanvien().getMaNhanVien(), x.getNhanvien().getHoTen(), x.getNhanvien().getNgaySinh(), x.getNhanvien().isGioiTinh(), x.getNhanvien().getSoDienThoai(), x.getNhanvien().getEmail(), x.getNhanvien().getDiaChi(), x.getNhanvien().getCCCD(), x.getNhanvien().getChucVu(), x.getNhanvien().getTrangThai(), x.getNhanvien().getMatKhau());
            KhachHangModel kdmd = new KhachHangModel(x.getKhachhang().getMaKhachHang(), x.getKhachhang().getHoTen(), x.getKhachhang().getSoDienThoai(), x.getKhachhang().getDiaChi(), x.getKhachhang().getEmail(),x.getKhachhang().getDiem());
            KhuyenMaiModel kmmd = new KhuyenMaiModel(x.getKhuyenmai().getIdKhuyenMai(), x.getKhuyenmai().getTenKhuyenMai(), x.getKhuyenmai().getNgayBatDau(), x.getKhuyenmai().getNgayKetThuc(), x.getKhuyenmai().getGiaKhuyenMai(), x.getKhuyenmai().getMoTa());
            _lsthoaDonSpModels.add(new HoaDonModel(x.getMaHoaDon(), x.getThoiGianTao(), x.getTrangThai(), nhanVienModel, kdmd, kmmd));
        }
        return _lsthoaDonSpModels;
    }

//    @Override
//    public int getMaxIdHoaDon() {
//        return _lsthoaDonSpModels.size() + 1;
//    }
}
