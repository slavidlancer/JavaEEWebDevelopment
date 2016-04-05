<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ct" uri="http://web_store.jeewd.com/tags" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<ct:Page title="Web Store: Order Registry"
    projectName="CourseProjectWebStore"
    currentVersion="1.0.0">
  <jsp:body>
    <input type="button" value="Add Order"
            onclick="location='${contextPath}${addOrderPageUrl}'">
    <ct:VerticalTableHeading>
      <jsp:attribute name="row1-title">
        
      </jsp:attribute>
      <jsp:attribute name="row1-value">
        
      </jsp:attribute>
      <jsp:attribute name="row2-title">
        
      </jsp:attribute>
      <jsp:attribute name="row2-value">
        
      </jsp:attribute>
      <jsp:attribute name="row3-title"/>
      <jsp:attribute name="row3-value">
        
      </jsp:attribute>
    </ct:VerticalTableHeading>
    <br><br>
  </jsp:body>
</ct:Page>