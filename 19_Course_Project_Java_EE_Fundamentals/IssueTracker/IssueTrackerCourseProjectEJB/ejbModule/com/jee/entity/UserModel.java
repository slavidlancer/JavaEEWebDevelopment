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
@Table(name = "users")
public class UserModel extends BaseDomainObject {

    private static final long serialVersionUID = 1L;
    
    private String username;
    private String password;
    private String fullName;
    private String email;
    private List<IssueModel> issues;
    private Long issuesCount;
    
    public UserModel() {}
    
    public UserModel(Long id, String username, String password, String fullName, String email) {
        super();
        this.id = id;
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.email = email;
    }
    
    public UserModel(Long id, String username, String password, String fullName, String email, Long issuesCount) {
        super();
        this.id = id;
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.email = email;
        this.issuesCount = issuesCount;
    }
    
    @Column(name = "username", length = 100, nullable = false)
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    @Column(name = "password", length = 200, nullable = false)
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    @Column(name = "full_name", length = 200, nullable = true)
    public String getFullName() {
        return this.fullName;
    }
    
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    
    @Column(name = "email", length = 200, nullable = true)
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "author", fetch = FetchType.LAZY)
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
    public int hashCode() {
        int hash = 0;
        hash += (this.id != null ? this.id.hashCode() : 0);
        
        return hash;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof UserModel)) {
            return false;
        }
        
        UserModel other = (UserModel) obj;
        
        if (((this.id == null) && (other.id != null)) ||
                ((this.id != null) && !this.id.equals(other.id))) {
            return false;
        }
        
        return true;
    }
    
    @Override
    public String toString() {
        String value = "User[id = " + this.id + ", username = " + this.username +
                ", password = " + this.password + ", full name = " + this.fullName +
                ", e-mail = " + this.email + "]";
        
        return value;
    }
}
