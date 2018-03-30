package kr.co.isaveyou.isaveyou.map;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import kr.co.isaveyou.isaveyou.R;

public class FloorMapActivity extends AppCompatActivity {
    private static final String TAG = "FloorMapActivity";
    String event,issue, eventCheck,place;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_floor_map);
        Intent intent = getIntent();
        eventCheck = intent.getDataString();
        String [] sArray = eventCheck.split("/");

        event = sArray[0];
        place = sArray[1];

        Log.v(TAG, "event : " + event);
        Log.v(TAG, "place : " + place);

        if(event.equals("1")){
            FragmentManager fragmentManager = getSupportFragmentManager();
            android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            android.support.v4.app.Fragment fragment_fire_ext = new Fire_extFragment();
            fragmentTransaction.replace(R.id.fire_ext_map_layout,fragment_fire_ext);
            fragmentTransaction.commit();
            Log.v(TAG, "event-1 : " + event);
        }else if(event.equals("0")){
            FragmentManager fragmentManager = getSupportFragmentManager();
            android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            Bundle bundle = new Bundle();
            bundle.putString("place",place);
            android.support.v4.app.Fragment fragment_disaster = new DisasterFragment();
            fragment_disaster.setArguments(bundle);
            fragmentTransaction.replace(R.id.fire_ext_map_layout,fragment_disaster);
            fragmentTransaction.commit();
            Log.v(TAG, "event-0 : " +event);
            Log.v(TAG,"place0 : " + place);
        }else if(event.equals("2")){
            Log.v(TAG, "event-2 : " +event);
        }



    }

    @Override
    protected void onStop() {
        super.onStop();
        finish();
    }
}
