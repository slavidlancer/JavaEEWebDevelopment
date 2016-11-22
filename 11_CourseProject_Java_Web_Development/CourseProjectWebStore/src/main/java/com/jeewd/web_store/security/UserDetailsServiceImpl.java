package com.jeewd.web_store.security;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import com.jeewd.web_store.entities.user.Role;
import com.jeewd.web_store.entities.user.User;
import com.jeewd.web_store.services.user.UserService;

public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserService userService;
    
    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        User user = userService.getUserByUsername(username);
        
        List<GrantedAuthority> roles = new ArrayList<>();
        
        if (user != null) {
            for (Role role : user.getRoles()) {
                roles.add(new SimpleGrantedAuthority(role.getRole()));
            }
            
            return new com.jeewd.web_store.security.User(user.getUsername(),
                    user.getPassword(), roles);
        } else {
            return new com.jeewd.web_store.security.User("", "",
                    new ArrayList<GrantedAuthority>());
        }
    }
}
