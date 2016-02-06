package com.jeewd.ejbs;

import java.util.HashMap;
import java.util.Map;
import javax.ejb.Stateless;

@Stateless
public class BankOperationImpl implements BankOperation {
    private Map<String, Double> clientAccount = new HashMap<>();
    private boolean newClientAdded;
    private boolean incorrectValues;

    @Override
    public double deposit(String client, double currentAmount,
            double changeAmount) {
        if (clientAccount.containsKey(client)) {
            currentAmount = clientAccount.get(client);
            newClientAdded = false;
        } else {
            clientAccount.put(client, currentAmount);
            newClientAdded = true;
        }
        
        if (changeAmount > 0.0d) {
            clientAccount.put(client, (currentAmount + changeAmount));
            incorrectValues = false;
            
            return currentAmount + changeAmount;
        }
        
        incorrectValues = true;
        
        return currentAmount;
    }

    @Override
    public double withdraw(String client, double currentAmount,
            double changeAmount) {
        if (!clientAccount.containsKey(client)) {
            newClientAdded = true;
            
            return deposit(client, currentAmount, changeAmount);
        } else if (clientAccount.containsKey(client)) {
            currentAmount = clientAccount.get(client);
            newClientAdded = false;
        }
        
        if ((changeAmount > 0.0d) && (changeAmount <= (0.50 * currentAmount))) {
            clientAccount.put(client, (currentAmount - changeAmount));
            incorrectValues = false;
            
            return currentAmount - changeAmount;
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
    public boolean incorrectAmmountToChange() {
        return incorrectValues;
    }
}
