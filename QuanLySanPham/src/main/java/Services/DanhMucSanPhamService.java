/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DomainModels.DanhMucSanPham;
import Repositories.DanhMucSanPhamRepositories;
import Repositories.IDanhMucSanPhamRepositories;
import ViewsModels.DanhMucSanPhamModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nguyen Van Thuan
 */
public class DanhMucSanPhamService implements IDanhMucSanPhamService {

    List<DanhMucSanPhamModel> _lstdanhMucSpModels;
    IDanhMucSanPhamRepositories _IDanhMucSanPhamRepositories;

    public DanhMucSanPhamService() {
        _IDanhMucSanPhamRepositories = new DanhMucSanPhamRepositories();
    }

    DanhMucSanPham getDanhMucRpst(DanhMucSanPhamModel danhMucSanPhamModel) {
        DanhMucSanPham danhmucSP = new DanhMucSanPham();
        danhmucSP.setMaDanhMuc(danhMucSanPhamModel.getMaDanhMuc());
        danhmucSP.setTenDanhMuc(danhMucSanPhamModel.getTenDanhMuc());
        danhmucSP.setMota(danhMucSanPhamModel.getMota());
        return danhmucSP;
    }

    @Override
    public String them(DanhMucSanPhamModel danhMucSanPhamModel) {
        DanhMucSanPham dmsp = _IDanhMucSanPhamRepositories.insert(getDanhMucRpst(danhMucSanPhamModel));
        if (dmsp == null) {
            return "Thêm Không thành công";
        }
        return "Thêm thành công";
    }

    @Override
    public String sua(DanhMucSanPhamModel danhMucSanPhamModel) {
        boolean checkdmsp = _IDanhMucSanPhamRepositories.update(getDanhMucRpst(danhMucSanPhamModel));
        if (checkdmsp == false) {
            return "Sửa Không thành công";
        }
        return "Sửa thành công";
    }

    @Override
    public List<DanhMucSanPhamModel> getListFromDB() {
        _lstdanhMucSpModels = new ArrayList<>();
        List<DanhMucSanPham> lstdanhMucSp = new ArrayList<>();
        lstdanhMucSp = _IDanhMucSanPhamRepositories.selectAll();
        for (DanhMucSanPham x : lstdanhMucSp) {
            _lstdanhMucSpModels.add(new DanhMucSanPhamModel(x.getMaDanhMuc(), x.getTenDanhMuc(), x.getMota()));
        }
        return _lstdanhMucSpModels;
    }

    @Override
    public int getMaDanhMuc() {
        return _lstdanhMucSpModels.size() + 1;
    }

    @Override
    public List<DanhMucSanPhamModel> findDanhMucSp(String tenDmSp) {
        List<DanhMucSanPhamModel> lstFind = new ArrayList<>();
        String pattern = ".*"+Utils.CheckData.unAccent(tenDmSp.toLowerCase())+".*";
        if (tenDmSp.isBlank()) {
            return _lstdanhMucSpModels;
        }
        for (DanhMucSanPhamModel x : _lstdanhMucSpModels) {
            if (Utils.CheckData.unAccent(x.getTenDanhMuc()).toLowerCase().matches(pattern)) {
                lstFind.add(x);
            }
        }
        return lstFind;
    }

}
