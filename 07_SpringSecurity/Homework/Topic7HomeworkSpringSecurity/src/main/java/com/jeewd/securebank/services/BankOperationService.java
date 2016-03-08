package com.jeewd.securebank.services;

import java.math.BigDecimal;
import com.jeewd.securebank.entity.BankAccount;

public interface BankOperationService {
    void deposit(BankAccount bankAccount, BigDecimal changeAmount);
    void withdraw(BankAccount bankAccount, BigDecimal changeAmount);
}
