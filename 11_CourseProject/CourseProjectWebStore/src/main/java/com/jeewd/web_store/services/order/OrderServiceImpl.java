package com.jeewd.web_store.services.order;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jeewd.web_store.dao.order.OrderDao;
import com.jeewd.web_store.dto.order.OrderSearch;
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
    public List<Order> getOrdersBySearch(OrderSearch orderSearch) {
        return orderDao.getOrdersBySearch(orderSearch);
    }

    @Override
    public boolean addOrder(Order order) {
        return orderDao.addOrder(order);
    }

    @Override
    public boolean updateOrder(Order order) {
        return orderDao.updateOrder(order);
    }

    @Override
    public boolean deleteOrder(Order order) {
        return orderDao.deleteOrder(order);
    }
}
