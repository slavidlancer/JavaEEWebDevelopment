package com.jeewd.web_store.dao.customer;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.jeewd.web_store.dto.customer.CustomerSearch;
import com.jeewd.web_store.dto.customer.CustomerTransfer;
import com.jeewd.web_store.entities.customer.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao {
    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    @Override
    public List<Customer> getAllCustomers() {
        List<?> customerList = new ArrayList<Customer>();
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        
        try {
            transaction = session.beginTransaction();
            String hql = "FROM com.jeewd.web_store.entities.customer.Customer";
            Query query = session.createQuery(hql);
            
            customerList = query.list();
            
            transaction.commit();
        } catch (HibernateException he) {
            if (transaction != null) {
                transaction.rollback();
            }
            
            he.printStackTrace();
        } finally {
            session.close();
        }
        
        return (ArrayList<Customer>) customerList;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Customer> getCustomersBySearch(
            CustomerSearch customerSearch) {
        List<?> customerList = new ArrayList<Customer>();
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        
        try {
            transaction = session.beginTransaction();
            String hql = "FROM com.jeewd.web_store.entities.customer.Customer c"
                    + " WHERE (c.status = :status)";
            Query query = session.createQuery(hql);
            query.setParameter("status", "Active");
            
            customerList = query.list();
            
            transaction.commit();
        } catch (HibernateException he) {
            if (transaction != null) {
                transaction.rollback();
            }
            
            he.printStackTrace();
        } finally {
            session.close();
        }
        
        return (ArrayList<Customer>) customerList;
    }

    @Override
    public Customer getCustomerById(Long id) {
        return null;
    }

    @Override
    public boolean addCustomer(CustomerTransfer customerTransfer) {
        return false;
    }

    @Override
    public boolean updateCustomer(CustomerTransfer customerTransfer) {
        return false;
    }

    @Override
    public boolean deleteCustomerById(Long id) {
        return false;
    }
}
