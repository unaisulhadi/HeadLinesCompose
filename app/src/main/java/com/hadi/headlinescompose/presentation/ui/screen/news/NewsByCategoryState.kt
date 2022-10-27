package com.hadi.headlinescompose.presentation.ui.screen.news

import androidx.paging.PagingData
import com.hadi.headlinescompose.data.model.NewsResponse

data class NewsByCategoryState(
    var isLoading: Boolean = false,
    val news: PagingData<NewsResponse.Article>,
    val error: String? = ""
)

