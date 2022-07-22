/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DomainModels.KieuDang;
import DomainModels.MauSac;
import Repositories.KieuDangRepository;

import java.util.ArrayList;
import java.util.List;
import Repositories.IKieuDangRepository;
import ViewsModel.KieuDangModel;

/**
 *
 * @author hieu
 */
public class KieuDangService implements IKieuDangService{
IKieuDangRepository _iTruyvankieudang;
        List<KieuDangModel> _lstkieudang;
        
        public KieuDangService(){
            _iTruyvankieudang = new KieuDangRepository();
            _lstkieudang = new ArrayList<>();
        }

    @Override
    public List<KieuDangModel> getproduct() {
         _lstkieudang = new ArrayList<>();
        var kieudang = _iTruyvankieudang.findAll();
        for (KieuDang x : kieudang) {
            _lstkieudang.add(new KieuDangModel(x.getMaKieuDang(), x.getTenKieuDang(), x.getMota()));
        }
        return _lstkieudang;
    }

    @Override
    public KieuDangModel createNewProduct(KieuDangModel kieudang) {
         var x = _iTruyvankieudang.Save(new KieuDang(kieudang.getMaKieuDang(), kieudang.getTenKieuDang(), kieudang.getMota()));
         return new KieuDangModel(x.getMaKieuDang(), x.getTenKieuDang(), x.getMota());
    }

    @Override
    public KieuDangModel updateProductById(KieuDangModel kieudang) {
       var x = _iTruyvankieudang.Save(new KieuDang(kieudang.getMaKieuDang(), kieudang.getTenKieuDang(), kieudang.getMota()));
         return new KieuDangModel(x.getMaKieuDang(), x.getTenKieuDang(), x.getMota());
    }

   
    
      
}
