package com.example.impl.di

import android.app.Application
import com.example.impl.room.StocksRoomDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [DataSourceModule::class])
class DbModule {

    @Provides
    @Singleton
    fun provideStocksDatabase(application: Application) = StocksRoomDatabase.DaoInstance(application)

    @Provides
    @Singleton
    fun provideStocksDao(db: StocksRoomDatabase) = db.getMoviesDao()
}