package com.jeewd.jdbc_bank.services;

//import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jeewd.jdbc_bank.dao.BankAccountDao;
import com.jeewd.jdbc_bank.entity.BankAccount;

@Service
public class BankAccountServiceImpl implements BankAccountService {
    //private static Set<BankAccount> bankAccounts = new HashSet<>();
    @Autowired
    private BankAccountDao bankAccountDao;
    
    @Override
    public boolean addBankAccount(BankAccount bankAccount, String user) {
        /*bankAccount.setCreatedBy(user);
        
        if (!bankAccounts.contains(bankAccount)) {
            bankAccounts.add(bankAccount);
        }*/
        
        return bankAccountDao.addBankAccount(bankAccount, user);
    }

    @Override
    public BankAccount getBankAccountNumberByUsername(String username,
            String number) {
        /*for (BankAccount bankAccount : bankAccounts) {
            if (username.equals(bankAccount.getUsername())) {
                if (number.equals(bankAccount.getNumber())) {
                    return bankAccount;
                }
            }
        }*/
        
        return bankAccountDao.getBankAccountNumberByUsername(username, number);
    }
    
    @Override
    public Set<BankAccount> getAllBankAccounts() {
        //return bankAccounts;
        return bankAccountDao.getAllBankAccounts();
    }
}
