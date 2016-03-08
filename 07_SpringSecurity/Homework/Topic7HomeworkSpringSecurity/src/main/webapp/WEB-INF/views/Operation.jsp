<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="ct" uri="http://securebank.jeewd.com/tags" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<ct:Page title="Web Bank: Operation Page"
    projectName="Topic7HomeworkSpringSecurity"
    currentVersion="1.0.0">
  <jsp:body>
    <form:form action="${contextPath}${processOperationUrl}" method="post"
        modelAttibute="bankOperation">
      <ct:VerticalTableHeading>
        <jsp:attribute name="row1-title">
          Account Number:
        </jsp:attribute>
        <jsp:attribute name="row1-value">
          <sec:authorize access="hasRole('ROLE_BANK_EMPLOYEE')">
            <c:if test="${not empty accounts}">
              <select name="number" style="width: 100%;">
                <c:forEach var="a" items="${accounts}">
                  <option value="${a.number}">${a.username}/${a.number}</option>
                </c:forEach>
              </select>
            </c:if>
          </sec:authorize>
          <sec:authorize access="hasRole('ROLE_USER')">
            <sec:authorize access="!hasRole('ROLE_BANK_EMPLOYEE')">
              <c:if test="${not empty accounts}">
                <select name="number" style="width: 100%;">
                  <c:forEach var="a" items="${accounts}">
                    <c:if test="${user.username == a.username}">
                      <option value="${a.number}">${a.number}</option>
                    </c:if>
                  </c:forEach>
                </select>
              </c:if>
            </sec:authorize>
          </sec:authorize>
        </jsp:attribute>
        <jsp:attribute name="row2-title">
          Operation:
        </jsp:attribute>
        <jsp:attribute name="row2-value">
          <select name="operation" style="width: 100%;">
            <option value="deposit">Deposit</option>
            <option value="withdraw">Withdraw</option>
          </select>
        </jsp:attribute>
        <jsp:attribute name="row3-title">
          Amount:
        </jsp:attribute>
        <jsp:attribute name="row3-value">
          <input type="text" name="amount">
        </jsp:attribute>
        <jsp:attribute name="row4-title">
          Currency:
        </jsp:attribute>
        <jsp:attribute name="row4-value">
          <select name="currency">
            <option value="BGN">
              BGN
            </option>
            <option value="USD">
              USD
            </option>
            <option value="EUR">
              EUR
            </option>
          </select>
        </jsp:attribute>
        <jsp:attribute name="row5-title"/>
        <jsp:attribute name="row5-value">
          <input type="submit" id="buttonsubmit" value="Submit">
        </jsp:attribute>
      </ct:VerticalTableHeading>
    </form:form>
    <br>
  </jsp:body>
</ct:Page>