package com.example.wanzixizuoye_one.model;

import android.util.Log;

import com.example.wanzixizuoye_one.api.ApiService;
import com.example.wanzixizuoye_one.beans.DataBean;
import com.example.wanzixizuoye_one.beans.FoodBean;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class IModellist implements IModeljiekou{
    private static final String TAG = "IModellist";
    @Override
    public void getFoodlist(final ICallBack iCallBack) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiService.FOODURL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        ApiService apiService = retrofit.create(ApiService.class);

        apiService.getRxRetrofitFood()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<FoodBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(FoodBean foodBean) {
                        List<DataBean> fooddata = foodBean.getData();

                        iCallBack.updatachenggong(fooddata);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "onError: " + e.getMessage() );
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
