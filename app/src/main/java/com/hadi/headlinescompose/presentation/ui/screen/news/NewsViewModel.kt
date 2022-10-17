package com.hadi.headlinescompose.presentation.ui.screen.news

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hadi.headlinescompose.data.model.NewsResponse
import com.hadi.headlinescompose.domain.repository.NewsRepository
import com.hadi.headlinescompose.utils.Resource
import com.hadi.headlinescompose.utils.ResourceDrawable
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(

    private val repository: NewsRepository

) : ViewModel() {


    val allNews = repository.getNewsByCategory("technology")



}
