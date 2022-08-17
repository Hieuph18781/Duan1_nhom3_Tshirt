/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DomainModels.KhachHang;
import Repositories.IKhachHangRepository;
import Repositories.KhachHangRepostiry;
import ViewsModels.KhachHangModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class ManagerKhachHangServicr implements IManagerKhachHangService {

    private IKhachHangRepository _iKhachHang;
    private List<KhachHangModel> _lstKH;

    public ManagerKhachHangServicr() {
        _iKhachHang = new KhachHangRepostiry();
        _lstKH = new ArrayList<>();
    }

    KhachHang getDanhMucKH(KhachHangModel DanhMucKHModel) {
        KhachHang Kh = new KhachHang();
        Kh.setMaKhachHang(DanhMucKHModel.getMaKhachHang());
        Kh.setHoTen(DanhMucKHModel.getHoTen());
        Kh.setSoDienThoai(DanhMucKHModel.getSoDienThoai());
        Kh.setDiaChi(DanhMucKHModel.getDiaChi());

        Kh.setEmail(DanhMucKHModel.getEmail());

        return Kh;
    }

    @Override
    public List<KhachHangModel> getKhachHang(int position, int pageSize) {
        _lstKH = new ArrayList<>();
        var khachhang = _iKhachHang.fillAll(position, pageSize);
        for (KhachHang x : khachhang) {
            System.out.println(x.getSoDienThoai());
            _lstKH.add(new KhachHangModel(x.getMaKhachHang(), x.getHoTen(), x.getSoDienThoai(), x.getDiaChi(), x.getEmail(), x.getDiem()));
        }
        return _lstKH;
    }

    @Override
    public KhachHangModel getKhachhangById(int MaKhachHang) {
        var x = _iKhachHang.findById(MaKhachHang);
        return new KhachHangModel(x.getMaKhachHang(), x.getHoTen(),x.getSoDienThoai(), x.getDiaChi(),  x.getEmail(), x.getDiem());

    }

    @Override
    public String createKhachHang(KhachHangModel khachhangmodel) {
//        khachhangmodel.getMaKhachHang();
//        var x = _iKhachHang.save(new KhachHang(khachhangmodel.getMaKhachHang(), khachhangmodel.getHoTen(), khachhangmodel.getEmail(), khachhangmodel.getSoDienThoai(), khachhangmodel.getDiaChi()));
//        return new KhachHangModel(x.getMaKhachHang(), x.getHoTen(), x.getEmail(), x.getSoDienThoai(), x.getDiaChi());
        KhachHang KH = _iKhachHang.save(getDanhMucKH(khachhangmodel));
        if (KH == null) {
            return "ko thanh công";

        }
        return "thanh công";

    }

    @Override
    public KhachHangModel update(KhachHangModel khachhangmodel) {
        var x = _iKhachHang.save(new KhachHang(khachhangmodel.getMaKhachHang(), khachhangmodel.getHoTen(), khachhangmodel.getSoDienThoai(), khachhangmodel.getDiaChi(), khachhangmodel.getEmail(), khachhangmodel.getDiem()));
        return new KhachHangModel(x.getMaKhachHang(), x.getHoTen(), x.getSoDienThoai(), x.getDiaChi(), x.getEmail(), x.getDiem());
    }

    @Override
    public long countAllKh() {
        return _iKhachHang.totalCount();
    }

    @Override
    public int getmaKH() {
        return _lstKH.size() + 2;
    }

    @Override
    public KhachHangModel createNewKhachHang(KhachHangModel khachhangmodel) {
        khachhangmodel.getMaKhachHang();
        var x = _iKhachHang.save(new KhachHang(khachhangmodel.getMaKhachHang(), khachhangmodel.getHoTen(), khachhangmodel.getSoDienThoai(), khachhangmodel.getDiaChi(), khachhangmodel.getEmail(), khachhangmodel.getDiem()));
        return new KhachHangModel(x.getMaKhachHang(), x.getHoTen(), x.getSoDienThoai(), x.getDiaChi(), x.getEmail(), x.getDiem());
    }

    @Override
    public List<KhachHangModel> TimKiem(String ten) {
        List<KhachHangModel> KHmodel = new ArrayList<>();
        for (KhachHang x : _iKhachHang.find()) {
            if (x.getHoTen().toLowerCase().contains(ten.toLowerCase())) {
                KHmodel.add(new KhachHangModel(x.getMaKhachHang(), x.getHoTen(), x.getSoDienThoai(), x.getDiaChi(), x.getEmail(), x.getDiem()));

            } else if (x.getEmail().toLowerCase().contains(ten.toLowerCase())) {
                KHmodel.add(new KhachHangModel(x.getMaKhachHang(), x.getHoTen(), x.getSoDienThoai(), x.getDiaChi(), x.getEmail(), x.getDiem()));
            } else if (x.getSoDienThoai().toLowerCase().contains(ten.toLowerCase())) {
                KHmodel.add(new KhachHangModel(x.getMaKhachHang(), x.getHoTen(), x.getSoDienThoai(), x.getDiaChi(), x.getEmail(), x.getDiem()));

            }

        }
        return KHmodel;

    }

    @Override
    public boolean timKiem2(String chuoi1, String chuoi2) {
        String pattern = ".*" + Utils.CheckData.unAccent(chuoi2.toLowerCase()) + ".*";
        if (Utils.CheckData.unAccent(chuoi1).toLowerCase().matches(pattern)) {
            return true;
        }
        return false;
    }

    @Override
    public List<KhachHangModel> getAllKhachHang() {
        List<KhachHangModel> lstKH = new ArrayList<>();
        var khachhang = _iKhachHang.find();
        for (KhachHang x : khachhang) {
            _lstKH.add(new KhachHangModel(x.getMaKhachHang(), x.getHoTen(), x.getSoDienThoai(), x.getDiaChi(), x.getEmail(), x.getDiem()));
        }
        return _lstKH;
    }
}
