<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Student addition</title>
</head>
<body>
<h1>Student addition!</h1>
<form:form method="POST" action="${contextPath}/addStudentSave"
    modelAttribute="student">
  <table>
    <tr>
      <td>Faculty Number</td>
      <td><input type="text" name="facultyNumber"></td>
      <td>Name</td>
      <td><input type="text" name="name" value="${student.name}"></td>
    </tr>
  </table>
  <input type="submit" id="buttonsubmit" name="Submit"/>
</form:form>
</body>
</html>