package com.jeewd.securebank.entity;

import java.math.BigDecimal;

public class BankAccount {
    private String username;
    private String number;
    private BigDecimal amount;
    private CurrencyID currency;
    private String createdBy;
    
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getNumber() {
        return number;
    }
    
    public void setNumber(String number) {
        this.number = number;
    }
    
    public BigDecimal getAmount() {
        return amount;
    }
    
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
    
    public CurrencyID getCurrency() {
        return currency;
    }
    
    public void setCurrency(CurrencyID currency) {
        this.currency = currency;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
}
