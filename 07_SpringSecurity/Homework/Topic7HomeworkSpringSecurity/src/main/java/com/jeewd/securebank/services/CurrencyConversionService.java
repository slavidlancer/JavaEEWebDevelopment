package com.jeewd.securebank.services;

import java.math.BigDecimal;

public interface CurrencyConversionService {
    BigDecimal convert(BigDecimal changeAmount, String changeCurrency,
            String accountCurrency);
}
