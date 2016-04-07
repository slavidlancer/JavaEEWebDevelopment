package com.jeewd.web_store.dao.product;

import java.util.List;
import com.jeewd.web_store.dto.product.ProductSearch;
import com.jeewd.web_store.entities.product.Product;

public interface ProductDao {
    List<Product> getAllProducts();
    List<Product> getProductsBySearch(ProductSearch productSearch);
    boolean addProduct(Product product);
    boolean updateProduct(Product product);
    boolean deleteProduct(Product product);
}
