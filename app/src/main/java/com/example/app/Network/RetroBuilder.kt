package com.example.app.Network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetroBuilder {
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(Url.baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    val api: ApiInterface by lazy {
        retrofit.create(ApiInterface::class.java)
    }
}