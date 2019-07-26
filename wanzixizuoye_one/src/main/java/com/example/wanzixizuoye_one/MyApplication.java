package com.example.wanzixizuoye_one;

import android.app.Application;
import android.content.Context;

import com.example.wanzixizuoye_one.dao.DaoMaster;
import com.example.wanzixizuoye_one.dao.DaoSession;

public class MyApplication extends Application {

    private static DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();

        initDB();
    }

    private void initDB() {
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(this, "food.db");

        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDb());

        daoSession = daoMaster.newSession();
    }
    public static DaoSession getDaoSession(){
        return daoSession;
    }
}
