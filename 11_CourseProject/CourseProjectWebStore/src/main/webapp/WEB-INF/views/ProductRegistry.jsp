<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ct" uri="http://web_store.jeewd.com/tags" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<ct:Page title="Web Store: Product Registry"
    projectName="CourseProjectWebStore"
    currentVersion="1.0.0">
  <jsp:body>
    <input type="button" value="Add Product"
            onclick="location='${contextPath}${addProductPageUrl}'">
    <br>
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
      <c:if test="${not empty products}">
          <tbody>
            <c:forEach var="p" items="${products}">
              <tr align="center">
                <td>${p.name}</td>
                <td>${p.type}</td>
                <td>${p.price}</td>
                <td>${p.quantity}</td>
                <td>
                  <input type="button" value="Edit"
                      onclick="location='${contextPath}${editProductPageUrl}'">
                </td>
                <td>
                  <input type="button" value="Delete"
                      onclick="location=
                          '${contextPath}${deleteProductPageUrl}'">
                </td>
              </tr>
            </c:forEach>
          </tbody>
        </c:if>
    </table>
    <br><br>
  </jsp:body>
</ct:Page>