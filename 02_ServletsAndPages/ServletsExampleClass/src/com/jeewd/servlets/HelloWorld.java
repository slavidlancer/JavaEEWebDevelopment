package com.jeewd.servlets;

import java.io.IOException;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloWorld
 */
@WebServlet("/HelloWorld")
public class HelloWorld extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloWorld() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request,
	        HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(
		        request.getContextPath());
		response.getWriter().append(System.lineSeparator());
		response.getWriter().append("hello world");
		response.getWriter().append(System.lineSeparator());
		response.getWriter().append("the time/date: ").append(new Date().
		        toString());
		response.getWriter().append(System.lineSeparator());
		
		Integer count = (Integer) request.getSession().getAttribute("COUNTER");
        
        if (count == null) {
            count = 0;
        }
        
        response.getWriter().append(count.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request,
	        HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
