/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import DomainModels.HoaDonChiTiet;
import DomainModels.HoaDonDoiTraChiTiet;
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
    public HoaDonDoiTraChiTiet insert(HoaDonDoiTraChiTiet HoaDon1) {
        HoaDon1.setMaHoaDonDoiTraChiTiet(0);
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
    public boolean update(HoaDonDoiTraChiTiet HoaDonDoiTraChiTiet) {
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
    public boolean delete(HoaDonDoiTraChiTiet HoaDonDoiTraChiTiet) {
        boolean check;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction trans = session.getTransaction();
            trans.begin();
            try {
                String hql = "DELETE HoaDonDoiTraChiTiet p WHERE p.MaHoaDonDoiTraChiTiet = :MaHoaDonDoiTraChiTiet";
                Query query = session.createQuery(hql);
                query.setParameter("MaHoaDonDoiTraChiTiet", HoaDonDoiTraChiTiet.getMaHoaDonDoiTraChiTiet());
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
//            String hql = "SELECT p FROM HoaDonDoiTraChiTiet p WHERE p.hoadondoitra = "+191;
//            TypedQuery<HoaDonDoiTraChiTiet> query = session.createQuery(hql, HoaDonDoiTraChiTiet.class);
//            products = query.getResultList();
//            if (products.isEmpty()) {
//                System.out.println("1");
//            }
//            for (HoaDonDoiTraChiTiet x : products) {
//                System.out.println(x);
//            }
//        }
//        
//    }
    @Override
    public List<HoaDonDoiTraChiTiet> selectAll(int MaHoaDonDoiTra) {
        List<HoaDonDoiTraChiTiet> products;
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "SELECT p FROM HoaDonDoiTraChiTiet p WHERE p.hoadondoitra = "+MaHoaDonDoiTra;
            TypedQuery<HoaDonDoiTraChiTiet> query = session.createQuery(hql, HoaDonDoiTraChiTiet.class);
            products = query.getResultList();
        }
        return products;
    }
    
}
