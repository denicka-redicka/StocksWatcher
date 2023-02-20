package com.example.favoriteslist

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.core.data.Snippet
import com.example.favoriteslist.feature.FavoritesFeature
import com.example.favoriteslist.feature.FavoritesViewModel
import com.example.utils.ui.SnippetItem
@Composable
fun FavoritesListScreen(
    viewModel: FavoritesViewModel,
) {
    val state by viewModel.state.collectAsState(FavoritesFeature.Logic.initValue.state)
    FavoritesList(state?.stocks ?: emptyList()) { snippet ->
        viewModel.dispatch(FavoritesFeature.Message.FavoriteStarClicked(snippet))
    }
}

@Composable
fun FavoritesList(snippets: List<Snippet>, onStarClicked: (Snippet) -> Unit) {
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