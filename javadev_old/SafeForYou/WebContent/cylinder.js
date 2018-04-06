// -----------------------차트 설정 시작-----------------------
 
// rMate 차트 생성 준비가 완료된 상태 시 호출할 함수를 지정합니다.
var chartVars = "&rMateOnLoadCallFunction=rMateChartOnLoad1";
var chartVars2 = "&rMateOnLoadCallFunction=rMateChartOnLoad2";
var chartVars3 = "&rMateOnLoadCallFunction=rMateChartOnLoad3";
var chartVars4 = "&rMateOnLoadCallFunction=rMateChartOnLoad4";
 
// rMateChart 를 생성합니다.
// 파라메터 (순서대로) 
//  1. 차트의 id ( 임의로 지정하십시오. ) 
//  2. 차트가 위치할 div 의 id (즉, 차트의 부모 div 의 id 입니다.)
//  3. 차트 생성 시 필요한 환경 변수들의 묶음인 chartVars
//  4. 차트의 가로 사이즈 (생략 가능, 생략 시 100%)
//  5. 차트의 세로 사이즈 (생략 가능, 생략 시 100%)
rMateChartH5.create("chart1", "chartHolder1", chartVars, "100%", "100%");
rMateChartH5.create("chart2", "chartHolder2", chartVars2, "100%", "100%");
rMateChartH5.create("chart3", "chartHolder3", chartVars3, "100%", "100%");
rMateChartH5.create("chart4", "chartHolder4", chartVars4, "100%", "100%");

// 차트의 속성인 rMateOnLoadCallFunction 으로 설정된 함수.
// rMate 차트 준비가 완료된 경우 이 함수가 호출됩니다.
// 이 함수를 통해 차트에 레이아웃과 데이터를 삽입합니다.
// 파라메터 : id - rMateChartH5.create() 사용 시 사용자가 지정한 id 입니다.

function rMateChartOnLoad() {
		chart1.setLayout(layoutStr1);
		chart1.setData(chartData1);
	}
function rMateChartOnLoad2() {
		chart1.setLayout(layoutStr2);
		chart1.setData(chartData2);
	}
function rMateChartOnLoad3() {
		chart1.setLayout(layoutStr3);
		chart1.setData(chartData3);
	}
function rMateChartOnLoad4() {
		chart1.setLayout(layoutStr4);
		chart1.setData(chartData4);
	}
function chartReadyHandler(id) {
	   document.getElementById(id).setLayout(layoutStr);
	   document.getElementById(id).setData(chartData);
	}
// 스트링 형식으로 레이아웃 정의.
var layoutStr1 = 
                '<rMateChart backgroundColor="#FFFFFF"  horizontalAlign="center" verticalAlign="middle" borderStyle="none">'
                  +'<CurrencyFormatter id="cft" currencySymbol="%" alignSymbol="right"/>'
                   +'<VCylinderGauge width="150" height="350" minimum="0" maximum="200" '
                   +'labels="[-20,-10,0,10,20,30,40,50,60,70,80]" tickInterval="10" value="25" '
                  +'cylinderColor="[#ff842e,#ffd44a,#ff842e]" cylinderAlpha="[1,1,1]" cylinderRatio="[0,100,255]" '
                   +'targetMark="120" snapInterval="1" labelJsFunction="labelFunc" valueLabelStyleName="valueLabel" valueChangeFunction="changeFunction"/>'
                 +'<Style>'
                        +'.valueLabel{fontSize:11;fontWeight:bold;}'
                    +'</Style>'
               +'</rMateChart>';
