package com.jeewd.web_store.dao.order;

import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.jeewd.web_store.dto.order.OrderSearch;
import com.jeewd.web_store.dto.order.OrderTransfer;
import com.jeewd.web_store.entities.order.Order;

@Repository
public class OrderDaoImpl implements OrderDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Order> getAllOrders() {
        return null;
    }

    @Override
    public List<Order> getOrdersBySearch(OrderSearch orderSearch) {
        return null;
    }

    @Override
    public Order getOrderById(Long id) {
        return null;
    }

    @Override
    public boolean addOrder(OrderTransfer orderTransfer) {
        return false;
    }

    @Override
    public boolean updateOrder(OrderTransfer orderTransfer) {
        return false;
    }

    @Override
    public boolean deleteOrderById(Long id) {
        return false;
    }
}
