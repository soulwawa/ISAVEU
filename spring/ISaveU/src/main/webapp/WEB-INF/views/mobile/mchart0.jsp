<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link href="/css/style2.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="/css/rMateChartH5.css" />
<script type="text/javascript"
	src="/js/rMateChartH5License.js"></script>
<script type="text/javascript"
	src="/js/rMateIntegrationH5.js"></script>
<script type="text/javascript" src="/js/theme.js"></script>
<script type="text/javascript" src="/js/js1.js"></script>
<script type="text/javascript" src="/js/mchart.js"></script>
<script>
   var interval1 = setInterval(function () {
    $.ajax({
      type: "GET",
      url: "http://192.168.0.35:9999/admin/Dispatcher",
      dataType: "json",
      success: function(data) {
        ob = data;
        console.log("온도:"+ob.temp+",진동 "+ob.gyro+",CO "+ob.smoke+",불꽃 "+ob.fire+", "+ob.date);
      }
    });
  }, 9900);
  var interval2 = setInterval(function () {
	    $.ajax({
	      type: "GET",
	      url: "http://192.168.0.35:9999/admin/DispatcherRecent?num=12",
	      dataType: "json",
	      success: function(data2) {
	        ob2 = data2;
	        console.log(ob2);
	      }
	    });
	  }, 9900);
  
  $(window).on("unload", function(){
	    alert("call");
	    console.log("this will be triggered");
	    clearInterval(interval1);
	    clearInterval(interval2);
	}); 
</script>
<style>
.chartHolder{
	width:850px !important;
	height:450px !important;;
	position:relative !important;
	display:block !important;
	margin-top:10px !important;
	
}
body{
	width:850px !important;
	text-align:center !important;
}
html{
	width:850px !important;
	text-align:center !important;
}
.chart_label_container{
	margin-top:10px !important;
	float:left;
	width:850px;
	height:30px;
	z-index:2000;
	text-align:center !important;
}
.chart_label{
	position:relative !important;
	width:850px;
	height:30px;
	z-index:2500;
	text-align:center !important;
}
</style>
<title>관리자 페이지</title>

</head>
<body>
	<div id="chartHolder21" class="chartHolder" onclick="">
		<div class="chart_label_container">
			<label class="chart_label">
				Sensor 0
			</label>
		</div>
	</div>
	<div id="chartHolder22" class="chartHolder" onclick="">
		<div class="chart_label_container">
			<label class="chart_label">
				Sensor 1
			</label>
		</div>
	</div>
	<div id="chartHolder23" class="chartHolder" onclick="">
		<div class="chart_label_container">
			<label class="chart_label">
				Sensor 2
			</label>
		</div>
	</div>
	<div id="chartHolder24" class="chartHolder" onclick="">
		<div class="chart_label_container">
			<label class="chart_label">
				Sensor 3
			</label>
		</div>
	</div>
	<div id="chartHolder25" class="chartHolder" onclick="">
		<div class="chart_label_container">
			<label class="chart_label">
				Sensor 4
			</label>
		</div>
	</div>
	<div id="chartHolder26" class="chartHolder" onclick="">
		<div class="chart_label_container">
			<label class="chart_label">
				Sensor 5
			</label>
		</div>
	</div>
	<div id="chartHolder27" class="chartHolder" onclick="">
		<div class="chart_label_container">
			<label class="chart_label">
				Sensor 6
			</label>
		</div>
	</div>
	<div id="chartHolder28" class="chartHolder" onclick="">
		<div class="chart_label_container">
			<label class="chart_label">
				Sensor 7
			</label>
		</div>
	</div>
	<div id="chartHolder29" class="chartHolder" onclick="">
		<div class="chart_label_container">
			<label class="chart_label">
				Sensor 8
			</label>
		</div>
	</div>
	<div id="chartHolder30" class="chartHolder" onclick="">
		<div class="chart_label_container">
			<label class="chart_label">
				Sensor 9
			</label>
		</div>
	</div>
	<div id="chartHolder31" class="chartHolder" onclick="">
		<div class="chart_label_container">
			<label class="chart_label">
				Sensor 10
			</label>
		</div>
	</div>
</body>
</html>