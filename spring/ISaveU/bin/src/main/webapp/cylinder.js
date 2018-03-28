var chartVars = "rMateOnLoadCallFunction=chartReadyHandler";

rMateChartH5.create("chart1", "chartHolder1", chartVars, "100%", "100%");
rMateChartH5.create("chart2", "chartHolder2", chartVars, "100%", "100%");
rMateChartH5.create("chart3", "chartHolder3", chartVars, "100%", "100%");
rMateChartH5.create("chart4", "chartHolder4", chartVars, "100%", "100%");

function chartReadyHandler(id) {
	var num = id.replace(/\D/g, "");
	document.getElementById(id).setLayout(window["layoutStr" + num]);
	document.getElementById(id).setData(chartData);
}
/**
 * minimum : 최소 값
 * maximum : 최대 값
 * showDataTip : 툴팁의 출력 여부 default true
 * targetValue : 목표치 값
 * showTargetLine : 목표치의 출력 여부 default false
 * direction : 출력 방향 default vertical
 * duration : 이펙트 출력 시간 default 800
 * showValueLabel : 수치 라벨 출력 여부 default true
 * showAnimation : 이펙트 출력 여부 default true
 * valueChangeFunction : 데이터 변경될 시 호출될 콜백 함수
 * labelJsFunction : 수치 라벨 사용자 정의 함수
 * fillJsFunction : 색상 사용자 정의 함수
 * formatter : 포맷터 default NumberFormatter
 * bounceAnimating : 이펙트 튕김 효과 설정 여부 default true
 * backgroundColor : 배경 색상 default #ffffff
 * backgroundAlpha : 배경 색상 투명도 default 1
 * backgroundStroke : 배경 테두리 선 
 * foregroundColor : 게이지 채워지는 영역 색상 default #33eeff
 * foreLineStroke : 게이지 채워지는 영역 테두리 선
 * horizontalRatio : 게이지 수평 출력 비율 default 0.6
 * verticalRatio : 게이지 수평 출력 비율 default 0.8
 * valueLabelHorizontalRatio : 수치 라벨 수평 위치 비율 default 0.5
 * valueLabelVerticalRatio : 수치 라벨 수직 위치 비율 default 0.5
 * leftTopBorderRadius : 위 왼쪽 보더 값 default 0
 * rightTopBorderRadius : 위 오른쪽 보더 값 default 0
 * leftBottomRadius : 아래 왼쪽 보더 값 default 0
 * rightBottomRadius : 아래 오른쪽 보더 값 default 0
 */
var layoutStr1 = 
	 '<rMateChart backgroundColor="#ecf0f5" marginTop="25" marginBottom="25" horizontalAlign="center" verticalScrollPolicy="off" verticalAlign="middle"  borderStyle="none">'
    +'<CurrencyFormatter id="cmt" precision="0" currencySymbol="\'C" alignSymbol="right"/>'
  +'<HLinearGauge backgroundColor="#ecf0f5" width="500" height="100" minimum="0" maximum="50" labels="[0,10,20,30,40,50]" tickInterval="10" formatter="{cmt}" targetMark="40" '
     +'targetMarkColor="[#ff842e,#ff842e,#ff842e]" targetMarkAlpha="[1,1,1]" targetMarkRatio="[0,125,255]" targetMarkThickness="3" targetMarkBorderColor="#ff842e" '
  +'linearAlpha="[1,1,1]" linearColor="[#1bcfc6,#34d9d5,#1a97d1]" linearRatio="[0,90,255]" linearBorderColor="#1a97d1" labelJsFunction="labelFunc1" '
   +'linearBgAlpha="[1,1,1]" linearBgColor="[#555555,#555555,#555555]" linearBgRatio="[0,125,255]" '
    +'valueLabelStyleName="valueLabel" valueChangeFunction="changeFunction1"/>'
   +'<Style>'
         +'.valueLabel{fontSize:20;color:0xffffff;fontWeight:bold;}'
  +'</Style>'
+'</rMateChart>';
var layoutStr2 = 
	 '<rMateChart backgroundColor="#ecf0f5" marginTop="25" marginBottom="25" horizontalAlign="center" verticalScrollPolicy="off" verticalAlign="middle"  borderStyle="none">'
    +'<CurrencyFormatter id="cmt" precision="0" currencySymbol="!" alignSymbol="right"/>'
  +'<HLinearGauge backgroundColor="#ecf0f5" width="500" height="100" minimum="100" maximum="600" labels="[100,200,300,400,500,600]" tickInterval="100" formatter="{cmt}" targetMark="60" '
     +'targetMarkColor="[#ff842e,#ff842e,#ff842e]" targetMarkAlpha="[1,1,1]" targetMarkRatio="[0,125,255]" targetMarkThickness="3" targetMarkBorderColor="#ff842e" '
  +'linearAlpha="[1,1,1]" linearColor="[#1bcfc6,#34d9d5,#1a97d1]" linearRatio="[0,90,255]" linearBorderColor="#1a97d1" labelJsFunction="labelFunc2" '
   +'linearBgAlpha="[1,1,1]" linearBgColor="[#555555,#555555,#555555]" linearBgRatio="[0,125,255]" '
    +'valueLabelStyleName="valueLabel" valueChangeFunction="changeFunction2"/>'
   +'<Style>'
         +'.valueLabel{fontSize:20;color:0xffffff;fontWeight:bold;}'
  +'</Style>'
