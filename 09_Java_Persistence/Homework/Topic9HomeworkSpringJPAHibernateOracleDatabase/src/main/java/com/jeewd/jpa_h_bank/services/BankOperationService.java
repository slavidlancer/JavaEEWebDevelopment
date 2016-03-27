package com.jeewd.jpa_h_bank.services;

import java.math.BigDecimal;

import com.jeewd.jpa_h_bank.entities.BankAccount;
import com.jeewd.jpa_h_bank.security.User;

public interface BankOperationService {
    boolean deposit(BankAccount bankAccount, BigDecimal changeAmount, User user,
            String currency);
    boolean withdraw(BankAccount bankAccount, BigDecimal changeAmount,
            User user, String currency);
}
