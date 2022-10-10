package com.hadi.headlinescompose.presentation.ui.screen.news

import androidx.compose.animation.core.*
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.hadi.headlinescompose.presentation.ui.theme.*

@Composable
fun ShimmerEffect() {

    LazyColumn(
        contentPadding = PaddingValues(all = SMALL_PADDING),
        verticalArrangement = Arrangement.spacedBy(SMALL_PADDING)
    ){
        items(count = 2){
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
        ))
    ShimmerItem(alpha = alphaAnim)
}


@Composable
fun ShimmerItem(alpha: Float) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(NEWS_ITEM_HEIGHT),
        color = ShimmerLightGray
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(all = MEDIUM_PADDING),
        ) {
            Surface(
                modifier = Modifier
                    .alpha(alpha = alpha)
                    .fillMaxWidth(0.4f),
                color = ShimmerMediumGray,
                shape = RoundedCornerShape(size = SMALL_PADDING)
            ) {}
            Spacer(modifier = Modifier.padding(all = SMALL_PADDING))
            Surface(
                modifier = Modifier
                    .alpha(alpha = alpha)
                    .fillMaxWidth(0.6f),
                color = ShimmerMediumGray,
                shape = RoundedCornerShape(size = SMALL_PADDING)
            ) {}
        }
    }
}


@Composable
@Preview
fun ShimmerItemPreview() {
    AnimatedShimmerItem()
}