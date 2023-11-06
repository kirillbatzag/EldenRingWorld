package com.example.eldenringworld.api

import com.example.eldenringworld.model.bossData
import com.example.eldenringworld.model.bossModel
import retrofit2.Response
import retrofit2.http.GET

interface apiBoss {
    @GET("bosses?limit=106")
    suspend fun getBosses(): Response<bossModel>
}
