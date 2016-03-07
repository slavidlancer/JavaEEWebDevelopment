package com.jeewd.securebank.services;

import java.math.BigDecimal;
import com.jeewd.securebank.entity.BankAccount;

public interface BankOperationService {
    BigDecimal deposit(BankAccount bankAccount, BigDecimal changeAmount);
    BigDecimal withdraw(BankAccount bankAccount, BigDecimal changeAmount);
}
