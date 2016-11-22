package com.jee.web.beans.issues;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;

import com.jee.entity.IssueModel;
import com.jee.service.IssueDaoServiceLocal;
//import com.jee.web.constants.UrlConstants;
/*import com.jee.web.utils.ContextCheck;
import com.jee.web.utils.GeneralUtils;
import com.jee.web.utils.ValidateUser;*/

@ManagedBean(name = "viewIssueBean")
@ViewScoped
public class ViewIssueBean implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Inject
    private HttpServletRequest request;
    
    @EJB
    IssueDaoServiceLocal issueDaoService;
    
    private IssueModel issue;
    
    @PostConstruct
    public void init() {
        String idParameter = request.getParameter("id");
        
        if (StringUtils.isNotBlank(idParameter) && StringUtils.isNumeric(idParameter)) {
            Long id = Long.valueOf(idParameter);
            
            this.issue = issueDaoService.findById(id);
        }
    }
    
    /*public String updateAction() {
        if (!validate()) {
            return null;
        }
        
        issueService.update(this.issue);
        
        return UrlConstants.UPDATE_ISSUE_URL;
    }*/
    
    public IssueModel getIssue() {
        return this.issue;
    }
    
    public void setIssue(IssueModel issue) {
        this.issue = issue;
    }
    
    /*public boolean validate() {
        boolean isValid = ValidateUser.validate(this.user);
        
        return isValid;
    }
    
    public boolean hasErrors() {
        boolean hasErrors = ContextCheck.hasErrors();
        
        return hasErrors;
    }*/
}
