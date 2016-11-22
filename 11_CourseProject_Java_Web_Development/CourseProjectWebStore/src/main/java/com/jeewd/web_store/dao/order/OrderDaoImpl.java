package com.jeewd.web_store.dao.order;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.jeewd.web_store.dto.order.OrderSearch;
import com.jeewd.web_store.dto.order.OrderTransfer;
import com.jeewd.web_store.entities.order.Order;

@Repository
public class OrderDaoImpl implements OrderDao {
    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    @Override
    public List<Order> getAllOrders() {
        List<?> orderList = new ArrayList<Order>();
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        
        try {
            transaction = session.beginTransaction();
            String hql = "FROM com.jeewd.web_store.entities.order.Order";
            Query query = session.createQuery(hql);
            
            orderList = query.list();
            
            transaction.commit();
        } catch (HibernateException he) {
            if (transaction != null) {
                transaction.rollback();
            }
            
            he.printStackTrace();
        } finally {
            session.close();
        }
        
        return (ArrayList<Order>) orderList;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Order> getOrdersBySearch(OrderSearch orderSearch) {
        List<?> orderList = new ArrayList<Order>();
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        
        try {
            transaction = session.beginTransaction();
            String hql = "FROM com.jeewd.web_store.entities.order.Order o"
                    + " WHERE (o.status = :status)";
            Query query = session.createQuery(hql);
            query.setParameter("status", "Active");
            
            orderList = query.list();
            
            transaction.commit();
        } catch (HibernateException he) {
            if (transaction != null) {
                transaction.rollback();
            }
            
            he.printStackTrace();
        } finally {
            session.close();
        }
        
        return (ArrayList<Order>) orderList;
    }

    @Override
    public Order getOrderById(Long id) {
        return null;
    }

    @Override
    public boolean addOrder(OrderTransfer orderTransfer) {
        return false;
    }

    @Override
    public boolean updateOrder(OrderTransfer orderTransfer) {
        return false;
    }

    @Override
    public boolean deleteOrderById(Long id) {
        return false;
    }
}
