package com.jee.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.jee.entity.base.BaseDomainObject;

@Entity
@Table(name = "USERS")
public class UserModel extends BaseDomainObject {

    private static final long serialVersionUID = 1L;
    
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private List<PostModel> posts;
    //private transient int numberOfPosts;
    
    public UserModel() {}
    
    public UserModel(Long id, String username, String password, String firstName, String lastName, String email,
            List<PostModel> posts) {
        super();
        this.id = id;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.posts = posts;
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
}
