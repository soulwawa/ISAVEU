<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>사건 목록 열람</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link href="/css/style2.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css"/>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script language="javascript" type="text/javascript" src="/js/js1.js"></script>
<script>
var pagenum = 1;
var obj;
var action;
var etime;	
var module;
var dept;
var iss;
var img;
var pagesize;
setTimeout(function(){
	winload();
},200);

function winload(){
    $.ajax({
      type: "GET",
      url: "http://192.168.0.35:9999/admin/event.do",
      dataType: "json",
      success: function(data) {
        obj = data;
        if(obj.list.length % 20 != 0){
        	pagesize = parseInt(obj.list.length/20)+1;
        }else if(obj.list.length % 20 == 0){
        	pagesize = parseInt(obj.list.length/20);
        }
        for(var i = 0; i < 20; i++){
        	document.getElementById("page").innerHTML = pagenum + "(총 페이지 수 :" + pagesize + ")";
         	var counter = obj.list[i];
         	
         	if(typeof counter.action_id === "undefined"){
         		action = "null";
         	}else{
         		action = counter.action_id;
         	}
         	
         	if(typeof counter.time === "undefined"){
         		etime = "null";
         	}else{
         		etime = counter.time;
         	}
         	
         	if(typeof counter.module_id === "undefined"){
         		module = "null";
         	}else{
         		module = counter.module_id;
         	}
         	
         	if(typeof counter.dept_name === "undefined"){
         		dept = "null";
         	}else{
         		dept = counter.dept_name;
         	}
         	
         	if(typeof counter.issue === "undefined"){
         		iss = "null";
         	}else{
         		iss = counter.issue;
         	}
         	
         	if(typeof counter.url === "undefined"){
         		img = "null";
         	}else{
         		img = counter.url;
         	}
         	
         	document.getElementById("t"+i+"0").innerHTML=action;
         	document.getElementById("t"+i+"1").innerHTML=etime;
         	document.getElementById("t"+i+"2").innerHTML=module;
         	document.getElementById("t"+i+"3").innerHTML=dept;
         	
         	if(iss == 1){
        		document.getElementById("t"+i+"4").innerHTML="화재";
        	}else if(iss == 2){
        		document.getElementById("t"+i+"4").innerHTML="지진";
        	}else if(iss == 3){
        		document.getElementById("t"+i+"4").innerHTML="화재, 지진";
        	}else{
        		document.getElementById("t"+i+"4").innerHTML=iss;
        	}

        	document.getElementById("t"+i+"5").innerHTML = "<p id=\"photo\" onclick=\"showphoto(\'"+img+"\')\">"+img+"</p>";
      	}
      }
    });
}
    
