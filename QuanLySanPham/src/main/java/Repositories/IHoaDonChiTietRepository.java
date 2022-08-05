/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repositories;

import DomainModels.HoaDon;
import DomainModels.HoaDonChiTiet;
import java.util.List;

/**
 *
 * @author Nguyen Van Thuan
 */
public interface IHoaDonChiTietRepository {

    public HoaDonChiTiet insert(HoaDonChiTiet HoaDon1);

    public boolean update(HoaDonChiTiet HoaDon);

    public boolean delete(HoaDonChiTiet HoaDon);

    public List<HoaDonChiTiet> selectAll(int MaHoaDon);
}
