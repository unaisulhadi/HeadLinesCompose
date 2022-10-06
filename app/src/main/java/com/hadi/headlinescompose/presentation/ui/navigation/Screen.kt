package com.hadi.headlinescompose.presentation.ui.navigation

sealed class Screen(val route:String) {
    object Splash : Screen("splash_screen")
    object News : Screen("news_screen")
}
