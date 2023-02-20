package com.example.local.di

import com.example.local.data.LocalDataSource

interface CoreLocalApi<Stock> {

    fun getLocalDataSource(): LocalDataSource<Stock>
}