+'</rMateChart>';
var layoutStr3 = 
	 '<rMateChart backgroundColor="#ecf0f5" marginTop="25" marginBottom="25" horizontalAlign="center" verticalScrollPolicy="off" verticalAlign="middle"  borderStyle="none">'
    +'<CurrencyFormatter id="cmt" precision="0" currencySymbol="@" alignSymbol="right"/>'
  +'<HLinearGauge backgroundColor="#ecf0f5" width="500" height="100" minimum="0" maximum="1600" labels="[0,200,400,600,800,1000,1200,1400,1600]" tickInterval="200" formatter="{cmt}" targetMark="60" '
     +'targetMarkColor="[#ff842e,#ff842e,#ff842e]" targetMarkAlpha="[1,1,1]" targetMarkRatio="[0,125,255]" targetMarkThickness="3" targetMarkBorderColor="#ff842e" '
  +'linearAlpha="[1,1,1]" linearColor="[#1bcfc6,#34d9d5,#1a97d1]" linearRatio="[0,90,255]" linearBorderColor="#1a97d1" labelJsFunction="labelFunc3" '
   +'linearBgAlpha="[1,1,1]" linearBgColor="[#555555,#555555,#555555]" linearBgRatio="[0,125,255]" '
    +'valueLabelStyleName="valueLabel" valueChangeFunction="changeFunction3"/>'
   +'<Style>'
         +'.valueLabel{fontSize:20;color:0xffffff;fontWeight:bold;}'
  +'</Style>'
+'</rMateChart>';
var layoutStr4 = 
	 '<rMateChart backgroundColor="#ecf0f5" marginTop="25" marginBottom="25" horizontalAlign="center" verticalScrollPolicy="off" verticalAlign="middle"  borderStyle="none">'
   +'<CurrencyFormatter id="cmt" precision="0" currencySymbol="@" alignSymbol="right"/>'
 +'<HLinearGauge backgroundColor="#ecf0f5" width="500" height="100" minimum="0" maximum="1600" labels="[0,200,400,600,800,1000,1200,1400,1600]" tickInterval="200" formatter="{cmt}" targetMark="60" '
    +'targetMarkColor="[#ff842e,#ff842e,#ff842e]" targetMarkAlpha="[1,1,1]" targetMarkRatio="[0,125,255]" targetMarkThickness="3" targetMarkBorderColor="#ff842e" '
 +'linearAlpha="[1,1,1]" linearColor="[#1bcfc6,#34d9d5,#1a97d1]" linearRatio="[0,90,255]" linearBorderColor="#1a97d1" labelJsFunction="labelFunc4" '
  +'linearBgAlpha="[1,1,1]" linearBgColor="[#555555,#555555,#555555]" linearBgRatio="[0,125,255]" '
   +'valueLabelStyleName="valueLabel" valueChangeFunction="changeFunction4"/>'
  +'<Style>'
        +'.valueLabel{fontSize:20;color:0xffffff;fontWeight:bold;}'
 +'</Style>'
+'</rMateChart>';
var chartData = [35];

function changeValue(){
	document.getElementById("chart1").setData([parseInt(Math.random()*100)]);
	document.getElementById("chart2").setData([parseInt(Math.random()*100)]);
	document.getElementById("chart3").setData([parseInt(Math.random()*100)]);
	document.getElementById("chart4").setData([parseInt(Math.random()*100)]);
}

var gaugeValue1, gaugeValue2, gaugeValue3, gaugeValue4;

function changeFunction1(value){
	gaugeValue1 = value;
}

function changeFunction2(value){
	gaugeValue2 = value;
}

function changeFunction3(value){
	gaugeValue3 = value;
}

function changeFunction4(value){
	gaugeValue4 = value;
}

function commitValue(){
	alert("chart1 : " + gaugeValue1 + "\nchart2 : " + gaugeValue2 + "\nchart3 : " + gaugeValue3+ "\nchart4 : " + gaugeValue4);
}

function labelFunc1(value){
	return value+"\'C";
}
function labelFunc2(value){
	return value+"%";
}
function labelFunc3(value){
	return value+"#";
}
function labelFunc4(value){
	return value+"#";
}

rMateChartH5.registerTheme(rMateChartH5.themes);

function rMateChartH5ChangeTheme(theme){
	document.getElementById("chart1").setTheme(theme);
}