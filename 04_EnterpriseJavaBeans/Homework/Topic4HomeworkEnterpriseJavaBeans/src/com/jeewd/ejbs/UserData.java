package com.jeewd.ejbs;

import java.util.Map;
import javax.ejb.Local;

@Local
public interface UserData {
    Map<String, Account> getUsersWithAccountsList();
    void setUsersWithAccountsList(Map<String, Account> usersWithAccountsList);
}
