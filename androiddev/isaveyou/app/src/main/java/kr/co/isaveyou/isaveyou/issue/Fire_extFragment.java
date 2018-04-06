package kr.co.isaveyou.isaveyou.issue;


import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import com.akexorcist.roundcornerprogressbar.RoundCornerProgressBar;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Locale;


import kr.co.isaveyou.isaveyou.R;

//소화기 위치 확인을 위한 Fragment
public class Fire_extFragment extends Fragment {
    private static final String TAG = "Fire_extFragment";
    ImageSwitcher fire_ext1, fire_ext2, fire_ext3, fire_ext4, fire_ext5, fire_ext6,  fire_ext7,  fire_ext8,  fire_ext9, fire_ext10, fire_ext11;
    RoundCornerProgressBar pb_600, pb_601, pb_602, pb_603, pb_604,pb_605,pb_606,pb_607, pb_608, pb_609, pb_610;
    ArrayList<ImageSwitcher>switcherList = new ArrayList();
    Handler threadHandler = new Handler();
    ImageSwitcher switcher;
    TextView tv_startDate_600, tv_endDate_600, tv_startDate_601, tv_endDate_601, tv_startDate_602, tv_endDate_602, tv_startDate_603, tv_endDate_603, tv_startDate_604, tv_endDate_604, tv_startDate_605, tv_endDate_605, tv_startDate_606, tv_endDate_606, tv_startDate_607, tv_endDate_607, tv_startDate_608, tv_endDate_608,tv_startDate_609, tv_endDate_609, tv_startDate_610, tv_endDate_610;
    boolean running;
    Thread thread;
    Button checkButton;
    LinearLayout layout_fire_ext1,layout_fire_ext2,layout_fire_ext3,layout_fire_ext4,layout_fire_ext5,layout_fire_ext6,layout_fire_ext7,layout_fire_ext8,layout_fire_ext9,layout_fire_ext10,layout_fire_ext11;
    String result;
    HttpURLConnection conn;
    LinearLayout [] linearLayouts = new LinearLayout[11];
    ImageSwitcher [] imageSwitchers = new ImageSwitcher[11];


