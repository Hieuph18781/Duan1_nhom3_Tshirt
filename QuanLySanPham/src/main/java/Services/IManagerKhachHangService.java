/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import ViewsModels.KhachHangModel;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface IManagerKhachHangService {

    List<KhachHangModel> getKhachHang(int position, int pageSize);

    KhachHangModel getKhachhangById(int MaKhachHang);

    String createKhachHang(KhachHangModel khachhangmodel);

    KhachHangModel createNewKhachHang(KhachHangModel khachhangmodel);

    KhachHangModel update(KhachHangModel khachhangmodel);

    long countAllKh();

    public int getmaKH();

    public List<KhachHangModel> TimKiem(String ten);

    public boolean timKiem2(String chuoi1, String chuoi2);

    List<KhachHangModel> getAllKhachHang();

}
