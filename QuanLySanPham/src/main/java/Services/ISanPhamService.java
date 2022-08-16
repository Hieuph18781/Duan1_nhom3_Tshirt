/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import DomainModels.SanPham;
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
    public boolean suaSoLuongSP(String MaSp, int soLuong);
    public String getMaSanPham();
    public boolean Timkiem(String chuoi1, String chuoi2);
    public List<SanPhamModel> getlstGiaAndMaSp(int gia, String maSanPham);
}
