<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@ include file="/WEB-INF/jsp/header.jsp" %>

<html>
<body>
<h1><fmt:message key="heading"/></h1>
<h2>Artefact Added</h2>
 
Artefact Name : ${model.Artefact.artefacturl} <br/>
Model Name : ${model.Artefact.modelid} <br/>
Artefact notes : ${model.Artefact.notes} <br/>
 <br/>
 <a href="<c:url value="vocabWelcome.htm"/>">Home</a>
</body>
</html>

<%@ include file="/WEB-INF/jsp/footer.jsp" %>