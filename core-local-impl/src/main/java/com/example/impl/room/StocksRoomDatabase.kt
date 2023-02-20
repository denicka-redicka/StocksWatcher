package com.example.impl.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.impl.room.entitiy.StockModel


@Database(entities = [StockModel::class], version = 1)
abstract class StocksRoomDatabase : RoomDatabase() {

    abstract fun getMoviesDao(): LocalDao

    companion object {
        private const val CONTACT_DATABASE = "stocks.db"

        fun DaoInstance(context: Context): StocksRoomDatabase {
            return Room.databaseBuilder(
                context,
                StocksRoomDatabase::class.java,
                CONTACT_DATABASE
            ).fallbackToDestructiveMigration()
                .build()
        }
    }
}