package com.hadi.headlinescompose.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.hadi.headlinescompose.R
import com.hadi.headlinescompose.presentation.ui.navigation.AppNavGraph
import com.hadi.headlinescompose.presentation.ui.screen.intro.SplashScreen
import com.hadi.headlinescompose.presentation.ui.theme.HeadLinesComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HeadLinesComposeTheme {


                val navController = rememberNavController()
                // A surface container using the 'background' color from the theme
                Box(modifier = Modifier) {
                    Image(
                        modifier = Modifier.fillMaxSize(),
                        painter = painterResource(id = R.drawable.background),
                        contentScale = ContentScale.Crop,
                        contentDescription = null)

                    AppNavGraph(navController = navController)

                }
            }
        }
    }
}