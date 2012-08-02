<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@ include file="/WEB-INF/jsp/header.jsp" %>

<html>
<body>
<h1><fmt:message key="heading"/></h1>
<h2>Data Element Listing</h2>
<table>
	<c:forEach var="dataElement" items="${model.DEList}">
	         <tr>
	           <td>${dataElement.description}</td>
	           <td>${dataElement.definition}</td>
	           <td>${dataElement.comments}</td>
	           <td>${dataElement.createdBy}</td>
	           <td>${dataElement.administrativeStatus}</td>
	           <td>${dataElement.registrationStatus}</td>
	         </tr>
	       </c:forEach>
</table>
	 <a href="<c:url value="welcome"/>">Home</a>
</body>
</html>

<%@ include file="/WEB-INF/jsp/footer.jsp" %>