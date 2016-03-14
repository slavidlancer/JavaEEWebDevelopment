package com.jeewd.jdbc_bank.services;

import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import com.jeewd.jdbc_bank.security.User;
import org.springframework.stereotype.Service;
import com.jeewd.jdbc_bank.dao.OperationDao;
import com.jeewd.jdbc_bank.entity.BankAccount;

@Service
public class BankOperationServiceImpl implements BankOperationService {
    @Autowired
    private OperationDao operationDao;
    
    @Override
    public boolean deposit(BankAccount bankAccount, BigDecimal changeAmount,
            User user, String currency) {
        bankAccount.setAmount(bankAccount.getAmount().add(changeAmount));
        operationDao.registerOperation(bankAccount.getNumber(), "deposit",
                changeAmount, currency, user.getUsername());
        
        return true;
    }

    @Override
    public boolean withdraw(BankAccount bankAccount, BigDecimal changeAmount,
            User user, String currency) {
        BigDecimal compareAmount = new BigDecimal(bankAccount.getAmount().
                toString()).subtract(changeAmount);
        
        if (!(new BigDecimal(0).compareTo(compareAmount) <= 0)) {
            return false;
        }
        
        bankAccount.setAmount(bankAccount.getAmount().subtract(changeAmount));
        operationDao.registerOperation(bankAccount.getNumber(), "withdraw",
                changeAmount, currency, user.getUsername());
        
        return true;
    }
}
