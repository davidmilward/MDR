<%@ include file="include.jsp" %>
<%@ include file="header.jsp" %>

</script>
<h1><fmt:message key="heading"/></h1>
<div id="content"></div>


<h2>You have just deleted this Data Element:</h2><br>
 <form:form modelAttribute="dataElement" action="${model.DataElement.deid}" method="post" >
  <table class="center">
    <tr>
      	<td align="center" width="20%">Description:<form:errors path="description" cssClass="errors"/></td>
        <td width="20%"><form:input path="description"  readonly="true"  size="30" maxlength="80"/></td>
    </tr>
    <tr>
      <td align="center" width="20%">Definition:<form:errors path="definition" cssClass="errors"/></td>
      <td width="20%"><form:input path="definition" readonly="true"  size="30" maxlength="80"/></td>
    </tr>
    <tr>
	     <td align="center" width="20%">Term:<form:errors path="termString" cssClass="errors"/></td>
	     <td width="20%"><form:input path="termString" size="30" maxlength="80"/>
	     <form:input type="hidden" path="adminObjectID"  />
	     </td>
    </tr>
    <tr>
        <td align="center" width="20%">Registration Status:</td>
        <td width="20%">
        <form:input readonly="true" path="registrationStatus"  size="30" maxlength="80"/>
    </tr>
    <tr>
      <td align="center" width="20%">(Registered by)I am:<form:errors path="registeredby" cssClass="errors"/></td>
      <td width="20%">
      <form:input readonly="true" path="registeredby" size="30" maxlength="80"/>
      </td>
    </tr>
    <tr>
      <td align="center" width="20%">(Administered by)Working for:<form:errors path="administeredby" cssClass="errors"/></td>
        <td width="20%">
        <form:input readonly="true" path="administeredby" size="30" maxlength="80"/>
        </td>
    </tr>
    <tr>
      <td align="center" width="20%">Submittedby:<form:errors path="submittedby" cssClass="errors"/></td>
        <td width="20%">
        <form:input readonly="true" path="submittedby" size="30" maxlength="80"/>
        </td>
    </tr>
    <tr>
      <td align="center" width="20%">Classifiedby:<form:errors path="classifiedby" cssClass="errors"/></td>
        <td width="20%">
        <form:input readonly="true" path="classifiedby" size="30" maxlength="80"/>
        </td>
    </tr>
    

  </table>

</form:form>	
</div>


<%@ include file="footer.jsp" %>