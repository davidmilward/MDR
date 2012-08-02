<%@ include file="include.jsp" %>
<%@ include file="header.jsp" %>


  <body>
    <h1><fmt:message key="heading"/></h1>
    <div id="content"></div>
    <br><br/>

<div class="container">

	<div class="span-12 last">	

		<form:form modelAttribute="person" >
		
		<table class="center" width="65%" border="1" cellspacing="0" cellpadding="5">

		  	<tr><td align="center" width="20%">
		  	    <p>
		  	    <c:choose>
					<c:when test="${person.new}">
					<c:set var="method" value="post"/>
					    <p>Add Person Details</p>
					</c:when>
					<c:otherwise>
					<c:set var="method" value="put"/>
						<p>Edit Person:</p>
					</c:otherwise>
					</c:choose>
				</p>
				</td></tr>
		        <tr>
		        <th>Title:<form:errors path="title" cssErrorClass="error"/></th>
				<td align="center" width="20%">
				         <form:select path="title" >
				                <form:option value="Dr">Dr</form:option>
				                <form:option value="Mr">Mr</form:option>
				                <form:option value="Ms">Ms</form:option>
				                <form:option value="Mrs">Mrs</form:option>
				                <form:option value="Miss">Miss</form:option>
				           </form:select>
				 </td>
				 </tr>
			
				</p></td></tr>
				<tr><td align="center" width="20%"><p>	
					<form:label for="firstname" path="firstname" cssErrorClass="error">First Name</form:label><br/>
					<form:input path="firstname" /> <form:errors path="firstname" />
				</p></td></tr>
				<tr><td align="center" width="20%"><p>
					<form:label for="surname" path="surname" cssErrorClass="error">Surname</form:label><br/>
					<form:input path="surname" /> <form:errors path="surname" />
				</p></td></tr>
				<tr><td align="center" width="20%"><p>	
					<form:label for="dob" path="dob" cssErrorClass="error">Date of Birth</form:label><br/>
					<form:input path="dob" /> <form:errors path="dob" />
				</p></td></tr>
				 <tr><td align="center" width="20%"><p>
					<form:label	for="otherNames" path="otherNames" cssErrorClass="error">Other names</form:label><br/>
					<form:input path="otherNames" /> <form:errors path="otherNames" />			
				</p></td></tr>
				<tr><td><p>	
					<form:label for="alias" path="alias" cssErrorClass="error">alias</form:label><br/>
					<form:input path="alias" /> <form:errors path="alias" />
				</p></td></tr>
				<tr><td><p>
					<form:label for="fullName" path="fullName" cssErrorClass="error">fullname</form:label><br/>
					<form:input path="fullName" /> <form:errors path="fullName" />
				</p></td></tr>
				<tr><td><p>	
					<form:label for="notes" path="notes" cssErrorClass="error">Notes</form:label><br/>
					<form:input path="notes" /> <form:errors path="notes" />
				</p></td></tr>

			<tr>
			      <td>
			        <c:choose>
			          <c:when test="${person.new}">
			            <p class="submit"><input type="submit" value="Add Person"/></p>
			          </c:when>
			          <c:otherwise>
			            <p class="submit"><input type="submit" value="Update Person"/></p>
			          </c:otherwise>
			        </c:choose>
			      </td>
			    </tr>
			    </table>
		</form:form>
	</div>
	<hr>	
	
</div>

<%@ include file="footer.jsp" %>