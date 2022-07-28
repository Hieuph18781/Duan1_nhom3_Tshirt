/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repositories;

import DomainModels.KhachHang;
import ViewsModels.KhachHangModel;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface IKhachHangRepository {

    List<KhachHang> fillAll(int position, int pageSize);

    KhachHang findById(int MaKhachHang);
    List<KhachHang> find();

   public KhachHang save(KhachHang khachhang);
     public boolean  update (KhachHang khachhang);

    long totalCount();

}
