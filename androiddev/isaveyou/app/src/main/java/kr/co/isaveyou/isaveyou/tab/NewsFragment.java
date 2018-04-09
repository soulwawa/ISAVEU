package kr.co.isaveyou.isaveyou.tab;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.JsonReader;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

import kr.co.isaveyou.isaveyou.R;


public class NewsFragment extends Fragment {
    private static final String TAG = "NewsFragment";
    ArrayList<HashMap<String,String>> newsList;
    String url = "http://pho901121.cafe24.com/login/db_get_notice_posts.php";
    private static final String TAG_RESULTS="posts";
    private static final String TAG_WRITER = "writer";
    private static final String TAG_TITLE = "title";
    private static final String TAG_DATE = "regist_day";
    private static final String TAG_CONTENT = "content";
    JSONArray posts = null;
    HttpURLConnection conn;
    String result;



    //UI관련
    private RecyclerView rv;
    private LinearLayoutManager mLinearLayoutManager;
    private OnFragmentInteractionListener mListener;

    public NewsFragment() {
        // Required empty public constructor
    }

    public static NewsFragment newInstance(String param1, String param2) {
        NewsFragment fragment = new NewsFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news, container, false);
        newsList = new ArrayList<HashMap<String, String>>();
        //adpater set해줌, 매니져와 연결시켜줌
        mLinearLayoutManager = new LinearLayoutManager(getActivity());
        mLinearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rv = (RecyclerView)view.findViewById(R.id.rv);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(mLinearLayoutManager);

//        //폰 내 db와 연결하여 uid 얻어와 보내기 - Fragment 이기 때문에 context가 getActivity()


        return view;
    }

   public void getData(String url){
        class GetDataJSON extends AsyncTask<String,Void,String>{
            @Override
            protected String doInBackground(String... strings) {
                String param = "&city:서울&country:종로구&village:적선동";
                Log.v(TAG, "param : " + param);
                try {
                    //서버 접속
                    URL url = new URL("https://api2.sktelecom.com/weather/current/minutely?version=1");
                    conn = (HttpURLConnection)url.openConnection();
                    conn.setRequestProperty("Content-type","application/json");
                    conn.setRequestMethod("GET");
                    conn.setDoInput(true);
                    conn.connect();
                    OutputStream outs = conn.getOutputStream();
                    outs.write(param.getBytes("UTF-8"));
                    outs.flush();
                    outs.close();
                    if(conn.getResponseCode()!=HttpURLConnection.HTTP_OK){

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
                    Log.v(TAG, "url : " + url );


                }catch (Exception e) {
                    e.printStackTrace();
                }
                return null;

            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
//                JsonReader jsonReader = new JsonReader();
            }
        }

   }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    /** JSON -> LIST 가공 메소드 **/
    public void makeList(String myJSON) {
        try {
            JSONObject jsonObj = new JSONObject(myJSON);
            posts = jsonObj.getJSONArray(TAG_RESULTS);
            for(int i=0; i<posts.length(); i++) {
                //JSON에서 각각의 요소를 뽑아옴
                JSONObject c = posts.getJSONObject(i);
                String title = c.getString(TAG_TITLE);
                String writer = c.getString(TAG_WRITER);
                String date = c.getString(TAG_DATE);
                String content = c.getString(TAG_CONTENT);
                if(content.length() > 50 ) {
                    content = content.substring(0,50) + "..."; //50자 자르고 ... 붙이기
                }
                if(title.length() > 16 ) {
                    title = title.substring(0,16) + "..."; //18자 자르고 ... 붙이기
                }

                //HashMap에 붙이기
                HashMap<String,String> posts = new HashMap<String,String>();
                posts.put(TAG_TITLE,title);
                posts.put(TAG_WRITER,writer);
                posts.put(TAG_DATE,date);
                posts.put(TAG_CONTENT, content);

                //ArrayList에 HashMap 붙이기
                newsList.add(posts);
            }
            //카드 리스트뷰 어댑터에 연결
            NewsAdapter adapter = new NewsAdapter(getActivity(),newsList);
            Log.e(TAG, "" + newsList.size());
            rv.setAdapter(adapter);
            adapter.notifyDataSetChanged();

        }catch(JSONException e) {
            e.printStackTrace();
        }
    }

}
