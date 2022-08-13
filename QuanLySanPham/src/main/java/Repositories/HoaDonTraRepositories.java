/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import DomainModels.HoaDon;
import DomainModels.HoaDonDoiTra;
import Utils.HibernateUtil;
import java.util.Date;
import java.util.List;
import javax.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author Nguyen Van Thuan
 */
public class HoaDonTraRepositories implements IHoaDonTraRepositories {

    @Override
    public HoaDonDoiTra insert(HoaDonDoiTra HoaDon1) {
        HoaDonDoiTra hddt = getHoadontraBymahoadon(HoaDon1.getHoadon().getMaHoaDon());
        if (hddt != null) {
            return hddt;
        }
        HoaDon1.setMaHoaDonDoiTra(0);
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction trans = session.getTransaction();
            trans.begin();
            try {
                int id = (int) session.save(HoaDon1);
                HoaDon1.setMaHoaDonDoiTra(id);
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
    public HoaDonDoiTra getHoadontraBymahoadon(int mahoadon) {
        HoaDonDoiTra product;
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction trans = session.getTransaction();
            trans.begin();
            String hql = "SELECT p FROM HoaDonDoiTra p WHERE p.hoadon = " + mahoadon;
            try {
                TypedQuery<HoaDonDoiTra> query = session.createQuery(hql, HoaDonDoiTra.class);
                product = query.getSingleResult();
                trans.commit();
                return product;
            } catch (Exception e) {
                e.printStackTrace();
                trans.rollback();
                product = null;
                return product;
            }
        }
    }

    @Override
    public boolean update(HoaDonDoiTra HoaDon) {
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
    public List<HoaDonDoiTra> selectAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<HoaDon> selectHoaDonToDate(Date enity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

//    public static void main(String[] args) {
//        HoaDonDoiTra product;
//        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
//            Transaction trans = session.getTransaction();
//            trans.begin();
//            String hql = "SELECT p FROM HoaDonDoiTra p WHERE p.hoadon = " + 99;
//            try {
//                TypedQuery<HoaDonDoiTra> query = session.createQuery(hql, HoaDonDoiTra.class);
////            query.setParameter("id", 9);
//                product = query.getSingleResult();
//                trans.commit();
//                System.out.println(product);
//                return;
//            } catch (Exception e) {
//                e.printStackTrace();
//                trans.rollback();
//                product = null;
//                System.out.println(product);
//            }
//        }
//
//    }
    @Override
    public boolean delete(int mahoadontra) {
        boolean check;
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction trans = session.getTransaction();
            trans.begin();
            try {
                String hql = "DELETE HoaDonDoiTra p WHERE p.MaHoaDonDoiTra = :MaHoaDonDoiTra";
                Query query = session.createQuery(hql);
                query.setParameter("MaHoaDonDoiTra", mahoadontra);
                int result = query.executeUpdate();
                if (result == 0) {
                    check = true;
                }
                trans.commit();
            } catch (Exception e) {
                check = false;
            }
        }
        return true;
    }
}
