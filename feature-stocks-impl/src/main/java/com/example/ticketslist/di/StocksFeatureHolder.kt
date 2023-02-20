package com.example.ticketslist.di

import com.example.core.di.ComponentHolder

object StocksFeatureHolder : ComponentHolder<StocksApi, StocksDependencies> {

    private var component: StocksComponent? = null

    override fun init(dependencies: StocksDependencies) {
        if (component == null) {
            synchronized(StocksFeatureHolder::class.java) {
                if (component == null) {
                    component = StocksComponent.initAndGet(dependencies)
                }
            }
        }
    }

    override fun get() = component ?: throw Exception("StocksComponent was not Initialized!")

    override fun reset() {
        component = null
    }
}