<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="ct" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>CoursePage</title>
  </head>
  <body>
    <ct:Header title="CoursePage"/>
    <table border="1">
      <thead>
        <tr>
          <th>Topic</th>
          <th>Date</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td>Web Basics</td>
          <td><%= new java.util.Date() %></td>
        </tr>
        <tr>
          <td>Servlets and Pages</td>
          <td><%= new java.util.Date() %></td>
        </tr>
      </tbody>
    </table>
    <ct:Footer/>
  </body>
</html>