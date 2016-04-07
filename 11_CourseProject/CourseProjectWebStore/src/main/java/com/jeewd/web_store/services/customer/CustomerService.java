package com.jeewd.web_store.services.customer;

import java.util.List;
import com.jeewd.web_store.dto.customer.CustomerSearch;
import com.jeewd.web_store.entities.customer.Customer;

public interface CustomerService {
    List<Customer> getAllCustomers();
    List<Customer> getCustomersBySearch(CustomerSearch customerSearch);
    Customer getCustomerById(Long id);
    boolean addCustomer(Customer customer);
    boolean updateCustomer(Customer customer);
    boolean deleteCustomerById(Long id);
}
