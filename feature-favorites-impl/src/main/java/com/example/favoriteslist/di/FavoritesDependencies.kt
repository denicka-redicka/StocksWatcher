package com.example.favoriteslist.di

import com.example.core.data.Snippet
import com.example.core.di.BaseDependencies
import com.example.local.di.CoreLocalApi

interface FavoritesDependencies: BaseDependencies {

    val dbApi: CoreLocalApi<@JvmSuppressWildcards Snippet>
}