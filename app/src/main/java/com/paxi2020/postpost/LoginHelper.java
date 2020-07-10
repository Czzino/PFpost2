package com.paxi2020.postpost;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class LoginHelper {

    public static Retrofit getInstance(){
        Retrofit.Builder builder= new Retrofit.Builder();
        builder.baseUrl("http://fvwlharu.dothome.co.kr");
        builder.addConverterFactory(GsonConverterFactory.create());
        return builder.build();
    }

    public static Retrofit getInstance2(){
        Retrofit.Builder builder= new Retrofit.Builder();
        builder.baseUrl("http://fvwlharu.dothome.co.kr");
        builder.addConverterFactory(ScalarsConverterFactory.create());
        return builder.build();  //String 응답 Sclars
    }

}
