package com.jeewd.ejbs;

import java.math.BigDecimal;
import javax.ejb.Local;

@Local
public interface BankOperation {
    BigDecimal deposit(BigDecimal currentAmount, BigDecimal changeAmount);
    BigDecimal withdraw(BigDecimal currentAmount, BigDecimal changeAmount);
}
