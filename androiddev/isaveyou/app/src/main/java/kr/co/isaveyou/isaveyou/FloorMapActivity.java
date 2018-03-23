package kr.co.isaveyou.isaveyou;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class FloorMapActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_floor_map);


    }

    @Override
    protected void onStop() {
        super.onStop();
        finish();
    }
}
