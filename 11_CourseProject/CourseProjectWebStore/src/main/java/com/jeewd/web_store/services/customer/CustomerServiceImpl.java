package com.jeewd.web_store.services.customer;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jeewd.web_store.dao.customer.CustomerDao;
import com.jeewd.web_store.dto.customer.CustomerSearch;
import com.jeewd.web_store.entities.customer.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerDao customerDao;

    @Override
    public List<Customer> getAllCustomers() {
        return customerDao.getAllCustomers();
    }

    @Override
    public List<Customer> getCustomersBySearch(CustomerSearch customerSearch) {
        return customerDao.getCustomersBySearch(customerSearch);
    }

    @Override
    public boolean addCustomer(Customer customer) {
        return customerDao.addCustomer(customer);
    }

    @Override
    public boolean updateCustomer(Customer customer) {
        return customerDao.updateCustomer(customer);
    }

    @Override
    public boolean deleteCustomer(Customer customer) {
        return customerDao.deleteCustomer(customer);
    }
}
