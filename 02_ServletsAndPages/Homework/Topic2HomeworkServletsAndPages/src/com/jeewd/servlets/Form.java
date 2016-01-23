package com.jeewd.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Form
 */
@WebServlet("/Form")
public class Form extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Form() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().print(formatForm());
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
    
    private String formatForm() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<!DOCTYPE html>");
        stringBuilder.append("<html>");
        stringBuilder.append("<head><title>").append("Form Servlet").
            append("</title></head>");
        stringBuilder.append("<body>");
        stringBuilder.append("<form>");
        stringBuilder.append("ID:<br><input type=\"text\" name=\"id\">");
        stringBuilder.append("<br>");
        stringBuilder.append("Topic:<br><input type=\"text\" name=\"topic\">");
        stringBuilder.append("<br>");
        stringBuilder.append("Date:<br><input type=\"text\" name=\"date\">");
        stringBuilder.append("<br><br>");
        stringBuilder.append("<input type=\"submit\" value=\"Submit\">");
        stringBuilder.append("&nbsp&nbsp");
        stringBuilder.append("<input type=\"button\" value=\"Cancel\">");
        stringBuilder.append("</form>");
        stringBuilder.append("</body>");
        stringBuilder.append("</html>");

        return stringBuilder.toString();
    }
}
