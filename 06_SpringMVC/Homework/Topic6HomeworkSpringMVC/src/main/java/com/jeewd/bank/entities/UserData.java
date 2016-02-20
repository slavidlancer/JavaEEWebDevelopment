package com.jeewd.bank.entities;

import java.util.Map;

public interface UserData {
    Map<String, Account> getUsersWithAccountsList();
    void setUsersWithAccountsList(Map<String, Account> usersWithAccountsList);
}
