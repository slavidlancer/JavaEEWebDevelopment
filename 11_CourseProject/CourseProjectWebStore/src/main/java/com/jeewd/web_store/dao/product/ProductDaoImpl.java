package com.jeewd.web_store.dao.product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.jeewd.web_store.dto.product.ProductSearch;
import com.jeewd.web_store.dto.product.ProductTransfer;
import com.jeewd.web_store.entities.product.Product;
import com.jeewd.web_store.entities.product.ProductType;

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
        boolean isNameNullAndEmpty = false;
        boolean isTypeNullAndEmpty = false;
        boolean isPriceNullAndEmpty = false;
        boolean isQuantityNullAndEmpty = false;
        
        try {
            transaction = session.beginTransaction();
            
            if ((productSearch.getName() == null) ||
                    ("".equals(productSearch.getName()))) {
                isNameNullAndEmpty = true;
            }
            
            if ((productSearch.getType() == null) ||
                    ("".equals(productSearch.getType()))) {
                isTypeNullAndEmpty = true;
            }
            
            if ((productSearch.getPrice() == null) ||
                    ("".equals(productSearch.getPrice()))) {
                isPriceNullAndEmpty = true;
            }
            
            if ((productSearch.getQuantity() == null) ||
                    ("".equals(productSearch.getQuantity()))) {
                isQuantityNullAndEmpty = true;
            }
            
            if (isNameNullAndEmpty && isTypeNullAndEmpty &&
                    isPriceNullAndEmpty && isQuantityNullAndEmpty) {
                String hql = "FROM com.jeewd.web_store.entities.product.Product"
                        + " p WHERE (p.status = :status)";
                Query query = session.createQuery(hql);
                query.setParameter("status", "Active");
                
                productList = query.list();
            } else {
                Criteria criteria = session.createCriteria(Product.class);
                criteria.add(Restrictions.in("status", "Active"));
                
                if (!isNameNullAndEmpty) {
                    criteria.add(Restrictions.in("name",
                            productSearch.getName()));
                }
                
                if (!isTypeNullAndEmpty) {
                    ProductType productType = new ProductType();
                    productType.setName(productSearch.getType());
                    productType.setId(getProductTypeId(productType.getName()));
                    
                    criteria.add(Restrictions.in("type", productType));
                }
                
                if (!isPriceNullAndEmpty) {
                    criteria.add(Restrictions.in("price",
                            new BigDecimal(productSearch.getPrice())));
                }
                
                if (!isQuantityNullAndEmpty) {
                    criteria.add(Restrictions.in("quantity",
                            Integer.parseInt(productSearch.getQuantity())));
                }
                
                productList = criteria.list();
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
    public Product getProductById(Long id) {
        Product product = null;
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        
        try {
            transaction = session.beginTransaction();
            String hql = "from "
                    + "com.jeewd.web_store.entities.product.Product p "
                    + "where p.id = :id";
            Query query = session.createQuery(hql);
            query.setParameter("id", id);
            
            if (query.uniqueResult() != null) {
                product = (Product) query.uniqueResult();
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
        
        return product != null ? product : null;
    }

    @Override
    public Long getProductTypeId(String productTypeName) {
        Long id = -1L;
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        
        try {
            transaction = session.beginTransaction();
            String hql = "from "
                    + "com.jeewd.web_store.entities.product.ProductType pt "
                    + "where pt.name = :name";
            Query query = session.createQuery(hql);
            query.setParameter("name", productTypeName);
            
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
    public boolean updateProduct(ProductTransfer productTransfer) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        
        try {
           transaction = session.beginTransaction();
           Product product = 
                      session.get(
                  com.jeewd.web_store.entities.product.Product.class,
                      productTransfer.getId());
           product.setName(productTransfer.getName());
           ProductType productType = new ProductType();
           productType.setName(productTransfer.getType());
           
           if (!productTransfer.getType().equals(product.getType().getName())) {
               product.setType(productType);
           }
           
           product.setPrice(new BigDecimal(productTransfer.getPrice()));
           product.setQuantity(Integer.parseInt(productTransfer.getQuantity()));
           
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
    public boolean deleteProductById(Long id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        
        try {
           transaction = session.beginTransaction();
           Product product = 
                      session.get(
                  com.jeewd.web_store.entities.product.Product.class, id);
           product.setStatus("Inactive");
           
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
}
