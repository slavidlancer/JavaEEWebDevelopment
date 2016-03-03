<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="ct" uri="http://securebank.jeewd.com/tags" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<ct:Page title="Web Bank: Operation Page"
    projectName="Topic7HomeworkSpringSecurity"
    currentVersion="1.0.0">
  <jsp:body>
    <form:form action="${contextPath}${processOperationUrl}" method="post"
        modelAttibute="bankAccount">
      <ct:VerticalTableHeading>
        <jsp:attribute name="row1-title">
          New Client:<br><br>
        </jsp:attribute>
        <jsp:attribute name="row1-value">
          <input type="text" name="id" value='${id}' size="29"><br><br>
        </jsp:attribute>
        <jsp:attribute name="row2-title">
          Current Client:
        </jsp:attribute>
        <jsp:attribute name="row2-value">
          ${id}
        </jsp:attribute>
        <jsp:attribute name="row3-title">
          Current bank account amount:<br><br>
        </jsp:attribute>
        <jsp:attribute name="row3-value">
          ${currentamount}&nbsp; ${accountcurrency}<br><br>
        </jsp:attribute>
        <jsp:attribute name="row4-title">
          Operation:
        </jsp:attribute>
        <jsp:attribute name="row4-value">
          <select name="operation" style="width: 100%;">
            <option value="deposit">Deposit</option>
            <option value="withdraw">Withdraw</option>
          </select>
        </jsp:attribute>
        <jsp:attribute name="row5-title">
          Amount to change:
        </jsp:attribute>
        <jsp:attribute name="row5-value">
          <input type="text" name="changeamount" value="0" size="20">&nbsp;
          <select name="changecurrency">
            <option value="BGN" ${accountcurrency eq "BGN" ? "selected" : ""}>
              BGN
            </option>
            <option value="USD" ${accountcurrency eq "USD" ? "selected" : ""}>
              USD
            </option>
            <option value="EUR" ${accountcurrency eq "EUR" ? "selected" : ""}>
              EUR
            </option>
          </select>
        </jsp:attribute>
        <jsp:attribute name="row6-title"/>
        <jsp:attribute name="row6-value">
          <input type="submit" value="Submit">
        </jsp:attribute>
      </ct:VerticalTableHeading>
    </form:form>
    <br>
  </jsp:body>
</ct:Page>