package com.jeewd.web_store.dto.customer;

import java.util.Date;

public class CustomerTransfer {
    private Long id;
    private String name;
    private String pid;
    private Date dateOfBirth;
    private String address;
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getPid() {
        return pid;
    }
    
    public void setPid(String pid) {
        this.pid = pid;
    }
    
    public Date getDateOfBirth() {
        return dateOfBirth;
    }
    
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
}
