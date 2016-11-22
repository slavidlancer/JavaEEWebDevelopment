package com.jee.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.jee.entity.base.BaseDomainObject;

@Entity
@Table(name = "comments")
public class CommentModel extends BaseDomainObject {

    private static final long serialVersionUID = 1L;
    
    private String comment;
    private String commentator;
    private IssueModel issue;
    
    public CommentModel() {}
    
    public CommentModel(Long id, String comment, String commentator, IssueModel issue) {
        super();
        this.id = id;
        this.comment = comment;
        this.commentator = commentator;
        this.issue = issue;
    }
    
    @Column(name = "comment", columnDefinition = "TEXT", nullable = false)
    public String getComment() {
        return comment;
    }
    
    public void setComment(String comment) {
        this.comment = comment;
    }
    
    @Column(name = "commentator", length = 200, nullable = false)
    public String getCommentator() {
        return commentator;
    }
    
    public void setCommentator(String commentator) {
        this.commentator = commentator;
    }
    
    @JoinColumn(name = "issue_id", referencedColumnName = "id")
    @ManyToOne
    public IssueModel getIssue() {
        return issue;
    }
    
    public void setIssue(IssueModel issue) {
        this.issue = issue;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.id != null ? this.id.hashCode() : 0);
        
        return hash;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof CommentModel)) {
            return false;
        }
        
        CommentModel other = (CommentModel) obj;
        
        if (((this.id == null) && (other.id != null)) ||
                ((this.id != null) && !this.id.equals(other.id))) {
            return false;
        }
        
        return true;
    }
    
    @Override
    public String toString() {
        String value = "Comment[id = " + this.id + ", comment = " + this.comment +
                ", commentator = " + this.commentator + ", issue id = " + this.issue.getId() + "]";
        
        return value;
    }
}
