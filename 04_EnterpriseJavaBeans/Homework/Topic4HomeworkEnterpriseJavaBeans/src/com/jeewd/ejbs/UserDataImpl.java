package com.jeewd.ejbs;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import com.jeewd.model.Account;

@Singleton
public class UserDataImpl implements UserData {
    private Map<String, Account> usersWithAccountsList;
    
    @PostConstruct
    void postConstruct() {
        setUsersWithAccountsList(new HashMap<>());
    }

    public Map<String, Account> getUsersWithAccountsList() {
        return usersWithAccountsList;
    }

    public void setUsersWithAccountsList(Map<String,
            Account> usersWithAccountsList) {
        this.usersWithAccountsList = usersWithAccountsList;
    }
}
