<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ct" uri="http://servlets.jeewd.com/tags" %>

<ct:Page title="LoginForm"
    projectName=""
    currentVersion="">
  <jsp:body>
    <form method="post">
      Username:
      <br>
      <input type="text" name="username">
      <br>
      Password:
      <br>
      <input type="password" name="password">
      <br><br>
      <input type="submit" value="Submit">
    </form>
  </jsp:body>
</ct:Page>