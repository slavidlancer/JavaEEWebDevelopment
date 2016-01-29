package com.jeewd.servlets;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

/**
 * Servlet implementation class DynamicServlet
 */
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
        
    }
}
