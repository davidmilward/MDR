<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@ include file="/WEB-INF/jsp/header.jsp" %>


<html> 
<body>
<h2>Country Details</h2>
 
<form:form method="POST" commandName="Country">
<form:errors path="*" cssClass="errorblock" element="div"/>
<table>
 
<tr>
      <td align="right" width="20%">Country Name:</td>
        <td width="20%">
          <form:input path="name"/>
        </td>
</tr>
<tr>
      <td align="right" width="20%">2-digit Abbreviation:</td>
        <td width="20%">
          <form:input path="abbr2"/>
        </td>
</tr>
<tr>
      <td align="right" width="20%">3-digit Abbreviation:</td>
        <td width="20%">
          <form:input path="abbr3"/>
        </td>
</tr>

<tr>
<td colspan="3"><input type="submit" /></td>
</tr>

</table>
</form:form>
 
</body>
</html>
<%@ include file="/WEB-INF/jsp/footer.jsp" %>