package com.jeewd.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/pages/Homepage.jsp")
public class SecurityFilter implements Filter {
    private final String USER_NAME = "nickname";
    private final String PASS_WORD = "0123456789";
    
    @Override
    public void destroy() {}

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpSession httpSession = httpRequest.getSession();
        String userName = (String) httpSession.getAttribute("username");
        String requestUserName = request.getParameter("user");
        String requestPassWord = request.getParameter("pwd");
        
        if ((requestUserName != null) && (requestPassWord != null)) {
            if (requestUserName.equals(USER_NAME) &&
                    requestPassWord.equals(PASS_WORD)) {
                httpSession.setAttribute("username", requestUserName);
                httpSession.setMaxInactiveInterval(30 * 60);
                Cookie userNameCookie = new Cookie("username", requestUserName);
                userNameCookie.setMaxAge(30 * 60);
                httpResponse.addCookie(userNameCookie);
                httpResponse.sendRedirect("Homepage.jsp");
            } else if (userName == null) {
                httpResponse.sendRedirect("Loginform.jsp");
            }
        } else if (userName == null) {
            httpResponse.sendRedirect("Loginform.jsp");
        }
        
        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig fConfig) throws ServletException {}
}
