<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="ct" uri="http://securebank.jeewd.com/tags" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<ct:Page title="Web Bank: Bank Register Page"
    projectName="Topic7HomeworkSpringSecurity"
    currentVersion="1.0.0">
  <jsp:body>
    <ct:VerticalTableHeading>
      <jsp:attribute name="row1-title">
        Username:
      </jsp:attribute>
      <jsp:attribute name="row1-value">
        ${user.username}
      </jsp:attribute>
      <jsp:attribute name="row2-title">
        Account Number:
      </jsp:attribute>
      <jsp:attribute name="row2-value">
        ${accounts.number}
      </jsp:attribute>
      <jsp:attribute name="row3-title">
        Current Amount:
      </jsp:attribute>
      <jsp:attribute name="row3-value">
        ${accounts.amount}
      </jsp:attribute>
      <jsp:attribute name="row4-title">
        Account Currency:
      </jsp:attribute>
      <jsp:attribute name="row4-value">
        ${accounts.currency}
      </jsp:attribute>
      <jsp:attribute name="row5-title">
        Created By:
      </jsp:attribute>
      <jsp:attribute name="row5-value">
        ${accounts.username}
      </jsp:attribute>
      <jsp:attribute name="row6-title"/>
      <jsp:attribute name="row6-value">
        <sec:authorize access="hasRole('ROLE_USER')">
          <input type="button" value="Operation"
              onclick="location='${contextPath}${operationUrl}'">
        </sec:authorize>
      </jsp:attribute>
    </ct:VerticalTableHeading>
    <sec:authorize access="hasRole('ROLE_BANK_EMPLOYEE')">
      <br>
      <input type="button" value="New Account"
          onclick="location='${contextPath}${createAccountUrl}'">
    </sec:authorize>
    <br><br>
    <input type="button" value="Logout"
        onclick="location='${contextPath}/logout'">
    <br>
  </jsp:body>
</ct:Page>