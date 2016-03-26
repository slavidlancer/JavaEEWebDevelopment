package com.jeewd.jdbc_bank.dao;

import java.math.BigDecimal;
import com.jeewd.jdbc_bank.entities.BankAccount;

public interface OperationDao {
    boolean performDeposit(BankAccount bankAccount, BigDecimal changeAmount);
    boolean performWithdraw(BankAccount bankAccount, BigDecimal changeAmount);
    boolean registerOperation(String accountNumber, String operation,
            BigDecimal amount, String currency, String performedBy);
}
