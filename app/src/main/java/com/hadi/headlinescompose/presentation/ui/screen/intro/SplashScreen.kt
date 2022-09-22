package com.hadi.headlinescompose.presentation.ui.screen.intro

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.hadi.headlinescompose.R
import com.hadi.headlinescompose.presentation.ui.components.IntroCategoryBox
import com.hadi.headlinescompose.presentation.ui.theme.Grey
import com.hadi.headlinescompose.presentation.ui.theme.PrimaryRed

@Composable
fun SplashScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 36.dp)
    ) {

        Row(modifier = Modifier
            .fillMaxWidth()
            .height(220.dp)) {

            IntroCategoryBox(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(2f)
                    .padding(start = 8.dp, top = 12.dp, end = 4.dp),
                painter = painterResource(id = R.drawable.vintage_car),
                title = "AUTOMOTIVE"
            )

            IntroCategoryBox(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f)
                    .padding(start = 4.dp, top = 12.dp, end = 8.dp),
                painter = painterResource(id = R.drawable.gas_station),
                title = "BUSINESS"
            )

        }

        Row(modifier = Modifier
            .fillMaxWidth()
            .height(220.dp)) {

            IntroCategoryBox(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f)
                    .padding(start = 8.dp, top = 8.dp, end = 4.dp),
                painter = painterResource(id = R.drawable.model_woman),
                title = "FASHION"
            )

            IntroCategoryBox(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(2f)
                    .padding(start = 4.dp, top = 8.dp, end = 8.dp),
                painter = painterResource(id = R.drawable.lifestyle),
                title = "TECHNOLOGY"
            )

        }

    }


}
