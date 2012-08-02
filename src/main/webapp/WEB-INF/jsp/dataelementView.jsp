<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@ include file="/WEB-INF/jsp/header.jsp" %>

  <body>
    <h1><fmt:message key="heading"/></h1>
    <div id="content"></div>
    <br><br/>
<%--     <h3><fmt:message key="greeting"/></h3>	 --%>
<div id="content"></div>
<h1><fmt:message key="viewDataElement.heading"/></h1>
<!-- <div class="container"> -->
<!-- 	<div class="span-12 last">	 -->
		<form:form modelAttribute="dataElement" action="${model.DataElement.id}" method="post">
		  	<fieldset bgcolor="f8f8ff" border="1" cellspacing="0" cellpadding="5">		
				<legend>Data Element Fields - view</legend>
				<p>
					<form:label	for="id" path="definition" cssErrorClass="error">ID</form:label><br/>
					<form:input path="id" /> <form:errors path="id" />			
				</p>
				<p>
					<form:label	for="adminObjectID" path="adminObjectID" cssErrorClass="error">ID</form:label><br/>
					<form:input path="adminObjectID" /> <form:errors path="adminObjectID" />			
				</p>
				<p>
					<form:label	for="valueDomainID" path="valueDomainID" cssErrorClass="error">ID</form:label><br/>
					<form:input path="valueDomainID" /> <form:errors path="valueDomainID" />			
				</p>
				
		        <p>
					<form:label	for="definition" path="definition" cssErrorClass="error">Definition</form:label><br/>
					<form:input path="definition" /> <form:errors path="definition" />			
				</p>
				<p>	
					<form:label for="termString" path="termString" cssErrorClass="error">Term</form:label><br/>
					<form:input path="termString" /> <form:errors path="termString" />
				</p>
				<p>
					<form:label for="description" path="description" cssErrorClass="error">Description</form:label><br/>
					<form:input path="description" /> <form:errors path="description" />
				</p>
				<p>	
					<form:label for="comments" path="comments" cssErrorClass="error">Comments</form:label><br/>
					<form:input path="comments" /> <form:errors path="comments" />
				</p>
								<p>	
					<form:label for="dateFirstActive" path="dateFirstActive" cssErrorClass="error">Date First Active</form:label><br/>
					<form:input path="dateFirstActive" /> <form:errors path="dateFirstActive" />
				</p>
								<p>	
					<form:label for="createdBy" path="createdBy" cssErrorClass="error">Created By</form:label><br/>
					<form:input path="createdBy" /> <form:errors path="createdBy" />
				</p>
								<p>	
					<form:label for="lastModifiedOn" path="lastModifiedOn" cssErrorClass="error">Last Modified</form:label><br/>
					<form:input path="lastModifiedOn" /> <form:errors path="lastModifiedOn" />
				</p>
								<p>	
					<form:label for="registrationStatus" path="registrationStatus" cssErrorClass="error">Registration Status</form:label><br/>
					<form:input path="registrationStatus" /> <form:errors path="registrationStatus" />
				</p>
								<p>	
					<form:label for="classification" path="classification" cssErrorClass="error">Classification</form:label><br/>
					<form:input path="classification" /> <form:errors path="classification" />
				</p>
				
			</fieldset>
		</form:form>
    <a href="<c:url value="welcome"/>">Home</a>	
	<ul>
		<li> <a href="?locale=en_us">us</a> |  <a href="?locale=en_gb">gb</a> | <a href="?locale=es_es">es</a> | <a href="?locale=de_de">de</a> </li>
	</ul>	
</div>
</body>
</html>