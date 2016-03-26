package com.jeewd.jdbc_secure_bank.services;

import java.math.BigDecimal;
import java.util.List;

import com.jeewd.jdbc_secure_bank.entity.Account;

public interface WebBank {
    List<Account> getAccounts();
    
    boolean createAccount(Account account);
    
    BigDecimal deposit(String client, BigDecimal amount, String currency);
    
    BigDecimal withdraw(String client, BigDecimal amount, String currency);
}
