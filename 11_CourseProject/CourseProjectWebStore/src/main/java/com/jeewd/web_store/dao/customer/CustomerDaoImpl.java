package com.jeewd.web_store.dao.customer;

import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.jeewd.web_store.dto.customer.CustomerSearch;
import com.jeewd.web_store.entities.customer.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Customer> getAllCustomers() {
        return null;
    }

    @Override
    public List<Customer> getCustomersBySearch(CustomerSearch customerSearch) {
        return null;
    }

    @Override
    public Customer getCustomerById(Long id) {
        return null;
    }

    @Override
    public boolean addCustomer(Customer customer) {
        return false;
    }

    @Override
    public boolean updateCustomer(Customer customer) {
        return false;
    }

    @Override
    public boolean deleteCustomerById(Long id) {
        return false;
    }
}
