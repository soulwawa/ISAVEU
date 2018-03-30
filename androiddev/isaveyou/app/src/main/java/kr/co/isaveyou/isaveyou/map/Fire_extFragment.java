package kr.co.isaveyou.isaveyou.map;


import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
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
public class Fire_extFragment extends Fragment {
    private static final String TAG = "Fire_extFragment";
    ImageSwitcher fire_ext1, fire_ext2, fire_ext3, fire_ext4, fire_ext5, fire_ext6,  fire_ext7,  fire_ext8,  fire_ext9, fire_ext10, fire_ext11, fire_ext12;
    ProgressBar pb_600, pb_601, pb_602, pb_603, pb_604,pb_605,pb_606,pb_607, pb_608, pb_609, pb_610;
    ArrayList<ImageSwitcher>switcherList = new ArrayList();
    Handler threadHandler = new Handler();
    ImageSwitcher switcher;
    boolean running;
    Thread thread;
    Button checkButton;
    ConstraintLayout layout_fire_ext1,layout_fire_ext2,layout_fire_ext3,layout_fire_ext4,layout_fire_ext5,layout_fire_ext6,layout_fire_ext7,layout_fire_ext8,layout_fire_ext9,layout_fire_ext10,layout_fire_ext11;



    View.OnClickListener handler = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.checkButton:
                    Log.v(TAG, "소화기 보기 눌림");
                    Toast.makeText(getContext(),"소화기 보기 눌림",Toast.LENGTH_SHORT).show();
                    startCheckFire_ext_Animation();
                    break;
                case R.id.room600_hallWay01_Fire_ext:
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

        fire_ext1 = view.findViewById(R.id.is_600);
        fire_ext2 = view.findViewById(R.id.is_waitingRoom_601);
        fire_ext3 = view.findViewById(R.id.is_602);
        fire_ext4 = view.findViewById(R.id.is_603);
        fire_ext5 = view.findViewById(R.id.is_604);
        fire_ext6 = view.findViewById(R.id.is_605);
        fire_ext7 = view.findViewById(R.id.is_606);
        fire_ext8 = view.findViewById(R.id.is_607);
        fire_ext9 = view.findViewById(R.id.is_608);
        fire_ext10 = view.findViewById(R.id.is_609);
        fire_ext11 = view.findViewById(R.id.is_restRoom_610);

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

        pb_600 = view.findViewById(R.id.pb_hallway_600);
        pb_610 = view.findViewById(R.id.pb_restRoom_610);
        pb_602 = view.findViewById(R.id.pb_602);
        pb_603 = view.findViewById(R.id.pb_603);
        pb_604 = view.findViewById(R.id.pb_604);
        pb_605 = view.findViewById(R.id.pb_605);
        pb_606 = view.findViewById(R.id.pb_606);
        pb_607 = view.findViewById(R.id.pb_607);
        pb_608 = view.findViewById(R.id.pb_608);
        pb_609 = view.findViewById(R.id.pb_609);
        pb_601 = view.findViewById(R.id.pb_waitingRoom_601);

        pb_600.setProgress(80);

        layout_fire_ext1 = view.findViewById(R.id.room600_hallway01_cLayout);
        layout_fire_ext2 = view.findViewById(R.id.room601_waitingroom_cLayout);
        layout_fire_ext3 = view.findViewById(R.id.room602_cLayout);
        layout_fire_ext4 = view.findViewById(R.id.room603_cLayout);
        layout_fire_ext5 = view.findViewById(R.id.room604_cLayout);
        layout_fire_ext6 = view.findViewById(R.id.room605_cLayout);
        layout_fire_ext7 = view.findViewById(R.id.room606_cLayout);
        layout_fire_ext8 = view.findViewById(R.id.room607_cLayout);
        layout_fire_ext9 = view.findViewById(R.id.room608_cLayout);
        layout_fire_ext10 = view.findViewById(R.id.room609_cLayout);
        layout_fire_ext11 = view.findViewById(R.id.restRoom610_cLayout);







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
