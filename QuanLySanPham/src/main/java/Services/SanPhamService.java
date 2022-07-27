/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DomainModels.MauSac;
import DomainModels.SanPham;
import Repositories.IMauSacRepository;
import Repositories.ISanPhamRepository;
import Repositories.SanPhamRepository;
import ViewsModels.DanhMucSanPhamModel;
import ViewsModels.MauSacModel;
import ViewsModels.SanPhamModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hieu
 */
public class SanPhamService implements ISanPhamService{
    ISanPhamRepository _iSanphamRepository;
    List<SanPhamModel> _lstSanpham;
    
    List<MauSacModel> _lstMausac;
    
    public SanPhamService(){
         _iSanphamRepository = new SanPhamRepository();
         _lstSanpham = new ArrayList<>();
    }
    
    SanPham Getdssp(SanPhamModel sanphams){
        SanPham sp = new SanPham();
        sp.setMaSanPham(sanphams.getMaSanPham());
        sp.setTenSanPham(sanphams.getTenSanPham());
        sp.setKieudang(sanphams.getKieudang());
        sp.setChatlieu(sanphams.getChatlieu());
        sp.setDanhMucSanPham(sanphams.getDanhMucSanPham());
        sp.setMota(sanphams.getMota());
        sp.setMausac(sanphams.getMausac());
        sp.setSize(sanphams.getSize());
        sp.setGia(sanphams.getGia());
        sp.setSoLuong(sanphams.getSoLuong());      
        return sp;
    }

    @Override
    public int getMaSanPham() {
        return _lstSanpham.size() + 1;
    }

    @Override
    public String Ins(SanPhamModel SanPhamModel) {
        SanPham sp = _iSanphamRepository.insert(Getdssp(SanPhamModel));
        if (sp == null) {
            return "Thêm thành công";
        }
        return "Thêm không thành công";
    }
    

    @Override
    public String Up(SanPhamModel SanPhamModel) {
        boolean checkint = _iSanphamRepository.update(Getdssp(SanPhamModel));
        if (checkint == false) {
            return "thêm không thành công";
        }
        return "Thêm thành công";
    }

//    @Override
//    public List<SanPhamModel> getList() {
//        _lstSanpham =  new ArrayList<>();
//        var sanphams = _iSanphamRepository.selectAll();
//        for (SanPham x : sanphams) {
//            _lstSanpham.add(new SanPhamModel(x.getMaSanPham(), x.getTenSanPham(), x.getSoLuong(), x.getGia(), x.getMota(), x.getTrangThai(), x.getChatlieu(), x.getKieudang(),x.getDanhMucSanPham(), x.getMausac(), x.getSize()));
//        }
//        return _lstSanpham;
//    }

//    @Override
//    public List<MauSacModel> getList1() {
////         _lstMausac = new ArrayList<>();
////        var colorr = _iSanphamRepository.selectAllms();
////        for (MauSac x : colorr) {
////            _lstMausac.add(new MauSacModel(x.getMaMauSac(), x.getTenMauSac(), x.getMota()));
////        }
////        return _lstMausac;
//    }

    @Override
    public List<DanhMucSanPhamModel> getList2() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
