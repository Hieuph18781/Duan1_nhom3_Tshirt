/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import ViewsModels.HoaDonDoiTraMoDel;
import ViewsModels.HoaDonModel;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Nguyen Van Thuan
 */
public interface IHoaDonDoiTraService {

    public HoaDonDoiTraMoDel them(HoaDonDoiTraMoDel HoaDonDoiTraMoDel);

    public HoaDonDoiTraMoDel sua(HoaDonDoiTraMoDel HoaDonDoiTraMoDel);

    public boolean xoa(int mahoadontra);

    public List<HoaDonDoiTraMoDel> getListFromDB();

//    public int getMaxIdHoaDon();
    public List<HoaDonDoiTraMoDel> getLstToDay(Date ngay);
}
