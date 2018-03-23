package kr.co.isaveyou.isaveyou;


import android.media.MediaPlayer;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import java.io.BufferedInputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

//스트리밍을 위한 Fragment
public class MonitoringFragment extends android.support.v4.app.Fragment {
    private static final String TAG = "MonitoringFragment";
    VideoView videoView_monitoring;
    TextView tv_monitoring;
    Button btn_stop, btn_start;
    String streamingServer_access, streamingServer_url;
    View.OnClickListener handler = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_start:
                    try {

//                        URLConnection conn = (HttpURLConnection)url.openConnection();
//                        conn.setDoInput(false);
//                        conn.connect();

                        MediaController mediaController = new MediaController(getContext());

                        videoView_monitoring.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                            @Override
                            public void onPrepared(MediaPlayer mp) {
                                Log.v(TAG,"영상 준비 완료");
                                Toast.makeText(getContext(),"영상이 준비되었습니다.",Toast.LENGTH_SHORT).show();
                            }
                        });

                        videoView_monitoring.setMediaController(mediaController);
                        videoView_monitoring.setVideoURI(Uri.parse(streamingServer_url));
                        videoView_monitoring.requestFocus();


                        videoView_monitoring.start();
                        Log.v(TAG,"영상 재생 시작");

//                        Log.v(TAG, "url : " + url );
                    }catch (Exception e) {
                        e.printStackTrace();
                    }
                case R.id.btn_stop:
                    FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                    fragmentManager.beginTransaction().remove(MonitoringFragment.this).commit();
                    Log.v(TAG,"정지버튼눌림");
                    StopTask stopTask = new StopTask();
                    stopTask.execute();
                    if(fragmentManager.getBackStackEntryCount()>0){
                        fragmentManager.popBackStack();
                    }else {
                    }
                    break;
            }
        }
    };

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_monitoring,null);
        tv_monitoring = (TextView)view.findViewById(R.id.tv_monitoring);
        btn_stop = view.findViewById(R.id.btn_stop);
        btn_stop.setOnClickListener(handler);
        btn_start = view.findViewById(R.id.btn_start);
        btn_start.setOnClickListener(handler);


        Log.v(TAG,"영상 준비");
        Bundle bundle = getArguments();
        streamingServer_access = bundle.getString("streamingServer_access","");
        streamingServer_url = bundle.getString("steramingServer_url","");

        Log.v(TAG, "bundle 값, streamingSever_access :"+ streamingServer_access + ", streamingServer_url :" + streamingServer_url);

        videoView_monitoring = (VideoView)view.findViewById(R.id.videoView_monitoring);
//        MediaController mediaController = new MediaController(getContext());
//
//        videoView_monitoring.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
//            @Override
//            public void onPrepared(MediaPlayer mp) {
//                Log.v(TAG,"영상 준비 완료");
//                Toast.makeText(getContext(),"영상이 준비되었습니다.",Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        videoView_monitoring.requestFocus();
//
//
//        videoView_monitoring.start();
        Log.v(TAG,"영상 재생 시작");
        return view;
    }
    class StopTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... strings) {
            try {
                URL url = new URL(streamingServer_access);
                URLConnection conn = (HttpURLConnection)url.openConnection();
                conn.setDoInput(false);
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
}
