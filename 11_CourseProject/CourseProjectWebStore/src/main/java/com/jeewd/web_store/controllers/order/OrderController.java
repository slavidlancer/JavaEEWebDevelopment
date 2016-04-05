package com.jeewd.web_store.controllers.order;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.jeewd.constants.UrlConstants;

@Controller
public class OrderController {
    @RequestMapping(value = UrlConstants.ORDER_REGISTRY_PAGE_URL,
            method = RequestMethod.GET)
    public String orderRegistryPage() {
        return "OrderRegistry";
    }
    
    @RequestMapping(value = UrlConstants.ORDER_ADD_PAGE_URL,
            method = RequestMethod.GET)
    public String addOrderPage() {
        return "AddEditOrder";
    }
    
    @RequestMapping(value = UrlConstants.ORDER_EDIT_PAGE_URL,
            method = RequestMethod.GET)
    public String editOrderPage() {
        return "AddEditOrder";
    }
}
