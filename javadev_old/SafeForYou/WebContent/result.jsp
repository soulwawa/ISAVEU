<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script>
  function requestAjax() {
    $.ajax({
      type: "GET",
      url: "http://localhost:8088/SafeForYou/Dispatcher",
      dataType: "json",
      success: function(data) {
        ob = data;
        
        var result1 = document.getElementById("result1");
        result1.innerHTML = ob.code+", "+ob.msg;
      }
    });
  }
</script>
<title>JSP</title>
</head>
<body>
<div id="result1">

</div>
<input type="button" value="ajax전송" onclick="requestAjax()">
</body>
</html>
