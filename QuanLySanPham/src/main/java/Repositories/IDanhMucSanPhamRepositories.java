/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repositories;

import DomainModels.DanhMucSanPham;
import java.util.List;

/**
 *
 * @author Nguyen Van Thuan
 */
public interface IDanhMucSanPhamRepositories {

    public DanhMucSanPham insert(DanhMucSanPham danhMucSp);

    public boolean update(DanhMucSanPham danhMucSp);

    public List<DanhMucSanPham> selectAll();

    public DanhMucSanPham selectById(DanhMucSanPham enity);
}
