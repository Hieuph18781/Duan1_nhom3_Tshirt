/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import DomainModels.ChatLieu;
import Utils.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author dytc0
 */
public class ChatLieuRepository implements IChatLieuRepository {


    @Override
    public List<ChatLieu> getProducts() {
        List<ChatLieu> chatLieus;
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "SELECT c FROM ChatLieu c";
            TypedQuery<ChatLieu> query = session.createQuery(hql, ChatLieu.class);
            chatLieus = query.getResultList();
        }
        return chatLieus;
    }

    @Override
    public ChatLieu save(ChatLieu chatLieu) {

        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction trans = session.getTransaction();
            trans.begin();
            try {
                session.save(chatLieu);
                trans.commit();
            } catch (Exception e) {
                e.printStackTrace();
                trans.rollback();
                chatLieu = null;
            }
        } finally {
            return chatLieu;
        }
    }

    @Override
    public ChatLieu update2(ChatLieu chatLieu) {
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction trans = session.getTransaction();
            trans.begin();
            try {
                session.update(chatLieu);
                trans.commit();
            } catch (Exception e) {
                e.printStackTrace();
                trans.rollback();
                chatLieu = null;
            }
        } finally {
            return chatLieu;
        }
    }

//    @Override
//    public int checkMa(String machatlieu) {
//        for (int i = 0; i < chatLieus.size(); i++) {
//            if (chatLieus.get(i).getMaChatLieu().equalsIgnoreCase(machatlieu)) {
//                return i;
//            }
//        }
//        return -3;
//    }


}
