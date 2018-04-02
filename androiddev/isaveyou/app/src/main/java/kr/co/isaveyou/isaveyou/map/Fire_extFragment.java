package kr.co.isaveyou.isaveyou.map;


import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
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

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
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
    ArrayList<String > roomNumList = new ArrayList<>();

    String strDate;


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
                    stopCheckFire_ext_Animation();

                    checkDate_fire_ext checkDate_fire_ext1 = new checkDate_fire_ext();
                    checkDate_fire_ext1.execute();


                    ImageThread.interrupted();
                    break;
                case R.id.room601_waitingRoom_Fire_ext:
                    Log.v(TAG, "room601_waitingRoom_Fire_ext");
                    layout_fire_ext2.setVisibility(View.VISIBLE);
                    stopCheckFire_ext_Animation();

                    checkDate_fire_ext checkDate_fire_ext2 = new checkDate_fire_ext();
                    checkDate_fire_ext2.execute();


                    ImageThread.interrupted();
                    break;
                case R.id.room602_Fire_ext:
                    Log.v(TAG, "room602_Fire_ext");
                    layout_fire_ext3.setVisibility(View.VISIBLE);
                    stopCheckFire_ext_Animation();

                    checkDate_fire_ext checkDate_fire_ext3 = new checkDate_fire_ext();
                    checkDate_fire_ext3.execute();


                    ImageThread.interrupted();
                    break;
                case R.id.room603_Fire_ext:
                    Log.v(TAG, "room603_Fire_ext 눌림");
                    layout_fire_ext4.setVisibility(View.VISIBLE);
                    stopCheckFire_ext_Animation();

                    checkDate_fire_ext checkDate_fire_ext4 = new checkDate_fire_ext();
                    checkDate_fire_ext4.execute();


                    ImageThread.interrupted();
                    break;
                case R.id.room604_Fire_ext:
                    Log.v(TAG, "room604_Fire_ext 눌림");
                    layout_fire_ext5.setVisibility(View.VISIBLE);
                    stopCheckFire_ext_Animation();

                    checkDate_fire_ext checkDate_fire_ext5 = new checkDate_fire_ext();
                    checkDate_fire_ext5.execute();


                    ImageThread.interrupted();
                    break;
                case R.id.room605_Fire_ext:
                    Log.v(TAG, "room605_Fire_ext");
                    layout_fire_ext6.setVisibility(View.VISIBLE);
                    stopCheckFire_ext_Animation();

                    checkDate_fire_ext checkDate_fire_ext6 = new checkDate_fire_ext();
                    checkDate_fire_ext6.execute();


                    ImageThread.interrupted();
                    break;
                case R.id.room606_Fire_ext:
                    Log.v(TAG, "room606_Fire_ext");
                    layout_fire_ext7.setVisibility(View.VISIBLE);
                    stopCheckFire_ext_Animation();

                    checkDate_fire_ext checkDate_fire_ext7 = new checkDate_fire_ext();
                    checkDate_fire_ext7.execute();


                    ImageThread.interrupted();
                    break;
                case R.id.room607_Fire_ext:
                    Log.v(TAG, "room607_Fire_ext 눌림");
                    layout_fire_ext8.setVisibility(View.VISIBLE);
                    stopCheckFire_ext_Animation();

                    checkDate_fire_ext checkDate_fire_ext8 = new checkDate_fire_ext();
                    checkDate_fire_ext8.execute();


                    ImageThread.interrupted();
                    break;
                case R.id.room608_Fire_ext:
                    Log.v(TAG, "room608_Fire_ext 눌림");
                    layout_fire_ext9.setVisibility(View.VISIBLE);
                    stopCheckFire_ext_Animation();

                    checkDate_fire_ext checkDate_fire_ext9 = new checkDate_fire_ext();
                    checkDate_fire_ext9.execute();


                    ImageThread.interrupted();
                    break;
                case R.id.room609_Fire_ext:
                    Log.v(TAG, "room609_Fire_ext 눌림");
                    layout_fire_ext10.setVisibility(View.VISIBLE);
                    stopCheckFire_ext_Animation();

                    checkDate_fire_ext checkDate_fire_ext10 = new checkDate_fire_ext();
                    checkDate_fire_ext10.execute();


                    ImageThread.interrupted();
                    break;
                case R.id.restRoom610_Fire_ext:
                    Log.v(TAG, "restRoom610_Fire_ext 눌림");
                    layout_fire_ext11.setVisibility(View.VISIBLE);
                    stopCheckFire_ext_Animation();

                    checkDate_fire_ext checkDate_fire_ext11 = new checkDate_fire_ext();
                    checkDate_fire_ext11.execute();

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
//        if(bundle != null) {
//            place_fire_ext = bundle.getString("place");
//        }
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

        fire_ext1.setOnClickListener(handler);
        fire_ext2.setOnClickListener(handler);
        fire_ext3.setOnClickListener(handler);
        fire_ext4.setOnClickListener(handler);
        fire_ext5.setOnClickListener(handler);
        fire_ext6.setOnClickListener(handler);
        fire_ext7.setOnClickListener(handler);
        fire_ext8.setOnClickListener(handler);
        fire_ext9.setOnClickListener(handler);
        fire_ext10.setOnClickListener(handler);
        fire_ext11.setOnClickListener(handler);




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



