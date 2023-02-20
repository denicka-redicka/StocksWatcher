package com.example.local.data

import kotlinx.coroutines.flow.Flow

interface LocalDataSource<Stock> {

    suspend fun saveStock(stock: Stock)

    suspend fun deleteStock(ticket: String)

    suspend fun getFavoriteStocks(): Flow<List<Stock>>

    suspend fun getTicketsList(): List<String>
}