package com.jeewd.securebank.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.springframework.stereotype.Service;
import com.jeewd.securebank.entity.BankAccount;

@Service
public class AccountServiceImpl implements AccountService {
    private static HashMap<String, List<BankAccount>> database =
            new HashMap<>();
    private static List<BankAccount> bankAccounts =
            new ArrayList<>();
    
    @Override
    public boolean addAccount(BankAccount bankAccount, String user) {
        bankAccount.setCreatedBy(user);
        bankAccounts.add(bankAccount);
        database.put(bankAccount.getUsername(), bankAccounts);
        
        return true;
    }

    @Override
    public List<BankAccount> getAllAccounts() {
        return bankAccounts;
    }
}
