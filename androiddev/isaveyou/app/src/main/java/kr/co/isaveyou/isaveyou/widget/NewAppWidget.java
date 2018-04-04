package kr.co.isaveyou.isaveyou.widget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.widget.RemoteViews;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import kr.co.isaveyou.isaveyou.R;
import kr.co.isaveyou.isaveyou.issue.FloorMapActivity;
import kr.co.isaveyou.isaveyou.voice.VoiceActivity;

/**
 * Implementation of App Widget functionality.
 */
public class NewAppWidget extends AppWidgetProvider {
    private static final String TAG = "ISaveUWidget";
    private static final String str_camera = "ACTION_CAMERA";
    private static final String str_voice_record = "ACTION_VOICE_RECORD";
    private static final String str_ok = "ACTION_OK";
    String result, issue;
    HttpURLConnection conn;

//    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
//                                int appWidgetId) {
//
//        CharSequence widgetText = context.getString(R.string.appwidget_text);
//        // Construct the RemoteViews object
//        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.new_app_widget);
//        views.setTextViewText(R.id.appwidget_text, widgetText);
//
//        // Instruct the widget manager to update the widget
//        appWidgetManager.updateAppWidget(appWidgetId, views);
//    }

    @Override
    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);
        String action = intent.getAction();
        Log.v(TAG, "onReceive() action : " + action);
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.new_app_widget);
        if (AppWidgetManager.ACTION_APPWIDGET_UPDATE.equals(action)) {
            Bundle extras = intent.getExtras();
            if (extras != null) {
                int[] appWidgetIds = extras.getIntArray(AppWidgetManager.EXTRA_APPWIDGET_IDS);
                if (appWidgetIds != null && appWidgetIds.length > 0) {
                    this.onUpdate(context, AppWidgetManager.getInstance(context), appWidgetIds);
                }
            }
        }
        switch (action){
            case "ACTION_CAMERA" :
                Intent it_go_camera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                it_go_camera.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(it_go_camera);
                Log.v(TAG, "카메라 실행");
                break;
            case "ACTION_VOICE_RECORD":

                Log.v(TAG, "녹음 시작");
                break;
            case "ACTION_OK":
                WidgetUpdateTask widgetUpdateTask = new WidgetUpdateTask();
                widgetUpdateTask.execute();
                Log.v(TAG, "확인 버튼 누름");
                views.setTextViewText(R.id.tv_issue_for_widget, "문제가 없습니다.");
                views.setInt(R.id.layout_status,"setBackgroundResource",R.drawable.app_logo);
                break;
        }

    }


    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them
        final int N = appWidgetIds.length;
        for (int i=0; i<N; i++) {
            int appWidgetId = appWidgetIds[i];
            RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.new_app_widget);
//            views.setTextViewText();


            // Create an Intent to launch FloorMapActivity
            Intent it_checkMap = new Intent(context, FloorMapActivity.class);
            it_checkMap.setData(Uri.parse("2/000"));
            PendingIntent pi_map = PendingIntent.getActivity(context, 0, it_checkMap, 0);
            views.setOnClickPendingIntent(R.id.btn_check_map, pi_map);

            // Create an Intent to launch Camera
            views.setOnClickPendingIntent(R.id.btn_camera,getPendingSelfIntent(context, str_camera));

