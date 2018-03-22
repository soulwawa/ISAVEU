package kr.co.isaveyou.isaveyou;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.PowerManager;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.io.BufferedInputStream;
import java.net.URL;
import java.net.URLConnection;


import static android.content.Intent.ACTION_VIEW;
import static android.content.Intent.ACTION_DIAL;

public class MyFirebaseMessagingService extends FirebaseMessagingService {
    private static final String TAG = "MyFirebaseMessaginService";
    Bitmap img;


    //notification 활용을 위한 service - 푸시 메시지를 전달 받는 역할 담당
    //구글 클라우드 서버에서 보내오는 메시지를 받음


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

        sendNotification(
                //서버에서 보내오는 title, content를 인수로 지정
                remoteMessage.getData().get("title"),
                remoteMessage.getData().get("content")
        );


        // 안드로이드 폰깨우기
        PowerManager.WakeLock sCpuWakeLock;
        PowerManager pm = (PowerManager) getSystemService(Context.POWER_SERVICE);

        sCpuWakeLock = pm.newWakeLock( PowerManager.FULL_WAKE_LOCK |
                PowerManager.ACQUIRE_CAUSES_WAKEUP |
                PowerManager.ON_AFTER_RELEASE, TAG);

        sCpuWakeLock.acquire();

        if(sCpuWakeLock != null) { //acquire 함수를 사용하였으면 꼭 release를 해줘야 cpu 메모리 점유 , 배터리 소모에 영향을 덜 준다/
            sCpuWakeLock.release();
            sCpuWakeLock = null;
        }



    }


    private void sendNotification(String title, String messageBody) {

        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        Log.v(TAG, "notification 생성");


        int color = getResources().getColor(R.color.colorAccent);

        //largeIcon에 이미지를 사용하기 위해서는 비트맵으로 바꿔줘야 함
        Bitmap mLargeIconForNoti = BitmapFactory.decodeResource(getResources(), R.drawable.pic_2nd);


        //이미지 온라인 링크를 가져와 비트맵으로 바꿈
        try {
            URL url = new URL(messageBody);
            URLConnection connection = url.openConnection();
            connection.connect();
            BufferedInputStream bis = new BufferedInputStream(connection.getInputStream());
            img = BitmapFactory.decodeStream(bis);
            Log.v(TAG, "url : " + url + ", messagebody : " + messageBody);
        }catch (Exception e) {
            e.printStackTrace();
        }


        String channelId = getString(R.string.default_notification_channel_id);


        long [] pattern = {1000,1500,1000,1500, 1000,1500,1000,1500, 1000,1500,1000,1500}; //노티가 등록될 때 진동 패턴 (숫자 값 = 시간, 홀수 - 대기시간, 짝수 - 울림시간)
        Uri notificationSoundURI = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        //notificaiton 눌렀을 때의 액션 정의

        Intent actionCall = new Intent(ACTION_DIAL,Uri.parse("tel:119"));
        Intent actionCheckPlace = new Intent(ACTION_VIEW,Uri.parse("http://www.naver.com"));
        Intent actionCheckFire_ext = new Intent(getApplicationContext(),FloorMapActivity.class);



        //pending intetn에 액션 추가
//        FLAG_CANCEL_CURRENT : 이전에 생성한 PendingIntent 는 취소하고 새롭게 만든다.
//        FLAG_NO_CREATE : 생성된 PendingIntent 를 반환한다. 재사용 가능하다.
//        FLAG_ONE_SHOT : 이 flag 로 생성한 PendingIntent 는 일회용이다.
//        FLAG_UPDATE_CURRENT : 이미 생성된 PendingIntent 가 존재하면 해당 Intent 의 내용을 변경한다.


        PendingIntent callPendingIntent = PendingIntent.getActivity(getApplicationContext(),0,actionCall,PendingIntent.FLAG_CANCEL_CURRENT);
        PendingIntent checkPlacePendingIntent = PendingIntent.getActivity(getApplicationContext(),0,actionCheckPlace,PendingIntent.FLAG_CANCEL_CURRENT);
        PendingIntent checkFire_ext = PendingIntent.getActivity(getApplicationContext(),0,actionCheckFire_ext,PendingIntent.FLAG_CANCEL_CURRENT);



        NotificationCompat.Builder mNotificationBuilder = new NotificationCompat.Builder( this, channelId) //4.1 아래 버전과의 호환성을 위해 notificationCompat을 사용
                .setSmallIcon(R.drawable.ic_stat_name) //작은 아이콘 세팅
                .setLargeIcon(mLargeIconForNoti) //큰 아이콘 세팅 - 큰 아이콘 세팅을 위해서 위에 bitmap 이용
                .setColor(color)
                .setDefaults(Notification.DEFAULT_LIGHTS|Notification.DEFAULT_SOUND)
                .setAutoCancel( false ) // notification을 클릭한 경우, notification을 사라지게 하려면 true 값을 줘야함
                .setVibrate(pattern) //진동 설정
                .setPriority(NotificationCompat.PRIORITY_MAX)
                .setSound(notificationSoundURI)
                .setContentTitle("긴급상황 발생")
                .setWhen(System.currentTimeMillis())
                .setStyle(new NotificationCompat.BigPictureStyle() /*스타일 지정*/
                        .bigPicture(mLargeIconForNoti)
                        .bigPicture(img)
                        )
                .setContentText(title + "호 비상상황 발생, 빠르게 대피해주세요!")
                .addAction(R.drawable.pic_fire_call,getResources().getString(R.string.call),callPendingIntent) //119신고 액션 추가
                .addAction(R.drawable.pic_checkplace, getResources().getString(R.string.checkPlace),checkPlacePendingIntent)
                .addAction(R.drawable.pic_fire_ext,getResources().getString(R.string.checkFire_ext),checkFire_ext);


//                .setContentIntent(checkPlacePendingIntent)
//                .setContentIntent(callPendingIntent)
//                .setContentIntent(monitoringPendingIntent);





        notificationManager.notify(0 /* ID of notification */, mNotificationBuilder.build());
    }
}
