package com.jeewd.web_store.services.order;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jeewd.web_store.dao.order.OrderDao;
import com.jeewd.web_store.dto.order.OrderSearch;
import com.jeewd.web_store.dto.order.OrderTransfer;
import com.jeewd.web_store.entities.order.Order;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;

    @Override
    public List<Order> getAllOrders() {
        return orderDao.getAllOrders();
    }

    @Override
    public List<OrderSearch> getOrdersBySearch(OrderSearch orderSearch) {
        List<OrderSearch> ordersSearchResult = new ArrayList<>();
        orderDao.getOrdersBySearch(orderSearch);
        
        return ordersSearchResult;
    }

    @Override
    public Order getOrderById(Long id) {
        return orderDao.getOrderById(id);
    }

    @Override
    public boolean addOrder(OrderTransfer orderTransfer) {
        return orderDao.addOrder(orderTransfer);
    }

    @Override
    public boolean updateOrder(OrderTransfer orderTransfer) {
        return orderDao.updateOrder(orderTransfer);
    }

    @Override
    public boolean deleteOrderById(Long id) {
        return orderDao.deleteOrderById(id);
    }

    @Override
    public BigDecimal calculateOverallPurchasePrice(Order order) {
        return null;
    }
}
