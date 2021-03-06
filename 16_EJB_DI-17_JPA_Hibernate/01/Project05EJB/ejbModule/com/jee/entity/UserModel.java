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
    private String firstName;
    private String lastName;
    private String email;
    private List<PostModel> posts;
    private Long postsCount;
    
    public UserModel() {}
    
    public UserModel(Long id, String username, String password, String firstName, String lastName, String email) {
        super();
        this.id = id;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
    
    public UserModel(Long id, String username, String password, String firstName, String lastName, String email,
            Long postsCount) {
        super();
        this.id = id;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.postsCount = postsCount;
    }
    
    @Column(name = "username", length = 30, nullable = false)
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    @Column(name = "password", length = 100, nullable = true)
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    @Column(name = "first_name", length = 100, nullable = true)
    public String getFirstName() {
        return this.firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    @Column(name = "last_name", length = 100, nullable = true)
    public String getLastName() {
        return this.lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    @Column(name = "email", length = 150, nullable = true)
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "author", fetch = FetchType.LAZY)
    public List<PostModel> getPosts() {
        return this.posts;
    }
    
    public void setPosts(List<PostModel> posts) {
        this.posts = posts;
    }
    
    @Transient
    public Long getPostsCount() {
        return this.postsCount;
    }
    
    public void setPostsCount(Long postsCount) {
        this.postsCount = postsCount;
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
        String value = "User[id = " + this.id + "]";
        
        return value;
    }
}
