/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import DomainModels.NhanVien;
import Utils.HibernateUtil;
import java.util.List;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author Bùi Công Minh
 */
public class NhanVienRepository implements INhanVienRepostiory {

    @Override
    public List<NhanVien> findAll() {
        List<NhanVien> nhanvien;
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "SELECT m FROM NhanVien m";
            TypedQuery<NhanVien> query = session.createQuery(hql, NhanVien.class);

            nhanvien = query.getResultList();
        }
        return nhanvien;
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public NhanVien Save(NhanVien nhanvien) {
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
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

    @Override
    public NhanVien findById(String MaNhanVien) {
        NhanVien nv;
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "SELECT n FROM NhanVien n WHERE n.MaNhanVien = :MaNhanVien";
            TypedQuery<NhanVien> query = session.createQuery(hql, NhanVien.class);
            query.setParameter("MaNhanVien", MaNhanVien);
            nv = query.getSingleResult();
        }
        return nv;
    }

    @Override
    public void updatemk(String MaNhanVien, String matkhau) {
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "UPDATE NhanVien set MatKhau = :matKhau WHERE MaNhanVien = :maNhanVien";
            Query<?> query = session.createQuery(hql);
            query.setParameter("maNhanVien", MaNhanVien);
            query.setParameter("matKhau", matkhau);
            System.out.println(hql);
            session.beginTransaction();

            int executeUpdate = query.executeUpdate();
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public NhanVien findByChucVu(String ChucVu) {
         NhanVien nv;
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "SELECT n FROM NhanVien n WHERE n.ChucVu= :ChucVu";
            TypedQuery<NhanVien> query = session.createQuery(hql, NhanVien.class);
            query.setParameter("Quản Lý", ChucVu);
            nv = query.getSingleResult();
        }
        return nv; //To change body of generated methods, choose Tools | Templates.
    }
}
