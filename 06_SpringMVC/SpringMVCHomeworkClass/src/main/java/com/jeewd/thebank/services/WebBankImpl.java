package com.jeewd.thebank.services;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;

import com.jeewd.thebank.entity.Account;
import com.jeewd.thebank.entity.ExchangeRate;

@Service
public class WebBankImpl implements WebBank {
    private static final Map<String, Account> bankAccounts = new HashMap<>();
    private static final Map<String, ExchangeRate> exchangeRates =
            new HashMap<>();
    /*private static final BigDecimal EXCHANGE_RATE_BGN_TO_EUR =
            new BigDecimal(0.51);*/
    private static final BigDecimal EXCHANGE_RATE_EUR_TO_BGN =
            new BigDecimal(1.96);
    
    private Map<String, BigDecimal> initialAmounts = new HashMap<>();
    private Map<String, BigDecimal> totalWithdraws = new HashMap<>();
    
    static {
        ExchangeRate exchangeRate = new ExchangeRate();
        exchangeRate.setCurrency("BGN");
        exchangeRate.setRate(EXCHANGE_RATE_EUR_TO_BGN);
        exchangeRate.setDate(new Date());
        exchangeRates.put("EUR", exchangeRate);
    }
    
    @Override
    public BigDecimal deposit(String client, BigDecimal amount,
            String currency) {
        Account userAccount = bankAccounts.get(client);
        
        if (userAccount == null) {
            userAccount = new Account();
            userAccount.setCurrency("BGN");
        }
        
        if (!userAccount.getCurrency().equals(currency)) {
            ExchangeRate exchangeRate = exchangeRates.get(currency);
            amount = amount.multiply(exchangeRate.getRate());
        }
        
        BigDecimal currentAmount = userAccount.getAmount();
        
        if (currentAmount == null) {
            currentAmount = new BigDecimal(0).setScale(2);
        }
        
        currentAmount = currentAmount.add(amount);
        userAccount.setAmount(currentAmount);
        bankAccounts.put(client, userAccount);
        initialAmounts.put(client, currentAmount);
        
        return currentAmount.setScale(2, RoundingMode.HALF_UP);
    }

    @Override
    public BigDecimal withdraw(String client, BigDecimal amount,
            String currency) {
        Account userAccount = bankAccounts.get(client);
        BigDecimal currentAmount = userAccount.getAmount();
        BigDecimal totalWithdraw = totalWithdraws.get(client);
        BigDecimal initialAmount = initialAmounts.get(client);
        BigDecimal compareAmount = initialAmount.multiply(new BigDecimal(0.50));
        
        if (totalWithdraw == null) {
            totalWithdraw = new BigDecimal(0).setScale(2);
        }
        
        if (!userAccount.getCurrency().equals(currency)) {
            ExchangeRate exchangeRate = exchangeRates.get(currency);
            amount = amount.multiply(exchangeRate.getRate());
        }
        
        totalWithdraw = totalWithdraw.add(amount);
        
        if (currentAmount == null) {
            return new BigDecimal(0).setScale(2);
        } else if ((currentAmount.compareTo(amount) >= 0) &&
                (totalWithdraw.compareTo(compareAmount) < 0)) {
            currentAmount = currentAmount.subtract(amount);
            userAccount.setAmount(currentAmount);
            bankAccounts.put(client, userAccount);
            totalWithdraws.put(client, totalWithdraw);
        }
        
        return currentAmount.setScale(2, RoundingMode.HALF_UP);
    }
}
