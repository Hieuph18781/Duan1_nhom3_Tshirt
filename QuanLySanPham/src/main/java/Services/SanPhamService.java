/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DomainModels.SanPham;
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
public class SanPhamService implements ISanPhamService{
    List<SanPhamModel> _lstsanpham;
    ISanPhamRepository _sanphamservice;
    
    public SanPhamService(){
        _sanphamservice = new SanPhamRepository();
    }
    
    SanPham getDanhMucRpst(SanPhamModel dSanPhamModel) {
        SanPham SP = new SanPham();
        SP.setMaSanPham(dSanPhamModel.getMaSanPham());
        SP.setTenSanPham(dSanPhamModel.getTenSanPham());
        SP.getChatlieu().setMaChatLieu(dSanPhamModel.getChatlieuModel().getMaChatLieu());
        SP.getDanhMucSanPham().setMaDanhMuc(dSanPhamModel.getDanhMucSanPhamModel().getMaDanhMuc());
        SP.getKieudang().setMaKieuDang(dSanPhamModel.getKieudangModel().getMaKieuDang());
        SP.getMausac().setMaMauSac(dSanPhamModel.getMausacModel().getMaMauSac());
        SP.getSize().setMaSize(dSanPhamModel.getSizeModel().getMaSize());
        SP.setSoLuong(dSanPhamModel.getSoLuong());
        SP.setMota(dSanPhamModel.getMota());
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
            KieuDangModel kdmd = new KieuDangModel();
            kdmd.setMaKieuDang(x.getKieudang().getMaKieuDang());
            DanhMucSanPhamModel dmsp = new DanhMucSanPhamModel();
            dmsp.setMaDanhMuc(x.getDanhMucSanPham().getMaDanhMuc());
            MauSacModel msmd = new MauSacModel();
            msmd.setMaMauSac(x.getMausac().getMaMauSac());
            SizeModel szmd = new SizeModel();
            szmd.setMaSize(x.getSize().getMaSize());
            _lstsanpham.add(new SanPhamModel(x.getMaSanPham(), x.getTenSanPham(), x.getSoLuong(), x.getGia(), x.getMota(),
                    clmd
                    , kdmd
                    , dmsp
                    , msmd
                    , szmd));
    }
        return _lstsanpham;
    }

    @Override
    public String them(SanPhamModel danhMucSanPhamModel) {
        SanPham dmsp = _sanphamservice.insert(getDanhMucRpst(danhMucSanPhamModel));
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
    public int getmamausac() {
        return  _lstsanpham.size() +1;
    }

    @Override
    public List<SanPhamModel> Timkiem(String ten) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
