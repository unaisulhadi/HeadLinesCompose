package com.hadi.headlinescompose.presentation.ui.components

import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hadi.headlinescompose.presentation.ui.theme.*

@Composable
fun ShimmerEffect() {

    LazyColumn(
        contentPadding = PaddingValues(all = SMALL_PADDING),
        verticalArrangement = Arrangement.spacedBy(SMALL_PADDING)
    ) {
        items(count = 5) {
            AnimatedShimmerItem()
        }
    }

}

@Composable
fun AnimatedShimmerItem() {
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
    ShimmerItem(alpha = alphaAnim)
}


@Composable
fun ShimmerItem(alpha: Float) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(NEWS_ITEM_HEIGHT)
            .background(Color.White)
            .padding(all = SMALL_PADDING)
    ) {

        Box(
            modifier = Modifier
                .fillMaxHeight()
                .weight(1f)
                .background(ShimmerMediumGray)
        )
        Spacer(modifier = Modifier.width(SMALL_PADDING))
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .weight(2f)
        ) {

            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .background(Color.Cyan),
                color = ShimmerMediumGray
            ) {}
            Spacer(modifier = Modifier.height(SMALL_PADDING))
            repeat(3) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(18.dp)
                        .background(ShimmerMediumGray)
                )
                Spacer(modifier = Modifier.height(EXTRA_SMALL_PADDING))
            }

        }

    }
}


@Composable
@Preview
fun ShimmerItemPreview() {
    AnimatedShimmerItem()
}