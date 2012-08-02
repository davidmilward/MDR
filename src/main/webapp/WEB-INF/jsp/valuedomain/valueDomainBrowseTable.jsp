<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@ include file="/WEB-INF/jsp/header.jsp" %>

<body>
    <h1><fmt:message key="heading"/></h1>
    <div id="content"></div>
    <br><br/>
	<h2>Value Domain Listing</h2>
	<table>
		<c:forEach var="valueDomain" items="${model.VDList}">
		         <tr>
		           <td>${valueDomain.description}</td>
		           <td>${dataElement.definition}</td>
		           <td>${dataElement.comments}</td>
		           <td>${dataElement.createdBy}</td>
		           <td>${dataElement.administrativeStatus}</td>
		           <td>${dataElement.registrationStatus}</td>
		         </tr>
		       </c:forEach>
	</table>

<%@ include file="/WEB-INF/jsp/footer.jsp" %>