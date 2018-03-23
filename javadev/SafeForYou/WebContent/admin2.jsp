<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<% String root = request.getContextPath(); %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<link href="<%=root%>/css/style2.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="<%=root%>/javascript/temperature.js"></script>
<link rel="stylesheet" type="text/css" href="./rMateChartH5.css"/>
<script language="javascript" type="text/javascript" src="./rMateChartH5License.js"></script>
<script language="javascript" type="text/javascript" src="./rMateGaugeChartH5.js"></script>
<script type="text/javascript" src="./theme.js"></script>
<script language="javascript" type="text/javascript" src="./gauge.js"></script>
<script type="text/javascript" src="./common.js"></script>
<script type="text/javascript" src="./sample_util.js"></script>
<link rel="stylesheet" type="text/css" href="./sample.css"/>
<script type="text/javascript" src="./shCore.js"></script>
<script type="text/javascript" src="./shBrushJScript.js"></script>
<script type="text/javascript">

function a()
{
	document.getElementById(id).setData(chartData);
}
</script>
<link type="text/css" rel="stylesheet" href="./shCoreDefault.css"/>
<title>관리자 페이지</title>
</head>
<body>
	<div class="wwrap">
		<div class="hheader">	
			<div class="ttop">
				<div class="ccase">
					<div>
						<%=request.getAttribute("result")%>
					</div>
					<div>
						hello admin
					</div>
					<div class="llogout">
						logout
					</div>
				</div>
			</div>
			<div class="nnav">
				<div class="fflex">
					<div class="mmenuBtn" id="mBtn1" onclick="admin.do">
						<img src="<%=root%>/img/main.png" alt="logo" class="mmainImg"/>
					</div>
					<div class="mmenuBtn" id="mBtn2">
						sensor log
					</div>
					<div class="mmenuBtn" id="mBtn3">
						event log
					</div>
					<div class="mmenuBtn" id="mBtn4">
						streaming
					</div>
					<div class="mmenuBtn" id="mBtn5">
						HR table
					</div>
					<div class="mmenuBtn" id="mBtn6">
						location info
					</div>
				</div>
			</div>
		</div>
		<div class="ccontainer">
			<div class="ccontent">
				<div class="ttempChart">
					<div id="content">
							<!-- 차트가 삽입될 DIV -->
						<div id="chartHolder"></div>
					</div>
				</div>
				<div>
				</div>
				<div>
				</div>
				<div>
				</div>
			</div>
			
		</div>
		<div class="ffooter">
			<%=request.getAttribute("result")%>
		</div>
	</div>		
</body>
</html>