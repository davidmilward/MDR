<%@ include file="/WEB-INF/jsp/include.jsp" %>
<!DOCTYPE HTML>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
  <script src="${pageContext.request.contextPath}/js/jquery-1.6.1.js" type="text/javascript"></script>
  <script src="${pageContext.request.contextPath}/js/createMenu.js" type="text/javascript"></script>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/mdc.css"/>
  <link rel="shortcut icon" type="image/png" href="${pageContext.request.contextPath}/favicon.ico" />
  <link rel="icon" type="image/png" href="${pageContext.request.contextPath}/images/favicon.ico" />
  <fmt:setBundle basename="messages"/>
  <title><fmt:message key="welcome.title"/></title>
  <script> $(document).ready(
                    function(){ 
					        createMenu($("#content"));
							}
					);
 </script>
</head>