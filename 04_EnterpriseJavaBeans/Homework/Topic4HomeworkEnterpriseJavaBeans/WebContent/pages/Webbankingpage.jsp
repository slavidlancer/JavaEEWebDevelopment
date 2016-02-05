<%@page import="sun.security.jca.GetInstance"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ct" uri="http://ejbs.jeewd.com/tags" %>
<c:set var="user" value='<%= session.getAttribute("id") %>'/>

<ct:Page title="Web Banking Page"
    projectName="Topic4HomeworkEnterpriseJavaBeans"
    currentVersion="1.0.0">
  <jsp:body>
    <p>Current user: ${user}</p>
    <form action="../BankOperationController" method="post">
      <ct:VerticalTableHeading>
        <jsp:attribute name="row1-title">Client:</jsp:attribute>
        <jsp:attribute name="row1-value"><input type="text" name="id">
            </jsp:attribute>
        <jsp:attribute name="row2-title">Current bank account amount:
            </jsp:attribute>
        <jsp:attribute name="row2-value"><input type="text"
            name="currentamount"></jsp:attribute>
        <jsp:attribute name="row3-title">Operation:</jsp:attribute>
        <jsp:attribute name="row3-value"><select name="operation">
                <option value="deposit">Deposit</option>
                <option value="withdraw">Withdraw</option>
              </select>
            </jsp:attribute>
        <jsp:attribute name="row4-title">Amount to change:</jsp:attribute>
        <jsp:attribute name="row4-value"><input type="text" name="changeamount">
            </jsp:attribute>
        <jsp:attribute name="row5-title"/>
        <jsp:attribute name="row5-value"><input type="submit" value="Submit">
            </jsp:attribute>
      </ct:VerticalTableHeading>
    </form>
    <br><br>
  </jsp:body>
</ct:Page>