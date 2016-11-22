package com.jeewd.web_store.services.order;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jeewd.web_store.dao.order.OrderDao;
import com.jeewd.web_store.dto.order.OrderSearch;
import com.jeewd.web_store.dto.order.OrderTransfer;
import com.jeewd.web_store.entities.order.Order;
import com.jeewd.web_store.entities.order.ProductList;

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
        
        if (orderDao.getOrdersBySearch(orderSearch) != null) {
            for (Order order :
                orderDao.getOrdersBySearch(orderSearch)) {
                StringBuilder products = new StringBuilder();
                int countOfProducts = 0;
                Integer tempQuantity = 0;
                BigDecimal tempPrice = BigDecimal.ZERO.setScale(2);
                OrderSearch orderSearchResult = new OrderSearch();
                orderSearchResult.setId(order.getId());
                orderSearchResult.setCustomerName(order.getCustomer().
                        getName());
                
                if (order.getProductList() != null) {
                    for (ProductList productList : order.getProductList()) {
                        if (countOfProducts > 0) {
                            products.append(", ");
                        }
                        
                        tempQuantity += productList.getQuantity();
                        /*tempPrice.add(productList.getProduct().getPrice().
                                multiply(new BigDecimal(tempQuantity)));*/
                        
                        products.append("[" +
                                productList.getProduct().getName() + " : " +
                                productList.getProduct().getType().getName() +
                                "]");
                        countOfProducts++;
                    }
                }
                
                orderSearchResult.setProducts(products.toString());
                orderSearchResult.setQuantity(tempQuantity);
                orderSearchResult.setOverallPrice(tempPrice);
                orderSearchResult.setPurchaseDate(
                        new SimpleDateFormat("YYYY-MM-dd").format(
                                order.getPurchaseDate()).toString());
                
                ordersSearchResult.add(orderSearchResult);
            }
        }
        
        return ordersSearchResult != null ? ordersSearchResult : null;
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
