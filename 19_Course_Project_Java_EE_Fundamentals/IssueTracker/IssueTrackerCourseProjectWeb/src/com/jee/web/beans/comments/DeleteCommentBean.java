package com.jee.web.beans.comments;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;

import com.jee.entity.CommentModel;
import com.jee.service.CommentDaoServiceLocal;
import com.jee.web.constants.UrlConstants;

@ManagedBean(name = "deleteCommentBean")
@ViewScoped
public class DeleteCommentBean implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Inject
    private HttpServletRequest request;
    
    @EJB
    CommentDaoServiceLocal commentDaoService;
    
    private CommentModel comment;
    
    @PostConstruct
    public void init() {
        String idParameter = request.getParameter("id");
        
        if (StringUtils.isNotBlank(idParameter) && StringUtils.isNumeric(idParameter)) {
            Long id = Long.valueOf(idParameter);
            
            this.comment = commentDaoService.findById(id);
        }
    }
    
    public String deleteAction() {
        commentDaoService.delete(this.comment);
        
        return UrlConstants.UPDATE_COMMENT_ADMIN_URL;
    }
    
    public String deleteByIdAction(Long id) {
        Long issueId = this.comment.getIssue().getId();
        commentDaoService.deleteById(id);
        
        return UrlConstants.UPDATE_COMMENT_ADMIN_URL + "&id=" + issueId;
    }
    
    public CommentModel getComment() {
        return this.comment;
    }
    
    public void setComment(CommentModel comment) {
        this.comment = comment;
    }
}
