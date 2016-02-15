package com.jeewd.model;

import java.math.BigDecimal;

public class Account {
    private BigDecimal currentAmount;
    private String currency;
    
    public Account(BigDecimal currentAmount, String currency) {
        this.currentAmount = currentAmount;
        this.currency = currency;
    }

    public BigDecimal getCurrentAmount() {
        return currentAmount;
    }

    public void setCurrentAmount(BigDecimal currentAmount) {
        this.currentAmount = currentAmount;
    }
    
    public String getCurrency() {
        return this.currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
