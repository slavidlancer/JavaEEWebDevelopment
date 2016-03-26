package com.jeewd.jdbc_secure_bank.entity;

import java.math.BigDecimal;
import java.util.Date;

public class ExchangeRate {
    private String currency;
    private BigDecimal rate;
    private Date date;
    
    public String getCurrency() {
        return currency;
    }
    
    public void setCurrency(String currency) {
        this.currency = currency;
    }
    
    public BigDecimal getRate() {
        return rate;
    }
    
    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }
    
    public Date getDate() {
        return date;
    }
    
    public void setDate(Date date) {
        this.date = date;
    }
}