var layoutStr2 = 
			    '<rMateChart backgroundColor="#FFFFFF"  horizontalAlign="center" verticalAlign="middle" borderStyle="none">'
			      +'<CurrencyFormatter id="cft" currencySymbol="%" alignSymbol="right"/>'
			       +'<VCylinderGauge width="150" height="350" minimum="0" maximum="200" '
			       +'labels="[-20,-10,0,10,20,30,40,50,60,70,80]" tickInterval="10" value="25" '
			      +'cylinderColor="[#ff842e,#ffd44a,#ff842e]" cylinderAlpha="[1,1,1]" cylinderRatio="[0,100,255]" '
			       +'targetMark="120" snapInterval="1" labelJsFunction="labelFunc" valueLabelStyleName="valueLabel" valueChangeFunction="changeFunction"/>'
			     +'<Style>'
			            +'.valueLabel{fontSize:11;fontWeight:bold;}'
			        +'</Style>'
			   +'</rMateChart>';
var layoutStr3 = 
			    '<rMateChart backgroundColor="#FFFFFF"  horizontalAlign="center" verticalAlign="middle" borderStyle="none">'
			      +'<CurrencyFormatter id="cft" currencySymbol="%" alignSymbol="right"/>'
			       +'<VCylinderGauge width="150" height="350" minimum="0" maximum="200" '
			       +'labels="[-20,-10,0,10,20,30,40,50,60,70,80]" tickInterval="10" value="25" '
			      +'cylinderColor="[#ff842e,#ffd44a,#ff842e]" cylinderAlpha="[1,1,1]" cylinderRatio="[0,100,255]" '
			       +'targetMark="120" snapInterval="1" labelJsFunction="labelFunc" valueLabelStyleName="valueLabel" valueChangeFunction="changeFunction"/>'
			     +'<Style>'
			            +'.valueLabel{fontSize:11;fontWeight:bold;}'
			        +'</Style>'
			   +'</rMateChart>';
var layoutStr4 = 
			    '<rMateChart backgroundColor="#FFFFFF"  horizontalAlign="center" verticalAlign="middle" borderStyle="none">'
			      +'<CurrencyFormatter id="cft" currencySymbol="%" alignSymbol="right"/>'
			       +'<VCylinderGauge width="150" height="350" minimum="0" maximum="200" '
			       +'labels="[-20,-10,0,10,20,30,40,50,60,70,80]" tickInterval="10" value="25" '
			      +'cylinderColor="[#ff842e,#ffd44a,#ff842e]" cylinderAlpha="[1,1,1]" cylinderRatio="[0,100,255]" '
			       +'targetMark="120" snapInterval="1" labelJsFunction="labelFunc" valueLabelStyleName="valueLabel" valueChangeFunction="changeFunction"/>'
			     +'<Style>'
			            +'.valueLabel{fontSize:11;fontWeight:bold;}'
			        +'</Style>'
			   +'</rMateChart>';
// 게이지 데이터
var chartData1 = [160];
var chartData2 = [170];
var chartData3 = [180];
var chartData4 = [190];

 
//게이지 값 랜덤 변경 함수


function changeValue(){
	   // 게이지의 값을 변경할려면 setData 함수를 사용하세요.
	document.getElementById("chart1").setData([parseInt(Math.random()*100)]);
	document.getElementById("chart2").setData([parseInt(Math.random()*100)]);
	document.getElementById("chart3").setData([parseInt(Math.random()*100)]);
	document.getElementById("chart4").setData([parseInt(Math.random()*100)]);
	}
 
//게이지 값 보관.
var gaugeValue1, gaugeValue2, gaugeValue3, gaugeValue4;
 
// 게이지 value change 이벤트 핸들러 함수.
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
	   alert("chart1 : " + gaugeValue1 + "\nchart2 : " + gaugeValue2 + "\nchart3 : " + gaugeValue3 + "\nchart4 : " + gaugeValue4);
	}
	 
	function labelFunc(value){
	    return value+"%";
	}

rMateChartH5.registerTheme(rMateChartH5.themes);

function rMateChartH5ChangeTheme(theme){
    document.getElementById("chart1").setTheme(theme);
}
 
// -----------------------차트 설정 끝 -----------------------