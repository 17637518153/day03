package com.example.lianxiti_one.fartroy;

import android.util.Log;

public class Rectangle implements Shape{
    private static final String TAG = "Rectangle";
    @Override
    public void drow() {
        System.out.println("这是一个矩形");
        Log.e(TAG, "drow: "+"这是一个矩形"  );
    }
}
