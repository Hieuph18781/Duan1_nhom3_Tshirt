/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DomainModels.NhanVien;
import Repositories.INhanVienRepostiory;
import Repositories.NhanVienRepository;
import ViewsModels.NhanVienModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bùi Công Minh
 */
public class NhanVienService implements INhanVienService{
    INhanVienRepostiory _inhanvientruyvan;
    List<NhanVienModel>  _lstnhanvien;
    
    public NhanVienService(){
        _inhanvientruyvan = new NhanVienRepository();
        _lstnhanvien = new ArrayList<>();
        
    }
       NhanVien getnhanvien (NhanVienModel nhanvienmodel) {
           NhanVien nhanvien=new NhanVien();
           nhanvien.setMaNhanVien(nhanvienmodel.getMaNhanVien());
           nhanvien.setHoTen(nhanvienmodel.getHoTen());
           nhanvien.setNgaySinh(nhanvienmodel.getNgaySinh());
           nhanvien.setGioiTinh(nhanvienmodel.getGioiTinh());
           nhanvien.setSoDienThoai(nhanvienmodel.getSoDienThoai());
           nhanvien.setEmail(nhanvienmodel.getEmail());
           nhanvien.setDiaChi(nhanvienmodel.getDiaChi());
           nhanvien.setCCCD(nhanvienmodel.getCCCD());
           nhanvien.setChucVu(nhanvienmodel.getChucVu());
           nhanvien.setTrangThai(nhanvienmodel.isTrangThai());
           nhanvien.setMatKhau(nhanvienmodel.getMatKhau());
           return nhanvien;
           
       }

    @Override
    public List<NhanVienModel> getproduct() {
        _lstnhanvien = new ArrayList<>();
        var nhanvien = _inhanvientruyvan.findAll();
        for (NhanVien x : nhanvien) {
            _lstnhanvien.add(new NhanVienModel(x.getMaNhanVien(), x.getHoTen(), x.getNgaySinh(), x.getGioiTinh(), x.getSoDienThoai(), x.getEmail(), x.getDiaChi(), x.getCCCD(), x.getChucVu(), x.getTrangThai(), x.getMatKhau()));
        }
        return _lstnhanvien;
    } //To change body of generated methods, choose Tools | Templates.
    

    @Override
    public NhanVienModel createNewProduct(NhanVienModel nhanvienmodel) {
        //nhanvienmodel.setMaNhanVien();
        var x = _inhanvientruyvan.Save(new NhanVien(nhanvienmodel.getMaNhanVien(), nhanvienmodel.getHoTen(), nhanvienmodel.getNgaySinh(), nhanvienmodel.getGioiTinh() , nhanvienmodel.getSoDienThoai(), nhanvienmodel.getEmail(), nhanvienmodel.getEmail(), nhanvienmodel.getDiaChi(), nhanvienmodel.getChucVu(), nhanvienmodel.isTrangThai(), nhanvienmodel.getMatKhau()));
        return new NhanVienModel(x.getMaNhanVien(), x.getHoTen(), x.getNgaySinh(), x.getGioiTinh(), x.getSoDienThoai(), x.getEmail(), x.getDiaChi(), x.getCCCD(), x.getChucVu(), x.getTrangThai(), x.getMatKhau()); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String sua(NhanVienModel nhanvienmodel) {
        boolean checkdmsp = _inhanvientruyvan.update(getnhanvien(nhanvienmodel));
        if (checkdmsp == false) {
            return "Sửa Không thành công";
        }
        return "Sửa thành công"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getMaxIdNhanVien() {
        return _lstnhanvien.size()+1; //To change body of generated methods, choose Tools | Templates.
    }
    
}
