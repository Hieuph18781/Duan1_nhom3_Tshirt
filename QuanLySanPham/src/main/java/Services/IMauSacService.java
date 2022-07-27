/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import DomainModels.MauSac;
import ViewsModels.DanhMucSanPhamModel;
import ViewsModels.MauSacModel;
import ViewsModels.MauSacModel;
import java.util.List;

/**
 *
 * @author hieu
 */
public interface IMauSacService {
    List<MauSacModel> getproduct();
    public String them(MauSacModel danhMucSanPhamModel);
    public String sua(MauSacModel danhMucSanPhamModel);
    public int getmamausac();
    public List<MauSacModel> Timkiem(String ten);
    
}
