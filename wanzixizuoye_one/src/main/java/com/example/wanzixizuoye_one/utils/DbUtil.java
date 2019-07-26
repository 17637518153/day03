package com.example.wanzixizuoye_one.utils;

import android.util.Log;

import com.example.wanzixizuoye_one.MyApplication;
import com.example.wanzixizuoye_one.beans.DataBean;
import com.example.wanzixizuoye_one.dao.DaoSession;
import com.example.wanzixizuoye_one.dao.DataBeanDao;

import java.util.List;

public class DbUtil {
    private static final String TAG = "DbUtil";
    //添加数据
    public static void insert(DataBean dblist){
        DaoSession daoSession = MyApplication.getDaoSession();
        DataBean queryItem = queryItem(dblist.getTitle());
        if (queryItem == null) {
            daoSession.insert(dblist);
        } else {
            Log.e(TAG, "insert: 数据已存在" );
        }
    }
    //查询单个数据
    public static DataBean queryItem(String title){
        DaoSession daoSession = MyApplication.getDaoSession();
        DataBean dataBean = daoSession.queryBuilder(DataBean.class)
                .where(DataBeanDao.Properties.Title.eq(title))
                .build()
                .unique();

        return dataBean;
    }
    //查询全部数据
    public static List<DataBean> queryAll(){
        DaoSession daoSession = MyApplication.getDaoSession();
        return daoSession.loadAll(DataBean.class);
    }
}
