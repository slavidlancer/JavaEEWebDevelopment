<%@ page import="java.util.*" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ taglib prefix="pt" uri="http://servlets.jeewd.com/tags" %>
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

<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>TablePageTag</title>
  </head>
  <body>
    <pt:Page title="TablePageTag" systemVersion="1.0.0">
${firstDateVar}&nbsp;&nbsp;${secondDateVar}
    </pt:Page>
  </body>
</html>