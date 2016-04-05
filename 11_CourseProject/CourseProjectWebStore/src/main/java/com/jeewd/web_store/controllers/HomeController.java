package com.jeewd.web_store.controllers;

//import java.math.BigDecimal;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/*import com.jeewd.web_store.entities.product.Product;
import com.jeewd.web_store.entities.product.ProductType;*/
//import com.jeewd.web_store.services.product.TryService;

//http://localhost:8080/web_store
@Controller
public class HomeController {
    /*@Autowired
    private TryService tryService;*/
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String homePage() {
        /*Product product = new Product();
        //product.setId((long) 5);
        product.setName("new_product 03");
        product.setPrice(new BigDecimal("9.99"));
        product.setQuantity(1);
        product.setStatus("Active");
        ProductType productType = new ProductType();
        //productType.setId((long) 3);
        String productTypeName = "drink2";
        productType.setName(productTypeName);
        Long id = tryService.getProductTypeId(productTypeName);
        
        if (id != -1) {
            productType.setId(id);
            product.setType(productType);
        } else {
            product.setType(productType);
        }
        
        tryService.addProduct(product);
        
        tryService.getAllProducts();
        
        tryService.updateProduct((long) 5, new BigDecimal("1000"), "Active");
        
        tryService.getAllProducts();
        
        //tryService.deleteProduct((long) 4); //foreign key constraint violated
        tryService.updateProduct((long) 4, BigDecimal.ZERO, "Inactive");
        
        tryService.getAllProducts();*/
        
        return "WebStoreHomePage";
    }
}
