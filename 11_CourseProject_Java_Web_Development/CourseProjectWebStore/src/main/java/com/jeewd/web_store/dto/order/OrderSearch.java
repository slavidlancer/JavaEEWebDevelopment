package com.jeewd.web_store.dto.order;

import java.math.BigDecimal;

public class OrderSearch {
    private Long id;
    private Integer quantity;
    private BigDecimal overallPrice;
    private String products;
    private String customerName;
    private String purchaseDate;
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getOverallPrice() {
        return overallPrice;
    }

    public void setOverallPrice(BigDecimal overallPrice) {
        this.overallPrice = overallPrice;
    }
    
    public String getProducts() {
        return products;
    }
    
    public void setProducts(String products) {
        this.products = products;
    }
    
    public String getCustomerName() {
        return customerName;
    }
    
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    
    public String getPurchaseDate() {
        return purchaseDate;
    }
    
    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }
}
