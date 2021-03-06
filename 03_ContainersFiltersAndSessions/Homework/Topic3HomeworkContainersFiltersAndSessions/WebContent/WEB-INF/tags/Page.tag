<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ct" uri="http://servlets.jeewd.com/tags" %>
<%@ attribute name="title" %>
<%@ attribute name="projectName" %>
<%@ attribute name="currentVersion" %>

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
    <ct:Footer projectName="${projectName}" currentVersion="${currentVersion}"/>
  </body>
</html>