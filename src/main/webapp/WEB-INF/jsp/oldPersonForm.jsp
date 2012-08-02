


<html> 
<body>
<h2>Add Person Details</h2>
 
<form:form method="POST" commandName="Person">
<form:errors path="*" cssClass="errorblock" element="div"/>
<table>
 
<tr>
      <td align="right" width="20%">Title:</td>
        <td width="20%">
         <form:select path="title" >
                <form:option value="Application">Dr</form:option>
                <form:option value="Candidate">Mr</form:option>
                <form:option value="Historical">Ms</form:option>
                <form:option value="Incomplete">Mrs</form:option>
                <form:option value="Standard">Miss</form:option>
           </form:select>
        </td>
</tr>
<tr>
      <td align="right" width="20%">First name:</td>
        <td width="20%">
          <form:input path="firstname"/>
        </td>
</tr>
<tr>
      <td align="right" width="20%">Surname:</td>
        <td width="20%">
          <form:input path="surname"/>
        </td>
</tr>
<tr>
      <td align="right" width="20%">Other names:</td>
        <td width="20%">
          <form:input path="otherNames"/>
        </td>
</tr>
<tr>
      <td align="right" width="20%">Alias:</td>
        <td width="20%">
          <form:input path="alias"/>
        </td>
</tr>
<tr>
      <td align="right" width="20%">Date of Birth:</td>
        <td width="20%">
          <form:input path="dob"/>
        </td>
</tr>
<tr>
      <td align="right" width="20%">Notes:</td>
        <td width="20%">
          <form:input path="notes"/>
        </td>
</tr>

<tr>
<td colspan="3"><input type="submit" /></td>
</tr>

</table>
</form:form>
 
</body>
</html>
<%@ include file="/WEB-INF/jsp/footer.jsp" %>