/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DomainModels.KhuyenMai;
import Repositories.IKhuyenmaiRepository;
import Repositories.KhuyenMaiRepository;
import ViewsModels.KhuyenMaiModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hieu
 */
public class KhuyenMaiService implements IKhuyenMaiService{
    List<KhuyenMaiModel> _lstkhuyenmai;
    IKhuyenmaiRepository _Ikhuyenmairepo;
    public KhuyenMaiService(){
        _Ikhuyenmairepo = new KhuyenMaiRepository();
        
    }
    
    KhuyenMai getkm(KhuyenMaiModel kmModel){
          KhuyenMai km = new KhuyenMai();
        km.setIdKhuyenMai(kmModel.getIdKhuyenMai());
        km.setTenKhuyenMai(kmModel.getTenKhuyenMai());
        km.setNgayBatDau(kmModel.getNgayBatDau());
        km.setNgayKetThuc(kmModel.getNgayKetThuc());
        km.setGiaKhuyenMai(kmModel.getGiaKhuyenMai());
        km.setMoTa(kmModel.getMoTa());
        return km;
    }
    @Override
    public String them(KhuyenMaiModel kmModel) {
        KhuyenMai dmsp = _Ikhuyenmairepo.insert(getkm(kmModel));
        if (dmsp == null) {
            return "Thêm Không thành công";
        }
        return "Thêm thành công";
    }

    @Override
    public String sua(KhuyenMaiModel kmModel) {
        boolean checkdmsp = _Ikhuyenmairepo.update(getkm(kmModel));
        if (checkdmsp == false) {
            return "Sửa Không thành công";
        }
        return "Sửa thành công";
    }

    @Override
    public List<KhuyenMaiModel> getListFromDB() {
         _lstkhuyenmai = new ArrayList<>();
        List<KhuyenMai> lstdanhMucSp = new ArrayList<>();
        lstdanhMucSp = _Ikhuyenmairepo.selectAll();
        for (KhuyenMai x : lstdanhMucSp) {
        
            _lstkhuyenmai.add(new KhuyenMaiModel(x.getIdKhuyenMai(), x.getTenKhuyenMai(), x.getNgayBatDau(), x.getNgayKetThuc(), x.getGiaKhuyenMai(), x.getMoTa()));
        }
            return _lstkhuyenmai;
    }

    @Override
    public int getMaDanhMuc() {
        return _lstkhuyenmai.size() + 1;
    }

    @Override
    public List<KhuyenMaiModel> findDanhMucSp(String tenDmSp) {
        List<KhuyenMaiModel> ms = new ArrayList<>();
       List<KhuyenMai> mausac = new ArrayList<>();
        for (KhuyenMai x : _Ikhuyenmairepo.selectAll()) {
            if (x.getTenKhuyenMai().toLowerCase().contains(tenDmSp.toLowerCase()) ) {
                ms.add(new KhuyenMaiModel(x.getIdKhuyenMai(), x.getTenKhuyenMai(), x.getNgayBatDau(), x.getNgayKetThuc(), x.getGiaKhuyenMai(), x.getMoTa()));
                System.out.println(ms + "ádsd");
            }
        }
        return ms;
    }
    
}
