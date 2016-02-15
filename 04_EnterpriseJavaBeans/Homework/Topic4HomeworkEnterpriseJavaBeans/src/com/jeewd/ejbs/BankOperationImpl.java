package com.jeewd.ejbs;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.Stateful;

@Stateful
public class BankOperationImpl implements BankOperation {
    private Map<String, BigDecimal> withdrawSoFarList;
    private Map<String, BigDecimal> allowedWithdrawMaxAmountList;
    
    @PostConstruct
    void postConstruct() {
        withdrawSoFarList = new HashMap<>();
        allowedWithdrawMaxAmountList = new HashMap<>();
    }
    
    @Override
    public BigDecimal deposit(String clientName, BigDecimal currentAmount,
            BigDecimal changeAmount) {
        BigDecimal currentAmountScaled = currentAmount.setScale(2,
                BigDecimal.ROUND_HALF_UP);
        BigDecimal changeAmountScaled = changeAmount.setScale(2,
                BigDecimal.ROUND_HALF_UP);
        BigDecimal result = new BigDecimal(0).setScale(2);
        
        if (!allowedWithdrawMaxAmountList.containsKey(clientName)) {
            allowedWithdrawMaxAmountList.put(clientName, currentAmountScaled);
        }
        
        BigDecimal currentAllowedWithdrawMaxAmount =
                allowedWithdrawMaxAmountList.get(clientName);
        
        if (changeAmountScaled.compareTo(result) == 1) {
            result = currentAmountScaled.add(changeAmountScaled);
            allowedWithdrawMaxAmountList.put(clientName,
                    currentAllowedWithdrawMaxAmount.add(changeAmountScaled));
        } else {
            result = currentAmountScaled;
        }
        
        return result;
    }

    @Override
    public BigDecimal withdraw(String clientName, BigDecimal currentAmount,
            BigDecimal changeAmount) {
        BigDecimal currentAmountScaled = currentAmount.setScale(2,
                BigDecimal.ROUND_HALF_UP);
        BigDecimal changeAmountScaled = changeAmount.setScale(2,
                BigDecimal.ROUND_HALF_UP);
        BigDecimal result = new BigDecimal(0).setScale(2);
        BigDecimal currentWithdrawAmount = new BigDecimal(0).setScale(2);
        BigDecimal allowedWithdrawMaxAmount = allowedWithdrawMaxAmountList.
                get(clientName).multiply(new BigDecimal(0.50)).setScale(2);
        
        if (!withdrawSoFarList.containsKey(clientName)) {
            withdrawSoFarList.put(clientName, changeAmountScaled);
        } else {
            currentWithdrawAmount = withdrawSoFarList.get(clientName);
            withdrawSoFarList.put(clientName, currentWithdrawAmount.add(
                    changeAmountScaled));
            
        }
        
        currentWithdrawAmount = withdrawSoFarList.get(clientName);
        
        if ((changeAmountScaled.compareTo(result) == 1) &&
                (currentWithdrawAmount.compareTo(allowedWithdrawMaxAmount)
                        < 0)) {
            result = currentAmountScaled.subtract(changeAmountScaled);
        } else {
            result = currentAmountScaled;
            withdrawSoFarList.put(clientName, currentWithdrawAmount.subtract(
                    changeAmountScaled));
        }
        
        return result;
    }
}
