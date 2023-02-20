package com.example.yandexinvestment.di

import com.example.core.data.Snippet
import com.example.local.di.CoreLocalApi
import com.example.network.di.CoreNetworkApi

interface AppInjector {

    val networkApi: CoreNetworkApi<List<@JvmSuppressWildcards Snippet>>

    val localApi: CoreLocalApi<@JvmSuppressWildcards Snippet>
}