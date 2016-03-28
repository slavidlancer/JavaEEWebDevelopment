package com.jeewd.jpa_h_bank.entities;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
//import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "OPERATIONS")
public class Operation {
    @Id
    @Column(name = "ID")
    private Long id;
    //@ManyToOne
    @Column(name = "ACCOUNT_NUMBER")
    private String accountNumber;
    @Column(name = "OPERATION")
    private String operation;
    @Column(name = "AMOUNT")
    private BigDecimal amount;
    @Column(name = "CURRENCY")
    private String currency;
    //@ManyToOne
    @Column(name = "PERFORMED_BY")
    private String performedBy;
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getAccountNumber() {
        return accountNumber;
    }
    
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
    
    public String getOperation() {
        return operation;
    }
    
    public void setOperation(String operation) {
        this.operation = operation;
    }
    
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
    
    public String getPerformedBy() {
        return performedBy;
    }
    
    public void setPerformedBy(String performedBy) {
        this.performedBy = performedBy;
    }
}
