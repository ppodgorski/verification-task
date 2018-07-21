package com.ppodgorski.verificationtask.network;


import com.ppodgorski.verificationtask.model.Data;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiService {

    @POST("/")
    Call<Void> sendData(@Body Data data);

}
