package com.jeewd.web_store.entities.order;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.jeewd.web_store.entities.customer.Customer;

@Entity
@Table(name = "ORDERS")
public class Order {
    @Id
    @Column(name = "ID")
    private Long id;
    @Column(name = "OVERALL_PRICE")
    private BigDecimal overallPrice;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CUSTOMER")
    private Customer customer;
    @Column(name = "PURCHASE_DATE")
    private Date purchaseDate;
    @Column(name = "STATUS")
    private String status;
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public BigDecimal getOverallPrice() {
        return overallPrice;
    }
    
    public void setOverallPrice(BigDecimal overallPrice) {
        this.overallPrice = overallPrice;
    }
    
    public Customer getCustomer() {
        return customer;
    }
    
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    
    public Date getPurchaseDate() {
        return purchaseDate;
    }
    
    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
}
