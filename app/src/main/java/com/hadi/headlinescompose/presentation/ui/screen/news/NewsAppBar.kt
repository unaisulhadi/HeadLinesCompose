package com.hadi.headlinescompose.presentation.ui.screen.news

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hadi.headlinescompose.presentation.ui.theme.Black
import com.hadi.headlinescompose.presentation.ui.theme.RockWell

@Composable
fun NewsAppBar() {
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Image(
                modifier = Modifier
                    .padding(start = 8.dp)
                    .height(40.dp)
                    .width(30.dp),
                painter = painterResource(id = com.hadi.headlinescompose.R.drawable.ic_back),
                contentDescription = null
            )

            Text(
                text = "NEWS",
                fontFamily = RockWell,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )

            Box(
                modifier = Modifier
                    .padding(end =8.dp)
                    .height(50.dp)
                    .width(50.dp)
            )

        }

        Box(
            modifier = Modifier
                .padding(top = 4.dp, bottom = 6.dp, start = 8.dp, end = 8.dp)
                .fillMaxWidth()
                .height(1.dp)
                .background(Black)

        )
    }

}


@Preview
@Composable
fun NewsAppBarPreview() {
    NewsAppBar()
}