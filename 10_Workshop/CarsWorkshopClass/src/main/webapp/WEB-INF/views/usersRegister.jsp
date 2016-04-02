<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<title>User Registry</title>
</head>
<body>
<h1>User Registry</h1>
<sec:authorize access="hasRole('ROLE_ADMIN')">
  <button type="button" onclick="location='${contextPath}/addUser'">
    Add User
  </button>
  <button type="button" onclick="location='${contextPath}${addUserUrl}'">
    Add User (constant URL)
  </button>
</sec:authorize>
<form:form method="GET" action="${contextPath}${usersRegisterUrl}"
  modelAttribute="UserSearch">
 <table>
  <tr>
   <td>Username</td>
   <td><input type="text" name="username"><td>
   <td>Status</td>
   <td><input type="text" name="status"><td>
  </tr>
 </table>
 <input type=submit id="button_search" name="Search"/>
</form:form>
<br>
<table border="1">
  <thead>
    <tr>
      <th>Username</th>
      <th>Status</th>
    </tr>
  </thead>
  <c:if test="${not empty users}">
    <tbody>
      <c:forEach var="u" items="${users}">
        <tr>
          <td>${u.username}</td>
          <td>${u.status}</td>
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