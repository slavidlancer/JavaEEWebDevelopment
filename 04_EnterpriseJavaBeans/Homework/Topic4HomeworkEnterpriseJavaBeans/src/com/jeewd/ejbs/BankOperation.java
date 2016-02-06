package com.jeewd.ejbs;

import javax.ejb.Local;

@Local
public interface BankOperation {
    double deposit(String client, double currentAmount, double changeAmount);
    double withdraw(String client, double currentAmount, double changeAmount);
    boolean doesNotContainClient(String client);
    boolean incorrectAmmountToChange();
}
