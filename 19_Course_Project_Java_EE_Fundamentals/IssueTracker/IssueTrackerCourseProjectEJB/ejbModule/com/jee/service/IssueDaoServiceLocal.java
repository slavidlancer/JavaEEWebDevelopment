package com.jee.service;

import java.util.List;

import javax.ejb.Local;

import com.jee.entity.IssueModel;

@Local
public interface IssueDaoServiceLocal {
    
    List<IssueModel> findAllIssues();
    
    List<IssueModel> findAllIssuesCommentsCount();
    
    Long findAllIssuesCount();
    
    Long findIssueCommentsCountById(Long id);
    
    IssueModel findById(Long id);
    
    List<IssueModel> findByState(String state);
    
    IssueModel save(IssueModel entity);
    
    IssueModel update(IssueModel entity);
    
    void delete(IssueModel entity);
    
    void deleteById(Long id);
}
