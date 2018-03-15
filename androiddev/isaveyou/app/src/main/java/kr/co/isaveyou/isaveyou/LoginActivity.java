package kr.co.isaveyou.isaveyou;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.iid.FirebaseInstanceId;

public class LoginActivity extends AppCompatActivity {
    private static final String TAG = "LoginActivity";
    EditText etId, etPw;
    View.OnClickListener handler = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.login_button:
                    Login();
                    Log.v(TAG, "로그인 버튼 눌림");
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
            etPw.setError("입력하신 암호가 너무 짧습니다.");
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
            etId.setError("입력하신 사번이 너무 짧습니다."); //에러 발생시 text를 보여줌
            focusView = etId;
            cancel = true;
            Log.v(TAG, "너무 짧은 사번 입력");
        }else if (!TextUtils.isEmpty(id)&&!TextUtils.isEmpty(pw)){
            Intent intent = new Intent(this, MainActivity.class);
            String strId = id.valueOf(id);
            intent.putExtra("사번",strId);
            startActivity(intent);
            finish();
        }

        if(cancel){
            focusView.requestFocus();
        } else {
            
        }


    }
    // id, pw 길이 확인을 위한 method
    private boolean isPasswordVaild(String password){ //패스워드를 너무 짧게 입력한 경우를 확인하기 위한 method
        return password.length() > 4;
    }
    private boolean isIdVaild(String id){ //패스워드를 너무 짧게 입력한 경우를 확인하기 위한 method
        return id.length() > 4;
    }

    void getInstanceId(){ //앱을 설치한 기계의 instance Id를 얻기 위한 method
        Log.v(TAG, "id : " + FirebaseInstanceId.getInstance().getToken());
    }

}
