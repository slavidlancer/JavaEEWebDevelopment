<%@ tag dynamic-attributes="dynattrs" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table>
  <c:set var="attributesCount" value="${dynattrs.size()/2}"/>
  <c:forEach var="i" begin="1" end="${attributesCount}">
    <c:set var="titleKey" value="row${i}-title"></c:set>
    <c:set var="valueKey" value="row${i}-value"></c:set>
    <c:if test="${dynattrs[titleKey] != null}">
      <tr>
        <th align="right">${dynattrs[titleKey]}</th>
        <td align="center">${dynattrs[valueKey]}</td>
      </tr>
    </c:if>
  </c:forEach>
</table>