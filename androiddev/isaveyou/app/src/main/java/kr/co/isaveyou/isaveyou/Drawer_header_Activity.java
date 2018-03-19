//package kr.co.isaveyou.isaveyou;
//
//import android.content.Intent;
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.util.Log;
//import android.widget.TextView;
//
//public class Drawer_header_Activity extends AppCompatActivity {
//    private static final String TAG = "Drawer_header_Activity";
//    String strId;
//    TextView tvId;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.drawer_header);
//
//        tvId = findViewById(R.id.drawer_textId);
//        Intent intent = getIntent();
//        strId = intent.getStringExtra("사번");
//        Log.v(TAG, "사번 : " + strId);
//
//        tvId.setText(strId);
//
//        Intent intent_main = new Intent(this,MainActivity.class);
//    }
//}
