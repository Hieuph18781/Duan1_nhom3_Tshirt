/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DomainModels.HoaDon;
import DomainModels.HoaDonChiTiet;
import DomainModels.SanPham;
import Repositories.HoaDonChiTietRepository;
import Repositories.HoaDonRepository;
import Repositories.IHoaDonChiTietRepository;
import Repositories.IHoaDonRepository;
import ViewsModels.ChatLieuModel;
import ViewsModels.DanhMucSanPhamModel;
import ViewsModels.HoaDonChiTietModel;
import ViewsModels.HoaDonModel;
import ViewsModels.KhachHangModel;
import ViewsModels.KhuyenMaiModel;
import ViewsModels.KieuDangModel;
import ViewsModels.MauSacModel;
import ViewsModels.NhanVienModel;
import ViewsModels.SanPhamModel;
import ViewsModels.SizeModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nguyen Van Thuan
 */
public class HoaDonChiTietService implements IHoaDonChiTietService {
    
    List<HoaDonChiTietModel> _lsthoaDonChiTietModels;
    IHoaDonChiTietRepository _IHoaDonChiTietRepository;
    
    public HoaDonChiTietService() {
        _IHoaDonChiTietRepository = new HoaDonChiTietRepository();
    }
    
    public HoaDonChiTiet getHdct(HoaDonChiTietModel hoaDonChiTietModel) {
        for (HoaDonChiTietModel x : getListFromDB(hoaDonChiTietModel.getHoaDonModel().getMaHoaDon())) {
            if (x.getHoaDonModel().getMaHoaDon() == hoaDonChiTietModel.getHoaDonModel().getMaHoaDon()
               && 
                x.getSanPhamModel().getMaSanPham().equals(hoaDonChiTietModel.getSanPhamModel().getMaSanPham())) 
            {
                hoaDonChiTietModel.setMaHoaDonCT(x.getMaHoaDonCT());
            }
        }
        System.out.println("---"+hoaDonChiTietModel.getSanPhamModel().getMaSanPham());
        HoaDonChiTiet hdct = new HoaDonChiTiet(hoaDonChiTietModel.getMaHoaDonCT(), hoaDonChiTietModel.getSoLuong(), hoaDonChiTietModel.getDonGia(), new HoaDon(hoaDonChiTietModel.getHoaDonModel().getMaHoaDon()), new SanPham(hoaDonChiTietModel.getSanPhamModel().getMaSanPham()));
        return hdct;
    }
    
    @Override
    public HoaDonChiTietModel them(HoaDonChiTietModel HoaDonChiTietModel) {
        for (HoaDonChiTietModel x : getListFromDB(HoaDonChiTietModel.getHoaDonModel().getMaHoaDon())) {
            if (x.getHoaDonModel().getMaHoaDon() == HoaDonChiTietModel.getHoaDonModel().getMaHoaDon()
                    && x.getSanPhamModel().getMaSanPham().equals(HoaDonChiTietModel.getSanPhamModel().getMaSanPham())) {
                x.setSoLuong(x.getSoLuong() + 1);
//                System.out.println(x.getMaHoaDonCT());
                return sua(x);
            }
        }
        HoaDonChiTiet dmsp = _IHoaDonChiTietRepository.insert(getHdct(HoaDonChiTietModel));
        if (dmsp == null) {
            return null;
        }
        return HoaDonChiTietModel;
    }
    
    @Override
    public HoaDonChiTietModel sua(HoaDonChiTietModel HoaDonModel) {
        boolean checkhd = _IHoaDonChiTietRepository.update(getHdct(HoaDonModel));
        if (checkhd == false) {
            return null;
        }
        return HoaDonModel;
    }
    
