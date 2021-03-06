<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ct" uri="http://jdbc_bank.jeewd.com/tags" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<ct:Page title="Web Bank: Login Page"
    projectName="Topic8HomeworkSpringJDBCOracleDatabase"
    currentVersion="1.0.0">
  <jsp:body>
    <form action="${contextPath}/login" method="post">
      <ct:VerticalTableHeading>
        <jsp:attribute name="row1-title">
          Username:
        </jsp:attribute>
        <jsp:attribute name="row1-value">
          <input type="text" id="username" name="username">
        </jsp:attribute>
        <jsp:attribute name="row2-title">
          Password:
        </jsp:attribute>
        <jsp:attribute name="row2-value">
          <input id="password" name="password" type="password"/>
        </jsp:attribute>
        <jsp:attribute name="row3-title"/>
        <jsp:attribute name="row3-value">
          <input name="submit" type="submit" value="Login"/>
        </jsp:attribute>
      </ct:VerticalTableHeading>
      <%-- <input type="hidden" name="${_csrf.parameterName}"
      value="${_csrf.token}"/> --%>
    </form>
    <br><br>
    1 user with ROLE_BANK_EMPLOYEE<br>
    &nbsp;&nbsp;&nbsp;&nbsp;Database ID: 1<br>
    &nbsp;&nbsp;&nbsp;&nbsp;username: admin<br>
    &nbsp;&nbsp;&nbsp;&nbsp;password: 1<br><br>
    2 users with ROLE_USER<br>
    &nbsp;&nbsp;&nbsp;&nbsp;Database ID: 2<br>
    &nbsp;&nbsp;&nbsp;&nbsp;username: user<br>
    &nbsp;&nbsp;&nbsp;&nbsp;password: 12<br><br>
    &nbsp;&nbsp;&nbsp;&nbsp;Database ID: 3<br>
    &nbsp;&nbsp;&nbsp;&nbsp;username: user02<br>
    &nbsp;&nbsp;&nbsp;&nbsp;password: 12<br>
    <br><br>
  </jsp:body>
</ct:Page>