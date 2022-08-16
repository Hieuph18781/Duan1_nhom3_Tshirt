/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repositories;

import DomainModels.SanPham;
import java.util.List;

/**
 *
 * @author hieu
 */
public interface ISanPhamRepository {

    List<SanPham> findAll();

    public SanPham insert(SanPham danhMucSp);

    public boolean update(SanPham danhMucSp);

    public boolean updateSoLuongSP(String MaSp, int soLuong);

    SanPham findById(String ma);

    public List<SanPham> findGiaAndMaSp(int gia, String maSanPham);
}
