package kr.co.isaveyou.isaveyou.widget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
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
import kr.co.isaveyou.isaveyou.main.MainActivity;
import kr.co.isaveyou.isaveyou.voice.VoiceActivity;

/**
 * Implementation of App Widget functionality.
 */
public class NewAppWidget extends AppWidgetProvider {
    private static final String TAG = "ISaveUWidget";
    private static final String str_streaming = "ACTION_STREAMING";
    private static final String str_voice_record = "ACTION_VOICE_RECORD";
    private static final String str_ok = "ACTION_OK";
    private static final String str_noti_update = "ACTION_NOTIFICATION_UPDATE";
    String result, issue, loc, loc1;
    HttpURLConnection conn;
    SharedPreferences sharedPreferences1, sharedPreferences2;
    String [] sArray, ssArray;

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
            case "ACTION_STREAMING" :
                Intent it_go_streaming = new Intent(context, MainActivity.class);
                it_go_streaming.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                it_go_streaming.setData(Uri.parse("1"));
                context.startActivity(it_go_streaming);
                Log.v(TAG, "스트리밍 실행");
                break;
            case "ACTION_VOICE_RECORD":
                Log.v(TAG, "녹음 시작");
                break;
            case "ACTION_OK":
                try{
                    if(sharedPreferences1!=null) {
                        WidgetUpdateTask widgetUpdateTask = new WidgetUpdateTask();
                        widgetUpdateTask.execute();
                        Log.v(TAG, "확인 버튼 누름1");
                        views.setTextViewText(R.id.tv_issue_for_widget, "문제가 없습니다.");
                        views.setInt(R.id.layout_status, "setBackgroundResource", R.drawable.app_logo);
                        ComponentName newWidget0 = new ComponentName(context.getPackageName(), NewAppWidget.class.getName());
                        AppWidgetManager.getInstance(context).updateAppWidget(newWidget0, views);
                    }else{
                        Log.v(TAG, "확인 버튼 누름2");
                        views.setTextViewText(R.id.tv_issue_for_widget, "문제가 없습니다.");
                        views.setInt(R.id.layout_status, "setBackgroundResource", R.drawable.app_logo);
                        ComponentName newWidget0 = new ComponentName(context.getPackageName(), NewAppWidget.class.getName());
                        AppWidgetManager.getInstance(context).updateAppWidget(newWidget0, views);
                    }
                }catch (NullPointerException e){
                    e.printStackTrace();
                }
                break;
            case "ACTION_NOTIFICATION_UPDATE":
                Log.v(TAG, "업데이트");
                //위젯에 글자를 나타내기 위한 새로 고침 작업을 별도의 method로 빼기
                this.refresh(context, views);
//                AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
                ComponentName newWidget1 = new ComponentName(context.getPackageName(), NewAppWidget.class.getName());
                AppWidgetManager.getInstance(context).updateAppWidget(newWidget1,views);
                sharedPreferences1 = context.getSharedPreferences("check_type",Context.MODE_PRIVATE);
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



            // Create an Intent to launch FloorMapActivity
            Intent it_checkMap = new Intent(context, FloorMapActivity.class);
            it_checkMap.setData(Uri.parse("1"));
            PendingIntent pi_map = PendingIntent.getActivity(context, 0, it_checkMap, 0);
            views.setOnClickPendingIntent(R.id.btn_check_map, pi_map);


            // Create an Intent to launch Camera
            views.setOnClickPendingIntent(R.id.btn_camera,getPendingSelfIntent(context, str_streaming));


            views.setOnClickPendingIntent(R.id.btn_ok, getPendingSelfIntent(context,str_ok));

            Intent it_voiceRecord = new Intent(context,VoiceActivity.class);
            PendingIntent pi_voiceRecord = PendingIntent.getActivity(context,0,it_voiceRecord,0);
            views.setOnClickPendingIntent(R.id.btn_record,pi_voiceRecord);



            //위젯에 글자를 나타내기 위한 새로 고침 작업을 별도의 method로 빼기
//            this.refresh(context,views);

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
        SharedPreferences sharedPreferences2 = context.getSharedPreferences("check_type",Context.MODE_PRIVATE);
        sharedPreferences1 = sharedPreferences2;
        //issue 타입에 맞게 이미지 바꿔줌
//        List<String> keys = new ArrayList<>();
        Map<String, ?> allEntries = sharedPreferences.getAll();
        issue = "";

