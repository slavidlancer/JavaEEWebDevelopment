package com.jeewd.web_store.controllers.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
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
import com.jeewd.web_store.utils.UserUtils;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;
    
    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    @RequestMapping(value = UrlConstants.PRODUCT_REGISTRY_PAGE_URL,
            method = RequestMethod.GET)
    public String goToProductRegistryPage(Model model,
            @ModelAttribute("ProductSearch") ProductSearch productSearch) {
        initializeAttributes(model);
        
        model.addAttribute("products",
                productService.getProductsBySearch(productSearch));
        
        return JspNameConstants.PRODUCT_REGISTRY_PAGE;
    }
    
    @Secured("ROLE_ADMIN")
    @RequestMapping(value = UrlConstants.PRODUCT_ADD_PAGE_URL,
            method = RequestMethod.GET)
    public String goToAddProductPage(Model model,
            @ModelAttribute("ProductTransfer")
    ProductTransfer productTransfer) {
        initializeAttributes(model);
        System.out.println("add_page");
        System.out.println("id:" + productTransfer.getId());
        System.out.println("name:" + productTransfer.getName());
        System.out.println("price:" + productTransfer.getPrice());
        System.out.println("type:" + productTransfer.getType());
        System.out.println("quantity:" + productTransfer.getQuantity());
        
        return JspNameConstants.ADD_EDIT_PRODUCT_PAGE;
    }
    
    @Secured("ROLE_ADMIN")
    @RequestMapping(value = UrlConstants.PRODUCT_EDIT_PAGE_URL,
            method = RequestMethod.POST)
    public String goToEditProductPage(Model model,
            @ModelAttribute("ProductTransfer")
    ProductTransfer productTransfer) {
        initializeAttributes(model);
        System.out.println("edit_page");
        System.out.println("id:" + productTransfer.getId());
        System.out.println("name:" + productTransfer.getName());
        System.out.println("price:" + productTransfer.getPrice());
        System.out.println("type:" + productTransfer.getType());
        System.out.println("quantity:" + productTransfer.getQuantity());
        model.addAttribute("ProductTransfer",
                productService.getProductById(
                        Long.valueOf(productTransfer.getId())));
        
        return JspNameConstants.ADD_EDIT_PRODUCT_PAGE;
    }
    
    @Secured("ROLE_ADMIN")
    @RequestMapping(value = UrlConstants.PRODUCT_ADD_EDIT_URL,
            method = RequestMethod.POST)
    public String addEditOrder(Model model,
            @ModelAttribute("ProductTransfer")
    ProductTransfer productTransfer) {
        initializeAttributes(model);
        
        System.out.println("add_edit_url");
        System.out.println("id:" + productTransfer.getId());
        System.out.println("name:" + productTransfer.getName());
        System.out.println("price:" + productTransfer.getPrice());
        System.out.println("type:" + productTransfer.getType());
        System.out.println("quantity:" + productTransfer.getQuantity());
        
        if (productTransfer.getId() == null) {
            //productTransfer.setId("");
            productService.addProduct(productTransfer);
            System.out.println("add");
        } else {
            productService.updateProduct(productTransfer);
            System.out.println("update");
        }
        
        return JspNameConstants.PRODUCT_REGISTRY_PAGE;
    }
    
    @Secured("ROLE_ADMIN")
    @RequestMapping(value = UrlConstants.PRODUCT_DELETE_URL,
            method = RequestMethod.POST)
    public String deleteProduct(Model model,
            @ModelAttribute("Product") ProductTransfer productTransfer) {
        initializeAttributes(model);
        productService.deleteProductById(Long.valueOf(productTransfer.getId()));
        model.addAttribute("products",
                productService.getProductsBySearch(new ProductSearch()));
        
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
        model.addAttribute("userPrincipal", UserUtils.getUser());
    }
}
