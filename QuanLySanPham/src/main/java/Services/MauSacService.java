/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DomainModels.MauSac;
import Repositories.MauSacRepository;
import ViewsModels.MauSacModel;
import java.util.ArrayList;
import java.util.List;
import Repositories.IMauSacRepository;
import ViewsModels.DanhMucSanPhamModel;

/**
 *
 * @author hieu
 */
public class MauSacService implements IMauSacService{
        IMauSacRepository _iTruyvanmausac;
        List<MauSacModel> _lstMausac;
        
        public MauSacService(){
            _iTruyvanmausac = new MauSacRepository();
            _lstMausac = new ArrayList<>();
        }
MauSac getDanhMucRpst(MauSacModel danhMucSanPhamModel){
        MauSac danhmucSP = new MauSac();
        danhmucSP.setMaMauSac(danhMucSanPhamModel.getMaMauSac());
        danhmucSP.setTenMauSac(danhMucSanPhamModel.getTenMauSac());
        danhmucSP.setMota(danhMucSanPhamModel.getMota());
        return danhmucSP;
    }
    @Override
    public List<MauSacModel> getproduct() {
         _lstMausac = new ArrayList<>();
        var colorr = _iTruyvanmausac.findAll();
        for (MauSac x : colorr) {
            _lstMausac.add(new MauSacModel(x.getMaMauSac(), x.getTenMauSac(), x.getMota()));
        }
        return _lstMausac;
    }

    

    @Override
    public int getmamausac() {
      return _lstMausac.size()+1;
        
    }

    @Override
    public String them(MauSacModel danhMucSanPhamModel) {
        MauSac dmsp = _iTruyvanmausac.insert(getDanhMucRpst(danhMucSanPhamModel));
        if (dmsp == null) {
            return "Thêm Không thành công";
        }
        return "Thêm thành công";
    }

    @Override
    public String sua(MauSacModel danhMucSanPhamModel) {
        boolean checkdmsp = _iTruyvanmausac.update(getDanhMucRpst(danhMucSanPhamModel));
        if (checkdmsp == false) {
            return "Sửa Không thành công";
        }
        return "Sửa thành công";
    }

    @Override
    public List<MauSacModel> Timkiem(String ten) {
        List<MauSacModel> ms = new ArrayList<>();
       List<MauSac> mausac = new ArrayList<>();
        for (MauSac x : _iTruyvanmausac.findAll()) {
            if (x.getTenMauSac().toLowerCase().contains(ten.toLowerCase()) ) {
                ms.add(new MauSacModel(x.getMaMauSac(),x.getTenMauSac(), x.getMota()));
                System.out.println(ms + "ádsd");
            }
        }
        return ms;
    }

    
      
}
