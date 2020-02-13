package com.example.e_softwarica.api;

import com.example.e_softwarica.model.AssignmentReceiveParams;
import com.example.e_softwarica.model.NoticeReceiveParams;
import com.example.e_softwarica.model.RoutineReceiveParams;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface API {

    //@FormUrlEncoded
    //@POST("com/example/e_softwarica/api/v1/account/login")
    //Call<LoginSingupResponse> checkUser(@Field("username") String username , @Field("password") String password);

    //@FormUrlEncoded
    //@POST("com/example/e_softwarica/api/account/signup")
    //Call<Void> register(@Field("first_name") String first_name , @Field("last_name") String last_name,@Field("username") String username , @Field("password") String password);

    @POST("allassignment.js")
    Call<AssignmentReceiveParams> getAllAssignment();

    @POST("allnotice.js")
    Call<NoticeReceiveParams> getAllNotice();

    @POST("allroutine.js")
    Call<RoutineReceiveParams> getAllRoutine();


}
