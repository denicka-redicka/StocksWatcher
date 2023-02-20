package com.example.core.di

interface ComponentHolder<Api: BaseApi, Deps: BaseDependencies> {

    fun init(dependencies: Deps)
    fun get(): Api
    fun reset()
}

interface BaseApi

interface BaseDependencies