package com.example.yandexinvestment

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.favoriteslist.di.FavoritesApi
import com.example.ticketslist.di.StocksApi
import com.example.utils.ui.theme.AppTheme
import com.example.utils.ui.theme.YandexTheme
import com.example.yandexinvestment.ui.MainScreen
import javax.inject.Inject

class MainActivity : ComponentActivity() {
    @Inject lateinit var stocksComponent: StocksApi
    @Inject lateinit var favoritesApi: FavoritesApi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        appComponent.inject(this)

        setContent {

            val navController = rememberNavController()

            NavHost(
                navController = navController,
                startDestination = com.example.core.navigation.NavigationDestination.StocksListDestination.destination,
                modifier = Modifier.fillMaxHeight()
            ) {
                composable(com.example.core.navigation.NavigationDestination.StocksListDestination.destination) {

                }

                composable(com.example.core.navigation.NavigationDestination.FavoriteListDestination.destination) {

                }

                composable(com.example.core.navigation.NavigationDestination.SearchScreenDestination.destination) {
                    Text(
                        text = "Check"
                    )
                }
            }

            YandexTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = AppTheme.colors.primaryBackground
                ) {

                    MainScreen(stocksComponent, favoritesApi)
                }
            }
        }
    }
}