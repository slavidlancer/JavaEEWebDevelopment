package com.jeewd.ejbs;

import java.math.BigDecimal;
import javax.ejb.Stateful;

@Stateful
public class BankOperationImpl implements BankOperation {
    public BankOperationImpl() {}
    
    @Override
    public BigDecimal deposit(String client, BigDecimal currentAmount,
            BigDecimal changeAmount) {
        BigDecimal currentAmountScaled = currentAmount.setScale(2,
                BigDecimal.ROUND_HALF_UP);
        
        return currentAmountScaled;
    }

    @Override
    public BigDecimal withdraw(String client, BigDecimal currentAmount,
            BigDecimal changeAmount) {
        BigDecimal currentAmountScaled = currentAmount.setScale(2,
                BigDecimal.ROUND_HALF_UP);
        
        return currentAmountScaled;
    }
}
