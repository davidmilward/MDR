<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@ include file="/WEB-INF/jsp/header.jsp" %>

<html>
<body>
<h1><fmt:message key="heading"/></h1>
<h2>Persons Listing</h2>
<table>
	<c:forEach var="person" items="${model.Persons}">
	         <tr>
	           <td>${person.title}</td>
	           <td>${person.firstname}</td>
	           <td>${person.surname}</td>
	           <td>${person.otherNames}</td>
	           <td>${person.alias}</td>
	           <td>${person.dob}</td>
	           <td>${person.notes}</td>
	         </tr>
	       </c:forEach>
</table>
	 <a href="<c:url value="vocabWelcome.htm"/>">Home</a>
</body>
</html>

<%@ include file="/WEB-INF/jsp/footer.jsp" %>