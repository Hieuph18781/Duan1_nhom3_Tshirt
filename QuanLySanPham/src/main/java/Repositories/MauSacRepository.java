/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import DomainModels.MauSac;
import Utils.HibernateUtil;
import java.util.List;
import javax.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author hieu
 */
public class MauSacRepository implements IMauSacRepository{

    @Override
    public List<MauSac> findAll() {
        List<MauSac> Colors ;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "SELECT m FROM MauSac m";
            TypedQuery<MauSac> query = session.createQuery(hql, MauSac.class);
   
            Colors = query.getResultList();
        }
        return Colors;
    }

    @Override
    public MauSac Save(MauSac color) {
       try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction trans = session.getTransaction();
            trans.begin();
            try {
                session.saveOrUpdate(color);
                trans.commit();
            } catch (Exception e) {
                e.printStackTrace();
                trans.rollback();
                color = null;
            }
        } finally {
            return color;
        }
    } 

    @Override
    public MauSac findById(String ma) {
       MauSac mausac;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "SELECT m FROM MauSac m WHERE m.MaMauSac = :MaMauSac";
            TypedQuery<MauSac> query = session.createQuery(hql, MauSac.class);
            query.setParameter("MaMauSac", ma);
            mausac = query.getSingleResult();
        }
        return mausac;
    }
}
