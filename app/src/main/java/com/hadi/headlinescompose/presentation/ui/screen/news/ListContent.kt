package com.hadi.headlinescompose.presentation.ui.screen.news

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.items
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.hadi.headlinescompose.data.model.NewsResponse
import com.hadi.headlinescompose.presentation.ui.components.ShimmerEffect
import com.hadi.headlinescompose.presentation.ui.navigation.Screen
import com.hadi.headlinescompose.presentation.ui.theme.*

@Composable
fun ListContent(
    news: LazyPagingItems<NewsResponse.Article>,
    navController: NavController,
) {


    val result = handlePagingResult(news = news)

    if (result) {
        LazyColumn(
            contentPadding = PaddingValues(horizontal = 8.dp),
            verticalArrangement = Arrangement.spacedBy(SMALL_PADDING)
        ) {
            items(
                items = news,
                key = { news ->
                    news.url
                }
            ) { news ->
                news?.let {
                    NewsItem(news = it) {
                        navController.currentBackStackEntry?.arguments?.putParcelable("news", news)
                        navController.navigate(Screen.Detail.route)
                    }
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 8.dp)
                            .height(1.dp)
                            .background(Black)
                    )
                }
            }
        }
    }


}


@Composable
fun handlePagingResult(
    news: LazyPagingItems<NewsResponse.Article>,
): Boolean {

    news.apply {
        val error = when {
            loadState.refresh is LoadState.Error -> loadState.refresh as LoadState.Error
            loadState.prepend is LoadState.Error -> loadState.prepend as LoadState.Error
            loadState.append is LoadState.Error -> loadState.append as LoadState.Error
            else -> null
        }

        return when {
            loadState.refresh is LoadState.Loading -> {
                ShimmerEffect()
                false
            }
            error != null -> {
                EmptyScreen(error = error)
                false
            }
            news.itemCount < 1 -> {
                //EmptyScreen()
                false
            }
            else -> true
        }
    }


}


@Composable
fun EmptyScreen(error: LoadState.Error? = null) {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "EMPTY")
    }
}