/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import ViewsModels.DanhMucSanPhamModel;
import ViewsModels.MauSacModel;
import ViewsModels.SanPhamModel;
import java.util.List;

/**
 *
 * @author hieu
 */
public interface ISanPhamService {
     public String Ins(SanPhamModel SanPhamModel);
    public String Up(SanPhamModel SanPhamModel);
//    public List<SanPhamModel> getList();
//    public List<MauSacModel> getList1();
    public List<DanhMucSanPhamModel> getList2();
    
    public int getMaSanPham();
}
