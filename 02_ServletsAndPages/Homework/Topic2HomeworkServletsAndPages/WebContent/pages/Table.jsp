<%@ page import="java.util.*" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
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

    Date firstDate = getDateAndTimeAsObject("14.01.2016 18:00");
    Date secondDate = getDateAndTimeAsObject("28.01.2016 18:00");
%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Table JSP</title>
  </head>
  <body>
    <table border="1" class="width: 100%">
      <tbody>
        <tr>
          <th>Topic</th>
          <th>Date</th>
        </tr>
        <tr>
          <td>Web Development Basics</td>
          <td><%= firstDate %></td>
        </tr>
        <tr>
          <td>Servlets and Pages</td>
          <td><%= secondDate %></td>
        </tr>
      </tbody>
    </table>
  </body>
</html>