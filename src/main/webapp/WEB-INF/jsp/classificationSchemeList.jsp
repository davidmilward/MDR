<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@ include file="/WEB-INF/jsp/header.jsp" %>

<html>
<body>
<h1><fmt:message key="heading"/></h1>
<h2>Country Listing</h2>
<table>
	<c:forEach var="scheme" items="${model.ClassificationScheme}">
	         <tr>
	           <td>${scheme.name}</td>
	           <td>${scheme.schemetype}</td>
	           <td>${scheme.description}</td>
	         </tr>
	       </c:forEach>
</table>
	 <a href="<c:url value="vocabWelcome.htm"/>">Home</a>
</body>
</html>

<%@ include file="/WEB-INF/jsp/footer.jsp" %>