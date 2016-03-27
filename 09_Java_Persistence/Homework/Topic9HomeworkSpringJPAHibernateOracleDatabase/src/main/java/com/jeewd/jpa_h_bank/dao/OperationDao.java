package com.jeewd.jpa_h_bank.dao;

import java.math.BigDecimal;

import com.jeewd.jpa_h_bank.entities.BankAccount;

public interface OperationDao {
    boolean performDeposit(BankAccount bankAccount, BigDecimal changeAmount);
    boolean performWithdraw(BankAccount bankAccount, BigDecimal changeAmount);
    boolean registerOperation(String accountNumber, String operation,
            BigDecimal amount, String currency, String performedBy);
}
