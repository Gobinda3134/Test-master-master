package com.example.e_softwarica.network;

import com.google.gson.GsonBuilder;

import java.lang.reflect.Modifier;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;



public class ServiceGenerator {

    public static final String API = "https://esoftwaricabisu.000webhostapp.com/backend/api/records/";

    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

    public static <S> S createRequestGsonMITRA(Class<S> serviceClass)
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API)
                .addConverterFactory(GsonConverterFactory.create(
                        new GsonBuilder()
                                .excludeFieldsWithModifiers(Modifier.FINAL, Modifier.TRANSIENT, Modifier.STATIC)
                                .create()
                ))
                .client(httpClient.build())
                .build();
        return  retrofit.create(serviceClass);

    }






}
