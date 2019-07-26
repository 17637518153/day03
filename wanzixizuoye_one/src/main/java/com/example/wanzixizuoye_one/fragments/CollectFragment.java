package com.example.wanzixizuoye_one.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wanzixizuoye_one.R;
import com.example.wanzixizuoye_one.adapters.MyAdapter;
import com.example.wanzixizuoye_one.beans.DataBean;
import com.example.wanzixizuoye_one.utils.DbUtil;

import java.util.ArrayList;
import java.util.List;

public class CollectFragment extends Fragment {
    private View view;
    private RecyclerView mRecyclerViewCo;
    private List<DataBean> foodlist;
    private MyAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.collect_fragment_layout, null);
        initView(view);
        return view;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            initData();
        }
    }

    private void initData() {
        List<DataBean> dataBeans = DbUtil.queryAll();
        foodlist.clear();
        foodlist.addAll(dataBeans);
        adapter.notifyDataSetChanged();
    }

    private void initView(View view) {
        mRecyclerViewCo = (RecyclerView) view.findViewById(R.id.RecyclerViewCo);
        //设置布局管理器
        mRecyclerViewCo.setLayoutManager(new LinearLayoutManager(getActivity()));
        //设置分割线
        mRecyclerViewCo.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
        //创建集合
        foodlist = new ArrayList<>();
        //创建适配器
        adapter = new MyAdapter(getActivity(), foodlist);
        mRecyclerViewCo.setAdapter(adapter);
    }
}
