package com.jeewd.ejb;

import java.math.BigDecimal;
import javax.ejb.Local;

@Local
public interface WebBank {
    BigDecimal deposit(String client, BigDecimal amount, String currency);
    BigDecimal withdraw(String client, BigDecimal amount, String currency);
}
