/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import ViewsModels.SanPhamModel;
import java.util.List;

/**
 *
 * @author hieu
 */
public interface ISanPhamService {
    List<SanPhamModel> getlistsanpham();
    public String them(SanPhamModel danhMucSanPhamModel);
    public String sua(SanPhamModel danhMucSanPhamModel);
    public int getmamausac();
    public List<SanPhamModel> Timkiem(String ten);
}
