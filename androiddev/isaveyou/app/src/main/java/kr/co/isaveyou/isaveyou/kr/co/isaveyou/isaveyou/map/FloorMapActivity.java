package kr.co.isaveyou.isaveyou.kr.co.isaveyou.isaveyou.map;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import kr.co.isaveyou.isaveyou.R;
import kr.co.isaveyou.isaveyou.kr.co.isaveyou.isaveyou.main.MonitoringFragment;

public class FloorMapActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_floor_map);
        FragmentManager fragmentManager = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        android.support.v4.app.Fragment fragment_fire_ext = new Fire_extFragment();
        fragmentTransaction.add(R.id.frie_ext_map_layout,fragment_fire_ext);
        fragmentTransaction.commit();


    }

    @Override
    protected void onStop() {
        super.onStop();
        finish();
    }
}
