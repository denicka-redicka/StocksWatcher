package com.example.network.di

import com.example.core.data.Snippet
import dagger.Component
import javax.inject.Singleton

@Component(modules = [NetworkModule::class])
@Singleton
interface NetworkComponent : CoreNetworkApi<List<@JvmSuppressWildcards Snippet>> {

    companion object {
        fun initAndGet(): NetworkComponent {

            return DaggerNetworkComponent.builder()
                .build()
        }
    }

}