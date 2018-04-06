<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Event Upload</title>
</head>
<body>
	<form id = "uploadForm" name = "uploadForm" action = "/Post" method="post" enctype="multpart/form-data">
	<input type ="file" name = "uploadfile">
	</form>
</body>
</html>