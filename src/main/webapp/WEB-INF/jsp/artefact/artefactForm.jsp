<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@ include file="/WEB-INF/jsp/header.jsp" %>


<html> 
<body>
<h2>Artefact</h2>
 
<form:form method="POST" commandName="Artefact">
<form:errors path="*" cssClass="errorblock" element="div"/>
<table>
 
<tr>
      <td align="right" width="20%">Artefact URL:</td>
        <td width="20%">
          <form:input path="artefacturl"/>
        </td>
</tr>
<tr>
      <td align="right" width="20%">Model ID:</td>
        <td width="20%">
          <form:input path="modelid"/>
        </td>
</tr>
<tr>
      <td align="right" width="20%">EBXML Registration id :</td>
        <td width="20%">
          <form:input path="externalid"/>
        </td>
</tr>
<tr>
      <td align="right" width="20%">Notes :</td>
        <td width="20%">
          <form:input path="notes"/>
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