    @Override
    public List<HoaDonChiTietModel> getListFromDB(int MaHoaDon) {
        _lsthoaDonChiTietModels = new ArrayList<>();
        if (MaHoaDon==-1) {
            return _lsthoaDonChiTietModels;
        }
        List<HoaDonChiTiet> hoaDonChiTiets = new ArrayList<>();
        hoaDonChiTiets = _IHoaDonChiTietRepository.selectAll(MaHoaDon);
        for (HoaDonChiTiet x : hoaDonChiTiets) {
            ChatLieuModel clmd = new ChatLieuModel();
            clmd.setMaChatLieu(x.getSanpham().getChatlieu().getMaChatLieu());
            clmd.setTenChatLieu(x.getSanpham().getChatlieu().getTenChatLieu());
            
            KieuDangModel kdmd = new KieuDangModel();
            kdmd.setMaKieuDang(x.getSanpham().getKieudang().getMaKieuDang());
            kdmd.setTenKieuDang(x.getSanpham().getKieudang().getTenKieuDang());
            
            DanhMucSanPhamModel dmsp = new DanhMucSanPhamModel();
            dmsp.setMaDanhMuc(x.getSanpham().getDanhMucSanPham().getMaDanhMuc());
            dmsp.setTenDanhMuc(x.getSanpham().getDanhMucSanPham().getTenDanhMuc());
            
            MauSacModel msmd = new MauSacModel();
            msmd.setMaMauSac(x.getSanpham().getMausac().getMaMauSac());
            msmd.setTenMauSac(x.getSanpham().getMausac().getTenMauSac());
            
            SizeModel szmd = new SizeModel();
            szmd.setMaSize(x.getSanpham().getSize().getMaSize());
            szmd.setTenSize(x.getSanpham().getSize().getTenSize());
            SanPhamModel spmd = new SanPhamModel(x.getSanpham().getMaSanPham(), x.getSanpham().getTenSanPham(), x.getSanpham().getSoLuong(), x.getSanpham().getGia(), x.getSanpham().getMota(), x.getSanpham().getTrangThai(), clmd, kdmd, dmsp, msmd, szmd);
            
            NhanVienModel nhanVienModel = new NhanVienModel(x.getHoadon().getNhanvien().getMaNhanVien(), x.getHoadon().getNhanvien().getHoTen(), x.getHoadon().getNhanvien().getNgaySinh(), x.getHoadon().getNhanvien().isGioiTinh(), x.getHoadon().getNhanvien().getSoDienThoai(), x.getHoadon().getNhanvien().getEmail(), x.getHoadon().getNhanvien().getDiaChi(), x.getHoadon().getNhanvien().getCCCD(), x.getHoadon().getNhanvien().getChucVu(), x.getHoadon().getNhanvien().getTrangThai(), x.getHoadon().getNhanvien().getMatKhau());
            
            KhachHangModel khmd = new KhachHangModel(x.getHoadon().getKhachhang().getMaKhachHang(), x.getHoadon().getKhachhang().getHoTen(), x.getHoadon().getKhachhang().getSoDienThoai(), x.getHoadon().getKhachhang().getDiaChi(), x.getHoadon().getKhachhang().getEmail(),x.getHoadon().getKhachhang().getDiem());
            
            KhuyenMaiModel kmmd = new KhuyenMaiModel(x.getHoadon().getKhuyenmai().getIdKhuyenMai(), x.getHoadon().getKhuyenmai().getTenKhuyenMai(), x.getHoadon().getKhuyenmai().getNgayBatDau(), x.getHoadon().getKhuyenmai().getNgayKetThuc(), x.getHoadon().getKhuyenmai().getGiaKhuyenMai(), x.getHoadon().getKhuyenmai().getMoTa());
            
            HoaDonModel hdmd = new HoaDonModel(x.getHoadon().getMaHoaDon(), x.getHoadon().getThoiGianTao(), x.getHoadon().getTrangThai(), nhanVienModel, khmd, kmmd);
            _lsthoaDonChiTietModels.add(new HoaDonChiTietModel(x.getMaHoaDonCT(), x.getSoLuong(), x.getDonGia(), spmd, hdmd));
        }
        return _lsthoaDonChiTietModels;
    }
    
    @Override
    public boolean xoa(HoaDonChiTietModel HoaDonModel) {
        return _IHoaDonChiTietRepository.delete(getHdct(HoaDonModel));
    }
    
}
