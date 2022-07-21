/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DomainModels.MauSac;
import Repositories.MauSacRepository;
import ViewsModel.MauSacModel;
import java.util.ArrayList;
import java.util.List;
import Repositories.IMauSacRepository;

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
    public MauSacModel createNewProduct(MauSacModel color) {
         var x = _iTruyvanmausac.Save(new MauSac(color.getMaMauSac(), color.getTenMauSac(), color.getMota()));
         return new MauSacModel(x.getMaMauSac(), x.getTenMauSac(), x.getMota());
    }

    @Override
    public MauSacModel updateProductById(MauSacModel colors) {
       var x = _iTruyvanmausac.Save(new MauSac(colors.getMaMauSac(), colors.getTenMauSac(), colors.getMota()));
         return new MauSacModel(x.getMaMauSac(), x.getTenMauSac(), x.getMota());
    }

    
      
}
