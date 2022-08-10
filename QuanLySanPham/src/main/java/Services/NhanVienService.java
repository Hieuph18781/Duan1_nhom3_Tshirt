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
import javax.swing.JOptionPane;

/**
 *
 * @author Bùi Công Minh
 */
public class NhanVienService implements INhanVienService {

    INhanVienRepostiory _inhanvientruyvan;
    List<NhanVienModel> _lstnhanvien;

    public NhanVienService() {
        _inhanvientruyvan = new NhanVienRepository();
        _lstnhanvien = new ArrayList<>();
    }

    NhanVien getnhanvien(NhanVienModel nhanvienmodel) {
        NhanVien nhanvien = new NhanVien();
        nhanvien.setMaNhanVien(nhanvienmodel.getMaNhanVien());
        nhanvien.setHoTen(nhanvienmodel.getHoTen());
        nhanvien.setNgaySinh(nhanvienmodel.getNgaySinh());
        nhanvien.setGioiTinh(nhanvienmodel.isGioiTinh());
        nhanvien.setSoDienThoai(nhanvienmodel.getSoDienThoai());
        nhanvien.setEmail(nhanvienmodel.getEmail());
        nhanvien.setDiaChi(nhanvienmodel.getDiaChi());
        nhanvien.setCCCD(nhanvienmodel.getCCCD());
        nhanvien.setChucVu(nhanvienmodel.getChucVu());
        nhanvien.setTrangThai(nhanvienmodel.getTrangThai());
        nhanvien.setMatKhau(nhanvienmodel.getMatKhau());
        return nhanvien;

    }

    @Override
    public List<NhanVienModel> getproduct() {
        _lstnhanvien = new ArrayList<>();
        var nhanvien = _inhanvientruyvan.findAll();
        for (NhanVien x : nhanvien) {
            System.out.println(x.getHoTen());
            _lstnhanvien.add(new NhanVienModel(x.getMaNhanVien(), x.getHoTen(), x.getNgaySinh(), x.isGioiTinh(), x.getSoDienThoai(), x.getEmail(), x.getDiaChi(), x.getCCCD(), x.getChucVu(), x.getTrangThai(), x.getMatKhau()));
        }
        return _lstnhanvien;
    } //To change body of generated methods, choose Tools | Templates.

    @Override
    public NhanVienModel createNewProduct(NhanVienModel nhanvienmodel) {
        //nhanvienmodel.setMaNhanVien();
        System.out.println("2");
        var x = _inhanvientruyvan.Save(new NhanVien(nhanvienmodel.getMaNhanVien(), nhanvienmodel.getHoTen(), nhanvienmodel.getNgaySinh(), nhanvienmodel.isGioiTinh(), nhanvienmodel.getSoDienThoai(), nhanvienmodel.getEmail(), nhanvienmodel.getDiaChi(), nhanvienmodel.getCCCD(), nhanvienmodel.getChucVu(), nhanvienmodel.getTrangThai(), nhanvienmodel.getMatKhau()));
        System.out.println("1");
        return new NhanVienModel(x.getMaNhanVien(), x.getHoTen(), x.getNgaySinh(), x.isGioiTinh(), x.getSoDienThoai(), x.getEmail(), x.getDiaChi(), x.getCCCD(), x.getChucVu(), x.getTrangThai(), x.getMatKhau()); //To change body of generated methods, choose Tools | Templates.

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
        return _lstnhanvien.size() + 1; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public NhanVienModel findNhanVien(String MaNhanVien) {
        var x = _inhanvientruyvan.findById(MaNhanVien);
        if (MaNhanVien == null) {
            return new NhanVienModel();
        }
        return new NhanVienModel(x.getMaNhanVien(), x.getHoTen(),x.getEmail(), x.getChucVu(), x.getTrangThai(), x.getMatKhau());
    }

    @Override
    public void updatemk(String MaNhanVien, String matkhau) {
        _inhanvientruyvan.updatemk(MaNhanVien, matkhau);
    }

   
    @Override
    public boolean Timkiem(String chuoi1, String chuoi2) {
       String pattern = ".*" + Utils.CheckData.unAccent(chuoi2.toLowerCase()) + ".*";
        if (Utils.CheckData.unAccent(chuoi1).toLowerCase().matches(pattern)) {
            return true;
        }
        return false; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public NhanVienModel findchucvu(String ChucVu) {
         //To change body of generated methods, choose Tools | Templates.
        return null;
         //To change body of generated methods, choose Tools | Templates.
    }
    }

