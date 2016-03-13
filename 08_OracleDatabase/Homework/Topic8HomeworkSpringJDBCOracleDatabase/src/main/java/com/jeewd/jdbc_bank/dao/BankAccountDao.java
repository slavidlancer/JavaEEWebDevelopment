package com.jeewd.jdbc_bank.dao;

import java.util.List;
import com.jeewd.jdbc_bank.entity.BankAccount;

public interface BankAccountDao {
    List<BankAccount> getBankAccounts();
    boolean addBankAccount(BankAccount bankAccount);
}
