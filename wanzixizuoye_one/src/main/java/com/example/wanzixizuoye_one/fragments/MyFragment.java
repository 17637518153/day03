package com.example.wanzixizuoye_one.fragments;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.wanzixizuoye_one.R;
import com.example.wanzixizuoye_one.WebActivity;
import com.example.wanzixizuoye_one.adapters.MyAdapter;
import com.example.wanzixizuoye_one.beans.DataBean;
import com.example.wanzixizuoye_one.beans.FoodBean;
import com.example.wanzixizuoye_one.presenter.IPresenterlist;
import com.example.wanzixizuoye_one.utils.DbUtil;
import com.example.wanzixizuoye_one.view.IView;

import java.util.ArrayList;
import java.util.List;

public class MyFragment extends Fragment implements IView {

    private View view;
    private RecyclerView mRecyclerView;
    private List<DataBean> foodlist;
    private MyAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.my_fragment_layout, null);
        initView(view);
        initData();
        return view;
    }

    private void initData() {
        IPresenterlist iPresenterlist = new IPresenterlist(this);
        iPresenterlist.getFooddlist();
    }

    private void initView(View view) {
        mRecyclerView = (RecyclerView) view.findViewById(R.id.RecyclerView);
        //设置布局管理器
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        //设置分割线
        mRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
        //创建集合
        foodlist = new ArrayList<>();
        //创建适配器
        adapter = new MyAdapter(getActivity(), foodlist);
        mRecyclerView.setAdapter(adapter);

        //接口回调
        adapter.setOnItemLongClickListener(new MyAdapter.OnItemLongClickListener() {
            @Override
            public void OnItemLongClick(final int i) {
                new AlertDialog.Builder(getActivity())
                        .setTitle("窗口")
                        .setMessage("是否插入数据库")
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                DbUtil.insert(foodlist.get(i));
                                adapter.notifyDataSetChanged();
                                Toast.makeText(getActivity(), "数据添加成功", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("取消",null)
                        .create()
                        .show();
            }

            @Override
            public void OnItemClick(int i) {
                DataBean bean = foodlist.get(i);
                String pic = bean.getPic();
                String title = bean.getTitle();
                Intent intent = new Intent(getActivity(), WebActivity.class);
                intent.putExtra("11",pic);
                intent.putExtra("22",title);
                startActivity(intent);
            }
        });
    }

    private static final String TAG = "MyFragment";
    @Override
    public void updatachenggong(List<DataBean> fooddata) {
        foodlist.addAll(fooddata);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void updatashibai(String error) {
        Log.e(TAG, "updatashibai: " + error );
    }
}
