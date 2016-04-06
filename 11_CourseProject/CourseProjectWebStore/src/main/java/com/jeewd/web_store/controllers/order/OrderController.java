package com.jeewd.web_store.controllers.order;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.jeewd.constants.JspNameConstants;
import com.jeewd.constants.UrlConstants;

@Controller
public class OrderController {
    //@Secured({"ROLE_USER", "ROLE_ADMIN"})
    @RequestMapping(value = UrlConstants.ORDER_REGISTRY_PAGE_URL,
            method = RequestMethod.GET)
    public String goToOrderRegistryPage(Model model) {
        initializeAttributes(model);
        
        return JspNameConstants.ORDER_REGISTRY_PAGE;
    }
    
    //@Secured("ROLE_ADMIN")
    @RequestMapping(value = UrlConstants.ORDER_ADD_PAGE_URL,
            method = RequestMethod.GET)
    public String goToAddOrderPage(Model model) {
        initializeAttributes(model);
        
        return JspNameConstants.ADD_EDIT_ORDER_PAGE;
    }
    
    //@Secured("ROLE_ADMIN")
    @RequestMapping(value = UrlConstants.ORDER_EDIT_PAGE_URL,
            method = RequestMethod.GET)
    public String goToEditOrderPage(Model model) {
        initializeAttributes(model);
        
        return JspNameConstants.ADD_EDIT_ORDER_PAGE;
    }
    
    //@Secured({"ROLE_USER", "ROLE_ADMIN"})
    @RequestMapping(value = UrlConstants.ORDER_DELETE_URL,
            method = RequestMethod.GET)
    public String deleteOrder(Model model) {
        initializeAttributes(model);
        
        return JspNameConstants.ORDER_REGISTRY_PAGE;
    }
    
    private static void initializeAttributes(Model model) {
        model.addAttribute("orderRegistryPageUrl",
                UrlConstants.ORDER_REGISTRY_PAGE_URL);
        model.addAttribute("addOrderPageUrl",
                UrlConstants.ORDER_ADD_PAGE_URL);
        model.addAttribute("editOrderPageUrl",
                UrlConstants.ORDER_EDIT_PAGE_URL);
        model.addAttribute("addEditOrderUrl",
                UrlConstants.ORDER_ADD_EDIT_URL);
        model.addAttribute("deleteOrderUrl",
                UrlConstants.ORDER_DELETE_URL);
        //model.addAttribute("user", UserUtils.getUser());
    }
}
