package com.jeewd.jpa_h_bank.entities;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
//import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ACCOUNTS")
public class BankAccount {
    @Id
    @Column(name = "ID")
    private Long id;
    //@ManyToOne
    @Column(name = "USERNAME")
    private String username;
    @Column(name = "ACCOUNT_NUMBER")
    private String number;
    @Column(name = "AMOUNT")
    private BigDecimal amount;
    @Column(name = "CURRENCY")
    private CurrencyID currency;
    //@ManyToOne
    @Column(name = "CREATED_BY")
    private String createdBy;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
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
        if (amount == null) {
            amount = new BigDecimal(0).setScale(2);
        }
        
        if (new BigDecimal(0).compareTo(amount) <= 0) {
            this.amount = amount.setScale(2);
        } else {
            this.amount = new BigDecimal(0).setScale(2);
        }
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
    
    @Override
    public int hashCode() {
        return this.username.hashCode() + this.number.hashCode();
    }

    @Override
    public boolean equals(Object otherBankAccount) {
        if (otherBankAccount == null) {
            return false;
        }
        
        if (!BankAccount.class.isAssignableFrom(otherBankAccount.getClass())) {
            return false;
        }
        
        final BankAccount other = (BankAccount) otherBankAccount;
        
        if (this.username.equals(other.username)) {
            if (this.number.equals(other.number)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
