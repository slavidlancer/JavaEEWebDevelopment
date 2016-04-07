package com.jeewd.web_store.controllers.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.jeewd.constants.JspNameConstants;
import com.jeewd.constants.UrlConstants;
import com.jeewd.web_store.dto.product.ProductSearch;
import com.jeewd.web_store.dto.product.ProductTransfer;
import com.jeewd.web_store.services.product.ProductService;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;
    
    //@Secured({"ROLE_USER", "ROLE_ADMIN"})
    @RequestMapping(value = UrlConstants.PRODUCT_REGISTRY_PAGE_URL,
            method = RequestMethod.GET)
    public String goToProductRegistryPage(Model model,
            @ModelAttribute("ProductSearch") ProductSearch productSearch) {
        initializeAttributes(model);
        
        if (productSearch != null) {
            model.addAttribute("products",
                    productService.getProductsBySearch(productSearch));
        } else {
            model.addAttribute("products", productService.getAllProducts());
        }
        
        return JspNameConstants.PRODUCT_REGISTRY_PAGE;
    }
    
    //@Secured("ROLE_ADMIN")
    @RequestMapping(value = UrlConstants.PRODUCT_ADD_PAGE_URL,
            method = RequestMethod.GET)
    public String goToAddProductPage(Model model) {
        initializeAttributes(model);
        
        return JspNameConstants.ADD_EDIT_PRODUCT_PAGE;
    }
    
    //@Secured("ROLE_ADMIN")
    @RequestMapping(value = UrlConstants.PRODUCT_EDIT_PAGE_URL,
            method = RequestMethod.GET)
    public String goToEditProductPage(Model model,
            @ModelAttribute("Product") ProductTransfer productTransfer) {
        initializeAttributes(model);
        model.addAttribute("customer",
                productService.getProductById(productTransfer.getId()));
        
        return JspNameConstants.ADD_EDIT_PRODUCT_PAGE;
    }
    
    //@Secured("ROLE_ADMIN")
    @RequestMapping(value = UrlConstants.PRODUCT_ADD_EDIT_URL,
            method = RequestMethod.GET)
    public String addEditOrder(Model model,
            @ModelAttribute("Product") ProductTransfer productTransfer) {
        initializeAttributes(model);
        
        if (productTransfer.getId() != null) {
            productService.updateProduct(productTransfer);
        } else {
            productService.addProduct(productTransfer);
        }
        
        return JspNameConstants.PRODUCT_REGISTRY_PAGE;
    }
    
    //@Secured("ROLE_ADMIN")
    @RequestMapping(value = UrlConstants.PRODUCT_DELETE_URL,
            method = RequestMethod.GET)
    public String deleteProduct(Model model,
            @ModelAttribute("Product") ProductTransfer productTransfer) {
        initializeAttributes(model);
        productService.deleteProductById(productTransfer.getId());
        
        return JspNameConstants.PRODUCT_REGISTRY_PAGE;
    }
    
    private static void initializeAttributes(Model model) {
        model.addAttribute("productRegistryPageUrl",
                UrlConstants.PRODUCT_REGISTRY_PAGE_URL);
        model.addAttribute("addProductPageUrl",
                UrlConstants.PRODUCT_ADD_PAGE_URL);
        model.addAttribute("editProductPageUrl",
                UrlConstants.PRODUCT_EDIT_PAGE_URL);
        model.addAttribute("addEditProductUrl",
                UrlConstants.PRODUCT_ADD_EDIT_URL);
        model.addAttribute("deleteProductUrl",
                UrlConstants.PRODUCT_DELETE_URL);
        //model.addAttribute("user", UserUtils.getUser());
    }
}
