package com.example.network.di

import com.example.core.data.Snippet
import com.example.network.data.StocksRemoteDataSourceApi
import com.example.network.data.StocksRemoteDataSourceImpl
import dagger.Binds

@dagger.Module
internal interface DataSourceModule {

    @Binds
    fun bindRemoteDataSource(
        remoteDataSourceImpl: StocksRemoteDataSourceImpl
    ): StocksRemoteDataSourceApi<List<@JvmSuppressWildcards Snippet>>
}