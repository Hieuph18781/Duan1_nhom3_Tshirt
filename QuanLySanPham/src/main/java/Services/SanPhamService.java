/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DomainModels.ChatLieu;
import DomainModels.DanhMucSanPham;
import DomainModels.KieuDang;
import DomainModels.MauSac;
import DomainModels.SanPham;
import DomainModels.Size;
import Repositories.ISanPhamRepository;
import Repositories.SanPhamRepository;
import ViewsModels.ChatLieuModel;
import ViewsModels.DanhMucSanPhamModel;
import ViewsModels.KieuDangModel;
import ViewsModels.MauSacModel;
import ViewsModels.SanPhamModel;
import ViewsModels.SizeModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hieu
 */
public class SanPhamService implements ISanPhamService {

    List<SanPhamModel> _lstsanpham;
    ISanPhamRepository _sanphamservice;
    IManageChatLieuService _ChatLieuService;

    public SanPhamService() {
        _sanphamservice = new SanPhamRepository();
        _ChatLieuService = new ManageChatLieuService();
    }

    SanPham getDanhMucRpst(SanPhamModel dSanPhamModel) {
        SanPham SP = new SanPham();
        SP.setMaSanPham(dSanPhamModel.getMaSanPham());
        SP.setTenSanPham(dSanPhamModel.getTenSanPham());

        SP.setChatlieu(new ChatLieu(dSanPhamModel.getChatlieuModel().getMaChatLieu(), dSanPhamModel.getChatlieuModel().getTenChatLieu(), dSanPhamModel.getChatlieuModel().getMota()));

        SP.setDanhMucSanPham(new DanhMucSanPham(dSanPhamModel.getDanhMucSanPhamModel().getMaDanhMuc(), dSanPhamModel.getDanhMucSanPhamModel().getTenDanhMuc(), dSanPhamModel.getDanhMucSanPhamModel().getMota()));

        SP.setKieudang(new KieuDang(dSanPhamModel.getKieudangModel().getMaKieuDang(), dSanPhamModel.getKieudangModel().getTenKieuDang(), dSanPhamModel.getKieudangModel().getMota(), dSanPhamModel.getKieudangModel().getHinhAnh()));

        SP.setMausac(new MauSac(dSanPhamModel.getMausacModel().getMaMauSac(), dSanPhamModel.getMausacModel().getTenMauSac(), dSanPhamModel.getMausacModel().getMota()));

        SP.setSize(new Size(dSanPhamModel.getSizeModel().getMaSize(), dSanPhamModel.getSizeModel().getTenSize(), dSanPhamModel.getSizeModel().getMota()));

        SP.setSoLuong(dSanPhamModel.getSoLuong());
        SP.setMota(dSanPhamModel.getMota());
        SP.setGia(dSanPhamModel.getGia());
        SP.setTrangThai(dSanPhamModel.isTrangThai());
        return SP;
    }

    @Override
    public List<SanPhamModel> getlistsanpham() {
        _lstsanpham = new ArrayList<>();
        List<SanPham> lstSp = new ArrayList<>();
        lstSp = _sanphamservice.findAll();
        for (SanPham x : lstSp) {
            ChatLieuModel clmd = new ChatLieuModel();
            clmd.setMaChatLieu(x.getChatlieu().getMaChatLieu());
            clmd.setTenChatLieu(x.getChatlieu().getTenChatLieu());

            KieuDangModel kdmd = new KieuDangModel();
            kdmd.setMaKieuDang(x.getKieudang().getMaKieuDang());
            kdmd.setTenKieuDang(x.getKieudang().getTenKieuDang());

            DanhMucSanPhamModel dmsp = new DanhMucSanPhamModel();
            dmsp.setMaDanhMuc(x.getDanhMucSanPham().getMaDanhMuc());
            dmsp.setTenDanhMuc(x.getDanhMucSanPham().getTenDanhMuc());

            MauSacModel msmd = new MauSacModel();
            msmd.setMaMauSac(x.getMausac().getMaMauSac());
            msmd.setTenMauSac(x.getMausac().getTenMauSac());

            SizeModel szmd = new SizeModel();
            szmd.setMaSize(x.getSize().getMaSize());
            szmd.setTenSize(x.getSize().getTenSize());

            _lstsanpham.add(new SanPhamModel(x.getMaSanPham(), x.getTenSanPham(), x.getSoLuong(), x.getGia(), x.getMota(), x.getTrangThai(), clmd, kdmd, dmsp, msmd, szmd));
        }
        return _lstsanpham;
    }

    @Override
    public String them(SanPhamModel danhMucSanPhamModel) {
        SanPham dmsp = _sanphamservice.insert(getDanhMucRpst(danhMucSanPhamModel));
        System.out.println("1213");
        if (dmsp == null) {
            return "Thêm Không thành công";
        }
        return "Thêm thành công";
    }

    @Override
    public String sua(SanPhamModel danhMucSanPhamModel) {
        boolean checkdmsp = _sanphamservice.update(getDanhMucRpst(danhMucSanPhamModel));
        if (checkdmsp == false) {
            return "Sửa Không thành công";
        }
        return "Sửa thành công";
    }

    @Override
    public String getMaSanPham() {
        return "MaSP" + (_lstsanpham.size() + 1);
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
    public boolean suaSoLuongSP(String MaSp, int soLuong) {
        return _sanphamservice.updateSoLuongSP(MaSp, soLuong);
    }

    @Override
    public List<SanPhamModel> getlstGiaAndMaSp(int gia, String maSanPham) {
        List<SanPhamModel> getlstspham = new ArrayList<>();
        List<SanPham> lstSp = new ArrayList<>();
        lstSp = _sanphamservice.findAll();
        for (SanPham x : lstSp) {
            ChatLieuModel clmd = new ChatLieuModel();
            clmd.setMaChatLieu(x.getChatlieu().getMaChatLieu());
            clmd.setTenChatLieu(x.getChatlieu().getTenChatLieu());

            KieuDangModel kdmd = new KieuDangModel();
            kdmd.setMaKieuDang(x.getKieudang().getMaKieuDang());
            kdmd.setTenKieuDang(x.getKieudang().getTenKieuDang());

            DanhMucSanPhamModel dmsp = new DanhMucSanPhamModel();
            dmsp.setMaDanhMuc(x.getDanhMucSanPham().getMaDanhMuc());
            dmsp.setTenDanhMuc(x.getDanhMucSanPham().getTenDanhMuc());

            MauSacModel msmd = new MauSacModel();
            msmd.setMaMauSac(x.getMausac().getMaMauSac());
            msmd.setTenMauSac(x.getMausac().getTenMauSac());

            SizeModel szmd = new SizeModel();
            szmd.setMaSize(x.getSize().getMaSize());
            szmd.setTenSize(x.getSize().getTenSize());

            getlstspham.add(new SanPhamModel(x.getMaSanPham(), x.getTenSanPham(), x.getSoLuong(), x.getGia(), x.getMota(), x.getTrangThai(), clmd, kdmd, dmsp, msmd, szmd));
        }
        return getlstspham;
    }

}
