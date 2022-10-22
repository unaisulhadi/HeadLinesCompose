package com.hadi.headlinescompose.presentation.ui.screen.details

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.hadi.headlinescompose.R
import com.hadi.headlinescompose.data.model.NewsResponse
import com.hadi.headlinescompose.presentation.ui.navigation.Screen
import com.hadi.headlinescompose.presentation.ui.screen.news.ListContent
import com.hadi.headlinescompose.presentation.ui.screen.news.NewsAppBar
import com.hadi.headlinescompose.presentation.ui.theme.*
import com.hadi.headlinescompose.utils.dummyNewsItem

@Composable
fun DetailScreen(
    navController: NavController,
    newsItem: NewsResponse.Article?
) {

    val matrix = ColorMatrix()
    matrix.setToSaturation(0F)

    Scaffold(
        topBar = {
            NewsAppBar() {
                navController.navigateUp()
            }
        },
        backgroundColor = Color.Transparent
    ) {
        if (newsItem == null) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Something went wrong!!!",
                    fontFamily = RockWell,
                    fontSize = 18.sp
                )
            }
        } else {
            Column(
                modifier = Modifier.fillMaxSize()
                    .padding(16.dp)
                    .border(
                        width = 1.dp,
                        color = Color.Black,
                        shape = RectangleShape
                    )
                    .padding(12.dp)
            ) {
                Column(
                    modifier = Modifier
                        .weight(1f),
                ) {

                    Text(
                        text = newsItem.title,
                        lineHeight = 28.sp,
                        fontFamily = RockWell,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        overflow = TextOverflow.Ellipsis
                    )
                    Text(
                        modifier = Modifier.padding(top = 8.dp),
                        text = newsItem.publishedAt,
                        lineHeight = 18.sp,
                        fontSize = 15.sp,
                        color = Grey,
                        fontFamily = Calisto
                    )
                    Text(
                        modifier = Modifier.padding(top = 8.dp),
                        text = newsItem.author ?: "----",
                        color = Black,
                        lineHeight = 18.sp,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = Calisto
                    )
                    AsyncImage(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp)
                            .padding(top = 8.dp),
                        contentScale = ContentScale.Crop,
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(data = newsItem.urlToImage)
                            .placeholder(R.drawable.newspaper)
                            .error(R.drawable.newspaper)
                            .build(),
                        colorFilter = ColorFilter.colorMatrix(matrix),
                        contentDescription = null
                    )
                    Text(
                        modifier = Modifier.padding(top = 8.dp),
                        text = newsItem.content ?: newsItem.description,
                        color = Black,
                        lineHeight = 22.sp,
                        fontSize = 17.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = Calisto
                    )
                }
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp)
                        .height(56.dp),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = PrimaryRed
                    ),
                    shape = RectangleShape,
                    onClick = {

                    }) {
                    Text(
                        text = stringResource(R.string.read_full_article),
                        fontFamily = RockWell,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }
            }

        }
    }
}


@Preview
@Composable
fun DetailsScreenPreview() {
    DetailScreen(
        navController = rememberNavController(),
        newsItem = dummyNewsItem
    )
}