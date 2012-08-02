<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@ include file="/WEB-INF/jsp/header.jsp" %>

  <body>
    <h1><fmt:message key="heading"/></h1>
    <div id="content"></div>
    <br><br/>

<h1><fmt:message key="createValueDomain.heading"/></h1>
<form:form method="post" commandName="createValueDomain">
<p>New Value Domain - please enter details</p>
  <table align="center" width="65%" bgcolor="f8f8ff" border="1" cellspacing="0" cellpadding="5">
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
                <form:option value="1">String</form:option>
                <form:option value="2">Integer</form:option>
                <form:option value="3">Long</form:option>
                <form:option value="4">Short</form:option>
           </form:select> 
        </td>
    </tr>
    <tr>
      <td align="center" width="20%">Maximum Character Length:</td>
        <td width="20%">
          <form:input path="maxchar"/>
        </td>
    </tr>
    <tr>
      <td align="center" width="20%">Unit of Measure:</td>
        <td width="20%">
          <form:input path="unitofmeasure"/>
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
              <form:options items="${personList}" itemValue="id" itemLabel="fullName" />
          </form:select>
        </td>
    </tr>
    <tr>
      <td align="center" width="20%">(Administered by)Working for:</td>
        <td width="20%">
        <form:select path="administeredby" >
         		<form:options items="${personList}" itemValue="id" itemLabel="fullName" />
          </form:select>
        </td>
    </tr>
    <tr>
      <td align="center" width="20%">Submitted by:</td>
        <td width="20%">
        <form:select path="submittedby" >
         		<form:options items="${personList}" itemValue="id" itemLabel="fullName" />
          </form:select>
        </td>
    </tr>
    <tr>
      <td align="center" width="20%">Classified by:</td>
        <td width="20%">
        <form:select path="classifiedby" >
         		<form:options items="${personList}" itemValue="id" itemLabel="fullName" />
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
          <form:input path="classification"/>
        </td>
    </tr>
    
    <tr>
      <td align="center" width="20%">Administrative Status:</td>
        <td width="20%">
          <form:select path="administrativestatus" >
                <form:option value='1'>No Pending Changes</form:option>
                <form:option value='2'>Scheduled For Review</form:option>
                <form:option value="3">Under Review</form:option>
                <form:option value='4'>Changes Pending</form:option>
           </form:select>
        </td>
    </tr>


  </table>
  <br>
  <input type="submit" value="Execute">
</form:form>
    <a href="<c:url value="welcome"/>">Home</a>	
	<ul>
		<li> <a href="?locale=en_us">us</a> |  <a href="?locale=en_gb">gb</a> | <a href="?locale=es_es">es</a> | <a href="?locale=de_de">de</a> </li>
	</ul>	
</div>
</body>
</html>