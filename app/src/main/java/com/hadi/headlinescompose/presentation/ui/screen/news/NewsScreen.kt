package com.hadi.headlinescompose.presentation.ui.screen.news

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.hadi.headlinescompose.presentation.ui.theme.PrimaryRed

@Composable
fun NewsScreen(
    navController: NavController,
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(PrimaryRed)
    ) {

        Text(text = "THIS IS NEWS SCREEN")

    }

}