package com.jeewd.web_store.controllers.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.jeewd.constants.JspNameConstants;
import com.jeewd.constants.UrlConstants;
import com.jeewd.web_store.dto.order.OrderSearch;
import com.jeewd.web_store.dto.order.OrderTransfer;
import com.jeewd.web_store.services.order.OrderService;
import com.jeewd.web_store.utils.UserUtils;

@Controller
public class OrderController {
    @Autowired
    private OrderService orderService;
    
    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    @RequestMapping(value = UrlConstants.ORDER_REGISTRY_PAGE_URL,
            method = RequestMethod.GET)
    public String goToOrderRegistryPage(Model model,
            @ModelAttribute("OrderSearch") OrderSearch orderSearch) {
        initializeAttributes(model);
        
        if (orderSearch != null) {
            model.addAttribute("orders",
                    orderService.getOrdersBySearch(orderSearch));
        } else {
            model.addAttribute("orders", orderService.getAllOrders());
        }
        
        return JspNameConstants.ORDER_REGISTRY_PAGE;
    }
    
    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    @RequestMapping(value = UrlConstants.ORDER_ADD_PAGE_URL,
            method = RequestMethod.GET)
    public String goToAddOrderPage(Model model) {
        initializeAttributes(model);
        
        return JspNameConstants.ADD_EDIT_ORDER_PAGE;
    }
    
    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    @RequestMapping(value = UrlConstants.ORDER_EDIT_PAGE_URL,
            method = RequestMethod.POST)
    public String goToEditOrderPage(Model model,
            @ModelAttribute("OrderTransfer") OrderTransfer orderTransfer) {
        initializeAttributes(model);
        model.addAttribute("order",
                orderService.getOrderById(orderTransfer.getId()));
        
        return JspNameConstants.ADD_EDIT_ORDER_PAGE;
    }
    
    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    @RequestMapping(value = UrlConstants.ORDER_ADD_EDIT_URL,
            method = RequestMethod.POST)
    public String addEditOrder(Model model,
            @ModelAttribute("OrderTransfer") OrderTransfer orderTransfer) {
        initializeAttributes(model);
        
        if (orderTransfer.getId() != null) {
            orderService.updateOrder(orderTransfer);
        } else {
            orderService.addOrder(orderTransfer);
        }
        
        model.addAttribute("orders",
                orderService.getOrdersBySearch(new OrderSearch()));
        
        return JspNameConstants.ORDER_REGISTRY_PAGE;
    }
    
    @Secured("ROLE_ADMIN")
    @RequestMapping(value = UrlConstants.ORDER_DELETE_URL,
            method = RequestMethod.POST)
    public String deleteOrder(Model model,
            @ModelAttribute("OrderTransfer") OrderTransfer orderTransfer) {
        initializeAttributes(model);
        orderService.deleteOrderById(orderTransfer.getId());
        model.addAttribute("orders",
                orderService.getOrdersBySearch(new OrderSearch()));
        
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
        model.addAttribute("userPrincipal", UserUtils.getUser());
    }
}
