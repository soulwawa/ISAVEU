<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<% String root = request.getContextPath(); %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link href="<%=root%>/css/style2.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="<%=root%>/rMateChartH5.css" />
<script language="javascript" type="text/javascript"
	src="<%=root%>/rMateChartH5License.js"></script>
<script language="javascript" type="text/javascript"
	src="<%=root%>/rMateIntegrationH5.js"></script>
<script type="text/javascript" src="<%=root%>/theme.js"></script>
<script language="javascript" type="text/javascript" src="<%=root%>/cylinder.js"></script>
<script language="javascript" type="text/javascript" src="<%=root%>/line4.js"></script>
<script language="javascript" type="text/javascript" src="<%=root%>/js1.js"></script>
<script>
	var data1;
	var data2;
	var data3;
	var data4;
	var data5;
   var interval = setInterval(function () {
    $.ajax({
      type: "GET",
      url: "http://192.168.0.35:9999/Dispatcher",
      dataType: "json",
      success: function(data) {
        ob = data;
        
        var result1 = document.getElementById("result1");
        
        
        result1.innerHTML = "온도:"+ob.temp+",진동 "+ob.gyro+",CO "+ob.smoke+",불꽃 "+ob.fire+", "+ob.date;
        
        
        document.getElementById("chart1").setData([parseInt(ob.temp)]);
        document.getElementById("chart2").setData([parseInt(ob.gyro)]);
        document.getElementById("chart3").setData([parseInt(ob.smoke)]);
        document.getElementById("chart4").setData([parseInt(ob.fire)]);
        console.log("온도:"+ob.temp+",진동 "+ob.gyro+",CO "+ob.smoke+",불꽃 "+ob.fire+", "+ob.date);
        if([parseInt(ob.temp)] > 40) {
        	showAlert();
        }

      }
    });
  }, 9900);
  var interval = setInterval(function () {
	    $.ajax({
	      type: "GET",
	      url: "http://192.168.0.35:9999/DispatcherRecent?num=12",
	      dataType: "json",
	      success: function(data2) {
	        ob2 = data2;
	        console.log(ob2);
	        var result2 = document.getElementById("content3");
	        result2.innerHTML = ob2.temp;
	        
	        
	        document.getElementById("chart5").setData(ob2);
	      }
	    });
	  }, 9900);
  
  $(window).on("unload", function(){
	    alert("call");
	    console.log("this will be triggered");
	}); 
</script>
<style>
.info {
	width: 500px;
	height: 400px;
	position: absolute;
	background-color: transparent !important;
	left: 42px;
	top:60px;
}

.value {
	margin: 0;
	padding: 15px 20px;
	height: 100px;
	width: 500px;
	background-color: transparent !important;
	text-align: center;
}
</style>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css"/>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<title>관리자 페이지</title>

</head>
<body>
	<div class="wrapper">
		<div class="alert" id="art" >
			화재 발생
			<div id="fireBtn" onclick="closeAlert()">위치확인</div>			
		</div>
		<div class="location" id="lct" onclick="closeLocation()">
			<div id="fire">
			<div id="exts1">
				<div class="shake-freeze" id="ex0">
					<img src="./img/extinguisher.png" alt="extinguisher" class="imgEtg" name="etgs1"/>
				</div>
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
			</div>
			</div>
		</div>
		<div class="header">
			<div class="case" onclick="goReplace('/admin')">
				<img src="<%=root%>/img/logo1.png" alt="logo" class="logo" />
			</div>
		</div>
		<div class="sidebar">
			<div class="menuBtn" id="btnSensor">
				<button type="button" class="btn btn-default btn-lg btn-block" onclick="goReplace('/sensor1')">
  					<span class="glyphicon glyphicon-tasks" ></span> Sensor Log
				</button>
			</div>
			<div class="menuBtn" id="btnSensor">
				<button type="button" class="btn btn-default btn-lg btn-block" onclick="goReplace('/sensor2')">
  					<span class="glyphicon glyphicon-tasks" ></span> Sensor Log
				</button>
			</div>
			<div class="menuBtn" >
				<button type="button" class="btn btn-default btn-lg btn-block" onclick="goReplace('/event')">
  					<span class="glyphicon glyphicon-alert" ></span> Envent Log
				</button>
			</div>
			<div class="menuBtn" >
				<button type="button" class="btn btn-default btn-lg btn-block" onclick="goReplace('/stream')">
  					<span class="glyphicon glyphicon-play-circle" ></span> Striming
				</button>
			</div>
			<div class="menuBtn" >
				<button type="button" class="btn btn-default btn-lg btn-block" onclick="goReplace('/hr')">
  					<span class="glyphicon glyphicon-user" ></span> H.R
				</button>
			</div>
			<div class="menuBtn" >
				<button type="button" class="btn btn-default btn-lg btn-block" onclick="goReplace('/ex')">
  					<span class="glyphicon glyphicon-map-marker"></span> Map
				</button>
			</div>
			<input type="button" value="불내기" onclick="showAlert()"/>
		</div>
		<div class="contents">
			<div id="floor1">
				<div class="area" id="a1">
					<div id="content1"
						style="height: 400px; width: 550; position: relative;">
						<!-- 차트가 삽입될 DIV -->
						<div id="chartHolder1" class="chartHolder" style="height: 100px;"></div>
						<div id="chartHolder2" class="chartHolder" style="height: 100px;"></div>
						<div id="chartHolder3" class="chartHolder" style="height: 100px;"></div>
						<div id="chartHolder4" class="chartHolder" style="height: 100px;"></div>
					</div>
					<div class="info">
						<div class="value">실시간 온도 센서값</div>
						<div class="value">실시간 진동 센서값</div>
						<div class="value">실시간 CO 센서값</div>
						<div class="value">실시간 불꽃 센서값</div>
					</div>
				</div>
				<div class="area" id="a2">
					<div id="content2"
						style="height: 400px; width: 550; position: relative;">
						<div id="chartHolder5" class="chartHolder" style="height: 400px; width: 550;"></div>
					</div>
				</div>
			</div>
			<div id="floor2">
				<div class="area" id="a3">
					<div id="content3"
						style="height: 400px; width: 550; position: relative;">
					</div>
				</div>
				<div class="area" id="a4">
					<div id="content4"
						style="height: 400px; width: 550; position: relative;">
					</div>
				</div>
			</div>
		</div>
		<div class="footer">
			<div style="padding: 7px;">Copyright © 2018 HSB Inc.</div>
			<div>
				<div id="result1"></div>
				<div id="result2"></div>
				<div id="result3"></div>
				<div id="result4"></div>
			</div>
		</div>
	</div>
</body>
</html>