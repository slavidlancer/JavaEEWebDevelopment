package com.jeewd.web_store.services.customer;

import java.text.SimpleDateFormat;
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
        
        if (customerDao.getCustomersBySearch(customerSearch) != null) {
            for (Customer customer :
                customerDao.getCustomersBySearch(customerSearch)) {
                CustomerSearch customerSearchResult = new CustomerSearch();
                customerSearchResult.setId(customer.getId());
                customerSearchResult.setName(customer.getName());
                customerSearchResult.setPid(customer.getpID());
                customerSearchResult.setDateOfBirth(
                        new SimpleDateFormat("YYYY-MM-dd").format(
                                customer.getDateOfBirth()).toString());
                customerSearchResult.setAddress(customer.getAddress());
                
                customersSearchResult.add(customerSearchResult);
            }
        }
        
        return customersSearchResult != null ? customersSearchResult : null;
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
