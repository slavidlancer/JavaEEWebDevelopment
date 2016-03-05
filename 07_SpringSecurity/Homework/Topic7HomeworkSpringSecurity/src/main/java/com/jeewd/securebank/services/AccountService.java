package com.jeewd.securebank.services;

import java.util.List;
import com.jeewd.securebank.entity.BankAccount;

public interface AccountService {
    boolean addAccount(BankAccount bankAccount, String user);
    List<BankAccount> getAllAccounts();
}
