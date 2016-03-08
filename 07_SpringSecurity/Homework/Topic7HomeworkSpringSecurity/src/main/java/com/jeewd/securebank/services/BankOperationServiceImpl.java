package com.jeewd.securebank.services;

import java.math.BigDecimal;
import org.springframework.stereotype.Service;
import com.jeewd.securebank.entity.BankAccount;

@Service
public class BankOperationServiceImpl implements BankOperationService {
    @Override
    public BigDecimal deposit(BankAccount bankAccount,
            BigDecimal changeAmount) {
        return bankAccount.getAmount().add(changeAmount);
    }

    @Override
    public BigDecimal withdraw(BankAccount bankAccount,
            BigDecimal changeAmount) {
        // TODO Auto-generated method stub
        return bankAccount.getAmount().add(changeAmount);
    }
}
