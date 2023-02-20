package com.example.ticketslist.domain

import com.example.core.data.Snippet

interface StocksRepository {

    suspend fun getStocksList(): List<Snippet>

    suspend fun saveStock(stock: Snippet)

    suspend fun deleteStock(ticket: String)
}