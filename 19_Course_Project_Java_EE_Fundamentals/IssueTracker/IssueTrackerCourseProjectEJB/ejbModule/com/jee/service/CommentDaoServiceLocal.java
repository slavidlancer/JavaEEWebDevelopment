package com.jee.service;

import java.util.List;

import javax.ejb.Local;

import com.jee.entity.CommentModel;

@Local
public interface CommentDaoServiceLocal {
    
    List<CommentModel> findAllComments();
    
    List<CommentModel> findAllCommentsForIssueById(Long id);
    
    CommentModel findById(Long id);
    
    CommentModel save(CommentModel entity);
    
    CommentModel update(CommentModel entity);
    
    void delete(CommentModel entity);
    
    void deleteById(Long id);
}
