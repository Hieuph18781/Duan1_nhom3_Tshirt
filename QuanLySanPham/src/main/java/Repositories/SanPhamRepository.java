/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import DomainModels.DanhMucSanPham;
import DomainModels.SanPham;
import Utils.HibernateUtil;

import java.util.List;
import javax.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;


/**
 *
 * @author hieu
 */
public class SanPhamRepository implements ISanPhamRepository{

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
    
}
