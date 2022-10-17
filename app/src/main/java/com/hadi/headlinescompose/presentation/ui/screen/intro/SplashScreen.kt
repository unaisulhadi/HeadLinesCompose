package com.hadi.headlinescompose.presentation.ui.screen.intro

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.hadi.headlinescompose.R
import com.hadi.headlinescompose.presentation.ui.components.IntroCategoryBox
import com.hadi.headlinescompose.presentation.ui.navigation.Screen
import com.hadi.headlinescompose.presentation.ui.theme.Grey
import com.hadi.headlinescompose.presentation.ui.theme.PrimaryRed
import com.hadi.headlinescompose.presentation.ui.theme.RockWell

@Composable
fun SplashScreen(
    navController: NavController
) {

    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
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

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 8.dp, end = 8.dp, top = 24.dp)
        ) {

            Box(modifier = Modifier
                .weight(1f)
                .height(2.dp)
                .background(Grey))

            Box(modifier = Modifier
                .weight(1f)
                .height(2.dp))

            Box(modifier = Modifier
                .weight(1f)
                .height(2.dp)
                .background(Grey))
        }

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp, vertical = 12.dp),
            text = stringResource(id = R.string.splash_desc),
            fontFamily = RockWell,
            fontWeight = FontWeight.Bold,
            fontSize = 32.sp,
            textAlign = TextAlign.Center
        )

        Box(modifier = Modifier
            .fillMaxWidth()
            .padding(start = 8.dp, end = 8.dp)
            .height(2.dp)
            .background(Grey)
        )

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 100.dp, start = 8.dp, end = 8.dp, bottom = 12.dp)
                .height(56.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = PrimaryRed
            ),
            shape = RectangleShape,
            onClick = {

                navController.navigate(Screen.Home.route)

            }) {
            Text(
                text = stringResource(R.string.start_reading),
                fontFamily = RockWell,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }

    }


}
