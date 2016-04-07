<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ct" uri="http://web_store.jeewd.com/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

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
          <input type="button" value="Add User"
              onclick="location='${contextPath}${addUserPageUrl}'">
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
          <td>Name:</td>
          <td><input type="text" name="name"><td>
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
          <th>Name</th>
          <th>Type</th>
          <th>Price</th>
          <th>Quantity</th>
          <th>*</th>
          <th>x</th>
        </tr>
      </thead>
      <tbody>
      <tr align="center">
                <td>sdds</td>
                <td>fdfd</td>
                <td>dsds</td>
                <td>sdsw</td>
                <td>
                  <input type="button" value="Edit"
                      onclick="location='${contextPath}${editUserPageUrl}'">
                </td>
                <td>
                  <input type="button" value="Delete"
                      onclick="location=
                          '${contextPath}${deleteUserUrl}'">
                </td>
              </tr>
      </tbody>
      <c:if test="${not empty users}">
          <tbody>
            <c:forEach var="u" items="${users}">
              <tr align="center">
                <td>${u.username}</td>
                <td>${u.name}</td>
                <td>${u.type}</td>
                <td>${u.status}</td>
                <td>
                  <form:form action="${contextPath}${editUserPageUrl}"
                      method="get" modelAttibute="User">
                    <input type="hidden" name="id" value="${u.id}">
                    <input type="submit" value="Edit">
                  </form:form>
                  <!-- <input type="button" value="Edit"
                      onclick="location='${contextPath}${editUserPageUrl}'"> -->
                </td>
                <td>
                  <form:form action="${contextPath}${deleteUserUrl}"
                      method="get" modelAttibute="User">
                    <input type="hidden" name="id" value="${u.id}">
                    <input type="submit" value="Delete">
                  </form:form>
                </td>
              </tr>
            </c:forEach>
          </tbody>
        </c:if>
    </table>
    <br><br>
    ${user.username} (logged in)&nbsp;
    <input type="button" value="Logout"
        onclick="location='${contextPath}/logout'">
    <br>
  </jsp:body>
</ct:Page>