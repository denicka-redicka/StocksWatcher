package com.example.ticketslist.di

import com.example.core.di.BaseApi
import com.example.ticketslist.feature.StocksViewModel

interface StocksApi: BaseApi {

    val vmFactory: StocksViewModel.StocksVmFactory
}