package kr.co.isaveyou.isaveyou;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;

/**
 * notification에서 다른 기능 구현을 위한 bcr
 */

public class NotiBroadCastRecevier extends BroadcastReceiver {
    private static final String TAG = "BroadCastReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.v(TAG,"receive");
        String action = intent.getAction();
        switch (action){
            case "dial":
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("119"));
                Intent intent1 = new Intent(callIntent);
                Log.v(TAG,"intent : " + intent);
                break;
        }
    }
}
