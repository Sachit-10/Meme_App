package com.example.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object Retrofit_Instance {

    val retrofit by lazy{

        Retrofit.Builder().baseUrl("https://meme-api.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val apiinterface by lazy{
        retrofit.create(ApiInterface::class.java)
    }
}