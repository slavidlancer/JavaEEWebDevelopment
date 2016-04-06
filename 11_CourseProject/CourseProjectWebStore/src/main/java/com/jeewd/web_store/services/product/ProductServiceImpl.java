package com.jeewd.web_store.services.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jeewd.web_store.dao.product.ProductDao;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;
}
