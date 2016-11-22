package com.jee.web.beans.issues;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import com.jee.entity.IssueModel;
import com.jee.service.IssueDaoServiceLocal;
import com.jee.web.constants.UrlConstants;

@ManagedBean(name = "listIssuesBean")
@ViewScoped
public class ListIssuesBean implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Inject
    private HttpServletRequest request;
    
    @EJB
    IssueDaoServiceLocal issueDaoService;
    
    private String state;
    
    @PostConstruct
    public void init() {
        this.state = request.getParameter("state");
    }
    
    public String listAllAction() {
        return UrlConstants.LIST_ISSUES_REDIRECT;
    }
    
    public String listAllAuthAction() {
        return UrlConstants.LIST_ISSUES_AUTH_REDIRECT;
    }
    
    public String listAllAdminAction() {
        return UrlConstants.LIST_ISSUES_ADMIN_REDIRECT;
    }
    
    public String listAction() {
        return UrlConstants.UPDATE_ISSUE_URL;
    }
    
    public String listAuthAction() {
        return UrlConstants.UPDATE_ISSUE_AUTH_URL;
    }
    
    public String listAdminAction() {
        return UrlConstants.UPDATE_ISSUE_ADMIN_URL;
    }
    
    public String listSimpleAction() {
        return UrlConstants.LIST_ISSUES_URL;
    }
    
    public String listSimpleAuthAction() {
        return UrlConstants.LIST_ISSUES_AUTH_URL;
    }
    
    public String listSimpleAdminAction() {
        return UrlConstants.LIST_ISSUES_ADMIN_URL;
    }
    
    public String viewAction() {
        return UrlConstants.VIEW_ISSUE_URL;
    }
    
    public String viewAuthAction() {
        return UrlConstants.VIEW_ISSUE_AUTH_URL;
    }
    
    public String viewAdminAction() {
        return UrlConstants.VIEW_ISSUE_ADMIN_URL;
    }
    
    public String editAction() {
        return UrlConstants.EDIT_ISSUE_URL;
    }
    
    public String editAdminAction() {
        return UrlConstants.EDIT_ISSUE_ADMIN_URL;
    }
    
    public String createAction() {
        return UrlConstants.CREATE_ISSUE_URL;
    }
    
    public String createAdminAction() {
        return UrlConstants.CREATE_ISSUE_ADMIN_URL;
    }
    
    public List<IssueModel> getAllIssues() {
        return issueDaoService.findAllIssues();
    }
    
    public List<IssueModel> getIssuesByState(String state) {
        return issueDaoService.findByState(state);
    }
    
    public Long getAllIssuesCount() {
        return issueDaoService.findAllIssuesCount();
    }
    
    public Long getIssueCommentsCountById(Long id) {
        return issueDaoService.findIssueCommentsCountById(id);
    }
    
    public String getState() {
        return this.state;
    }
    
    public void setState(String state) {
        this.state = state;
    }
}
