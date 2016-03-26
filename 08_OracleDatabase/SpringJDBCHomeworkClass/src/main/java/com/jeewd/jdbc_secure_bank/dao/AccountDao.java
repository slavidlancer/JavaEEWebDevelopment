package com.jeewd.jdbc_secure_bank.dao;

import java.util.List;
import com.jeewd.jdbc_secure_bank.entity.Account;

public interface AccountDao {
    List<Account> getAccounts();
    
    boolean addAccount(Account account);
}
