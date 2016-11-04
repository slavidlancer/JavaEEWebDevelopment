package com.jee.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.jee.entity.base.BaseDomainObject;

@Entity
@Table(name = "POSTS")
public class PostModel extends BaseDomainObject {

    private static final long serialVersionUID = 1L;
    
    private String title;
    private String content;
    private Date date;
    private UserModel author;
    
    public PostModel() {}
    
    public PostModel(Long id, String title, String content, Date date, UserModel author) {
        super();
        this.id = id;
        this.title = title;
        this.content = content;
        this.date = date;
        this.author = author;
    }
    
    @Column(name = "title", length = 300, nullable = false)
    public String getTitle() {
        return this.title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    @Column(name = "content", length = 500, nullable = false)
    public String getContent() {
        return this.content;
    }
    
    public void setContent(String content) {
        this.content = content;
    }
    
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    public Date getDate() {
        return this.date;
    }
    
    public void setDate(Date date) {
        this.date = date;
    }
    
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne
    public UserModel getAuthor() {
        return this.author;
    }
    
    public void setAuthor(UserModel author) {
        this.author = author;
    }
}
