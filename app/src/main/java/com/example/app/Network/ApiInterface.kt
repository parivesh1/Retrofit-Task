package com.example.app.Network

import com.example.app.Model.Info
import retrofit2.http.GET

interface ApiInterface {

    @GET("/posts")
    suspend fun getInfo(): List<Info>
}