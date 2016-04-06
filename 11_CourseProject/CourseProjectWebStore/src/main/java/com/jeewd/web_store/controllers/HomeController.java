package com.jeewd.web_store.controllers;

//import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.jeewd.constants.JspNameConstants;
import com.jeewd.constants.UrlConstants;

//http://localhost:8080/web_store
@Controller
public class HomeController {
    //@Secured({"ROLE_USER", "ROLE_ADMIN"})
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String goToHomePage(Model model) {
        initializeAttributes(model);
        
        return JspNameConstants.HOME_PAGE;
    }
    
    private static void initializeAttributes(Model model) {
        model.addAttribute("productRegistryPageUrl",
                UrlConstants.PRODUCT_REGISTRY_PAGE_URL);
        model.addAttribute("customerRegistryPageUrl",
                UrlConstants.CUSTOMER_REGISTRY_PAGE_URL);
        model.addAttribute("orderRegistryPageUrl",
                UrlConstants.ORDER_REGISTRY_PAGE_URL);
        model.addAttribute("userRegistryPageUrl",
                UrlConstants.USER_REGISTRY_PAGE_URL);
        //model.addAttribute("user", UserUtils.getUser());
    }
}
