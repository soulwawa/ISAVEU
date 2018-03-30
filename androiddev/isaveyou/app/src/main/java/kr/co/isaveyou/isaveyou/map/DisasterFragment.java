package kr.co.isaveyou.isaveyou.map;


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


import java.util.ArrayList;

import kr.co.isaveyou.isaveyou.R;


public class DisasterFragment extends android.support.v4.app.Fragment {
    private static final String TAG = "DisasterFragment";
    String place;
    ImageSwitcher is_601,is_602,is_603,is_604,is_606,is_607,is_608,is_609,is_610,is_600,is_605;
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
        is_601 = (ImageSwitcher) view.findViewById(R.id.is_waitingRoom_601);
        is_604 = (ImageSwitcher)view.findViewById(R.id.is_604);
        is_603 = (ImageSwitcher)view.findViewById(R.id.is_603);
        is_602 = (ImageSwitcher)view.findViewById(R.id.is_602);
        is_606 = (ImageSwitcher)view.findViewById(R.id.is_606);
        is_607 = (ImageSwitcher)view.findViewById(R.id.is_607);
        is_608 = (ImageSwitcher)view.findViewById(R.id.is_608);
        is_609 = (ImageSwitcher)view.findViewById(R.id.is_609);
        is_600 = (ImageSwitcher)view.findViewById(R.id.is_600);
        is_610 = (ImageSwitcher)view.findViewById(R.id.is_restRoom_610);

        Log.v(TAG,"place : " + place);

        switch (place){
            case "600" :
                switcherList.add(is_600);
            case "601" :
                switcherList.add(is_601);
            case "602" :
                switcherList.add(is_602);
            case "603" :
                switcherList.add(is_603);
            case "604" :
                switcherList.add(is_604);
            case "605" :
                switcherList.add(is_605);
            case "606" :
                switcherList.add(is_606);
            case "607" :
                switcherList.add(is_607);
            case "608" :
                switcherList.add(is_608);
            case "609" :
                switcherList.add(is_609);
            case "610" :
                switcherList.add(is_610);
            default:
                    break;
        }



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


        startCheckDisaster_Animation();



        return view;
    }
    private void startCheckDisaster_Animation(){
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
