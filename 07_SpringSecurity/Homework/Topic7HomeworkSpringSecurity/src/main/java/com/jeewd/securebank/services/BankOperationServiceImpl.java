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
        BigDecimal compareAmount = new BigDecimal(bankAccount.getAmount().
                toString()).subtract(changeAmount);
        
        if (new BigDecimal(0).compareTo(compareAmount) <= 0) {
            bankAccount.setAmount(bankAccount.getAmount().subtract(
                    changeAmount));
        }
    }
}
