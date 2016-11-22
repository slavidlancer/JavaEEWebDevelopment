package com.jee.web.beans.users;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;

import com.jee.entity.UserModel;
import com.jee.service.UserDaoServiceLocal;
import com.jee.web.constants.UrlConstants;

@ManagedBean(name = "deleteUserBean")
@ViewScoped
public class DeleteUserBean implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Inject
    private HttpServletRequest request;
    
    @EJB
    UserDaoServiceLocal userDaoService;
    
    private UserModel user;
    
    @PostConstruct
    public void init() {
        String idParameter = request.getParameter("id");
        
        if (StringUtils.isNotBlank(idParameter) && StringUtils.isNumeric(idParameter)) {
            Long id = Long.valueOf(idParameter);
            
            this.user = userDaoService.findById(id);
        }
    }
    
    public String deleteAction() {
        userDaoService.delete(this.user);
        
        return UrlConstants.UPDATE_USER_ADMIN_URL;
    }
    
    public String deleteByIdAction(Long id) {
        userDaoService.deleteById(id);
        
        return UrlConstants.UPDATE_USER_ADMIN_URL;
    }
}
