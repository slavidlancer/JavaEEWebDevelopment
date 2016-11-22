package com.jee.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.jee.entity.base.BaseDomainObject;

@Entity
@Table(name = "states")
public class StateModel extends BaseDomainObject {

    private static final long serialVersionUID = 1L;
    
    private String state;
    private List<IssueModel> issues;
    private Long issuesCount;
    
    public StateModel() {}
    
    public StateModel(Long id, String state) {
        super();
        this.id = id;
        this.state = state;
    }
    
    public StateModel(Long id, String state, Long issuesCount) {
        super();
        this.id = id;
        this.state = state;
        this.issuesCount = issuesCount;
    }
    
    @Column(name = "type", length = 100, nullable = false)
    public String getState() {
        return this.state.toUpperCase();
    }
    
    public void setState(String state) {
        this.state = state;
    }
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "state", fetch = FetchType.LAZY)
    public List<IssueModel> getIssues() {
        return this.issues;
    }

    public void setIssues(List<IssueModel> issues) {
        this.issues = issues;
    }
    
    @Transient
    public Long getIssuesCount() {
        return this.issuesCount;
    }
    
    public void setIssuesCount(Long issuesCount) {
        this.issuesCount = issuesCount;
    }
    
    @Override
    public String toString() {
        String value = "State[id = " + this.id + ", state = " + this.state + "]";
        
        return value;
    }
}
