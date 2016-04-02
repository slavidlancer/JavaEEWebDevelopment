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
    
    @RequestMapping(value = UrlConstants.ORDER_ADD_EDIT_PAGE_URL,
            method = RequestMethod.GET)
    public String addEditOrderPage() {
        return "AddEditOrder";
    }
}
