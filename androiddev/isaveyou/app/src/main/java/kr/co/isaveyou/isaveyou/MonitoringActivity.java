package kr.co.isaveyou.isaveyou;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import java.net.URI;
import java.net.URL;

public class MonitoringActivity extends AppCompatActivity {
    VideoView videoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monitoring);
        Intent intent = getIntent();
        videoView = (VideoView)findViewById(R.id.videoView_Monitoring);

        videoView.setVideoPath("rtsp ip");

        final MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        videoView.start();
    }

    class MonitoringTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... strings) {

            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
        }
    }
}
