/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import DomainModels.DanhMucSanPham;
import DomainModels.HoaDon;
import DomainModels.HoaDonChiTiet;
import Utils.HibernateUtil;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Nguyen Van Thuan
 */
public class HoaDonRepository implements IHoaDonRepository {

    @Override
    public HoaDon insert(HoaDon HoaDon1) {
        HoaDon1.setMaHoaDon(0);
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction trans = session.getTransaction();
            trans.begin();
            try {
                int id = (int) session.save(HoaDon1);
                HoaDon1.setMaHoaDon(id);
                trans.commit();
            } catch (Exception e) {
                e.printStackTrace();
                trans.rollback();
                HoaDon1 = null;
            }
        } finally {
            return HoaDon1;
        }
    }

    @Override
    public boolean update(HoaDon HoaDon) {
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction trans = session.getTransaction();
            trans.begin();
            try {
                session.saveOrUpdate(HoaDon);
                trans.commit();
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                trans.rollback();
                return false;
            }
        } finally {
            return true;
        }
    }

    @Override
    public List<HoaDon> selectAll() {
        List<HoaDon> products;
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "SELECT p FROM HoaDon p";
            TypedQuery<HoaDon> query = session.createQuery(hql, HoaDon.class);
            products = query.getResultList();
        }
        return products;
    }
//
//    public static void main(String[] args) {
//        DateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        System.out.println(dateFormat1.format(new java.util.Date()));
//    }

    @Override
    public List<HoaDon> selectHoaDonToDate(Date enity) {
        List<HoaDon> products;
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "SELECT p FROM HoaDon p WHERE p.TrangThai = 0";
            TypedQuery<HoaDon> query = session.createQuery(hql, HoaDon.class);
            products = query.getResultList();
            return products;
        }
    }
//    public static void main(String[] args) {
//        System.out.println(getHoadonById(1).toString());
//    }

    @Override
    public HoaDon getHoadonById(int mahoadon) {
        HoaDon hoaDon;
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "SELECT p FROM HoaDon p WHERE p.MaHoaDon = :MaHoaDon";
            TypedQuery<HoaDon> query = session.createQuery(hql, HoaDon.class);
            query.setParameter("MaHoaDon", mahoadon);
            hoaDon = query.getSingleResult();
        }
        return hoaDon;
    }
}
