package com.jeewd.temp;

import java.math.BigDecimal;
import java.util.List;
import com.jeewd.web_store.entities.product.Product;

public interface TryDao {
    List<Product> getAllProducts();
    boolean addProduct(Product product);
    boolean updateProduct(Long id, BigDecimal price, String status);
    boolean deleteProduct(Long id);
    Long getProductTypeId(String name);
}
