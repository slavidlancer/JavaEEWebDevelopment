package com.jeewd.web_store.dao.user;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.jeewd.web_store.dto.user.UserSearch;
import com.jeewd.web_store.dto.user.UserTransfer;
import com.jeewd.web_store.entities.user.User;

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    @Override
    public List<User> getAllUsers() {
        List<?> userList = new ArrayList<User>();
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        
        try {
            transaction = session.beginTransaction();
            String hql = "FROM com.jeewd.web_store.entities.user.User";
            Query query = session.createQuery(hql);
            
            userList = query.list();
            
            transaction.commit();
        } catch (HibernateException he) {
            if (transaction != null) {
                transaction.rollback();
            }
            
            he.printStackTrace();
        } finally {
            session.close();
        }
        
        return (ArrayList<User>) userList;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<User> getUsersBySearch(UserSearch userSearch) {
        List<?> userList = new ArrayList<User>();
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        
        try {
            transaction = session.beginTransaction();
            String hql = "FROM com.jeewd.web_store.entities.user.User";
            Query query = session.createQuery(hql);
            
            userList = query.list();
            
            transaction.commit();
        } catch (HibernateException he) {
            if (transaction != null) {
                transaction.rollback();
            }
            
            he.printStackTrace();
        } finally {
            session.close();
        }
        
        return (ArrayList<User>) userList;
    }

    @Override
    public User getUserById(Long id) {
        return null;
    }

    @Override
    public User getUserByUsername(String username) {
        User userResult = null;
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        
        try {
            transaction = session.beginTransaction();
            String hql = "FROM com.jeewd.web_store.entities.user.User u"
                    + " WHERE u.status = :status AND u.username = :username";
            Query query = session.createQuery(hql);
            query.setParameter("status", "Active");
            query.setParameter("username", username);
            
            if (!query.list().isEmpty()) {
                userResult = (User) query.list().get(0);
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
        
        return userResult;
    }

    @Override
    public boolean addUser(UserTransfer userTransfer) {
        return false;
    }

    @Override
    public boolean updateUser(UserTransfer userTransfer) {
        return false;
    }

    @Override
    public boolean deleteUserById(Long id) {
        return false;
    }
}
