package com.example.yandexinvestment.di

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

@Composable
inline fun <reified T : ViewModel> daggerViewModel(
    key: String? = null,
    viewModelInstanceCreator: ViewModelProvider.Factory
): T =
    androidx.lifecycle.viewmodel.compose.viewModel(
        modelClass = T::class.java,
        key = key,
        factory = viewModelInstanceCreator
    )