package com.jeewd.web_store.services.order;

import java.util.List;
import com.jeewd.web_store.dto.order.OrderSearch;
import com.jeewd.web_store.entities.order.Order;
import com.sun.management.OperatingSystemMXBean;

public interface OrderService {
    List<Order> getAllOrders();
    List<Order> getOrdersBySearch(OrderSearch orderSearch);
    Order getOrderById(Long id);
    boolean addOrder(Order order);
    boolean updateOrder(Order order);
    boolean deleteOrderById(Long id);
}
