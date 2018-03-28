package kr.co.isaveyou.isaveyou.kr.co.isaveyou.isaveyou.map;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import kr.co.isaveyou.isaveyou.R;


public class DisasterFragment extends android.support.v4.app.Fragment {
    private static final String TAG = "DisasterFragment";
    String place;
    ImageView iv_601,iv_602,iv_603,iv_604,iv_605,iv_606,iv_607,iv_607_1,iv_hallway,iv_restRoon,iv_waitingRoom;
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
        View view = inflater.inflate(R.layout.fragment_fire_ext,null);
        iv_601 = (ImageView) view.findViewById(R.id.iv_601);
        iv_602 = (ImageView)view.findViewById(R.id.iv_602);
        iv_603 = (ImageView)view.findViewById(R.id.iv_603);
        iv_604 = (ImageView)view.findViewById(R.id.iv_604);
        iv_605 = (ImageView)view.findViewById(R.id.iv_605);
        iv_606 = (ImageView)view.findViewById(R.id.iv_606);
        iv_607 = (ImageView)view.findViewById(R.id.iv_607);
        iv_607_1 = (ImageView)view.findViewById(R.id.iv_607_1);
        iv_hallway = (ImageView)view.findViewById(R.id.iv_hallway);
        iv_restRoon = (ImageView)view.findViewById(R.id.iv_restRoom);
        iv_waitingRoom = (ImageView)view.findViewById(R.id.iv_waitingRoom);
//        Glide.with(this).load(R.drawable.emoticon_fire).into(iv_601);
        Log.v(TAG,"place : " + place);

        switch(place){
            case "601":
                Log.v(TAG,"place : " +place);
            case "602" :
                break;
        }


        return view;
    }
}
