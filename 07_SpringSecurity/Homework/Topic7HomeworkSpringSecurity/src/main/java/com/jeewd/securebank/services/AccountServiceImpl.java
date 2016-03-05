package com.jeewd.securebank.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.springframework.stereotype.Service;
import com.jeewd.securebank.entity.BankAccount;
import com.jeewd.securebank.entity.CurrencyID;

@Service
public class AccountServiceImpl implements AccountService {
    private static final HashMap<String, List<BankAccount>> database =
            new HashMap<>();
    
    @Override
    public boolean addAccount(String username, String number, BigDecimal amount,
            CurrencyID currency) {
        ArrayList<BankAccount> bankAccounts = new ArrayList<>();
        bankAccounts.add(new BankAccount(username, number, amount, currency));
        database.put(username, bankAccounts);
        
        return true;
    }

    @Override
    public List<BankAccount> getAccounts(String username) {
        return database.get(username);
    }
}
