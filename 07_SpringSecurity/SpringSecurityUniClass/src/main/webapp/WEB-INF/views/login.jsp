<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<title>Login</title>
</head>
<body>
<form name="login" action="${contextPath}/login" method="POST">
  <label>Username</label>
  <input id="username" name="username" type="text"/>
  <label>Password</label>
  <input id="password" name="password" type="password"/>
  <input name="submit" type="submit" value="Login"/>
  <%--<input type="hidden" name="${_csrf.parameterName}"
      value="${_csrf.token}"/> --%>
</form>
</body>
</html>