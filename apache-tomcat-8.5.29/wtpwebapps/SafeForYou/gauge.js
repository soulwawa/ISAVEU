// -----------------------차트 설정 시작-----------------------
// rMate 차트 생성 준비가 완료된 상태 시 호출할 함수를 지정합니다.
var chartVars = "rMateOnLoadCallFunction=chartReadyHandler";

// rMateChart 를 생성합니다.
// 파라메터 (순서대로) 
//  1. 차트의 id ( 임의로 지정하십시오. ) 
//  2. 차트가 위치할 div 의 id (즉, 차트의 부모 div 의 id 입니다.)
//  3. 차트 생성 시 필요한 환경 변수들의 묶음인 chartVars
//  4. 차트의 가로 사이즈 (생략 가능, 생략 시 100%)
//  5. 차트의 세로 사이즈 (생략 가능, 생략 시 100%)
rMateChartH5.create("chart1", "chartHolder", chartVars, "80%", "80%"); 

// 차트의 속성인 rMateOnLoadCallFunction 으로 설정된 함수.
// rMate 차트 준비가 완료된 경우 이 함수가 호출됩니다.
// 이 함수를 통해 차트에 레이아웃과 데이터를 삽입합니다.
// 파라메터 : id - rMateChartH5.create() 사용 시 사용자가 지정한 id 입니다.
function chartReadyHandler(id) {
	document.getElementById(id).setLayout(layoutStr);
	document.getElementById(id).setData(chartData);
}

// 스트링 형식으로 레이아웃 정의
var layoutStr = 
				'<rMateChart frameColor="#EEEEEE"  borderStyle="none">'
					+'<Options>'
						+'<Caption text="실시간 온도" fontFamily="맑은 고딕"/>'
					+'</Options>'
					+'<NumberFormatter id="numFmt" precision="0"/>' 
					+'<CircularGauge valueChangeFunction="valueChangeFunc" padding="8" startAngle="90" minimumAngle="40" maximumAngle="320" minimum="0" maximum="150" value="25" interval="10" minorInterval="10" formatter="{numFmt}" tickLabelStyleName="tickText" valueLabelStyleName="valueText" editMode="true" majorTickType="circle" liveDragging="true" tickGap="-3" labelGap="-5" showDataTip="false" tickLabelPlacement="outside" tickColor="#1B699A" needleCoverRadius="100" needleThickness="100" pointThickness="0" tickRadius="2" needleLengthRatio="0.9" minorTickType="line" minorTickRadius="5" needlePointStyle="rounding" isValueTop="true" animationDuration="1000" bounceAnimating="true" rotateTickLabel="true" showOutFrame="true" outFrameLabelXOffset="0" outFrameLabelYOffset="0.2">'
						+'<frameFill>'
							+'<LinearGradient angle="0">'
								+'<entries>'
									+'<GradientEntry color="#f6af43" ratio="0"/>'
									+'<GradientEntry color="#f55a58" ratio="1"/>'
								+'</entries>'
							+'</LinearGradient>'
						+'</frameFill>'
						+'<frameStroke>'
							+'<Stroke color="#aaaaaa" weight="0"/>'
						+'</frameStroke>'
						+'<needleFill>'
							+'<SolidColor color="#555"/>'
						+'</needleFill>'
						+'<needleStroke>'
							+'<Stroke color="#555"/>'
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
							+'fontFamily:"맑은 고딕";'
							+'fontSize:11;'
							+'color:#555555;'
						+'}'
					+'</Style>'
					/**
					 * +'<RealTimeChart id="chart1" dataDisplayType="time" timePeriod="60" interval="3" showDataTips="true">'
					//60초동안 3초 간격으로 데이터 표현(시간 기준)
						+'<horizontalAxis>'
						//데이터와 축라벨은 모두 초단위, 데이터가 3초단위로 들어오므로 dataInterval=3, 축라벨 간격은 9(초), GMT가 아닌 Local시간 표시 true
							+'<DateTimeAxis dataUnits="seconds" labelUnits="seconds" dataInterval="3" interval="9" displayLocalTime="true"/>'
						+'</horizontalAxis>'
						+'<series>'
							+'<Column2DSeries xField="Time" yField="Volume" displayName="Trading Volume" itemRenderer="GradientColumnItemRenderer">'
								+'<fill>'
									+'<SolidColor color="0xB0C759" />'
								+'</fill>'
							+'</Column2DSeries>'
						+'</series>'
					+'</RealTimeChart>'
					+'<HttpServiceRepeater url="http://localhost/data2.jsp" target="{chart1}" interval="3" method="get" />'
					 */
				+'</rMateChart>';
				
// 게이지 데이터
var chartData = [22];

//게이지 값 랜덤 변경 함수
function changeValue()
{
	// 게이지의 값을 변경할려면 setData 함수를 사용하세요.
	document.getElementById("chart1").setDataURL("http://localhost/data2.jsp");
	
}

// 게이지 값 보관.
var gaugeValue;

// 게이지 value change 이벤트 핸들러 함수.
function valueChangeFunc(value)
{
	gaugeValue = value;
}

// 확인
function commitValue()
{
	alert(gaugeValue);
}
	
/**
 * rMateChartH5 3.0이후 버전에서 제공하고 있는 테마기능을 사용하시려면 아래 내용을 설정하여 주십시오.
 * 테마 기능을 사용하지 않으시려면 아래 내용은 삭제 혹은 주석처리 하셔도 됩니다.
 *
 * -- rMateChartH5.themes에 등록되어있는 테마 목록 --
 * - simple
 * - cyber
 * - modern
 * - lovely
 * - pastel
 * -------------------------------------------------
 *
 * rMateChartH5.themes 변수는 theme.js에서 정의하고 있습니다.
 */
rMateChartH5.registerTheme(rMateChartH5.themes);

/**
 * 샘플 내의 테마 버튼 클릭 시 호출되는 함수입니다.
 * 접근하는 차트 객체의 테마를 변경합니다.
 * 파라메터로 넘어오는 값
 * - simple
 * - cyber
 * - modern
 * - lovely
 * - pastel
 * - default
 *
 * default : 테마를 적용하기 전 기본 형태를 출력합니다.
 */
function rMateChartH5ChangeTheme(theme){
	document.getElementById("chart1").setTheme(theme);
}

// -----------------------차트 설정 끝 -----------------------
