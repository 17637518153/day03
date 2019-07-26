package com.example.wanzixizuoye_one.model;

import com.example.wanzixizuoye_one.beans.DataBean;

import java.util.List;

public interface ICallBack {
    void updatachenggong(List<DataBean> fooddata);
    void updatashibai(String error);
}
