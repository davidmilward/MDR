<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@ include file="/WEB-INF/jsp/header.jsp" %>


<html> 
<body>
<h2>Model Details</h2>
 
<form:form method="POST" commandName="Model">
<p>New Model - please enter details</p>
  <table width="65%" bgcolor="f8f8ff" border="1" cellspacing="0" cellpadding="5">
    <tr>
      <td align="center" width="20%">Name:</td>
        <td width="20%">
          <form:input path="name"/>
        </td>
    </tr>
    <tr>
      <td align="center" width="20%">Description:</td>
        <td width="20%">
          <form:input path="description"/>
        </td>
    </tr>
    <tr>
      <td align="center" width="20%">Namespace:</td>
        <td width="20%">
          <form:input path="namespace"/>
        </td>
    </tr>
    <tr>
      <td align="center" width="20%">Registration Status:</td>
        <td width="20%">
          <form:select path="registrationStatus" >
                <form:option value="Application">Application</form:option>
                <form:option value="Candidate">Candidate</form:option>
                <form:option value="Historical">Historical</form:option>
                <form:option value="Incomplete">Incomplete</form:option>
                <form:option value="Standard">Standard</form:option>
                <form:option value="Superceded">Superceded</form:option>
           </form:select>
        </td>
    </tr>
    <tr>
      <td align="center" width="20%">registeredBy:</td>
        <td width="20%">
        <form:select path="registeredBy" >
                <form:option value="John Doe">John Doe</form:option>
                <form:option value="Mike Bee">Mike Bee</form:option>
                <form:option value="Jamie Oliver">Jamie Oliver</form:option>
                <form:option value="Michelle Pfeiffer">Michelle Pfeiffer</form:option>
           </form:select>
        </td>
    </tr>
    <tr>
      <td align="center" width="20%">administeredBy:</td>
        <td width="20%">
          <form:select path="administeredBy" >
                <form:option value="John Doe">John Doe</form:option>
                <form:option value="Mike Bee">Mike Bee</form:option>
                <form:option value="Jamie Oliver">Jamie Oliver</form:option>
                <form:option value="Michelle Pfeiffer">Michelle Pfeiffer</form:option>
           </form:select>
        </td>
    </tr>
    <tr>
      <td align="center" width="20%">Submittedby:</td>
        <td width="20%">
          <form:select path="submittedby" >
                <form:option value="John Doe">John Doe</form:option>
                <form:option value="Mike Bee">Mike Bee</form:option>
                <form:option value="Jamie Oliver">Jamie Oliver</form:option>
                <form:option value="Michelle Pfeiffer">Michelle Pfeiffer</form:option>
           </form:select>
        </td>
    </tr>
    <tr>
      <td align="center" width="20%">classifiedBy:</td>
        <td width="20%">
          <form:select path="classifiedBy" >
                <form:option value="John Doe">John Doe</form:option>
                <form:option value="Mike Bee">Mike Bee</form:option>
                <form:option value="Jamie Oliver">Jamie Oliver</form:option>
                <form:option value="Michelle Pfeiffer">Michelle Pfeiffer</form:option>
           </form:select>
        </td>
    </tr>
    <tr>
      <td align="center" width="20%">Comments:</td>
        <td width="20%">
          <form:input path="comments"/>
        </td>
    </tr>
    <tr>
      <td align="center" width="20%">Classification:</td>
        <td width="20%">
           <form:select path="classification" >
                <form:option value="UML">UML</form:option>
                <form:option value="SKOS">SKOS</form:option>
                <form:option value="ClassificationA">ClassificationA</form:option>
                <form:option value="ClassificationB">ClassificationB</form:option>
           </form:select> 
        </td>
    </tr>
    <tr>
      <td align="center" width="20%">Administrative Status:</td>
        <td width="20%">
          <form:select path="administrativeStatus" >
                <form:option value="noPendingChanges">No Pending Changes</form:option>
                <form:option value="scheduledForReview">Scheduled For Review</form:option>
                <form:option value="underReview">Under Review</form:option>
                <form:option value="changesPending">Changes Pending</form:option>
           </form:select>
        </td>
    </tr>


  </table>
  <br>
  <input type="submit" align="center" value="Execute">
</form:form>
 
</body>
</html>
<%@ include file="/WEB-INF/jsp/footer.jsp" %>