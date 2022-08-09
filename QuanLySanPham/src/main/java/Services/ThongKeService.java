/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DomainModels.HoaDon;
import DomainModels.HoaDonChiTiet;
import Repositories.IThongKeRepository;
import Repositories.ThongKeRepository;
import ViewsModels.HoaDonChiTietModel;
import ViewsModels.HoaDonModel;
import ViewsModels.KhachHangModel;
import ViewsModels.KhuyenMaiModel;
import ViewsModels.NhanVienModel;
import ViewsModels.SanPhamModel;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author dytc0
 */
public class ThongKeService implements IThongKeService {

    IThongKeRepository _IThongKeService;
    List<HoaDonModel> _lstHoaDon;
    List<HoaDonChiTietModel> _lstHoaDonCT;

    public ThongKeService() {
        _IThongKeService = new ThongKeRepository();
        _lstHoaDon = new ArrayList<>();
    }

    @Override
    public List<Object[]> thongke1() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Object[]> thongke2(String a) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Object[]> thongke3(int a, int b) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Object[]> thongke4(int a) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public long TongTien1() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public long TongTien2() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public long TongTien3() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<HoaDonModel> thongke5() {
        _lstHoaDon = new ArrayList<>();
        List<HoaDon> hoadon = new ArrayList<>();
        hoadon = _IThongKeService.thongke5();
        for (HoaDon x : hoadon) {
            NhanVienModel nhanVienModel = new NhanVienModel();
            nhanVienModel.setMaNhanVien(x.getNhanvien().getMaNhanVien());
            KhachHangModel kdmd = new KhachHangModel();
            kdmd.setMaKhachHang(x.getKhachhang().getMaKhachHang());
            KhuyenMaiModel kmmd = new KhuyenMaiModel();
            kmmd.setIdKhuyenMai(x.getKhuyenmai().getIdKhuyenMai());
            _lstHoaDon.add(new HoaDonModel(x.getMaHoaDon(), x.getThoiGianTao(), x.getTrangThai(), nhanVienModel, kdmd, kmmd));
        }
        return _lstHoaDon;
    }

    @Override
    public List<HoaDonModel> thongke6() {
        _lstHoaDon = new ArrayList<>();
        List<HoaDon> hoadon = new ArrayList<>();
        hoadon = _IThongKeService.thongke6();
        for (HoaDon x : hoadon) {
            NhanVienModel nhanVienModel = new NhanVienModel();
            nhanVienModel.setMaNhanVien(x.getNhanvien().getMaNhanVien());
            KhachHangModel kdmd = new KhachHangModel();
            kdmd.setMaKhachHang(x.getKhachhang().getMaKhachHang());
            KhuyenMaiModel kmmd = new KhuyenMaiModel();
            kmmd.setIdKhuyenMai(x.getKhuyenmai().getIdKhuyenMai());
            _lstHoaDon.add(new HoaDonModel(x.getMaHoaDon(), x.getThoiGianTao(), x.getTrangThai(), nhanVienModel, kdmd, kmmd));
        }
        return _lstHoaDon;
    }

    @Override
    public boolean Timkiem(String chuoi1, String chuoi2) {
        String pattern = ".*" + Utils.CheckData.unAccent(chuoi2.toLowerCase()) + ".*";
        if (Utils.CheckData.unAccent(chuoi1).toLowerCase().matches(pattern)) {
            return true;
        }
        return false;
    }

    @Override
    public List<HoaDonModel> thongke7(Date a, Date b) {
        _lstHoaDon = new ArrayList<>();
        List<HoaDon> hoadon = new ArrayList<>();
        hoadon = _IThongKeService.thongke7(a, b);
        for (HoaDon x : hoadon) {
            NhanVienModel nhanVienModel = new NhanVienModel();
            nhanVienModel.setMaNhanVien(x.getNhanvien().getMaNhanVien());
            KhachHangModel kdmd = new KhachHangModel();
            kdmd.setMaKhachHang(x.getKhachhang().getMaKhachHang());
            KhuyenMaiModel kmmd = new KhuyenMaiModel();
            kmmd.setIdKhuyenMai(x.getKhuyenmai().getIdKhuyenMai());
            _lstHoaDon.add(new HoaDonModel(x.getMaHoaDon(), x.getThoiGianTao(), x.getTrangThai(), nhanVienModel, kdmd, kmmd));
        }
        return _lstHoaDon;
    }

    @Override
    public List<HoaDonModel> thongke8(Date a, Date b) {
        _lstHoaDon = new ArrayList<>();
        List<HoaDon> hoadon = new ArrayList<>();
        hoadon = _IThongKeService.thongke8(a, b);
        for (HoaDon x : hoadon) {
            NhanVienModel nhanVienModel = new NhanVienModel();
            nhanVienModel.setMaNhanVien(x.getNhanvien().getMaNhanVien());
            KhachHangModel kdmd = new KhachHangModel();
            kdmd.setMaKhachHang(x.getKhachhang().getMaKhachHang());
            KhuyenMaiModel kmmd = new KhuyenMaiModel();
            kmmd.setIdKhuyenMai(x.getKhuyenmai().getIdKhuyenMai());
            _lstHoaDon.add(new HoaDonModel(x.getMaHoaDon(), x.getThoiGianTao(), x.getTrangThai(), nhanVienModel, kdmd, kmmd));
        }
        return _lstHoaDon;
    }

    @Override
    public List<Object[]> thongke9(int a) {
        _lstHoaDonCT = new ArrayList<>();

        List<Object[]> list = _IThongKeService.thongke9(a);
        return list;
    }

}
