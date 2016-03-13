package com.jeewd.jdbc_bank.services;

import java.math.BigDecimal;
import com.jeewd.jdbc_bank.entity.BankAccount;

public interface BankOperationService {
    void deposit(BankAccount bankAccount, BigDecimal changeAmount);
    void withdraw(BankAccount bankAccount, BigDecimal changeAmount);
}
