/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DomainModels.Size;
import Repositories.ISizeRepository;
import Repositories.SizeRepository;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class ManageSizeServixe implements IManageSizeService {

    private final ISizeRepository _iSizeRepostiory;
    private List<Size> _lstSize;

    public ManageSizeServixe() {
        _iSizeRepostiory = new SizeRepository();
        _lstSize = new ArrayList<>();
    }

    @Override
    public Size createNewSize(Size size) {
        size.getMaSize();
        var x = _iSizeRepostiory.save(new Size(size.getMaSize(), size.getTenSize(), size.getMota()));
        return new Size(x.getMaSize(), x.getTenSize(), x.getMota());

    }

    @Override
    public Size UpdateNewSize(Size size) {
        var x = _iSizeRepostiory.save(new Size(size.getMaSize(), size.getTenSize(), size.getMota()));
        return new Size(x.getMaSize(), x.getTenSize(), x.getMota());
    }

    @Override
    public List<Size> getSize(int position, int pageSize) {
       _lstSize=new ArrayList<>();
       var size= _iSizeRepostiory.finAll(position, pageSize);
        for (Size x : size) {
            _lstSize.add(new Size(x.getMaSize(),x.getTenSize(),x.getMota()));
            
        }
        return _lstSize;
    }
}
