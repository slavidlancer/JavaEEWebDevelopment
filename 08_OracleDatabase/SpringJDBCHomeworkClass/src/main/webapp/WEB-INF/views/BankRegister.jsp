<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<title>Bank Registry</title>
</head>
<body>
<h1>Bank Registry</h1>
<button type="button" onclick="location='${contextPath}/addAccount'">
    Bank Operation
  </button>
<table border="1">
  <thead>
    <tr>
      <th>Username</th>
      <th>Account Number</th>
      <th>Amount</th>
      <th>Currency</th>
      <th>Created By</th>
    </tr>
  </thead>
  <c:if test="${not empty accounts}">
    <tbody>
      <c:forEach var="s" items="${accounts}">
        <tr>
          <td>${s.username}</td>
          <td>${s.accountNumber}</td>
          <td>${s.amount}</td>
          <td>${s.currency}</td>
          <td>${s.createdBy}</td>
        </tr>
      </c:forEach>
    </tbody>
  </c:if>
</table>
</body>
</html>