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
function change() {
	var change = document.getElementById("mySpan");
	//id가 mySpan인 객체 찾기
	span.style.color = "green"; //글자 색 green
	span.style.fontSize= "30px"; //글자 크기는 30픽셀
	span.style.display = "block"; //블록 박스로 변경
	span.style.width = "6em"; // 박스의 폭, 6글자 크기
	span.style.border = "3px dotted magenta"; //3픽셀 점선 magenta 테두리
	span.style.margin = "20px"; // 상하좌우 여백 20px
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