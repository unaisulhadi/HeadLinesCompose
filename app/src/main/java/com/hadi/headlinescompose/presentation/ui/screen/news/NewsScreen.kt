package com.hadi.headlinescompose.presentation.ui.screen.news

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.paging.compose.collectAsLazyPagingItems

@Composable
fun NewsScreen(
    navController: NavController,
    newsViewModel: NewsViewModel = hiltViewModel(),
) {
    val news = newsViewModel.allNews.collectAsLazyPagingItems()

    Scaffold(
        topBar = { NewsAppBar() {
            navController.navigateUp()
        } },
        backgroundColor = Color.Transparent,
        content = {

            ListContent(
                news = news,
                navController = navController
            )


        }
    )
}