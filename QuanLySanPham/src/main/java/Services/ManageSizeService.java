/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DomainModels.Size;
import Repositories.ISizeRepository;
import Repositories.SizeRepository;
import ViewsModels.SizeModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Chung
 */
public class ManageSizeService implements IManageSizeService {

    private final ISizeRepository _iSizeRepostiory;
    private List<SizeModel> _lstSize;

    public ManageSizeService() {
        _iSizeRepostiory = new SizeRepository();
        _lstSize = new ArrayList<>();
    }

    @Override
    public SizeModel createNewSize(SizeModel size) {
        size.getMaSize();
        var x = _iSizeRepostiory.save(new Size(size.getMaSize(), size.getTenSize(), size.getMota()));
        return new SizeModel(x.getMaSize(), x.getTenSize(), x.getMota());

    }

    @Override
    public SizeModel UpdateNewSize(SizeModel size) {
        var x = _iSizeRepostiory.save(new Size(size.getMaSize(), size.getTenSize(), size.getMota()));
        return new SizeModel(x.getMaSize(), x.getTenSize(), x.getMota());
    }

    @Override
    public List<SizeModel> getSize(int position, int pageSize) {
       _lstSize=new ArrayList<>();
       var size= _iSizeRepostiory.finAll(position, pageSize);
        for (Size x : size) {
            _lstSize.add(new SizeModel(x.getMaSize(),x.getTenSize(),x.getMota()));
            
        }
        return _lstSize;
    }
    Size getSizemodel(SizeModel sizemodel){
        Size sizes=new Size();
        sizes.setMaSize(sizemodel.getMaSize());
        sizes.setTenSize(sizemodel.getTenSize());
        sizes.setMota(sizemodel.getMota());
        return sizes;
    }

    @Override
    public String sua(SizeModel size) {
        boolean check=_iSizeRepostiory.update(getSizemodel(size));
        if (check== false) {
            return "sua thanh cong";
            
        }else{
            return "that bai";
        }
    }

    @Override
    public int getMaxIdSize() {
        return _lstSize.size()+1;
    }

    @Override
    public List<SizeModel> TimKiem(String ten) {
        List<SizeModel> sizem= new ArrayList<>();
       
        for (Size x : _iSizeRepostiory.find()) {
            if (x.getTenSize().toLowerCase().contains(ten.toLowerCase())) {
               sizem.add( new SizeModel(x.getMaSize(),x.getTenSize(),x.getMota()));
                System.out.println(sizem +".... ");
            }
        }
        return sizem;
    }
    @Override
    public List<SizeModel> getfullize(){
         _lstSize=new ArrayList<>();
       var size= _iSizeRepostiory.find();
        for (Size x : size) {
            _lstSize.add(new SizeModel(x.getMaSize(),x.getTenSize(),x.getMota()));
            
        }
        return _lstSize;   
    }
    
}
