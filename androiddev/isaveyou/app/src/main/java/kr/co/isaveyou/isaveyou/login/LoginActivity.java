package kr.co.isaveyou.isaveyou.login;

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
import android.widget.Toast;

import com.google.firebase.iid.FirebaseInstanceId;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import kr.co.isaveyou.isaveyou.main.MainActivity;
import kr.co.isaveyou.isaveyou.R;


public class LoginActivity extends AppCompatActivity {
    private static final String TAG = "LoginActivity";
    public SharedPreferences settings;
    String loginId,loginPw,deviceKey,result;
    boolean loginChecked;
    CheckBox autoLogin;
    EditText etId, etPw;


    View.OnClickListener handler = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.login_button:
                    LoginErrorCheck();
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
        //기기 마다의 인스턴스 값 얻기
        getInstanceId();

    }

    private void LoginErrorCheck() { //로그인 에러 check method - id, pw 값을 받아옴
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

        else if (!isIdVaild(id)){ //너무 짧은 사번 값이 입력된 경우 확인
            etId.setError("입력하신 사번이 너무 길거나 짧습니다."); //에러 발생시 text를 보여줌
            focusView = etId;
            cancel = true;
            Log.v(TAG, "너무 짧은 사번 입력");
        }else if (!TextUtils.isEmpty(id)&&!TextUtils.isEmpty(pw)){
        }

        if(cancel){
            focusView.requestFocus();
        } else {
            
        }


    }
    // id, pw 길이 확인을 위한 method
    private boolean isPasswordVaild(String password){ //패스워드를 너무 짧게 입력하거나 길게 입력한 경우를 확인하기 위한 method
        return password.length()<=12 && password.length() >= 6;
    }
    private boolean isIdVaild(String id){ //아이디를 너무 짧게 입력하거나 길게 입력한 경우를 확인하기 위한 method, 사번은 10자로 구성됨
        return id.length() == 10;
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
    class LoginCheckTask extends AsyncTask<String, Void, String>{
        @Override
        protected String doInBackground(String... strings) {
            loginId = etId.getText().toString();
            loginPw = etPw.getText().toString();
            String param = "u_id=" + loginId + "&u_pw=" + loginPw +"&u_instancekey="+deviceKey +"";
            Log.v(TAG, "param : " + param);

            HttpURLConnection conn = null;
            try{
                /*서버연결*/
                URL url = new URL("http://192.168.0.35:9999/Android/Login.do?");
                conn = (HttpURLConnection)url.openConnection();

                conn.setFixedLengthStreamingMode(param.length());
                conn.setRequestProperty("Content-type","application/x-www-form-urlencoded");
                conn.setRequestMethod("POST");
                conn.setDoInput(true); // inputStream으로 서버로부터 응답을 받겠다는 옵션
                conn.connect();
                Log.v(TAG, "서버 연결");
                /*안드로이드 -> 서버 파라메터값 전달*/
                OutputStream outs = conn.getOutputStream();
                outs.write(param.getBytes("UTF-8"));
                outs.flush();
                outs.close();

                /*서버 -> 안드로이드 파라메터값 전달*/
                /* 실패 시 실패 메시지띄움*/
                if(conn.getResponseCode()!=HttpURLConnection.HTTP_OK){
                    finish();
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

            }catch(MalformedURLException|ProtocolException e){
                e.printStackTrace();
            }catch(IOException e){
                e.printStackTrace();
            }finally {
                conn.disconnect();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Log.v(TAG, "result in onPostExecute : " + result);
            Log.v(TAG, "onPostExecute loginId :" +loginId + ",loginPw :" + loginPw + ",deviceKey :" +deviceKey );

            try{
                String code_access = null;
                String code_name = null;
                String code_profile = null;
                String code_email = null;


                JSONObject jsonObject = new JSONObject(result);
                if(jsonObject.equals(null)){
                    Toast.makeText(getApplicationContext(),"서버에 접속할 수 없습니다.\n 다시 접속해 주세요.",Toast.LENGTH_SHORT).show();
//                    Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                }
                code_access = jsonObject.getString("access");
                code_name = jsonObject.getString("name");
                code_profile = jsonObject.getString("profile");
                code_email = jsonObject.getString("email");

                Log.v(TAG, "code_access : " + code_access);
                Log.v(TAG, "code_name : " + code_name);
                Log.v(TAG, "code_email : " + code_profile);
                Log.v(TAG, "code_profile : " + code_email);

                if(!code_access.equals("0")){
                    Toast.makeText(getApplicationContext(),"로그인 성공",Toast.LENGTH_SHORT).show();
                    Intent intent_main = new Intent(getApplicationContext(), MainActivity.class);

                    String strName = code_name;
                    String strEmail = code_email;
                    String strProfile = code_profile;
                    intent_main.putExtra("이름",strName);
                    intent_main.putExtra("이메일",strEmail);
                    intent_main.putExtra("프로필사진",strProfile);
                    startActivity(intent_main);
                    Log.v(TAG, "로그인성공");
                    finish();
                }else if(code_access.equals(null)){
                    Toast.makeText(getApplicationContext(),"로그인에 실패하였습니다. 다시 접속하여 주세요.", Toast.LENGTH_SHORT).show();
//                    Intent intent_re_go = new Intent(getApplicationContext(),LoginActivity.class);
                    Log.v(TAG, "로그인실패");
//                    startActivity(intent_re_go);
                }else{
                    Toast.makeText(getApplicationContext(),"잘못된 ID와 PW를 입력하셨습니다.",Toast.LENGTH_SHORT).show();
//                    Intent intent_re_go = new Intent(getApplicationContext(),LoginActivity.class);
                    Log.v(TAG, "로그인실패");
//                    startActivity(intent_re_go);
                }

            }catch (JSONException e){
                e.printStackTrace();
            }
        }
    }

}
