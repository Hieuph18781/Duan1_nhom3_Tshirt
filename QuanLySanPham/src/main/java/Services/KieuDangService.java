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
import Utils.CheckData;

/**
 *
 * @author hieu
 */
public class KieuDangService implements IKieuDangService {

    IKieuDangRepository _iTruyvankieudang;
    List<KieuDangModel> _lstkieudang;

    public KieuDangService() {
        _iTruyvankieudang = new KieuDangRepository();
        _lstkieudang = new ArrayList<>();
    }

    KieuDang getkieudang(KieuDangModel kieudangModel) {
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
            _lstkieudang.add(new KieuDangModel(x.getMaKieuDang(), x.getTenKieuDang(), x.getMota(), x.getHinhAnh()));
        }
        return _lstkieudang;
    }

    @Override
    public KieuDangModel createNewProduct(KieuDangModel kieudang) {
        kieudang.setMaKieuDang(0);
        var x = _iTruyvankieudang.Save(new KieuDang(kieudang.getMaKieuDang(), kieudang.getTenKieuDang(), kieudang.getMota(), kieudang.getHinhAnh()));
        return new KieuDangModel(x.getMaKieuDang(), x.getTenKieuDang(), x.getMota(), x.getHinhAnh());
    }

    @Override
    public String sua(KieuDangModel kieudangModel) {
        boolean checkdmsp = _iTruyvankieudang.update(getkieudang(kieudangModel));
        if (checkdmsp == false) {
            return "Sửa Không thành công";
        }
        return "Sửa thành công";
    }

    @Override
    public int getMaxIdKieuDang() {
        return _lstkieudang.size() + 1;
    }

    public List<KieuDangModel> findKieuDang(String tenkiedang) {
        List<KieuDangModel> lstFind = new ArrayList<>();
        String pattern = ".*" + Utils.CheckData.unAccent(tenkiedang.toLowerCase()) + ".*";
        if (tenkiedang.isBlank()) {

            return _lstkieudang;
        }

        for (KieuDangModel x : _lstkieudang) {

            if (Utils.CheckData.unAccent(x.getTenKieuDang()).toLowerCase().matches(pattern)) {
                lstFind.add(x);

            }
        }

        return lstFind; //To change body of generated methods, choose Tools | Templates.
    }

}
