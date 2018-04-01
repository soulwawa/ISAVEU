package kr.co.isaveyou.isaveyou.voice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import kr.co.isaveyou.isaveyou.R;

public class VoiceActivity extends AppCompatActivity {
    private static final String TAG = "VoiceActivity";
    private static final int RESULT_SPEECH = 1; //REQUEST_CODE로 쓰임
    private Intent i;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voice);
    }
}
