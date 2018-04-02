var chartVars = "rMateOnLoadCallFunction=chartReadyHandler2";
 
// rMateChart 를 생성합니다.
// 파라메터 (순서대로) 
//  1. 차트의 id ( 임의로 지정하십시오. ) 
//  2. 차트가 위치할 div 의 id (즉, 차트의 부모 div 의 id 입니다.)
//  3. 차트 생성 시 필요한 환경 변수들의 묶음인 chartVars
//  4. 차트의 가로 사이즈 (생략 가능, 생략 시 100%)
//  5. 차트의 세로 사이즈 (생략 가능, 생략 시 100%)
rMateChartH5.create("chart5", "chartHolder5", chartVars, "59.5%", "100%"); 
 
// 차트의 속성인 rMateOnLoadCallFunction 으로 설정된 함수.
// rMate 차트 준비가 완료된 경우 이 함수가 호출됩니다.
// 이 함수를 통해 차트에 레이아웃과 데이터를 삽입합니다.
// 파라메터 : id - rMateChartH5.create() 사용 시 사용자가 지정한 id 입니다.
function chartReadyHandler2(id) {
 document.getElementById(id).setLayout(layoutStr);
   document.getElementById(id).setData(chartData2);
}

var effect = compIE() ? "SeriesClip" : "SeriesInterpolate";
 
// 스트링 형식으로 레이아웃 정의.
var layoutStr = 
                '<rMateChart  backgroundColor="#ffffff" borderStyle="none">'
              +'<Options>'
                  +'<Caption text=""/>'
                  +'<SubCaption text="실시간 측정값" />'
                   +'<Legend useVisibleCheck="true"/>'
               +'</Options>'
             +'<NumberFormatter id="numFmt" precision="0"/>'
               +'<Line2DChart showDataTips="true" dataTipDisplayMode="axis" paddingTop="0">'
                 +'<horizontalAxis>'
                       +'<CategoryAxis categoryField="time" padding="0.2"/>'
                    +'</horizontalAxis>'
                  +'<verticalAxis>'
                     +'<LinearAxis maximum="100"/>'
                    +'</verticalAxis>'
                    +'<series>'
                       /* 
                     itemRenderer는 Tip이 보여지는 영역차트 부분에 ItemRenderer에서 제공하는 모양을 그려줍니다
                      이 예제에서는 Diamond입니다
                      사용할 수 있는 도형을 모두 표현한 예제는 Chart Samples 의 범례 예제를 참고하십시오.
                      */
                      
                    
                    	+'<Line2DSeries labelPosition="up" yField="fire" fill="#ffffff" radius="5" displayName="temp" itemRenderer="RectangleItemRenderer">'
                           +'<showDataEffect>'
                           + '<' + effect + ' duration="1000"/>'
                           +'</showDataEffect>'
                        +'</Line2DSeries>'
                      
                        +'<Line2DSeries labelPosition="up" yField="temp" fill="#ffffff" radius="5" displayName="smoke" itemRenderer="CircleItemRenderer">'
                           +'<showDataEffect>'
                           + '<' + effect + ' duration="1000"/>'
                           +'</showDataEffect>'
                         +'</Line2DSeries>'
                         
                        +'<Line2DSeries labelPosition="up" yField="smoke" fill="#ffffff" radius="6" displayName="fire" itemRenderer="TriangleItemRenderer">'
                         +'<showDataEffect>'
                         + '<' + effect + ' duration="1000"/>'
                           +'</showDataEffect>'
                        +'</Line2DSeries>'
                      
                        +'<Line2DSeries labelPosition="up" yField="gyro" fill="#ffffff" radius="6" displayName="gyro" itemRenderer="DiamondItemRenderer">'
                         +'<showDataEffect>'
                         + '<' + effect + ' duration="1000"/>'
                           +'</showDataEffect>'
                       +'</Line2DSeries>'
                      
                       
                    +'</series>'
                  +'<annotationElements>'
                       +'<CrossRangeZoomer zoomType="horizontal" fontSize="11" color="#FFFFFF" horizontalLabelFormatter="{numFmt}" verticalLabelPlacement="bottom" horizontalLabelPlacement="left" enableZooming="false" enableCrossHair="true">'
                        +'</CrossRangeZoomer>'
                    +'</annotationElements>'
              +'</Line2DChart>'
         +'</rMateChart>';
 
//// 차트 데이터
var chartData2 = [{"time":"00:00:55", "temp":38.5, "smoke":20, "fire":50, "gyro":10},
                  {"time":"00:00:50", "temp":56.57, "smoke":27.52, "fire":42, "gyro":11},
                  {"time":"00:00:45", "temp":58.57, "smoke":23.65, "fire":40, "gyro":12},
                  {"time":"00:00:40", "temp":41.13, "smoke":29.54, "fire":60, "gyro":13},
                  {"time":"00:00:35", "temp":"50", "smoke":24.21, "fire":50, "gyro":14},
                  {"time":"00:00:30", "temp":60.79, "smoke":39.12, "fire":52.5, "gyro":15},
                  {"time":"00:00:25", "temp":49.14, "smoke":32.56, "fire":70.64, "gyro":14},
                  {"time":"00:00:20", "temp":89.35, "smoke":39.24, "fire":68.57, "gyro":13},
                  {"time":"00:00:15", "temp":65.21, "smoke":32.12, "fire":54.14, "gyro":12},
                  {"time":"00:00:10", "temp":75.15, "smoke":42.12, "fire":57.58, "gyro":11},
                  {"time":"00:00:05", "temp":69.12, "smoke":35.54, "fire":54.47, "gyro":10},
                  {"time":"00:00:00", "temp":73.24, "smoke":40.45, "fire":62.47, "gyro":14}];

//IE 판별
function compIE(){
  var agent = navigator.userAgent;
    if(agent.indexOf("MSIE 7.0") > -1 || agent.indexOf("MSIE 8.0") > - 1 || agent.indexOf("Trident 4.0") > -1)
     return false;
 
   if(document.documentMode && document.documentMode <= 5)
      return false;
 
   return true;
}
 

rMateChartH5.registerTheme(rMateChartH5.themes);
 

function rMateChartH5ChangeTheme(theme){
 document.getElementById("chart5").setTheme(theme);
}
 
// -----------------------차트 설정 끝 -----------------------