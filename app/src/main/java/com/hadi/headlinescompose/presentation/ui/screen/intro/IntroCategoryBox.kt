package com.hadi.headlinescompose.presentation.ui.screen.intro

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.hadi.headlinescompose.R
import com.hadi.headlinescompose.presentation.ui.theme.PrimaryRed
import com.hadi.headlinescompose.presentation.ui.theme.RockWell

@Composable
fun IntroCategoryBox(
    modifier: Modifier = Modifier,
    painter: Painter,
    title: String,
) {

    Box(
        modifier = modifier,
        contentAlignment = Alignment.BottomStart) {

        Image(
            painter = painter,
            contentScale = ContentScale.Crop,
            contentDescription = null
        )

        Text(
            modifier = Modifier
                .padding(start = 8.dp, bottom = 8.dp)
                .background(PrimaryRed)
                .padding(4.dp),
            text = title,
            fontFamily = RockWell,
            color = Color.Black
        )

    }


}