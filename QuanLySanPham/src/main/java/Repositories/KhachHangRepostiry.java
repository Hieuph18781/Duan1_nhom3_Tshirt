/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import DomainModels.KhachHang;
import Utils.HibernateUtil;
import java.util.List;
import javax.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Admin
 */
public class KhachHangRepostiry implements IKhachHangRepository {

    @Override
    public List<KhachHang> fillAll(int position, int pageSize) {
        List<KhachHang> khachhangs ;
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "select p from KhachHang p where p.MaKhachHang != 1";
            TypedQuery<KhachHang> query = session.createQuery(hql, KhachHang.class);
            query.setFirstResult(position);
            query.setMaxResults(pageSize);
            khachhangs =query.getResultList();
        }
        return khachhangs;
    }

    @Override
    public KhachHang findById(int MaKhachHang) {
        KhachHang khachhang;
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
              String hql = "SELECT p FROM KhachHang p WHERE p.MaKhachHang = :MaKhachHang";
            TypedQuery<KhachHang> query = session.createQuery(hql, KhachHang.class);
            query.setParameter("MaKhachHang", MaKhachHang);
            khachhang= query.getSingleResult();
        }
        return khachhang;
    }
    

    @Override
    public KhachHang save(KhachHang khachhang) {
      
         try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
             Transaction trans = session.getTransaction();
            trans.begin();
             try {
                 session.saveOrUpdate(khachhang);
                 trans.commit();
             } catch (Exception e) {
                 e.printStackTrace();
                 trans.rollback();
                 khachhang=null;
             }
         }finally{
             return khachhang;
         }
    }

    @Override
    public long totalCount() {
       long total = 0;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String statement = "SELECT COUNT(p.makhachhang) FROM KhachHang p";
            TypedQuery<Long> query = session.createQuery(statement, Long.class);
            total = query.getSingleResult();
        }
        return total;  
        
    }

    @Override
    public boolean update(KhachHang khachhang) {
try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
             Transaction trans = session.getTransaction();
            trans.begin();
             try {
                 session.saveOrUpdate(khachhang);
                 trans.commit();
                 return true;
             } catch (Exception e) {
                 e.printStackTrace();
                 trans.rollback();
                return false;
             }
         }finally{
             return true;
         }    }

    @Override
    public List<KhachHang> find() {
        List<KhachHang> KH;
        try (Session sesion =HibernateUtil.getSessionFactory().openSession()){
             String hql = "select p from KhachHang p where p.MaKhachHang != 1";
             TypedQuery<KhachHang> query=sesion.createQuery(hql,KhachHang.class);
               KH=query.getResultList();
        }
        return KH;
    }

}
