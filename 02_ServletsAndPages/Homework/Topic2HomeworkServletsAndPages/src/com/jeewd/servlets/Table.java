package com.jeewd.servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
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
        Date firstDate = getDateAndTimeAsObject("21.01.2016 18:00");
        Date secondDate = getDateAndTimeAsObject("28.01.2016 18:00");
        
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<!DOCTYPE html>");
        stringBuilder.append("<html>");
        stringBuilder.append("<head><title>").append("Table Servlet").
            append("</title></head>");
        stringBuilder.append("<body>");
        stringBuilder.append("<table border=\"1\" class=\"width: 100%\">");
        stringBuilder.append("<tbody><tr><th>Topic</th><th>Date</th></tr>");
        stringBuilder.append("<tr><td>Web Basics</td>");
        stringBuilder.append("<td>" + firstDate + "</td>");
        stringBuilder.append("</tr>");
        stringBuilder.append("<tr><td>Servlets and Pages</td>");
        stringBuilder.append("<td>" + secondDate + "</td>");
        stringBuilder.append("</tr>");
        stringBuilder.append("</tbody></table>");
        stringBuilder.append("</body>");
        stringBuilder.append("</html>");

        return stringBuilder.toString();
    }
    
    private Date getDateAndTimeAsObject(String date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
                "dd.MM.yyyy HH:mm");
        Date dateObject = null;
        
        try {
            dateObject = simpleDateFormat.parse(date);
        } catch (java.text.ParseException pe) {
            pe.printStackTrace();
        }
        
        return dateObject;
    }
}
