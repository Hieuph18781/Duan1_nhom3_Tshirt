/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repositories;

import DomainModels.HoaDon;
import DomainModels.HoaDonDoiTra;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Nguyen Van Thuan
 */
public interface IHoaDonTraRepositories {

    public HoaDonDoiTra insert(HoaDonDoiTra HoaDon1);

    public HoaDonDoiTra getHoadontraBymahoadon(int mahoadon);

    public boolean update(HoaDonDoiTra HoaDon);
    
    public boolean delete(int mahoadontra);

    public List<HoaDonDoiTra> selectAll();

    public List<HoaDon> selectHoaDonToDate(Date enity);
}
