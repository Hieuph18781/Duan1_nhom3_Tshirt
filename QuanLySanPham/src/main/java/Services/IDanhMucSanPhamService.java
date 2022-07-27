/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import ViewsModels.DanhMucSanPhamModel;
import java.util.List;

/**
 *
 * @author Nguyen Van Thuan
 */
public interface IDanhMucSanPhamService {
    public String them(DanhMucSanPhamModel danhMucSanPhamModel);
    public String sua(DanhMucSanPhamModel danhMucSanPhamModel);
    public List<DanhMucSanPhamModel> getListFromDB();
    public int getMaDanhMuc();
    public List<DanhMucSanPhamModel> findDanhMucSp(String tenDmSp);
}
