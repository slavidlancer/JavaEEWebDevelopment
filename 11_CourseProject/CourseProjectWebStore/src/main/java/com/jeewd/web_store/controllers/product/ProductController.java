package com.jeewd.web_store.controllers.product;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.jeewd.constants.UrlConstants;

@Controller
public class ProductController {
    @RequestMapping(value = UrlConstants.PRODUCT_REGISTRY_PAGE_URL,
            method = RequestMethod.GET)
    public String productRegistryPage() {
        return "ProductRegistry";
    }
    
    @RequestMapping(value = UrlConstants.PRODUCT_ADD_PAGE_URL,
            method = RequestMethod.GET)
    public String addProductPage() {
        return "AddEditProduct";
    }
    
    @RequestMapping(value = UrlConstants.PRODUCT_EDIT_PAGE_URL,
            method = RequestMethod.GET)
    public String editProductPage() {
        return "AddEditProduct";
    }
}
