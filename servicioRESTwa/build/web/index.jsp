<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
  String ctxPath = request.getContextPath();
%>
<html>
  <head>
    <title>TODO supply a title</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
		<script src="<%=ctxPath%>/js/connectApi.js"></script>
		<script type="text/javascript">
			//getData();
			getChallenge();
		</script>
  </head>
  <body>
		<div>TODO write content</div>
  </body>
</html>
