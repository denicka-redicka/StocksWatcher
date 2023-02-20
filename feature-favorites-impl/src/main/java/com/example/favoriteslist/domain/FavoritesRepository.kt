package com.example.favoriteslist.domain

import com.example.core.data.Snippet
import kotlinx.coroutines.flow.Flow

interface FavoritesRepository {

    suspend fun getAllFavorites(): Flow<List<Snippet>>

    suspend fun deleteStock(ticket: String)
}