package com.hadi.headlinescompose.presentation.ui.screen.news

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun NewsAppBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Image(
            painter = painterResource(id = com.hadi.headlinescompose.R.drawable.newspaper),
            contentDescription = null
        )

    }
}