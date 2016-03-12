package com.jeewd.secure_bank.services;

import java.math.BigDecimal;

public interface WebBank {
    BigDecimal deposit(String client, BigDecimal amount, String currency);
    BigDecimal withdraw(String client, BigDecimal amount, String currency);
}
