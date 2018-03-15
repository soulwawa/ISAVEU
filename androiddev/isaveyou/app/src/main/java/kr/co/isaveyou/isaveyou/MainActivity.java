package kr.co.isaveyou.isaveyou;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.google.firebase.iid.FirebaseInstanceId;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    TextView tvId;
    String strId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvId = findViewById(R.id.tvId);

        Intent intent = getIntent();
        strId = intent.getStringExtra("사번");


        tvId.setText(strId);
        Log.v(TAG, "사번 : " + strId);


        Log.v(TAG, intent.getStringExtra("title") + "");
        Log.v(TAG, intent.getStringExtra("content") + "");

        //화면 꺼짐 방지 기능
//        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON
//                | WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD
//                | WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON
//                | WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED);
    }





}
