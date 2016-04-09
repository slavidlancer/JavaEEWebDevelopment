package com.jeewd.web_store.controllers.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.jeewd.constants.JspNameConstants;
import com.jeewd.constants.UrlConstants;
import com.jeewd.web_store.dto.customer.CustomerSearch;
import com.jeewd.web_store.dto.customer.CustomerTransfer;
import com.jeewd.web_store.services.customer.CustomerService;
import com.jeewd.web_store.utils.UserUtils;

@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    
    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    @RequestMapping(value = UrlConstants.CUSTOMER_REGISTRY_PAGE_URL,
            method = RequestMethod.GET)
    public String goToCustomerRegistryPage(Model model,
            @ModelAttribute("CustomerSearch") CustomerSearch customerSearch) {
        initializeAttributes(model);
        
        if (customerSearch != null) {
            model.addAttribute("customers",
                    customerService.getCustomersBySearch(customerSearch));
        } else {
            model.addAttribute("customers", customerService.getAllCustomers());
        }
        
        return JspNameConstants.CUSTOMER_REGISTRY_PAGE;
    }
    
    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    @RequestMapping(value = UrlConstants.CUSTOMER_ADD_PAGE_URL,
            method = RequestMethod.GET)
    public String goToAddCustomerPage(Model model) {
        initializeAttributes(model);
        
        return JspNameConstants.ADD_EDIT_CUSTOMER_PAGE;
    }
    
    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    @RequestMapping(value = UrlConstants.CUSTOMER_EDIT_PAGE_URL,
            method = RequestMethod.GET)
    public String goToEditCustomerPage(Model model,
            @ModelAttribute("CustomerTransfer") CustomerTransfer customerTransfer) {
        initializeAttributes(model);
        model.addAttribute("customer",
                customerService.getCustomerById(customerTransfer.getId()));
        
        return JspNameConstants.ADD_EDIT_CUSTOMER_PAGE;
    }
    
    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    @RequestMapping(value = UrlConstants.CUSTOMER_ADD_EDIT_URL,
            method = RequestMethod.GET)
    public String addEditCustomer(Model model,
            @ModelAttribute("CustomerTransfer")
    CustomerTransfer customerTransfer) {
        initializeAttributes(model);
        
        if (customerTransfer.getId() != null) {
            customerService.updateCustomer(customerTransfer);
        } else {
            customerService.addCustomer(customerTransfer);
        }
        
        return JspNameConstants.CUSTOMER_REGISTRY_PAGE;
    }
    
    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    @RequestMapping(value = UrlConstants.CUSTOMER_DELETE_URL,
            method = RequestMethod.GET)
    public String deleteCustomer(Model model,
            @ModelAttribute("CustomerTransfer")
    CustomerTransfer customerTransfer) {
        initializeAttributes(model);
        customerService.deleteCustomerById(customerTransfer.getId());
        model.addAttribute("customers",
                customerService.getCustomersBySearch(new CustomerSearch()));
        
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
        model.addAttribute("userPrincipal", UserUtils.getUser());
    }
}
