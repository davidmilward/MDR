<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@ include file="/WEB-INF/jsp/header.jsp" %>

<h1><fmt:message key="heading"/></h1>
<div id="content"></div>


<h2>Data Element:</h2><br>

  
  <form:form method="post" commandName="updateModel" >

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
        <form:select path="registrationStatus">
        	<form:options path="registrationStatus" items="${registrationStatusList}" /></td>
        </form:select>
    </tr>
    <tr>
      <td align="center" width="20%">(Registered by)I am:<form:errors path="registeredBy" cssClass="errors"/></td>
      <td width="20%">
      <form:select path="registeredBy">
      	<form:options items="${personList}" itemValue="id" itemLabel="fullName" size="30" maxlength="80" />
      </form:select></td>
    </tr>
    <tr>
      <td align="center" width="20%">(Administered by)Working for:<form:errors path="administeredBy" cssClass="errors"/></td>
        <td width="20%">
        <form:select path="administeredBy" >
         		<form:options items="${personList}" itemValue="id" itemLabel="fullName" size="30" maxlength="80" />
          </form:select>
        </td>
    </tr>
    <tr>
      <td align="center" width="20%">Submittedby:<form:errors path="submittedby" cssClass="errors"/></td>
        <td width="20%">
        <form:select path="submittedby" >
         		<form:options items="${personList}" itemValue="id" itemLabel="fullName" size="30" maxlength="80" />
          </form:select>
        </td>
    </tr>
    <tr>
      <td align="center" width="20%">Classifiedby:<form:errors path="classifiedBy" cssClass="errors"/></td>
        <td width="20%">
        <form:select path="classifiedBy" >
         		<form:options items="${personList}" itemValue="id" itemLabel="fullName" size="30" maxlength="80" />
          </form:select>
        </td>
    </tr>
    <tr>
      <td align="center" width="20%">Comments:<form:errors path="comments" cssClass="errors"/></td>
        <td width="20%">
          <form:input path="comments"/>
        </td>
    </tr>
    <tr>
      <td align="center" width="20%">Classification:<form:errors path="classification" cssClass="errors"/></td>
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
      <td align="center" width="20%">Administrative Status:<form:errors path="administrativeStatus" cssClass="errors"/></td>
        <td width="20%">
          <form:select path="administrativeStatus" >
                <form:option value='1'>No Pending Changes</form:option>
                <form:option value='2'>Scheduled For Review</form:option>
                <form:option value="3">Under Review</form:option>
                <form:option value='4'>Changes Pending</form:option>
           </form:select>
        </td>
    </tr>
  <input type="submit" align="center" value="Update">
  </table>
</form:form>

    <a href="<c:url value="welcome"/>">Home</a>	
	<ul>
		<li> <a href="?locale=en_us">us</a> |  <a href="?locale=en_gb">gb</a> | <a href="?locale=es_es">es</a> | <a href="?locale=de_de">de</a> </li>
	</ul>	
</div>



<%@ include file="/WEB-INF/jsp/footer.jsp" %>