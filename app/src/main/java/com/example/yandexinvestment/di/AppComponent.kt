package com.example.yandexinvestment.di

import android.app.Application
import com.example.core.data.Snippet
import com.example.impl.di.LocalComponent
import com.example.local.di.CoreLocalApi
import com.example.network.di.CoreNetworkApi
import com.example.network.di.NetworkComponent
import com.example.yandexinvestment.MainActivity
import dagger.Component
import javax.inject.Singleton

@[Singleton Component(modules = [AppModule::class], dependencies = [AppInjector::class])]
interface AppComponent: AppInjector {

    fun inject(activity: MainActivity)

    companion object {
        fun initAndGet(app: Application): AppComponent =
            DaggerAppComponent.builder()
                .appInjector(object: AppInjector {
                    override val networkApi: CoreNetworkApi<List<Snippet>> = NetworkComponent.initAndGet()
                    override val localApi: CoreLocalApi<Snippet> = LocalComponent.initAndGet(app)
                })
                .build()
    }

}