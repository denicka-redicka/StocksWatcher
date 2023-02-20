package com.example.core.navigation

sealed class NavigationDestination(val destination: String) {
    object StocksListDestination: NavigationDestination("stocks_list")
    object FavoriteListDestination: NavigationDestination("favorites_list")
    object SearchScreenDestination: NavigationDestination("search_screen")
}