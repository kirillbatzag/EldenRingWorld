package com.example.eldenringworld.api

import com.example.eldenringworld.model.locationModel
import retrofit2.Response
import retrofit2.http.GET

interface apiLocation {
    @GET("locations?limit=177")
    suspend fun getLocal(): Response<locationModel>
}