<%@page import="sun.security.jca.GetInstance"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ct" uri="http://servlets.jeewd.com/tags" %>
<c:set var="user" value='<%= session.getAttribute("username") %>'/>

<ct:Page title="HomePage"
    projectName="Topic3HomeworkContainersFiltersAndSessions"
    currentVersion="1.0.0">
  <jsp:body>
    <p>Current user: ${user}</p>
  </jsp:body>
</ct:Page>