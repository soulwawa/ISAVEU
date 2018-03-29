package kr.co.isaveyou.isaveyou.kr.co.isaveyou.isaveyou.map;


import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;
import android.widget.ViewSwitcher;
import java.util.ArrayList;


import kr.co.isaveyou.isaveyou.R;

//소화기 위치 확인을 위한 Fragment
public class Fire_extFragment extends android.support.v4.app.Fragment {
    private static final String TAG = "Fire_extFragment";
    ImageSwitcher fire_ext1, fire_ext2, fire_ext3, fire_ext4, fire_ext5, fire_ext6,  fire_ext7,  fire_ext8,  fire_ext9, fire_ext10, fire_ext11, fire_ext12;
    ProgressBar pb_hallway01, pb_601, pb_602, pb_603, pb_604,pb_605,pb_606,pb_607, pb_waitingRoom, pb_restRoom, pb_607_1;
    ArrayList<ImageSwitcher>switcherList = new ArrayList();
    Handler threadHandler = new Handler();
    ImageSwitcher switcher;
    boolean running;
    Thread thread;
    Button checkButton;
    ConstraintLayout layout_fire_ext1,layout_fire_ext2,layout_fire_ext3,layout_fire_ext4,layout_fire_ext5,layout_fire_ext6,layout_fire_ext7,layout_fire_ext8,layout_fire_ext9,layout_fire_ext10,layout_fire_ext11,layout_fire_ext12;



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
                    Log.v(TAG, "hallWay01_Fire_ext 눌림");
                    Toast.makeText(getContext(),"hallWay01_Fire_ext 눌림",Toast.LENGTH_SHORT).show();
                    layout_fire_ext1.setVisibility(View.VISIBLE);

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
        checkButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()){
                    case MotionEvent.ACTION_UP:
                        v.setBackgroundResource(R.drawable.mybutton);
                        break;
                    case MotionEvent.ACTION_CANCEL:
                        v.setBackgroundResource(R.drawable.mybutton);
                        break;
                    case MotionEvent.ACTION_DOWN:
                        v.setBackgroundResource(R.drawable.mybuttonpressed);
                }
                return false;
            }
        });
        checkButton.setOnClickListener(handler);

        fire_ext1 = view.findViewById(R.id.hallWay01_Fire_ext);
        fire_ext2 = view.findViewById(R.id.restRoom_Fire_ext);
        fire_ext3 = view.findViewById(R.id.room601_Fire_ext);
        fire_ext4 = view.findViewById(R.id.room602_Fire_ext);
        fire_ext5 = view.findViewById(R.id.room603_Fire_ext);
        fire_ext6 = view.findViewById(R.id.room604_Fire_ext);
        fire_ext7 = view.findViewById(R.id.room605_Fire_ext);
        fire_ext8 = view.findViewById(R.id.room606_Fire_ext);
        fire_ext9 = view.findViewById(R.id.room607_Fire_ext);
        fire_ext10 = view.findViewById(R.id.room607_1_Fire_ext);
        fire_ext11 = view.findViewById(R.id.waitingRoom_Fire_ext);

        fire_ext1.setOnClickListener(handler);
        fire_ext2.setOnClickListener(handler);
        fire_ext3.setOnClickListener(handler);
        fire_ext4.setOnClickListener(handler);
        fire_ext5.setOnClickListener(handler);
        fire_ext6.setOnClickListener(handler);
        fire_ext7.setOnClickListener(handler);
        fire_ext8.setOnClickListener(handler);
        fire_ext9.setOnClickListener(handler);
        fire_ext10.setOnClickListener(handler);
        fire_ext11.setOnClickListener(handler);

        switcherList.add(fire_ext1);
        switcherList.add(fire_ext2);
        switcherList.add(fire_ext3);
        switcherList.add(fire_ext4);
        switcherList.add(fire_ext5);
        switcherList.add(fire_ext6);
        switcherList.add(fire_ext7);
        switcherList.add(fire_ext8);
        switcherList.add(fire_ext9);
        switcherList.add(fire_ext10);
        switcherList.add(fire_ext11);

        pb_hallway01 = view.findViewById(R.id.pb_hallway01);
        pb_restRoom = view.findViewById(R.id.pb_restRoom);
        pb_601 = view.findViewById(R.id.pb_601);
        pb_602 = view.findViewById(R.id.pb_602);
        pb_603 = view.findViewById(R.id.pb_603);
        pb_604 = view.findViewById(R.id.pb_604);
        pb_605 = view.findViewById(R.id.pb_605);
        pb_606 = view.findViewById(R.id.pb_606);
        pb_607 = view.findViewById(R.id.pb_607);
        pb_607_1 = view.findViewById(R.id.pb_607_1);
        pb_waitingRoom = view.findViewById(R.id.pb_waitingRoom);

        pb_hallway01.setProgress(80);

        layout_fire_ext1 = view.findViewById(R.id.hallway01_cLayout);
        layout_fire_ext3 = view.findViewById(R.id.hallway01_cLayout);
        layout_fire_ext4 = view.findViewById(R.id.hallway01_cLayout);
        layout_fire_ext5 = view.findViewById(R.id.hallway01_cLayout);
        layout_fire_ext6 = view.findViewById(R.id.hallway01_cLayout);
        layout_fire_ext7 = view.findViewById(R.id.hallway01_cLayout);
        layout_fire_ext8 = view.findViewById(R.id.hallway01_cLayout);
        layout_fire_ext9 = view.findViewById(R.id.hallway01_cLayout);
        layout_fire_ext10 = view.findViewById(R.id.hallway01_cLayout);
        layout_fire_ext11 = view.findViewById(R.id.hallway01_cLayout);
        layout_fire_ext12 = view.findViewById(R.id.hallway01_cLayout);







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


    //존재하는 소화기위치 표시하는 애니메이션
    private void startCheckFire_ext_Animation(){
        for(int i = 0; i<switcherList.size();i++){
            switcher = switcherList.get(i);
            switcher.setVisibility(View.VISIBLE);

            thread = new ImageThread();
            thread.start();
        }
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
