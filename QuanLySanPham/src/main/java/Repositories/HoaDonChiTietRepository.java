/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import DomainModels.HoaDon;
import DomainModels.HoaDonChiTiet;
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
public class HoaDonChiTietRepository implements IHoaDonChiTietRepository {

    @Override
    public HoaDonChiTiet insert(HoaDonChiTiet HoaDon1) {
        HoaDon1.setMaHoaDonCT(0);
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
    public boolean update(HoaDonChiTiet HoaDon) {
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
    public List<HoaDonChiTiet> selectAll(int MaHoaDon) {
        List<HoaDonChiTiet> products;
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "SELECT p FROM HoaDonChiTiet p WHERE p.hoadon = "+MaHoaDon;
            TypedQuery<HoaDonChiTiet> query = session.createQuery(hql, HoaDonChiTiet.class);
            products = query.getResultList();
        }
        return products;
    }

    @Override
    public boolean delete(HoaDonChiTiet HoaDon) {
        boolean check;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction trans = session.getTransaction();
            trans.begin();
            try {
                String hql = "DELETE HoaDonChiTiet p WHERE p.MaHoaDonCT = :MaHoaDonCT";
                Query query = session.createQuery(hql);
                query.setParameter("MaHoaDonCT", HoaDon.getMaHoaDonCT());
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
