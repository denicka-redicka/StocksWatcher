package com.example.ticketslist.di

import com.example.core.di.Feature
import dagger.Component

@[Feature Component(modules = [BindModule::class], dependencies = [StocksDependencies::class])]
interface StocksComponent: StocksApi {

    companion object {
        fun initAndGet(dependencies: StocksDependencies): StocksComponent =
            DaggerStocksComponent.builder()
                .stocksDependencies(dependencies)
                .build()
    }
}