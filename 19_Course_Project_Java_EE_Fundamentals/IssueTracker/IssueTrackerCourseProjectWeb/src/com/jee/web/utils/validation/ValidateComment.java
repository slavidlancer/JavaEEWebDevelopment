package com.jee.web.utils.validation;

import org.apache.commons.lang3.StringUtils;

import com.jee.entity.CommentModel;
import com.jee.web.utils.MessageUtils;

public class ValidateComment {
    
    public static boolean validate(CommentModel comment) {
        boolean isNotValid = false;
        
        if (StringUtils.isBlank(comment.getComment())) {
            MessageUtils.addErrorMessage("comment", "error.required.comment");
            
            isNotValid = true;
        }
        
        if (StringUtils.isBlank(comment.getCommentator())) {
            MessageUtils.addErrorMessage("error.required.commentator");
            
            isNotValid = true;
        }
        
        return !isNotValid;
    }
}
