package com.jeewd.ejbs;

import java.math.BigDecimal;
import javax.ejb.Stateful;

@Stateful
public class BankOperationImpl implements BankOperation {
    @Override
    public BigDecimal deposit(BigDecimal currentAmount,
            BigDecimal changeAmount) {
        BigDecimal currentAmountScaled = currentAmount.setScale(2,
                BigDecimal.ROUND_HALF_UP);
        BigDecimal changeAmountScaled = changeAmount.setScale(2,
                BigDecimal.ROUND_HALF_UP);
        BigDecimal result = new BigDecimal(0).setScale(2);
        
        if (changeAmountScaled.compareTo(result) == 1) {
            result = currentAmountScaled.add(changeAmountScaled);
        } else {
            result = currentAmountScaled;
        }
        
        return result;
    }

    @Override
    public BigDecimal withdraw(BigDecimal currentAmount,
            BigDecimal changeAmount) {
        BigDecimal currentAmountScaled = currentAmount.setScale(2,
                BigDecimal.ROUND_HALF_UP);
        BigDecimal changeAmountScaled = changeAmount.setScale(2,
                BigDecimal.ROUND_HALF_UP);
        BigDecimal result = new BigDecimal(0).setScale(2);
        BigDecimal allowedWithdrawMaxAmount = currentAmount.multiply(
                new BigDecimal(0.50));
        
        if ((changeAmountScaled.compareTo(result) == 1) &&
                (changeAmountScaled.compareTo(allowedWithdrawMaxAmount) < 1)) {
            result = currentAmountScaled.subtract(changeAmountScaled);
        } else {
            result = currentAmountScaled;
        }
        
        return result;
    }
}
