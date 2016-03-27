package com.jeewd.jpa_h_bank.dao;

import java.util.Set;

import com.jeewd.jpa_h_bank.entities.BankAccount;

public interface BankAccountDao {
    boolean addBankAccount(BankAccount bankAccount);
    boolean containsBankAccount(BankAccount bankAccount);
    BankAccount getBankAccountNumberByUsername(String username, String number);
    Set<BankAccount> getAllBankAccounts();
}
