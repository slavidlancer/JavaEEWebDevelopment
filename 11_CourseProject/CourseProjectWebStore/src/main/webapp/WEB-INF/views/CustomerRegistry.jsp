<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ct" uri="http://web_store.jeewd.com/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<ct:Page title="Web Store: Customer Registry"
    projectName="CourseProjectWebStore"
    currentVersion="1.0.0">
  <jsp:body>
    <table>
      <tr>
        <td>
          <b>[Menu]</b>&nbsp;&nbsp;
          <input type="button" value="Home Page"
              onclick="location='${contextPath}'">&nbsp;&nbsp;
          <input type="button" value="Add Customer"
              onclick="location='${contextPath}${addCustomerPageUrl}'">
        </td>
      </tr>
    </table>
    <br><hr>
    <form:form action="${contextPath}${customerRegistryPageUrl}" method="get"
        modelAttibute="CustomerSearch">
      <table>
        <tr>
          <td>Name:</td>
          <td><input type="text" name="name"><td>
          <td>PID:</td>
          <td><input type="text" name="pid"><td>
          <td>Date of Birth:</td>
          <td><input type="text" name="dateOfBirth"><td>
          <td>Address:</td>
          <td><input type="text" name="address"><td>
        </tr>
      </table>
      <input type="submit" value="Search">
    </form:form>
    <hr><h3>Customers</h3>
    <table border="1">
      <thead>
        <tr align="center">
          <th>Name</th>
          <th>PID</th>
          <th>Date of Birth</th>
          <th>Address</th>
          <sec:authorize access="hasRole('ROLE_ADMIN')">
            <th>*</th>
            <th>x</th>
          </sec:authorize>
        </tr>
      </thead>
      <c:if test="${not empty customers}">
          <tbody>
            <c:forEach var="c" items="${customers}">
              <tr align="center">
                <td>${c.name}</td>
                <td>${c.pid}</td>
                <td>${c.dateOfBirth}</td>
                <td>${c.address}</td>
                <sec:authorize access="hasRole('ROLE_ADMIN')">
                  <td>
                    <form:form action="${contextPath}${editCustomerPageUrl}"
                        method="get" modelAttibute="Customer">
                      <input type="hidden" name="id" value="${c.id}">
                      <input type="submit" value="Edit">
                    </form:form>
                  </td>
                  <td>
                    <form:form action="${contextPath}${deleteCustomerUrl}"
                        method="get" modelAttibute="Customer">
                      <input type="hidden" name="id" value="${c.id}">
                      <input type="submit" value="Delete">
                    </form:form>
                  </td>
                </sec:authorize>
              </tr>
            </c:forEach>
          </tbody>
        </c:if>
    </table>
    <br><br>
    ${userPrincipal.username} (logged in)&nbsp;
    <input type="button" value="Logout"
        onclick="location='${contextPath}/logout'">
    <br>
  </jsp:body>
</ct:Page>