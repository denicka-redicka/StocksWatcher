package com.example.favoriteslist.feature

import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import ca.gaket.tea.GreenTeaViewModel
import com.example.favoriteslist.domain.FavoritesRepository
import javax.inject.Inject

class FavoritesViewModel(
    dependencies: FavoritesFeature.Dependencies,
    stateHandle: SavedStateHandle
) : GreenTeaViewModel<FavoritesFeature.State, FavoritesFeature.Message, FavoritesFeature.Dependencies>(
    init = FavoritesFeature.Logic.initValue,
    update = FavoritesFeature.Logic::update,
    restore = FavoritesFeature.Logic::restore,
    dependencies = dependencies,
    savedStateHandle = stateHandle
) {

    init {
        onCreated()
    }

    class FavoritesVmFactory @Inject constructor(
        private val repository: FavoritesRepository
    ) : AbstractSavedStateViewModelFactory() {

        override fun <T : ViewModel> create(
            key: String,
            modelClass: Class<T>,
            handle: SavedStateHandle
        ): T {
            return FavoritesViewModel(
                dependencies = FavoritesFeature.Dependencies(repository),
                stateHandle = handle
            ) as T
        }
    }
}