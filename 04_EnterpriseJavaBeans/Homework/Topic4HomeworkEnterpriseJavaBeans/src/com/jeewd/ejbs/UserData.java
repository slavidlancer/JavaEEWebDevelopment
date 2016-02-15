package com.jeewd.ejbs;

import java.util.Map;
import javax.ejb.Local;
import com.jeewd.model.Account;

@Local
public interface UserData {
    Map<String, Account> getUsersWithAccountsList();
    void setUsersWithAccountsList(Map<String, Account> usersWithAccountsList);
}
