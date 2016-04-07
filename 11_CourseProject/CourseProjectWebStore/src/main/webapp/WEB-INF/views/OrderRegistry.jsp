<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ct" uri="http://web_store.jeewd.com/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<ct:Page title="Web Store: Order Registry"
    projectName="CourseProjectWebStore"
    currentVersion="1.0.0">
  <jsp:body>
    <table>
      <tr>
        <td>
          <b>[Menu]</b>&nbsp;&nbsp;
          <input type="button" value="Home Page"
              onclick="location='${contextPath}'">&nbsp;&nbsp;
          <input type="button" value="Add Order"
              onclick="location='${contextPath}${addOrderPageUrl}'">
        </td>
      </tr>
    </table>
    <br><hr>
    <form:form action="${contextPath}${orderRegistryPageUrl}" method="get"
        modelAttibute="OrderSearch">
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
    <hr><h3>Orders</h3>
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
                <td>1</td>
                <td>2</td>
                <td>o.price</td>
                <td>o.quantity</td>
                <td>
                  <input type="button" value="Edit"
                      onclick="location='${contextPath}${editOrderPageUrl}'">
                </td>
                <td>
                  <input type="button" value="Delete"
                      onclick="location=
                          '${contextPath}${deleteOrderUrl}'">
                </td>
              </tr>
      </tbody>
      <c:if test="${not empty orders}">
          <tbody>
            <c:forEach var="o" items="${orders}">
              <tr align="center">
                <td>${o.name}</td>
                <td>${o.type}</td>
                <td>${o.price}</td>
                <td>${o.quantity}</td>
                <td>
                  <form:form action="${contextPath}${editOrderPageUrl}"
                      method="get" modelAttibute="Order">
                    <input type="hidden" name="id" value="${o.id}">
                    <input type="submit" value="Edit">
                  </form:form>
                  <!-- <input type="button" value="Edit"
                      onclick="location='${contextPath}${editOrderPageUrl}'"> -->
                </td>
                <td>
                  <form:form action="${contextPath}${deleteOrderUrl}"
                      method="get" modelAttibute="Order">
                    <input type="hidden" name="id" value="${o.id}">
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