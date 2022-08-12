/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repositories;

import DomainModels.HoaDon;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Nguyen Van Thuan
 */
public interface IHoaDonRepository {

    public HoaDon insert(HoaDon HoaDon1);

    public boolean update(HoaDon HoaDon);

    public List<HoaDon> selectAll();

    public List<HoaDon> selectHoaDonToDate(Date enity);

    public HoaDon getHoadonById(int mahoadon);
}
