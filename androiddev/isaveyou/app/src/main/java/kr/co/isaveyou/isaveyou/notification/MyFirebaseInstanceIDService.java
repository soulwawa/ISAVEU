package kr.co.isaveyou.isaveyou.notification;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

public class MyFirebaseInstanceIDService extends FirebaseInstanceIdService {
    //쿨라우드 서버에 단말을 등록하는 역할을 담당
    //onTokenRefresh()메소드를 재정의하면 전달받은 등록 ID를 확인할 수 있음
    private static final String TAG = "MyFirebaseIIDService";

    @Override
    public void onTokenRefresh() {
        super.onTokenRefresh();
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Log.v(TAG, "Refreshed token" + refreshedToken);

        //생성 등록된 토큰을 개인 앱서버에 보내 저장해 두었다가 추가로 뭔가를 하고 싶으면 할 수 있게 한다.
        sendRegistrationToServer(refreshedToken);
    }

    private void sendRegistrationToServer(String token){
        //서버에 인증 Instance ID 등록하기
        ServerUtilities.register(this,token);
        //SharedPreference 객체에 id 저장

    }


}
