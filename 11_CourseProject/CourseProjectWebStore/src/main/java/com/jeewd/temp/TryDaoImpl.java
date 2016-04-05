package com.jeewd.temp;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.jeewd.web_store.entities.product.Product;
import com.jeewd.web_store.entities.product.ProductType;

@Repository
public class TryDaoImpl implements TryDao {
    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    @Override
    public List<Product> getAllProducts() {
        List<?> productList = new ArrayList<Product>();
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        
        try {
            transaction = session.beginTransaction();
            String hql = "FROM com.jeewd.web_store.entities.product.Product";
            Query query = session.createQuery(hql);
            
            productList = query.list();
            
            for (Object object : productList) {
                Product product = (Product) object;
                System.out.println(product.getName() + ":" + product.getType().getName());
                System.out.println(product.getPrice() + "/" + product.getId());
                System.out.println(product.getStatus() + "\n");
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
        
        return (ArrayList<Product>) productList;
    }

    @Override
    public boolean addProduct(Product product) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        @SuppressWarnings("unused")
        Long id = null;
        
        try {
           transaction = session.beginTransaction();
           id = (Long) session.save(product);
           
           transaction.commit();
        } catch (HibernateException he) {
            if (transaction != null) {
                transaction.rollback();
            }
            
            he.printStackTrace();
            
            return false;
        } finally {
           session.close();
        }
        
        return true;
    }
    
    @Override
    public boolean updateProduct(Long id, BigDecimal price, String status) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        
        try {
           transaction = session.beginTransaction();
           Product product = 
                      session.get(
                  com.jeewd.web_store.entities.product.Product.class, id);
           product.setPrice(product.getPrice().add(price));
           product.setStatus(status);
           
           session.update(product);
           transaction.commit();
        } catch (HibernateException he) {
            if (transaction != null) {
                transaction.rollback();
            }
            
            he.printStackTrace();
            
            return false;
        } finally {
           session.close();
        }
        
        return true;
     }
     
     @Override
    public boolean deleteProduct(Long id) {
         Session session = sessionFactory.openSession();
         Transaction transaction = null;
         
         try {
           transaction = session.beginTransaction();
           Product product =
                     session.get(
                 com.jeewd.web_store.entities.product.Product.class, id);
           
           session.delete(product);
           transaction.commit();
         } catch (HibernateException he) {
             if (transaction != null) {
                 transaction.rollback();
             }
             
             he.printStackTrace();
             
             return false;
         } finally {
            session.close();
         }
         
         return true;
     }
     
     @Override
     public Long getProductTypeId(String name) {
         Long id = -1L;
         Session session = sessionFactory.openSession();
         Transaction transaction = null;
         
         try {
             transaction = session.beginTransaction();
             String hql = "from "
                     + "com.jeewd.web_store.entities.product.ProductType pt "
                     + "where pt.name = :name";
             Query query = session.createQuery(hql);
             query.setParameter("name", name);
             
             if (query.uniqueResult() != null) {
                 ProductType productType = (ProductType) query.uniqueResult();
                 id = productType.getId();
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
         
         return id;
     }
}
