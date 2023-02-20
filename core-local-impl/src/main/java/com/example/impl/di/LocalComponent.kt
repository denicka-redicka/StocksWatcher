package com.example.impl.di

import android.app.Application
import com.example.local.di.CoreLocalApi
import com.example.core.data.Snippet
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@[Singleton Component(modules = [DbModule::class])]
interface LocalComponent: CoreLocalApi<@JvmSuppressWildcards Snippet> {

    companion object {
        fun initAndGet(app: Application): LocalComponent {

            return DaggerLocalComponent.builder()
                .application(app)
                .build()
        }
    }

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(app: Application): Builder

        fun build(): LocalComponent
    }
}