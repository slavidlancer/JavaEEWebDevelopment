package com.jee.web.beans.comments;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;

import com.jee.entity.CommentModel;
import com.jee.service.CommentDaoServiceLocal;
import com.jee.web.constants.UrlConstants;
import com.jee.web.utils.ContextCheck;
import com.jee.web.utils.validation.ValidateComment;

@ManagedBean(name = "editCommentBean")
@ViewScoped
public class EditCommentBean implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Inject
    private HttpServletRequest request;
    
    @EJB
    CommentDaoServiceLocal commentDaoService;
    
    private CommentModel comment;
    
    @PostConstruct
    public void init() {
        String idParameter = request.getParameter("id");
        
        if (StringUtils.isNotBlank(idParameter) && StringUtils.isNumeric(idParameter)) {
            Long id = Long.valueOf(idParameter);
            
            this.comment = commentDaoService.findById(id);
        }
    }
    
    public String editAction() {
        Long issueId = this.comment.getIssue().getId();
        String editParameter = request.getParameter("edit");
        Long commentId = this.comment.getId();
        
        return UrlConstants.EDIT_COMMENT_ADMIN_URL + "&id=" + issueId + "&edit=" + editParameter +
                "&commentid=" + commentId;
    }
    
    public String updateAction() {
        if (!validate()) {
            return null;
        }
        
        commentDaoService.update(this.comment);
        
        return UrlConstants.UPDATE_COMMENT_AUTH_URL;
    }
    
    public String updateAdminAction() {
        if (!validate()) {
            return null;
        }
        
        commentDaoService.update(this.comment);
        
        return UrlConstants.UPDATE_COMMENT_ADMIN_URL;
    }
    
    public CommentModel getComment() {
        return this.comment;
    }
    
    public void setComment(CommentModel comment) {
        this.comment = comment;
    }
    
    public boolean validate() {
        boolean isValid = ValidateComment.validate(this.comment);
        
        return isValid;
    }
    
    public boolean hasErrors() {
        boolean hasErrors = ContextCheck.hasErrors();
        
        return hasErrors;
    }
}
