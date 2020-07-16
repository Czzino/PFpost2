package com.paxi2020.postpost;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.PartMap;

public interface RegisterService {

    @POST("/Post/Register.php")
    Call<String> postRegister(@PartMap Map<String, String> dataPart);
}
