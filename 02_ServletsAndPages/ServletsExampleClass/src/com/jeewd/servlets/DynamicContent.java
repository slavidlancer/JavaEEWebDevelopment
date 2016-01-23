package com.jeewd.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DynamicContent
 */
@WebServlet("/DynamicContent")
public class DynamicContent extends HttpServlet {
    /**
     * 
     */
    private static final long serialVersionUID = 4643448211103623946L;
    
    public DynamicContent() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        
        Integer count = (Integer) request.getSession().getAttribute("COUNTER");
        
        if (count == null) {
            count = 0;
        }
        
        response.getWriter().append(count.toString());
        
        request.getSession().setAttribute("COUNTER", ++count);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
