package com.jeewd.servlets;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;

@WebServlet("/DynamicServlet")
public class DynamicServlet implements Servlet {
    @Override
    public void destroy() {}

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void init(ServletConfig arg0) throws ServletException {}

    @Override
    public void service(ServletRequest request, ServletResponse response)
            throws ServletException, IOException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        response.getWriter().println(httpServletRequest.getSession().getId());
        httpServletRequest.getSession().setAttribute("testAttr", "test");
        httpServletRequest.getSession().invalidate();
    }
}
