<%@ include file="include.jsp" %>
<%@ include file="header.jsp" %>
<link type="text/css" rel="stylesheet" href="/WEB-INF/js/styles/mdc.css" />
  <body>
    <h1><fmt:message key="heading"/></h1>
    <div id="content"></div>
    <br><br/>
	<h1><fmt:message key="createDataElement.heading"/></h1>
	<form:form method="put" commandName="createDataElement">
	 <input type="hidden" name="_method" value="PUT"/>
     <p>please enter data element details</p>
	  <center>
	  <table  width="65%" border="1" cellspacing="0" cellpadding="5">
	    <tr>
	      <td align="center" width="20%">Term:</td>
	        <td width="20%">
	          <form:input path="term"/>
	        </td>
	    </tr>
	    <tr>
	      <td align="center" width="20%">Description8:</td>
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
	          <form:select path="administrativestatus" >
	                <form:option value='1'>No Pending Changes</form:option>
	                <form:option value='2'>Scheduled For Review</form:option>
	                <form:option value="3">Under Review</form:option>
	                <form:option value='4'>Changes Pending</form:option>
	           </form:select>
	        </td>
	    </tr>


  </table>
  </center>
  <br>
  <input type="submit" align="center" value="Execute">
</form:form>	
</div>
<%@ include file="footer.jsp" %>