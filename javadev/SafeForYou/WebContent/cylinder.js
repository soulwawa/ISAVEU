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
rMateChartH5.create("chart1", "chartHolder", chartVars, "100%", "100%"); 
 
// 차트의 속성인 rMateOnLoadCallFunction 으로 설정된 함수.
// rMate 차트 준비가 완료된 경우 이 함수가 호출됩니다.
// 이 함수를 통해 차트에 레이아웃과 데이터를 삽입합니다.
// 파라메터 : id - rMateChartH5.create() 사용 시 사용자가 지정한 id 입니다.
function chartReadyHandler(id) {
 document.getElementById(id).setLayout(layoutStr);
   document.getElementById(id).setData(chartData);
}
 
// 스트링 형식으로 레이아웃 정의.
var layoutStr = 
                '<rMateChart backgroundColor="#FFFFFF"  horizontalAlign="center" verticalAlign="middle" borderStyle="none">'
                  +'<CurrencyFormatter id="cft" currencySymbol="%" alignSymbol="right"/>'
                   +'<VCylinderGauge id="chart1" width="150" height="350" minimum="0" maximum="200" '
                   +'labels="[0,20,40,60,80,100,120,140,160,180,200]" tickInterval="20" value="temp" '
                   +'cylinderColor="[#ff842e,#ffd44a,#ff842e]" cylinderAlpha="[1,1,1]" cylinderRatio="[0,100,255]" '
                   +'targetMark="120" snapInterval="1" labelJsFunction="labelFunc" valueLabelStyleName="valueLabel" valueChangeFunction="changeFunction"/>'
                   +'<HttpServiceRepeater url="http://localhost/data3.jsp" target="{chart1}" interval="10" method="get"/>'
                   +'<Style>'
                        +'.valueLabel{fontSize:11;fontWeight:bold;}'
                   +'</Style>'  
               +'</rMateChart>';
 
// 게이지 데이터
var chartData = [50];
 
//게이지 값 랜덤 변경 함수
function changeValue()
{
  // 게이지의 값을 변경할려면 setData 함수를 사용하세요.
	document.getElementById("chart1").setDataURL("./data3.jsp");
}
 
// 게이지 값 보관.
var gaugeValue;
 
// 게이지 value change 이벤트 핸들러 함수.
function changeFunction(value)
{
 gaugeValue = value;
}
 
// 확인
function commitValue()
{
    alert(gaugeValue);
}
 
function labelFunc(value)
{
   return value+"%";
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