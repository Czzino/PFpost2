package com.paxi2020.postpost;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.PartMap;

public interface RetrofitService {

    @POST("/Post/Register.php")
    Call<RegisterItem> postRegister(@Body RegisterItem dataPart);
}
