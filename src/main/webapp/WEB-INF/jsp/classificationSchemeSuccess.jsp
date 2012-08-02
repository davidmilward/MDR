<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@ include file="/WEB-INF/jsp/header.jsp" %>

<html>
<body>
<h1><fmt:message key="heading"/></h1>
<h2>New Classification Scheme Added</h2>
 
Classification Scheme Name : ${model.Scheme.name} <br/>
Description : ${model.Scheme.description} <br/>
Scheme Type : ${model.Scheme.schemeType} <br/>
 <br/>
 <a href="<c:url value="vocabWelcome.htm"/>">Home</a>
</body>
</html>

<%@ include file="/WEB-INF/jsp/footer.jsp" %>