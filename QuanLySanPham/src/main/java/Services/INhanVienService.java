/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import ViewsModels.NhanVienModel;
import java.util.List;

/**
 *
 * @author Bùi Công Minh
 */
public interface INhanVienService {

    List<NhanVienModel> getproduct();

    NhanVienModel createNewProduct(NhanVienModel nhanvienmodel);

    public String sua(NhanVienModel nhanvienmodel);

    public int getMaxIdNhanVien();

    NhanVienModel findNhanVien(String MaNhanVien);

    public void updatemk(String MaNhanVien, String matkhau);
    public boolean Timkiem(String chuoi1, String chuoi2);
    public NhanVienModel findchucvu(String ChucVu);
}
