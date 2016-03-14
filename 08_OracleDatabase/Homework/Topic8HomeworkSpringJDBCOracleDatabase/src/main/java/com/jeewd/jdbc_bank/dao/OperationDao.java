package com.jeewd.jdbc_bank.dao;

import java.math.BigDecimal;

public interface OperationDao {
    boolean registerOperation(String accountNumber, String operation,
            BigDecimal amount, String currency, String performedBy);
}
