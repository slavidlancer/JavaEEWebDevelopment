package com.jeewd.bank.services;

import java.math.BigDecimal;

public interface BankOperation {
    BigDecimal deposit(String clientName, BigDecimal currentAmount,
            BigDecimal changeAmount);
    BigDecimal withdraw(String clientName, BigDecimal currentAmount,
            BigDecimal changeAmount);
}