function nextpage() {
	if(pagenum == pagesize-1){
		pagenum = pagenum + 1;
		document.getElementById("page").innerHTML = pagenum + "(총 페이지 수 :" + pagesize + ")";
		for(var i = 0; i < (obj.list.length - (pagenum-1)*20); i++){
			var k = ((pagenum-1)*20) + i;
	     	var counter = obj.list[k];
         	
	     	if(typeof counter.action_id === "undefined"){
         		action = "null";
         	}else{
         		action = counter.action_id;
         	}
         	
         	if(typeof counter.time === "undefined"){
         		etime = "null";
         	}else{
         		etime = counter.time;
         	}
         	
         	if(typeof counter.module_id === "undefined"){
         		module = "null";
         	}else{
         		module = counter.module_id;
         	}
         	
         	if(typeof counter.dept_name === "undefined"){
         		dept = "null";
         	}else{
         		dept = counter.dept_name;
         	}
         	
         	if(typeof counter.issue === "undefined"){
         		iss = "null";
         	}else{
         		iss = counter.issue;
         	}
         	
         	if(typeof counter.url === "undefined"){
         		img = "null";
         	}else{
         		img = counter.url;
         	}
         	
         	document.getElementById("t"+i+"0").innerHTML=action;
         	document.getElementById("t"+i+"1").innerHTML=etime;
         	document.getElementById("t"+i+"2").innerHTML=module;
         	document.getElementById("t"+i+"3").innerHTML=dept;
         	
         	if(iss == 1){
        		document.getElementById("t"+i+"4").innerHTML="화재";
        	}else if(iss == 2){
        		document.getElementById("t"+i+"4").innerHTML="지진";
        	}else if(iss == 3){
        		document.getElementById("t"+i+"4").innerHTML="화재, 지진";
        	}else{
        		document.getElementById("t"+i+"4").innerHTML=iss;
        	}

        	document.getElementById("t"+i+"5").innerHTML = "<p id=\"photo\" onclick=\"showphoto(\'"+img+"\')\">"+img+"</p>";
      	}
		for(var i = (obj.list.length - (pagenum-1)*20); i < 20; i++){
			document.getElementById("t"+i+"0").innerHTML="-";
         	document.getElementById("t"+i+"1").innerHTML="";
         	document.getElementById("t"+i+"2").innerHTML="";
         	document.getElementById("t"+i+"3").innerHTML="";
         	document.getElementById("t"+i+"4").innerHTML="";
         	document.getElementById("t"+i+"5").innerHTML="";
		}
	}else if(pagenum < pagesize){
		pagenum = pagenum + 1;
		document.getElementById("page").innerHTML = pagenum + "(총 페이지 수 :" + pagesize + ")";
			for(var i = 0; i < 20; i++){
				
				var k = ((pagenum-1)*20) + i;
		     	var counter = obj.list[k];
	         	
		     	if(typeof counter.action_id === "undefined"){
	         		action = "null";
	         	}else{
	         		action = counter.action_id;
	         	}
	         	
	         	if(typeof counter.time === "undefined"){
	         		etime = "null";
	         	}else{
	         		etime = counter.time;
	         	}
	         	
	         	if(typeof counter.module_id === "undefined"){
	         		module = "null";
	         	}else{
	         		module = counter.module_id;
	         	}
	         	
	         	if(typeof counter.dept_name === "undefined"){
	         		dept = "null";
	         	}else{
	         		dept = counter.dept_name;
	         	}
	         	
	         	if(typeof counter.issue === "undefined"){
	         		iss = "null";
	         	}else{
	         		iss = counter.issue;
	         	}
	         	
	         	if(typeof counter.url === "undefined"){
	         		img = "null";
	         	}else{
	         		img = counter.url;
	         	}
	         	
	         	document.getElementById("t"+i+"0").innerHTML=action;
	         	document.getElementById("t"+i+"1").innerHTML=etime;
	         	document.getElementById("t"+i+"2").innerHTML=module;
	         	document.getElementById("t"+i+"3").innerHTML=dept;
	         	
	         	if(iss == 1){
	        		document.getElementById("t"+i+"4").innerHTML="화재";
	        	}else if(iss == 2){
	        		document.getElementById("t"+i+"4").innerHTML="지진";
	        	}else if(iss == 3){
	        		document.getElementById("t"+i+"4").innerHTML="화재, 지진";
	        	}else{
	        		document.getElementById("t"+i+"4").innerHTML=iss;
	        	}
	
	        	document.getElementById("t"+i+"5").innerHTML = "<p id=\"photo\" onclick=\"showphoto(\'"+img+"\')\">"+img+"</p>";
	      	}
	}else{
		alert("마지막 페이지 입니다.");
	}
}

