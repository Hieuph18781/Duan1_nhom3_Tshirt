/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import DomainModels.DanhMucSanPham;
import Utils.HibernateUtil;
import java.util.List;
import javax.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Nguyen Van Thuan
 */
public class DanhMucSanPhamRepositories implements IDanhMucSanPhamRepositories {

    @Override
    public DanhMucSanPham insert(DanhMucSanPham danhMucSp) {
        danhMucSp.setMaDanhMuc(0);
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
    public boolean update(DanhMucSanPham danhMucSp) {
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
    public List<DanhMucSanPham> selectAll() {
        List<DanhMucSanPham> products;
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "SELECT p FROM DanhMucSanPham p";
            TypedQuery<DanhMucSanPham> query = session.createQuery(hql, DanhMucSanPham.class);
            products = query.getResultList();
        }
        return products;
    }

    @Override
    public DanhMucSanPham selectById(DanhMucSanPham enity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
