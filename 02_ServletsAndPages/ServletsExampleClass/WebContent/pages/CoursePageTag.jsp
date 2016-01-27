<%@ taglib prefix="ct" uri="http://servlets.jeewd.com/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="date" value="<%= new java.util.Date() %>"/>
<c:set var="topic" value="2"/>
<ct:Page title="CoursePageTag">
  <c:if test='${topic == "2"}'>
    <jsp:body>
      <ct:VerticalTable>
        <jsp:attribute name="row1-title">Course</jsp:attribute>
        <jsp:attribute name="row1-value">Web Development Basics</jsp:attribute>
        <jsp:attribute name="row2-title">Date</jsp:attribute>
        <jsp:attribute name="row2-value">${date}</jsp:attribute>
      </ct:VerticalTable>
    </jsp:body>
  </c:if>
</ct:Page>
