<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="ct" uri="http://jpa_h_bank.jeewd.com/tags" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<ct:Page title="Web Bank: Account Creation Page"
    projectName="Topic9HomeworkSpringJPAHibernateOracleDatabase"
    currentVersion="1.0.0">
  <jsp:body>
    <form:form action="${contextPath}${addAccountUrl}" method="post"
        modelAttibute="bankAccount">
      <ct:VerticalTableHeading>
        <jsp:attribute name="row1-title">
          Username:
        </jsp:attribute>
        <jsp:attribute name="row1-value">
          <sec:authorize access="hasRole('ROLE_BANK_EMPLOYEE')">
            <c:if test="${not empty users}">
              <select name="username" style="width: 100%;">
                <c:forEach var="u" items="${users}">
                  <option value="${u}">${u}</option>
                </c:forEach>
              </select>
            </c:if>
          </sec:authorize>
        </jsp:attribute>
        <jsp:attribute name="row2-title">
          Account Number:
        </jsp:attribute>
        <jsp:attribute name="row2-value">
          <input type="text" name="number">
        </jsp:attribute>
        <jsp:attribute name="row3-title">
          Initial Amount:
        </jsp:attribute>
        <jsp:attribute name="row3-value">
          <input type="text" name="amount">
        </jsp:attribute>
        <jsp:attribute name="row4-title">
          Account Currency:
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