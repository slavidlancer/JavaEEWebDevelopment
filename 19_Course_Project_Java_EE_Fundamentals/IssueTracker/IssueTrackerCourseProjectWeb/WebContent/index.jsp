<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="user" value="${sessionScope.LOGGED_USER}"></c:set>
<c:if test="${not empty user}">
 <% response.sendRedirect(request.getContextPath() + "/pages/auth/listIssues.html"); %>
</c:if>
<c:if test="${empty user}">
 <% response.sendRedirect(request.getContextPath() + "/pages/listIssues.html"); %>
</c:if>