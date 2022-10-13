package com.hadi.headlinescompose.presentation.ui.screen.news

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
        AsyncImage(
            modifier = Modifier
                .fillMaxHeight()
                .weight(1f),
            contentScale = ContentScale.Crop,
            model = ImageRequest.Builder(LocalContext.current)
                .data(data = news.urlToImage)
                .placeholder(com.hadi.headlinescompose.R.drawable.newspaper)
                .error(com.hadi.headlinescompose.R.drawable.newspaper)
                .build(),
            contentDescription = null
        )
        Spacer(modifier = Modifier.padding(all = SMALL_PADDING))
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .weight(2f),
        ) {
            Text(
                modifier = Modifier.padding(top = 16.dp),
                text = news.title,
                maxLines = 2,
                lineHeight = 18.sp,
                fontFamily = RockWell,
                fontWeight = FontWeight.SemiBold
            )

            Text(
                modifier = Modifier.padding(top = 8.dp),
                text = news.content ?: "",
                maxLines = 4,
                overflow = TextOverflow.Ellipsis,
                lineHeight = 20.sp,
                fontFamily = Calisto
            )
        }

    }

}


@Preview
@Composable
fun NewsItemPreview() {
    val news = NewsResponse.Article(
        author = "Some Author",
        content = "This is random content This is random content This is random content This is random content This is random content This is random content This is random content This is random content This is random content ",
        description = "This is description This is description This is description This is description This is description",
        publishedAt = "SDJKSDHSJDHSJD",
        source = null,
        title = "NEWS TITLE GOES HERE NEWS TITLE GOES HERE NEWS TITLE GOES HERE " ,
        url = "dsdsdsds",
        urlToImage = null

    )

    NewsItem(news = news, navController = rememberNavController())

}


@Composable
fun EmptyScreen(error: LoadState.Error? = null) {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "EMPTY")
    }
}