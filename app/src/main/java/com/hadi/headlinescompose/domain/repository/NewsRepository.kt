package com.hadi.headlinescompose.domain.repository

import androidx.lifecycle.LiveData
import androidx.paging.PagingData
import com.hadi.headlinescompose.data.model.NewsResponse
import com.hadi.headlinescompose.utils.Resource
import kotlinx.coroutines.flow.Flow

interface NewsRepository {

    fun getTopHeadlines(): Flow<Resource<NewsResponse>>

    fun getEverything(): Flow<Resource<NewsResponse>>

    fun getNewsByCategory(category: String) : Flow<PagingData<NewsResponse.Article>>

    fun searchNews(query : String) : Flow<PagingData<NewsResponse.Article>>

    fun searchNewsFlow(query: String) : Flow<PagingData<NewsResponse.Article>>

}