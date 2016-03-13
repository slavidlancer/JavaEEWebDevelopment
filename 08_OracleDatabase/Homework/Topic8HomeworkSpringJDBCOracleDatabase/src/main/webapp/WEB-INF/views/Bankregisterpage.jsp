<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="ct" uri="http://jdbc_bank.jeewd.com/tags" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:set var="areAccountsPresent" value="false"/>

<ct:Page title="Web Bank: Bank Register Page"
    projectName="Topic8HomeworkSpringJDBCOracleDatabase"
    currentVersion="1.0.0">
  <jsp:body>
    <table border="1">
      <thead>
        <tr align="center">
          <th>Username</th>
          <th>Account Number</th>
          <th>Current Amount</th>
          <th>Account Currency</th>
          <th>Created By</th>
        </tr>
      </thead>
      <sec:authorize access="hasRole('ROLE_BANK_EMPLOYEE')">
        <c:if test="${not empty accounts}">
          <tbody>
            <c:forEach var="a" items="${accounts}">
              <tr align="center">
                <td>${a.username}</td>
                <td>${a.number}</td>
                <td>${a.amount}</td>
                <td>${a.currency}</td>
                <td>${a.createdBy}</td>
              </tr>
              <c:set var="areAccountsPresent" value="true"/>
            </c:forEach>
          </tbody>
        </c:if>
      </sec:authorize>
      <sec:authorize access="hasRole('ROLE_USER')">
        <sec:authorize access="!hasRole('ROLE_BANK_EMPLOYEE')">
          <c:if test="${not empty accounts}">
            <tbody>
              <c:forEach var="a" items="${accounts}">
                <c:if test="${user.username == a.username}">
                  <tr align="center">
                    <td>${a.username}</td>
                    <td>${a.number}</td>
                    <td>${a.amount}</td>
                    <td>${a.currency}</td>
                    <td>${a.createdBy}</td>
                  </tr>
                  <c:set var="areAccountsPresent" value="true"/>
                </c:if>
              </c:forEach>
            </tbody>
          </c:if>
        </sec:authorize>
      </sec:authorize>
    </table>
    <br>
    <sec:authorize access="hasRole('ROLE_USER')">
      <c:if test="${not empty accounts}">
        <c:if test="${areAccountsPresent}">
          <br>
          <input type="button" value="Operation"
              onclick="location='${contextPath}${operationUrl}'">
          &nbsp;
        </c:if>
      </c:if>
    </sec:authorize>
    <sec:authorize access="hasRole('ROLE_BANK_EMPLOYEE')">
      <input type="button" value="New Account"
          onclick="location='${contextPath}${createAccountUrl}'">
    </sec:authorize>
    <br><br>
    ${user.username} (logged in)&nbsp;
    <input type="button" value="Logout"
        onclick="location='${contextPath}/logout'">
    <br>
  </jsp:body>
</ct:Page>