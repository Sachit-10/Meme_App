package com.example.retrofit

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {

    @GET("/gimme")
    fun getData(): Call<responsedataclass>
}