/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repositories;

import DomainModels.HoaDonChiTiet;
import DomainModels.HoaDonTraChiTiet;
import java.util.List;

/**
 *
 * @author Nguyen Van Thuan
 */
public interface IHoaDonDoiTraChiTietRepositories {
    public HoaDonTraChiTiet insert(HoaDonTraChiTiet HoaDon1);

    public boolean update(HoaDonTraChiTiet HoaDonDoiTraChiTiet);

    public boolean delete(HoaDonTraChiTiet HoaDonDoiTraChiTiet);

    public List<HoaDonTraChiTiet> selectAll(int MaHoaDonDoiTra);
}
