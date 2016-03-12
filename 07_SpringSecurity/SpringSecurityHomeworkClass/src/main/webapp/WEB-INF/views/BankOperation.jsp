<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Web Bank</title>
</head>
<body>
<form:form action="/thebank/bankOp" method="post" modelAttribute="bankOp">
  Client: <input type="text" name="client" value="${bankOp.client}">
  <br><br>
  Current amount: <input type="text" name="currentAmount"
      value="${currentAmount}"><br><br>
  Operation: <input type="text" name="operation"><br><br>
  Amount: <input type="text" name="amount"><br><br>
  Currency: <input type="text" name="currency"><br><br>
  <input type="submit" value="Submit">
</form:form>
</body>
</html>