function lastpage() {
	if(pagenum > 1){
		pagenum = pagenum - 1;
		document.getElementById("page").innerHTML = pagenum + "(총 페이지 수 :" + pagesize + ")";
			for(var i = 0; i < 20; i++){

				var k = ((pagenum-1)*20) + i;
		     	var counter = obj.list[k];
	         	
		     	if(typeof counter.action_id === "undefined"){
	         		action = "null";
	         	}else{
	         		action = counter.action_id;
	         	}
	         	
	         	if(typeof counter.time === "undefined"){
	         		etime = "null";
	         	}else{
	         		etime = counter.time;
	         	}
	         	
	         	if(typeof counter.module_id === "undefined"){
	         		module = "null";
	         	}else{
	         		module = counter.module_id;
	         	}
	         	
	         	if(typeof counter.dept_name === "undefined"){
	         		dept = "null";
	         	}else{
	         		dept = counter.dept_name;
	         	}
	         	
	         	if(typeof counter.issue === "undefined"){
	         		iss = "null";
	         	}else{
	         		iss = counter.issue;
	         	}
	         	
	         	if(typeof counter.url === "undefined"){
	         		img = "null";
	         	}else{
	         		img = counter.url;
	         	}
	         	
	         	document.getElementById("t"+i+"0").innerHTML=action;
	         	document.getElementById("t"+i+"1").innerHTML=etime;
	         	document.getElementById("t"+i+"2").innerHTML=module;
	         	document.getElementById("t"+i+"3").innerHTML=dept;
	         	
	         	if(iss == 1){
	        		document.getElementById("t"+i+"4").innerHTML="화재";
	        	}else if(iss == 2){
	        		document.getElementById("t"+i+"4").innerHTML="지진";
	        	}else if(iss == 3){
	        		document.getElementById("t"+i+"4").innerHTML="화재, 지진";
	        	}else{
	        		document.getElementById("t"+i+"4").innerHTML=iss;
	        	}
	
	        	document.getElementById("t"+i+"5").innerHTML = "<p id=\"photo\" onclick=\"showphoto(\'"+img+"\')\">"+img+"</p>";
	      	}
	}else{
		alert("첫번째 페이지 입니다.");
	}
}
    
$(window).on("unload", function(){
    clearInterval(alwayscheck);
}); 

