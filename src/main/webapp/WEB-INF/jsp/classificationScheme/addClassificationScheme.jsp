<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@ include file="/WEB-INF/jsp/header.jsp" %>

<script type="text/javascript" src="<c:url value="/resources/jquery/1.6/jquery.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/jqueryform/2.8/jquery.form.js" />"></script>	
  <body>
    <h1><fmt:message key="heading"/></h1>
    <div id="content"></div>
    <br><br/>

<h1><fmt:message key="addClassificationScheme.heading"/></h1>
<form:form method="post" commandName="classificationScheme" enctype="multipart/form-data">
<p>Add a new Classification Scheme</p>
  <class="center" width="65%" border="1" cellspacing="0" cellpadding="5">
    <tr>
        <td align="center" width="20%">Name:</td>
        <td width="20%">
          <form:input path="name"/>
        </td>
    </tr>
    <tr>
        <td align="center" width="20%">File:</td>
        <td width="20%">
            <input type="file" name="file"/>
		</td>
	</tr>
  </table>
  <br>
  <input type="submit" align="center" value="Add">
</form:form>
<script type="text/javascript">
			$(document).ready(function() {
				$('<input type="hidden" name="ajaxUpload" value="true" />').insertAfter($("#file"));
				$("#fileuploadForm").ajaxForm({ success: function(html) {
						$("#fileupload").replaceWith(html);
					}
				});
			});
		</script>	
<%@ include file="/WEB-INF/jsp/footer.jsp" %>