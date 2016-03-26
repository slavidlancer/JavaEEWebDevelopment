package com.jeewd.jdbc_bank.services;

import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jeewd.jdbc_bank.dao.BankAccountDao;
import com.jeewd.jdbc_bank.entities.BankAccount;

@Service
public class BankAccountServiceImpl implements BankAccountService {
    @Autowired
    private BankAccountDao bankAccountDao;
    
    @Override
    public boolean addBankAccount(BankAccount bankAccount, String user) {
        if (bankAccountDao.containsBankAccount(bankAccount)) {
            return false;
        }
        
        bankAccount.setCreatedBy(user);
        
        return bankAccountDao.addBankAccount(bankAccount);
    }

    @Override
    public BankAccount getBankAccountNumberByUsername(String username,
            String number) {
        return bankAccountDao.getBankAccountNumberByUsername(username, number);
    }
    
    @Override
    public Set<BankAccount> getAllBankAccounts() {
        return bankAccountDao.getAllBankAccounts();
    }
}
