package com.jeewd.ejb;

import java.math.BigDecimal;
import javax.ejb.Stateful;

@Stateful
public class WebBankImpl implements WebBank {
    @Override
    public BigDecimal deposit(String client, BigDecimal amount,
            String currency) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public BigDecimal withdraw(String client, BigDecimal amount,
            String currency) {
        // TODO Auto-generated method stub
        return null;
    }
}
