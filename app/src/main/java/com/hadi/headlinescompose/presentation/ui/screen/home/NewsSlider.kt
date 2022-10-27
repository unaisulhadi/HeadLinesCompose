package com.hadi.headlinescompose.presentation.ui.screen.home

import android.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.hadi.headlinescompose.data.model.NewsResponse
import com.hadi.headlinescompose.presentation.ui.theme.Black
import com.hadi.headlinescompose.presentation.ui.theme.PrimaryRed
import com.hadi.headlinescompose.presentation.ui.theme.RockWell
import com.hadi.headlinescompose.utils.ResourceDrawable

@Composable
fun NewsSlider(
    modifier: Modifier =Modifier,
    news: NewsResponse.Article,
    onNewsClick : () -> Unit
) {

    val matrix = ColorMatrix()
    matrix.setToSaturation(0F)

    Row(
        modifier = modifier
            .fillMaxWidth(fraction = 5f)
            .height(180.dp)
            .clickable {
                onNewsClick()
            }
    ) {

        Column(
            modifier = Modifier
                .fillMaxHeight()
                .weight(3f)
                .padding(vertical = 4.dp, horizontal = 8.dp)
        ) {

            Text(
                text = "TRENDING",
                color = PrimaryRed,
                fontFamily = RockWell
            )

            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(128.dp)
                    .padding(top = 4.dp),
                text = news.title,
                lineHeight = 22.sp,
                fontStyle = FontStyle.Normal,
                fontWeight = FontWeight.Bold,
                maxLines = 5,
                overflow = TextOverflow.Ellipsis,
                color = Black,
                fontSize = 22.sp,
                fontFamily = RockWell
            )
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Read More",
                    color = Black,
                    fontSize = 16.sp,
                    fontFamily = RockWell
                )
                Image(
                    modifier = Modifier.size(28.dp),
                    painter = painterResource(id = ResourceDrawable.ic_arrow_right),
                    contentDescription = null
                )
            }

        }

        Column(
            modifier = Modifier
                .fillMaxHeight()
                .weight(2f)
                .padding(end = 8.dp)
        ) {

            AsyncImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(top = 4.dp, bottom = 4.dp),
                model = ImageRequest.Builder(LocalContext.current)
                    .data(data = news.urlToImage)
                    .placeholder(com.hadi.headlinescompose.R.drawable.newspaper)
                    .error(com.hadi.headlinescompose.R.drawable.newspaper)
                    .build(),
                contentScale = ContentScale.Crop,
                colorFilter = ColorFilter.colorMatrix(matrix),
                contentDescription = null
            )

        }


    }

}



@Composable
@Preview
fun NewsSliderPreview() {
    NewsSlider(
        news = NewsResponse.Article(
            title = "NASA Just Detected the Most Powerful Gamma-ray Bursts Close to Earth - News18\",",
            content = "Gamma-ray-bursts (GRB) were unintentionally found by American military satellites in the 1960s. Their creation most likely took place when a massive star exploded towards the end of their lives and turned into a black hole.",
            author = null,
            description = "",
            publishedAt = "",
            source = null,
            url = "",
            urlToImage = "https://images.news18.com/ibnlive/uploads/2022/10/gamma-rays-166607875216x9.png",
        )
    ){}
}