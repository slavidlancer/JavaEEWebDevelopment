<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ct" uri="http://web_store.jeewd.com/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
          <td>Type:</td>
          <td><input type="text" name="type"><td>
          <td>Price:</td>
          <td><input type="text" name="price"><td>
          <td>Quantity:</td>
          <td><input type="text" name="quantity"><td>
        </tr>
      </table>
      <input type="submit" value="Search">
    </form:form>
    <hr><h3>Customers</h3>
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
                <td>c.name</td>
                <td>c.type</td>
                <td>c.price</td>
                <td>c.quantity</td>
                <td>
                  <input type="button" value="Edit"
                      onclick="location='${contextPath}${editCustomerPageUrl}'">
                </td>
                <td>
                  <input type="button" value="Delete"
                      onclick="location=
                          '${contextPath}${deleteCustomerUrl}'">
                </td>
              </tr>
      </tbody>
      <c:if test="${not empty customers}">
          <tbody>
            <c:forEach var="c" items="${customers}">
              <tr align="center">
                <td>${c.name}</td>
                <td>${c.type}</td>
                <td>${c.price}</td>
                <td>${c.quantity}</td>
                <td>
                  <form:form action="${contextPath}${editCustomerPageUrl}"
                      method="get" modelAttibute="Customer">
                    <input type="hidden" name="id" value="${c.id}">
                    <input type="submit" value="Edit">
                  </form:form>
                  <!-- <input type="button" value="Edit"
                      onclick="location='${contextPath}${editCustomerPageUrl}'"> -->
                </td>
                <td>
                  <form:form action="${contextPath}${deleteCustomerUrl}"
                      method="get" modelAttibute="Customer">
                    <input type="hidden" name="id" value="${c.id}">
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