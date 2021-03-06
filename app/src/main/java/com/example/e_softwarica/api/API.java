package com.example.e_softwarica.api;

import com.example.e_softwarica.model.AssignmentReceiveParams;
import com.example.e_softwarica.model.NoticeReceiveParams;
import com.example.e_softwarica.model.RoutineReceiveParams;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface API {

    @POST("allassignment.php")
    Call<AssignmentReceiveParams> getAllAssignment();

    @POST("allnotice.php")
    Call<NoticeReceiveParams> getAllNotice();

    @POST("allroutine.php")
    Call<RoutineReceiveParams> getAllRoutine();


}
