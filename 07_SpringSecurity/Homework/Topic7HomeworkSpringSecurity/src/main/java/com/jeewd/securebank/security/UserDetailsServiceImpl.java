package com.jeewd.securebank.security;

import java.util.ArrayList;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImpl implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        
        if ("admin".equals(username)) {
            authorities.add(new SimpleGrantedAuthority("ROLE_BANK_EMPLOYEE"));
            
            return new User(username, "c4ca4238a0b923820dcc509a6f75849b",
                    authorities);
        }
        
        return new User(username, "e10adc3949ba59abbe56e057f20f883e",
                authorities);
    }
}
