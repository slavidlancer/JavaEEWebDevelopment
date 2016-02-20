package com.jeewd.bank.entities;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
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
