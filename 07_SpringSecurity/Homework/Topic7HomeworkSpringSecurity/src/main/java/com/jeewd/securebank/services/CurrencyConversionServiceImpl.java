package com.jeewd.securebank.services;

import java.math.BigDecimal;

public class CurrencyConversionServiceImpl
        implements CurrencyConversionService {
    private static final String CURRENCY_BGN = "BGN";
    private static final String CURRENCY_USD = "USD";
    private static final String CURRENCY_EUR = "EUR";
    private static final BigDecimal EXCHANGE_RATE_BGN_TO_EUR =
            new BigDecimal(0.511292);
    private static final BigDecimal EXCHANGE_RATE_EUR_TO_BGN =
            new BigDecimal(1.95583);
    
    @Override
    public BigDecimal convert(BigDecimal changeAmount, String changeCurrency,
            String accountCurrency) {
        BigDecimal result = changeAmount;
        
        if (!changeCurrency.equals(accountCurrency)) {
            switch (accountCurrency) {
                case CURRENCY_BGN:
                    switch (changeCurrency) {
                        case CURRENCY_USD:
                            BigDecimal exchangeRateUSDtoBGN = new BigDecimal(
                                    1.76185);
                            result = changeAmount.multiply(
                                    exchangeRateUSDtoBGN);
                            
                            break;

                        case CURRENCY_EUR:
                            result = changeAmount.multiply(
                                    EXCHANGE_RATE_EUR_TO_BGN);
                            
                            break;
                    }
                    
                    break;

                case CURRENCY_USD:
                    switch (changeCurrency) {
                        case CURRENCY_BGN:
                            BigDecimal exchangeRateBGNtoUSD = new BigDecimal(
                                    0.567585);
                            result = changeAmount.multiply(
                                    exchangeRateBGNtoUSD);
                            
                            break;

                        case CURRENCY_EUR:
                            BigDecimal exchangeRateEURtoUSD = new BigDecimal(
                                    1.11823);
                            result = changeAmount.multiply(
                                    exchangeRateEURtoUSD);
                            
                            break;
                    }
                    
                    break;

                case CURRENCY_EUR:
                    switch (changeCurrency) {
                        case CURRENCY_BGN:
                            result = changeAmount.multiply(
                                    EXCHANGE_RATE_BGN_TO_EUR);
                            
                            break;

                        case CURRENCY_USD:
                            BigDecimal exchangeRateUSDtoEUR = new BigDecimal(
                                    0.894269);
                            result = changeAmount.multiply(
                                    exchangeRateUSDtoEUR);
                            
                            break;
                    }
                    
                    break;
            }
        }
        
        return result;
    }
}
