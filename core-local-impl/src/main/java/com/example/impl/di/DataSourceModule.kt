package com.example.impl.di

import com.example.local.data.LocalDataSource
import com.example.core.data.Snippet
import com.example.impl.data.LocalDataSourceImpl
import dagger.Binds
import dagger.Module

@Module
interface DataSourceModule {

    @Binds
    fun bindLocalDataSource(impl: LocalDataSourceImpl): LocalDataSource<@JvmSuppressWildcards Snippet>
}