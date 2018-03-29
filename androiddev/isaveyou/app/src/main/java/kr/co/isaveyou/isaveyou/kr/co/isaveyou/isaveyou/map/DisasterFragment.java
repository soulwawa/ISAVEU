package kr.co.isaveyou.isaveyou.kr.co.isaveyou.isaveyou.map;


import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;


import com.bumptech.glide.Glide;

import java.util.ArrayList;

import kr.co.isaveyou.isaveyou.R;


public class DisasterFragment extends android.support.v4.app.Fragment {
    private static final String TAG = "DisasterFragment";
    String place;
    ImageSwitcher iv_601,iv_602,iv_603,iv_604,iv_605,iv_606,iv_607,iv_607_1,iv_hallway,iv_restRoom,iv_waitingRoom;
    ImageSwitcher switcher;
    ArrayList<ImageSwitcher> switcherList = new ArrayList();
    Thread thread;
    boolean running;
    Handler threadHandler = new Handler();
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = this.getArguments();
        Log.v(TAG,bundle+"");
        if(bundle != null) {
            place = bundle.getString("place");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_disaster,null);
        iv_601 = (ImageSwitcher) view.findViewById(R.id.iv_601);
        iv_602 = (ImageSwitcher)view.findViewById(R.id.iv_602);
        iv_603 = (ImageSwitcher)view.findViewById(R.id.iv_603);
        iv_604 = (ImageSwitcher)view.findViewById(R.id.iv_604);
        iv_605 = (ImageSwitcher)view.findViewById(R.id.iv_605);
        iv_606 = (ImageSwitcher)view.findViewById(R.id.iv_606);
        iv_607 = (ImageSwitcher)view.findViewById(R.id.iv_607);
        iv_607_1 = (ImageSwitcher)view.findViewById(R.id.iv_607_1);
        iv_hallway = (ImageSwitcher)view.findViewById(R.id.iv_hallway);
        iv_restRoom = (ImageSwitcher)view.findViewById(R.id.iv_restRoom);
        iv_waitingRoom = (ImageSwitcher)view.findViewById(R.id.iv_waitingRoom);
        Log.v(TAG,"place : " + place);

        switcherList.add(iv_601);
        switcherList.add(iv_602);
        switcherList.add(iv_603);
        switcherList.add(iv_604);
        switcherList.add(iv_605);
        switcherList.add(iv_606);
        switcherList.add(iv_607);
        switcherList.add(iv_607_1);
        switcherList.add(iv_hallway);
        switcherList.add(iv_restRoom);
        switcherList.add(iv_waitingRoom);

        Log.v(TAG, switcherList+"");

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

        switch(place){
            case "601":
                Log.v(TAG,"place : " +place);
                    startCheckFire_ext_Animation();
            case "602" :
                break;
        }


        return view;
    }
    private void startCheckFire_ext_Animation(){
        for(int i = 0; i<switcherList.size();i++){
            switcher = switcherList.get(i);
            switcher.setVisibility(View.VISIBLE);

            thread = new ImageThread();
            thread.start();
        }
        Log.v(TAG, "소화기 체크 애니메이션 시작");
    }
    class ImageThread extends Thread{
        int duration = 250;
        final int imageId[] = {R.drawable.ani_flame_1, R.drawable.ani_flame_2, R.drawable.ani_flame_3,R.drawable.ani_flame_4};
        int currentIndex = 0;

        public void run(){
            running = true;
            Log.v(TAG, "Image Thread 시작");
            while (running){
                synchronized (this){
                    threadHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            for(int i = 0; i<switcherList.size();i++){
                                switcher = switcherList.get(i);
                                switcher.setImageResource(imageId[currentIndex]);
                            }}
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
