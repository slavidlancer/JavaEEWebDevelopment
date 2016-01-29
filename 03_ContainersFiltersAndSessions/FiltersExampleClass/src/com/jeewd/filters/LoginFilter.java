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

@WebFilter("/DynamicServlet")
public class LoginFilter implements Filter {
    @Override
    public void destroy() {}

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String username = (String) httpRequest.getSession().
                getAttribute("username");
        String requestUserName = request.getParameter("user");
        
        if ((username == null) && (requestUserName == null)) {
            ((HttpServletResponse) response).sendRedirect("login.html");
        } else if (requestUserName != null) {
            httpRequest.getSession().setAttribute("username", requestUserName);
        }
        
        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {}
}
