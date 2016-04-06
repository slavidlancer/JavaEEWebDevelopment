package com.jeewd.web_store.controllers.customer;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.jeewd.constants.JspNameConstants;
import com.jeewd.constants.UrlConstants;

@Controller
public class CustomerController {
    //@Secured({"ROLE_USER", "ROLE_ADMIN"})
    @RequestMapping(value = UrlConstants.CUSTOMER_REGISTRY_PAGE_URL,
            method = RequestMethod.GET)
    public String goToCustomerRegistryPage(Model model) {
        initializeAttributes(model);
        
        return JspNameConstants.CUSTOMER_REGISTRY_PAGE;
    }
    
    //@Secured({"ROLE_USER", "ROLE_ADMIN"})
    @RequestMapping(value = UrlConstants.CUSTOMER_ADD_PAGE_URL,
            method = RequestMethod.GET)
    public String goToAddCustomerPage(Model model) {
        initializeAttributes(model);
        
        return JspNameConstants.ADD_EDIT_CUSTOMER_PAGE;
    }
    
    //@Secured({"ROLE_USER", "ROLE_ADMIN"})
    @RequestMapping(value = UrlConstants.CUSTOMER_EDIT_PAGE_URL,
            method = RequestMethod.GET)
    public String goToEditCustomerPage(Model model) {
        initializeAttributes(model);
        
        return JspNameConstants.ADD_EDIT_CUSTOMER_PAGE;
    }
    
    //@Secured({"ROLE_USER", "ROLE_ADMIN"})
    @RequestMapping(value = UrlConstants.CUSTOMER_DELETE_URL,
            method = RequestMethod.GET)
    public String deleteCustomer(Model model) {
        initializeAttributes(model);
        
        return JspNameConstants.CUSTOMER_REGISTRY_PAGE;
    }
    
    private static void initializeAttributes(Model model) {
        model.addAttribute("customerRegistryPageUrl",
                UrlConstants.CUSTOMER_REGISTRY_PAGE_URL);
        model.addAttribute("addCustomerPageUrl",
                UrlConstants.CUSTOMER_ADD_PAGE_URL);
        model.addAttribute("editCustomerPageUrl",
                UrlConstants.CUSTOMER_EDIT_PAGE_URL);
        model.addAttribute("addEditCustomerUrl",
                UrlConstants.CUSTOMER_ADD_EDIT_URL);
        model.addAttribute("deleteCustomerUrl",
                UrlConstants.CUSTOMER_DELETE_URL);
        //model.addAttribute("user", UserUtils.getUser());
    }
}
