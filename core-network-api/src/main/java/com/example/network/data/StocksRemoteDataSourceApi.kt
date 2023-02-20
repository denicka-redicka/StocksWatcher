package com.example.network.data


interface StocksRemoteDataSourceApi<Stocks> {

    suspend fun getStocksList(): Stocks
}