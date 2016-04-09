<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ct" uri="http://web_store.jeewd.com/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
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
          <td>Product:</td>
          <td><input type="text" name="product"><td>
          <td>Customer Name:</td>
          <td><input type="text" name="customerName"><td>
          <td>Date of Purchase:</td>
          <td><input type="text" name="dateOfPurchase"><td>
        </tr>
      </table>
      <input type="submit" value="Search">
    </form:form>
    <hr><h3>Orders</h3>
    <table border="1">
      <thead>
        <tr align="center">
          <th>Products</th>
          <th>Quantity</th>
          <th>Customer Name</th>
          <th>Date of Purchase</th>
          <th>Overall Price</th>
          <sec:authorize access="hasRole('ROLE_ADMIN')">
            <th>*</th>
            <th>x</th>
          </sec:authorize>
        </tr>
      </thead>
      <c:if test="${not empty orders}">
          <tbody>
            <c:forEach var="o" items="${orders}">
              <tr align="center">
                <td>${o.products}</td>
                <td>${o.quantity}</td>
                <td>${o.customerName}</td>
                <td>${o.dateOfPurchase}</td>
                <td>${o.overallPrice}</td>
                <sec:authorize access="hasRole('ROLE_ADMIN')">
                  <td>
                    <form:form action="${contextPath}${editOrderPageUrl}"
                        method="get" modelAttibute="Order">
                      <input type="hidden" name="id" value="${o.id}">
                      <input type="submit" value="Edit">
                    </form:form>
                  </td>
                  <td>
                    <form:form action="${contextPath}${deleteOrderUrl}"
                        method="get" modelAttibute="Order">
                      <input type="hidden" name="id" value="${o.id}">
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