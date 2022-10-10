package com.hadi.headlinescompose.presentation.ui.screen.news

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.items
import com.hadi.headlinescompose.data.model.NewsResponse
import com.hadi.headlinescompose.presentation.ui.theme.*

@Composable
fun ListContent(
    news: LazyPagingItems<NewsResponse.Article>,
    navController: NavController,
) {


    val result = handlePagingResult(news = news)

    if (result) {
        LazyColumn(
            contentPadding = PaddingValues(all = SMALL_PADDING),
            verticalArrangement = Arrangement.spacedBy(SMALL_PADDING)
        ) {
            items(
                items = news,
                key = { news ->
                    news.url
                }
            ) { news ->
                news?.let {
                    NewsItem(news = it, navController = navController)
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
                EmptyScreen()
                false
            }
            else -> true
        }
    }


}

@Composable
fun NewsItem(
    news: NewsResponse.Article,
    navController: NavController,
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(NEWS_ITEM_HEIGHT),
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth(1f),
            painter = painterResource(id = com.hadi.headlinescompose.R.drawable.lifestyle),
            contentDescription = null
        )
        Spacer(modifier = Modifier.padding(all = SMALL_PADDING))
        Column(
            modifier = Modifier
                .fillMaxWidth(2f),
        ) {
            Text(text = news.title,
                maxLines = 2,
                fontFamily = RockWell,
                fontWeight = FontWeight.SemiBold)

            Text(
                text = news.content ?: "",
                maxLines = 4,
                fontFamily = Calisto
            )
        }

    }

}



@Composable
fun EmptyScreen(error: LoadState.Error? = null) {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "EMPTY")
    }
}