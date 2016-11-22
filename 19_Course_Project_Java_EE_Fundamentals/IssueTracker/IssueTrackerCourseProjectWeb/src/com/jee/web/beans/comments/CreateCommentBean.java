package com.jee.web.beans.comments;

import java.io.IOException;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;

import com.jee.entity.CommentModel;
import com.jee.entity.IssueModel;
import com.jee.entity.UserModel;
import com.jee.service.CommentDaoServiceLocal;
import com.jee.service.IssueDaoServiceLocal;
import com.jee.web.constants.UrlConstants;
import com.jee.web.utils.ContextCheck;
import com.jee.web.utils.GeneralUtils;
import com.jee.web.utils.validation.ValidateComment;

@ManagedBean(name = "createCommentBean")
@ViewScoped
public class CreateCommentBean implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Inject
    private HttpServletRequest request;
    
    @EJB
    CommentDaoServiceLocal commentDaoService;
    
    @EJB
    IssueDaoServiceLocal issueDaoService;
    
    private CommentModel comment;
    private Long issueId;
    private String operationType;
    
    @PostConstruct
    public void init() {
        this.comment = new CommentModel();
        
        String editParameter = request.getParameter("edit");
        
        if ("true".equals(editParameter)) {
            String idParameter = request.getParameter("commentid");
            
            if (StringUtils.isNotBlank(idParameter) && StringUtils.isNumeric(idParameter)) {
                Long id = Long.valueOf(idParameter);
                
                this.comment = commentDaoService.findById(id);
                operationType = "edit";
            }
        } else {
            UserModel user = (UserModel) GeneralUtils.getLoggedUser(request);
            
            if (user != null) {
                this.comment.setCommentator(user.getUsername());
            }
        }
    }
    
    public String createSimpleAction() throws IOException {
        if (!validate()) {
            return null;
        }
        
        String idParameter = request.getParameter("issueid");
        
        if (StringUtils.isNotBlank(idParameter) && StringUtils.isNumeric(idParameter)) {
            issueId = Long.valueOf(idParameter);
        }
        
        IssueModel issue = issueDaoService.findById(this.issueId);
        this.comment.setIssue(issue);
        
        commentDaoService.save(this.comment);
        
        return UrlConstants.UPDATE_COMMENT_URL + "&id=" + this.issueId;
    }
    
    public String createAction() {
        if (!validate()) {
            return null;
        }
        
        String idParameter = request.getParameter("issueid");
        
        if (StringUtils.isNotBlank(idParameter) && StringUtils.isNumeric(idParameter)) {
            issueId = Long.valueOf(idParameter);
        }
        
        IssueModel issue = issueDaoService.findById(this.issueId);
        this.comment.setIssue(issue);
        
        commentDaoService.save(this.comment);
        
        return UrlConstants.UPDATE_COMMENT_AUTH_URL + "&id=" + this.issueId;
    }
    
    public String createAdminAction() {
        if (!validate()) {
            return null;
        }
        
        String idParameter = request.getParameter("issueid");
        
        if (StringUtils.isNotBlank(idParameter) && StringUtils.isNumeric(idParameter)) {
            issueId = Long.valueOf(idParameter);
        }
        
        IssueModel issue = issueDaoService.findById(this.issueId);
        this.comment.setIssue(issue);
        
        if ("edit".equals(operationType)) {
            commentDaoService.update(this.comment);
        } else {
            commentDaoService.save(this.comment);
        }
        
        return UrlConstants.UPDATE_COMMENT_ADMIN_URL + "&id=" + this.issueId;
    }
    
    public CommentModel getComment() {
        return this.comment;
    }
    
    public void setComment(CommentModel comment) {
        this.comment = comment;
    }
    
    public String getOperationType() {
        return this.operationType;
    }
    
    public void setOperationType(String operationType) {
        this.operationType = operationType;
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
