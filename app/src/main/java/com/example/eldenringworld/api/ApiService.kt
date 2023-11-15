package com.example.eldenringworld.api

import com.example.eldenringworld.model.bossModel
import com.example.eldenringworld.model.locationModel
import retrofit2.Response
import retrofit2.http.GET

interface apiBoss {
    @GET("bosses?limit=106")
    suspend fun getBosses(): Response<bossModel>
}

interface apiLocation {
    @GET("locations?limit=177")
    suspend fun getLocal(): Response<locationModel>
}