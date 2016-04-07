package com.jeewd.web_store.dao.order;

import java.util.List;
import com.jeewd.web_store.dto.order.OrderSearch;
import com.jeewd.web_store.entities.order.Order;

public interface OrderDao {
    List<Order> getAllOrders();
    List<Order> getOrdersBySearch(OrderSearch orderSearch);
    boolean addOrder(Order order);
    boolean updateOrder(Order order);
    boolean deleteOrder(Order order);
}
