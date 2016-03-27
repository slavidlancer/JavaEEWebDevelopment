package com.jeewd.jpa_h_bank.services;

import java.math.BigDecimal;

public interface CurrencyConversionService {
    BigDecimal convert(BigDecimal changeAmount, String changeCurrency,
            String accountCurrency);
}
