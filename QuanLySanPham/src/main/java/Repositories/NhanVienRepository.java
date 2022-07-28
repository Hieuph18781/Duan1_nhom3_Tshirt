/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;


import DomainModels.NhanVien;
import Utils.HibernateUtil;
import java.util.List;
import javax.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Bùi Công Minh
 */
public class NhanVienRepository  implements INhanVienRepostiory{

    @Override
    public List<NhanVien> findAll() {
          List<NhanVien> nhanvien ;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "SELECT m FROM NhanVien m";
            TypedQuery<NhanVien> query = session.createQuery(hql, NhanVien.class);
   
            nhanvien = query.getResultList();
        }
        return nhanvien;
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public NhanVien Save(NhanVien nhanvien) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction trans = session.getTransaction();
            trans.begin();
            try {
                session.saveOrUpdate(nhanvien);
                trans.commit();
            } catch (Exception e) {
                e.printStackTrace();
                trans.rollback();
                nhanvien = null;
            }
        } finally {
            return nhanvien;
        } //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(NhanVien nhanvien) {
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction trans = session.getTransaction();
            trans.begin();
            try {
                session.saveOrUpdate(nhanvien);
                trans.commit();
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                trans.rollback();
                return false;
            }
        } finally {
            return true; //To change body of generated methods, choose Tools | Templates.
    }
    
}
}
