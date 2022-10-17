package com.hadi.headlinescompose.presentation.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.hadi.headlinescompose.presentation.ui.screen.home.HomeScreen
import com.hadi.headlinescompose.presentation.ui.screen.intro.SplashScreen
import com.hadi.headlinescompose.presentation.ui.screen.news.NewsScreen

@Composable
fun AppNavGraph(
    navController: NavHostController,
) {

    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route
    ) {

        composable(route = Screen.Splash.route) {
            SplashScreen(navController = navController)
        }
        composable(route = Screen.Home.route) {
            HomeScreen(navController = navController)
        }
        composable(route = Screen.News.route) {
            NewsScreen(navController = navController)
        }

    }

}