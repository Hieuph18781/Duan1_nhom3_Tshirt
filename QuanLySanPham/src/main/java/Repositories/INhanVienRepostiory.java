/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repositories;

import DomainModels.NhanVien;
import java.util.List;

/**
 *
 * @author Bùi Công Minh
 */
public interface INhanVienRepostiory {

    List<NhanVien> findAll();

    public NhanVien Save(NhanVien nhanvien);

    public boolean update(NhanVien nhanvien);

    public NhanVien findById(String MaNhanVien);

    public void updatemk(String MaNhanVien, String matkhau);
    
    public NhanVien findByChucVu(String ChucVu);
}
