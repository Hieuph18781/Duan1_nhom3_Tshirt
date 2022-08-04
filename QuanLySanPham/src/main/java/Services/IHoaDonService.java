/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import ViewsModels.HoaDonModel;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Nguyen Van Thuan
 */
public interface IHoaDonService {

    public HoaDonModel them(HoaDonModel HoaDonModel);

    public HoaDonModel sua(HoaDonModel HoaDonModel);

    public List<HoaDonModel> getListFromDB();

//    public int getMaxIdHoaDon();

    public List<HoaDonModel> getLstToDay(Date ngay);
}
