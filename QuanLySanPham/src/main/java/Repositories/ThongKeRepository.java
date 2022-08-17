/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import DomainModels.HoaDon;
import DomainModels.HoaDonChiTiet;
import DomainModels.HoaDonDoiTra;
import Utils.HibernateUtil;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.hibernate.SessionFactory;

/**
 *
 * @author dytc0
 */
public class ThongKeRepository implements IThongKeRepository {

    @Override
    public List<Object[]> thongke1() {
        List<Object[]> list = new ArrayList<>();
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "SELECT S.MaSanPham,S.TenSanPham,SUM(H.SoLuong),SUM(S.gia*H.SoLuong)\n"
                    + "From SanPham S\n"
                    + "Inner join HoaDonChiTiet H on S.MaSanPham = H.sanpham\n"
                    + "Inner join HoaDon HD on H.hoadon = HD.MaHoaDon\n"
                    + "where DAY(HD.ThoiGianTao) = DAY(GETDATE()) and HD.TrangThai = 2 or HD.TrangThai = 3"
                    + "group by S.MaSanPham,S.TenSanPham\n"
                    + "order by SUM(S.gia*H.SoLuong) desc ";
            Query<?> query = session.createQuery(hql);
            session.beginTransaction();
            session.getTransaction().commit();

            list = (List<Object[]>) query.getResultList();
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
        return list;

    }

