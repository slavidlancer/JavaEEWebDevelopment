package com.jeewd.ejbs;

import java.math.BigDecimal;
import javax.ejb.Local;

@Local
public interface CurrencyConversion {
    BigDecimal convertFromCurrencyToAnother(BigDecimal fromValue,
            BigDecimal exchangeRate);
}
