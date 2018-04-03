<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script>
var interval = setInterval(function () {
    $.ajax({
      type: "GET",
      url: "http://newsky2.kma.go.kr/service/SecndSrtpdFrcstInfoService2/ForecastSpaceData?ServiceKey=fCBf9%2BEssgTckRkXRJ56vel6HpV1whICUYyn8rcJLvktz43DLXJOiFALDWdMmWAlO%2BhlwLxKCXVnZPXHf3TbPQ%3D%3D&nx=60&ny=127&base_date=20180402&base_time=2100",
      dataType: "json",
      success: function(data) {
        ob = data;
        var result1 = document.getElementById("result1");
        result1.innerHTML = ob;
        console.log(ob);
        alert("성공");

      }
    });
}, 9900);
</script>
<title>Insert title here</title>
</head>
<body>

	<div id="result1">
	</div>

</body>
</html>