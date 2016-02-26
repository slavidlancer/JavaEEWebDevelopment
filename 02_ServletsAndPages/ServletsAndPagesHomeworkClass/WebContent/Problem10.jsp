<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ct" uri="http://jeewd.com/tags" %>
<c:set var="date" value="<%= new Date() %>"/>

<ct:Page>
  <jsp:attribute name="title">Course schedule</jsp:attribute>
  <jsp:body>
    <ct:VerticalTable>
      <jsp:attribute name="row1-title">Course</jsp:attribute>
      <jsp:attribute name="row1-value">Web Development Basics</jsp:attribute>
      <jsp:attribute name="row2-title">Date</jsp:attribute>
      <jsp:attribute name="row2-value">${date}</jsp:attribute>
    </ct:VerticalTable>
    <div>Test</div>
  </jsp:body>
</ct:Page>