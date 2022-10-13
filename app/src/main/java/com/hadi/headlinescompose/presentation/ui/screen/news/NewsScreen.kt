package com.hadi.headlinescompose.presentation.ui.screen.news

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.paging.compose.collectAsLazyPagingItems
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState
import com.hadi.headlinescompose.presentation.ui.theme.PrimaryRed

@OptIn(ExperimentalPagerApi::class)
@Composable
fun NewsScreen(
    navController: NavController,
    newsViewModel: NewsViewModel = hiltViewModel(),
) {
    val pagerState = rememberPagerState()

    val news = newsViewModel.allNews.collectAsLazyPagingItems()

    Scaffold(
        topBar = { NewsAppBar() },
        content = {
            ListContent(
                news = news,
                navController = navController
            )
        }
    )

//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .background(PrimaryRed)
//    ) {

//        HorizontalPager(
//            modifier = Modifier.weight(10f),
//            state = pagerState,
//            count = pages.size,
//            verticalAlignment = Alignment.Top
//        ) { position ->
//            PagerScreen(onBoardingPage = pages[position])
//
//        }
//        HorizontalPagerIndicator(
//            modifier = Modifier
//                .weight(1f)
//                .align(Alignment.CenterHorizontally),
//            pagerState = pagerState,
//            activeColor = MaterialTheme.colors.activeIndicatorColor,
//            inactiveColor = MaterialTheme.colors.inactiveIndicatorColor,
//            indicatorWidth = PAGING_INDICATOR_WIDTH,
//            spacing = PAGING_INDICATOR_SPACING
//        )

//    }

}