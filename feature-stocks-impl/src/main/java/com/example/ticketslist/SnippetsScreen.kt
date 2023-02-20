package com.example.ticketslist

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.core.data.Snippet
import com.example.ticketslist.feature.StocksFeature
import com.example.ticketslist.feature.StocksViewModel
import com.example.utils.ui.SnippetItem

@Composable
fun SnippetListScreen(
    viewModel: StocksViewModel,
) {
    val state by viewModel.state.collectAsState(StocksFeature.Logic.initialState.state)
    SnippetsList(state?.stocks ?: emptyList()) { snippet ->
        viewModel.dispatch(StocksFeature.Message.FavoriteStarClicked(snippet))
    }
}

@Composable
fun SnippetsList(snippets: List<Snippet>, onStarClicked: (Snippet) -> Unit) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        var isEven: Boolean
        snippets.forEachIndexed { index, snippet ->
            item {
                isEven = index % 2 == 0
                SnippetItem(snippet, isEven, onStarClicked)
            }
        }
    }
}