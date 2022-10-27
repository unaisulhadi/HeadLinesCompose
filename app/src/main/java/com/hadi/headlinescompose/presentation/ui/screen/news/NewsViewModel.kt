package com.hadi.headlinescompose.presentation.ui.screen.news

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import com.hadi.headlinescompose.data.model.NewsResponse
import com.hadi.headlinescompose.domain.repository.NewsRepository
import com.hadi.headlinescompose.utils.Resource
import com.hadi.headlinescompose.utils.ResourceDrawable
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(

    private val repository: NewsRepository

) : ViewModel() {

    var allNews : Flow<PagingData<NewsResponse.Article>> = emptyFlow()

    fun getNewsByCategory(category : String) {
        allNews = repository.getNewsByCategory(category)
    }


}
