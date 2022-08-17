/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repositories;

import DomainModels.HoaDon;
import DomainModels.HoaDonChiTiet;
import DomainModels.HoaDonDoiTra;
import java.util.Date;
import java.util.List;

/**
 *
 * @author dytc0
 */
public interface IThongKeRepository {

    public List<Object[]> thongke1();

    public List<Object[]> thongke2(String a);

    public List<Object[]> thongke3(int a, int b);

    public List<Object[]> thongke4(int a);

    public long TongTien1();

    public long TongTien2();

    public long TongTien3();

    public long TongTien4(int a);

    public long TongTien5(int a);

    public List<HoaDon> thongke5();

    public List<HoaDon> thongke6();

    public List<HoaDon> thongke7(Date a, Date b);

    public List<HoaDon> thongke8(Date a, Date b);

    public List<Object[]> thongke9(int a);

    public List<HoaDonDoiTra> thongke10();

    public List<HoaDonDoiTra> thongke11(Date a, Date b);

    public List<Object[]> thongke12(int a);

    public List<HoaDon> thongke13();

    public List<HoaDon> thongke14(Date a, Date b);
    
    public List<HoaDon> thongke15();

}