function showphoto(img){
	document.getElementById("photoz").style.display="block";
	document.getElementById("photoz").style.background="url("+img+") no-repeat";
}
function closephoto(){
	document.getElementById("photoz").style.display="none";
}
</script>
<style>
p{
	margin:0 !important;
	padding:0 !important;
}
#photoz{
	width:800px;
	height:480px;
	padding:0;
	margin:0;
	position:absolute;
	background:none;
	z-index:1150;
	bottom:300px;
	left:560px;
	display:none;
}
#tb1{
	text-align:center;
	margin:0 !important;
	border-bottom:1px solid #ddd;
}
th{
	text-align:center;
	
}
tb{
	height:
}
#controler{
	width:300px;
	height:40px;
	z-index:1200;
	margin:0 auto;
	margin-bottom:-20px;
	margin-top:10px;
}
#nextbtn{
	width:80px;
	height:40px;
	margin:0;
	padding:0;
	z-index:1300;
}
#lastbtn{
	width:80px;
	height:40px;
	margin:0;
	padding:0;
	z-index:1300;
}
#page{
	width:140px;
	height:40px;
	margin:0;
	padding:0;
	z-index:1300;
}
.abc{
	float:left;
	text-align:center;
	vertical-align:middle;
}
</style>
</head>
<body>
	<div class="wrapper">
		<div class="alert" id="art" >
		</div>
		<div class="location" id="lct" onclick="closeLocation()">
			<div id="fire">
			<div id="firecase">
			<img src="/img/fireloc.gif" id="fireloc"alt="fire"/>
			</div>
			<div id="exts1">
				<div class="shake-freeze" id="ex0">
					<img src="/img/extinguisher.png" alt="extinguisher" class="imgEtg" name="etgs1"/>
				</div>
				<div class="shake-freeze" id="ex1">
					<img src="/img/extinguisher.png" alt="extinguisher" class="imgEtg" name="etgs1"/>
				</div>
				<div class="shake-freeze" id="ex2">
					<img src="/img/extinguisher.png" alt="extinguisher" class="imgEtg" name="etgs1"/>
				</div>
				<div class="shake-freeze" id="ex3">
					<img src="/img/extinguisher.png" alt="extinguisher" class="imgEtg" name="etgs1"/>
				</div>
				<div class="shake-freeze" id="ex4">
					<img src="/img/extinguisher.png" alt="extinguisher" class="imgEtg" name="etgs1"/>
				</div>
				<div class="shake-freeze" id="ex5">
					<img src="/img/extinguisher.png" alt="extinguisher" class="imgEtg" name="etgs1"/>
				</div>
				<div class="shake-freeze" id="ex6">
					<img src="/img/extinguisher.png" alt="extinguisher" class="imgEtg" name="etgs1"/>
				</div>
				<div class="shake-freeze" id="ex7">
					<img src="/img/extinguisher.png" alt="extinguisher" class="imgEtg" name="etgs1"/>
				</div>
				<div class="shake-freeze" id="ex8">
					<img src="/img/extinguisher.png" alt="extinguisher" class="imgEtg" name="etgs1"/>
				</div>
				<div class="shake-freeze" id="ex9">
					<img src="/img/extinguisher.png" alt="extinguisher" class="imgEtg" name="etgs1"/>
				</div>
				<div class="shake-freeze" id="ex10">
					<img src="/img/extinguisher.png" alt="extinguisher" class="imgEtg" name="etgs1"/>
				</div>
			</div>
			</div>
		</div>
		<div class="header">
			<div class="case" onclick="goReplace('/admin/admin')">
				<img src="/img/logo1.png" alt="logo" class="logo"/>
			</div>
		</div>
		<div class="sidebar">
			<div class="menuBtn" id="btnSensor">
				<button type="button" class="btn btn-default btn-lg btn-block" onclick="goReplace('/admin/sensor1')">
  					<span class="glyphicon glyphicon-tasks" ></span> Sensor Log
				</button>
			</div>
			<div class="menuBtn" >
				<button type="button" class="btn btn-default btn-lg btn-block" onclick="goReplace('/admin/event')">
  					<span class="glyphicon glyphicon-alert" ></span> Event Log
				</button>
			</div>
			<div class="menuBtn" >
				<button type="button" class="btn btn-default btn-lg btn-block" onclick="goReplace('/admin/stream')">
  					<span class="glyphicon glyphicon-play-circle" ></span> Status Check
				</button>
			</div>
			<div class="menuBtn" >
				<button type="button" class="btn btn-default btn-lg btn-block" onclick="goReplace('/admin/ex')">
  					<span class="glyphicon glyphicon-map-marker"></span> FE Maintenance
				</button>
			</div>
			<div class="menuBtn" >
				<button type="button" class="btn btn-default btn-lg btn-block" onclick="goReplace('/admin/index')">
  					<span class="glyphicon glyphicon-user" ></span> Emp Info
				</button>
			</div>
		</div>
		<div class="contents">
			<table class="table" id="tb1">
				<thead>
					<tr>
						<th scope="col">no</th>
						<th scope="col">발생일시</th>
						<th scope="col">module_id</th>
						<th scope="col">부서명</th>
						<th scope="col">발생 상황</th>
						<th scope="col">img</th>
						
					</tr>
				</thead>
				<tbody>
					<tr>
						<th scope="row" id="t00"></th>
						<td id="t01"></td>
						<td id="t02"></td>
						<td id="t03"></td>
						<td id="t04"></td>
						<td id="t05"></td>
					</tr>
					<tr>
						<th scope="row" id="t10"></th>
						<td id="t11"></td>
						<td id="t12"></td>
						<td id="t13"></td>
						<td id="t14"></td>
						<td id="t15"></td>
					</tr>
					<tr>
						<th scope="row" id="t20"></th>
						<td id="t21"></td>
						<td id="t22"></td>
						<td id="t23"></td>
						<td id="t24"></td>
						<td id="t25"></td>
					</tr>
					<tr>
						<th scope="row" id="t30"></th>
						<td id="t31"></td>
						<td id="t32"></td>
						<td id="t33"></td>
						<td id="t34"></td>
						<td id="t35"></td>
					</tr>
					<tr>
						<th scope="row" id="t40"></th>
						<td id="t41"></td>
						<td id="t42"></td>
						<td id="t43"></td>
						<td id="t44"></td>
						<td id="t45"></td>
					</tr>
					<tr>
						<th scope="row" id="t50"></th>
						<td id="t51"></td>
						<td id="t52"></td>
						<td id="t53"></td>
						<td id="t54"></td>
						<td id="t55"></td>
					</tr>
					<tr>
						<th scope="row" id="t60"></th>
						<td id="t61"></td>
						<td id="t62"></td>
						<td id="t63"></td>
						<td id="t64"></td>
						<td id="t65"></td>
					</tr>
					<tr>
						<th scope="row" id="t70"></th>
						<td id="t71"></td>
						<td id="t72"></td>
						<td id="t73"></td>
						<td id="t74"></td>
						<td id="t75"></td>
					</tr>
					<tr>
						<th scope="row" id="t80"></th>
						<td id="t81"></td>
						<td id="t82"></td>
						<td id="t83"></td>
						<td id="t84"></td>
						<td id="t85"></td>
					</tr>
					<tr>
						<th scope="row" id="t90"></th>
						<td id="t91"></td>
						<td id="t92"></td>
						<td id="t93"></td>
						<td id="t94"></td>
						<td id="t95"></td>
					</tr>
					<tr>
						<th scope="row" id="t100"></th>
						<td id="t101"></td>
						<td id="t102"></td>
						<td id="t103"></td>
						<td id="t104"></td>
						<td id="t105"></td>
					</tr>
					<tr>
						<th scope="row" id="t110"></th>
						<td id="t111"></td>
						<td id="t112"></td>
						<td id="t113"></td>
						<td id="t114"></td>
						<td id="t115"></td>
					</tr>
					<tr>
						<th scope="row" id="t120"></th>
						<td id="t121"></td>
						<td id="t122"></td>
						<td id="t123"></td>
						<td id="t124"></td>
						<td id="t125"></td>
					</tr>
					<tr>
						<th scope="row" id="t130"></th>
						<td id="t131"></td>
						<td id="t132"></td>
						<td id="t133"></td>
						<td id="t134"></td>
						<td id="t135"></td>
					</tr>
					<tr>
						<th scope="row" id="t140"></th>
						<td id="t141"></td>
						<td id="t142"></td>
						<td id="t143"></td>
						<td id="t144"></td>
						<td id="t145"></td>
					</tr>
					<tr>
						<th scope="row" id="t150"></th>
						<td id="t151"></td>
						<td id="t152"></td>
						<td id="t153"></td>
						<td id="t154"></td>
						<td id="t155"></td>
					</tr>
					<tr>
						<th scope="row" id="t160"></th>
						<td id="t161"></td>
						<td id="t162"></td>
						<td id="t163"></td>
						<td id="t164"></td>
						<td id="t165"></td>
					</tr>
					<tr>
						<th scope="row" id="t170"></th>
						<td id="t171"></td>
						<td id="t172"></td>
						<td id="t173"></td>
						<td id="t174"></td>
						<td id="t175"></td>
					</tr>
					<tr>
						<th scope="row" id="t180"></th>
						<td id="t181"></td>
						<td id="t182"></td>
						<td id="t183"></td>
						<td id="t184"></td>
						<td id="t185"></td>
					</tr>
					<tr>
						<th scope="row" id="t190"></th>
						<td id="t191"></td>
						<td id="t192"></td>
						<td id="t193"></td>
						<td id="t194"></td>
						<td id="t195"></td>
					</tr>
				</tbody>
			</table>
			<div id="controler">
				<div class="abc" id="nextbtn" onclick="lastpage()">이전 페이지</div>
				<div class="abc" id="page"></div>
				<div class="abc" id="lastbtn" onclick="nextpage()">다음 페이지</div>
			</div>
		</div>
		<div class="footer">
			<div style="padding: 7px;">Copyright © 2018 HSB Inc.</div>
		</div>
		<div id="photoz" onclick="closephoto()">
		</div>
	</div>
</body>
</html>