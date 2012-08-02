<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@ include file="/WEB-INF/jsp/header.jsp" %>

    <body>
    <h1><fmt:message key="heading"/></h1>
    <div id="content"></div>
    <br><br/>
   


   <h1><fmt:message key="viewValueDomain.heading"/></h1>

		<form:form modelAttribute="valueDomain" action="${model.valueDomain.id}" method="get" commandName="valueDomain" >
				<p><legend>Data Element Fields - view</legend></p>
				<table class="center">
				  <tr><td>Term : </td><td>${valueDomain.termString}</td></tr>
				  <tr><td>Datatype : </td><td>${valueDomain.datatype}</td></tr>
		          <tr><td>Maxchar : </td><td>${valueDomain.maxchar}</td></tr>
		          <tr><td>Unitofmeasure : </td><td>${valueDomain.unitofmeasure}</td></tr>
		          <tr><td>DateFirstActive : </td><td>${valueDomain.dateFirstActive}</td></tr>
		          <tr><td>Comments : </td><td>${valueDomain.comments}</td></tr>
		          <tr><td>Created By : </td><td>${valueDomain.creator}</td></tr>
		          <tr><td>Submitted By : </td><td>${valueDomain.submitter}</td></tr>
		          <tr><td>Classified By : </td><td>${valueDomain.classifier}</td></tr>
		          <tr><td>Administered By : </td><td>${valueDomain.adminster}</td></tr>
		          <tr><td>Registered By : </td><td>${valueDomain.registerer}</td></tr>
		          <tr><td>Administrative Status : </td><td>${valueDomain.administrativeStatus}</td></tr>
		           <tr><td>Registration Status : </td><td>${valueDomain.registrationStatus}</td></tr>
		          <tr><td>Value Domain Ref : </td><td>${valueDomain.valuedomainid}</td></tr>	          
		          <tr><td>Date First Active : </td><td>${valueDomain.dateFirstActive}</td></tr>
		          <tr><td>Date Last Modified On : </td><td>${valueDomain.lastModifiedOn}</td></tr>  
				</table>
			
		</form:form>
    </div>
</body>
<%@ include file="footer.jsp" %>
</html>