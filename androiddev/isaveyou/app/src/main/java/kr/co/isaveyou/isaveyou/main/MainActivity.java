package kr.co.isaveyou.isaveyou.main;


import android.app.Activity;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import android.graphics.Color;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;

import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.widget.FrameLayout;
import android.widget.ImageView;
import android.support.v7.widget.SearchView;
import android.widget.TextView;

import android.support.v7.widget.Toolbar;
import android.widget.Toast;
import android.widget.SearchView.OnQueryTextListener;

import com.getbase.floatingactionbutton.FloatingActionsMenu;
import com.squareup.otto.Bus;


import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;

import kr.co.isaveyou.isaveyou.R;
import kr.co.isaveyou.isaveyou.issue.FloorMapActivity;
import kr.co.isaveyou.isaveyou.issue.Static_webViewFragment;
import kr.co.isaveyou.isaveyou.tab.InformationFragment;
import kr.co.isaveyou.isaveyou.tab.myMapFragment;
import kr.co.isaveyou.isaveyou.tab.NewsFragment;
import kr.co.isaveyou.isaveyou.voice.VoiceActivity;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    String strName, strPicUrl, strEmail, result, eventCheck, event, streamingServer_url, streamingServer_access ;
    TextView tvName, tvEmail;
    ImageView profile;
    Bitmap profileImg;
    FrameLayout fl_streaming,fl_static_fire_ext;
    SearchView searchView;
    private DrawerLayout mDrawerLayout;

//    private RequestQueue mRequestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //

        //상태바 바꾸기
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setStatusBarColor(Color.rgb(36, 223, 145));
        }
//        LayoutInflater inflater = getLayoutInflater();
//        View layout = inflater.inflate(R.layout.fragment_monitoring, null);

        fl_streaming = (FrameLayout)findViewById (R.id.streming_framelayout);
//        fl_streaming.bringToFront();
        fl_static_fire_ext = (FrameLayout)findViewById(R.id.static_framelayout);
        fl_static_fire_ext.bringToFront();
        //tab 레이아웃 설정, adapter 설정
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tl_tabs);
        ViewPager viewPager = (ViewPager)findViewById(R.id.viewpager);
        Fragment[] arrFragments = new Fragment[3];
        arrFragments[0] = new myMapFragment();
        arrFragments[1] = new NewsFragment();
        arrFragments[2] = new InformationFragment();

        MyPagerAdapter pagerAdapter = new MyPagerAdapter(getSupportFragmentManager(),arrFragments);
        viewPager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

        Fragment NewsFragment = new NewsFragment();


        //floating action button 설정
        final FloatingActionsMenu menuMultipleActions = (FloatingActionsMenu) findViewById(R.id.multiple_actions);
