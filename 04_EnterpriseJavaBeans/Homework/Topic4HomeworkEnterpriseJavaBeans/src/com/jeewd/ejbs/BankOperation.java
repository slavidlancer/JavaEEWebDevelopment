package com.jeewd.ejbs;

import java.math.BigDecimal;
import javax.ejb.Local;

@Local
public interface BankOperation {
    BigDecimal deposit(String client, BigDecimal currentAmount,
            BigDecimal changeAmount);
    BigDecimal withdraw(String client, BigDecimal currentAmount,
            BigDecimal changeAmount);
    boolean doesNotContainClient(String client);
    boolean incorrectAmountToChange();
}
