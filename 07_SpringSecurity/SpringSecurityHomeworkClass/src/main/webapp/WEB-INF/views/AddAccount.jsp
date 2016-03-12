<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Account</title>
</head>
<body>
<h1>Add Account</h1>
<form:form method="POST" action="${contextPath}/addStudentPost"
    modelAttibute="account">
  <table>
    <tr>
      <td>Username</td>
      <td><input type="text" name="username"><td>
      <td>Account Number</td>
      <td><input type="text" name="accountNumber"><td>
      <td>Initial Amount</td>
      <td><input type="text" name="amount"><td>
      <td>Currency</td>
      <td><input type="text" name="currency"><td>
    </tr>
  </table>
  <input type=submit id="buttonsubmit" name="Submit"/>
</form:form>
</body>
</html>