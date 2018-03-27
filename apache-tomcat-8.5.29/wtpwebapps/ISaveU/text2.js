var chartVars = "rMateOnLoadCallFunction=chartReadyHandler";
 
rMateChartH5.create("chart1", "chartHolder", chartVars, "100%", "100%"); 
 
function chartReadyHandler(id) {
 document.getElementById(id).setLayout(layoutStr);
   document.getElementById(id).setData(chartData);
}
 
var layoutStr = 
                '<rMateChart backgroundColor="#FFFFFF"  borderStyle="none">'
                  +'<Options>'
                      +'<Caption text="Annual Report"/>'
                    +'</Options>'
                 +'<NumberFormatter id="numfmt" useThousandsSeparator="true"/>'
                   +'<Combination2DChart showDataTips="true">'
                   /* 
                     Combination2D 차트 생성시에 필요한 Combination2DChart 정의합니다 
                     showDataTips : 데이터에 마우스를 가져갔을 때 나오는 Tip을 보이기/안보이기 속성입니다  
                   */
                      +'<horizontalAxis>'
                           +'<CategoryAxis categoryField="Month" padding="1"/>'
                     +'</horizontalAxis>'
                      +'<verticalAxis>'
                         +'<LinearAxis id="vAxis1" formatter="{numfmt}" maximum="100" interval="10"/>'
                     +'</verticalAxis>'
                        +'<series>'
                           +'<Column2DSeries labelPosition="outside" yField="Profit" displayName="Profit" showValueLabels="[5]" columnWidthRatio="0.54">'
                                +'<fill>'
                                 +'<SolidColor color="#41b2e6"/>'
                              +'</fill>'
                                +'<showDataEffect>'
                                   +'<SeriesInterpolate/>'
                              +'</showDataEffect>'
                          +'</Column2DSeries>'
                          +'<Line2DSeries radius="6" yField="Cost" displayName="Cost" itemRenderer="CircleItemRenderer">'
                               +'<verticalAxis>'
                                 +'<LinearAxis id="vAxis2" interval="40" maximum="320"/>'
                              +'</verticalAxis>'
                                +'<showDataEffect>'
                                   +'<SeriesInterpolate/>'
                              +'</showDataEffect>'
                              +'<lineStroke>'
                                   +'<Stroke color="#f9bd03" weight="4"/>'
                               +'</lineStroke>'
                              +'<stroke>'
                                   +'<Stroke color="#f9bd03" weight="3"/>'
                               +'</stroke>'
                          +'</Line2DSeries>'
                        +'</series>'
                      +'<verticalAxisRenderers>'
                            +'<Axis2DRenderer axis="{vAxis1}" showLine="false"/>'
                         +'<Axis2DRenderer axis="{vAxis2}" showLine="false"/>'
                     +'</verticalAxisRenderers>'
                   +'</Combination2DChart>'
              +'</rMateChart>';
 
// 차트 데이터
var chartData = [{"Month":"Jan","Profit":20,"Cost":120,"Revenue":2300},
             {"Month":"Feb","Profit":30,"Cost":160,"Revenue":1200},
              {"Month":"Mar","Profit":52,"Cost":150,"Revenue":1600},
              {"Month":"Apr","Profit":45,"Cost":190,"Revenue":1300},
              {"Month":"May","Profit":62,"Cost":180,"Revenue":1000},
              {"Month":"Jun","Profit":82,"Cost":250,"Revenue":1200},
              {"Month":"Jul","Profit":48,"Cost":130,"Revenue":1000},
              {"Month":"Aug","Profit":39,"Cost":100,"Revenue":1600},
              {"Month":"Sep","Profit":61,"Cost":180,"Revenue":1200},
              {"Month":"Oct","Profit":42,"Cost":120,"Revenue":1000}];
 
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