package com.jeewd.web_store.services.order;

import java.math.BigDecimal;
import java.util.List;
import com.jeewd.web_store.dto.order.OrderSearch;
import com.jeewd.web_store.dto.order.OrderTransfer;
import com.jeewd.web_store.entities.order.Order;

public interface OrderService {
    List<Order> getAllOrders();
    List<OrderSearch> getOrdersBySearch(OrderSearch orderSearch);
    Order getOrderById(Long id);
    boolean addOrder(OrderTransfer orderTransfer);
    boolean updateOrder(OrderTransfer orderTransfer);
    boolean deleteOrderById(Long id);
    BigDecimal calculateOverallPurchasePrice(Order order);
}
