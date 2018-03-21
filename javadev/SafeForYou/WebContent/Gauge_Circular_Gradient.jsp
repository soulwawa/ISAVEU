<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<% String root = request.getContextPath(); %>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<meta http-equiv="Content-Script-Type" content="text/javascript"/>
<meta http-equiv="Content-Style-Type" content="text/css"/>
<meta http-equiv="X-UA-Compatible" content="IE=edge"/>
<link rel="stylesheet" type="text/css" href="./rMateChartH5/Assets/Css/rMateChartH5.css"/>
<script language="javascript" type="text/javascript" src="./LicenseKey/rMateChartH5License.js"></script>
<script language="javascript" type="text/javascript" src="./rMateChartH5/JS/rMateGaugeChartH5.js"></script>
<script type="text/javascript" src="./rMateChartH5/Assets/Theme/theme.js"></script>
<script type="text/javascript">
var chartVars = "rMateOnLoadCallFunction=chartReadyHandler";
rMateChartH5.create("chart1", "chartHolder", chartVars, "100%", "100%"); 
function chartReadyHandler(id) {
	document.getElementById(id).setLayout(layoutStr);
	document.getElementById(id).setData(chartData);
}
var layoutStr = 
				'<rMateChart frameColor="#EEEEEE"  borderStyle="none">'
					+'<Options>'
						+'<Caption text="ê²ì´ì§ - Gradient" fontFamily="ë§ì ê³ ë"/>'
					+'</Options>'
					+'<NumberFormatter id="numFmt" precision="0"/>' 
					+'<CircularGauge valueChangeFunction="valueChangeFunc" padding="8" startAngle="90" minimumAngle="40" maximumAngle="320" minimum="0" maximum="500" value="200" interval="50" minorInterval="10" formatter="{numFmt}" tickLabelStyleName="tickText" valueLabelStyleName="valueText" editMode="true" majorTickType="circle" liveDragging="false" tickGap="-3" labelGap="-5" showDataTip="false" tickLabelPlacement="outside" tickColor="#1B699A" needleCoverRadius="100" needleThickness="100" pointThickness="0" tickRadius="2" needleLengthRatio="0.9" minorTickType="line" minorTickRadius="5" needlePointStyle="rounding" isValueTop="true" animationDuration="1000" bounceAnimating="true" rotateTickLabel="true" showOutFrame="true" outFrameLabelXOffset="0" outFrameLabelYOffset="0.2">'
						+'<frameFill>'
							+'<LinearGradient angle="0">'
								+'<entries>'
									+'<GradientEntry color="#f6af43" ratio="0"/>'
									+'<GradientEntry color="#f55a58" ratio="1"/>'
								+'</entries>'
							+'</LinearGradient>'
						+'</frameFill>'
						+'<frameStroke>'
							+'<Stroke color="#ffffff" weight="0"/>'
						+'</frameStroke>'
						+'<needleFill>'
							+'<SolidColor color="#ffffff"/>'
						+'</needleFill>'
						+'<needleStroke>'
							+'<Stroke color="#ffffff"/>'
						+'</needleStroke>'
						+'<needleCoverFill>'
							+'<SolidColor color="#ffffff"/>'
						+'</needleCoverFill>'
						+'<needleCoverStroke>'
							+'<Stroke color="#ffffff"/>'
						+'</needleCoverStroke>'
						+'<minorTickStroke>'
							+'<Stroke color="#ffffff" alpha="0.5"/>'
						+'</minorTickStroke>'
						+'<tickFill>'
							+'<SolidColor color="#ffffff"/>'
						+'</tickFill>'
						+'<tickStroke>'
							+'<Stroke color="#ffffff" weight="3"/>'
						+'</tickStroke>'
					+'</CircularGauge>'
					+'<Style>'
						+'.valueText{'
							+'fontSize:35;'
							+'textAlign:center;'
							+'backgroundColor:#FFFFFF;'
							+'backgroundAlpha:0;'
							+'paddingTop:0;'
							+'borderStyle:none;'
							+'fontWeight:bold;'
							+'color:#555555;'
						+'}'
						+'.tickText{'
							+'fontFamily:"ë§ì ê³ ë";'
							+'fontSize:11;'
							+'color:#555555;'
						+'}'
					+'</Style>'
				+'</rMateChart>';
var chartData = [201];
function changeValue()
{
	document.getElementById("chart1").setData([parseInt(Math.random()*100) * 5]);
}
var gaugeValue;
function valueChangeFunc(value)
{
	gaugeValue = value;
}
function commitValue()
{
	alert(gaugeValue);
}
rMateChartH5.registerTheme(rMateChartH5.themes);
function rMateChartH5ChangeTheme(theme){
	document.getElementById("chart1").setTheme(theme);
}
</script>
<script type="text/javascript" src="./Web/JS/common.js"></script>
<script type="text/javascript" src="./Web/JS/sample_util.js"></script>
<link rel="stylesheet" type="text/css" href="./Web/sample.css"/>
<script type="text/javascript" src="./Web/syntax/shCore.js"></script>
<script type="text/javascript" src="./Web/syntax/shBrushJScript.js"></script>
<link type="text/css" rel="stylesheet" href="./Web/syntax/shCoreDefault.css"/>
<link href="./css/style2.css" rel="stylesheet" type="text/css">
<body>
	<div class="nav">
		<div>
			<a href="admin.do">
				<button id="btn6">
					<img src="<%=root%>/img/main.png" alt="logo" class="mainImg">
				</button>
			</a>
		</div>
		<br>
		<div>
			<a href="sensorlog.do"> <input type="button" value="ì¼ìë¡ê·¸"
				class="menuBtn" id="btn1">
			</a>
		</div>
		<br>
		<div>
			<a href="eventlog.do"> <input type="button" value="ì¬ê±´ëª©ë¡"
				class="menuBtn" id="btn2">
			</a>
		</div>
		<br>
		<div>
			<a href="streaming.do"> <input type="button" value="ì¤ìê° ì¤í¸ë¦¬ë°"
				class="menuBtn" id="btn3">
			</a>
		</div>
		<br>
		<div>
			<a href="employee.do"> <input type="button" value="ì¬ìì ë³´"
				class="menuBtn" id="btn4">
			</a>
		</div>
		<br>
		<div>
			<a href="location.do"> <input type="button" value="ìì¹ì ë³´"
				class="menuBtn" id="btn5">
			</a>
		</div>
	</div>
	<div class="container">
		<div class="top">
			<%=request.getAttribute("result")%>
			<div id="content" style="height:380px;">
			<div id="chartHolder"></div>
		</div>
		</div>
		<div class="content"></div>
	</div>
</body>
</html>