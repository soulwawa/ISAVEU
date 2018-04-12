package kr.co.isaveyou.isaveyou.issue;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import kr.co.isaveyou.isaveyou.R;

public class FloorMapActivity extends AppCompatActivity {
    private static final String TAG = "FloorMapActivity";
    String event, eventCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_floor_map);
        Intent intent = getIntent();
        eventCheck = intent.getDataString();
        String [] sArray = eventCheck.split("/");

        event = sArray[0];

        Log.v(TAG, "event : " + event);
//      Notification에서 누른 메뉴 값을 바탕으로 해당 Fragment 실행
        if(event.equals("1")){
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.popBackStack();
            android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            android.support.v4.app.Fragment fragment_fire_ext = new Fire_extFragment();
            fragmentTransaction.replace(R.id.fire_ext_map_layout,fragment_fire_ext);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
            Log.v(TAG, "event-1 : " + event);
        }else if(event.equals("0")){
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.popBackStack();
            android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            android.support.v4.app.Fragment fragment_disaster = new DisasterFragment();
            fragmentTransaction.replace(R.id.fire_ext_map_layout,fragment_disaster);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
            Log.v(TAG, "event-0 : " +event);
        }



    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);

    }

    @Override
    protected void onStop() {
        super.onStop();
        finish();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
