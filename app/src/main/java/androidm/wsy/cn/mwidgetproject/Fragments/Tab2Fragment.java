package androidm.wsy.cn.mwidgetproject.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidm.wsy.cn.mwidgetproject.Models.MatchMode;
import androidm.wsy.cn.mwidgetproject.R;
import androidm.wsy.cn.mwidgetproject.adapters.MatchAdapter;
import cn.wsy.adapter.base.SuperRefreshLayout;


public class Tab2Fragment extends Fragment {

    private SuperRefreshLayout refreshLayout;
    private RecyclerView recyclerView;

    private MatchAdapter adapter;
    private List<MatchMode> data = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab2, container, false);
        initView(view);
        initData();
        return view;
    }

    private void initView(View view) {
        View headerView = LayoutInflater.from(getActivity()).inflate(R.layout.header_view_tab2,null);
        TextView titleTv = (TextView) headerView.findViewById(R.id.header_title_tv);
        TextView descTv = (TextView) headerView.findViewById(R.id.header_desc_tv);

        titleTv.setText("即将开始");
        descTv.setText("赛程和结果");

        refreshLayout = (SuperRefreshLayout) view.findViewById(R.id.refreshlayout);
        recyclerView = (RecyclerView) view.findViewById(R.id.tab2_recyclerview);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new MatchAdapter(getActivity(), data);
        adapter.addHeaderView(headerView);
        recyclerView.setAdapter(adapter);
    }

    private void initData(){
        for (int i =0;i<10;i++){
            MatchMode bean = new MatchMode();
            bean.setType((int) ((i+Math.random())%2));
            data.add(bean);
        }

        adapter.notifyDataSetChanged();
    }


}
