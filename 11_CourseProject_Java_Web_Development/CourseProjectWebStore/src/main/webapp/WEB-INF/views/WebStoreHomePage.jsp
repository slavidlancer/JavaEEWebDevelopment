<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ct" uri="http://web_store.jeewd.com/tags" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<ct:Page title="Web Store: Home Page"
    projectName="CourseProjectWebStore"
    currentVersion="1.0.0">
  <jsp:body>
    <h2>Menu</h2>
    <ct:VerticalTableHeading>
      <jsp:attribute name="row1-title">
        <input type="button" value="Product Registry"
            onclick="location='${contextPath}${productRegistryPageUrl}'"
            style="width: 100%;">
        <br><br>
      </jsp:attribute>
      <jsp:attribute name="row1-value"/>
      <jsp:attribute name="row2-title">
        <input type="button" value="Customer Registry"
            onclick="location='${contextPath}${customerRegistryPageUrl}'"
            style="width: 100%;">
        <br><br>
      </jsp:attribute>
      <jsp:attribute name="row2-value"/>
      <jsp:attribute name="row3-title">
        <input type="button" value="Order Registry"
            onclick="location='${contextPath}${orderRegistryPageUrl}'"
            style="width: 100%;">
        <br><br>
      </jsp:attribute>
      <jsp:attribute name="row3-value"/>
      <jsp:attribute name="row4-title">
        <input type="button" value="User Registry"
            onclick="location='${contextPath}${userRegistryPageUrl}'"
            style="width: 100%;">
        <br><br>
      </jsp:attribute>
      <jsp:attribute name="row4-value"/>
    </ct:VerticalTableHeading>
    <br><br>
    ${userPrincipal.username} (logged in)&nbsp;
    <input type="button" value="Logout"
        onclick="location='${contextPath}/logout'">
    <br>
  </jsp:body>
</ct:Page>