package com.jeewd.ejbs;

import java.math.BigDecimal;

public class Account {
    private BigDecimal currentAmount;
    
    public Account(BigDecimal currentAmount) {
        this.currentAmount = currentAmount;
    }

    public BigDecimal getCurrentAmount() {
        return currentAmount;
    }

    public void setCurrentAmount(BigDecimal currentAmount) {
        this.currentAmount = currentAmount;
    }
}
