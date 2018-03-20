<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="java.io.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>:: ERROR</title>
<STYLE TYPE="text/css">
td {
	font-family: Times, 굴림체;
	font-size: 11pt;
}
</STYLE>
</head>
<body>

	<h1>Error</h1>

	<hr>
	<%
	Exception ex = (Exception)request.getAttribute("error.key");
%>

	<%=ex.toString() %>
	<br>
	<pre>
<%=ex.getMessage() %>
</pre>
	<br>
	<hr>

	<h4>printStackTrace</h4>
	<pre>

<%
	ex.printStackTrace(new PrintWriter((Writer)out));
%>

</pre>

</body>
</html>