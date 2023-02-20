package com.example.network.di

import com.example.network.data.StocksRemoteDataSourceApi
interface CoreNetworkApi<Stocks> {
    fun stockRemoteService(): StocksRemoteDataSourceApi<Stocks>
}