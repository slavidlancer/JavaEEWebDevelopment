package com.jeewd.secureuni.utils;

import org.springframework.security.core.context.SecurityContextHolder;

import com.jeewd.secureuni.security.User;

public class UserUtils {
    private UserUtils() {}

    public static User getUser() {
        Object principal = null;
        
        try {
            principal = SecurityContextHolder.getContext().getAuthentication().
                    getPrincipal();
        } catch (NullPointerException npe) {
            npe.printStackTrace();
        }
        
        if ((principal == null) || !(principal instanceof User)) {
            return null;
        }
        
        return (User) principal;
    }
}
