package com.jee.web.utils.validation;

import org.apache.commons.lang3.StringUtils;

import com.jee.entity.IssueModel;
import com.jee.web.utils.MessageUtils;

public class ValidateIssue {
    
    public static boolean validate(IssueModel issue) {
        boolean isNotValid = false;
        
        if (StringUtils.isBlank(issue.getTitle())) {
            MessageUtils.addErrorMessage("title", "error.required.title");
            
            isNotValid = true;
        }
        
        if (StringUtils.isBlank(issue.getDescription())) {
            MessageUtils.addErrorMessage("error.required.description");
            
            isNotValid = true;
        }
        
        return !isNotValid;
    }
}
