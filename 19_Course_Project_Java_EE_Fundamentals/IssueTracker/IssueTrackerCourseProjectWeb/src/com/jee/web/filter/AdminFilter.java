package com.jee.web.filter;

import java.io.IOException;
import java.io.Serializable;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.jee.entity.UserModel;
import com.jee.web.constants.UrlConstants;
import com.jee.web.utils.GeneralUtils;

public class AdminFilter implements Filter, Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Override
    public void destroy() {}
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
            throws IOException, ServletException {
        
        UserModel loggedUser = GeneralUtils.getLoggedUser(request);
        
        if (loggedUser == null) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher(
                    UrlConstants.PATH_LOGIN);
            requestDispatcher.forward(request, response);
            
            return;
        } else if ((loggedUser.getUsername() != null) && !loggedUser.getUsername().contains("admin")) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher(
                    UrlConstants.PATH_LOGIN);
            requestDispatcher.forward(request, response);
            
            return;
        } else {
            filterChain.doFilter(request, response);
            
            return;
        }
    }
    
    @Override
    public void init(FilterConfig arg0) throws ServletException {}
}
