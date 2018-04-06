<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<script language="javascript" type="text/javascript" src="./rMateChartH5License.js"></script>
<script src="./rMateChartH5.js" language="javascript"></script>
<script language="javascript" type="text/javascript" src="./rMateIntegrationH5.js"></script>
<script type="text/javascript" src="./common.js"></script>
<script type="text/javascript" src="./sample_util.js"></script>
<link rel="stylesheet" type="text/css" href="./sample.css"/>
<script type="text/javascript" src="./shCore.js"></script>
<script type="text/javascript" src="./shBrushJScript.js"></script>
<link type="text/css" rel="stylesheet" href="./shCoreDefault.css"/>
<script type="text/javascript" src="./theme.js"></script>

<!-- 사용자 정의 설정 시작 -->
<script language="JavaScript" type="text/javascript">
// -----------------------첫번째 차트 chartVars 설정 시작----------------------
var chartVars = "&rMateOnLoadCallFunction=rMateChartOnLoad";
// -----------------------첫번째 차트 chartVars 설정 끝-----------------------
// -----------------------두번째 차트 chartVars 설정 시작-----------------------
var chartVars2 = "&rMateOnLoadCallFunction=rMateChartOnLoad2";
// -----------------------두번째 차트 chartVars 설정 끝-----------------------
// rMateChart 를 생성합니다.
rMateChartH5.create("chart1", "chartHolder", chartVars, "100%", "100%");
rMateChartH5.create("chart2", "chartHolder2", chartVars2, "100%", "100%");
// rMate 차트 준비가 완료된 경우 이 함수가 호출됩니다.
// 사용자는 이 함수를 chartVars에 반드시 등록해야 합니다.
// 여기서 작업을 하십시오.
// 차트 콜백함수 4개 존재합니다.
// 1. setLayout - 스트링으로 작성된 레이아웃 XML을 삽입합니다.
// 2. setData - 배열로 작성된 데이터를 삽입합니다.
// 3. setLayoutURL - 레이아웃 XML 경로를 지시합니다.
// 4. setDataURL - 데이터 XML 경로를 지시합니다.
// 아래 예제는 가능한 방법을 제시한 것 입니다.
// 현재 1번 차트는 레이아웃을 스트링 형태로 받아들이고 데이터는 배열 형태로 받아들입니다.
function rMateChartOnLoad()
{
//예제1. 레이아웃 스트링 형태,데이터 배열 형태
chart1.setLayout(layoutStr);
chart1.setData(chartData);
//예제2. 레이아웃 XML URL경로, 데이터 배열 형태
//chart1.setLayoutURL(layoutURL2);
//chart1.setData(chartData2);
//예제3. 레이아웃 스트링 형태, 데이터 XML URL경로
//chart1.setLayout(layoutStr2);
//chart1.setDataURL(dataURL2);
//예제4. 레이아웃 URL, 데이터 URL
//chart1.setLayoutURL(layoutURL);
//chart1.setDataURL(dataURL);
}
// 2번 차트에서 차트가 생성되면 호출하는 함수(사용자에 의해 정의됨)
function rMateChartOnLoad2()
{
//예제2. 레이아웃 XML URL경로, 데이터 배열 형태
chart2.setLayoutURL(layoutURL2);
chart2.setData(chartData2);
}
// 동적으로 할당할 레이아웃 정의.
var layoutURL2 = encodeURIComponent("chartLayout.xml");
var layoutStr = "<rMateChart cornerRadius='12' borderStyle='solid'>"
+"<Options><Caption text='Annual Report'/></Options>"
+"<Line2DChart showDataTips='true'>"
+"<horizontalAxis><CategoryAxis categoryField='Month'/></horizontalAxis>"
+"<series><Line2DSeries yField='Profit' displayName='Profit'>"
+"<showDataEffect><SeriesInterpolate/></showDataEffect>"
+"<lineStroke><Stroke color='0xFF0000'weight='4'/>"
+"</lineStroke></Line2DSeries>"
+"</series></Line2DChart></rMateChart>";
// 동적으로 할당할 데이터 정의.
var chartData = [{"Month":"Jan", "Revenue":10000, "Cost":5000, "Profit":5000},
{"Month":"Feb", "Revenue":15000, "Cost":7000, "Profit":8000},
{"Month":"Mar", "Revenue":12000 , "Cost":6000, "Profit":6000},
{"Month":"Apr", "Revenue":30200, "Cost":4000, "Profit":26200},
{"Month":"May", "Revenue":28000, "Cost":10000, "Profit":18000},
{"Month":"Jun", "Revenue":12000, "Cost":5000, "Profit":7000},
{"Month":"Jul", "Revenue":22000, "Cost":10000, "Profit":12000},
{"Month":"Aug", "Revenue":13000, "Cost":6000, "Profit":7000},
{"Month":"Sep", "Revenue":22000, "Cost":10000, "Profit":12000},
{"Month":"Oct", "Revenue":29000, "Cost":8000, "Profit":21000},
{"Month":"Nov", "Revenue":18000, "Cost":7500, "Profit":10500},
{"Month":"Dec", "Revenue":30000, "Cost":12000, "Profit":18000} ];
var chartData2 = [{"Month":"Jan", "Revenue":1000, "Cost":500, "Profit":500},
{"Month":"Feb", "Revenue":1500, "Cost":700, "Profit":800},
{"Month":"Mar", "Revenue":1200 , "Cost":600, "Profit":600},
{"Month":"Apr", "Revenue":3020, "Cost":400, "Profit":2620},
{"Month":"May", "Revenue":2800, "Cost":1000, "Profit":1800},
{"Month":"Jun", "Revenue":1200, "Cost":500, "Profit":700},
163/174
{"Month":"Jul", "Revenue":2200, "Cost":1000, "Profit":1200},
{"Month":"Aug", "Revenue":1300, "Cost":600, "Profit":700},
{"Month":"Sep", "Revenue":2200, "Cost":1000, "Profit":1200},
{"Month":"Oct", "Revenue":2900, "Cost":800, "Profit":2100},
{"Month":"Nov", "Revenue":1800, "Cost":750, "Profit":1050},
{"Month":"Dec", "Revenue":3000, "Cost":1200, "Profit":1800} ];
</script>
<!-- 사용자 정의 설정 끝 -->
</head>
<body>
<table align="center" border="0" cellpadding="0" cellspacing="0">
<tr>
<td align="center">
<div class="content">
<!-- 차트가 삽입될 DIV -->
<div id="chartHolder" style="width:600px; height:400px;">
</div>
</div>
</td>
<td align="center">
<div class="content">
<!-- 차트가 삽입될 DIV -->
<div id="chartHolder2" style="width:600px; height:400px;">
</div>
</div>
</td>
</tr>
</table>
</body>
</html>