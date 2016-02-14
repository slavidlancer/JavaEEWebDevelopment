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
        
        System.out.printf("%s %s %s\t", currentAmountScaled, changeAmountScaled, result);
        
        if (changeAmountScaled.compareTo(result) == 1) {
            result = currentAmountScaled.add(changeAmountScaled);
            System.out.println(result + "first if");
        } else {
            result = currentAmountScaled;
            System.out.println(result + "second if");
        }
        
        this.allowedWithdrawMaxAmount = (result.multiply(new BigDecimal(0.50))).
                setScale(2);
        System.out.printf("\nw: %s a:%s\n", withdrawSoFar, allowedWithdrawMaxAmount);
        
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
        
        
        System.out.printf("%s %s %s\t", currentAmountScaled, changeAmountScaled, result);
        System.out.printf("\nw: %s a: %s\n", withdrawSoFar, allowedWithdrawMaxAmount);
        
        if ((changeAmountScaled.compareTo(result) == 1) &&
                (this.withdrawSoFar.compareTo(this.allowedWithdrawMaxAmount)
                        < 1)) {
            result = currentAmountScaled.subtract(changeAmountScaled);
            System.out.println(result + "first if");
        } else {
            result = currentAmountScaled;
            this.withdrawSoFar = withdrawSoFar.subtract(changeAmountScaled);
            System.out.println(result + "second if");
        }
        
        System.out.printf("\nw: %s\n", withdrawSoFar);
        
        return result;
    }
}
