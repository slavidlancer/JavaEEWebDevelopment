package com.jeewd.web_store.entities.user;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
//import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import com.jeewd.web_store.entities.customer.Customer;

@Entity
@Table(name = "USERS")
public class User {
    @Id
    /*@SequenceGenerator(name = "user_gen", sequenceName = "user_seq",
            initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "user_gen")*/
    @Column(name = "ID")
    private Long id;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "NAME")
    private Customer customer;
    @Column(name = "USERNAME")
    private String username;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "STATUS")
    private String status;
    @ManyToMany //(fetch = FetchType.EAGER)
    @JoinTable(name = "USER_ROLES",
            joinColumns = {@JoinColumn(name = "USER_ID",
                    referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "ROLE_ID",
                    referencedColumnName = "ID")})
    private List<Role> roles;
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Customer getName() {
        return customer;
    }
    
    public void setName(Customer customer) {
        this.customer = customer;
    }
    
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public List<Role> getRoles() {
        return roles;
    }
    
    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
