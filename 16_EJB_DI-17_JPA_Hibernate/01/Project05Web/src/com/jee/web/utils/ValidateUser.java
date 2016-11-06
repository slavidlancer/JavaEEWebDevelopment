package com.jee.web.utils;

import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

import com.jee.entity.UserModel;
import com.jee.web.constants.OtherConstants;

public class ValidateUser {
    
    private static Pattern pattern;
    
    public static boolean validate(UserModel user) {
        boolean isNotValid = false;
        
        if (StringUtils.isBlank(user.getUsername())) {
            MessageUtils.addErrorMessage("username", "error.required.username");
            
            isNotValid = true;
        }
        
        if (StringUtils.isBlank(user.getPassword())) {
            MessageUtils.addErrorMessage("error.required.password");
            
            isNotValid = true;
        }
        
        if (StringUtils.isBlank(user.getFirstName())) {
            MessageUtils.addErrorMessage("error.required.firstname");
            
            isNotValid = true;
        }
        
        if (StringUtils.isBlank(user.getLastName())) {
            MessageUtils.addErrorMessage("error.required.lastname");
            
            isNotValid = true;
        }
        
        if (StringUtils.isBlank(user.getEmail())) {
            MessageUtils.addErrorMessage("error.required.email");
            
            isNotValid = true;
        }
        
        pattern = Pattern.compile(OtherConstants.EMAIL_PATTERN);
        
        if (!pattern.matcher(user.getEmail()).matches()) {
            MessageUtils.addErrorMessage("error.invalid.email");
            
            isNotValid = true;
        }
        
        return !isNotValid;
    }
}
