/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import ViewsModels.HoaDonChiTietModel;
import ViewsModels.HoaDonDoiTraChiTietModel;
import java.util.List;

/**
 *
 * @author Nguyen Van Thuan
 */
public interface IHoaDonDoiTraChiTietService {
    public HoaDonDoiTraChiTietModel them(HoaDonDoiTraChiTietModel HoaDonDoiTraChiTietModel);

    public HoaDonDoiTraChiTietModel sua(HoaDonDoiTraChiTietModel HoaDondcctModel);

    public boolean xoa(HoaDonDoiTraChiTietModel HoaDondcctModel);

    public List<HoaDonDoiTraChiTietModel> getListFromDB(int MaHoaDonDoiTra);
}
