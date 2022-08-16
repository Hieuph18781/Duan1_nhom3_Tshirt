/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import ViewsModels.HoaDonChiTietModel;
import ViewsModels.HoaDonDoiTraMoDel;
import ViewsModels.HoaDonModel;
import java.util.Date;
import java.util.List;

/**
 *
 * @author dytc0
 */
public interface IThongKeService {

    public List<Object[]> thongke1();

    public List<Object[]> thongke2(String a);

    public List<Object[]> thongke3(int a, int b);

    public List<Object[]> thongke4(int a);

    public long TongTien1();

    public long TongTien2();

    public long TongTien3();

    public long TongTien4(int a);

    public long TongTien5(int a);
    
    public List<HoaDonModel> thongke5();

    public List<HoaDonModel> thongke6();

    public List<HoaDonModel> thongke7(Date a, Date b);

    public List<HoaDonModel> thongke8(Date a, Date b);

    public boolean Timkiem(String chuoi1, String chuoi2);

    public boolean Timkiem2(String chuoi1, String chuoi2);

    public List<Object[]> thongke9(int a);
    
    public List<HoaDonDoiTraMoDel> thongke10();
    
    public List<HoaDonDoiTraMoDel> thongke11(Date a, Date b);
    
    public List<Object[]> thongke12(int a);
    
    public List<HoaDonModel> thongke13();

    public List<HoaDonModel> thongke14(Date a, Date b);
    
    public List<HoaDonModel> thongke15();

}
