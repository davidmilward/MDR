<%@ include file="include.jsp" %>
<%@ include file="header.jsp" %>


<script type="text/javascript">

function changeImage(image)
{
  var x=document.getElementById(image.id);
  x.src="${pageContext.request.contextPath}/images/deleteSb.png";
  return true;
}

function changeBack(image)
{
	//alert("changeBack");
  var y=document.getElementById(image.id);
  y.src="${pageContext.request.contextPath}/images/deleteS.png";
  return true;
}

function changeUpdateImage(image)
{
	//alert("changeUpdateImage");
  var z=document.getElementById(image.id);
  z.src="${pageContext.request.contextPath}/images/updateSb.png";
  return true;
}

function changeUpdateBack(image)
{
	//alert("changeUpdateBack");
  var p=document.getElementById(image.id);
  p.src="${pageContext.request.contextPath}/images/updateS.png";
  return true;
}
function deleteDataElement(deid){
	var r=confirm("Are you sure you want to delete this data element, id=" + deid.name);
	if (r==true){deid.submit();}
}
function updateDataElement(deid){
	//alert("TESTING");
	var r=confirm("Are you sure you want to update this data element, id=" + deid.name);
	if (r==true) {deid.submit();}	
}
function viewDataElement(deid){
	var r=confirm("Are you sure you want to view this data element, id=" + deid.name);
	if (r==true){deid.submit();}	
}
</script>

<body>
    <h1><fmt:message key="heading"/></h1>
    <div id="content"></div>
    <br><br/>
	<h2>Data Element Listing</h2>
	<table class="center">
		<c:forEach var="dataElement" items="${model.DEList}">
		         <tr>
		           <td>${dataElement.description}</td>
		           <td>${dataElement.definition}</td>
		           <td>${dataElement.comments}</td>
		           <td>${dataElement.createdBy}</td>
		           <td>${dataElement.administrativeStatus}</td>
		           <td>${dataElement.registrationStatus}</td>
		           <td><form:form method="get" name="vform${dataElement.dataElementId}" action="${pageContext.request.contextPath}/dataelement/${dataElement.dataElementId}/de" >
		               <a href="#" onClick="javascript: return viewDataElement(vform${dataElement.dataElementId})" 
		                           onMouseOver="javascript: return changeUpdateImage(vwButton${dataElement.dataElementId})"  
		                           onMouseOut="javascript: return changeUpdateBack(vwButton${dataElement.dataElementId})">
		               <img id="vwButton${dataElement.dataElementId}" src="${pageContext.request.contextPath}/images/updateS.png" />
		              </a></form:form></td>
		           <td><form:form method="post" name="uform${dataElement.dataElementId}" action="${pageContext.request.contextPath}/dataelement/${dataElement.dataElementId}/de" >
		               <a href="#" onClick="javascript: return updateDataElement(uform${dataElement.dataElementId})" 
		                           onMouseOver="javascript: return changeUpdateImage(upButton${dataElement.dataElementId})"  
		                           onMouseOut="javascript: return changeUpdateBack(upButton${dataElement.dataElementId})">
		               <img id="upButton${dataElement.dataElementId}" src="${pageContext.request.contextPath}/images/updateS.png" /></a></form:form></td>
		           <td><form:form method="delete" name="form${dataElement.dataElementId}" action="${pageContext.request.contextPath}/dataelement/${dataElement.dataElementId}/de">
		               <a href="#" onClick="javascript: return deleteDataElement(form${dataElement.dataElementId})" 
		                           onMouseOver="javascript: return changeImage(delButton${dataElement.dataElementId})"  
		                           onMouseOut="javascript: return changeBack(delButton${dataElement.dataElementId})" >
		               <input type="hidden" name="_method" value="delete"/>
		           	   <img id="delButton${dataElement.dataElementId}" src="${pageContext.request.contextPath}/images/deleteS.png" /></a></form:form></td>
		         </tr>
		       </c:forEach>
	</table>

<%@ include file="footer.jsp" %>