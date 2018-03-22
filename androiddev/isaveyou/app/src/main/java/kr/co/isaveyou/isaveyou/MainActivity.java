package kr.co.isaveyou.isaveyou;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.google.firebase.iid.FirebaseInstanceId;

import java.io.BufferedInputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    String strName, strPicUrl, strEmail;
    TextView tvName, tvEmail;
    ImageView profile;
    Bitmap profileImg;
    Animation FabOpen, FabClose, FabRClockwise, FabRanticlockWise;


    boolean isOpen=false;
    private FloatingActionButton fabMain, fab_map, fab_static, fab_montoring;

    private DrawerLayout mDrawerLayout;
    View.OnClickListener handler = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.fabMain:
                   if(!isOpen){
                       fab_map.startAnimation(FabOpen);
                       fab_static.startAnimation(FabOpen);
                       fab_montoring.startAnimation(FabOpen);
                       fabMain.startAnimation(FabRanticlockWise);
                       fab_map.setClickable(true);
                       fab_static.setClickable(true);
                       fab_montoring.setClickable(true);
                       isOpen = true;
                   }else{
                       fab_map.startAnimation(FabClose);
                       fab_static.startAnimation(FabClose);
                       fab_montoring.startAnimation(FabClose);
                       fabMain.startAnimation(FabRanticlockWise);
                       fab_map.setClickable(false);
                       fab_static.setClickable(false);
                       fab_montoring.setClickable(false);
                       isOpen = false;
                   }
//                case R.id.fab_map:
//                    Toast.makeText(getApplicationContext(),"fab_map 눌림",Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //floating action button 설정
        FabOpen = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fab_open);
        FabClose = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fab_close);
        FabRClockwise = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate_anticlockwise);
        FabRanticlockWise = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate_anticlockwise);
        fabMain = findViewById(R.id.fabMain);
        fab_map = findViewById(R.id.fab_map);
        fab_static = findViewById(R.id.fab_static);
        fab_montoring = findViewById(R.id.fab_montoring);

        fabMain.setOnClickListener(handler);
        fab_map.setOnClickListener(handler);
        fab_static.setOnClickListener(handler);
        fab_montoring.setOnClickListener(handler);


        //Login intent에서 전달한 내용을 받음
        Intent intent = getIntent();
        strName = intent.getStringExtra("이름");
        strPicUrl = intent.getStringExtra("프로필사진");
        strEmail = intent.getStringExtra("이메일");

        Log.v(TAG, "이름 : " + strName);
        Log.v(TAG, "프로필사진 : " + strPicUrl);
        Log.v(TAG, "이메일 : " + strEmail);



        //toolbar 액션 설정

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
        actionBar.setDisplayHomeAsUpEnabled(true);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation_view);

        View headerView = navigationView.getHeaderView(0);

        tvName = headerView.findViewById(R.id.drawer_textId);
        tvName.setText(strName);

        tvEmail = headerView.findViewById(R.id.tvEmail);
        tvEmail.setText(strEmail);

        //프로필 사진을 설정하게 하는 쓰레드 실행
        profile = headerView.findViewById(R.id.profileimage);
        ProfilePicTask profilePicTask = new ProfilePicTask();
        profilePicTask.execute(strPicUrl);



        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                menuItem.setChecked(true);
                mDrawerLayout.closeDrawers();

                int id = menuItem.getItemId();
                switch (id){
                    case R.id.nav_camera:
                        Toast.makeText(MainActivity.this,menuItem.getTitle(),Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_gallery:
                        Toast.makeText(MainActivity.this,menuItem.getTitle(),Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_slideshow:
                        Toast.makeText(MainActivity.this,menuItem.getTitle(),Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_manage:
                        Toast.makeText(MainActivity.this,menuItem.getTitle(),Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_share:
                        Toast.makeText(MainActivity.this,menuItem.getTitle(),Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_send:
                        Toast.makeText(MainActivity.this,menuItem.getTitle(),Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
            case R.id.action_settings:
                return true;
        }
        if (onOptionsItemSelected(item)==true){

        }

        return super.onOptionsItemSelected(item);
    }
    class ProfilePicTask extends AsyncTask<String, Integer, Bitmap>{
        @Override
        protected Bitmap doInBackground(String... urls) {
            //이미지 온라인 링크를 가져와 비트맵으로 바꿈
            try {
                URL url = new URL(urls[0]);
                URLConnection conn = (HttpURLConnection)url.openConnection();
                conn.setDoInput(true);
                conn.connect();
                BufferedInputStream bis = new BufferedInputStream(conn.getInputStream());
                profileImg = BitmapFactory.decodeStream(bis);


                Log.v(TAG, "url : " + url );
            }catch (Exception e) {
                e.printStackTrace();
            }

            return profileImg;
        }

        @Override
        protected void onPostExecute(Bitmap img) {
            //가져온 사진을 처리
            //프로필 사진 설정 - 사진 동그랗게 만드는 코드
            profile.setImageBitmap(profileImg);
            RoundedBitmapDrawable roundDrawable = RoundedBitmapDrawableFactory.create(getResources(), profileImg);
            roundDrawable.setCircular(true);
            profile.setImageDrawable(roundDrawable);
            super.onPostExecute(img);
        }
    }


}
