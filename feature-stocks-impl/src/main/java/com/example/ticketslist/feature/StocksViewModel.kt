package com.example.ticketslist.feature

import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import ca.gaket.tea.GreenTeaViewModel
import com.example.ticketslist.domain.StocksRepository
import javax.inject.Inject

class StocksViewModel(
    dependencies: StocksFeature.Dependencies,
    savedStateHandle: SavedStateHandle
) : GreenTeaViewModel<StocksFeature.State, StocksFeature.Message, StocksFeature.Dependencies>(
    init = StocksFeature.Logic.initialState,
    update = StocksFeature.Logic::update,
    restore = StocksFeature.Logic::restore,
    dependencies = dependencies,
    savedStateHandle = savedStateHandle
) {

    init {
        onCreated()
    }

    class StocksVmFactory @Inject constructor(
        private val repository: StocksRepository
    ): AbstractSavedStateViewModelFactory() {

        override fun <T : ViewModel> create(key: String, modelClass: Class<T>, handle: SavedStateHandle): T {
            return StocksViewModel(
                dependencies = StocksFeature.Dependencies(
                    repository = repository
                ),
                savedStateHandle = handle
            ) as T
        }
    }
}