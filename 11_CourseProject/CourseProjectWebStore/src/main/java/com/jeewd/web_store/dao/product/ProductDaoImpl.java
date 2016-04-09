package com.jeewd.web_store.dao.product;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.jeewd.web_store.dto.product.ProductSearch;
import com.jeewd.web_store.dto.product.ProductTransfer;
import com.jeewd.web_store.entities.product.Product;

@Repository
public class ProductDaoImpl implements ProductDao {
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
            
            /*for (Object object : productList) {
                Product product = (Product) object;
                System.out.println(product.getName() + ":" + product.getType().getName());
                System.out.println(product.getPrice() + "/" + product.getId());
                System.out.println(product.getStatus() + "\n");
            }*/
            
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

    @SuppressWarnings("unchecked")
    @Override
    public List<Product> getProductsBySearch(ProductSearch productSearch) {
        List<?> productList = new ArrayList<Product>();
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        
        try {
            transaction = session.beginTransaction();
            String hql = "FROM com.jeewd.web_store.entities.product.Product p"
                    + " WHERE (p.status = :status)";
                    /*+ " AND (p.name LIKE :name) AND (p.type LIKE :type)";*/
            Query query = session.createQuery(hql);
            query.setParameter("status", "Active");
            /*query.setParameter("name", name);
            query.setParameter("type", type);*/
            
            productList = query.list();
            
            /*for (Object object : productList) {
                Product product = (Product) object;
                System.out.println(product.getName() + ":" + product.getType().getName());
                System.out.println(product.getPrice() + "/" + product.getId());
                System.out.println(product.getStatus() + "\n");
            }*/
            
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
    public Product getProductById(Long id) {
        return null;
    }

    @Override
    public boolean addProduct(ProductTransfer productTransfer) {
        return false;
    }

    @Override
    public boolean updateProduct(ProductTransfer productTransfer) {
        return false;
    }

    @Override
    public boolean deleteProductById(Long id) {
        return false;
    }
}
