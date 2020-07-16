package com.paxi2020.postpost;

import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class RegisterHelper {

    public static Retrofit getInstance(){
        Retrofit.Builder builder= new Retrofit.Builder();
        builder.baseUrl("http://fvwlharu.dothome.co.kr");
        builder.addConverterFactory(ScalarsConverterFactory.create());
        return builder.build();
    }
}
