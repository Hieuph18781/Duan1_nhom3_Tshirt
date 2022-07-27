/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import DomainModels.ChatLieu;
import DomainModels.DanhMucSanPham;
import DomainModels.KieuDang;
import DomainModels.MauSac;
import DomainModels.SanPham;
import DomainModels.Size;
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
    public SanPham insert(SanPham Sp) {
        Sp.setMaSanPham("");
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction trans = session.getTransaction();
            trans.begin();
            try {
                session.saveOrUpdate(Sp);
                trans.commit();
            } catch (Exception e) {
                e.printStackTrace();
                trans.rollback();
                Sp = null;
            }
        } finally {
            return Sp;
        }
    }

    @Override
    public boolean update(SanPham Sp) {
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction trans = session.getTransaction();
            trans.begin();
            try {
                session.saveOrUpdate(Sp);
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
    public List<SanPham> selectAll() {
         List<SanPham> Sanpham ;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "SELECT s FROM SanPham s";
            TypedQuery<SanPham> query = session.createQuery(hql, SanPham.class);
   
            Sanpham = query.getResultList();
        }
        return Sanpham;
    }

    @Override
    public SanPham findById(SanPham ma) {
        SanPham sanpham;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "SELECT s FROM SanPham s WHERE s.MaSanPham = :MaSanPham";
            TypedQuery<SanPham> query = session.createQuery(hql, SanPham.class);
            query.setParameter("MaSanPham", ma);
            sanpham = query.getSingleResult();
        }
        return sanpham;
    }

    @Override
    public List<MauSac> selectAllms() {
        List<MauSac> Colors ;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "SELECT m FROM MauSac m";
            TypedQuery<MauSac> query = session.createQuery(hql, MauSac.class);
   
            Colors = query.getResultList();
        }
        return Colors;
    }

    @Override
    public List<DanhMucSanPham> selectAlldmsp() {
        List<DanhMucSanPham> products;
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "SELECT p FROM DanhMucSanPham p";
            TypedQuery<DanhMucSanPham> query = session.createQuery(hql, DanhMucSanPham.class);
            products = query.getResultList();
        }
        return products;
    }

    @Override
    public List<Size> selectAllsi() {
        List<Size> sizes;
        try (Session session=HibernateUtil.getSessionFactory().openSession()){
            String hql="select p from Size p";
            TypedQuery<Size> query=session.createQuery(hql,Size.class);
            sizes= query.getResultList();
       
        }
        return sizes;
    }

    @Override
    public List<KieuDang> selectAllkd() {
        List<KieuDang> kieudang ;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "SELECT m FROM KieuDang m";
            TypedQuery<KieuDang> query = session.createQuery(hql, KieuDang.class);
   
            kieudang = query.getResultList();
        }
        return kieudang;
    }

    @Override
    public List<ChatLieu> selectAllcl() {
        List<ChatLieu> chatLieus;
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "SELECT c FROM ChatLieu c";
            TypedQuery<ChatLieu> query = session.createQuery(hql, ChatLieu.class);
            chatLieus = query.getResultList();
        }
        return chatLieus;
    }
    
}
