package kr.co.isaveyou.isaveyou;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.VideoView;

//스트리밍을 위한 Fragment
public class MonitoringFragment extends android.support.v4.app.Fragment {
    VideoView videoView_Monitoring;
    TextView tv_monitoring;
    Button btn_back, btn_stop;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_monitoring,null);
        tv_monitoring = (TextView)view.findViewById(R.id.tv_monitoring);

        return view;


    }
}
