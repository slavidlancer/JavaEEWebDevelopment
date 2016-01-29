<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ct" uri="http://servlets.jeewd.com/tags" %>
<%@ attribute name="title" %>
<%@ attribute name="systemVersion" %>
<%@ attribute name="showDate" %>

<c:set var="showCurrentDate" value="${showDate}"/>
<c:set var="currentDate" value="<%= new java.util.Date() %>"/>
<c:set var="currentDateWithBr" value="${currentDate}<br><br>"/>

<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>${title}</title>
  </head>
  <body>
    <ct:Header title="${title}"/>
    <jsp:doBody/>
    <br>
    ${showCurrentDate ? currentDateWithBr : "" }
    <ct:Footer systemVersion="${systemVersion}"/>
  </body>
</html>