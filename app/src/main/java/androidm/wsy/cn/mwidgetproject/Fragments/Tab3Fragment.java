package androidm.wsy.cn.mwidgetproject.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.TextHttpResponseHandler;

import java.util.ArrayList;
import java.util.List;

import androidm.wsy.cn.mwidgetproject.Models.ResponseNew;
import androidm.wsy.cn.mwidgetproject.R;
import androidm.wsy.cn.mwidgetproject.activitys.WebActivity;
import androidm.wsy.cn.mwidgetproject.adapters.Tab3Apater;
import cn.wsy.adapter.base.SuperRefreshLayout;
import cn.wsy.adapter.interfaces.OnItemClickListener;
import cn.wsy.generallib.httplib.utils.JsonParseUtil;
import cz.msebera.android.httpclient.Header;

public class Tab3Fragment extends Fragment {

    private RecyclerView recyclerView;
    private SuperRefreshLayout refreshLayout;
    private Tab3Apater adapter;

    private List<ResponseNew.NewInfo> re_data = new ArrayList<>();
    private int page = 1;

    public Tab3Fragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_tab3, container, false);
        initView(view);
        initListener();
        return view;
    }

    private void initView(View view){
        recyclerView = (RecyclerView) view.findViewById(R.id.tab3_recyclerview);
        refreshLayout = (SuperRefreshLayout) view.findViewById(R.id.refreshlayout);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        adapter = new Tab3Apater(getActivity(),re_data);
        adapter.addHeaderView(LayoutInflater.from(getActivity()).inflate(R.layout.header_item_tab3_layout,null));
        recyclerView.setAdapter(adapter);
       getNewFromServer(page);
    }

    private void initListener(){
        refreshLayout.setOnRefreshListener(new SuperRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                page = 1;
                getNewFromServer(page);
            }

            @Override
            public void onLoadMore() {
                page++;
                getNewFromServer(page);
            }
        });

        adapter.setClickListener(new OnItemClickListener() {
            @Override
            public void onclick(View view, int position) {
                Intent intent = new Intent(getActivity(), WebActivity.class);
                intent.putExtra("url",re_data.get(position).getUrl());
                startActivity(intent);
            }
        });
    }

//    private void initData(){
//        for (int i = 0;i<10;i++){
//            if (i%2== 0) {
//                data.add("2016年8月11日\n\n I am a developer of sy.wu");
//            }else{
//                data.add("2016年8月11日\n\n I am a developer of sy.wu,My jianshu address is \"http://www.jianshu.com/users/d388bcf9c4d3/latest_articles\"");
//            }
//        }
//        adapter.notifyDataSetChanged();
//    }

    public void getNewFromServer(final int page) {
        try {
            //  http://apis.baidu.com/txapi/tiyu/tiyu
            AsyncHttpClient client = new AsyncHttpClient();
            client.addHeader("apikey", "");
            RequestParams enetity = new RequestParams();
            enetity.add("num", String.valueOf(10));
            enetity.add("page", String.valueOf(page));
            client.get(getActivity(), "http://apis.baidu.com/txapi/tiyu/tiyu", enetity, new TextHttpResponseHandler() {
                @Override
                public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                    adapter.stopLoadMore();
                    Toast.makeText(getActivity(),"请稍后重新加载!", Toast.LENGTH_LONG).show();
                }

                @Override
                public void onSuccess(int statusCode, Header[] headers, String responseString) {
                    refreshLayout.setRefreshing(false);
                    refreshLayout.setRefreshing(false);
                    ResponseNew rsp = JsonParseUtil.jsonToMode(responseString, ResponseNew.class);
                    List<ResponseNew.NewInfo> tmp = rsp.getNewslist();
                    if (tmp == null ) return ;
                    if (tmp.size() > 0) {

                            if (page == 1) adapter.removeAll(re_data);
                            adapter.addAll(tmp);
                    } else {
                            re_data = tmp;
                        adapter.stopLoadMore();
                    }
                }
            });

        } catch (Exception e) {
            Toast.makeText(getActivity(), e.getMessage().toString(), Toast.LENGTH_LONG).show();
        }
    }

}