    View.OnClickListener handler = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.checkButton:
                    Log.v(TAG, "소화기 보기 눌림");
                    Toast.makeText(getContext(),"소화기를 누르시면 남은 점검 일자를 확인하실 수 있습니다.",Toast.LENGTH_SHORT).show();
                    Fire_ext_CheckTask fire_ext_checkTask = new Fire_ext_CheckTask();
                    fire_ext_checkTask.execute();
                    checkButton.setEnabled(false);
                    break;
                case R.id.room600_hallWay01_Fire_ext:
                    Log.v(TAG, "hallWay01_Fire_ext 눌림");
                    layout_fire_ext1.setVisibility(View.VISIBLE);
                    layout_fire_ext2.setVisibility(View.INVISIBLE);
                    layout_fire_ext3.setVisibility(View.INVISIBLE);
                    layout_fire_ext4.setVisibility(View.INVISIBLE);
                    layout_fire_ext5.setVisibility(View.INVISIBLE);
                    layout_fire_ext6.setVisibility(View.INVISIBLE);
                    layout_fire_ext7.setVisibility(View.INVISIBLE);
                    layout_fire_ext8.setVisibility(View.INVISIBLE);
                    layout_fire_ext9.setVisibility(View.INVISIBLE);
                    layout_fire_ext10.setVisibility(View.INVISIBLE);
                    layout_fire_ext11.setVisibility(View.INVISIBLE);
                    ImageThread.interrupted();
                    break;
                case R.id.room601_waitingRoom_Fire_ext:
                    Log.v(TAG, "room601_waitingRoom_Fire_ext");
                    layout_fire_ext1.setVisibility(View.INVISIBLE);
                    layout_fire_ext2.setVisibility(View.VISIBLE);
                    layout_fire_ext3.setVisibility(View.INVISIBLE);
                    layout_fire_ext4.setVisibility(View.INVISIBLE);
                    layout_fire_ext5.setVisibility(View.INVISIBLE);
                    layout_fire_ext6.setVisibility(View.INVISIBLE);
                    layout_fire_ext7.setVisibility(View.INVISIBLE);
                    layout_fire_ext8.setVisibility(View.INVISIBLE);
                    layout_fire_ext9.setVisibility(View.INVISIBLE);
                    layout_fire_ext10.setVisibility(View.INVISIBLE);
                    layout_fire_ext11.setVisibility(View.INVISIBLE);
                    ImageThread.interrupted();
                    break;
                case R.id.room602_Fire_ext:
                    Log.v(TAG, "room602_Fire_ext");
                    layout_fire_ext1.setVisibility(View.INVISIBLE);
                    layout_fire_ext2.setVisibility(View.INVISIBLE);
                    layout_fire_ext3.setVisibility(View.VISIBLE);
                    layout_fire_ext4.setVisibility(View.INVISIBLE);
                    layout_fire_ext5.setVisibility(View.INVISIBLE);
                    layout_fire_ext6.setVisibility(View.INVISIBLE);
                    layout_fire_ext7.setVisibility(View.INVISIBLE);
                    layout_fire_ext8.setVisibility(View.INVISIBLE);
                    layout_fire_ext9.setVisibility(View.INVISIBLE);
                    layout_fire_ext10.setVisibility(View.INVISIBLE);
                    layout_fire_ext11.setVisibility(View.INVISIBLE);
                    ImageThread.interrupted();
                    break;
                case R.id.room603_Fire_ext:
                    Log.v(TAG, "room603_Fire_ext 눌림");
                    layout_fire_ext1.setVisibility(View.INVISIBLE);
                    layout_fire_ext2.setVisibility(View.INVISIBLE);
                    layout_fire_ext3.setVisibility(View.INVISIBLE);
                    layout_fire_ext4.setVisibility(View.VISIBLE);
                    layout_fire_ext5.setVisibility(View.INVISIBLE);
                    layout_fire_ext6.setVisibility(View.INVISIBLE);
                    layout_fire_ext7.setVisibility(View.INVISIBLE);
                    layout_fire_ext8.setVisibility(View.INVISIBLE);
                    layout_fire_ext9.setVisibility(View.INVISIBLE);
                    layout_fire_ext10.setVisibility(View.INVISIBLE);
                    layout_fire_ext11.setVisibility(View.INVISIBLE);
                    ImageThread.interrupted();
                    break;
                case R.id.room604_Fire_ext:
                    Log.v(TAG, "room604_Fire_ext 눌림");
                    layout_fire_ext1.setVisibility(View.INVISIBLE);
                    layout_fire_ext2.setVisibility(View.INVISIBLE);
                    layout_fire_ext3.setVisibility(View.INVISIBLE);
                    layout_fire_ext4.setVisibility(View.INVISIBLE);
                    layout_fire_ext5.setVisibility(View.VISIBLE);
                    layout_fire_ext6.setVisibility(View.INVISIBLE);
                    layout_fire_ext7.setVisibility(View.INVISIBLE);
                    layout_fire_ext8.setVisibility(View.INVISIBLE);
                    layout_fire_ext9.setVisibility(View.INVISIBLE);
                    layout_fire_ext10.setVisibility(View.INVISIBLE);
                    layout_fire_ext11.setVisibility(View.INVISIBLE);
                    ImageThread.interrupted();
                    break;
                case R.id.room605_Fire_ext:
                    Log.v(TAG, "room605_Fire_ext");
                    layout_fire_ext1.setVisibility(View.INVISIBLE);
                    layout_fire_ext2.setVisibility(View.INVISIBLE);
                    layout_fire_ext3.setVisibility(View.INVISIBLE);
                    layout_fire_ext4.setVisibility(View.INVISIBLE);
                    layout_fire_ext5.setVisibility(View.INVISIBLE);
                    layout_fire_ext6.setVisibility(View.VISIBLE);
                    layout_fire_ext7.setVisibility(View.INVISIBLE);
                    layout_fire_ext8.setVisibility(View.INVISIBLE);
                    layout_fire_ext9.setVisibility(View.INVISIBLE);
                    layout_fire_ext10.setVisibility(View.INVISIBLE);
                    layout_fire_ext11.setVisibility(View.INVISIBLE);

