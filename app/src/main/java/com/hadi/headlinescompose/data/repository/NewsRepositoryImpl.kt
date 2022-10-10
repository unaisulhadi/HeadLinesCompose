package com.hadi.headlinescompose.data.repository

import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.hadi.headlinescompose.data.model.NewsResponse
import com.hadi.headlinescompose.data.paging.NewsPagingSource
import com.hadi.headlinescompose.data.paging.SearchNewsPagingSource
import com.hadi.headlinescompose.data.remote.NewsApi
import com.hadi.headlinescompose.domain.repository.NewsRepository
import com.hadi.headlinescompose.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val newsApi: NewsApi,
) : NewsRepository {

    override fun getTopHeadlines(): Flow<Resource<NewsResponse>> = flow {
        try {
            emit(Resource.Loading())
            val result = newsApi.getTopHeadLines()
            emit(Resource.Success(result))
        } catch (e: IOException) {
            e.printStackTrace()
            emit(Resource.Error(
                message = "Couldn't load Headlines"
            ))
        } catch (e: HttpException) {
            e.printStackTrace()
            emit(Resource.Error(
                message = "Couldn't load Headlines"
            ))
        }
    }

    override fun getEverything(): Flow<Resource<NewsResponse>> = flow {
        try {
            emit(Resource.Loading())
            val result = newsApi.getEverything()
            emit(Resource.Success(result))
        } catch (e: IOException) {
            e.printStackTrace()
            emit(Resource.Error(
                message = "Couldn't load News"
            ))
        } catch (e: HttpException) {
            e.printStackTrace()
            emit(Resource.Error(
                message = "Couldn't load News"
            ))
        }
    }

    override fun getNewsByCategory(
        category: String,
    ): Flow<PagingData<NewsResponse.Article>> = Pager(
        config = PagingConfig(
            pageSize = 10,
        ),
        pagingSourceFactory = {
            NewsPagingSource(newsApi, category)
        }
    ).flow

    override fun searchNews(query: String): Flow<PagingData<NewsResponse.Article>> = Pager(
        config = PagingConfig(
            pageSize = 10,
        ),
        pagingSourceFactory = {
            SearchNewsPagingSource(newsApi, query)
        }
    ).flow

    override fun searchNewsFlow(query: String): Flow<PagingData<NewsResponse.Article>> = Pager(
        config = PagingConfig(
            pageSize = 10,
        ),
        pagingSourceFactory = {
            SearchNewsPagingSource(newsApi, query)
        }
    ).flow
}