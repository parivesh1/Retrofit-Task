package com.example.app.Repo

import com.example.app.Model.Info
import com.example.app.Network.RetroBuilder

class Repository {

    suspend fun getItem(): List<Info> = RetroBuilder.api.getInfo()

}