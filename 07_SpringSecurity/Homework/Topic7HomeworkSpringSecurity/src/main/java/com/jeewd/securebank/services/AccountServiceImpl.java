package com.jeewd.securebank.services;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import org.springframework.stereotype.Service;
import com.jeewd.securebank.entity.BankAccount;

@Service
public class AccountServiceImpl implements AccountService {
    private static HashMap<String, Set<BankAccount>> database =
            new HashMap<>();
    private static Set<BankAccount> bankAccounts = new HashSet<>();
    
    @Override
    public boolean addAccount(BankAccount bankAccount, String user) {
        bankAccount.setCreatedBy(user);
        
        if (!bankAccounts.contains(bankAccount)) {
            bankAccounts.add(bankAccount);
            database.put(bankAccount.getUsername(), bankAccounts);
        }
        
        return true;
    }

    @Override
    public Set<BankAccount> getAllAccounts() {
        return bankAccounts;
    }
}
