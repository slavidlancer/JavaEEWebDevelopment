package com.jeewd.jdbc_bank.services;

import java.util.Set;
import com.jeewd.jdbc_bank.entity.BankAccount;

public interface AccountService {
    boolean addAccount(BankAccount bankAccount, String user);
    BankAccount getAccountNumberByUsername(String username, String number);
    Set<BankAccount> getAllAccounts();
}
