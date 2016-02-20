package com.jeewd.bank.services;

import java.math.BigDecimal;

public interface CurrencyConversion {
    BigDecimal convert(BigDecimal changeAmount, String changeCurrency,
            String accountCurrency);
}
