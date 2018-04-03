package kr.co.isaveyou.isaveyou.widget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.MediaStore;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.util.Log;
import android.widget.RemoteViews;

import java.util.ArrayList;

import kr.co.isaveyou.isaveyou.R;
import kr.co.isaveyou.isaveyou.issue.FloorMapActivity;

/**
 * Implementation of App Widget functionality.
 */
public class NewAppWidget extends AppWidgetProvider {
    private static final String TAG = "ISaveUWidget";
    private static final String str_camera = "ACTION_CAMERA";
    private static final String str_voice_record = "ACTION_VOICE_RECORD";

    private Intent i;
    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                int appWidgetId) {

        CharSequence widgetText = context.getString(R.string.appwidget_text);
        // Construct the RemoteViews object
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.new_app_widget);
        views.setTextViewText(R.id.appwidget_text, widgetText);

        // Instruct the widget manager to update the widget
        appWidgetManager.updateAppWidget(appWidgetId, views);
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);
        String action = intent.getAction();
        Log.v(TAG, "onReceive() action : " + action);

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
                Intent it_checkVoiceRecord = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                it_checkVoiceRecord.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_WEB_SEARCH);
                it_checkVoiceRecord.putExtra(RecognizerIntent.EXTRA_LANGUAGE,"ko-KR");
                it_checkVoiceRecord.putExtra(RecognizerIntent.EXTRA_PROMPT,"음성을 녹음해주세요.");
                context.startActivity(it_checkVoiceRecord);



                    Log.v(TAG, "녹음 시작");
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


            // Create an Intent to launch Camera
            views.setOnClickPendingIntent(R.id.btn_camera,getPendingSelfIntent(context, str_camera));
            Log.v(TAG, "카메라 누름");

            // Get the layout for the App Widget and attach an on-click listener
            // to the button

            views.setOnClickPendingIntent(R.id.btn_check_map, pi_map);

            Log.v(TAG, "맵보기 누름");
            views.setOnClickPendingIntent(R.id.btn_record,getPendingSelfIntent(context,str_voice_record));
            // Tell the AppWidgetManager to perform an update on the current app widget
            appWidgetManager.updateAppWidget(appWidgetId, views);}
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
    private RecognitionListener listener = new RecognitionListener() {
        @Override
        public void onReadyForSpeech(Bundle params) {

        }

        @Override
        public void onBeginningOfSpeech() {

        }

        @Override
        public void onRmsChanged(float rmsdB) {

        }

        @Override
        public void onBufferReceived(byte[] buffer) {

        }

        @Override
        public void onEndOfSpeech() {

        }

        @Override
        public void onError(int error) {

        }

        @Override
        public void onResults(Bundle results) {
            String key = "";
            key = SpeechRecognizer.RESULTS_RECOGNITION;
            ArrayList<String> mResult = results.getStringArrayList(key);
            String[] rs = new String[mResult.size()];

            mResult.toArray(rs);


        }

        @Override
        public void onPartialResults(Bundle partialResults) {

        }

        @Override
        public void onEvent(int eventType, Bundle params) {

        }
    };

}

