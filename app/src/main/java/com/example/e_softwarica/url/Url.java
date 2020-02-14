package com.example.e_softwarica.url;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Url {
    public static final String BASE_URL ="http://digitalsoftwarica.000webhostapp.com/";
    public static  String token="";
    public static Retrofit getInstance(){
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Url.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build();

        return retrofit;
    }
}