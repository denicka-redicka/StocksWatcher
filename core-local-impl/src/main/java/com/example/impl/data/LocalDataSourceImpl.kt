package com.example.impl.data

import com.example.local.data.LocalDataSource
import com.example.core.data.Snippet
import com.example.impl.room.LocalDao
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor(
    private val dao: LocalDao
) : LocalDataSource<Snippet> {

    override suspend fun saveStock(stock: Snippet) {
        dao.insert(stock.toStockModel())
    }

    override suspend fun deleteStock(ticket: String) {
        dao.removeMovie(ticket)
    }

    override suspend fun getFavoriteStocks(): Flow<List<Snippet>> {
        return dao.getAllFavorites().map {models ->
            models.map { it.toSnippet() }
        }
    }

    override suspend fun getTicketsList(): List<String> = dao.getTicketList()
}