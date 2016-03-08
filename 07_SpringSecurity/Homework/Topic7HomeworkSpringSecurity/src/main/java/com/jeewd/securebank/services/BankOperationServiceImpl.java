package com.jeewd.securebank.services;

import java.math.BigDecimal;
import org.springframework.stereotype.Service;
import com.jeewd.securebank.entity.BankAccount;

@Service
public class BankOperationServiceImpl implements BankOperationService {
    @Override
    public void deposit(BankAccount bankAccount, BigDecimal changeAmount) {
        bankAccount.setAmount(bankAccount.getAmount().add(changeAmount));
    }

    @Override
    public void withdraw(BankAccount bankAccount, BigDecimal changeAmount) {
        bankAccount.setAmount(bankAccount.getAmount().subtract(changeAmount));
        
        if (new BigDecimal(0).compareTo(bankAccount.getAmount()) > 0) {
            bankAccount.setAmount(new BigDecimal(0).setScale(2));
        }
    }
}
