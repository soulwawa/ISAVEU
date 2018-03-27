package kr.co.isaveyou.isaveyou.kr.co.isaveyou.isaveyou.map;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import kr.co.isaveyou.isaveyou.R;
import kr.co.isaveyou.isaveyou.kr.co.isaveyou.isaveyou.main.MonitoringFragment;

public class FloorMapActivity extends AppCompatActivity {
    private static final String TAG = "FloorMapActivity";
    String event;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_floor_map);
        Intent intent = getIntent();
        event = intent.getStringExtra("event");
        Log.v(TAG, "event" +event);
        if(event.equals("1")){
            FragmentManager fragmentManager = getSupportFragmentManager();
            android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            android.support.v4.app.Fragment fragment_fire_ext = new Fire_extFragment();
            fragmentTransaction.add(R.id.fire_ext_map_layout,fragment_fire_ext);
            fragmentTransaction.commit();
        }else if(intent.equals("0")){
            FragmentManager fragmentManager = getSupportFragmentManager();
            android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            android.support.v4.app.Fragment fragment_disaster = new DisasterFragment();
            fragmentTransaction.add(R.id.fire_ext_map_layout,fragment_disaster);
            fragmentTransaction.commit();
        }else if(intent.equals("2")){

        }



    }

    @Override
    protected void onStop() {
        super.onStop();
        finish();
    }
}
