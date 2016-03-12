package com.jeewd.secure_bank.services;

import java.math.BigDecimal;
import java.util.List;
import com.jeewd.secure_bank.entity.Account;

public interface WebBank {
    List<Account> getAccounts();
    
    boolean createAccount(Account account);
    
    BigDecimal deposit(String client, BigDecimal amount, String currency);
    
    BigDecimal withdraw(String client, BigDecimal amount, String currency);
}
