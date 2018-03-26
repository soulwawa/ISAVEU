package kr.co.isaveyou.isaveyou.kr.co.isaveyou.isaveyou.map;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Fragment;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;
import android.widget.ViewSwitcher;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;


import kr.co.isaveyou.isaveyou.R;

//소화기 위치 확인을 위한 Fragment
public class Fire_extFragment extends android.support.v4.app.Fragment {
    private static final String TAG = "Fire_extFragment";
    ImageSwitcher fire_ext1, fire_ext2, fire_ext3, fire_ext4, fire_ext5, fire_ext6,  fire_ext7,  fire_ext8,  fire_ext9, fire_ext10, fire_ext11, fire_ext12;
    ArrayList<ImageSwitcher>switcherList = new ArrayList();
    ArrayList<ImageView> imageViews = new ArrayList();
    Handler threadHandler = new Handler();
    ImageSwitcher switcher;
    boolean running;
    Thread thread;
    Button checkButton;

    View.OnClickListener handler = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.checkButton:
                    Log.v(TAG, "소화기 보기 눌림");
                    Toast.makeText(getContext(),"소화기 보기 눌림",Toast.LENGTH_SHORT).show();
                    startCheckFire_ext_Animation();
                    break;
                case R.id.hallWay01_Fire_ext:

                    break;
            }
        }
    };

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fire_ext,null);

        checkButton = view.findViewById(R.id.checkButton);
        checkButton.setOnClickListener(handler);
        fire_ext1 = view.findViewById(R.id.hallWay01_Fire_ext);
        fire_ext2 = view.findViewById(R.id.hallWay02_Fire_ext);
        fire_ext3 = view.findViewById(R.id.restRoom_Fire_ext);
        fire_ext4 = view.findViewById(R.id.room601_Fire_ext);
        fire_ext5 = view.findViewById(R.id.room602_Fire_ext);
        fire_ext6 = view.findViewById(R.id.room603_Fire_ext);
        fire_ext7 = view.findViewById(R.id.room604_Fire_ext);
        fire_ext8 = view.findViewById(R.id.room605_Fire_ext);
        fire_ext9 = view.findViewById(R.id.room606_Fire_ext);
        fire_ext10 = view.findViewById(R.id.room607_Fire_ext);
        fire_ext11 = view.findViewById(R.id.room607_1_Fire_ext);
        fire_ext12 = view.findViewById(R.id.waitingRoom_Fire_ext);

        switcherList.add(fire_ext1);
        switcherList.add(fire_ext2);
        switcherList.add(fire_ext3);
        switcherList.add(fire_ext4);
        switcherList.add(fire_ext5);
        switcherList.add(fire_ext6);
        switcherList.add(fire_ext7);


        for(int i= 0; i<switcherList.size();i++) {
            switcher = switcherList.get(i);
            switcher.setFactory(new ViewSwitcher.ViewFactory() {
                @Override
                public View makeView() {
                    ImageView imageView = new ImageView(getContext());

                    imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                    imageView.setLayoutParams(new ImageSwitcher.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

                    return imageView;
                }
            });
        }


        return view;
    }


    //존재하는 소화기위치 표시
    private void startCheckFire_ext_Animation(){
        switcher.setVisibility(View.VISIBLE);

        thread = new ImageThread();
        thread.start();
        Log.v(TAG, "소화기 체크 애니메이션 시작");
    }
    private void stopCheckFire_ext_Animation(){
        running = false;
        try{
            thread.join();
        }catch(InterruptedException e){
            e.printStackTrace();
        }

        switcher.setVisibility(View.INVISIBLE);
        Log.v(TAG, "소화기 체크 애니메이션 멈춤");
    }
    class ImageThread extends Thread{
        int duration = 250;
        final int imageId[] = {R.drawable.pic_fire_ext, R.drawable.pic_fire_ext_red, R.drawable.pic_fire_ext_orange};
        int currentIndex = 0;

        public void run(){
            running = true;
            Log.v(TAG, "Image Thread 시작");
            while (running){
                synchronized (this){
                    threadHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            switcher.setImageResource(imageId[currentIndex]);
                        }
                    });
                    currentIndex++;
                    if(currentIndex == imageId.length){
                        currentIndex = 1;
                    }
                    try{
                        Thread.sleep(duration);
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}
