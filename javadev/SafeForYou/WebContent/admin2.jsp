<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<% String root = request.getContextPath(); %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link href="<%=root%>/css/style2.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" type="text/css" href="./rMateChartH5.css"/>
<script language="javascript" type="text/javascript" src="./rMateChartH5License.js"></script>
<script language="javascript" type="text/javascript" src="./rMateGaugeChartH5.js"></script>
<script type="text/javascript" src="./theme.js"></script>
<script language="javascript" type="text/javascript" src="./cylinder.js"></script>
<script type="text/javascript" src="./common.js"></script>
<script type="text/javascript" src="./sample_util.js"></script>
<link rel="stylesheet" type="text/css" href="./sample.css"/>
<script type="text/javascript" src="./shCore.js"></script>
<script type="text/javascript" src="./shBrushJScript.js"></script>
<link type="text/css" rel="stylesheet" href="./shCoreDefault.css"/>
<script>
  var interval = setInterval(function () {
    $.ajax({
      type: "GET",
      url: "http://localhost:8088/SafeForYou/Dispatcher",
      dataType: "json",
      success: function(data) {
        ob = data;
        
        var result1 = document.getElementById("result1");
        
        
        result1.innerHTML = ob.temp+", "+ob.msg;

        
        document.getElementById("chart1").setData([parseInt(ob.temp)]);
        console.log(ob.temp);

      }
    });
  }, 1000);
  function setTimeout() { clearInterval(interval);
  }
  

</script>
<style>

</style>
<title>관리자 페이지</title>

</head>
<body>
	<div class="wrapper">
		<div class="header">
			<div class="case">
				<img src="<%=root%>/img/logo1.png" alt="logo" class="logo"/>
			</div>
		</div>
		<div class="sidebar">
			<div class="menuBtn">
			sensor log
			</div>
			<div class="menuBtn">
			sensor log
			</div>
			<div class="menuBtn">
			streaming
			</div>
			<div class="menuBtn">
			HR table
			</div>
			<div class="menuBtn">
			location info
			</div>
			<div class="menuBtn">
			fire extinguosher
			</div>

		</div>
		<div class="contents">
			<div id="content">
			<!-- 차트가 삽입될 DIV -->
			<div id="chartHolder"></div>
		</div>

		</div>
		<div class="footer">
		<div id="result1">

		</div>
		<div id="result2">

		</div>
		<div id="result3">

		</div>
		<div id="result4">

		</div>
		<input type="button" value="종료" onclick="setTimeout()"/>
		</div>
	</div>
</body>
</html>