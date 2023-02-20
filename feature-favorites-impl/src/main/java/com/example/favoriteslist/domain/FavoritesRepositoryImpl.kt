package com.example.favoriteslist.domain

import com.example.core.data.Snippet
import com.example.local.di.CoreLocalApi
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FavoritesRepositoryImpl @Inject constructor(
    dbApi: CoreLocalApi<@JvmSuppressWildcards Snippet>
): FavoritesRepository {

    private val db = dbApi.getLocalDataSource()

    override suspend fun getAllFavorites(): Flow<List<Snippet>> {
        return db.getFavoriteStocks()
    }

    override suspend fun deleteStock(ticket: String) {
        db.deleteStock(ticket)
    }
}