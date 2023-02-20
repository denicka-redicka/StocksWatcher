package com.example.network.data

import com.example.network.models.BrandInfoResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface LogoService {

    @GET("demo.json")
    suspend fun getBrandInfo(@Query("alias") website: String): BrandInfoResponse
}