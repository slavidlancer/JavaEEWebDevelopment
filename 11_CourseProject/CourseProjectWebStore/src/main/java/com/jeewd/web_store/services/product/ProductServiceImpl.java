package com.jeewd.web_store.services.product;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jeewd.web_store.dao.product.ProductDao;
import com.jeewd.web_store.dto.product.ProductSearch;
import com.jeewd.web_store.dto.product.ProductTransfer;
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
    public List<ProductSearch> getProductsBySearch(
            ProductSearch productSearch) {
        List<ProductSearch> productsSearchResult = new ArrayList<>();
        productDao.getProductsBySearch(productSearch);
        
        return productsSearchResult;
    }

    @Override
    public Product getProductById(Long id) {
        return productDao.getProductById(id);
    }

    @Override
    public boolean addProduct(ProductTransfer productTransfer) {
        return productDao.addProduct(productTransfer);
    }

    @Override
    public boolean updateProduct(ProductTransfer productTransfer) {
        return productDao.updateProduct(productTransfer);
    }

    @Override
    public boolean deleteProductById(Long id) {
        return productDao.deleteProductById(id);
    }
}
