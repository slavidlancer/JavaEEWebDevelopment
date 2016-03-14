package com.jeewd.jdbc_bank.dao;

public interface OperationDao {
    boolean registerOperation(String accountNumber, String operation,
            String amount, String currency, String performedBy);
}
