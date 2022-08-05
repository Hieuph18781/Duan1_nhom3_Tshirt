/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import ViewsModels.HoaDonModel;
import ViewsModels.HoaDonChiTietModel;
import java.util.List;

/**
 *
 * @author Nguyen Van Thuan
 */
public interface IHoaDonChiTietService {

    public HoaDonChiTietModel them(HoaDonChiTietModel HoaDonModel);

    public HoaDonChiTietModel sua(HoaDonChiTietModel HoaDonModel);

    public boolean xoa(HoaDonChiTietModel HoaDonModel);

    public List<HoaDonChiTietModel> getListFromDB(int MaHoaDon);
}
