package kr.co.isaveyou.isaveyou;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.util.Log;

/**
 * notification에서 다른 기능 구현을 위한 bcr
 * 추후 필요한 곳이 있을 수도 있어서 만들어 둠
 */

public class NotiBroadCastRecevier extends BroadcastReceiver {
    private static final String TAG = "BroadCastReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.v(TAG,"receive");
        String action = intent.getAction();
        switch (action){
            case "btn119":

                Log.v(TAG,"intent : " + intent);
                context.startActivity(intent);

                break;
        }
        IntentFilter intentFilter = new IntentFilter();

    }

}
