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

import androidm.wsy.cn.mwidgetproject.Models.MedalBean;
import androidm.wsy.cn.mwidgetproject.R;
import androidm.wsy.cn.mwidgetproject.adapters.MedalAdapter;
import cn.wsy.adapter.base.SuperRefreshLayout;

public class Tab1Fragment extends Fragment {

    private SuperRefreshLayout refreshLayout;
    private RecyclerView recyclerView;

    private MedalAdapter adapter;
    private List<MedalBean> data = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab1, container, false);
        initView(view);
        initData();
        return view;
    }

    private void initView(View view) {
        View headerView = LayoutInflater.from(getActivity()).inflate(R.layout.header_item_tab3_layout,null);
        TextView titleTv = (TextView) headerView.findViewById(R.id.header_title_tv);
        TextView descTv = (TextView) headerView.findViewById(R.id.header_desc_tv);

        titleTv.setText("奖牌数");
        descTv.setText("奖牌总数");

        refreshLayout = (SuperRefreshLayout) view.findViewById(R.id.refreshlayout);
        recyclerView = (RecyclerView) view.findViewById(R.id.tab1_recyclerview);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new MedalAdapter(getActivity(), data);
        adapter.addHeaderView(headerView);
        recyclerView.setAdapter(adapter);
    }

    private void initData(){
        for (int i =0;i<10;i++){
            MedalBean bean = new MedalBean();
            data.add(bean);
        }

        adapter.notifyDataSetChanged();
    }

}
