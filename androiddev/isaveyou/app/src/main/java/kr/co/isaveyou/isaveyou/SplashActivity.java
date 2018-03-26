package kr.co.isaveyou.isaveyou;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import kr.co.isaveyou.isaveyou.kr.co.isaveyou.isaveyou.login.LoginActivity;

/*
    앱 실행시 첫 화면
 */

public class SplashActivity extends Activity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try{
            Thread.sleep(2000); //화면이 보여지는 시간
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        startActivity(new Intent(this,LoginActivity.class));
        finish();
    }
}
