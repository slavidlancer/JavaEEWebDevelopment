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
        boolean toFill = true;
        bankAccount.setCreatedBy(user);
        
        /*if (!bankAccounts.isEmpty()) {
            System.out.println("not empty");
            for (BankAccount bankAccountItem : bankAccounts) {
                System.out.println("for-each");
                if (!bankAccountItem.getUsername().equals(bankAccount.
                        getUsername())) {
                    System.out.println("1 condition met");
                    
                    if (!bankAccountItem.getNumber().equals(bankAccount.
                            getNumber())) {
                        System.out.println("2 condition met");
                        toFill = true;
                    }
                }
            }
        } else {
            System.out.println("empty, else condition");
            bankAccounts.add(bankAccount);
            database.put(bankAccount.getUsername(), bankAccounts);
        }*/
        
        if (toFill) {
            bankAccounts.add(bankAccount);
            database.put(bankAccount.getUsername(), bankAccounts);
        }
        
        return true;
    }

    @Override
    public List<BankAccount> getAllAccounts() {
        return bankAccounts;
    }
}