    @Override
    public List<Object[]> thongke2(String a) {
        List<Object[]> list = new ArrayList<>();
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "SELECT S.MaSanPham,S.TenSanPham,SUM(H.SoLuong),SUM(S.gia*H.SoLuong)\n"
                    + "From SanPham S\n"
                    + "Inner join HoaDonChiTiet H on S.MaSanPham = H.sanpham\n"
                    + "Inner join HoaDon HD on H.hoadon = HD.MaHoaDon\n"
                    + "where CONVERT(date,HD.ThoiGianTao) = :ThoiGianTao and HD.TrangThai = 2 or HD.TrangThai = 3"
                    + "group by S.MaSanPham,S.TenSanPham\n"
                    + "order by SUM(S.gia*H.SoLuong) desc ";

            Query<?> query = session.createQuery(hql);
            query.setParameter("ThoiGianTao", a);
            System.out.println(hql);
            session.beginTransaction();
            session.getTransaction().commit();

            list = (List<Object[]>) query.getResultList();
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public List<Object[]> thongke3(int a, int b) {
        List<Object[]> list = new ArrayList<>();
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "SELECT S.MaSanPham,S.TenSanPham,SUM(H.SoLuong),SUM(S.gia*H.SoLuong)\n"
                    + "From SanPham S\n"
                    + "Inner join HoaDonChiTiet H on S.MaSanPham = H.sanpham\n"
                    + "Inner join HoaDon HD on H.hoadon = HD.MaHoaDon\n"
                    + "where MONTH(HD.ThoiGianTao) = :ThoiGianTao and YEAR(HD.ThoiGianTao) = :ThoiGianTao2 and HD.TrangThai = 2 or HD.TrangThai = 3"
                    + "group by S.MaSanPham,S.TenSanPham\n"
                    + "order by SUM(S.gia*H.SoLuong) desc ";
            Query<?> query = session.createQuery(hql);
            query.setParameter("ThoiGianTao", a);
            query.setParameter("ThoiGianTao2", b);
            session.beginTransaction();
            session.getTransaction().commit();

            list = (List<Object[]>) query.getResultList();
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public long TongTien1() {
        long a = 0;
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "SELECT SUM(S.gia*H.SoLuong)\n"
                    + "From SanPham S\n"
                    + "Inner join HoaDonChiTiet H on S.MaSanPham = H.sanpham\n"
                    + "Inner join HoaDon HD on H.hoadon = HD.MaHoaDon\n"
                    + "where DAY(HD.ThoiGianTao) = DAY(GETDATE()) AND HD.TrangThai = 2 OR HD.TrangThai = 3";
            System.out.println(hql);
            try {
                Query<?> query = session.createQuery(hql);
                session.beginTransaction();
                session.getTransaction().commit();
                a = (long) query.uniqueResult();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Không có dữ liệu thống kê trong ngày");
            }
        } catch (HibernateException e) {
            JOptionPane.showMessageDialog(null, "Không có dữ liệu thống kê trong ngày");
        }
        return a;

    }

    @Override
    public long TongTien2() {
        long a = 0;
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "SELECT SUM(S.gia*H.SoLuong)\n"
                    + "From SanPham S\n"
                    + "Inner join HoaDonChiTiet H on S.MaSanPham = H.sanpham\n"
                    + "Inner join HoaDon HD on H.hoadon = HD.MaHoaDon\n"
                    + "where MONTH(HD.ThoiGianTao) = MONTH(GETDATE()) AND HD.TrangThai = 2 OR HD.TrangThai = 3";
            try {
                Query<?> query = session.createQuery(hql);
                session.beginTransaction();
                session.getTransaction().commit();
                a = (long) query.uniqueResult();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Không có dữ liệu thống kê trong tháng");
            }
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
        return a;
    }

    @Override
    public long TongTien3() {
        long a = 0;

        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "SELECT SUM(S.gia*H.SoLuong)\n"
                    + "From SanPham S\n"
                    + "Inner join HoaDonChiTiet H on S.MaSanPham = H.sanpham\n"
                    + "Inner join HoaDon HD on H.hoadon = HD.MaHoaDon\n"
                    + "where YEAR(HD.ThoiGianTao) = YEAR(GETDATE()) AND HD.TrangThai = 2 OR HD.TrangThai = 3";
            try {
                Query<?> query = session.createQuery(hql);
                session.beginTransaction();
                session.getTransaction().commit();
                a = (long) query.uniqueResult();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Khong co du lieu thống kê trong năm");
            }

        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
        return a;
    }

    @Override
    public List<Object[]> thongke4(int a) {
        List<Object[]> list = new ArrayList<>();
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "SELECT S.MaSanPham,S.TenSanPham,SUM(H.SoLuong),SUM(S.gia*H.SoLuong)\n"
                    + "From SanPham S\n"
                    + "Inner join HoaDonChiTiet H on S.MaSanPham = H.sanpham\n"
                    + "Inner join HoaDon HD on H.hoadon = HD.MaHoaDon\n"
                    + "where YEAR(HD.ThoiGianTao) = :ThoiGianTao and HD.TrangThai = 2 or HD.TrangThai = 3"
                    + "group by S.MaSanPham,S.TenSanPham\n"
                    + "order by SUM(S.gia*H.SoLuong) desc ";
            Query<?> query = session.createQuery(hql);
            query.setParameter("ThoiGianTao", a);
            session.beginTransaction();
            session.getTransaction().commit();

            list = (List<Object[]>) query.getResultList();
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public List<HoaDon> thongke5() {
        List<HoaDon> nhanvien;
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "SELECT H FROM HoaDon H where H.TrangThai = 2 or H.TrangThai = 3"
                    + "order by H.ThoiGianTao desc";
            TypedQuery<HoaDon> query = session.createQuery(hql, HoaDon.class);

            nhanvien = query.getResultList();
        }
        return nhanvien;
    }

    @Override
    public List<HoaDon> thongke6() {
        List<HoaDon> nhanvien;
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "SELECT H FROM HoaDon H where H.TrangThai = 1"
                    + "order by H.ThoiGianTao desc";
            TypedQuery<HoaDon> query = session.createQuery(hql, HoaDon.class);

            nhanvien = query.getResultList();
        }
        return nhanvien;
    }

