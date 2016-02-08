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
        if (clientAccount.containsKey(client)) {
            currentAmount = clientAccount.get(client);
            newClientAdded = false;
        } else {
            clientAccount.put(client, currentAmount);
            newClientAdded = true;
        }
        
        if (changeAmount.compareTo(new BigDecimal(0)) == 1) {
            clientAccount.put(client, currentAmount.add(changeAmount));
            incorrectValues = false;
            
            return currentAmount.add(changeAmount);
        }
        
        incorrectValues = true;
        
        return currentAmount;
    }

    @Override
    public BigDecimal withdraw(String client, BigDecimal currentAmount,
            BigDecimal changeAmount) {
        if (!clientAccount.containsKey(client)) {
            newClientAdded = true;
            
            return deposit(client, currentAmount, changeAmount);
        } else if (clientAccount.containsKey(client)) {
            currentAmount = clientAccount.get(client);
            newClientAdded = false;
        }
        
        BigDecimal halfAmount = currentAmount.multiply(new BigDecimal(0.50));
        
        if ((changeAmount.compareTo(new BigDecimal(0)) == 1) &&
                (changeAmount.compareTo(halfAmount) <= 0)) {
            clientAccount.put(client, currentAmount.subtract(changeAmount));
            incorrectValues = false;
            
            return currentAmount.subtract(changeAmount);
        }
        
        incorrectValues = true;
        
        return currentAmount;
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
}
