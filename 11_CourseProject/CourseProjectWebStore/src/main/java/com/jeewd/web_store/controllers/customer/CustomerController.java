package com.jeewd.web_store.controllers.customer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.jeewd.constants.UrlConstants;

@Controller
public class CustomerController {
    @RequestMapping(value = UrlConstants.CUSTOMER_REGISTRY_PAGE_URL,
            method = RequestMethod.GET)
    public String customerRegistryPage() {
        return "CustomerRegistry";
    }
    
    @RequestMapping(value = UrlConstants.CUSTOMER_ADD_EDIT_PAGE_URL,
            method = RequestMethod.GET)
    public String addEditCustomerPage() {
        return "AddEditCustomer";
    }
}
