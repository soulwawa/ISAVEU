var chartVars = "rMateOnLoadCallFunction=chartReadyHandler";
 
rMateChartH5.create("chart1", "chartHolder", chartVars, "100%", "100%"); 
 
function chartReadyHandler(id) {
 document.getElementById(id).setLayout(layoutStr);
}

var layoutStr = 
              '<rMateChart backgroundColor="#FFFFFF"  borderStyle="none">'
                  +'<Options>'
                      +'<Caption text="RealTime Chart"/>'
                       +'<SubCaption text="매 3초 단위로 최근 15개의 데이터를 표현합니다.(데이터는 랜덤)" fontSize="11" fontFamily="맑은 고딕"/>'
                        +'<Legend useVisibleCheck="true"/>'
                   +'</Options>'
                 +'<DateFormatter id="dateFmt" formatString="HH:NN:SS"/>'
                 +'<RealTimeChart id="chart" dataDisplayType="dataSize" displayDataSize="15" showDataTips="true">'
             /*  
                실시간 차트 생성시에 필요한 RealTimeChart 정의합니다 
                showDataTips : 데이터에 마우스를 가져갔을 때 나오는 Tip을 보이기/안보이기 속성입니다  
               dateDisplayType - dataSize, time : 차트 표현 유형을 나타냅니다 default:dataSize
             diplayDataSize : 한 화면에 표현할 데이터 양 입니다 default:20
             interval : 차트 표현 유형이 "time"인 경우 HttpServiceRepeater의 interval값
              timePeriod : 차트 유형이 "time"인 경우 데이터를 차트에 나타낼 시간단위
                이 예제에서는 dataSize유형으로 나타내고 있습니다
              */ 
                        +'<horizontalAxis>'
                           +'<CategoryAxis id="hAxis" categoryField="Time" formatter="{dateFmt}"/>'
                         /* 차트 유형이 dataSize라면 CategoryAxis를 사용 해야합니다 */
                      +'</horizontalAxis>'
                      +'<verticalAxis>'
                         +'<LinearAxis id="vAxis" minimum="0" maximum="100" interval="10"/>'
                       +'</verticalAxis>'
                        +'<series>'
                           +'<Area2DSeries labelPosition="up" yField="P1" displayName="Process 1" itemRenderer="CircleItemRenderer"/>'
                           +'<Area2DSeries labelPosition="up" yField="P2" displayName="Process 2" itemRenderer="CircleItemRenderer"/>'
                       +'</series>'
                      +'<annotationElements>'
                           +'<AxisMarker>'
                               +'<lines>'
                                    +'<AxisLine value="70" label="한계치(70)" fontFamily="맑은 고딕">'
                                       +'<stroke>'
                                           +'<Stroke color="#ff0000" weight="1"/>'
                                       +'</stroke>'
                                  +'</AxisLine>'
                                +'</lines>'
                           +'</AxisMarker>'
                      +'</annotationElements>'
                  +'</RealTimeChart>'
                   +'<HttpServiceRepeater url="http://demo.riamore.net/demo/chart/process3Data.jsp" target="{chart}" interval="3" method="get"/>'
               /* 
             실시간 차트에는 HttpServiceRepeater를 반드시 정의해야 합니다
              url : 데이터가 있는 URL 경로입니다
             interval : 매초 단위로 RPC를 실행할 것인지를 나타냅니다 예를 들어 60이라면 1분 단위로 RPC를 실행합니다 default:30
              target : RPC성공 후 가져온 데이터를 넘겨줄 객체를 말합니다. 실시간 차트의 id를 정의하십시오
              method - get, post : HTTP프로토콜 메소드입니다. Get인지 Post인지 정의하십시오
               useFaultAlert - true, false : RPC실패 시 실패 했다는 경고창을 나타냅니다 defalt:true - 실시간 차트 생성시 주의점 -
              1.실시간 차트의 HttpServiceRepeater는 반드시 +'</rMateChart>'노드의 자식 위치에,
                  그리고 +'</RealTimeChart>'의 아래 형제 위치에 있어야 합니다
              2.target속성의 속성값으로 차트(RealTimeChart)의 id값을 정의 하십시오
               3.HttpServiceRepeater의 url은 차트 데이터가 있는 XML url 경로입니다
                  이 XML 데이터 형식은 반드시 아래와 같은 구조로 작성 되어야 합니다
               +'<items>'
                    +'<item>'
                     +'<Time>'13:8:27+'</Time>'
                      +'<Volume>'5527+'</Volume>'
                     +'<Price>'309+'</Price>'
                    +'</item>'
                +'</items>'
                */
             +'</rMateChart>';
 
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
