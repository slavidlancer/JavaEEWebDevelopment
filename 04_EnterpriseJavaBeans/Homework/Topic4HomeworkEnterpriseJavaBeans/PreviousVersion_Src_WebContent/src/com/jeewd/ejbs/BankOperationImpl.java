package com.jeewd.ejbs;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import javax.ejb.Stateful;

@Stateful
public class BankOperationImpl implements BankOperation {
    private Map<String, BigDecimal> clientAccount;
    private Map<String, String> accountCurrency;
    private boolean newClientAdded;
    private boolean incorrectValues;
    
    public BankOperationImpl() {
        clientAccount = new HashMap<>();
        accountCurrency = new HashMap<>();
    }
    
    @Override
    public BigDecimal deposit(String client, BigDecimal currentAmount,
            BigDecimal changeAmount) {
        BigDecimal currentAmountScaled = currentAmount.setScale(2,
                BigDecimal.ROUND_HALF_UP);
        
        if (clientAccount.containsKey(client)) {
            currentAmount = clientAccount.get(client);
            currentAmountScaled = currentAmount.setScale(2,
                    BigDecimal.ROUND_HALF_UP);
            newClientAdded = false;
        } else {
            clientAccount.put(client, currentAmountScaled);
            newClientAdded = true;
        }
        
        BigDecimal changeAmountScaled = changeAmount.setScale(2,
                BigDecimal.ROUND_HALF_UP);
        
        if (changeAmountScaled.compareTo(new BigDecimal(0)) == 1) {
            BigDecimal currentValue = currentAmountScaled.add(
                    changeAmountScaled);
            clientAccount.put(client, currentValue);
            incorrectValues = false;
            
            return currentValue;
        }
        
        incorrectValues = true;
        
        return currentAmountScaled;
    }

    @Override
    public BigDecimal withdraw(String client, BigDecimal currentAmount,
            BigDecimal changeAmount) {
        BigDecimal currentAmountScaled = currentAmount.setScale(2,
                BigDecimal.ROUND_HALF_UP);
        
        if (!clientAccount.containsKey(client)) {
            newClientAdded = true;
            
            return deposit(client, currentAmount, changeAmount);
        } else if (clientAccount.containsKey(client)) {
            currentAmount = clientAccount.get(client);
            currentAmountScaled = currentAmount.setScale(2,
                    BigDecimal.ROUND_HALF_UP);
            newClientAdded = false;
        }
        
        BigDecimal changeAmountScaled = changeAmount.setScale(2,
                BigDecimal.ROUND_HALF_UP);
        BigDecimal halfAmount = currentAmountScaled.multiply(
                new BigDecimal(0.50));
        
        if ((changeAmountScaled.compareTo(new BigDecimal(0)) == 1) &&
                (changeAmountScaled.compareTo(halfAmount) <= 0)) {
            BigDecimal currentValue = currentAmountScaled.subtract(
                    changeAmountScaled);
            clientAccount.put(client, currentValue);
            incorrectValues = false;
            
            return currentValue;
        }
        
        incorrectValues = true;
        
        return currentAmountScaled;
    }

    @Override
    public boolean doesNotContainClient(String client) {
        if (!clientAccount.containsKey(client) || newClientAdded) {
            return true;
        }
        
        return false;
    }

    @Override
    public boolean incorrectAmountToChange() {
        return incorrectValues;
    }

    @Override
    public void setCurrency(String account, String currency) {
        accountCurrency.put(account, currency);
    }

    @Override
    public String getCurrency(String account) {
        return accountCurrency.get(account);
    }
}
