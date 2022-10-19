package com.hadi.headlinescompose.presentation.ui.screen.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hadi.headlinescompose.domain.repository.NewsRepository
import com.hadi.headlinescompose.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.forEach
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.merge
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: NewsRepository
) : ViewModel() {

    private val _state = mutableStateOf(HomeDataState())
    val state: State<HomeDataState> = _state

    val categories = repository.getNewsCategories()

    init {
        getTopHeadlines()
    }


    private fun getTopHeadlines() {
        val topHeadlines = repository.getTopHeadlines()
        val everything = repository.getEverything()

        val homeNews = merge(topHeadlines, everything)


        homeNews.onEach { result ->

            when(result){
                is Resource.Success -> {
                    _state.value = HomeDataState(
                        news = HomeData(
                            banners = result.data?.articles?.take(5) ?: emptyList(),
                            everything = result.data?.articles?.takeLast(10) ?: emptyList()
                        )
                    )
                }
                is Resource.Error -> {
                    _state.value = HomeDataState(error = result.message ?: "An unexpected error occurred")
                }
                is Resource.Loading -> {
                    _state.value = HomeDataState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)

    }

}