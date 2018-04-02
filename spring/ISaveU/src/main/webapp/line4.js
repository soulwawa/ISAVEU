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
                      
                    
                    	+'<Line2DSeries labelPosition="up" yField="Sheep" fill="#ffffff" radius="5" displayName="temp" itemRenderer="RectangleItemRenderer">'
                           +'<showDataEffect>'
                           + '<' + effect + ' duration="1000"/>'
                           +'</showDataEffect>'
                        +'</Line2DSeries>'
                      
                        +'<Line2DSeries labelPosition="up" yField="Beef" fill="#ffffff" radius="5" displayName="smoke" itemRenderer="CircleItemRenderer">'
                           +'<showDataEffect>'
                           + '<' + effect + ' duration="1000"/>'
                           +'</showDataEffect>'
                         +'</Line2DSeries>'
                         
                        +'<Line2DSeries labelPosition="up" yField="Chicken" fill="#ffffff" radius="6" displayName="fire" itemRenderer="TriangleItemRenderer">'
                         +'<showDataEffect>'
                         + '<' + effect + ' duration="1000"/>'
                           +'</showDataEffect>'
                        +'</Line2DSeries>'
                      
                        +'<Line2DSeries labelPosition="up" yField="aaa" fill="#ffffff" radius="6" displayName="gyro" itemRenderer="DiamondItemRenderer">'
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
//var chartData2 = [{"Month":"Jan", "Beef":38.5, "Chicken":20, "Sheep":50, "aaa":10},
//                {"Month":"Feb", "Beef":56.57, "Chicken":27.52, "Sheep":42, "aaa":11},
//             {"Month":"Mar", "Beef":58.57, "Chicken":23.65, "Sheep":40, "aaa":12},
//             {"Month":"Apr", "Beef":41.13, "Chicken":29.54, "Sheep":60, "aaa":13},
//             {"Month":"May", "Beef":40.58, "Chicken":24.21, "Sheep":50, "aaa":14},
//             {"Month":"Jun", "Beef":60.79, "Chicken":39.12, "Sheep":52.5, "aaa":15},
//               {"Month":"Jul", "Beef":49.14, "Chicken":32.56, "Sheep":70.64, "aaa":14},
//              {"Month":"Aug", "Beef":89.35, "Chicken":39.24, "Sheep":68.57, "aaa":13},
//              {"Month":"Sep", "Beef":65.21, "Chicken":32.12, "Sheep":54.14, "aaa":12},
//              {"Month":"Oct", "Beef":75.15, "Chicken":42.12, "Sheep":57.58, "aaa":11},
//              {"Month":"Nov", "Beef":69.12, "Chicken":35.54, "Sheep":54.47, "aaa":10},
//              {"Month":"Dec", "Beef":73.24, "Chicken":40.45, "Sheep":62.47, "aaa":14}];

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