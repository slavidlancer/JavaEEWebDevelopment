<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<title>Student Registry</title>
</head>
<body>
<h1>Student Registry</h1>
<sec:authorize access="hasRole('ROLE_USER')">
  <button type="button" onclick="location='${contextPath}/addStudent'">
    Add Student
  </button>
  <button type="button" onclick="location='${contextPath}${addStudentUrl}'">
    Add Student (constant URL)
  </button>
</sec:authorize>
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
<div>Username: ${user.username}</div>
<button type="button" onclick="location='${contextPath}/logout'">
  Logout
</button>
</body>
</html>