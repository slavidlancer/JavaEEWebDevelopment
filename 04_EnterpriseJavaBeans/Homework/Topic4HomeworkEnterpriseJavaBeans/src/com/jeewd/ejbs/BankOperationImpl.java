package com.jeewd.ejbs;

import java.math.BigDecimal;
import javax.annotation.PostConstruct;
import javax.ejb.Stateful;

@Stateful
public class BankOperationImpl implements BankOperation {
    private BigDecimal allowedWithdrawMaxAmount;
    private BigDecimal withdrawSoFar;
    
    @PostConstruct
    void PostConstruct() {
        this.allowedWithdrawMaxAmount = new BigDecimal(0).setScale(2);
        this.withdrawSoFar = new BigDecimal(0).setScale(2);
    }
    
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
        this.withdrawSoFar = withdrawSoFar.add(changeAmountScaled);
        this.allowedWithdrawMaxAmount = currentAmount.multiply(new BigDecimal(
                0.50)).setScale(2);
        
        if ((changeAmountScaled.compareTo(result) == 1) &&
                (this.withdrawSoFar.compareTo(this.allowedWithdrawMaxAmount)
                        < 1)) {
            result = currentAmountScaled.subtract(changeAmountScaled);
        } else {
            result = currentAmountScaled;
            this.withdrawSoFar = withdrawSoFar.subtract(changeAmountScaled);
        }
        
        return result;
    }
}
