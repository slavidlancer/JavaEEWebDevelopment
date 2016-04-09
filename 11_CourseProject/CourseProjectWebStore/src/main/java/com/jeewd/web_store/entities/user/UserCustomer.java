package com.jeewd.web_store.entities.user;

import com.jeewd.web_store.entities.customer.Customer;

public class UserCustomer {
    private User user;
    private Customer customer;
    
    public User getUser() {
        return user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
    
    public Customer getCustomer() {
        return customer;
    }
    
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
