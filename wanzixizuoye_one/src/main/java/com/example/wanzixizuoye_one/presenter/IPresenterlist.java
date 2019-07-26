package com.example.wanzixizuoye_one.presenter;

import com.example.wanzixizuoye_one.beans.DataBean;
import com.example.wanzixizuoye_one.model.ICallBack;
import com.example.wanzixizuoye_one.model.IModellist;
import com.example.wanzixizuoye_one.view.IView;

import java.util.List;

public class IPresenterlist implements IPresenterjiekou{


    private final IModellist iModellist;
    IView iView;

    public IPresenterlist(IView iView) {
        this.iView = iView;
        iModellist = new IModellist();
    }

    @Override
    public void getFooddlist() {
        iModellist.getFoodlist(new ICallBack() {
            @Override
            public void updatachenggong(List<DataBean> fooddata) {
                iView.updatachenggong(fooddata);
            }

            @Override
            public void updatashibai(String error) {
                iView.updatashibai(error);
            }
        });
    }
}
