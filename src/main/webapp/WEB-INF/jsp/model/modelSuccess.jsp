<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@ include file="/WEB-INF/jsp/header.jsp" %>

<html>
<body>
<h1><fmt:message key="heading"/></h1>
<h2>Model successfully added to the MDR</h2>
 
<%-- DE Name : ${model.dataElement.termString} <br/> --%>
<%-- Description : ${model.dataElement.description} <br/> --%>
<%-- Definition : ${model.DataElement.definition} <br/> --%>
<%-- Comments : ${model.DataElement.comments} <br/> --%>
<%-- Last Modified : ${model.DataElement.lastModifiedOn} <br/> --%>
<%-- Registration Status : ${model.registrationStatus} <br/> --%>
<%-- Classification : ${model.classification} <br/> --%>

<form:form modelAttribute="model" action="${model.id}" method="post">
		  	<fieldset  bgcolor="f8f8ff" border="1" cellspacing="0" cellpadding="5">		
				<legend>Model Fields</legend>
				
		        <p>
					<form:label	for="name" path="name" cssErrorClass="error">Name</form:label><br/>
					<form:input path="name" /> <form:errors path="name" />			
				</p>
				<p>	
					<form:label for="namespace" path="namespace" cssErrorClass="error">Namespace</form:label><br/>
					<form:input path="namespace" /> <form:errors path="namespace" />
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
<%--     <a href="<c:url value="welcome"/>">Home</a>	 --%>
<!-- 	<ul> -->
<!-- 		<li> <a href="?locale=en_us">us</a> |  <a href="?locale=en_gb">gb</a> | <a href="?locale=es_es">es</a> | <a href="?locale=de_de">de</a> </li> -->
<!-- 	</ul>	 -->

<%@ include file="/WEB-INF/jsp/footer.jsp" %>


