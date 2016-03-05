package com.jeewd.securebank.services;

import java.math.BigDecimal;
import java.util.List;

import com.jeewd.securebank.entity.BankAccount;
import com.jeewd.securebank.entity.CurrencyID;

public interface AccountService {
    boolean addAccount(String username, String number, BigDecimal amount,
            CurrencyID currency);

    List<BankAccount> getAccounts(String username);
}
