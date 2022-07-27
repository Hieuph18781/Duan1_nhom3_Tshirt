/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import DomainModels.Size;
import Utils.HibernateUtil;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Chung
 */
public class SizeRepository implements ISizeRepository {

    @Override
    public Size save(Size size) {
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction trans = session.getTransaction();
            trans.begin();
            try {
                session.saveOrUpdate(size);
                trans.commit();
            } catch (Exception e) {
                e.printStackTrace();
                trans.rollback();
                size = null;
            }

        } finally {
            return size;
        }

    }

    @Override
    public String dalete(String MaSize) {
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction trans = session.getTransaction();
            trans.begin();
            try {
                String hql="Delete Size p where p.MaSize = : MaSize";
                Query query=session.createQuery(hql);
                query.setParameter("masize", MaSize);
             int result=query.executeUpdate();
                if (result == 0) {
                    MaSize = null;
                    
                }
                trans.commit();
            } catch (Exception e) {
                MaSize=null;
            }
        }
        return MaSize;
    }

    @Override
    public List<Size> finAll(int position, int pageSize) {
        List<Size> sizes;
        try (Session session=HibernateUtil.getSessionFactory().openSession()){
            String hql="select p from Size p";
            TypedQuery<Size> query=session.createQuery(hql,Size.class);
            query.setFirstResult(position);
            query.setMaxResults(pageSize);
            sizes= query.getResultList();
       
        }
        return sizes;
    
}

    @Override
    public boolean update(Size size) {
        try ( Session session = HibernateUtil.getSessionFactory().openSession()){
            Transaction trans = session.getTransaction();
            trans.begin();
            try {
                session.saveOrUpdate(size);
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
    public List<Size> find() {
        List<Size> sizes;
        try(Session sesion =HibernateUtil.getSessionFactory().openSession()){
            String hql="select p from Size p";
              TypedQuery<Size> query=sesion.createQuery(hql,Size.class);
               sizes=query.getResultList();
               
        }
        return sizes;
    }
    @Override
    public List<Size> getfullsizedb(){
    List<Size> sizes;
        try (Session session=HibernateUtil.getSessionFactory().openSession()){
            String hql="select p from Size p";
            TypedQuery<Size> query=session.createQuery(hql,Size.class);
            sizes= query.getResultList();
        }
        return sizes;
    }
}
