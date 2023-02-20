package com.example.yandexinvestment.di

import com.example.local.di.CoreLocalApi
import com.example.core.data.Snippet
import com.example.favoriteslist.di.FavoritesApi
import com.example.favoriteslist.di.FavoritesDependencies
import com.example.favoriteslist.di.FavoritesFeatureHolder
import com.example.network.di.CoreNetworkApi
import com.example.ticketslist.di.StocksApi
import com.example.ticketslist.di.StocksDependencies
import com.example.ticketslist.di.StocksFeatureHolder
import dagger.Module
import dagger.Provides

@Module
class AppModule {

    @Provides
    fun provideStocksDependencies(
        networkApi: CoreNetworkApi<List<@JvmSuppressWildcards Snippet>>,
        localApi: CoreLocalApi<@JvmSuppressWildcards Snippet>
    ): StocksDependencies {
        return object : StocksDependencies {
            override val networkApi: CoreNetworkApi<List<Snippet>> = networkApi
            override val database: CoreLocalApi<Snippet> = localApi

        }
    }

    @Provides
    fun provideStocksApi(dependencies: StocksDependencies): StocksApi {
        StocksFeatureHolder.init(dependencies)
        return StocksFeatureHolder.get()
    }

    @Provides
    fun provideFavoritesDependencies(
        localApi: CoreLocalApi<@JvmSuppressWildcards Snippet>
    ): FavoritesDependencies {
        return object : FavoritesDependencies {
            override val dbApi: CoreLocalApi<Snippet> = localApi
        }
    }

    @Provides
    fun provideFavoritesApi(dependencies: FavoritesDependencies): FavoritesApi {
        FavoritesFeatureHolder.init(dependencies)
        return FavoritesFeatureHolder.get()
    }
}