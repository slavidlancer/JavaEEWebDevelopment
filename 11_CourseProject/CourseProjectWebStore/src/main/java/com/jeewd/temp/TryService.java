package com.jeewd.temp;

import java.math.BigDecimal;
import java.util.List;
import com.jeewd.web_store.entities.product.Product;

public interface TryService {
    List<Product> getAllProducts();
    boolean addProduct(Product product);
    boolean deleteProduct(Long id);
    boolean updateProduct(Long id, BigDecimal price, String status);
    Long getProductTypeId(String name);
}