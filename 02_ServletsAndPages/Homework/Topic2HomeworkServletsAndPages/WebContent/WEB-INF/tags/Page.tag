<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="currentDate" value="<%= new java.util.Date() %>"/>
<%@ include file="Header.tag" %>
<jsp:doBody/>
<br>
<%@ include file="Footer.tag" %>
${showCurrentDate = "true"}
${showCurrentDate ? currentDate : "" }