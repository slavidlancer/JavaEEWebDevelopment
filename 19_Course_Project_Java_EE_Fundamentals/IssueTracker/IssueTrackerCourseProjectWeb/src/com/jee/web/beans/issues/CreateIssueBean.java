package com.jee.web.beans.issues;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import com.jee.entity.IssueModel;
import com.jee.entity.StateModel;
import com.jee.entity.UserModel;
import com.jee.service.IssueDaoServiceLocal;
import com.jee.service.StateDaoServiceLocal;
import com.jee.web.constants.UrlConstants;
import com.jee.web.utils.ContextCheck;
import com.jee.web.utils.GeneralUtils;
import com.jee.web.utils.validation.ValidateIssue;

@ManagedBean(name = "createIssueBean")
@ViewScoped
public class CreateIssueBean implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Inject
    private HttpServletRequest request;
    
    @EJB
    IssueDaoServiceLocal issueDaoService;
    
    @EJB
    StateDaoServiceLocal stateDaoService;
    
    private IssueModel issue;
    private String operationType;
    
    @PostConstruct
    public void init() {
        this.issue = new IssueModel();
    }
    
    public String createAction() {
        if (!validate()) {
            return null;
        }
        
        UserModel user = (UserModel) GeneralUtils.getLoggedUser(request);
        this.issue.setAuthor(user);
        StateModel state = (StateModel) stateDaoService.findById((long) 1);
        this.issue.setState(state);
        this.issue.setSubmissionDateTime(new java.util.Date());
        issueDaoService.save(this.issue);
        
        return UrlConstants.UPDATE_ISSUE_AUTH_URL;
    }
    
    public String createAdminAction() {
        if (!validate()) {
            return null;
        }
        
        UserModel user = (UserModel) GeneralUtils.getLoggedUser(request);
        this.issue.setAuthor(user);
        StateModel state = (StateModel) stateDaoService.findById((long) 1);
        this.issue.setState(state);
        this.issue.setSubmissionDateTime(new java.util.Date());
        issueDaoService.save(this.issue);
        
        return UrlConstants.UPDATE_ISSUE_ADMIN_URL;
    }
    
    public IssueModel getIssue() {
        return this.issue;
    }
    
    public void setIssue(IssueModel issue) {
        this.issue = issue;
    }
    
    public String getOperationType() {
        return this.operationType;
    }
    
    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }
    
    public boolean validate() {
        boolean isValid = ValidateIssue.validate(this.issue);
        
        return isValid;
    }
    
    public boolean hasErrors() {
        boolean hasErrors = ContextCheck.hasErrors();
        
        return hasErrors;
    }
}
