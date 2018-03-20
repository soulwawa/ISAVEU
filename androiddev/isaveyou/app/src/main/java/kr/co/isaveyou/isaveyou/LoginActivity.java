package kr.co.isaveyou.isaveyou;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

import com.google.firebase.iid.FirebaseInstanceId;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class LoginActivity extends AppCompatActivity {
    private static final String TAG = "LoginActivity";
    public SharedPreferences settings;
    String loginId,loginPw,deviceKey;
    boolean loginChecked;
    CheckBox autoLogin;
    EditText etId, etPw;

    View.OnClickListener handler = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.login_button:
                    Login();
                    Log.v(TAG, "로그인 버튼 눌림");
                    LoginCheckTask loginCheckTask = new LoginCheckTask();
                    loginCheckTask.execute();
                    break;
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etId = findViewById(R.id.login_id);
        etPw = findViewById(R.id.login_pw);
        findViewById(R.id.login_button).setOnClickListener(handler);
        autoLogin = (CheckBox)findViewById(R.id.checkBox2);

        loginId = etId.getText().toString().trim();
        loginPw = etPw.getText().toString().trim();
        deviceKey = FirebaseInstanceId.getInstance().getToken();

        Log.v(TAG, "loginId :" +loginId + ",loginPw :" + loginPw + ",deviceKey :" +deviceKey );
        settings = getSharedPreferences("settings", Activity.MODE_PRIVATE);
        // 자동 로그인을 설정했다면 앱이 시작된 경우에도 입력했던 값이 유지되도록 함

        loginChecked = settings.getBoolean("LoginChecked", false);
        if(loginChecked){
            etId.setText(settings.getString("loginID",""));
            etPw.setText(settings.getString("loginPW",""));
            autoLogin.setChecked(true);
        }
        HttpURLConnection conn = null;
        //기기 마다의 인스턴스 값 얻기
        getInstanceId();

    }

    private void Login() { //로그인 method - id, pw 값을 받아옴
        etId.setError(null);
        etPw.setError(null);

        String id = etId.getText().toString();
        String pw = etPw.getText().toString();

        boolean cancel = false;
        View focusView = null;

        Log.v(TAG, "id : " + id + ", pw : "+ pw);


        if (!isPasswordVaild(pw)){  //너무 짧은 암호 값이 입력된 경우 확인
            etPw.setError("입력하신 암호가 너무 길거나 짧습니다.");
            focusView = etPw;
            cancel = true;
            Log.v(TAG, "암호 오류");
        }
//        else if(TextUtils.isEmpty(id)){    //사번이 비어있는 경우 확인
//            etId.setError("사번을 입력해주세요.");
//            focusView = etId;
//            cancel = true;
//            Log.v(TAG, "사번 미입력");
//        }
        else if (!isIdVaild(id)){ //너무 짧은 사번 값이 입력된 경우 확인
            etId.setError("입력하신 사번이 너무 길거나 짧습니다."); //에러 발생시 text를 보여줌
            focusView = etId;
            cancel = true;
            Log.v(TAG, "너무 짧은 사번 입력");
        }else if (!TextUtils.isEmpty(id)&&!TextUtils.isEmpty(pw)){
            Intent intent_main = new Intent(this, MainActivity.class);
//            Intent intent_drawer = new Intent(this, Drawer_header_Activity.class);
            String strId = id.valueOf(id);
            intent_main.putExtra("사번",strId);
//            intent_drawer.putExtra("사번",strId);
            startActivity(intent_main);
//            startActivity(intent_drawer);
            finish();
        }

        if(cancel){
            focusView.requestFocus();
        } else {
            
        }


    }
    // id, pw 길이 확인을 위한 method
    private boolean isPasswordVaild(String password){ //패스워드를 너무 짧게 입력한 경우를 확인하기 위한 method
        return password.length()!= 10;
    }
    private boolean isIdVaild(String id){ //패스워드를 너무 짧게 입력한 경우를 확인하기 위한 method
        return id.length()<12 && id.length() > 6;
    }

    void getInstanceId(){ //앱을 설치한 기계의 instance Id를 얻기 위한 method
        Log.v(TAG, "id : " + FirebaseInstanceId.getInstance().getToken());
    }

    @Override
    protected void onStop() {
        super.onStop();
        //자동 로그인이 체크되어 있고, 로그인에 성공했으면 폰에 자동로그인
        if(autoLogin.isChecked()){
            settings = getSharedPreferences("settings", Activity.MODE_PRIVATE);
            SharedPreferences.Editor editor = settings.edit();

            editor.putString("loginID", loginId);
            editor.putString("loginPw", loginPw);
            editor.putBoolean("LoginChecked", true);

            editor.commit();
        }else{
            //자동 로그인 체크가 해제되면 폰에 저장된 정보 모두 삭제
            settings = getSharedPreferences("settings", Activity.MODE_PRIVATE);
            SharedPreferences.Editor editor =settings.edit();
            editor.clear(); // 모든 정보 해제
            editor.commit();

        }

    }
    //로그인 시 서버에 연결된 DB에 있는 ID 값과 PW 값으로 ID,PW 체크
    class LoginCheckTask extends AsyncTask<String, String, String>{
        @Override
        protected String doInBackground(String... strings) {
            loginId = etId.getText().toString();
            loginPw = etPw.getText().toString();
            String param = "u_id=" + loginId + "&u_pw=" + loginPw +"&u_instancekey="+deviceKey +"";
            Log.v(TAG, "param : " + param);

            try{
                /*서버연결*/
                URL url = new URL("http://192.168.0.35:8088/SafeForYou/AndroidLogin.do?");
                HttpURLConnection conn = (HttpURLConnection)url.openConnection();
                conn.setRequestProperty("Content-type","application/x-www-form-urlencoded");
                conn.setRequestMethod("POST");
                conn.setDoInput(true);
                conn.connect();
                Log.v(TAG, "서버 연결");
                /*안드로이드 -> 서버 파라메터값 전달*/
                OutputStream outs = conn.getOutputStream();
                outs.write(param.getBytes("UTF-8"));
                outs.flush();
                outs.close();

                /*서버 -> 안드로이드 파라메터값 전달*/
                InputStream is = null;
                BufferedReader in = null;
                String data = "";

                is = conn.getInputStream();
                in = new BufferedReader(new InputStreamReader(is), 8*1024);
                String line = null;
                StringBuffer buff = new StringBuffer();
                while ((line = in.readLine())!=null){
                    buff.append(line + "\n");
                }
                data = buff.toString().trim();
                Log.v(TAG, "data : " + data );
            }catch(MalformedURLException e){
                e.printStackTrace();
            }catch(IOException e){
                e.printStackTrace();
            }
            return null;
        }

    }
}
