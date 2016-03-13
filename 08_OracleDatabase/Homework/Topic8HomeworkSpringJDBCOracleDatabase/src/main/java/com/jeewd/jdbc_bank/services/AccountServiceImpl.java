package com.jeewd.jdbc_bank.services;

import java.util.HashSet;
import java.util.Set;
import org.springframework.stereotype.Service;
import com.jeewd.jdbc_bank.entity.BankAccount;

@Service
public class AccountServiceImpl implements AccountService {
    private static Set<BankAccount> bankAccounts = new HashSet<>();
    
    @Override
    public boolean addAccount(BankAccount bankAccount, String user) {
        bankAccount.setCreatedBy(user);
        
        if (!bankAccounts.contains(bankAccount)) {
            bankAccounts.add(bankAccount);
        }
        
        return true;
    }

    @Override
    public BankAccount getAccountNumberByUsername(String username,
            String number) {
        for (BankAccount bankAccount : bankAccounts) {
            if (username.equals(bankAccount.getUsername())) {
                if (number.equals(bankAccount.getNumber())) {
                    return bankAccount;
                }
            }
        }
        
        return null;
    }
    
    @Override
    public Set<BankAccount> getAllAccounts() {
        return bankAccounts;
    }
}
