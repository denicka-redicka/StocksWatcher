package com.example.ticketslist.di

import com.example.local.di.CoreLocalApi
import com.example.core.data.Snippet
import com.example.core.di.BaseDependencies
import com.example.network.di.CoreNetworkApi

interface StocksDependencies: BaseDependencies {

    val networkApi: CoreNetworkApi<List<@JvmSuppressWildcards Snippet>>

    val database: CoreLocalApi<@JvmSuppressWildcards Snippet>
}