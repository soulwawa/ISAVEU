package kr.co.isaveyou.isaveyou.tab;

import android.animation.Animator;
import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;

import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.JsonReader;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.location.places.ui.SupportPlaceAutocompleteFragment;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

import kr.co.isaveyou.isaveyou.R;
import kr.co.isaveyou.isaveyou.main.MainActivity;

//날씨 탭 관련 내용 작성
public class NewsFragment extends Fragment {
    private static final String TAG = "NewsFragment";
    HttpURLConnection conn;
    String result, temperature_max, temperature_min, today, temperature_now, weather_status, rain_status, humidity_status, location, wdir, wspd;
    TextView tv_weather_news, tv_temperature_max, tv_temperature_min, tv_today, tv_temperature_now, tv_temperature_sign,tv_weather_status, tv_rain_status, tv_humidity, tv_location, tv_wdir, tv_wspd;
    private static final Interpolator INTERPOLATOR = new FastOutSlowInInterpolator();
    private int mDySinceDirectionChange;
    private boolean mIsShowing;
    private boolean mIsHiding;
    ImageView iv_weather;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news, container, false);
        tv_weather_news = (TextView)view.findViewById(R.id.tv_weather_news);
        iv_weather = (ImageView)view.findViewById(R.id.iv_weather);
        tv_temperature_max = (TextView)view.findViewById(R.id.tv_temperature_max);
        tv_temperature_min = (TextView)view.findViewById(R.id.tv_temperature_min);
        tv_temperature_now = (TextView)view.findViewById(R.id.tv_temperature_now);
        tv_temperature_sign = (TextView)view.findViewById(R.id.tv_temperature_sign);
        tv_today = (TextView)view.findViewById(R.id.tv_today);
        tv_weather_status = (TextView)view.findViewById(R.id.tv_weather_status);
        tv_rain_status = (TextView)view.findViewById(R.id.tv_rain_status);
        tv_humidity = (TextView)view.findViewById(R.id.tv_humidity);
        tv_location = (TextView)view.findViewById(R.id.tv_location);
        tv_wdir = (TextView)view.findViewById(R.id.tv_wdir);
        tv_wspd = (TextView)view.findViewById(R.id.tv_wspd);
        //비동기 thread 실행
        GetWeatherTask getWeatherTask = new GetWeatherTask();
        getWeatherTask.execute();

        return view;
    }

    //날씨 정보 가져옴 - sk developer api 사용
    class GetWeatherTask extends AsyncTask<String,Void,String> {
        @Override
        protected String doInBackground(String... strings) {
            String param = "lat=37.575071&lon=126.973378";
            Log.v(TAG, "param : " + param);
            try {
                //서버 접속
                URL url = new URL("https://api2.sktelecom.com/weather/current/minutely?" +param);
                conn = (HttpURLConnection) url.openConnection();
                //헤더 작성
                conn.setRequestProperty("Content-type", "application/json;charset=UTF-8");
                conn.setRequestProperty("Accept", "application/json");
                conn.setRequestProperty("appKey", "98759e5d-e689-4da4-91d4-f6d0cedb89f9");
                conn.setRequestMethod("GET");
                //받아오는 데이터가 있으므로 true
                conn.setDoInput(true);
                conn.connect();
                //responseCode로 판단
                if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
                    tv_weather_news.setText("서버에 접속할 수 없습니다.");
                } else {

                    InputStream is = conn.getInputStream();
                    StringBuffer buffer = new StringBuffer();
                    BufferedReader br = new BufferedReader(new InputStreamReader(is));
                    String line;

                    while ((line = br.readLine()) != null) {
                        buffer.append(line + "\n");
                    }
                    result = buffer.toString();
                    Log.v(TAG, "buffer result : " + line);
                    br.close();
                }
                Log.v(TAG, "url : " + url);


            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;

        }
        //받아온 Json 객체 파싱
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            try{
                JSONObject jsonObject = new JSONObject(result);
                JSONObject jObj = jsonObject.getJSONObject("weather");
                JSONArray jjObj = jObj.getJSONArray("minutely");
                Log.v(TAG, "jObj : " +jObj);
                Log.v(TAG, "jjObj : " +jjObj);
                for(int i = 0; i<jjObj.length();i++){
                    JSONObject jObject = jjObj.getJSONObject(i);
                    today = jObject.getString("timeObservation");
                    Log.v(TAG, "today : " + today);
                    JSONObject temp_obj = jObject.getJSONObject("temperature");
                    temperature_now = temp_obj.getString("tc");
                    temperature_max = temp_obj.getString("tmax");
                    temperature_min = temp_obj.getString("tmin");
                    JSONObject sky_obj = jObject.getJSONObject("sky");
                    weather_status = sky_obj.getString("name");
                    JSONObject rain_obj= jObject.getJSONObject("rain");
                    rain_status = rain_obj.getString("sinceOntime");
                    humidity_status = jObject.getString("humidity");
                    JSONObject station_obj = jObject.getJSONObject("station");
                    location = station_obj.getString("name");
                    JSONObject wind_obj = jObject.getJSONObject("wind");
                    wdir = wind_obj.getString("wdir");
                    wspd = wind_obj.getString("wspd");
                    Log.v(TAG, "tc :" + temperature_now + ", tmax : "+ temperature_max + ", tmin : " + temperature_min + ", status : " + weather_status);
                }
                String temperature_sign = getResources().getString(R.string.temperature);
                String rain_sign = getResources().getString(R.string.rain_status);
                String humidity_sign = getResources().getString(R.string.humidity_sign);
                String wind_sign = "";
                tv_today.setText(String.valueOf(today));
                tv_temperature_max.setText("최고 : "+ String.valueOf(temperature_max) + " " + temperature_sign);
                tv_temperature_min.setText("최저 : "+ String.valueOf(temperature_min) + " " + temperature_sign);
                tv_temperature_now.setText(String.valueOf(temperature_now));
                tv_rain_status.setText("강수량 : " + String.valueOf(rain_status) + " " + rain_sign);
                tv_humidity.setText("습도 : " + String.valueOf(humidity_status) + " " + humidity_sign);
                tv_location.setText("지역 : " + String.valueOf(location));
                tv_wdir.setText("풍향 : " + String.valueOf(wdir));
                tv_wspd.setText("풍속 : " + String.valueOf(wspd) + " " + wind_sign);
                switch (weather_status){
                    case "맑음" :
                        iv_weather.setImageDrawable(getResources().getDrawable(R.drawable.pic_weather_sun));
                        break;
                    case "구름조금" :
                        iv_weather.setImageDrawable(getResources().getDrawable(R.drawable.pic_weather_cloudy_small));
                        break;
                    case "구름많음" :
                        iv_weather.setImageDrawable(getResources().getDrawable(R.drawable.pic_weather_cloudy));
                        break;
                    case "구름많고 비" :
                        iv_weather.setImageDrawable(getResources().getDrawable(R.drawable.pic_weather_rain));
                        break;
                    case "구름많고 눈":
                        iv_weather.setImageDrawable(getResources().getDrawable(R.drawable.pic_weather_cloudy_snow));
                        break;
                    case "구름많고 비 또는 눈":
                        iv_weather.setImageDrawable(getResources().getDrawable(R.drawable.pic_weather_rain_snow));
                        break;
                    case "흐림":
                        iv_weather.setImageDrawable(getResources().getDrawable(R.drawable.pic_weather_cloudy_gray));
                        break;
                    case "흐리고 비":
                        iv_weather.setImageDrawable(getResources().getDrawable(R.drawable.pic_weather_cloudy_gray_rain));
                        break;
                    case "흐리고 눈":
                        iv_weather.setImageDrawable(getResources().getDrawable(R.drawable.pic_weather_cloudy_gray_snow_rain));
                        break;
                    case "흐리고 비 또는 눈":
                        iv_weather.setImageDrawable(getResources().getDrawable(R.drawable.pic_weather_cloudy_gray));
                        break;
                    case "흐리고 낙뢰":
                        iv_weather.setImageDrawable(getResources().getDrawable(R.drawable.pic_weather_cloudy_lightening));
                        break;
                    case "뇌우/비":
                        iv_weather.setImageDrawable(getResources().getDrawable(R.drawable.pic_weather_lightening_rain));
                        break;
                    case "뇌우/눈":
                        iv_weather.setImageDrawable(getResources().getDrawable(R.drawable.pic_weather_cloudy_lightening_snow));
                        break;
                    case "뇌우/비 또는 눈":
                        iv_weather.setImageDrawable(getResources().getDrawable(R.drawable.pic_weather_cloudy_lightening_snow_rain));
                        break;
                }
                tv_weather_status.setText(String.valueOf(weather_status));
                Log.v(TAG, result);
            }
            catch (JSONException e){
                e.printStackTrace();
            }catch (NullPointerException e){
                e.printStackTrace();
            }
            if(isAdded()){
                getResources().getString(R.string.app_name);
            }
        }
    }



    @Override
    public void onDetach() {
        super.onDetach();
//        mListener = null;
    }
    //CoordinatorLayout 활용하여 애니메이션을 넣으려 했지만 시간이 부족하여 적용하지 못함
    public class QuickReturnFooterBehavior extends CoordinatorLayout.Behavior<View>{

        //스크롤에 반응
        @Override
        public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, View child, View directTargetChild, View target, int nestedScrollAxes, int type) {
            return  nestedScrollAxes == ViewCompat.SCROLL_AXIS_HORIZONTAL;
        }
        //Footer View hide/show
        @Override
        public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, View child, View target, int dx, int dy, int[] consumed) {
            //스크롤 방향이 바뀌는 경우 모든 동작을 취소하고 Y값을 다시 처음부터 시작
            if(dy>0&&mDySinceDirectionChange <0 || dy<0 && mDySinceDirectionChange>0){
                child.animate().cancel();
                mDySinceDirectionChange = 0;
            }
            mDySinceDirectionChange += dy;
            if(mDySinceDirectionChange > child.getHeight()&& child.getVisibility()==View.VISIBLE && !mIsHiding){
                hideView(child);
            }else if(mDySinceDirectionChange < 0 && child.getVisibility()==View.GONE && !mIsShowing){
                showView(child);
            }
        }
        // view를 숨김
        // 아래로 슬라이등하는 애니메이션
        // 애니메이션 종료 후 View를 없앤다
        private void hideView(final View view){
            mIsHiding = true;
            ViewPropertyAnimator animator = view.animate().translationY(view.getHeight()).setInterpolator(INTERPOLATOR).setDuration(200);
            animator.setListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animation) {
                }

                @Override
                public void onAnimationEnd(Animator animation) {
                    mIsHiding = false;
                    view.setVisibility(View.GONE);
                }

                @Override
                public void onAnimationCancel(Animator animation) {
                    //취소되면 다시 숨김
                    mIsHiding = false;
                    if(!mIsHiding){
                        showView(view);
                    }
                }

                @Override
                public void onAnimationRepeat(Animator animation) {

                }
            });
            animator.start();
        }
        private void showView(final View view){
            mIsShowing = true;
            ViewPropertyAnimator animator = view.animate().translationY(0).setInterpolator(INTERPOLATOR).setDuration(200);
            animator.setListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animation) {
                    view.setVisibility(View.VISIBLE);
                }

                @Override
                public void onAnimationEnd(Animator animation) {
                    mIsShowing = false;
                }

                @Override
                public void onAnimationCancel(Animator animation) {
                   //취소되면 다시 숨김
                    mIsShowing = false;
                    if(!mIsHiding){
                        hideView(view);
                    }

                }

                @Override
                public void onAnimationRepeat(Animator animation) {
                }
            });
            animator.start();
        }
    }


}
