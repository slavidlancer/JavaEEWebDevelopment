package com.jeewd.ejbs;

import java.util.HashMap;
import java.util.Map;
import javax.ejb.Stateless;

@Stateless
public class BankOperationImpl implements BankOperation {
    private Map<String, Double> clientAccount = new HashMap<>();
    private boolean newClientAdded;

    @Override
    public double deposit(String client, double currentAmount,
            double changeAmount) {
        clientAccount.put(client, (currentAmount + changeAmount));
        
        return currentAmount + changeAmount;
    }

    @Override
    public double withdraw(String client, double currentAmount,
            double changeAmount) {
        if (doesNotContainClient(client)) {
            newClientAdded = true;
            
            return deposit(client, currentAmount, changeAmount);
        }
        
        clientAccount.put(client, (currentAmount - changeAmount));
        
        return currentAmount - changeAmount;
        
    }

    @Override
    public boolean doesNotContainClient(String client) {
        if (!clientAccount.containsKey(client) || newClientAdded) {
            newClientAdded = false;
            
            return true;
        }
        
        newClientAdded = false;
        
        return false;
    }
}
