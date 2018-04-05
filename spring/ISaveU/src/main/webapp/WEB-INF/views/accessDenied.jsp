<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%
	String root = request.getContextPath();
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link href="<%=root%>/css/style2.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css" />
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<title>ERROR</title>
</head>
<body>
 	<div class ="panel panel-default">
 		<div class="panel-body">
 			<div class= "alert alert-danger" role = "alert">
 				<h1> Sorry, you do not hava permission to view this page.</h1>
 				Click Login at <a href="/">here</a>
 			</div>
 		</div>
	</div>

</body>
</html>