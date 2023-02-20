package com.example.yandexinvestment

import android.app.Application
import android.content.Context
import com.example.yandexinvestment.di.AppComponent

class InvestmentApp: Application() {

    val appComponent: AppComponent by lazy {
        AppComponent.initAndGet(this)
    }
}

val Context.appComponent: AppComponent
    get() = when (this) {
        is InvestmentApp -> appComponent
        else -> this.applicationContext.appComponent
    }