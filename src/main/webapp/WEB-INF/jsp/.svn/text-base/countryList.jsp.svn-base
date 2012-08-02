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
	<c:forEach var="country" items="${model.Countries}">
	         <tr>
	           <td>${country.name}</td>
	           <td>${country.abbr2}</td>
	           <td>${country.abbr3}</td>
	         </tr>
	       </c:forEach>
</table>
	 


<%@ include file="/WEB-INF/jsp/footer.jsp" %>