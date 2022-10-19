package com.hadi.headlinescompose.presentation.ui.screen.home

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
import com.hadi.headlinescompose.presentation.ui.theme.Calisto
import com.hadi.headlinescompose.presentation.ui.theme.RockWell
import com.hadi.headlinescompose.utils.ResourceDrawable

@Composable
fun HomeAppBar() {

    Column(
        modifier = Modifier.fillMaxWidth()
            .padding(horizontal = 8.dp)
    ) {

        Box(
            modifier = Modifier
                .padding(top = 36.dp)
                .fillMaxWidth()
                .height(1.dp)
                .background(Black)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 12.dp, start = 8.dp, end = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Image(
                modifier = Modifier
                    .width(40.dp)
                    .height(40.dp),
                painter = painterResource(id = ResourceDrawable.ic_menu),
                contentDescription = null
            )

            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "LATEST NEWS",
                    fontFamily = RockWell,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
                Text(
                    text = "Sunday, June 11, 1920",
                    fontFamily = Calisto,
                    fontSize = 16.sp
                )
            }

            Image(
                modifier = Modifier
                    .width(40.dp)
                    .height(40.dp),
                painter = painterResource(id = ResourceDrawable.ic_search),
                contentDescription = null
            )
        }

        Box(
            modifier = Modifier
                .padding(top = 12.dp)
                .fillMaxWidth()
                .height(1.dp)
                .background(Black)
        )

    }

}


@Preview
@Composable
fun HomeAppBarPreview() {
    HomeAppBar()
}