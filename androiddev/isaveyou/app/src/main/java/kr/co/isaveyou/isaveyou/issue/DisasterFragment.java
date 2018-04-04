package kr.co.isaveyou.isaveyou.issue;


import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewSwitcher;


import com.google.gson.JsonParser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import kr.co.isaveyou.isaveyou.R;


public class DisasterFragment extends android.support.v4.app.Fragment {
    private static final String TAG = "DisasterFragment";
    String place,result;
    ImageSwitcher is_601,is_602,is_603,is_604,is_606,is_607,is_608,is_609,is_610,is_600,is_605;
    ImageSwitcher switcher;
    ArrayList<ImageSwitcher> switcherList = new ArrayList();
    Thread thread;
    boolean running;
    Handler threadHandler = new Handler();
    HttpURLConnection conn;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_disaster,null);
        is_601 = (ImageSwitcher) view.findViewById(R.id.is_waitingRoom_601);
        is_604 = (ImageSwitcher)view.findViewById(R.id.is_604);
        is_603 = (ImageSwitcher)view.findViewById(R.id.is_603);
        is_602 = (ImageSwitcher)view.findViewById(R.id.is_602);
        is_606 = (ImageSwitcher)view.findViewById(R.id.is_606);
        is_607 = (ImageSwitcher)view.findViewById(R.id.is_607);
        is_608 = (ImageSwitcher)view.findViewById(R.id.is_608);
        is_609 = (ImageSwitcher)view.findViewById(R.id.is_609);
        is_600 = (ImageSwitcher)view.findViewById(R.id.is_600);
        is_610 = (ImageSwitcher)view.findViewById(R.id.is_restRoom_610);



        CheckDisasterTask checkDisasterTask = new CheckDisasterTask();
        checkDisasterTask.execute();

        Toast.makeText(getContext(),"가장 최근 상황 입니다.",Toast.LENGTH_SHORT).show();


        return view;
    }
    private void startCheckDisaster_Animation(){
        for(int i = 0; i<switcherList.size();i++){
            switcher = switcherList.get(i);
            switcher.setVisibility(View.VISIBLE);

            thread = new ImageThread();
            thread.start();
        }
        Log.v(TAG, "재난 애니메이션 시작");
    }
    class ImageThread extends Thread{
        int duration = 250;
        final int imageId[] = {R.drawable.ani_flame_1, R.drawable.ani_flame_2, R.drawable.ani_flame_3,R.drawable.ani_flame_4};
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
    class CheckDisasterTask extends AsyncTask<String,Void,String>{
        @Override
        protected String doInBackground(String... strings) {
            try {
                String loc = "6";
                String param = "loc=" + loc;

                URL url = new URL("http://192.168.0.35:9999/Android/DisasterCheck.do?");
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
            }catch (Exception e){
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            try {
                JSONObject jsonObject = new JSONObject(result);
                Log.v(TAG, "result : " + jsonObject);

                JSONArray jObj = jsonObject.getJSONArray("list");
                Log.v(TAG, "jObj : " + jObj);
                for (int i = 0; i < jObj.length(); i++) {
                    JSONObject disasterObj = jObj.getJSONObject(i);
                    String location = disasterObj.getString("location");
                    Log.v(TAG,"location : " +location);
                    String issue = disasterObj.getString("issue");
                    Log.v(TAG,"issue: " + issue);
                    switch (location) {
                        case "600":
                            if (issue.equals("1")) {
                                switcherList.add(is_600);
                            }
                            Log.v(TAG, "600");
                            break;
                        case "601":
                            if (issue.equals("1")) {
                                switcherList.add(is_601);
                            }
                            Log.v(TAG, "601");
                            break;
                        case "602":
                            if (issue.equals("1")) {
                                switcherList.add(is_602);
                            }
                            Log.v(TAG, "602");
                            break;
                        case "603":
                            if (issue.equals("1")) {
                                switcherList.add(is_603);
                            }
                            Log.v(TAG, "603");
                            break;
                        case "604":
                            if (issue.equals("1")) {
                                switcherList.add(is_604);
                            }
                            Log.v(TAG, "604");
                            break;
                        case "605":
                            if (issue.equals("1")) {
                                switcherList.add(is_605);
                            }
                            Log.v(TAG, "605");
                            break;
                        case "606":
                            if (issue.equals("1")) {
                                switcherList.add(is_606);
                            }
                            Log.v(TAG, "606");
                            break;
                        case "607":
                            if (issue.equals("1")) {
                                switcherList.add(is_607);
                            }
                            Log.v(TAG, "607");
                            break;
                        case "608":
                            if (issue.equals("1")) {
                                switcherList.add(is_608);
                            }
                            Log.v(TAG, "608");
                            break;
                        case "609":
                            if (issue.equals("1")) {
                                switcherList.add(is_609);
                            }
                            Log.v(TAG, "609");
                            break;
                        case "610":
                            if (issue.equals("1")) {
                                switcherList.add(is_610);
                            }
                            Log.v(TAG, "610");
                            break;

                    }

                }
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
                startCheckDisaster_Animation();
            }catch(JSONException e){
                e.printStackTrace();
            }

        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        CheckDisasterTask checkDisasterTask = new CheckDisasterTask();
        try
        {
            if (checkDisasterTask.getStatus() == AsyncTask.Status.RUNNING)
            {
                checkDisasterTask.cancel(true);
            }
            else
            {
            }
        }
        catch (Exception e)
        {
        }


    }
}
