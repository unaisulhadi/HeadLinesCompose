package com.hadi.headlinescompose.presentation.ui.screen.home

import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hadi.headlinescompose.presentation.ui.theme.ShimmerLightGray
import com.hadi.headlinescompose.presentation.ui.theme.ShimmerMediumGray

@Composable
fun SliderShimmerItem(
    alpha: Float
) {

    Row(
        modifier = Modifier
            .fillMaxWidth(fraction = 5f)
            .height(180.dp)
    ) {

        Column(
            modifier = Modifier
                .fillMaxHeight()
                .weight(3f)
                .padding(top = 4.dp, bottom = 4.dp, end = 8.dp, start = 8.dp)
        ) {

            Box(
                modifier = Modifier
                    .alpha(alpha = alpha)
                    .fillMaxWidth()
                    .height(25.dp)
                    .background(ShimmerMediumGray),
            ) {}

            Box(
                modifier = Modifier
                    .alpha(alpha = alpha)
                    .fillMaxWidth()
                    .height(120.dp)
                    .padding(vertical = 8.dp)
                    .background(ShimmerMediumGray)
            ) {}
            Box(
                modifier = Modifier
                    .alpha(alpha = alpha)
                    .width(150.dp)
                    .height(25.dp)
                    .background(ShimmerMediumGray)
            ) {}


        }

        Box(
            modifier = Modifier
                .alpha(alpha = alpha)
                .fillMaxHeight()
                .weight(2f)
                .padding(top = 4.dp, bottom = 4.dp, end = 8.dp)
                .background(ShimmerMediumGray),
        ) {}

    }

}

@Composable
fun AnimatedSliderShimmerItem() {
    val transition = rememberInfiniteTransition()
    val alphaAnim by transition.animateFloat(
        initialValue = 1f,
        targetValue = 0f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 500,
                easing = FastOutLinearInEasing
            ),
            repeatMode = RepeatMode.Reverse
        )
    )
    SliderShimmerItem(alpha = alphaAnim)
}

@Preview
@Composable
fun SliderShimmerPreview() {
    AnimatedSliderShimmerItem()
}