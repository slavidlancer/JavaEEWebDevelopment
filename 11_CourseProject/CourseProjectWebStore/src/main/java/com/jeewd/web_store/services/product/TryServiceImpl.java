package com.jeewd.web_store.services.product;

import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jeewd.web_store.dao.product.TryDao;
import com.jeewd.web_store.entities.product.Product;

@Service
public class TryServiceImpl implements TryService {
    @Autowired
    private TryDao tryDao;
    
    @Override
    public List<Product> getAllProducts() {
        /*for (Product product : tryDao.getAllProducts()) {
            System.out.println(product.getName() + product.getStatus() + product.getId() + product.getQuantity() + product.getPrice() + product.getType());
        }*/
        
        return tryDao.getAllProducts();
    }

    @Override
    public boolean addProduct(Product product) {
        return tryDao.addProduct(product);
    }
    
    @Override
    public boolean deleteProduct(Long id) {
        return tryDao.deleteProduct(id);
    }
    
    @Override
    public boolean updateProduct(Long id, BigDecimal price, String status) {
        return tryDao.updateProduct(id, price, status);
    }
}
