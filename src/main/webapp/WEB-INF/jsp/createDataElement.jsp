<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@ include file="/WEB-INF/jsp/header.jsp" %>

<body>
<div id="content"></div>
<h1><fmt:message key="createDataElement.heading"/></h1>
<form:form method="post" commandName="createDataElement">
<p>New Data Element - please enter details</p>
  <table align="center" width="65%" bgcolor="f8f8ff" border="1" cellspacing="0" cellpadding="5">
    <tr>
      <td align="center" width="20%">Term:</td>
        <td width="20%">
          <form:input path="term"/>
        </td>
    </tr>
    <tr>
      <td align="center" width="20%">Description:</td>
        <td width="20%">
          <form:input path="description"/>
        </td>
    </tr>
    <tr>
      <td align="center" width="20%">Definition:</td>
        <td width="20%">
          <form:input path="definition"/>
        </td>
    </tr>
    <tr>
      <td align="center" width="20%">Registration Status:</td>
        <td width="20%">
        <form:select path="registrationstatus" items="${registrationStatusList}"/>
        </td>
    </tr>
    <tr>
      <td align="center" width="20%">(Registered by)I am:</td>
        <td width="20%">
          <form:select path="registeredby">
              			<form:option value="-" label="--Please Select"/>
              			<form:options items="${personList}" />
          </form:select>
        </td>
    </tr>
    <tr>
      <td align="center" width="20%">(Administered by)Working for:</td>
        <td width="20%">
        <form:select path="administeredby">
              			<form:option value="-" label="--Please Select"/>
              			<form:options items="${personList}" />
          </form:select>
        </td>
    </tr>
    <tr>
      <td align="center" width="20%">Submittedby:</td>
        <td width="20%">
        <form:select path="submittedby">
              			<form:option value="-" label="--Please Select"/>
              			<form:options items="${personList}" />
          </form:select>
        </td>
    </tr>
    <tr>
      <td align="center" width="20%">Classifiedby:</td>
        <td width="20%">
        <form:select path="classifiedby">
              			<form:option value="-" label="--Please Select"/>
              			<form:options items="${personList}" itemValue="id" itemLabel="surname" />
          </form:select>
        </td>
    </tr>
    <tr>
      <td align="center" width="20%">Comments:</td>
        <td width="20%">
          <form:input path="comments"/>
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