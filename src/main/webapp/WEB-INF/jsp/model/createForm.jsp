<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@ include file="/WEB-INF/jsp/header.jsp" %>

  <body>
    <h1><fmt:message key="heading"/></h1>
    <div id="content"></div>
    <br><br/>
<%--     <h3><fmt:message key="greeting"/></h3>	 --%>
<!-- <div id="content"></div> -->
<h1><fmt:message key="createModel.heading"/></h1>
<form:form method="post" commandName="model">
<p>New Model - please enter details</p>
  <table align="center" width="65%" bgcolor="f8f8ff" border="1" cellspacing="0" cellpadding="5">
    <tr>
      <td align="center" width="20%">Name:</td>
        <td width="20%">
          <form:input path="name"/>
        </td>
    </tr>
    <tr>
      <td align="center" width="20%">Description:</td>
        <td width="20%">
          <form:input path="description"/>
        </td>
    </tr>
    <tr>
      <td align="center" width="20%">Namespace:</td>
        <td width="20%">
          <form:input path="namespace"/>
        </td>
    </tr>
    <tr>
      <td align="center" width="20%">Registration Status:</td>
        <td width="20%">
        <form:select path="registrationStatus" items="${registrationStatusList}"/>
        </td>
    </tr>
    <tr>
      <td align="center" width="20%">(Registered by)I am:</td>
        <td width="20%">
          <form:select path="registeredBy">
              <form:options items="${personList}" itemValue="id" itemLabel="fullName" />
          </form:select>
        </td>
    </tr>
    <tr>
      <td align="center" width="20%">(Administered by)Working for:</td>
        <td width="20%">
        <form:select path="administeredBy" >
         		<form:options items="${personList}" itemValue="id" itemLabel="fullName" />
          </form:select>
        </td>
    </tr>
    <tr>
      <td align="center" width="20%">Submittedby:</td>
        <td width="20%">
        <form:select path="submittedby" >
         		<form:options items="${personList}" itemValue="id" itemLabel="fullName" />
          </form:select>
        </td>
    </tr>
    <tr>
      <td align="center" width="20%">Classifiedby:</td>
        <td width="20%">
        <form:select path="classifiedBy" >
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
          <form:select path="administrativeStatus" >
                <form:option value='1'>No Pending Changes</form:option>
                <form:option value='2'>Scheduled For Review</form:option>
                <form:option value="3">Under Review</form:option>
                <form:option value='4'>Changes Pending</form:option>
           </form:select>
        </td>
    </tr>


  </table>
  <br>
  <input type="submit" align="center" value="Execute">
</form:form>
    <a href="<c:url value="welcome"/>">Home</a>	
	<ul>
		<li> <a href="?locale=en_us">us</a> |  <a href="?locale=en_gb">gb</a> | <a href="?locale=es_es">es</a> | <a href="?locale=de_de">de</a> </li>
	</ul>	
</div>
</body>
</html>