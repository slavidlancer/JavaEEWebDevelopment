package com.jeewd.jpa_h_bank.services;

import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeewd.jpa_h_bank.dao.OperationDao;
import com.jeewd.jpa_h_bank.entities.BankAccount;
import com.jeewd.jpa_h_bank.security.User;

@Service
public class BankOperationServiceImpl implements BankOperationService {
    @Autowired
    private OperationDao operationDao;
    
    @Override
    public boolean deposit(BankAccount bankAccount, BigDecimal changeAmount,
            User user, String currency) {
        //bankAccount.setAmount(bankAccount.getAmount().add(changeAmount));
        if (!operationDao.performDeposit(bankAccount, changeAmount)) {
            return false;
        }
        
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
        
        //bankAccount.setAmount(bankAccount.getAmount().subtract(changeAmount));
        if (!operationDao.performWithdraw(bankAccount, changeAmount)) {
            return false;
        }
        
        operationDao.registerOperation(bankAccount.getNumber(), "withdraw",
                changeAmount, currency, user.getUsername());
        
        return true;
    }
}
