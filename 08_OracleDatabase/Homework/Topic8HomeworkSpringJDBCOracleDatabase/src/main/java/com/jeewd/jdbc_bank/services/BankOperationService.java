package com.jeewd.jdbc_bank.services;

import java.math.BigDecimal;
import com.jeewd.jdbc_bank.entities.BankAccount;
import com.jeewd.jdbc_bank.security.User;

public interface BankOperationService {
    boolean deposit(BankAccount bankAccount, BigDecimal changeAmount, User user,
            String currency);
    boolean withdraw(BankAccount bankAccount, BigDecimal changeAmount,
            User user, String currency);
}