//            Intent it_
//            Intent it_check = new Intent(context, WidgetUpdateTask.class);
//            PendingIntent pi_ok = PendingIntent.getActivity(context,0,it_check,0);
            views.setOnClickPendingIntent(R.id.btn_ok, getPendingSelfIntent(context,str_ok));

            Intent it_voiceRecord = new Intent(context,VoiceActivity.class);
            PendingIntent pi_voiceRecord = PendingIntent.getActivity(context,0,it_voiceRecord,0);
            views.setOnClickPendingIntent(R.id.btn_record,pi_voiceRecord);



            //위젯에 글자를 나타내기 위한 새로 고침 작업을 별도의 method로 빼기
            this.refresh(context, views);

            // Tell the AppWidgetManager to perform an update on the current app widget
            appWidgetManager.updateAppWidget(appWidgetId, views);

        }
    }
    protected PendingIntent getPendingSelfIntent(Context context, String action) {
        Intent intent = new Intent(context, getClass());
        intent.setAction(action);
        return PendingIntent.getBroadcast(context, 0, intent, 0);
    }
    @Override
    public void onEnabled(Context context) {
        // Enter relevant functionality for when the first widget is created
    }

    @Override
    public void onDisabled(Context context) {
        // Enter relevant functionality for when the last widget is disabled
    }

    private void refresh(Context context, RemoteViews views) {
        //noti 에서 보내온 내용을 받음
        SharedPreferences sharedPreferences = context.getSharedPreferences("issue_type", Context.MODE_PRIVATE);
        //issue 타입에 맞게 이미지 바꿔줌
        List<String> keys = new ArrayList<>();
        Map<String, ?> allEntries = sharedPreferences.getAll();
        issue = "";
        for (Map.Entry<String, ?> entry : allEntries.entrySet()) {
            Log.v(TAG, entry.getKey() + ": " + entry.getValue().toString());
//            if(entry.getKey().toString().contains("1")){
//
//            }
            switch (entry.getKey().toString()) {
                case "1":
                    issue = sharedPreferences.getString("1", "");
                    views.setTextViewText(R.id.tv_issue_for_widget, issue);
                    views.setInt(R.id.layout_status, "setBackgroundResource", R.drawable.pic_disaster_flame);
                    Log.v(TAG, "화재");
                    break;
                case "2":
                    issue = sharedPreferences.getString("2", "");
                    views.setTextViewText(R.id.tv_issue_for_widget, issue);
                    Log.v(TAG, "지진");
                    views.setInt(R.id.layout_status, "setBackgroundResource", R.drawable.pic_disaster_earthquake);
                    break;
                case "3":
                    issue = sharedPreferences.getString("3", "");
                    views.setTextViewText(R.id.tv_issue_for_widget, issue);
                    views.setInt(R.id.layout_status, "setBackgroundResource", R.drawable.pic_disaster_fire_earthquake);
                    Log.v(TAG, "화재/지진");
                    break;
                case "4":
                    issue = sharedPreferences.getString("4", "");
                    views.setTextViewText(R.id.tv_issue_for_widget, issue);
                    views.setInt(R.id.layout_status, "setBackgroundResource", R.drawable.pic_miss_fire_ext);
                    Log.v(TAG, "소화기");
                    break;
            }
        }
    }
    class WidgetUpdateTask extends AsyncTask{
        @Override
        protected Object doInBackground(Object[] objects) {
            try {
                //서버 접속
                String [] sArray = issue.split(",");
                Log.v(TAG, "sArray" + sArray[1]);
                String loc1 = sArray[1];
                String [] ssArray = loc1.split("/");
                String loc = ssArray[0];
//                String loc = "600";
                String param = "loc=" + loc;

                URL url = new URL("http://192.168.0.35:9999/Android/feRestart.do?");
                conn = (HttpURLConnection)url.openConnection();
                conn.setFixedLengthStreamingMode(param.length());
                conn.setRequestProperty("Content-type","application/x-www-form-urlencoded");
                conn.setRequestMethod("POST");
                conn.setDoInput(true);
                conn.connect();
                OutputStream outs = conn.getOutputStream();
                outs.write(param.getBytes("UTF-8"));
                outs.flush();
                outs.close();
                Log.v(TAG, "서버 연결");

                if(conn.getResponseCode()!=HttpURLConnection.HTTP_OK){
                } else {
                    BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    String line;
                    StringBuffer buffer = new StringBuffer();
                    while ((line = reader.readLine())!=null){
                        buffer.append(line + "\n");
                    }
                    result = buffer.toString();
                    Log.v(TAG, "buffer result : " + line );
                    reader.close();
                }
                Log.v(TAG, "url : " + url );
            }catch (Exception e) {
                e.printStackTrace();
            }return null;
        }

        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);

        }
    }



}