    @Override
    public List<HoaDon> thongke7(Date a, Date b) {
        List<HoaDon> nhanvien;
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "SELECT H FROM HoaDon H where CONVERT(date,H.ThoiGianTao) >= :ThoiGianTao and CONVERT (date,H.ThoiGianTao) <= :ThoiGianTao2 And H.TrangThai = 2 or H.TrangThai = 3 " ;
            TypedQuery<HoaDon> query = session.createQuery(hql, HoaDon.class);
            query.setParameter("ThoiGianTao", a);
            query.setParameter("ThoiGianTao2", b);
            nhanvien = query.getResultList();
        }
        return nhanvien;
    }

    @Override
    public List<HoaDon> thongke8(Date a, Date b) {
        List<HoaDon> nhanvien;
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "SELECT H FROM HoaDon H where CONVERT(date,H.ThoiGianTao) >= :ThoiGianTao and CONVERT (date,H.ThoiGianTao) <= :ThoiGianTao2 and H.TrangThai = 1";
            TypedQuery<HoaDon> query = session.createQuery(hql, HoaDon.class);
            query.setParameter("ThoiGianTao", a);
            query.setParameter("ThoiGianTao2", b);
            nhanvien = query.getResultList();
        }
        return nhanvien;
    }

    @Override
    public List<Object[]> thongke9(int a) {
//        List<HoaDonChiTiet> nhanvien;
//        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
//            String hql = "SELECT S.MaSanPham,S.TenSanPham,H.SoLuong,S.gia*H.SoLuong\n"
//                    + "From SanPham S\n"
//                    + "Inner join HoaDonChiTiet H on S.MaSanPham = H.sanpham\n"
//                    + "Inner join HoaDon HD on H.hoadon = HD.MaHoaDon\n"
//                    + "where HD.MaHoaDon = :MaHoaDon\n"
//                    + "group by S.MaSanPham,S.TenSanPham,H.SoLuong";
////                String hql="Select H.MaSanPham,H.SoLuong,H.DonGia\n"
////                        + "From HoaDonChiTiet H\n"
////                        + "Inner join HoaDon HD on H.hoadon = HD.MaHoaDon\n"
////                        + "where HD.MaHoaDon = :MaHoaDon";
//            TypedQuery<HoaDonChiTiet> query = session.createQuery(hql, HoaDonChiTiet.class);
//            query.setParameter("MaHoaDon", a);
//            nhanvien = query.getResultList();
        List<Object[]> list = new ArrayList<>();
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "SELECT S.MaSanPham,S.TenSanPham,H.SoLuong,S.gia*H.SoLuong\n"
                    + "From SanPham S\n"
                    + "Inner join HoaDonChiTiet H on S.MaSanPham = H.sanpham\n"
                    + "Inner join HoaDon HD on H.hoadon = HD.MaHoaDon\n"
                    + "where HD.MaHoaDon = :MaHoaDon\n";
            Query<?> query = session.createQuery(hql);
            query.setParameter("MaHoaDon", a);
            session.beginTransaction();
            session.getTransaction().commit();

            list = (List<Object[]>) query.getResultList();
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public long TongTien4(int a) {
        long b = 0;
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "SELECT SUM(S.gia*H.SoLuong)\n"
                    + "From SanPham S\n"
                    + "Inner join HoaDonChiTiet H on S.MaSanPham = H.sanpham\n"
                    + "Inner join HoaDon HD on H.hoadon = HD.MaHoaDon\n"
                    + "where HD.MaHoaDon = :MaHoaDon";

            Query<?> query = session.createQuery(hql);
            query.setParameter("MaHoaDon", a);
            session.beginTransaction();
            session.getTransaction().commit();
            b = (long) query.uniqueResult();

        } catch (HibernateException e) {
            JOptionPane.showMessageDialog(null, "");
        }
        return b;
    }

    @Override
    public List<HoaDonDoiTra> thongke10() {
        List<HoaDonDoiTra> nhanvien;
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "SELECT H FROM HoaDonDoiTra H";
            TypedQuery<HoaDonDoiTra> query = session.createQuery(hql, HoaDonDoiTra.class);

            nhanvien = query.getResultList();
        }
        return nhanvien;
    }

    @Override
    public List<HoaDonDoiTra> thongke11(Date a, Date b) {
        List<HoaDonDoiTra> nhanvien;
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "SELECT H FROM HoaDonDoiTra H where CONVERT(date,H.NgayTaoHoaDon) >= :ThoiGianTao and CONVERT (date,H.NgayTaoHoaDon) <= :ThoiGianTao2";
            TypedQuery<HoaDonDoiTra> query = session.createQuery(hql, HoaDonDoiTra.class);
            query.setParameter("ThoiGianTao", a);
            query.setParameter("ThoiGianTao2", b);
            nhanvien = query.getResultList();
        }
        return nhanvien;
    }

    @Override
    public List<Object[]> thongke12(int a) {
        List<Object[]> list = new ArrayList<>();
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "SELECT S.MaSanPham,S.TenSanPham,C.SoLuong,C.DonGia*C.SoLuong\n"
                    + "From SanPham S\n"
                    + "Inner join HoaDonTraChiTiet C on S.MaSanPham = C.sanpham\n"
                    + "Inner join HoaDonDoiTra H on C.hoadondoitra = H.MaHoaDonDoiTra\n"
                    + "Inner join HoaDon r on H.hoadon = r.MaHoaDon\n"
                    + "where H.MaHoaDonDoiTra = :MaHoaDon\n"
                    + "order by H.NgayTaoHoaDon desc";
            Query<?> query = session.createQuery(hql);
            query.setParameter("MaHoaDon", a);
            session.beginTransaction();
            session.getTransaction().commit();

            list = (List<Object[]>) query.getResultList();
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public long TongTien5(int a) {
        long b = 0;
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "SELECT SUM(C.DonGia*C.SoLuong)\n"
                    + "From SanPham S\n"
                    + "Inner join HoaDonTraChiTiet C on S.MaSanPham = C.sanpham\n"
                    + "Inner join HoaDonDoiTra H on C.hoadondoitra = H.MaHoaDonDoiTra\n"
                    + "Inner join HoaDon r on H.hoadon = r.MaHoaDon\n"
                    + "where H.MaHoaDonDoiTra = :MaHoaDon\n";

            Query<?> query = session.createQuery(hql);
            query.setParameter("MaHoaDon", a);
            session.beginTransaction();
            session.getTransaction().commit();
            b = (long) query.uniqueResult();

        } catch (HibernateException e) {
            JOptionPane.showMessageDialog(null, "");
        }
        return b;
    }

    @Override
    public List<HoaDon> thongke13() {
        List<HoaDon> nhanvien;
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "SELECT H FROM HoaDon H where H.TrangThai = 3"
                    + "order by H.ThoiGianTao desc";
            TypedQuery<HoaDon> query = session.createQuery(hql, HoaDon.class);

            nhanvien = query.getResultList();
        }
        return nhanvien;
    }

    @Override
    public List<HoaDon> thongke14(Date a, Date b) {
        List<HoaDon> nhanvien;
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "SELECT H FROM HoaDon H where H.TrangThai = 3 and CONVERT(date,H.ThoiGianTao) >= :ThoiGianTao and CONVERT (date,H.ThoiGianTao) <= :ThoiGianTao2";
            TypedQuery<HoaDon> query = session.createQuery(hql, HoaDon.class);
            query.setParameter("ThoiGianTao", a);
            query.setParameter("ThoiGianTao2", b);
            nhanvien = query.getResultList();
        }
        return nhanvien;
    }

    @Override
    public List<HoaDon> thongke15() {
        List<HoaDon> nhanvien;
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "SELECT H FROM HoaDon H \n"
                    + "where DATEDIFF(day,H.ThoiGianTao,GETDATE())<=3"
                    + "And H.TrangThai = 2\n"
                    + "order by H.ThoiGianTao desc";
            TypedQuery<HoaDon> query = session.createQuery(hql, HoaDon.class);
            nhanvien = query.getResultList();
        }
        return nhanvien;
    }

}
