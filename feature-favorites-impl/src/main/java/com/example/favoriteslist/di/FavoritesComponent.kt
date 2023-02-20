package com.example.favoriteslist.di

import com.example.core.di.Feature
import dagger.Component

@[Feature Component(
    modules = [RepositoryModule::class],
    dependencies = [FavoritesDependencies::class]
)]
interface FavoritesComponent: FavoritesApi {

    companion object {
        fun initAndGet(dependencies: FavoritesDependencies): FavoritesComponent =
            DaggerFavoritesComponent.builder()
                .favoritesDependencies(dependencies)
                .build()
    }
}