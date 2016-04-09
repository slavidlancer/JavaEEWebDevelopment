package com.jeewd.web_store.services.product;

import java.util.List;
import com.jeewd.web_store.dto.product.ProductSearch;
import com.jeewd.web_store.dto.product.ProductTransfer;
import com.jeewd.web_store.entities.product.Product;

public interface ProductService {
    List<Product> getAllProducts();
    List<ProductSearch> getProductsBySearch(ProductSearch productSearch);
    Product getProductById(Long id);
    boolean addProduct(ProductTransfer productTransfer);
    boolean updateProduct(ProductTransfer productTransfer);
    boolean deleteProductById(Long id);
}
