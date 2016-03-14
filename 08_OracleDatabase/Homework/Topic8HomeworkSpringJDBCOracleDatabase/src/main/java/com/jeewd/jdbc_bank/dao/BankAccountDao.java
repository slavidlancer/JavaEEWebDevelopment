package com.jeewd.jdbc_bank.dao;

import java.util.Set;
import com.jeewd.jdbc_bank.entity.BankAccount;

public interface BankAccountDao {
    boolean addBankAccount(BankAccount bankAccount, String user);
    boolean containsBankAccount(BankAccount bankAccount);
    BankAccount getBankAccountNumberByUsername(String username, String number);
    Set<BankAccount> getAllBankAccounts();
}
