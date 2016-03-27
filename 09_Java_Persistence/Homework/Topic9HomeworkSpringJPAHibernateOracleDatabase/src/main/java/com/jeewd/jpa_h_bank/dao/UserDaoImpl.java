package com.jeewd.jpa_h_bank.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.jeewd.jpa_h_bank.entities.UserDb;

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public Map<Long, UserDb> getAllUsers() {
        Map<Long, UserDb> users = new HashMap<>();
        List<?> userDbList = new ArrayList<UserDb>();
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        
        try {
            transaction = session.beginTransaction();
            String hql = "FROM com.jeewd.jpa_h_bank.entities.UserDb";
            Query query = session.createQuery(hql);
            
            userDbList = query.list();
            
            for (Object object : userDbList) {
                UserDb userDb = (UserDb) object;
                users.put(userDb.getId(), userDb);
            }
            
            transaction.commit();
        } catch (HibernateException he) {
            if (transaction != null) {
                transaction.rollback();
            }
            
            he.printStackTrace();
        } finally {
            session.close();
        }
        
        return users;
    }

    @Override
    public List<String> getAllUsernames() {
        List<String> usernames = new ArrayList<>();
        List<?> userDbList = new ArrayList<UserDb>();
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        
        try {
            transaction = session.beginTransaction();
            String hql = "FROM com.jeewd.jpa_h_bank.entities.UserDb";
            Query query = session.createQuery(hql);
            
            userDbList = query.list();
            
            for (Object object : userDbList) {
                UserDb userDb = (UserDb) object;
                usernames.add(userDb.getUsername());
            }
            
            transaction.commit();
        } catch (HibernateException he) {
            if (transaction != null) {
                transaction.rollback();
            }
            
            he.printStackTrace();
        } finally {
            session.close();
        }
        
        return usernames;
    }
}
