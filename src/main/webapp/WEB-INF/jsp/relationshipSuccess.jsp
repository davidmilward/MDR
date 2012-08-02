<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@ include file="/WEB-INF/jsp/header.jsp" %>

<html>
<body>
<h1><fmt:message key="heading"/></h1>
<h2>Relationship Added</h2>
 
Relationship type : ${model.Relationship.type} <br/>
Relationship subject: ${model.Relationship.subject} <br/>
Relationship object : ${model.Relationship.object} <br/>
 <br/>
 <a href="<c:url value="vocabWelcome.htm"/>">Home</a>
</body>
</html>

<%@ include file="/WEB-INF/jsp/footer.jsp" %>