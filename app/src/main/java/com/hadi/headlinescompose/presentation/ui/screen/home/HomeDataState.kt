package com.hadi.headlinescompose.presentation.ui.screen.home

import com.hadi.headlinescompose.data.model.NewsResponse

data class HomeDataState(
    val isLoading: Boolean = false,
    val news: List<NewsResponse.Article> = emptyList(),
    val error: String = ""
)