//        checkDate_fire_ext checkDate_fire_ext = new checkDate_fire_ext();
//        checkDate_fire_ext.execute();


        return view;
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

                URL url = new URL("http://192.168.0.35:9999/locationFireEx.do");
                conn = (HttpURLConnection)url.openConnection();
                conn.setRequestProperty("Content-type","application/xml");
                conn.setRequestMethod("GET");
                conn.setDoInput(true);
                conn.connect();

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

                Iterator key = jsonObject.keys();

                while (key.hasNext()){
                    String roomNum= key.next().toString();
                    Log.v(TAG,"roonmNum" + roomNum);
                    roomNumList.add(roomNum);



                }
                Log.v(TAG, "roomNumListSize : " + roomNumList.size());

                for(int i= 0 ; i<roomNumList.size();i++) {
                    String roomNum = roomNumList.get(i);
                    String event = jsonObject.getString(roomNumList.get(i));
                    Log.v(TAG, "event :" + event);


                    switch (roomNum) {
                        case "600":
                            if (event.equals("1")) {
                                switcherList.add(fire_ext1);
                                Log.v(TAG, "600");
                            }else if(event.equals("0")){
                                Toast.makeText(getContext(),"소화기가 해당 위치에 존재하지 않습니다.",Toast.LENGTH_SHORT).show();
                            }
                            break;
                        case "601":
                            if (event.equals("1")) {
                                switcherList.add(fire_ext2);
                                Log.v(TAG, "601");
                            }else if(event.equals("0")){
                                Toast.makeText(getContext(),"소화기가 해당 위치에 존재하지 않습니다.",Toast.LENGTH_SHORT).show();
                            }
                            break;
                        case "602":
                            if (event.equals("1")) {
                                switcherList.add(fire_ext3);
                                Log.v(TAG, "602");
                            }else if(event.equals("0")){
                                Toast.makeText(getContext(),"소화기가 해당 위치에 존재하지 않습니다.",Toast.LENGTH_SHORT).show();
                            }
                            break;
                        case "603":
                            if (event.equals("1")) {
                                switcherList.add(fire_ext4);
                                Log.v(TAG, "603");
                            }else if(event.equals("0")){
                                Toast.makeText(getContext(),"소화기가 해당 위치에 존재하지 않습니다.",Toast.LENGTH_SHORT).show();
                            }
                            break;
                        case "604":
                            if (event.equals("1")) {
                                switcherList.add(fire_ext5);
                                Log.v(TAG, "604");
                            }else if(event.equals("0")){
                                Toast.makeText(getContext(),"소화기가 해당 위치에 존재하지 않습니다.",Toast.LENGTH_SHORT).show();
                            }
                            break;
                        case "605":
                            if (event.equals("1")) {
                                switcherList.add(fire_ext6);
                                Log.v(TAG, "605");
                            }else if(event.equals("0")){
                                Toast.makeText(getContext(),"소화기가 해당 위치에 존재하지 않습니다.",Toast.LENGTH_SHORT).show();
                            }
                            break;
                        case "606":
                            if (event.equals("1")) {
                                switcherList.add(fire_ext7);
                                Log.v(TAG, "606");
                            }else if(event.equals("0")){
                                Toast.makeText(getContext(),"소화기가 해당 위치에 존재하지 않습니다.",Toast.LENGTH_SHORT).show();
                            }
                            break;
                        case "607":
                            if (event.equals("1")) {
                                switcherList.add(fire_ext8);
                                Log.v(TAG, "607");
                            }else if(event.equals("0")){
                                Toast.makeText(getContext(),"소화기가 해당 위치에 존재하지 않습니다.",Toast.LENGTH_SHORT).show();
                            }
                            break;
                        case "608":
                            if (event.equals("1")) {
                                switcherList.add(fire_ext9);
                                Log.v(TAG, "608");
                            }else if(event.equals("0")){
                                Toast.makeText(getContext(),"소화기가 해당 위치에 존재하지 않습니다.",Toast.LENGTH_SHORT).show();
                            }
                            break;
                        case "609":
                            if (event.equals("1")) {
                                switcherList.add(fire_ext10);
                                Log.v(TAG, "609");
                            }else if(event.equals("0")){
                                Toast.makeText(getContext(),"소화기가 해당 위치에 존재하지 않습니다.",Toast.LENGTH_SHORT).show();
                            }
                            break;
                        case "610":
                            if (event.equals("1")) {
                                switcherList.add(fire_ext11);
                                Log.v(TAG, "610");
                            }else if(event.equals("0")){
                                Toast.makeText(getContext(),"소화기가 해당 위치에 존재하지 않습니다.",Toast.LENGTH_SHORT).show();
                            }
                            break;
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
    class checkDate_fire_ext extends AsyncTask<String, Void, String>{
        @Override
        protected String doInBackground(String... strings) {
            try{
                URL url = new URL("http://192.168.0.35:9999/locationFireExDate.do");
                conn = (HttpURLConnection)url.openConnection();
                conn.setRequestProperty("Content-type","application/xml");
                conn.setRequestMethod("GET");
                conn.setDoInput(true);
                conn.connect();

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
            Log.v(TAG, "result in onPostExecute(checkDate_fire_ext) : " + result);
            try {
                JSONObject jsonObject = new JSONObject(result);
                if (jsonObject.equals(null)) {
                    Toast.makeText(getContext(), "사용가능한 소화기가 존재하지 않습니다.", Toast.LENGTH_SHORT).show();
                }
                Iterator key = jsonObject.keys();
                while (key.hasNext()) {
                    String roomNum = key.next().toString();
                    Log.v(TAG, "roonmNum" + roomNum);
                    roomNumList.add(roomNum);
                }
                // 오늘에 날짜를 세팅 해준다.
                long now = System.currentTimeMillis();
                Date dateNow = new Date(now);
                Log.v(TAG, "dateNow : " + dateNow);
                //연,월,일을 따로 저장
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String today = sdf.format(dateNow);
                Log.v(TAG, "today : " + today);
                // 시간차이를 시간,분,초를 곱한 값으로 나누면 하루 단위가 나옴

                for (int i = 0; i < roomNumList.size(); i++) {
                    try {
                        String roomNum = roomNumList.get(i);
                        String date = jsonObject.getString(roomNumList.get(i));
                        Log.v(TAG, "date :" + date);
                        Date beginDate = sdf.parse(date);
                        Date endDate = sdf.parse(today);
                        long diff = endDate.getTime() - beginDate.getTime();
                        long diffDays = diff / (24 * 60 * 60 * 1000);
                        Calendar cal = new GregorianCalendar(Locale.KOREA);
                        cal.setTime(beginDate);
                        cal.add(Calendar.MONTH,1);
                        String checkDate = sdf.format(cal.getTime());
                        Log.v(TAG, "diff : " + diff);
                        Log.v(TAG, "diffDays : " + diffDays);
                        Log.v(TAG, "checkDate : " + checkDate);
                        switch (roomNum) {
                            case "600":
                                Log.v(TAG, "600");
                                tv_startDate_600.setText(date);
                                tv_endDate_600.setText(checkDate);
                                pb_600.setProgress(diffDays);
                            case "601":
                                Log.v(TAG, "601");
                                tv_startDate_601.setText(date);
                                tv_endDate_601.setText(checkDate);
                                pb_601.setProgress(diffDays);

                                break;
                            case "602":
                                Log.v(TAG, "602");
                                tv_startDate_602.setText(date);
                                tv_endDate_602.setText(checkDate);
                                pb_602.setProgress(diffDays);
                                break;
                            case "603":
                                Log.v(TAG, "603");
                                tv_startDate_603.setText(date);
                                tv_endDate_603.setText(checkDate);
                                pb_603.setProgress(diffDays);
                                break;
                            case "604":
                                Log.v(TAG, "604");
                                tv_startDate_604.setText(date);
                                tv_endDate_604.setText(checkDate);
                                pb_604.setProgress(diffDays);

                                break;
                            case "605":
                                Log.v(TAG, "605");
                                tv_startDate_605.setText(date);
                                tv_endDate_605.setText(checkDate);
                                pb_605.setProgress(diffDays);
                                break;
                            case "606":
                                Log.v(TAG, "606");
                                tv_startDate_606.setText(date);
                                tv_endDate_606.setText(checkDate);
                                pb_606.setProgress(diffDays);

                                break;
                            case "607":
                                Log.v(TAG, "607");
                                tv_startDate_607.setText(date);
                                tv_endDate_607.setText(checkDate);
                                pb_607.setProgress(diffDays);

                                break;
                            case "608":
                                Log.v(TAG, "608");
                                tv_startDate_608.setText(date);
                                tv_endDate_608.setText(checkDate);
                                pb_608.setProgress(diffDays);

                                break;
                            case "609":
                                Log.v(TAG, "609");
                                tv_startDate_609.setText(date);
                                tv_endDate_609.setText(checkDate);
                                pb_609.setProgress(diffDays);

                                break;
                            case "610":
                                Log.v(TAG, "610");
                                tv_startDate_610.setText(date);
                                tv_endDate_610.setText(checkDate);
                                pb_610.setProgress(diffDays);
                                break;
                        }
                    } catch (ParseException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }catch (JSONException e) {
                e.printStackTrace();
            }
        }

        public String doDateAdd(String start) {
            try {
                Calendar cal = new GregorianCalendar(Locale.KOREA);
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

                Date date = sdf.parse(start);
                cal.setTime(date);
                cal.add(Calendar.MONTH, 1); // 한달을 더한다.

                String strDate = sdf.format(cal.getTime());
                Log.v(TAG, "strDate" + strDate);
            }catch(ParseException e){
                e.printStackTrace();
            }
            return strDate;
        }


    }}
