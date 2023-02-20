package com.example.yandexinvestment.ui

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.*
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.favoriteslist.FavoritesListScreen
import com.example.favoriteslist.di.FavoritesApi
import com.example.favoriteslist.feature.FavoritesViewModel
import com.example.search.ui.SearchBar
import com.example.ticketslist.SnippetListScreen
import com.example.ticketslist.di.StocksApi
import com.example.ticketslist.feature.StocksViewModel
import com.example.utils.ui.theme.AppTheme
import com.example.yandexinvestment.di.daggerViewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun MainScreen(
    stocksComponent: StocksApi,
    favoritesComponent: FavoritesApi
) {
    val tabData = listOf("Stoks", "Favorite")
    val state = rememberPagerState(initialPage = 0)
    val coroutineScope = rememberCoroutineScope()

    Column {
        SearchBar()
        ScrollableTabRow(
            selectedTabIndex = state.currentPage,
            backgroundColor = AppTheme.colors.primaryBackground,
            indicator = {},
            divider = {},
            edgePadding = 16.dp
        ) {
            tabData.forEachIndexed { index, item ->
                val isSelected = state.currentPage == index
                Column(
                    modifier = Modifier
                        .clip(AppTheme.shapes.medium)
                        .selectable(
                            selected = isSelected,
                            onClick = {
                                coroutineScope.launch {
                                    state.animateScrollToPage(index)
                                }
                            },
                            enabled = true,
                            role = Role.Tab,
                            interactionSource = remember { MutableInteractionSource() },
                            indication = rememberRipple(bounded = true)
                        )
                        .sizeIn(minHeight = 50.dp),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.Bottom,
                    content = {
                        Text(
                            text = item,
                            fontSize = if (isSelected) 32.sp else 24.sp,
                            color = if (isSelected)
                                AppTheme.colors.primaryTextColor
                            else
                                AppTheme.colors.secondaryTextColor,
                            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
                            modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp)
                        )
                    }
                )
            }
        }

        HorizontalPager(
            count = tabData.size,
            state = state
        ) { page ->
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                when (page) {
                    0 -> {
                        val viewModel: StocksViewModel = daggerViewModel(
                            viewModelInstanceCreator = stocksComponent.vmFactory
                        )
                        SnippetListScreen(viewModel)
                    }
                    1 -> {
                        val viewModel: FavoritesViewModel = daggerViewModel(
                            viewModelInstanceCreator = favoritesComponent.vmFactory
                        )
                        FavoritesListScreen(viewModel = viewModel)
                    }
                    else -> Text(
                        text = "WTF?!"
                    )
                }
            }
        }
    }
}


