<%@ include file="../include.jsp" %>
<%@ include file="../header.jsp" %>

  <body>
    <h1><fmt:message key="heading"/></h1>
    <div id="content"></div>
    <br><br/>

<h1><fmt:message key="createPerson.heading"/></h1>
<form:form modelAttribute="person" action="person" method="post">
	<table align="center">
		  	<fieldset>		
				<legend>Details</legend>
				<p>
					<form:label	for="title" path="title" cssErrorClass="error">Title</form:label><br/>
					<form:input path="title" /> <form:errors path="title" />			
				</p>
				<p>	
					<form:label for="firstname" path="firstname" cssErrorClass="error">First Name</form:label><br/>
					<form:input path="firstname" /> <form:errors path="firstname" />
				</p>
				<p>
					<form:label for="surname" path="surname" cssErrorClass="error">Surname</form:label><br/>
					<form:input path="surname" /> <form:errors path="surname" />
				</p>
				<p>	
					<form:label for="dob" path="dob" cssErrorClass="error">Date of Birth</form:label><br/>
					<form:input path="dob" /> <form:errors path="dob" />
				</p>
				<p>	
					<input type="submit" />
				</p>
			</fieldset>
			</table>
		</form:form>


</div>
<%@ include file="../footer.jsp" %>