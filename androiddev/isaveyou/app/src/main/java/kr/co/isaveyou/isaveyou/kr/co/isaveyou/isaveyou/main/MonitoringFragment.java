package kr.co.isaveyou.isaveyou.kr.co.isaveyou.isaveyou.main;


import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;

import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import kr.co.isaveyou.isaveyou.R;

//스트리밍을 위한 Fragment
public class MonitoringFragment extends android.support.v4.app.Fragment {
    private static final String TAG = "MonitoringFragment";
    VideoView videoView_monitoring;
    TextView tv_monitoring, tv_time, tv_text;
    Button btn_stop, btn_start;
    SeekBar sk_monitoring;
    String streamingServer_access, streamingServer_url;
    HttpURLConnection conn;
    Handler updateHandler = new Handler();

    String result;
    View.OnClickListener handler = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_start:
                    try {
                        Toast.makeText(getContext(),"로딩 중, 잠시만 기다려주세요.",Toast.LENGTH_SHORT).show();
                        String url = streamingServer_url;
//                        try{
//                            Uri uri = Uri.parse(url);
//
//                            videoView_monitoring.setVideoURI(uri);}catch (Exception e){
//                            Toast.makeText(getContext(),"Error", Toast.LENGTH_SHORT).show();
//                        }
//                        //준비하는 과정
//                        videoView_monitoring.requestFocus();
//
//                        videoView_monitoring.setOnInfoListener(new MediaPlayer.OnInfoListener() {
//                            @Override
//                            public boolean onInfo(MediaPlayer mp, int what, int extra) {
//                                switch (what) {
//                                    case MediaPlayer.MEDIA_INFO_BUFFERING_START:
//                                        Toast.makeText(getContext(), "Buffering", Toast.LENGTH_SHORT).show();
//                                        break;
//                                    case MediaPlayer.MEDIA_INFO_BUFFERING_END:
//                                        Toast.makeText(getContext(), "Buffering finished\n Resume Playing", Toast.LENGTH_SHORT).show();
//                                        videoView_monitoring.start();
//                                        break;
//                                }
//
//                                return false;
//                            }
//                        });
//
//                        videoView_monitoring.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
//                            @Override
//                            public void onPrepared(MediaPlayer mp) {
//                                long finalTime = videoView_monitoring.getDuration();
//                                tv_time.setText(String.format("%d:%d", TimeUnit.MILLISECONDS.toMinutes((long) finalTime), TimeUnit.MILLISECONDS.toSeconds((long) finalTime), TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long) finalTime))));
//                                sk_monitoring.setMax((int) finalTime);
//                                sk_monitoring.setProgress(0);
//                                updateHandler.postDelayed(updateVideoTime, 100);
//                                Toast.makeText(getContext(), "Playing Video", Toast.LENGTH_SHORT).show();
//                                videoView_monitoring.start();
//                            }
//                        });



                        Log.v(TAG,"영상 재생 시작");
                        Log.v(TAG,"재생 버튼 눌림");


                    }catch (Exception e) {
                        e.printStackTrace();
                    }
//                case R.id.btn_stop:
//                    //영상 정지 버튼을 눌렀을 때, 서버에 신호를 보내어 Streaming을 종료
//                    FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
//                    fragmentManager.beginTransaction().remove(MonitoringFragment.this).commit();
//                    Log.v(TAG,"정지버튼눌림");
//                    StopTask stopTask = new StopTask();
//                    stopTask.execute();
//
//                    break;
            }
        }
    };

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = this.getArguments();
        Log.v(TAG,bundle+"");
        if(bundle != null) {
            streamingServer_access = bundle.getString("streamingServer_access");
            streamingServer_url = bundle.getString("streamingServer_url");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_monitoring,null);
        tv_monitoring = (TextView)view.findViewById(R.id.tv_monitoring);
        tv_text = (TextView)view.findViewById(R.id.tv_text);
//        sk_monitoring = (SeekBar) view.findViewById(R.id.sk_monitoring);
        btn_start = view.findViewById(R.id.btn_start);
        btn_stop = view.findViewById(R.id.btn_stop);
        sk_monitoring.bringToFront();
        tv_monitoring.bringToFront();
        tv_text.bringToFront();
        btn_start.bringToFront();
        btn_stop.bringToFront();



        btn_stop.setOnClickListener(handler);
        btn_stop.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()){
                    case MotionEvent.ACTION_UP:
                        v.setBackgroundResource(R.drawable.mybutton);
                        break;
                    case MotionEvent.ACTION_CANCEL:
                        v.setBackgroundResource(R.drawable.mybutton);
                        break;
                    case MotionEvent.ACTION_DOWN:
                        v.setBackgroundResource(R.drawable.mybuttonpressed);
                }
                return false;
            }
        });

        btn_start.setOnClickListener(handler);
        btn_start.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()){
                    case MotionEvent.ACTION_UP:
                        v.setBackgroundResource(R.drawable.mybutton);
                        break;
                    case MotionEvent.ACTION_CANCEL:
                        v.setBackgroundResource(R.drawable.mybutton);
                        break;
                    case MotionEvent.ACTION_DOWN:
                        v.setBackgroundResource(R.drawable.mybuttonpressed);
                }

                return false;
            }
        });


//        tv_time = view.findViewById(R.id.tv_time);

        Log.v(TAG,"영상 준비 작업 시작");
        Log.v(TAG, getArguments()+"");

        Log.v(TAG, "bundle 값 : streamingSever_access :"+ streamingServer_access + ", streamingServer_url :" + streamingServer_url);

//        videoView_monitoring = (VideoView)view.findViewById(R.id.videoView_monitoring);

        StartTask starttask = new StartTask();
        starttask.execute();


        return view;
    }


//    private Runnable updateVideoTime = new Runnable() {
//        @Override
//        public void run() {
//            long currentPosition = videoView_monitoring.getCurrentPosition();
//            sk_monitoring.setProgress((int)currentPosition);
//            updateHandler.postDelayed(this,100);
//        }
//    };

    class StopTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... strings) {
            try {
                //서버 접속

                URL url = new URL("http://192.168.0.13:5001/stream/0/");
                conn = (HttpURLConnection)url.openConnection();
                conn.setRequestProperty("Content-type","application/xml");
                conn.setRequestMethod("GET");
                conn.setDoInput(true);
                conn.connect();


                Log.v(TAG, "url : " + url );
            }catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {

            Log.v(TAG, "전달완료");

            super.onPostExecute(s);
        }
    }

    class StartTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... strings) {

            try {
                //서버 접속

                URL url = new URL(streamingServer_access);
                conn = (HttpURLConnection)url.openConnection();
                conn.setRequestProperty("Content-type","application/xml");
                conn.setRequestMethod("GET");
                conn.setDoInput(true);
                conn.connect();

//                OutputStream outs = conn.getOutputStream();
//                outs.write(streamingServer_access.getBytes("UTF-8"));
//                outs.flush();
//                outs.close();


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

            Log.v(TAG, "서버access 완료");
            Log.v(TAG, "result : " + result);

            super.onPostExecute(s);
        }
    }
}
