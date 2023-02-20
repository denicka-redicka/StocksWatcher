package com.example.favoriteslist.di

import com.example.favoriteslist.domain.FavoritesRepository
import com.example.favoriteslist.domain.FavoritesRepositoryImpl
import dagger.Binds
import dagger.Module

@Module
interface RepositoryModule {

    @Binds
    fun provideRepository(impl: FavoritesRepositoryImpl): FavoritesRepository
}