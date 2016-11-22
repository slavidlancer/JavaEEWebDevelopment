package com.jeewd.web_store.services.product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jeewd.web_store.dao.product.ProductDao;
import com.jeewd.web_store.dto.product.ProductSearch;
import com.jeewd.web_store.dto.product.ProductTransfer;
import com.jeewd.web_store.entities.product.Product;
import com.jeewd.web_store.entities.product.ProductType;

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
        
        if (productDao.getProductsBySearch(productSearch) != null) {
            for (Product product :
                    productDao.getProductsBySearch(productSearch)) {
                ProductSearch productSearchResult = new ProductSearch();
                productSearchResult.setId(product.getId());
                productSearchResult.setName(product.getName());
                productSearchResult.setType(product.getType().getName());
                productSearchResult.setPrice(product.getPrice().setScale(2).
                        toString());
                productSearchResult.setQuantity(
                        product.getQuantity().toString());
                
                productsSearchResult.add(productSearchResult);
            }
        }
        
        return productsSearchResult != null ? productsSearchResult : null;
    }

    @Override
    public ProductTransfer getProductById(Long id) {
        ProductTransfer productTransfer = new ProductTransfer();
        Product product = productDao.getProductById(id);
        ProductType productType = product.getType();
        productTransfer.setId(product.getId());
        productTransfer.setName(product.getName());
        productTransfer.setType(productType.getName());
        productTransfer.setPrice(product.getPrice().toString());
        productTransfer.setQuantity(product.getQuantity().toString());
        
        return productTransfer;
    }

    @Override
    public boolean addProduct(ProductTransfer productTransfer) {
        Product product = new Product();
        product.setName(productTransfer.getName());
        ProductType productType = new ProductType();
        String productTypeName = productTransfer.getType();
        productType.setName(productTransfer.getType());
        Long id = productDao.getProductTypeId(productTypeName);
        
        if (id != -1) {
            productType.setId(id);
            product.setType(productType);
        } else {
            product.setType(productType);
        }
        
        product.setPrice(new BigDecimal(productTransfer.getPrice()));
        product.setQuantity(Integer.parseInt(productTransfer.getQuantity()));
        product.setStatus("Active");
        
        return productDao.addProduct(product);
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
