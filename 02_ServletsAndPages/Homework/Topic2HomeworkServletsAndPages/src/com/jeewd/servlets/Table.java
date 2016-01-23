package com.jeewd.servlets;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Table
 */
@WebServlet("/Table")
public class Table extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Table() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().print(formatTable());
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    private String formatTable() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<html>");
        stringBuilder.append("<head><title>").append("Table Servlet").
            append("</title></head>");
        stringBuilder.append("<body>");
        stringBuilder.append("<table border=\"1\" class=\"width: 100%\">" +
                "<tbody><tr><th>Topic</th><th>Date</th></tr><tr>" +
                "<td>Java Web Development</td>" + "<td>" + new Date() +
                "</td></tr></tbody></table>");
        stringBuilder.append("</body>");
        stringBuilder.append("</html>");

        return stringBuilder.toString();
    }
}
