<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@ include file="/WEB-INF/jsp/header.jsp" %>

<html>
<body>
<h1><fmt:message key="heading"/></h1>
<h2>Model Listing</h2>
<table>
	<c:forEach var="swmodel" items="${model.Models}">
	         <tr>
	           <td>${swmodel.name}</td>
	           <td>${swmodel.namespace}</td>
	           <td>${swmodel.description}</td>
	         </tr>
	       </c:forEach>
</table>
	 <a href="<c:url value="vocabWelcome.htm"/>">Home</a>
</body>
</html>

<%@ include file="/WEB-INF/jsp/footer.jsp" %>