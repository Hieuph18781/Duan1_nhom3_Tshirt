/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import DomainModels.HoaDonChiTiet;
import DomainModels.HoaDonTraChiTiet;
import Utils.HibernateUtil;
import java.util.List;
import javax.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author Nguyen Van Thuan
 */
public class HoaDonDoiTraChiTietRepositories implements IHoaDonDoiTraChiTietRepositories{

    @Override
    public HoaDonTraChiTiet insert(HoaDonTraChiTiet HoaDon1) {
        HoaDon1.setMaHoaDonTraChiTiet(0);
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction trans = session.getTransaction();
            trans.begin();
            try {
                session.save(HoaDon1);
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
    public boolean update(HoaDonTraChiTiet HoaDonDoiTraChiTiet) {
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction trans = session.getTransaction();
            trans.begin();
            try {
                session.saveOrUpdate(HoaDonDoiTraChiTiet);
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
    public boolean delete(HoaDonTraChiTiet HoaDonDoiTraChiTiet) {
        boolean check;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction trans = session.getTransaction();
            trans.begin();
            try {
                String hql = "DELETE HoaDonTraChiTiet p WHERE p.MaHoaDonTraChiTiet = :MaHoaDonTraChiTiet";
                Query query = session.createQuery(hql);
                query.setParameter("MaHoaDonTraChiTiet", HoaDonDoiTraChiTiet.getMaHoaDonTraChiTiet());
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
//    public static void main(String[] args) {
//        List<HoaDonDoiTraChiTiet> products;
//        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
//            String hql = "SELECT p FROM HoaDonTraChiTiet p WHERE p.hoadondoitra = "+191;
//            TypedQuery<HoaDonDoiTraChiTiet> query = session.createQuery(hql, HoaDonTraChiTiet.class);
//            products = query.getResultList();
//            if (products.isEmpty()) {
//                System.out.println("1");
//            }
//            for (HoaDonTraChiTiet x : products) {
//                System.out.println(x);
//            }
//        }
//        
//    }
    @Override
    public List<HoaDonTraChiTiet> selectAll(int MaHoaDonDoiTra) {
        List<HoaDonTraChiTiet> products;
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "SELECT p FROM HoaDonTraChiTiet p WHERE p.hoadondoitra = "+MaHoaDonDoiTra;
            TypedQuery<HoaDonTraChiTiet> query = session.createQuery(hql, HoaDonTraChiTiet.class);
            products = query.getResultList();
        }
        return products;
    }
    
}
