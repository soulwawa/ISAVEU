package kr.co.isaveyou.isaveyou.voice;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import kr.co.isaveyou.isaveyou.Manifest;
import kr.co.isaveyou.isaveyou.R;
import kr.co.isaveyou.isaveyou.issue.FloorMapActivity;
import kr.co.isaveyou.isaveyou.main.MainActivity;

public class VoiceActivity extends AppCompatActivity {
    private static final String TAG = "VoiceActivity";
    private static final int SPEECH_REQUEST_CODE = 1; //REQUEST_CODE로 쓰임
    private Intent intent;
    private TextView tv_voiceREcordResult;
    SpeechRecognizer mRecognizer;
    private ArrayList<String> mResult;									//음성인식 결과 저장할 list
    private String mSelectedString;										//결과 list 중 사용자가 선택한 텍스트
    private TextView mResultTextView;									//최종 결과 출력하는 텍스트 뷰


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voice);


        Log.v(TAG, "VoiceACtivity 시작");
        sendRecognizeIntent();

    }
    //음성 녹음 intent method
    private void sendRecognizeIntent() {
        intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Speak to search");
        intent.putExtra(RecognizerIntent.EXTRA_MAX_RESULTS, 10);
        startActivityForResult(intent, SPEECH_REQUEST_CODE);
    }

    //음성녹음 실행한 뒤에 결과 값 받아옴
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == SPEECH_REQUEST_CODE){
            if(resultCode == RESULT_OK){
                Log.v(TAG, "result ok");
//                Intent widget_Intent = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.search_rul)));
//                startActivity(widget_Intent);
                String key = RecognizerIntent.EXTRA_RESULTS;

                mResult = data.getStringArrayListExtra(key);        //인식된 데이터 list 받아옴.
                String[] result = new String[mResult.size()];            //배열생성. 다이얼로그에서 출력하기 위해
                mResult.toArray(result);                                    //    list 배열로 변환
                //1개 선택하는 다이얼로그 생성
                AlertDialog ad = new AlertDialog.Builder(this).setTitle("녹음하신 내용과 일치하는 것을 선택하세요.")
                        .setSingleChoiceItems(result, -1, new DialogInterface.OnClickListener() {
                            @Override public void onClick(DialogInterface dialog, int which) {
                                mSelectedString = mResult.get(which);        //선택하면 해당 글자 저장
                            }
                        })
                        .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override public void onClick(DialogInterface dialog, int which) {
                                if(mSelectedString.contains("비상")&&mSelectedString.contains("대피")){
                                    Intent it_fire_ext = new Intent(getApplicationContext(), FloorMapActivity.class);
                                    it_fire_ext.setData(Uri.parse("1/000"));
                                    startActivity(it_fire_ext);
                                    finish();
                                }else if(mSelectedString.contains("화재")||mSelectedString.contains("현장")){
                                    Intent it_disaster = new Intent(getApplicationContext(), FloorMapActivity.class);
                                    it_disaster.setData(Uri.parse("0/000"));
                                    startActivity(it_disaster);
                                    finish();
                                }else if(mSelectedString.contains("모니터링")||mSelectedString.contains("스트리밍")||mSelectedString.contains("영상")){
                                    Intent it_streaming = new Intent(getApplicationContext(), MainActivity.class);
                                    it_streaming.setData(Uri.parse("1"));
                                    startActivity(it_streaming);
                                    finish();
                                }else if(mSelectedString.contains("소화기")){
                                    Intent it_fire_ext = new Intent(getApplicationContext(), FloorMapActivity.class);
                                    it_fire_ext.setData(Uri.parse("1/000"));
                                    startActivity(it_fire_ext);
                                }else{
                                    Toast.makeText(getApplicationContext(),"현재 말씀하신 내용과 관련된 기능이 없습니다.\n비상, 대피, 화재, 현장, 모니터링, 스트리밍, 영상, 소화기 중 하나를 포함하여 말씀해주세요.",Toast.LENGTH_LONG).show();
                                }
                                       //결과 출력

                            }
                        })
                        .setNegativeButton("취소", new DialogInterface.OnClickListener() {
                            @Override public void onClick(DialogInterface dialog, int which) {
                                mSelectedString = null;
                            }
                        }).create();
                ad.show();
            }else {
                Log.v(TAG, "result NOT ok");

            }
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        Intent it_main = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(it_main);
        finish();
    }
}
