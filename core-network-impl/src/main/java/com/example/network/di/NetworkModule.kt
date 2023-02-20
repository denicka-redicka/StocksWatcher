package com.example.network.di

import com.example.network.data.LogoService
import com.example.network.data.StocksService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Provides
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.create
import java.util.concurrent.TimeUnit

private const val yahooFinanceBaseUrl = "https://query2.finance.yahoo.com/"
private const val brandFetchBaseUrl = "https://brandfetch.com/_next/data/QbSpWqBhbhPyWSX8f7Nlg/developers/"

@dagger.Module(includes = [DataSourceModule::class])
class NetworkModule {

    private val json = Json {
        prettyPrint = true
        ignoreUnknownKeys = true
    }

    private val contentType = "application/json".toMediaType()

    @Provides
    internal fun StocksService(): StocksService {
        val client = OkHttpClient.Builder()
            .connectTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS)
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .build()
        val retrofit = Retrofit.Builder()
            .baseUrl(yahooFinanceBaseUrl)
            .addConverterFactory(json.asConverterFactory(contentType))
            .client(client)
            .build()
        return retrofit.create()
    }

    @Provides
    internal fun LogosService(): LogoService {
        val client = OkHttpClient.Builder()
            .connectTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS)
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .build()
        val retrofit = Retrofit.Builder()
            .baseUrl(brandFetchBaseUrl)
            .addConverterFactory(json.asConverterFactory(contentType))
            .client(client)
            .build()
        return retrofit.create()
    }
}