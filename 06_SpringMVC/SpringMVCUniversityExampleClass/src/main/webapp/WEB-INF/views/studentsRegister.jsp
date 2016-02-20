<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Students Register</title>
</head>
<body>
<h1>Students Register</h1>
<button type="button" onclick="location='${contextPath}${addStudentUrl}'">
  Add Student
</button><br>
<table border="1">
  <thead>
    <tr>
      <th>Student Faculty Number</th>
      <th>Student Name</th>
    </tr>
  </thead>
  <c:if test="${not empty students}">
    <tbody>
      <c:forEach var="s" items="${students}">
        <tr>
          <td>${s.facultyNumber}</td>
          <td>${s.name}</td>
        </tr>
      </c:forEach>
    </tbody>
  </c:if>
</table>
</body>
</html>