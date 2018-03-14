package kr.co.isaveyou.isaveyou;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

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
    }
}
