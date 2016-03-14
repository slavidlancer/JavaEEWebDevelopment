package com.jeewd.jdbc_bank.dao;

import java.util.Set;
import com.jeewd.jdbc_bank.entity.BankAccount;

public interface BankAccountDao {
    Set<BankAccount> getBankAccounts();
    boolean addBankAccount(BankAccount bankAccount);
}
