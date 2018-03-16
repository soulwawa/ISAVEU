package kr.co.isaveyou.isaveyou;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.PowerManager;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.RemoteViews;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyFirebaseMessagingService extends FirebaseMessagingService {
    private static final String TAG = "MyFirebaseMessaginService";


    //notification 활용을 위한 service - 푸시 메시지를 전달 받는 역할 담당
    //구글 클라우드 서버에서 보내오는 메시지를 받음


//    View.OnClickListener handler = new View.OnClickListener() {
//        @Override
//        public void onClick(View v) {
//            switch (v.getId()){
//                case R.string.call
//                    StartActivity
//                    break;
//            }
//        }
//    };



    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        Log.v(TAG, "receive");
        Log.d(TAG, "From" + remoteMessage.getFrom());



        // Check if message contains a data payload.
        if (remoteMessage.getData().size() > 0) {
            Log.d(TAG, "Message data payload: " + remoteMessage.getData());
        }


        // Check if message contains a notification payload.
        if (remoteMessage.getNotification() != null) {
            Log.d(TAG, "Message Notification Body: " + remoteMessage.getNotification().getBody());}
        sendNotification(remoteMessage.getData().get("title"), remoteMessage.getData().get("content"));


        // 안드로이드 폰깨우기
        PowerManager.WakeLock sCpuWakeLock;
        PowerManager pm = (PowerManager) getSystemService(Context.POWER_SERVICE);

        sCpuWakeLock = pm.newWakeLock( PowerManager.FULL_WAKE_LOCK |
                PowerManager.ACQUIRE_CAUSES_WAKEUP |
                PowerManager.ON_AFTER_RELEASE, TAG);

        sCpuWakeLock.acquire();

        if(sCpuWakeLock != null) { //acquire함수를 사용하였으면 꼭 release를 해줘야 cpu 메모리 점유 , 배터리 소모에 영향을 덜 준다/
            sCpuWakeLock.release();
            sCpuWakeLock = null;
        }

//        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON|WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED|WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD);

    }

    private void sendNotification(String title, String messageBody) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        Log.v(TAG, "notification 생성");

        int color = getResources().getColor(R.color.colorAccent);
        Bitmap mLargeIconForNoti = BitmapFactory.decodeResource(getResources(), R.drawable.pic_2nd);

        String channelId = getString(R.string.default_notification_channel_id);


        long [] pattern = {1000,1500,1000,1500, 1000,1500,1000,1500, 1000,1500,1000,1500}; //노티가 등록될 때 진동 패턴 (숫자 값 = 시간, 홀수 - 대기시간, 짝수 - 울림시간)
        Uri notificationSoundURI = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        //notificaiton 눌렀을 때의 액션 정의
        Intent actionCall = new Intent("dial");
        Intent actionMonitoring = new Intent();

        //pending intetn에 액션 추가
//        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0 /* Request code */, intent,
//                PendingIntent.FLAG_ONE_SHOT);
        PendingIntent callPendingIntent = PendingIntent.getBroadcast(getApplicationContext(),0,actionCall,PendingIntent.FLAG_ONE_SHOT);
        PendingIntent monitoringPendingIntent = PendingIntent.getActivity(getApplicationContext(),0,actionMonitoring,PendingIntent.FLAG_ONE_SHOT);
        PendingIntent checkPlacePendingIntent = PendingIntent.getActivity(getApplicationContext(),0,actionMonitoring,PendingIntent.FLAG_ONE_SHOT);

        sendBroadcast(actionCall);
//

        NotificationCompat.Builder mNotificationBuilder = new NotificationCompat.Builder( this, channelId) //4.1 아래 버전과의 호환성을 위해 notificationCompat을 사용용
                .setSmallIcon(R.drawable.ic_stat_name) //작은 아이콘 세팅
                .setLargeIcon(mLargeIconForNoti) //큰 아이콘 세팅 - 큰 아이콘 세팅을 위해서 위에 bitmap 이용
                .setColor(color)
                .setDefaults(Notification.DEFAULT_LIGHTS|Notification.DEFAULT_SOUND)
                .setContentTitle( title )
                .setContentText(messageBody)
                .setAutoCancel( false ) // notification을 클릭한 경우, notification을 사라지게 하려면 true 값을 줘야함
                .setVibrate(pattern) //진동 설정

                .setStyle(new NotificationCompat.BigPictureStyle().bigPicture(mLargeIconForNoti))
                .addAction(R.drawable.ic_call, getResources().getString(R.string.call), callPendingIntent) //119신고 액션 추가
                .addAction(R.drawable.ic_stat_warnig, getResources().getString(R.string.checkPlace),checkPlacePendingIntent)
                .addAction(R.drawable.ic_stat_monitoring, getResources().getString(R.string.checkPicture),monitoringPendingIntent) //화재 확인 액션 추가
                .setPriority(NotificationCompat.PRIORITY_MAX)
                .setSound(notificationSoundURI);
//                .setContentIntent(checkPlacePendingIntent)
//                .setContentIntent(callPendingIntent)
//                .setContentIntent(monitoringPendingIntent);




        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        notificationManager.notify(0 /* ID of notification */, mNotificationBuilder.build());
    }
}
