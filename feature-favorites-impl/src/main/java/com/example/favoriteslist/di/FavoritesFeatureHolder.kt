package com.example.favoriteslist.di

import com.example.core.di.ComponentHolder

object FavoritesFeatureHolder: ComponentHolder<FavoritesApi, FavoritesDependencies> {

    private var component: FavoritesComponent? = null

    override fun init(dependencies: FavoritesDependencies) {
        if (component == null) {
            synchronized(FavoritesFeatureHolder::class.java) {
                if (component == null) {
                    component = FavoritesComponent.initAndGet(dependencies)
                }
            }
        }
    }

    override fun get(): FavoritesApi = component ?: throw Exception("Component should be initialized")

    override fun reset() {
        component = null
    }
}