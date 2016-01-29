<%@ page import="java.util.*" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ taglib prefix="ct" uri="http://servlets.jeewd.com/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%!
    private Date getDateAndTimeAsObject(String date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
                "dd.MM.yyyy HH:mm");
        Date dateObject = null;
        
        try {
            dateObject = simpleDateFormat.parse(date);
        } catch (java.text.ParseException pe) {
            pe.printStackTrace();
        }
        
        return dateObject;
    }

    Date firstDate = getDateAndTimeAsObject("14.01.2016 18:00");
    Date secondDate = getDateAndTimeAsObject("21.01.2016 18:00");
%>

<c:set var="firstDateVar" value="<%= firstDate %>"/>
<c:set var="secondDateVar" value="<%= secondDate %>"/>

<ct:Page title="VerticalTableHeadingPageTag" systemVersion="1.0.0"
    showDate="true">
  <jsp:body>
    <ct:VerticalTableHeading>
      <jsp:attribute name="row1-title">Topic</jsp:attribute>
      <jsp:attribute name="row1-value">Web Development Basics</jsp:attribute>
      <jsp:attribute name="row2-title">Date</jsp:attribute>
      <jsp:attribute name="row2-value">${firstDateVar}</jsp:attribute>
      <jsp:attribute name="row3-title">Topic</jsp:attribute>
      <jsp:attribute name="row3-value">Servlets and Pages</jsp:attribute>
      <jsp:attribute name="row4-title">Date</jsp:attribute>
      <jsp:attribute name="row4-value">${secondDateVar}</jsp:attribute>
    </ct:VerticalTableHeading>
  </jsp:body>
</ct:Page>