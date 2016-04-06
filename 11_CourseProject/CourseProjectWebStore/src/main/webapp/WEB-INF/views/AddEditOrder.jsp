<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ct" uri="http://web_store.jeewd.com/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<ct:Page title="Web Store: Order Entry"
    projectName="CourseProjectWebStore"
    currentVersion="1.0.0">
  <jsp:body>
    <form:form action="${contextPath}${addEditOrderUrl}" method="post"
        modelAttibute="Order">
      <ct:VerticalTableHeading>
        <jsp:attribute name="row1-title">
          Name:
        </jsp:attribute>
        <jsp:attribute name="row1-value">
          <input type="text" name="name">
        </jsp:attribute>
        <jsp:attribute name="row2-title">
          Type:
        </jsp:attribute>
        <jsp:attribute name="row2-value">
          <input type="text" name="type">
        </jsp:attribute>
        <jsp:attribute name="row3-title">
          Price:
        </jsp:attribute>
        <jsp:attribute name="row3-value">
          <input type="text" name="price">
        </jsp:attribute>
        <jsp:attribute name="row4-title">
          Quantity:
        </jsp:attribute>
        <jsp:attribute name="row4-value">
          <input type="text" name="quantity">
        </jsp:attribute>
        <jsp:attribute name="row5-title">
          <br>
          <input type="button" value="Cancel"
              onclick="location='${contextPath}${orderRegistryPageUrl}'">
        </jsp:attribute>
        <jsp:attribute name="row5-value">
          <br>
          <input type="submit" value="Save">
        </jsp:attribute>
      </ct:VerticalTableHeading>
    </form:form>
    <br><br>
    ${user.username} (logged in)&nbsp;
    <input type="button" value="Logout"
        onclick="location='${contextPath}/logout'">
    <br>
  </jsp:body>
</ct:Page>