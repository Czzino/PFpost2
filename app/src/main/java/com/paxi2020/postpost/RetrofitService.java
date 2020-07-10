package com.paxi2020.postpost;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.PartMap;

public interface RetrofitService {


    @POST("/Register/insertDB. php")
    Call<String> postDataToBoard(@PartMap Map<String, String> dataPart);
}
