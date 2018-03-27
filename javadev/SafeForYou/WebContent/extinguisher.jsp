<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<% String root = request.getContextPath(); %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link href="<%=root%>/css/style2.css" rel="stylesheet" type="text/css"/>

<script>
	var a = 0;
function showExtinguisher() {
	if(a == 1) {
		document.getElementById("ex1").style.display = "none";	
		document.getElementById("ex2").style.display = "none";	
		document.getElementById("ex3").style.display = "none";	
		document.getElementById("ex4").style.display = "none";	
		document.getElementById("ex5").style.display = "none";	
		document.getElementById("ex6").style.display = "none";	
		document.getElementById("ex7").style.display = "none";	
		document.getElementById("ex8").style.display = "none";	
		document.getElementById("ex9").style.display = "none";	
		document.getElementById("ex10").style.display = "none";	
		document.getElementById("ex11").style.display = "none";	
		document.getElementById("ex12").style.display = "none";
		a = 0;
	}else {
		document.getElementById("ex1").style.display = "block";	
		document.getElementById("ex2").style.display = "block";	
		document.getElementById("ex3").style.display = "block";	
		document.getElementById("ex4").style.display = "block";	
		document.getElementById("ex5").style.display = "block";	
		document.getElementById("ex6").style.display = "block";	
		document.getElementById("ex7").style.display = "block";	
		document.getElementById("ex8").style.display = "block";	
		document.getElementById("ex9").style.display = "block";	
		document.getElementById("ex10").style.display = "block";	
		document.getElementById("ex11").style.display = "block";	
		document.getElementById("ex12").style.display = "block";
		a = 1;
	}
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
			<div class="map">
			</div>
			<div id="exts">
				<div class="extinguishers" id="ex1">
					<img src="<%=root%>/img/extinguisher.png" alt="extinguisher" class="imgEtg"/>
				</div>
				<div class="extinguishers" id="ex2">
					<img src="<%=root%>/img/extinguisher.png" alt="extinguisher" class="imgEtg"/>
				</div>
				<div class="extinguishers" id="ex3">
					<img src="<%=root%>/img/extinguisher.png" alt="extinguisher" class="imgEtg"/>
				</div>
				<div class="extinguishers" id="ex4">
					<img src="<%=root%>/img/extinguisher.png" alt="extinguisher" class="imgEtg"/>
				</div>
				<div class="extinguishers" id="ex5">
					<img src="<%=root%>/img/extinguisher.png" alt="extinguisher" class="imgEtg"/>
				</div>
				<div class="extinguishers" id="ex6">
					<img src="<%=root%>/img/extinguisher.png" alt="extinguisher" class="imgEtg"/>
				</div>
				<div class="extinguishers" id="ex7">
					<img src="<%=root%>/img/extinguisher.png" alt="extinguisher" class="imgEtg"/>
				</div>
				<div class="extinguishers" id="ex8">
					<img src="<%=root%>/img/extinguisher.png" alt="extinguisher" class="imgEtg"/>
				</div>
				<div class="extinguishers" id="ex9">
					<img src="<%=root%>/img/extinguisher.png" alt="extinguisher" class="imgEtg"/>
				</div>
				<div class="extinguishers" id="ex10">
					<img src="<%=root%>/img/extinguisher.png" alt="extinguisher" class="imgEtg"/>
				</div>
				<div class="extinguishers" id="ex11">
					<img src="<%=root%>/img/extinguisher.png" alt="extinguisher" class="imgEtg"/>
				</div>
				<div class="extinguishers" id="ex12">
					<img src="<%=root%>/img/extinguisher.png" alt="extinguisher" class="imgEtg"/>
				</div>
			</div>
			
		
		</div>
		<div class="footer">
			<input type="button" value="소화기 위치 찾기" onclick="showExtinguisher()"/>
		</div>
	</div>
</body>
</html>