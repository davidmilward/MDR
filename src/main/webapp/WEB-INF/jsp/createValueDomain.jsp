<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@ include file="/WEB-INF/jsp/header.jsp" %>

<html>
<head>
  <title><fmt:message key="title"/></title>
  <style>
    .error { color: red; }
  </style>  
</head>
<body>
<h1><fmt:message key="createValueDomain.heading"/></h1>
<form:form method="post" commandName="createValueDomain">
<p>New Value Domain Details - please enter details</p>
  <table width="65%" bgcolor="f8f8ff" border="1" cellspacing="0" cellpadding="5">
    <tr>
      <td align="center" width="20%">Term:</td>
        <td width="20%">
          <form:input path="term"/>
        </td>
    </tr>
    <tr>
      <td align="center" width="20%">Datatype:</td>
        <td width="20%">
           <form:select path="datatype" >
                <form:option value="A">A</form:option>
                <form:option value="B">B</form:option>
                <form:option value="C">C</form:option>
           </form:select>
        </td>
    </tr>
    <tr>
      <td align="center" width="20%">Unit of Measure:</td>
        <td width="20%">
          <form:input path="unitofmeasure"/>
        </td>
    </tr>
    <tr>
      <td align="center" width="20%">Permissible Values:</td>
        <td width="20%">
          <form:select path="permissiblevalue" >
                <form:option value="A">A</form:option>
                <form:option value="B">B</form:option>
                <form:option value="C">C</form:option>
           </form:select>
        </td>
    </tr>
    <tr>
      <td align="center" width="20%">Enumerated:</td>
        <td width="20%">
        <form:select path="enumerated" >
                <form:option value="True">True</form:option>
                <form:option value="False">False</form:option>
           </form:select>
        </td>
    </tr>
    <tr>
      <td align="center" width="20%">Format:</td>
        <td width="20%">
          <form:select path="format" >
                <form:option value="A">A</form:option>
                <form:option value="B">B</form:option>
                <form:option value="C">C</form:option>
           </form:select>
        </td>
    </tr>
    <tr>
      <td align="center" width="20%">Submittedby:</td>
        <td width="20%">
          <form:select path="submittedby" >
                <form:option value="John Doe">John Doe</form:option>
                <form:option value="Mike Bee">Mike Bee</form:option>
                <form:option value="Jamie Oliver">Jamie Oliver</form:option>
                <form:option value="Michelle Pfeiffer">Michelle Pfeiffer</form:option>
           </form:select>
        </td>
    </tr>
    <tr>
      <td align="center" width="20%">Classifiedby:</td>
        <td width="20%">
          <form:select path="classifiedby" >
                <form:option value="John Doe">John Doe</form:option>
                <form:option value="Mike Bee">Mike Bee</form:option>
                <form:option value="Jamie Oliver">Jamie Oliver</form:option>
                <form:option value="Michelle Pfeiffer">Michelle Pfeiffer</form:option>
           </form:select>
        </td>
    </tr>
    <tr>
      <td align="center" width="20%">Classification:</td>
        <td width="20%">
           <form:select path="classification" >
                <form:option value="UML">UML</form:option>
                <form:option value="SKOS">SKOS</form:option>
                <form:option value="ClassificationA">ClassificationA</form:option>
                <form:option value="ClassificationB">ClassificationB</form:option>
           </form:select> 
        </td>
    </tr>
    <tr>
      <td align="center" width="20%">Administrative Status:</td>
        <td width="20%">
          <form:input path="administrativestatus"/>
          <form:select path="administrativestatus" >
                <form:option value="noPendingChanges">No Pending Changes</form:option>
                <form:option value="scheduledForReview">Scheduled For Review</form:option>
                <form:option value="underReview">Under Review</form:option>
                <form:option value="changesPending">Changes Pending</form:option>
           </form:select>
        </td>
    </tr>


  </table>
  <br>
  <input type="submit" align="center" value="Execute">
</form:form>
<a href="<c:url value="vocabWelcome.htm"/>">Home</a>
</body>
</html>