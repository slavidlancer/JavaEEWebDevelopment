<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ct" uri="http://ejbs.jeewd.com/tags" %>
<c:set var="id" value='<%= session.getAttribute("id") %>'/>
<c:set var="currentAmount" value='<%= session.getAttribute("currentamount") %>'
    />
<c:set var="accountCurrency" value='<%= session.getAttribute("accountcurrency")
    %>'/>

<ct:Page title="Web Banking Page"
    projectName="Topic4HomeworkEnterpriseJavaBeans"
    currentVersion="1.0.0">
  <jsp:body>
    <form action="../BankOperationController" method="post">
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
          ${currentAmount}&nbsp;${accountCurrency}<br><br>
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
            <option value="bgn">BGN</option>
            <option value="usd">USD</option>
            <option value="eur">EUR</option>
          </select>
        </jsp:attribute>
        <jsp:attribute name="row6-title"/>
        <jsp:attribute name="row6-value">
          <input type="submit" value="Submit">
        </jsp:attribute>
      </ct:VerticalTableHeading>
    </form>
    <br>
  </jsp:body>
</ct:Page>