package com.jeewd.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(urlPatterns = "/pages/*")
public class SecurityFilter implements Filter {
    private static final String USER_NAME = "admin";
    private static final String PASS_WORD = "1234";
    
    @Override
    public void destroy() {}

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
        String userName = request.getParameter("username");
        String passWord = request.getParameter("password");
        
        if ((userName != null) && (passWord != null)) {
            if (SecurityFilter.USER_NAME.equals(userName) &&
                    SecurityFilter.PASS_WORD.equals(passWord)) {
                ((HttpServletRequest) request).getSession().setAttribute(
                        "username", userName);
                ((HttpServletResponse) response).sendRedirect(
                        "/FiltersHomeworkClass/pages/HomePage.jsp");
            } else {
                ((HttpServletResponse) response).sendRedirect(
                        "/FiltersHomeworkClass/Login.jsp");
            }
        } else {
            userName = (String) ((HttpServletRequest) request).getSession().
                    getAttribute("username");
            
            if (userName == null) {
                ((HttpServletResponse) response).sendRedirect(
                        "/FiltersHomeworkClass/Login.jsp");
            }
        }
        
        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {}
}
