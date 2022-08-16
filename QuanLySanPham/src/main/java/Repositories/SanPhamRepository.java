/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import DomainModels.DanhMucSanPham;
import DomainModels.HoaDonChiTiet;
import DomainModels.SanPham;
import Utils.HibernateUtil;

import java.util.List;
import javax.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author hieu
 */
public class SanPhamRepository implements ISanPhamRepository {

    @Override
    public List<SanPham> findAll() {
        List<SanPham> products;
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "SELECT i FROM SanPham i";
            TypedQuery<SanPham> query = session.createQuery(hql, SanPham.class);
            products = query.getResultList();
        }
        return products;
    }

//    public static void main(String[] args) {
//        List<SanPham> products = findGiaAndMaSp(80000, "MaSP1");
//        for (SanPham x : products) {
//            System.out.println(x.getMaSanPham());
//        }
//    }
    @Override
    public SanPham insert(SanPham danhMucSp) {
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction trans = session.getTransaction();
            trans.begin();
            try {
                session.saveOrUpdate(danhMucSp);
                trans.commit();
            } catch (Exception e) {
                e.printStackTrace();
                trans.rollback();
                danhMucSp = null;
            }
        } finally {
            return danhMucSp;
        }
    }

    @Override
    public boolean update(SanPham danhMucSp) {
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction trans = session.getTransaction();
            trans.begin();
            try {
                session.saveOrUpdate(danhMucSp);
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
    public SanPham findById(String ma) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean updateSoLuongSP(String MaSp, int soLuong) {

        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "UPDATE SanPham set SoLuong = :soluong WHERE MaSanPham = :maSanPham";
            Query<?> query = session.createQuery(hql);
            query.setParameter("maSanPham", MaSp);
            query.setParameter("soluong", soLuong);
            System.out.println(hql);
            session.beginTransaction();
            int executeUpdate = query.executeUpdate();
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<SanPham> findGiaAndMaSp(int gia, String maSanPham) {
        List<SanPham> products;
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "SELECT p FROM SanPham p WHERE p.MaSanPham = '" + maSanPham + "' or p.gia <=" + gia;
//            select * from SanPham where gia <= 80000 or MaSanPham = 'MaSP1'
            TypedQuery<SanPham> query = session.createQuery(hql, SanPham.class);
            products = query.getResultList();
        }
        return products;
    }
}
