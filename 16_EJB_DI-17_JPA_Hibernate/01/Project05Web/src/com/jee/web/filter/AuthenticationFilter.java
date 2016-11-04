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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.jee.entity.UserModel;
import com.jee.web.constants.UrlConstants;

public class AuthenticationFilter implements Filter, Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Override
    public void destroy() {}
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String requestedPath = httpRequest.getRequestURI().substring(
                httpRequest.getContextPath().length());
        
        if (UrlConstants.PATH_INDEX.equals(requestedPath)) {
            filterChain.doFilter(request, response);
            
            return;
        }
        
        if (UrlConstants.PATH_LOGIN.equals(requestedPath)) {
            filterChain.doFilter(request, response);
        
            return;
        }
        
        HttpSession Session = httpRequest.getSession();
        UserModel loggedUser = (UserModel) Session.getAttribute("LOGGED_USER");
        
        if (loggedUser == null) {
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
