<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<% String root = request.getContextPath(); %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link href="<%=root%>/css/style2.css" rel="stylesheet" type="text/css"/>
<link href="<%=root%>/css/shake.css" rel="stylesheet" type="text/css"/>
<style>
	#exts1{
	width:456px;
	height:824px;
	position:fixed;
	z-index:1250;
	}
</style>
<script>
var interval = setInterval(function () {
    $.ajax({
      type: "GET",
      url: "http://192.168.0.35:9999/Dispatcher",
      dataType: "json",
      success: function(data) {
        live = data;
        var result2 = document.getElementById("result2");
        result2.innerHTML = "온도:"+live.temp+",진동 "+live.gyro+",CO "+live.smoke+",불꽃 "+live.fire+", "+live.msg;
        console.log("온도:"+live.temp+",진동 "+live.gyro+",CO "+live.smoke+",불꽃 "+live.fire+", "+live.msg);
      }
    });
  }, 9900);
  
function checkex(){
	$.ajax({
	      type: "GET",
	      url: "http://192.168.0.35:9999/locationFireEx.do",
	      dataType: "json",
	      success: function(data) {
	        ob = data;
	        var state0 = ob.toString(600);
	        var state1 = ob.toString(601);
	        var state2 = ob.toString(602);
	        var state3 = ob.toString(603);
	        var state4 = ob.toString(604);
	        var state5 = ob.toString(605);
	        var state6 = ob.toString(606);
	        var state7 = ob.toString(607);
	        var state8 = ob.toString(608);
	        var state9 = ob.toString(609);
	        var state10 = ob.toString(610);
	        
	        var result1 = document.getElementById("result1");
	        result1.innerHTML = state1;
	        console.log(state1);
	      }
	    });
}  
  

function sleep(gap){
	var then, now;
	then = new Date().getTime();
	now=then;
	while((now-then)<gap)
		{
			now = new Date().getTime();
		}
}

</script>
<title>관리자 페이지</title>

</head>
<body>
	<div class="wrapper">
		<div class="alert">
		</div>
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
			<div class="map">
			</div>
			<div id="exts1">
				<div class="shake-freeze" id="ex1">
					<img src="./img/extinguisher.png" alt="extinguisher" class="imgEtg" name="etgs1"/>
				</div>
				<div class="shake-freeze" id="ex2">
					<img src="./img/extinguisher.png" alt="extinguisher" class="imgEtg" name="etgs1"/>
				</div>
				<div class="shake-freeze" id="ex3">
					<img src="./img/extinguisher.png" alt="extinguisher" class="imgEtg" name="etgs1"/>
				</div>
				<div class="shake-freeze" id="ex4">
					<img src="./img/extinguisher.png" alt="extinguisher" class="imgEtg" name="etgs1"/>
				</div>
				<div class="shake-freeze" id="ex5">
					<img src="./img/extinguisher.png" alt="extinguisher" class="imgEtg" name="etgs1"/>
				</div>
				<div class="shake-freeze" id="ex6">
					<img src="./img/extinguisher.png" alt="extinguisher" class="imgEtg" name="etgs1"/>
				</div>
				<div class="shake-freeze" id="ex7">
					<img src="./img/extinguisher.png" alt="extinguisher" class="imgEtg" name="etgs1"/>
				</div>
				<div class="shake-freeze" id="ex8">
					<img src="./img/extinguisher.png" alt="extinguisher" class="imgEtg" name="etgs1"/>
				</div>
				<div class="shake-freeze" id="ex9">
					<img src="./img/extinguisher.png" alt="extinguisher" class="imgEtg" name="etgs1"/>
				</div>
				<div class="shake-freeze" id="ex10">
					<img src="./img/extinguisher.png" alt="extinguisher" class="imgEtg" name="etgs1"/>
				</div>
				<div class="shake-freeze" id="ex11">
					<img src="./img/extinguisher.png" alt="extinguisher" class="imgEtg" name="etgs1"/>
				</div>
			</div>
		</div>
		<div class="footer">
			<input type="button" value="사용가능한 소화기 확인하기" onclick="checkex()"/>
			<div id="result1">
			</div>
			<div id="result2">
			</div>
		</div>
	</div>
</body>
</html>