        for (Map.Entry<String, ?> entry : allEntries.entrySet()) {
            Log.v(TAG, entry.getKey() + ": " + entry.getValue().toString());
            views.setTextViewText(R.id.tv_issue_for_widget, issue);
            switch (entry.getKey()) {
                case "1":
                    issue = sharedPreferences.getString("1", "");
                    views.setTextViewText(R.id.tv_issue_for_widget, issue);
                    views.setInt(R.id.layout_status, "setBackgroundResource", R.drawable.pic_disaster_flame);
                    Log.v(TAG, "화재");
                    sharedPreferences.edit().remove("1").commit();
                    break;
                case "2":
                    issue = sharedPreferences.getString("2", "");
                    views.setTextViewText(R.id.tv_issue_for_widget, issue);
                    Log.v(TAG, "지진");
                    views.setInt(R.id.layout_status, "setBackgroundResource", R.drawable.pic_disaster_earthquake);
                    sharedPreferences.edit().remove("2").commit();
                    break;
                case "3":
                    issue = sharedPreferences.getString("3", "");
                    views.setTextViewText(R.id.tv_issue_for_widget, issue);
                    views.setInt(R.id.layout_status, "setBackgroundResource", R.drawable.pic_disaster_fire_earthquake);
                    Log.v(TAG, "화재/지진");
                    sharedPreferences.edit().remove("3").commit();
                    break;
                case "4":
                    issue = sharedPreferences.getString("4", "");
                    views.setTextViewText(R.id.tv_issue_for_widget, issue);
                    views.setInt(R.id.layout_status, "setBackgroundResource", R.drawable.pic_miss_fire_ext);
                    Log.v(TAG, "소화기");
                    sharedPreferences.edit().remove("4").commit();
                    break;
                case "5":
                    issue = sharedPreferences.getString("5", "");
                    views.setTextViewText(R.id.tv_issue_for_widget, issue);
                    views.setInt(R.id.layout_status, "setBackgroundResource", R.drawable.pic_machine_question);
                    Log.v(TAG, "기계이상");
                    sharedPreferences.edit().remove("5").commit();
                    break;
                default:
                    issue = "";
                    break;
            }

        }
    }
    //상태 완료 확인 -> 서버로 확인 완료 보냄
    class WidgetUpdateTask extends AsyncTask{
        @Override
        protected Object doInBackground(Object[] objects) {
            //            List<String> keys = new ArrayList<>();
            Map<String, ?> allEntries = sharedPreferences1.getAll();
            String issue2 = "";
            for(Map.Entry<String, ?> entry : allEntries.entrySet()){
                switch (entry.getKey()){
                    case "1":
                        issue2 = sharedPreferences1.getString("1", "");
                        Log.v(TAG, "화재");
                        sharedPreferences1.edit().remove("1").commit();
                        break;
                    case "2":
                        issue = sharedPreferences1.getString("2", "");
                        Log.v(TAG, "지진");
                        sharedPreferences1.edit().remove("2").commit();
                        break;
                    case "3":
                        issue = sharedPreferences1.getString("3", "");
                        Log.v(TAG, "화재/지진");
                        sharedPreferences1.edit().remove("3").commit();
                        break;
                    case "4":
                        issue = sharedPreferences1.getString("4", "");
                        Log.v(TAG, "소화기");
                        sharedPreferences1.edit().remove("4").commit();
                        break;
                    case "5":
                        issue = sharedPreferences1.getString("5", "");
                        Log.v(TAG, "기계이상");
                        sharedPreferences1.edit().remove("5").commit();
                        break;
                    default:
                        issue = "";
                        break;
                }
            }
            try {
                //서버 접속
                sArray = issue2.split(",");
                Log.v(TAG, "sArray" + sArray[1]);
                loc1 = sArray[1];
                ssArray = loc1.split("/");
                loc = ssArray[0];
                if (loc1.equals("기계이상")){
                    URL url1 = new URL("http://localhost:9999/module/eventIn.do?module_id=0&temp=0&smoke=0&gyro=0&fire=0&issue=0&reset=1");
                    conn = (HttpURLConnection)url1.openConnection();
                    conn.setDoInput(true);
                    conn.setRequestProperty("Content-type","application/json");
                    conn.setRequestMethod("GET");
                    conn.connect();
                    sharedPreferences1.edit().remove("device_error").commit();
                }else if(loc1.equals("소화기")){
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
                    sharedPreferences1.edit().remove("fire_ext_error").commit();
                }else{

                }
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
            }catch (Exception e) {
                e.printStackTrace();
            } return null;
        }

        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);

        }
    }
}

