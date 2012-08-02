<%@ include file="header.jsp" %>

<body>
    <h1><fmt:message key="heading"/></h1>
    <div id="content"></div>
    <br><br/>
    <br><br/>
    <p></p>
     <p></p>
	<h1><fmt:message key="updateValueDomain.heading"/></h1>
  
 <form:form modelAttribute="valueDomain" action="${model.ValueDomain.id}" method="post" commandName="valueDomain" >

  <table class="center">
    <tr>
        <td align="center" width="20%">Term:<form:errors path="termString" cssClass="errors"/></td>
	     <td width="20%"><form:input path="termString" size="30" maxlength="80"/>
	     <form:input type="hidden" path="adminobjectid"  />
	     </td>
    </tr>
    <tr>
      	<td align="center" width="20%">maxchar:<form:errors path="maxchar" cssClass="errors"/></td>
        <td width="20%"><form:input path="maxchar" size="30" maxlength="80"/></td>
    </tr>
    <tr>
      <td align="center" width="20%">unitofmeasure:<form:errors path="unitofmeasure" cssClass="errors"/></td>
      <td width="20%"><form:input path="unitofmeasure" size="30" maxlength="80"/></td>
    </tr>
        <tr>
      <td align="center" width="20%">permissiblevalue:<form:errors path="permissiblevalue" cssClass="errors"/></td>
      <td width="20%"><form:input path="permissiblevalue" size="30" maxlength="80"/></td>
    </tr>
            <tr>
      <td align="center" width="20%">format:<form:errors path="format" cssClass="errors"/></td>
      <td width="20%"><form:input path="format" size="30" maxlength="80"/></td>
    </tr>
            <tr>
      <td align="center" width="20%">datatype:<form:errors path="datatype" cssClass="errors"/></td>
      <td width="20%"><form:input path="datatype" size="30" maxlength="80"/></td>
    </tr>
     <tr>
	    <td align="center" width="20%">Registration Status:</td>
	        <td width="20%">
	        <form:select path="registrationStatus">
					  <form:option value="NONE" label="--- Select ---" />
					  <form:options items="${registrationStatusList}" />
			</form:select>
	    </td>
	</tr>
    <tr>
      <td align="center" width="20%">(Administered by)Working for:<form:errors path="administeredBy" cssClass="errors"/></td>
        <td width="20%">
        <form:select path="administeredby" >
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
      <td align="center" width="20%">Classifiedby:<form:errors path="classifiedby" cssClass="errors"/></td>
        <td width="20%">
        <form:select path="classifiedby" >
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
                <form:option value='UML'>UML</form:option>
                <form:option value='SKOS'>SKOS</form:option>
                <form:option value='ClassificationA'>ClassificationA</form:option>
                <form:option value='ClassificationB'>ClassificationB</form:option>
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
  
  </table>
   <input type="submit" align="center" value="Update" >
</form:form>

	
</div>



<%@ include file="footer.jsp" %>