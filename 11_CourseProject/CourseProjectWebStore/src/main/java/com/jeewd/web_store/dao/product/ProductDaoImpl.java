package com.jeewd.web_store.dao.product;

import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.jeewd.web_store.dto.product.ProductSearch;
import com.jeewd.web_store.entities.product.Product;

@Repository
public class ProductDaoImpl implements ProductDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public List<Product> getProductsBySearch(ProductSearch productSearch) {
        return null;
    }

    @Override
    public Product getProductById(Long id) {
        return null;
    }

    @Override
    public boolean addProduct(Product product) {
        return false;
    }

    @Override
    public boolean updateProduct(Product product) {
        return false;
    }

    @Override
    public boolean deleteProductById(Long id) {
        return false;
    }
}
