package com.hadi.headlinescompose.presentation.ui.screen.home

import com.hadi.headlinescompose.data.model.NewsResponse

data class HomeDataState(
    val isLoading: Boolean = false,
    val news: HomeData = HomeData(emptyList(), emptyList()),
    val error: String = ""
)

data class HomeData(
    val banners: List<NewsResponse.Article> = emptyList(),
    val everything: List<NewsResponse.Article> = emptyList(),
)