package com.jee.web.beans.comments;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.jee.entity.CommentModel;
import com.jee.service.CommentDaoServiceLocal;

@ManagedBean(name = "listCommentBean")
@ViewScoped
public class ListCommentBean implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @EJB
    CommentDaoServiceLocal commentDaoService;
    
    @PostConstruct
    public void init() {}
    
    public List<CommentModel> getAllComments() {
        return commentDaoService.findAllComments();
    }
    
    public List<CommentModel> getAllCommentsForIssueById(Long id) {
        return commentDaoService.findAllCommentsForIssueById(id);
    }
}