                    ImageThread.interrupted();
                    break;
                case R.id.room606_Fire_ext:
                    Log.v(TAG, "room606_Fire_ext");
                    layout_fire_ext1.setVisibility(View.INVISIBLE);
                    layout_fire_ext2.setVisibility(View.INVISIBLE);
                    layout_fire_ext3.setVisibility(View.INVISIBLE);
                    layout_fire_ext4.setVisibility(View.INVISIBLE);
                    layout_fire_ext5.setVisibility(View.INVISIBLE);
                    layout_fire_ext6.setVisibility(View.INVISIBLE);
                    layout_fire_ext7.setVisibility(View.VISIBLE);
                    layout_fire_ext8.setVisibility(View.INVISIBLE);
                    layout_fire_ext9.setVisibility(View.INVISIBLE);
                    layout_fire_ext10.setVisibility(View.INVISIBLE);
                    layout_fire_ext11.setVisibility(View.INVISIBLE);
                    ImageThread.interrupted();
                    break;
                case R.id.room607_Fire_ext:
                    Log.v(TAG, "room607_Fire_ext 눌림");
                    layout_fire_ext1.setVisibility(View.INVISIBLE);
                    layout_fire_ext2.setVisibility(View.INVISIBLE);
                    layout_fire_ext3.setVisibility(View.INVISIBLE);
                    layout_fire_ext4.setVisibility(View.INVISIBLE);
                    layout_fire_ext5.setVisibility(View.INVISIBLE);
                    layout_fire_ext6.setVisibility(View.INVISIBLE);
                    layout_fire_ext7.setVisibility(View.INVISIBLE);
                    layout_fire_ext8.setVisibility(View.VISIBLE);
                    layout_fire_ext9.setVisibility(View.INVISIBLE);
                    layout_fire_ext10.setVisibility(View.INVISIBLE);
                    layout_fire_ext11.setVisibility(View.INVISIBLE);
                    ImageThread.interrupted();
                    break;
                case R.id.room608_Fire_ext:
                    Log.v(TAG, "room608_Fire_ext 눌림");
                    layout_fire_ext1.setVisibility(View.INVISIBLE);
                    layout_fire_ext2.setVisibility(View.INVISIBLE);
                    layout_fire_ext3.setVisibility(View.INVISIBLE);
                    layout_fire_ext4.setVisibility(View.INVISIBLE);
                    layout_fire_ext5.setVisibility(View.INVISIBLE);
                    layout_fire_ext6.setVisibility(View.INVISIBLE);
                    layout_fire_ext7.setVisibility(View.INVISIBLE);
                    layout_fire_ext8.setVisibility(View.INVISIBLE);
                    layout_fire_ext9.setVisibility(View.VISIBLE);
                    layout_fire_ext10.setVisibility(View.INVISIBLE);
                    layout_fire_ext11.setVisibility(View.INVISIBLE);
                    ImageThread.interrupted();
                    break;
                case R.id.room609_Fire_ext:
                    Log.v(TAG, "room609_Fire_ext 눌림");
                    layout_fire_ext1.setVisibility(View.INVISIBLE);
                    layout_fire_ext2.setVisibility(View.INVISIBLE);
                    layout_fire_ext3.setVisibility(View.INVISIBLE);
                    layout_fire_ext4.setVisibility(View.INVISIBLE);
                    layout_fire_ext5.setVisibility(View.INVISIBLE);
                    layout_fire_ext6.setVisibility(View.INVISIBLE);
                    layout_fire_ext7.setVisibility(View.INVISIBLE);
                    layout_fire_ext8.setVisibility(View.INVISIBLE);
                    layout_fire_ext9.setVisibility(View.INVISIBLE);
                    layout_fire_ext10.setVisibility(View.VISIBLE);
                    layout_fire_ext11.setVisibility(View.INVISIBLE);
                    ImageThread.interrupted();
                    break;
                case R.id.restRoom610_Fire_ext:
                    Log.v(TAG, "restRoom610_Fire_ext 눌림");
                    layout_fire_ext1.setVisibility(View.INVISIBLE);
                    layout_fire_ext2.setVisibility(View.INVISIBLE);
                    layout_fire_ext3.setVisibility(View.INVISIBLE);
                    layout_fire_ext4.setVisibility(View.INVISIBLE);
                    layout_fire_ext5.setVisibility(View.INVISIBLE);
                    layout_fire_ext6.setVisibility(View.INVISIBLE);
                    layout_fire_ext7.setVisibility(View.INVISIBLE);
                    layout_fire_ext8.setVisibility(View.INVISIBLE);
                    layout_fire_ext9.setVisibility(View.INVISIBLE);
                    layout_fire_ext10.setVisibility(View.INVISIBLE);
                    layout_fire_ext11.setVisibility(View.VISIBLE);
                    ImageThread.interrupted();
                    break;


            }
        }
    };



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = this.getArguments();
        Log.v(TAG,bundle+"");

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fire_ext,null);

        checkButton = view.findViewById(R.id.checkButton);

        checkButton.setOnClickListener(handler);

        fire_ext1 = view.findViewById(R.id.room600_hallWay01_Fire_ext);
        fire_ext2 = view.findViewById(R.id.room601_waitingRoom_Fire_ext);
        fire_ext3 = view.findViewById(R.id.room602_Fire_ext);
        fire_ext4 = view.findViewById(R.id.room603_Fire_ext);
        fire_ext5 = view.findViewById(R.id.room604_Fire_ext);
        fire_ext6 = view.findViewById(R.id.room605_Fire_ext);
        fire_ext7 = view.findViewById(R.id.room606_Fire_ext);
        fire_ext8 = view.findViewById(R.id.room607_Fire_ext);
        fire_ext9 = view.findViewById(R.id.room608_Fire_ext);
        fire_ext10 = view.findViewById(R.id.room609_Fire_ext);
        fire_ext11 = view.findViewById(R.id.restRoom610_Fire_ext);

        //이미지스위처 조작을 위해 imageSwitchers 안에 이미지스위처들 저장
        imageSwitchers[0] = fire_ext1;
        imageSwitchers[1] = fire_ext2;
        imageSwitchers[2] = fire_ext3;
        imageSwitchers[3] = fire_ext4;
        imageSwitchers[4] = fire_ext5;
        imageSwitchers[5] = fire_ext6;
        imageSwitchers[6] = fire_ext7;
        imageSwitchers[7] = fire_ext8;
        imageSwitchers[8] = fire_ext9;
        imageSwitchers[9] = fire_ext10;
        imageSwitchers[10] = fire_ext11;
        //이미지 스위처에 핸들러 달아줌
        for(int i = 0 ; i<11 ; i++){
            imageSwitchers[i].setOnClickListener(handler);
        }

        pb_600 = view.findViewById(R.id.pb_hallway_600);
        pb_610 = view.findViewById(R.id.pb_restRoom_610);
        pb_602 = view.findViewById(R.id.pb_602);
        pb_603 = view.findViewById(R.id.pb_603);
        pb_604 = view.findViewById(R.id.pb_604);
        pb_605 = view.findViewById(R.id.pb_605);
        pb_606 = view.findViewById(R.id.pb_606);
        pb_607 = view.findViewById(R.id.pb_607);
        pb_608 = view.findViewById(R.id.pb_608);
        pb_609 = view.findViewById(R.id.pb_609);
        pb_601 = view.findViewById(R.id.pb_waitingRoom_601);



        layout_fire_ext1 = view.findViewById(R.id.room600_hallway01_Layout);
        layout_fire_ext2 = view.findViewById(R.id.room601_waitingroom_Layout);
        layout_fire_ext3 = view.findViewById(R.id.room602_Layout);
        layout_fire_ext4 = view.findViewById(R.id.room603_Layout);
        layout_fire_ext5 = view.findViewById(R.id.room604_Layout);
        layout_fire_ext6 = view.findViewById(R.id.room605_Layout);
        layout_fire_ext7 = view.findViewById(R.id.room606_Layout);
        layout_fire_ext8 = view.findViewById(R.id.room607_Layout);
        layout_fire_ext9 = view.findViewById(R.id.room608_Layout);
        layout_fire_ext10 = view.findViewById(R.id.room609_Layout);
        layout_fire_ext11 = view.findViewById(R.id.restRoom610_Layout);
        //레이아웃 조작을 위해 linerLayouts 안에 레이아웃들 저장
        linearLayouts[0] = layout_fire_ext1;
        linearLayouts[1] = layout_fire_ext2;
        linearLayouts[2] = layout_fire_ext3;
        linearLayouts[3] = layout_fire_ext4;
        linearLayouts[4] = layout_fire_ext5;
        linearLayouts[5] = layout_fire_ext6 ;
        linearLayouts[6] = layout_fire_ext7;
        linearLayouts[7] = layout_fire_ext8;
        linearLayouts[8] = layout_fire_ext9;
        linearLayouts[9] = layout_fire_ext10;
        linearLayouts[10] = layout_fire_ext11;




        tv_startDate_600 = view.findViewById(R.id.tv_startDate_600_hallway01);
        tv_endDate_600 = view.findViewById(R.id.tv_endDate_600_hallway01);
        tv_startDate_601 = view.findViewById(R.id.tv_startDate_601_waiting);
        tv_endDate_601 = view.findViewById(R.id.tv_endDate_601_waiting);
        tv_startDate_602 = view.findViewById(R.id.tv_startDate_602);
        tv_endDate_602 = view.findViewById(R.id.tv_endDate_602);
        tv_startDate_603 = view.findViewById(R.id.tv_startDate_603);
        tv_endDate_603 = view.findViewById(R.id.tv_endDate_603);
        tv_startDate_604 = view.findViewById(R.id.tv_startDate_604);
        tv_endDate_604 = view.findViewById(R.id.tv_endDate_604);
        tv_startDate_605 = view.findViewById(R.id.tv_startDate_605);
        tv_endDate_605 = view.findViewById(R.id.tv_endDate_605);
        tv_startDate_606 = view.findViewById(R.id.tv_startDate_606);
        tv_endDate_606 = view.findViewById(R.id.tv_endDate_606);
        tv_startDate_607 = view.findViewById(R.id.tv_startDate_607);
        tv_endDate_607 = view.findViewById(R.id.tv_endDate_607);
        tv_startDate_608 = view.findViewById(R.id.tv_startDate_608);
        tv_endDate_608 = view.findViewById(R.id.tv_endDate_608);
        tv_startDate_609 = view.findViewById(R.id.tv_startDate_609);
        tv_endDate_609 = view.findViewById(R.id.tv_endDate_609);
        tv_startDate_610 = view.findViewById(R.id.tv_startDate_610_restRoom);
        tv_endDate_610 = view.findViewById(R.id.tv_endDate_610_restRoom);


        return view;
    }

    private void closeLayout(){
        layout_fire_ext1 = linearLayouts[0];
        layout_fire_ext2 = linearLayouts[1];
        layout_fire_ext3 = linearLayouts[2];
        layout_fire_ext4 = linearLayouts[3];
        layout_fire_ext5 = linearLayouts[4];
        layout_fire_ext6 = linearLayouts[5];
        layout_fire_ext7 = linearLayouts[6];
        layout_fire_ext8 = linearLayouts[7];
        layout_fire_ext9 = linearLayouts[8];
        layout_fire_ext10 = linearLayouts[9];
        layout_fire_ext11 = linearLayouts[10];
        for(int i = 0;i<linearLayouts.length;i++ ){

        }
    }


    //존재하는 소화기위치 표시하는 애니메이션
    private void startCheckFire_ext_Animation(){
        for(int i = 0; i<switcherList.size();i++){
            switcher = switcherList.get(i);
            switcher.setVisibility(View.VISIBLE);
            thread = new ImageThread();
            thread.start();
        }
        Log.v(TAG, "소화기 체크 애니메이션 시작");
    }
    private void stopCheckFire_ext_Animation(){
        running = false;
        try{
            thread.join();
        }catch(InterruptedException e){
            e.printStackTrace();
        }

        switcher.setVisibility(View.INVISIBLE);
        Log.v(TAG, "소화기 체크 애니메이션 멈춤");
    }
    class ImageThread extends Thread{
        int duration = 250;
        final int imageId[] = {R.drawable.pic_fire_ext, R.drawable.pic_fire_ext_red, R.drawable.pic_fire_ext_orange,R.drawable.pic_fire_ext_lime};
        int currentIndex = 0;

        public void run(){
            running = true;
            Log.v(TAG, "Image Thread 시작");
            while (running){
                synchronized (this){
                    threadHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            for(int i = 0; i<switcherList.size();i++){
                                switcher = switcherList.get(i);
                                switcher.setImageResource(imageId[currentIndex]);
                            }}
                    });
                    currentIndex++;
                    if(currentIndex == imageId.length){
                        currentIndex = 1;
                    }
                    try{
                        Thread.sleep(duration);
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        }
    }
    class Fire_ext_CheckTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... strings) {
            try {
                //서버 접속
                String loc = "6";
                String param = "loc=" + loc;

                URL url = new URL("http://192.168.0.35:9999/Android/locationFireEx.do?");
                conn = (HttpURLConnection)url.openConnection();
                conn.setFixedLengthStreamingMode(param.length());
                conn.setRequestProperty("Content-type","application/x-www-form-urlencoded");
                conn.setRequestMethod("POST");
                conn.setDoInput(true);
                conn.connect();
                OutputStream outs = conn.getOutputStream();
                outs.write(param.getBytes("UTF-8"));
                outs.flush();
                outs.close();
                Log.v(TAG, "서버 연결");

                if(conn.getResponseCode()!=HttpURLConnection.HTTP_OK){
                } else {
                    BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    String line;
                    StringBuffer buffer = new StringBuffer();
                    while ((line = reader.readLine())!=null){
                        buffer.append(line + "\n");
                    }
                    result = buffer.toString();
                    Log.v(TAG, "buffer result : " + line );
                    reader.close();
                }
                Log.v(TAG, "url : " + url );
            }catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Log.v(TAG, "result in onPostExecute(Fire_ext_Check) : " + result);

            try{
                JSONObject jsonObject = new JSONObject(result);
                if(jsonObject.equals(null)){
                    Toast.makeText(getContext(),"사용가능한 소화기가 존재하지 않습니다.",Toast.LENGTH_SHORT).show();
                }

                //현재 시간
                long now = System.currentTimeMillis();
                Date dateNow = new Date(now);
                Log.v(TAG, "dateNow : " + dateNow);
                //연,월,일을 따로 저장
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String today = sdf.format(dateNow);
                Log.v(TAG, "today : " + today);
                // 시간차이를 시간,분,초를 곱한 값으로 나누면 하루 단위가 나옴

                JSONArray jObj = jsonObject.getJSONArray("list");

                for(int i= 0 ; i < jObj.length();i++) {
                    try{
                        JSONObject fire_extObj= jObj.getJSONObject(i);
                        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
                        String location = fire_extObj.getString("location");
                        String issue = fire_extObj.getString("fire_ex_status");
                        String date = fire_extObj.getString("check_date");
                        String str_date = date.substring(0,11);
                        Log.v(TAG,"str_date : " + str_date);
                        Log.v(TAG, "fire_ex_status :" + issue);
                        Log.v(TAG, "date :" + date);
                        Date beginDate = sdf1.parse(date);
                        Date endDate = sdf1.parse(today);
                        long diff = endDate.getTime() - beginDate.getTime();
                        long diffDays = diff / (24 * 60 * 60 * 1000);
                        Calendar cal = new GregorianCalendar(Locale.KOREA);
                        cal.setTime(beginDate);
                        cal.add(Calendar.MONTH,1);
                        String checkDate = sdf.format(cal.getTime());
                        Log.v(TAG, "diff : " + diff);
                        Log.v(TAG, "diffDays : " + diffDays);
                        Log.v(TAG, "checkDate : " + checkDate);

                        switch (location) {
                            case "600":
                                if (issue.equals("1")) {
                                    switcherList.add(fire_ext1);
                                    Log.v(TAG, "600");
                                    tv_startDate_600.setText(str_date);
                                    tv_endDate_600.setText(checkDate);
                                    pb_600.setProgress(diffDays);

                                }else if(issue.equals("0")){
                                    tv_startDate_600.setText("소화기 없음");
                                    tv_endDate_600.setVisibility(View.INVISIBLE);
                                    pb_600.setVisibility(View.INVISIBLE);
                                }
                                break;
                            case "601":
                                if (issue.equals("1")) {
                                    switcherList.add(fire_ext2);
                                    Log.v(TAG, "601");
                                    tv_startDate_601.setText(str_date);
                                    tv_endDate_601.setText(checkDate);
                                    pb_601.setProgress(diffDays);
                                }else if(issue.equals("0")){
                                    tv_startDate_601.setText("소화기 없음");
                                    tv_endDate_601.setVisibility(View.INVISIBLE);
                                    pb_601.setVisibility(View.INVISIBLE);
                                }
                                break;
                            case "602":
                                if (issue.equals("1")) {
                                    switcherList.add(fire_ext3);
                                    Log.v(TAG, "602");
                                    tv_startDate_602.setText(str_date);
                                    tv_endDate_602.setText(checkDate);
                                    pb_602.setProgress(diffDays);
                                }else if(issue.equals("0")){
                                    tv_startDate_602.setText("소화기 없음");
                                    tv_endDate_602.setVisibility(View.INVISIBLE);
                                    pb_602.setVisibility(View.INVISIBLE);
                                }
                                break;
                            case "603":
                                if (issue.equals("1")) {
                                    switcherList.add(fire_ext4);
                                    Log.v(TAG, "603");
                                    tv_startDate_603.setText(str_date);
                                    tv_endDate_603.setText(checkDate);
                                    pb_603.setProgress(diffDays);
                                }else if(issue.equals("0")){
                                    tv_startDate_603.setText("소화기 없음");
                                    tv_endDate_603.setVisibility(View.INVISIBLE);
                                    pb_603.setVisibility(View.INVISIBLE);
                                }
                                break;
                            case "604":
                                if (issue.equals("1")) {
                                    switcherList.add(fire_ext5);
                                    Log.v(TAG, "604");
                                    tv_startDate_604.setText(str_date);
                                    tv_endDate_604.setText(checkDate);
                                    pb_604.setProgress(diffDays);
                                }else if(issue.equals("0")){
                                    tv_startDate_604.setText("소화기 없음");
                                    tv_endDate_604.setVisibility(View.INVISIBLE);
                                    pb_604.setVisibility(View.INVISIBLE);
                                }
                                break;
                            case "605":
                                if (issue.equals("1")) {
                                    switcherList.add(fire_ext6);
                                    Log.v(TAG, "605");
                                    tv_startDate_605.setText(str_date);
                                    tv_endDate_605.setText(checkDate);
                                    pb_605.setProgress(diffDays);
                                }else if(issue.equals("0")){
                                    tv_startDate_605.setText("소화기 없음");
                                    tv_endDate_605.setVisibility(View.INVISIBLE);
                                    pb_605.setVisibility(View.INVISIBLE);
                                }
                                break;
                            case "606":
                                if (issue.equals("1")) {
                                    switcherList.add(fire_ext7);
                                    Log.v(TAG, "606");
                                    tv_startDate_606.setText(str_date);
                                    tv_endDate_606.setText(checkDate);
                                    pb_606.setProgress(diffDays);
                                }else if(issue.equals("0")){
                                    tv_startDate_606.setText("소화기 없음");
                                    tv_endDate_606.setVisibility(View.INVISIBLE);
                                    pb_606.setVisibility(View.INVISIBLE);
                                }
                                break;
                            case "607":
                                if (issue.equals("1")) {
                                    switcherList.add(fire_ext8);
                                    Log.v(TAG, "607");
                                    tv_startDate_607.setText(str_date);
                                    tv_endDate_607.setText(checkDate);
                                    pb_607.setProgress(diffDays);
                                }else if(issue.equals("0")){
                                    tv_startDate_607.setText("소화기 없음");
                                    tv_endDate_607.setVisibility(View.INVISIBLE);
                                    pb_607.setVisibility(View.INVISIBLE);
                                }
                                break;
                            case "608":
                                if (issue.equals("1")) {
                                    switcherList.add(fire_ext9);
                                    Log.v(TAG, "608");
                                    tv_startDate_608.setText(str_date);
                                    tv_endDate_608.setText(checkDate);
                                    pb_608.setProgress(diffDays);
                                }else if(issue.equals("0")){
                                    tv_startDate_608.setText("소화기 없음");
                                    tv_endDate_608.setVisibility(View.INVISIBLE);
                                    pb_608.setVisibility(View.INVISIBLE);
                                }
                                break;
                            case "609":
                                if (issue.equals("1")) {
                                    switcherList.add(fire_ext10);
                                    Log.v(TAG, "609");
                                    tv_startDate_609.setText(str_date);
                                    tv_endDate_609.setText(checkDate);
                                    pb_609.setProgress(diffDays);
                                }else if(issue.equals("0")){
                                    tv_startDate_609.setText("소화기 없음");
                                    tv_endDate_609.setVisibility(View.INVISIBLE);
                                    pb_609.setVisibility(View.INVISIBLE);
                                }
                                break;
                            case "610":
                                if (issue.equals("1")) {
                                    switcherList.add(fire_ext11);
                                    Log.v(TAG, "610");
                                    tv_startDate_610.setText(str_date);
                                    tv_endDate_610.setText(checkDate);
                                    pb_610.setProgress(diffDays);
                                }else if(issue.equals("0")){
                                    tv_startDate_610.setText("소화기 없음");
                                    tv_endDate_610.setVisibility(View.INVISIBLE);
                                    pb_610.setVisibility(View.INVISIBLE);
                                }
                                break;
                        }
                    }catch (ParseException e){
                        e.printStackTrace();
                    }
                }
                Log.v(TAG, "switcherList size : "+switcherList.size() );
                Log.v(TAG, "switcherList : "+switcherList );

                for(int i= 0; i< switcherList.size();i++) {
                    switcher = switcherList.get(i);
                    Log.v(TAG, "switcher : "+ switcher );
                    switcher.setFactory(new ViewSwitcher.ViewFactory() {
                        @Override
                        public View makeView() {
                            ImageView imageView = new ImageView(getContext());

                            imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                            imageView.setLayoutParams(new ImageSwitcher.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

                            return imageView;
                        }
                    });
                }
                startCheckFire_ext_Animation();

            }catch (JSONException e){
                e.printStackTrace();
            }


        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
//        CheckDate_fire_ext checkDateFireExt = new CheckDate_fire_ext();
        Fire_ext_CheckTask fire_ext_checkTask = new Fire_ext_CheckTask();
        try
        {
//            if (checkDateFireExt.getStatus() == AsyncTask.Status.RUNNING )
//            {
//                checkDateFireExt.cancel(true);
//            }
            if(fire_ext_checkTask.getStatus() == AsyncTask.Status.RUNNING)
            {
                fire_ext_checkTask.cancel(true);
            }else{

            }
        }
        catch (Exception e)
        {
        }
    }
}
