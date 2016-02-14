package com.jeewd.ejbs;

import java.math.BigDecimal;
import javax.ejb.Stateless;

@Stateless
public class CurrencyConversionImpl implements CurrencyConversion {
    @Override
    public BigDecimal convertFromCurrencyToAnother(BigDecimal fromValue,
            BigDecimal exchangeRate) {
        BigDecimal toValue = fromValue.multiply(exchangeRate);
        
        return toValue;
    }
}
