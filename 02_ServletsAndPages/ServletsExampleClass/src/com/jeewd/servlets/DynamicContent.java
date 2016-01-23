package com.jeewd.servlets;

import java.io.IOException;
import java.util.Date;

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
        
        response.getWriter().println(formatDynamicContent(
                (Integer) request.getSession().getAttribute("COUNTER")));
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
    
    private String formatDynamicContent(int count) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<html>");
        stringBuilder.append("<head><title>").append("Dynamic Servlet").
            append("</title></head>");
        stringBuilder.append("<body>");
        stringBuilder.append("<h2>timestamp: " + new Date() + "<br>").
            append("times: " + count + "</h2>");
        stringBuilder.append("</body>");
        stringBuilder.append("<html>");
        
        return stringBuilder.toString();
    }
}
