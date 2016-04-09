<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ct" uri="http://web_store.jeewd.com/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:set var="isUserAdmin" value="false"/>

<ct:Page title="Web Store: User Registry"
    projectName="CourseProjectWebStore"
    currentVersion="1.0.0">
  <jsp:body>
    <table>
      <tr>
        <td>
          <b>[Menu]</b>&nbsp;&nbsp;
          <input type="button" value="Home Page"
              onclick="location='${contextPath}'">&nbsp;&nbsp;
          <sec:authorize access="hasRole('ROLE_ADMIN')">
            <input type="button" value="Add User"
                onclick="location='${contextPath}${addUserPageUrl}'">
          </sec:authorize>
        </td>
      </tr>
    </table>
    <br><hr>
    <form:form action="${contextPath}${userRegistryPageUrl}" method="get"
        modelAttibute="UserSearch">
      <table>
        <tr>
          <td>Username:</td>
          <td><input type="text" name="username"><td>
          <td>Customer Name:</td>
          <td><input type="text" name="customerName"><td>
          <td>Type:</td>
          <td><input type="text" name="type"><td>
          <td>Status:</td>
          <td><input type="text" name="status"><td>
        </tr>
      </table>
      <input type="submit" value="Search">
    </form:form>
    <hr><h3>Users</h3>
    <table border="1">
      <thead>
        <tr align="center">
          <th>Username</th>
          <th>Customer Name</th>
          <th>Type</th>
          <th>Status</th>
          <th>*</th>
          <sec:authorize access="hasRole('ROLE_ADMIN')">
            <th>x</th>
          </sec:authorize>
        </tr>
      </thead>
      <c:if test="${not empty users}">
        <tbody>
          <sec:authorize access="hasRole('ROLE_ADMIN')">
            <c:set var="isUserAdmin" value="true"/>
          </sec:authorize>
          <sec:authorize access="!hasRole('ROLE_ADMIN')">
            <c:set var="isUserAdmin" value="false"/>
          </sec:authorize>
          <c:forEach var="u" items="${users}">
            <c:choose>
              <c:when test="${isUserAdmin}">
                <tr align="center">
                  <td>${u.username}</td>
                  <td>${u.customerName}</td>
                  <td>${u.type}</td>
                  <td>${u.status}</td>
                  <td>
                    <form:form action="${contextPath}${editUserPageUrl}"
                        method="get" modelAttibute="User">
                      <input type="hidden" name="id" value="${u.id}">
                      <input type="submit" value="Edit">
                    </form:form>
                  </td>
                  <td>
                    <form:form action="${contextPath}${deleteUserUrl}"
                        method="get" modelAttibute="User">
                      <input type="hidden" name="id" value="${u.id}">
                      <input type="submit" value="Delete">
                    </form:form>
                  </td>
                </tr>
              </c:when>
              <c:otherwise>
                <c:if test="${u.status eq 'Active'}">
                  <tr align="center">
                    <td>${u.username}</td>
                    <td>${u.customerName}</td>
                    <td>${u.type}</td>
                    <td>${u.status}</td>
                    <td>
                      <form:form action="${contextPath}${editUserPageUrl}"
                          method="get" modelAttibute="User">
                        <input type="hidden" name="id" value="${u.id}">
                        <input type="submit" value="Edit">
                      </form:form>
                    </td>
                  </tr>
                </c:if>
              </c:otherwise>
            </c:choose>
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