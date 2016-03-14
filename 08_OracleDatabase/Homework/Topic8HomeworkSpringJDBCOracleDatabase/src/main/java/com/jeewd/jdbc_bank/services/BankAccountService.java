package com.jeewd.jdbc_bank.services;

import java.util.Set;
import com.jeewd.jdbc_bank.entity.BankAccount;

public interface BankAccountService {
    boolean addBankAccount(BankAccount bankAccount, String user);
    BankAccount getBankAccountNumberByUsername(String username, String number);
    Set<BankAccount> getAllBankAccounts();
}
