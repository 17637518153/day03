package com.example.wanzixizuoye_one.api;

import com.example.wanzixizuoye_one.beans.FoodBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiService {


    String FOODURL = "http://www.qubaobei.com/";
    @GET("ios/cf/dish_list.php?stage_id=1&limit=20&page=1")
    Observable<FoodBean> getRxRetrofitFood();

}
