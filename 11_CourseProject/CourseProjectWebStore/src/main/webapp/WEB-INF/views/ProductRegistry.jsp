<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ct" uri="http://web_store.jeewd.com/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<ct:Page title="Web Store: Product Registry"
    projectName="CourseProjectWebStore"
    currentVersion="1.0.0">
  <jsp:body>
    <table>
      <tr>
        <td>
          <b>[Menu]</b>&nbsp;&nbsp;
          <input type="button" value="Home Page"
              onclick="location='${contextPath}'">&nbsp;&nbsp;
          <input type="button" value="Add Product"
              onclick="location='${contextPath}${addProductPageUrl}'">
        </td>
      </tr>
    </table>
    <br><hr>
    <form:form action="${contextPath}${productRegistryPageUrl}" method="get"
        modelAttibute="ProductSearch">
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
    <hr><h3>Products</h3>
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
      <!-- <tr align="center">
                <td>sdds</td>
                <td>fdfd</td>
                <td>dsds</td>
                <td>sdsw</td>
                <td>
                  <input type="button" value="Edit"
                      onclick="location='${contextPath}${editProductPageUrl}'">
                </td>
                <td>
                  <input type="button" value="Delete"
                      onclick="location=
                          '${contextPath}${deleteProductUrl}'">
                </td>
              </tr> -->
      </tbody><tr><td><form:form action="${contextPath}${editProductPageUrl}"
                      method="post" modelAttibute="ProductTransfer">
                    <input type="text" name="id" value="123">
                    <input type="submit" value="Edit">
                  </form:form></td></tr>
      <c:if test="${not empty products}">
          <tbody>
            <c:forEach var="p" items="${products}">
              <tr align="center">
                <td>${p.name}</td>
                <td>${p.type}</td>
                <td>${p.price}</td>
                <td>${p.quantity}</td>
                <td>
                  <form:form action="${contextPath}${editProductPageUrl}"
                      method="get" modelAttibute="Product">
                    <input type="hidden" name="id" value="${p.id}">
                    <input type="submit" value="Edit">
                  </form:form>
                </td>
                <td>
                  <form:form action="${contextPath}${deleteProductUrl}"
                      method="get" modelAttibute="Product">
                    <input type="hidden" name="id" value="${p.id}">
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