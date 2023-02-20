package com.example.ticketslist.feature

import android.os.Parcelable
import ca.gaket.tea.runtime.coroutines.*
import com.example.core.data.Snippet
import com.example.ticketslist.domain.StocksRepository
import kotlinx.parcelize.Parcelize

object StocksFeature {

    @Parcelize
    data class State(
        val isLoading: Boolean,
        val stocks: List<Snippet>,
        val errorMessage: String?
    ) : Parcelable

    sealed class Message {
        data class StocksResponse(val stocks: List<Snippet>) : Message()
        data class FavoriteStarClicked(val snippet: Snippet) : Message()
    }

    object Logic {
        val initialState = State(
            isLoading = true,
            stocks = emptyList(),
            errorMessage = null
        ) with Effects.GetStocks

        fun restore(state: State): Update<State, Message, Dependencies> =
            state with noEffects()

        fun update(message: Message, state: State): Update<State, Message, Dependencies> =
            when (message) {
                is Message.StocksResponse -> handleStockResponse(message, state) with noEffects()
                is Message.FavoriteStarClicked -> handleFavoriteStarClicked(message, state)
            }

        private fun handleFavoriteStarClicked(
            message: Message.FavoriteStarClicked,
            state: State
        ): Update<State, Message, Dependencies> {
            val shouldDelete = message.snippet.isFavorite
            message.snippet.isFavorite = !message.snippet.isFavorite
            return state with if (shouldDelete) Effects.DeleteStocks(message.snippet.ticketName) else Effects.SaveStocks(
                message.snippet
            )
        }

        private fun handleStockResponse(
            message: Message.StocksResponse,
            state: State
        ) = if (message.stocks.isNotEmpty()) {
            state.copy(isLoading = false, stocks = message.stocks)
        } else {
            state.copy(
                isLoading = false,
                stocks = emptyList(),
                errorMessage = "Something wrong.."
            )
        }
    }


    class Dependencies(
        val repository: StocksRepository
    )

    object Effects {
        object GetStocks : Effect<Dependencies, Message> by Effect.single({ dependencies ->
            val stocks = dependencies.repository.getStocksList()
            return@single Message.StocksResponse(stocks)
        })

        data class SaveStocks(val snippet: Snippet) :
            Effect<Dependencies, Message> by Effect.idle({ dependencies ->
                dependencies.repository.saveStock(snippet)
            })

        data class DeleteStocks(val ticket: String) :
            Effect<Dependencies, Message> by Effect.idle({ dependencies ->
                dependencies.repository.deleteStock(ticket)
            })
    }
}