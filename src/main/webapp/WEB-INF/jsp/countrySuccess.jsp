<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@ include file="/WEB-INF/jsp/header.jsp" %>

<html>
<body>
<h1><fmt:message key="heading"/></h1>
<h2>Country Addition</h2>
 
Country Name : ${model.Country.name} <br/>
2-letter abbreviation : ${model.Country.abbr2} <br/>
3-letter abbreviation : ${model.Country.abbr3} <br/>
 <br/>
 <a href="<c:url value="vocabWelcome.htm"/>">Home</a>
</body>
</html>

<%@ include file="/WEB-INF/jsp/footer.jsp" %>