package com.example.ticketslist.domain

import com.example.core.data.Snippet
import com.example.local.di.CoreLocalApi
import com.example.network.di.CoreNetworkApi
import javax.inject.Inject

class StocksRepositoryImpl @Inject constructor(
    api: CoreNetworkApi<List<@JvmSuppressWildcards Snippet>>,
    db: CoreLocalApi<@JvmSuppressWildcards Snippet>
): StocksRepository {

    private val api = api.stockRemoteService()
    private val db = db.getLocalDataSource()

    override suspend fun getStocksList(): List<Snippet> {
        return api.getStocksList().map {snippet ->
            val savedTicket = db.getTicketsList()
            if (savedTicket.contains(snippet.ticketName)) {
                snippet.isFavorite = true
            }
            snippet
        }
    }

    override suspend fun saveStock(stock: Snippet) {
        db.saveStock(stock)
    }

    override suspend fun deleteStock(ticket: String) {
        db.deleteStock(ticket)
    }
}