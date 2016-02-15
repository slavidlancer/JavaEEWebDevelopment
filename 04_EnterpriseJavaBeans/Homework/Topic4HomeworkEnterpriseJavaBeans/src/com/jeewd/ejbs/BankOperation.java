package com.jeewd.ejbs;

import java.math.BigDecimal;
import javax.ejb.Local;

@Local
public interface BankOperation {
    BigDecimal deposit(String clientName, BigDecimal currentAmount,
            BigDecimal changeAmount);
    BigDecimal withdraw(String clientName, BigDecimal currentAmount,
            BigDecimal changeAmount);
}
