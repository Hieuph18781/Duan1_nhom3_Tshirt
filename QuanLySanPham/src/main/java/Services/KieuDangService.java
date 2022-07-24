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
import ViewsModels.KieuDangModel;
import javax.swing.JOptionPane;
import org.hibernate.cfg.JPAIndexHolder;

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
 KieuDang getkieudang(KieuDangModel kieudangModel){
        KieuDang kieudangSP = new KieuDang();
       kieudangSP.setMaKieuDang(kieudangModel.getMaKieuDang());
       kieudangSP.setTenKieuDang(kieudangModel.getTenKieuDang());
        kieudangSP.setMota(kieudangModel.getMota());
        return kieudangSP;
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
public String sua(KieuDangModel kieudangModel) {
         boolean checkdmsp = _iTruyvankieudang.update(getkieudang(kieudangModel));
        if (checkdmsp == false) {
            return "Sửa Không thành công";
        }
        return "Sửa thành công";
    }

   
  

      
}
