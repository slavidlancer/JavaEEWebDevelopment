package com.jeewd.cars.security;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import com.jeewd.cars.dao.user.UserDao;
import com.jeewd.cars.entities.user.Authority;
import com.jeewd.cars.entities.user.AutoUser;

public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        AutoUser autoUser = userDao.getUser(username);
        
        List<GrantedAuthority> authorities = new ArrayList<>();
        
        for (Authority authority : autoUser.getAuthorities()) {
            authorities.add(new SimpleGrantedAuthority(
                    authority.getAuthority()));
        }
        
        return new User(autoUser.getUsername(), autoUser.getPassword(),
                authorities);
    }
}
