package com.jeewd.jdbc_bank.services;

import java.math.BigDecimal;

public interface CurrencyConversionService {
    BigDecimal convert(BigDecimal changeAmount, String changeCurrency,
            String accountCurrency);
}