//        FloatingActionsMenu.collapse(); // close the menu
//        FloatingActionsMenu.toggle(); // toggle the menu
//        FloatingActionsMenu.expand(); // open the menu
        findViewById(R.id.fab_streaming).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StreamingTask streamingtask = new StreamingTask();
                streamingtask.execute();
                fl_streaming.setVisibility(View.VISIBLE);
                menuMultipleActions.collapse();
                fl_streaming.bringToFront();
                Log.v(TAG, "스트리밍 버튼 클릭");
            }
        });
        findViewById(R.id.fab_map).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), FloorMapActivity.class);
                intent.setData(Uri.parse("1/000"));
                startActivity(intent);

                Log.v(TAG, "맵 버튼 클릭");
            }
        });
        findViewById(R.id.fab_voice_recognition).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"음성인식 클릭",Toast.LENGTH_SHORT).show();
                Intent it_voiceRecord = new Intent(getApplicationContext(),VoiceActivity.class);
                startActivity(it_voiceRecord);
                menuMultipleActions.collapse();
                Log.v(TAG, "음성인식 버튼 클릭");

            }
        });
        Intent intent = getIntent();
        eventCheck = intent.getDataString();
        String [] sArray = eventCheck.split("/");
        event = sArray[0];
        if(event.equals("0")) {
            //Login intent에서 전달한 내용을 받음
            Intent it_login = getIntent();
            strName = it_login.getStringExtra("이름");
            strPicUrl = it_login.getStringExtra("프로필사진");
            strEmail = it_login.getStringExtra("이메일");

            Log.v(TAG, "이름 : " + strName);
            Log.v(TAG, "프로필사진 : " + strPicUrl);
            Log.v(TAG, "이메일 : " + strEmail);
        }else if(event.equals("1")){
            StreamingTask streamingtask = new StreamingTask();
            streamingtask.execute();
        }



        //toolbar 액션 설정

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayHomeAsUpEnabled(true);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation_view);

        View headerView = navigationView.getHeaderView(0);

        tvName = headerView.findViewById(R.id.drawer_textId);
        tvName.setText(strName);

        tvEmail = headerView.findViewById(R.id.tvEmail);
        tvEmail.setText(strEmail);

        //프로필 사진을 설정하게 하는 쓰레드 실행
        profile = headerView.findViewById(R.id.profile_image);
        ProfilePicTask profilePicTask = new ProfilePicTask();
        profilePicTask.execute(strPicUrl);


        //drawer에 있는 메뉴 관련 액션
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                menuItem.setChecked(true);
                mDrawerLayout.closeDrawers();
                menuMultipleActions.collapse();
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
                        menuItem.setChecked(false);
                        break;
                    case R.id.nav_send:
                        Toast.makeText(MainActivity.this,menuItem.getTitle(),Toast.LENGTH_SHORT).show();
                        menuItem.setChecked(false);
                        break;
                    case R.id.nav_voice_record:
                        Toast.makeText(MainActivity.this,menuItem.getTitle(),Toast.LENGTH_SHORT).show();
                        menuItem.setChecked(false);
                        Intent it_voiceRecord = new Intent(getApplicationContext(),VoiceActivity.class);
                        startActivity(it_voiceRecord);
                        break;
                }
                return true;
            }
        });
    }
    //Streaming layout set invisible 하기
    public  void Invisible_Streaming (){
        fl_streaming.setVisibility(View.INVISIBLE);
       mDrawerLayout.bringToFront();
    }

    //탭 어댑터 설정
    private class MyPagerAdapter extends FragmentPagerAdapter {
        private Fragment[] arrFragments;

        public MyPagerAdapter(FragmentManager fm, Fragment[] arrFragments) {
            super(fm);
            this.arrFragments = arrFragments;
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    fl_streaming.setVisibility(View.INVISIBLE);
                    return arrFragments[0];
                case 1:
                    fl_streaming.setVisibility(View.INVISIBLE);
                    return arrFragments[1];
                case 2:
                    fl_streaming.setVisibility(View.INVISIBLE);
                    return arrFragments[2];
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return arrFragments.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "주변 지도";
                case 1:
                    return "날씨";
                case 2:
                    return "주소록";
                default:
                    return null;

            }
        }
    }
    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
    }
    //타이틀 바에 있는 버튼의 메뉴 생성
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        getMenuInflater().inflate(R.menu.search_view_menu, menu);

        //searchview 정의
        MenuItem searchItem = menu.findItem(R.id.action_search);
        searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        SearchManager searchManager = (SearchManager)getSystemService(Context.SEARCH_SERVICE);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));


        //searchview 검색어 입력/검색 이벤트 처리
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        return true;
    }
    //타이틀 바에 있는 버튼 클릭했을 때의 액션
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

        return super.onOptionsItemSelected(item);
    }


    //프로필 사진 요청
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

    //스트리밍 요청
    class StreamingTask extends AsyncTask<String, Void, String>{
        @Override
        protected String doInBackground(String... strings) {
            String param = "act_st=1";
            Log.v(TAG, "param : " + param);

            HttpURLConnection conn = null;
            try{
                /*서버연결*/
                URL url = new URL("http://192.168.0.35:9999/Android/Streaming.do?");
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

            }catch(MalformedURLException |ProtocolException e){
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

            Log.v(TAG, "result in  : " + result);
            Log.v(TAG, "onPostExecute streamingServer_url :" + streamingServer_url + ",streamingServer_access :" + streamingServer_access);

            try{
                String streamingServer_url = null;
                String streamingServer_access = null;



                JSONObject jsonObject = new JSONObject(result);

                streamingServer_access = jsonObject.getString("streaming_access");
                streamingServer_url = jsonObject.getString("streamingServer_url");


                Log.v(TAG, "streamingServer_url : " + streamingServer_url);
                Log.v(TAG, "streamingServer_access : " + streamingServer_access);


                if(!streamingServer_access.equals("0")){

                    String streaming_url = streamingServer_url;
                    String streaming_access = streamingServer_access;

                    MonitoringFragment fragment = new MonitoringFragment();
                    Bundle bundle = new Bundle(2);
                    bundle.putString("streamingServer_access",streaming_url);
                    bundle.putString("streamingServer_url",streaming_access);
                    fragment.setArguments(bundle);
                    Log.v(TAG,"스트리밍서버 내용 받음");
                    Log.v(TAG,"번들 : "+ bundle);
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.replace(R.id.streming_framelayout,fragment);

                    fragmentTransaction.commit();
                }else {
                    Toast.makeText(getApplicationContext(),"스트리밍 서버 접속실패", Toast.LENGTH_SHORT).show();
                    Log.v(TAG, "스트리밍 서버 접속실패 : null");

                }

//

            }catch (JSONException e){
                e.printStackTrace();
            }

        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        fl_streaming.setVisibility(View.INVISIBLE);
    }
}


