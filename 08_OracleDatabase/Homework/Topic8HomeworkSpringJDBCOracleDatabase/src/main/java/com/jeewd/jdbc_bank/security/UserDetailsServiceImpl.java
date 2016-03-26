package com.jeewd.jdbc_bank.security;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import com.jeewd.jdbc_bank.dao.UserDao;
import com.jeewd.jdbc_bank.entities.UserDb;

public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserDao userDao;
    
    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        
        HashMap<Long, UserDb> users = (HashMap<Long, UserDb>)
                userDao.getAllUsers();
        
        for (Entry<Long, UserDb> user : users.entrySet()) {
            if ("admin".equals(user.getValue().getUsername())
                    && "ROLE_BANK_EMPLOYEE".equals(user.getValue().getRole())) {
                if (user.getValue().getUsername().equals(username)) {
                    authorities.add(new SimpleGrantedAuthority(
                            "ROLE_BANK_EMPLOYEE"));
                    
                    return new User(username, user.getValue().getPassword(),
                            authorities);
                }
            } else if (user.getValue().getUsername().equals(username)
                    && "ROLE_USER".equals(user.getValue().getRole())) {
                return new User(username, user.getValue().getPassword(),
                        authorities);
            }
        }
        
        return new User("", "", new ArrayList<GrantedAuthority>());
    }
}
