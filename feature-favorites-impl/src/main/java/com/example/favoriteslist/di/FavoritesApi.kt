package com.example.favoriteslist.di

import com.example.core.di.BaseApi
import com.example.favoriteslist.feature.FavoritesViewModel

interface FavoritesApi: BaseApi {

    val vmFactory: FavoritesViewModel.FavoritesVmFactory
}