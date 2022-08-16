/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DomainModels.HoaDonChiTiet;
import DomainModels.HoaDonDoiTra;
import DomainModels.HoaDonTraChiTiet;
import DomainModels.NhanVien;
import DomainModels.SanPham;
import Repositories.HoaDonChiTietRepository;
import Repositories.HoaDonDoiTraChiTietRepositories;
import Repositories.IHoaDonChiTietRepository;
import Repositories.IHoaDonDoiTraChiTietRepositories;
import ViewsModels.ChatLieuModel;
import ViewsModels.DanhMucSanPhamModel;
import ViewsModels.HoaDonChiTietModel;
import ViewsModels.HoaDonDoiTraChiTietModel;
import ViewsModels.HoaDonDoiTraMoDel;
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
public class HoaDonDoiTraChiTietService implements IHoaDonDoiTraChiTietService {

    List<HoaDonDoiTraChiTietModel> _lsthoaDonDoiTraChiTietModels;
    IHoaDonDoiTraChiTietRepositories _IHoaDonDoiTraChiTietRepositories;

    public HoaDonDoiTraChiTietService() {
        _IHoaDonDoiTraChiTietRepositories = new HoaDonDoiTraChiTietRepositories();
    }
    
    HoaDonTraChiTiet getHoaDonDtCt(HoaDonDoiTraChiTietModel HoaDonDoiTraChiTietModel){
        HoaDonDoiTra hddt = new HoaDonDoiTra();
        hddt.setMaHoaDonDoiTra(HoaDonDoiTraChiTietModel.getHoaDonDoiTraModel().getMaHoaDonDoiHang());
        
        SanPham nv = new SanPham();
        nv.setMaSanPham(HoaDonDoiTraChiTietModel.getSanPhamModel().getMaSanPham());
        
        
        return new HoaDonTraChiTiet(HoaDonDoiTraChiTietModel.getMaHoaDonDoiTraChiTiet(), HoaDonDoiTraChiTietModel.getSoLuong(), HoaDonDoiTraChiTietModel.getDonGia(), hddt, nv);
    }
    
    @Override
    public HoaDonDoiTraChiTietModel them(HoaDonDoiTraChiTietModel HoaDonDoiTraChiTietModel) {
        for (HoaDonDoiTraChiTietModel x : getListFromDB(HoaDonDoiTraChiTietModel.getHoaDonDoiTraModel().getMaHoaDonDoiHang())) {
            if (x.getSanPhamModel().getMaSanPham().equals(HoaDonDoiTraChiTietModel.getSanPhamModel().getMaSanPham())
                    && x.getHoaDonDoiTraModel().getMaHoaDonDoiHang() == HoaDonDoiTraChiTietModel.getHoaDonDoiTraModel().getMaHoaDonDoiHang()
                ) {
                HoaDonDoiTraChiTietModel.setMaHoaDonDoiTraChiTiet(x.getMaHoaDonDoiTraChiTiet());
                HoaDonDoiTraChiTietModel.setSoLuong(x.getSoLuong()+HoaDonDoiTraChiTietModel.getSoLuong());
                return sua(HoaDonDoiTraChiTietModel);
            }
        }
        HoaDonTraChiTiet dmsp = _IHoaDonDoiTraChiTietRepositories.insert(getHoaDonDtCt(HoaDonDoiTraChiTietModel));
        if (dmsp == null) {
            return null;
        }
        return HoaDonDoiTraChiTietModel;
    }

    @Override
    public HoaDonDoiTraChiTietModel sua(HoaDonDoiTraChiTietModel HoaDondcctModel) {
        boolean checkhd = _IHoaDonDoiTraChiTietRepositories.update(getHoaDonDtCt(HoaDondcctModel));
        if (checkhd == false) {
            return null;
        }
        return HoaDondcctModel;
    }

    @Override
    public boolean xoa(HoaDonDoiTraChiTietModel HoaDondcctModel) {
        return _IHoaDonDoiTraChiTietRepositories.delete(getHoaDonDtCt(HoaDondcctModel));
    }

    @Override
    public List<HoaDonDoiTraChiTietModel> getListFromDB(int MaHoaDonDoiTra) {
        _lsthoaDonDoiTraChiTietModels = new ArrayList<>();
        if (MaHoaDonDoiTra == -1) {
            return _lsthoaDonDoiTraChiTietModels;
        }
        List<HoaDonTraChiTiet> lts = _IHoaDonDoiTraChiTietRepositories.selectAll(MaHoaDonDoiTra);
        for (HoaDonTraChiTiet x : lts) {
            
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
            
            NhanVienModel nhanVienModel = new NhanVienModel(x.getHoadondoitra().getNhanvien().getMaNhanVien(), x.getHoadondoitra().getNhanvien().getHoTen(), x.getHoadondoitra().getNhanvien().getNgaySinh(), x.getHoadondoitra().getNhanvien().isGioiTinh(), x.getHoadondoitra().getNhanvien().getSoDienThoai(), x.getHoadondoitra().getNhanvien().getEmail(), x.getHoadondoitra().getNhanvien().getDiaChi(), x.getHoadondoitra().getNhanvien().getCCCD(), x.getHoadondoitra().getNhanvien().getChucVu(), x.getHoadondoitra().getNhanvien().getTrangThai(), x.getHoadondoitra().getNhanvien().getMatKhau());
        
        KhachHangModel kdmd1 = new KhachHangModel(x.getHoadondoitra().getKhachhang().getMaKhachHang(), x.getHoadondoitra().getKhachhang().getHoTen(), x.getHoadondoitra().getKhachhang().getSoDienThoai(), x.getHoadondoitra().getKhachhang().getDiaChi(), x.getHoadondoitra().getKhachhang().getEmail(), x.getHoadondoitra().getKhachhang().getDiem());
        
        KhuyenMaiModel kmmd = new KhuyenMaiModel(x.getHoadondoitra().getHoadon().getKhuyenmai().getIdKhuyenMai(), x.getHoadondoitra().getHoadon().getKhuyenmai().getTenKhuyenMai(), x.getHoadondoitra().getHoadon().getKhuyenmai().getNgayBatDau(), x.getHoadondoitra().getHoadon().getKhuyenmai().getNgayKetThuc(), x.getHoadondoitra().getHoadon().getKhuyenmai().getGiaKhuyenMai(), x.getHoadondoitra().getHoadon().getKhuyenmai().getMoTa());
        
        HoaDonModel hoaDonModel = new HoaDonModel(x.getHoadondoitra().getHoadon().getMaHoaDon(), x.getHoadondoitra().getHoadon().getThoiGianTao(), x.getHoadondoitra().getHoadon().getTrangThai(), nhanVienModel, kdmd1, kmmd);
            
            HoaDonDoiTraMoDel hddtmd = new HoaDonDoiTraMoDel(x.getHoadondoitra().getMaHoaDonDoiTra(), x.getHoadondoitra().getTongTienHoanTra(), x.getHoadondoitra().getNgayTaoHoaDon(), x.getHoadondoitra().getMoTa(),hoaDonModel , kdmd1, nhanVienModel);
            _lsthoaDonDoiTraChiTietModels.add(new HoaDonDoiTraChiTietModel(x.getMaHoaDonTraChiTiet(), x.getSoLuong(), x.getDonGia(), hddtmd, spmd));
        }
        
        return _lsthoaDonDoiTraChiTietModels;
    }

}
