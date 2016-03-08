package com.jeewd.securebank.services;

import java.util.Set;

import com.jeewd.securebank.entity.BankAccount;

public interface AccountService {
    boolean addAccount(BankAccount bankAccount, String user);
    BankAccount getAccountNumberByUsername(String username, String number);
    Set<BankAccount> getAllAccounts();
}
