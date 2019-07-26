package com.example.wanzixizuoye_one;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.wanzixizuoye_one.adapters.MyAndCollectVpAdapter;
import com.example.wanzixizuoye_one.fragments.CollectFragment;
import com.example.wanzixizuoye_one.fragments.MyFragment;

import java.util.ArrayList;
//刘建鑫  小实训
public class MainActivity extends AppCompatActivity {

    /**
     * 我的
     */
    private TextView mMainTv;
    private Toolbar mMainToolbar;
    private ViewPager mMainVp;
    private RelativeLayout mMainRl;
    private TabLayout mMainTab;
    private LinearLayout mMainLL;
    private DrawerLayout mMainDrawer;
    private ArrayList<Fragment> fragments;
    private MyAndCollectVpAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initToolbar();
        initFragment();
    }

    private void initFragment() {
        fragments = new ArrayList<>();
        fragments.add(new MyFragment());
        fragments.add(new CollectFragment());
        adapter = new MyAndCollectVpAdapter(getSupportFragmentManager(), fragments);
        mMainVp.setAdapter(adapter);
        mMainTab.setupWithViewPager(mMainVp);
        mMainTab.getTabAt(0).setCustomView(R.layout.my_tablayout_layout);
        mMainTab.getTabAt(1).setCustomView(R.layout.collect_tablayout_layout);

        mMainTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:
                        mMainTv.setText("我的");
                        break;
                    case 1:
                        mMainTv.setText("收藏");
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void initToolbar() {
        mMainToolbar.setTitle("");
        setSupportActionBar(mMainToolbar);
    }

    private void initView() {
        mMainTv = (TextView) findViewById(R.id.mainTv);
        mMainToolbar = (Toolbar) findViewById(R.id.mainToolbar);
        mMainVp = (ViewPager) findViewById(R.id.mainVp);
        mMainRl = (RelativeLayout) findViewById(R.id.mainRl);
        mMainTab = (TabLayout) findViewById(R.id.mainTab);
        mMainLL = (LinearLayout) findViewById(R.id.mainLL);
        mMainDrawer = (DrawerLayout) findViewById(R.id.mainDrawer);
    }
}
