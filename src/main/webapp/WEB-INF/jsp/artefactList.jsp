<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@ include file="/WEB-INF/jsp/header.jsp" %>

<html>
<body>
<h1><fmt:message key="heading"/></h1>
<h2>Artefact Listing</h2>
<table>
	<c:forEach var="artefact" items="${model.Artefacts}">
	         <tr>
	           <td>${artefact.modelid}</td>
	           <td>${artefact.externalid}</td>
	           <td>${artefact.artefacturl}</td>
	         </tr>
	       </c:forEach>
</table>
	 <a href="<c:url value="vocabWelcome.htm"/>">Home</a>
</body>
</html>

<%@ include file="/WEB-INF/jsp/footer.jsp" %>