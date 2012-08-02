<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@ include file="/WEB-INF/jsp/header.jsp" %>


<html> 
<body>
<h2>Country Details</h2>
 
<form:form method="POST" commandName="ClassificationSchemeType">
<form:errors path="*" cssClass="errorblock" element="div"/>
<table>
 
<tr>
      <td align="right" width="20%">Classification Scheme Type Name:</td>
        <td width="20%">
          <form:input path="typename"/>
        </td>
</tr>
<tr>
      <td align="right" width="20%">Description:</td>
        <td width="20%">
          <form:input path="description"/>
        </td>
</tr>
<tr>
      <td align="right" width="20%">URL:</td>
        <td width="20%">
          <form:input path="url"/>
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