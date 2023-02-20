package com.example.impl.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.impl.room.entitiy.StockModel
import kotlinx.coroutines.flow.Flow

@Dao
interface LocalDao {

    @Query("SELECT * from stocks")
    fun getAllFavorites(): Flow<List<StockModel>>

    @Query("SELECT * from stocks WHERE ticket =:ticket")
    fun getTicket(ticket: String): StockModel

    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun insert(movie: StockModel): Long

    @Query("DELETE FROM stocks WHERE ticket = :ticket")
    fun removeMovie(ticket: String)

    @Query("SELECT ticket from stocks")
    fun getTicketList(): List<String>
}