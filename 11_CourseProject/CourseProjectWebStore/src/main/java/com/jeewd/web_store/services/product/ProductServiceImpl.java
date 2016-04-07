package com.jeewd.web_store.services.product;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jeewd.web_store.dao.product.ProductDao;
import com.jeewd.web_store.dto.product.ProductSearch;
import com.jeewd.web_store.entities.product.Product;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;

    @Override
    public List<Product> getAllProducts() {
        return productDao.getAllProducts();
    }

    @Override
    public List<Product> getProductsBySearch(ProductSearch productSearch) {
        return productDao.getProductsBySearch(productSearch);
    }

    @Override
    public boolean addProduct(Product product) {
        return productDao.addProduct(product);
    }

    @Override
    public boolean updateProduct(Product product) {
        return productDao.updateProduct(product);
    }

    @Override
    public boolean deleteProduct(Product product) {
        return productDao.deleteProduct(product);
    }
}
