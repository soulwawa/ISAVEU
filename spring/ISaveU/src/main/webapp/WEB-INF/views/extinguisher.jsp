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
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css"/>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script language="javascript" type="text/javascript" src="<%=root%>/js1.js"></script>
<style>
#exts1{
	width:456px;
	height:624px;
	position:relative;
	z-index:1250;
}
.result{
	float:left;
}
#ext0{
	display:none;
	position:relative;
	left:200px;
	top:205px;
}
#ext1{
	display:none;
	position:relative;
	left:120px;
	top:80px;
}
#ext2{
	display:none;
	position:relative;
	left:120px;
	top:145px;
}
#ext3{
	display:none;
	position:relative;
	left:120px;
	top:250px;
}
#ext4{
	display:none;
	position:relative;
	left:120px;
	top:375px;
}
#ext5{
	display:none;
	position:relative;
	left:165px;
	top:513px;
}
#ext6{
	display:none;
	position:relative;
	left:290px;
	bottom:80px;
}
#ext7{
	display:none;
	position:relative;
	left:290px;
	top:50px;
}
#ext8{
	display:none;
	position:relative;
	left:320px;
	top:190px;
}
#ext9{
	display:none;
	position:relative;
	left:395px;
	top:345px;
}
#ext10{
	display:none;
	position:relative;
	left:395px;
	top:390px;
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
	      success: function(data2) {
	        ob2 = data2;
	        var state = new Array();

	        for(var i = 0; i < 11; i++){
	        	var j = 600 + i;
	            var k = j.toString(); 
	        	state[i] = ob2[k];
	        	if(state[i] == 0){
	        		document.getElementById("ext"+i).style.display="none";
	        	}
	        	if(state[i] == 1){
	        		document.getElementById("ext"+i).style.display="block";
	        	}
	        	
	        }
	      }
	    });
}  
</script>
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
				<img src="<%=root%>/img/logo1.png" alt="logo" class="logo"/>
			</div>
		</div>
		<div class="sidebar">
			<div class="menuBtn" >
				<button type="button" class="btn btn-default btn-lg btn-block" onclick="goReplace('/sensor')">
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
			<div class="map">
			</div>
			<div id="exts1">
				<div class="shake-freeze" id="ext0">
					<img src="./img/extinguisher.png" alt="extinguisher" class="imgEtg"/>
				</div>
				<div class="shake-freeze" id="ext1">
					<img src="./img/extinguisher.png" alt="extinguisher" class="imgEtg"/>
				</div>
				<div class="shake-freeze" id="ext2">
					<img src="./img/extinguisher.png" alt="extinguisher" class="imgEtg"/>
				</div>
				<div class="shake-freeze" id="ext3">
					<img src="./img/extinguisher.png" alt="extinguisher" class="imgEtg"/>
				</div>
				<div class="shake-freeze" id="ext4">
					<img src="./img/extinguisher.png" alt="extinguisher" class="imgEtg"/>
				</div>
				<div class="shake-freeze" id="ext5">
					<img src="./img/extinguisher.png" alt="extinguisher" class="imgEtg"/>
				</div>
				<div class="shake-freeze" id="ext6">
					<img src="./img/extinguisher.png" alt="extinguisher" class="imgEtg"/>
				</div>
				<div class="shake-freeze" id="ext7">
					<img src="./img/extinguisher.png" alt="extinguisher" class="imgEtg"/>
				</div>
				<div class="shake-freeze" id="ext8">
					<img src="./img/extinguisher.png" alt="extinguisher" class="imgEtg"/>
				</div>
				<div class="shake-freeze" id="ext9">
					<img src="./img/extinguisher.png" alt="extinguisher" class="imgEtg"/>
				</div>
				<div class="shake-freeze" id="ext10">
					<img src="./img/extinguisher.png" alt="extinguisher" class="imgEtg"/>
				</div>
			</div>
		</div>
		<div class="footer">
			<input type="button" value="사용가능한 소화기 확인하기" onclick="checkex()"/>
			<div class="result" id="result0">
			</div>
			<div class="result" id="result1">
			</div>
			<div class="result" id="result2">
			</div>
			<div class="result" id="result3">
			</div>
			<div class="result" id="result4">
			</div>
			<div class="result" id="result5">
			</div>
			<div class="result" id="result6">
			</div>
			<div class="result" id="result7">
			</div>
			<div class="result" id="result8">
			</div>
			<div class="result" id="result9">
			</div>
			<div class="result" id="result10">
			</div>
		</div>
	</div>
</body>
</html>