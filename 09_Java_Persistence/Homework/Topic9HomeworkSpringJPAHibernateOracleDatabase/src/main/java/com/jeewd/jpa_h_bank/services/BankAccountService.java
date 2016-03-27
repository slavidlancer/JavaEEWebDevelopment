package com.jeewd.jpa_h_bank.services;

import java.util.Set;

import com.jeewd.jpa_h_bank.entities.BankAccount;

public interface BankAccountService {
    boolean addBankAccount(BankAccount bankAccount, String user);
    BankAccount getBankAccountNumberByUsername(String username, String number);
    Set<BankAccount> getAllBankAccounts();
}
