package com.hadi.headlinescompose.presentation.ui.screen.news

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.paging.PagingData
import androidx.paging.compose.collectAsLazyPagingItems
import com.hadi.headlinescompose.data.model.NewsResponse
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.newSingleThreadContext

@Composable
fun NewsScreen(
    navController: NavController,
    newsViewModel: NewsViewModel = hiltViewModel(),
) {

    LaunchedEffect(key1 = true) {
        val category =
            navController.previousBackStackEntry?.arguments?.getString("category") ?: "technology"
        newsViewModel.getNewsByCategory(category)
        Log.d("SelectedCategory", "NewsScreen: $category")
    }

    val news = newsViewModel.allNews.collectAsLazyPagingItems()


    Scaffold(
        topBar = {
            NewsAppBar() {
                navController.navigateUp()
            }
        },
        backgroundColor = Color.Transparent,
        content = {

            ListContent(
                news = news,
                navController = navController
            )

        }
    )
}