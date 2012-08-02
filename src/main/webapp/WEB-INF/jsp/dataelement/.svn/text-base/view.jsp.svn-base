<%@ include file="include.jsp" %>
<%@ include file="header.jsp" %>

  <body>
    <h1><fmt:message key="heading"/></h1>
    <div id="content"></div>
    <br><br/>
   


   <h1><fmt:message key="viewDataElement.heading"/></h1>

		<form:form modelAttribute="dataElement" action="${model.DataElement.id}" method="get" commandName="dataElement" >
				<p><legend>Data Element Fields - view</legend></p>
				<table class="center">
				  <tr><td>Term : </td><td>${dataElement.termString}</td></tr>
				  <tr><td>Description : </td><td>${dataElement.description}</td></tr>
		          <tr><td>Definition : </td><td>${dataElement.definition}</td></tr>
		          <tr><td>Classification : </td><td>${dataElement.classification}</td></tr>
		          <tr><td>Comments : </td><td>${dataElement.comments}</td></tr>
		          <tr><td>Created By : </td><td>${dataElement.creator}</td></tr>
		          <tr><td>Submitted By : </td><td>${dataElement.submitter}</td></tr>
		          <tr><td>Classified By : </td><td>${dataElement.classifier}</td></tr>
		          <tr><td>Administered By : </td><td>${dataElement.adminster}</td></tr>
		          <tr><td>Registered By : </td><td>${dataElement.registerer}</td></tr>
		          <tr><td>Administrative Status : </td><td>${dataElement.administrativeStatus}</td></tr>
		           <tr><td>Registration Status : </td><td>${dataElement.registrationStatus}</td></tr>
		          <tr><td>Value Domain Ref : </td><td>${dataElement.valueDomainID}</td></tr>	          
		          <tr><td>Date First Active : </td><td>${dataElement.dateFirstActive}</td></tr>
		          <tr><td>Date Last Modified On : </td><td>${dataElement.lastModifiedOn}</td></tr>  
				</table>
			
		</form:form>
    </div>
<%@ include file="footer.jsp" %>