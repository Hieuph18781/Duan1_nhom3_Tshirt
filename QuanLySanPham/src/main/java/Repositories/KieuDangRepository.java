/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import DomainModels.KieuDang;

import Utils.HibernateUtil;
import java.util.List;
import javax.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author hieu
 */
public class KieuDangRepository implements IKieuDangRepository{

    @Override
    public List<KieuDang> findAll() {
        List<KieuDang> kieudang ;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "SELECT m FROM KieuDang m";
            TypedQuery<KieuDang> query = session.createQuery(hql, KieuDang.class);
   
            kieudang = query.getResultList();
        }
        return kieudang;
    }

    public KieuDang Save(KieuDang kieudang) {
       try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction trans = session.getTransaction();
            trans.begin();
            try {
                session.saveOrUpdate(kieudang);
                trans.commit();
            } catch (Exception e) {
                e.printStackTrace();
                trans.rollback();
                kieudang = null;
            }
        } finally {
            return kieudang;
        }
    } 

   public boolean update(KieuDang kieudangSp) {
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction trans = session.getTransaction();
            trans.begin();
            try {
                session.saveOrUpdate(kieudangSp);
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

    

    }

   

