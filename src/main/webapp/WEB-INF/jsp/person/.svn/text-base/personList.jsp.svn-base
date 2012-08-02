<%@ include file="include.jsp" %>
<%@ include file="header.jsp" %>


  <body>
    <h1><fmt:message key="heading"/></h1>
    <div id="content"></div>
    <br><br/>
<h2>Persons Listing</h2>
<table class="center" width="65%" border="1" cellspacing="0" cellpadding="5">
            <tr>
	           <td align="center" width="20%">Title</td>
	           <td align="center" width="20%">First Name</td>
	           <td align="center" width="20%">Surname</td>
	           <td align="center" width="20%">Other names</td>
	           <td align="center" width="20%">Alias</td>
	           <td align="center" width="20%">Date of birth</td>
	           <td align="center" width="20%">Notes</td>
	           <td align="center" width="20%">Edit</td>
	         </tr>
	<c:forEach var="person" items="${model.Persons}">
	         <tr>
	           <td align="center" width="20%">${person.title}</td>
	           <td align="center" width="20%">${person.firstname}</td>
	           <td align="center" width="20%">${person.surname}</td>
	           <td align="center" width="20%">${person.otherNames}</td>
	           <td align="center" width="20%">${person.alias}</td>
	           <td align="center" width="20%">${person.dob}</td>
	           <td align="center" width="20%">${person.notes}</td>
	           <td align="center" width="20%"><a href="person/${person.id}">Edit</a></td>
	         </tr>
	       </c:forEach>
</table>
	

<%@ include file="footer.jsp" %>