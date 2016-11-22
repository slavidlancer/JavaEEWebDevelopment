package com.jee.entity;


import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.jee.entity.base.BaseDomainObject;

@Entity
@Table(name = "issues")
public class IssueModel extends BaseDomainObject {

    private static final long serialVersionUID = 1L;
    
    private String title;
    private String description;
    private UserModel author;
    private StateModel state;
    private Date submissionDateTime;
    private List<CommentModel> comments;
    private Long commentsCount;
    
    public IssueModel() {}
    
    public IssueModel(Long id, String title, String description, UserModel author, StateModel state,
            Date submissionDateTime) {
        super();
        this.id = id;
        this.title = title;
        this.description = description;
        this.author = author;
        this.state = state;
        this.submissionDateTime = submissionDateTime;
    }
    
    public IssueModel(Long id, String title, String description, UserModel author, StateModel state,
            Date submissionDateTime, Long commentsCount) {
        super();
        this.id = id;
        this.title = title;
        this.description = description;
        this.author = author;
        this.state = state;
        this.submissionDateTime = submissionDateTime;
        this.commentsCount = commentsCount;
    }
    
    @Column(name = "title", length = 500, nullable = false)
    public String getTitle() {
        return this.title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    @Column(name = "description", columnDefinition = "TEXT", nullable = false)
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne
    public UserModel getAuthor() {
        return this.author;
    }
    
    public void setAuthor(UserModel author) {
        this.author = author;
    }
    
    @JoinColumn(name = "state_id", referencedColumnName = "id")
    @ManyToOne
    public StateModel getState() {
        return this.state;
    }
    
    public void setState(StateModel state) {
        this.state = state;
    }
    
    @Column(name = "submission_date_time")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getSubmissionDateTime() {
        return this.submissionDateTime;
    }
    
    public void setSubmissionDateTime(Date submissionDateTime) {
        this.submissionDateTime = submissionDateTime;
    }
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "issue", fetch = FetchType.LAZY)
    public List<CommentModel> getComments() {
        return comments;
    }
    
    public void setComments(List<CommentModel> comments) {
        this.comments = comments;
    }
    
    @Transient
    public Long getCommentsCount() {
        return this.commentsCount;
    }
    
    public void setCommentsCount(Long commentsCount) {
        this.commentsCount = commentsCount;
    }
    
    @Override
    public String toString() {
        String value = "Issue[id = " + this.id + ", title = " + this.title +
                ", description = " + this.description + ", author = " + this.author +
                ", state = " + this.state + ", submission date and time = " +
                this.submissionDateTime + "]";
        
        return value;
    }
}
