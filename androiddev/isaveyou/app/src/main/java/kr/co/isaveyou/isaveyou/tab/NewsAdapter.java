package kr.co.isaveyou.isaveyou.tab;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

import kr.co.isaveyou.isaveyou.R;
import kr.co.isaveyou.isaveyou.main.MainActivity;


public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {
    private static final String TAG = "NewsAdapter";
    Context context;
    ArrayList<HashMap<String, String>> newsList; // 공지사항 정보 담겨 있음
    public NewsAdapter(Context context,ArrayList<HashMap<String,String>>newsList){
        this.context = context;
        this.newsList = newsList;
    }
    // 새로운 뷰 생성
    @Override
    public NewsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //recycler view에 반복될 아이템 레이아웃 연결

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_item_list_news,null);
        return new ViewHolder(v);
    }
    //타겟 api 설정 - 이걸 지정해주지 않으면 카드뷰가 보이지 않음(버전에 영향을 받음)
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)


    //정보 및 이벤트 처리는 이 메소드에서 구현
//    Adapter를 생성할 때 데이터를 담은 ArrayList<...>를 인자로 받아서
//    onBindViewHolder()에서 하나하나를 처리한다
    @Override
    public void onBindViewHolder(final NewsAdapter.ViewHolder holder, int position) {

        final int pos = position;
        //정보 다듬기


        HashMap<String,String> noticeItem = newsList.get(position);
        holder.tv_writer.setText(noticeItem.get("writer")); //작성자
        Log.v(TAG, "onBindViewHolder");
        holder.tv_title.setText(noticeItem.get("title")); //제목
        holder.tv_content.setText(noticeItem.get("content")); //내용 일부
        holder.tv_date.setText(noticeItem.get("regist_day")); //작성일
        holder.cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, MainActivity.class);
//                i.putExtra()
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.newsList.size();
    }

    //item layout 불러오기 - 사용할 UI 요소를 초기화 시켜줌
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tv_title;
        TextView tv_date;
        TextView tv_content;
        TextView tv_writer;
        CardView cv;
        public ViewHolder(View v){
            super(v);
            tv_title = (TextView) v.findViewById(R.id.tv_title);
            tv_date = (TextView) v.findViewById(R.id.tv_date);
            tv_content = (TextView) v.findViewById(R.id.tv_content);
            tv_writer = (TextView) v.findViewById(R.id.tv_writer);
            cv = (CardView) v.findViewById(R.id.cv_card);
        }
    }
}

