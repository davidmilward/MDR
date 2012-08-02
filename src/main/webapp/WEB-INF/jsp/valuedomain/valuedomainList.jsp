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
function deleteValueDomain(deid){
	var r=confirm("Are you sure you want to delete this ValueDomain, id=" + deid.name);
	if (r==true){deid.submit();}
}
function updateValueDomain(deid){
	//alert("TESTING");
	var r=confirm("Are you sure you want to update this ValueDomain, id=" + deid.name);
	if (r==true) {deid.submit();}	
}
function viewValueDomain(deid){
	var r=confirm("Are you sure you want to view this ValueDomain, id=" + deid.name);
	if (r==true){deid.submit();}	
}
</script>

<body>
    <h1><fmt:message key="heading"/></h1>
    <div id="content"></div>
    <br><br/>
	<h2>Value Domain Listing</h2>
	<table class="center">
		<c:forEach var="valueDomain" items="${model.VDList}">
		         <tr>
		           <td>${valueDomain.datatype}</td>
		           <td>${valueDomain.enumerated}</td>
		           <td>${valueDomain.format}</td>
		           <td>${valueDomain.maxchar}</td>
		           <td>${valueDomain.permissiblevalue}</td>
		           <td>${valueDomain.unitofmeasure}</td>
		           <td><form:form method="get" name="vform${valueDomain.valuedomainid}" action="${pageContext.request.contextPath}/valuedomain/${valueDomain.valuedomainid}/vd" >
		               <a href="#" onClick="javascript: return viewValueDomain(vform${valueDomain.valuedomainid})" 
		                           onMouseOver="javascript: return changeUpdateImage(vwButton${valueDomain.valuedomainid})"  
		                           onMouseOut="javascript: return changeUpdateBack(vwButton${valueDomain.valuedomainid})">
		               <img id="vwButton${valueDomain.valuedomainid}" src="${pageContext.request.contextPath}/images/updateS.png" />
		              </a></form:form></td>
		           <td><form:form method="post" name="uform${valueDomain.valuedomainid}" action="${pageContext.request.contextPath}/valuedomain/${valueDomain.valuedomainid}/vd" >
		               <a href="#" onClick "javascript: return updateValueDomain(uform${dataElement.dataElementId})" 
		                           onMouseOver="javascript: return changeUpdateImage(upButton${valueDomain.valuedomainid})"  
		                           onMouseOut="javascript: return changeUpdateBack(upButton${valueDomain.valuedomainid})">
		               <img id="upButton${valueDomain.valuedomainid}" src="${pageContext.request.contextPath}/images/updateS.png" /></a></form:form></td>
		           <td><form:form method="delete" name="form${valueDomain.valuedomainid}" action="${pageContext.request.contextPath}/valuedomain/${valueDomain.valuedomainid}/vd">
		               <a href="#" onClick "javascript: return deleteValueDomain(form${valueDomain.valuedomainid})" 
		                           onMouseOver="javascript: return changeImage(delButton${valueDomain.valuedomainid})"  
		                           onMouseOut="javascript: return changeBack(delButton${valueDomain.valuedomainid})" >
		               <input type="hidden" name="_method" value="delete"/>
		           	   <img id="delButton${valueDomain.valuedomainid}" src="${pageContext.request.contextPath}/images/deleteS.png" /></a></form:form></td>
		         </tr>
		       </c:forEach>
	</table>

<%@ include file="footer.jsp" %>