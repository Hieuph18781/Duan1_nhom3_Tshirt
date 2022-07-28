/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import DomainModels.DanhMucSanPham;
import DomainModels.KhuyenMai;
import Utils.HibernateUtil;
import java.util.List;
import javax.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author hieu
 */
public class KhuyenMaiRepository implements IKhuyenmaiRepository{

    @Override
    public KhuyenMai insert(KhuyenMai km) {
        km.setIdKhuyenMai(0);
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction trans = session.getTransaction();
            trans.begin();
            try {
                session.saveOrUpdate(km);
                trans.commit();
            } catch (Exception e) {
                e.printStackTrace();
                trans.rollback();
                km = null;
            }
        } finally {
            return km;
        }
    }

    @Override
    public boolean update(KhuyenMai km) {
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction trans = session.getTransaction();
            trans.begin();
            try {
                session.saveOrUpdate(km);
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
    public List<KhuyenMai> selectAll() {
         List<KhuyenMai> products;
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "SELECT k FROM KhuyenMai k";
            TypedQuery<KhuyenMai> query = session.createQuery(hql, KhuyenMai.class);
            products = query.getResultList();
        }
        return products;
    }

    @Override
    public KhuyenMai selectById(KhuyenMai enity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
