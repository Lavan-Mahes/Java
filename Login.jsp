<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Page</title>
</head>
<body>
<h1>JSP Page</h1>
<%
if((request.getParameter("username").equals("ramu"))&&(request.getParameter("password").equals("123"))) {
%>
<jsp:forward page="forward2.jsp"/>
<% } else { %>
<%@include file="forward.html"%>
<% } %>
</body>
</html>
