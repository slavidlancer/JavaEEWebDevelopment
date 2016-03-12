package com.jeewd.secure_bank.entity;

import java.math.BigDecimal;

public class Account {
    private BigDecimal amount;
    private String currency;
    
    public BigDecimal getAmount() {
        return amount;
    }
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
    public String getCurrency() {
        return currency;
    }
    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
