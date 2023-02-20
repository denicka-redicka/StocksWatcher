package com.example.favoriteslist.feature

import android.os.Parcelable
import ca.gaket.tea.runtime.coroutines.Effect
import ca.gaket.tea.runtime.coroutines.Update
import ca.gaket.tea.runtime.coroutines.noEffects
import ca.gaket.tea.runtime.coroutines.with
import com.example.core.data.Snippet
import com.example.favoriteslist.domain.FavoritesRepository
import kotlinx.coroutines.flow.map
import kotlinx.parcelize.Parcelize

object FavoritesFeature {

    @Parcelize
    data class State(
        val stocks: List<Snippet>
    ) : Parcelable

    sealed class Message {
        data class FavoritesListResponse(val favorites: List<Snippet>) : Message()
        data class FavoriteStarClicked(val snippet: Snippet) : Message()
    }

    object Logic {
        val initValue = State(emptyList()) with Effects.GetFavorites

        fun restore(state: State): Update<State, Message, Dependencies> = state with noEffects()

        fun update(message: Message, state: State): Update<State, Message, Dependencies> {
            return when (message) {
                is Message.FavoritesListResponse -> state.copy(stocks = message.favorites) with noEffects()
                is Message.FavoriteStarClicked -> state with Effects.DeleteStocks(message.snippet.ticketName)
            }
        }
    }

    object Effects {
        object GetFavorites : Effect<Dependencies, Message> by Effect.flow({ dependencies ->
            val favoritesStocks = dependencies.repository.getAllFavorites()
            return@flow favoritesStocks.map {snippets ->
                Message.FavoritesListResponse(snippets)
            }
        })

        data class DeleteStocks(val ticket: String) :
            Effect<Dependencies, Message> by Effect.idle({ dependencies ->
                dependencies.repository.deleteStock(ticket)
            })
    }

    class Dependencies(
        val repository: FavoritesRepository
    )
}