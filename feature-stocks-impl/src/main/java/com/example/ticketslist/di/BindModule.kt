package com.example.ticketslist.di

import com.example.ticketslist.domain.StocksRepository
import com.example.ticketslist.domain.StocksRepositoryImpl
import dagger.Binds
import dagger.Module

@Module
interface BindModule {

    @Binds
    fun bindStockRepository(implementation: StocksRepositoryImpl): StocksRepository
}