package com.jeewd.web_store.services.customer;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jeewd.web_store.dao.customer.CustomerDao;
import com.jeewd.web_store.dto.customer.CustomerSearch;
import com.jeewd.web_store.dto.customer.CustomerTransfer;
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
    public List<CustomerSearch> getCustomersBySearch(
            CustomerSearch customerSearch) {
        List<CustomerSearch> customersSearchResult = new ArrayList<>();
        customerDao.getCustomersBySearch(customerSearch);
        
        return customersSearchResult;
    }

    @Override
    public Customer getCustomerById(Long id) {
        return customerDao.getCustomerById(id);
    }

    @Override
    public boolean addCustomer(CustomerTransfer customerTransfer) {
        return customerDao.addCustomer(customerTransfer);
    }

    @Override
    public boolean updateCustomer(CustomerTransfer customerTransfer) {
        return customerDao.updateCustomer(customerTransfer);
    }

    @Override
    public boolean deleteCustomerById(Long id) {
        return customerDao.deleteCustomerById(id);
    }
}
