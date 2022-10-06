package com.hadi.headlinescompose.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.hadi.headlinescompose.data.model.NewsResponse
import com.hadi.headlinescompose.data.remote.NewsApi
import com.hadi.headlinescompose.utils.NETWORK_PAGE_SIZE
import com.hadi.headlinescompose.utils.STARTING_INDEX
import retrofit2.HttpException
import java.io.IOException


class SearchNewsPagingSource(
    private val newsApi: NewsApi,
    var query : String
) : PagingSource<Int, NewsResponse.Article>() {


    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, NewsResponse.Article> {
        val position = params.key ?: STARTING_INDEX
        return try {
            val data = newsApi.searchNews(
                query = query,
                page = position,
                pageSize = params.loadSize)
            val nextKey = if (data.articles.isEmpty()) {
                null
            } else {
                // initial load size = 3 * NETWORK_PAGE_SIZE
                // ensure we're not requesting duplicating items, at the 2nd request
                position + (params.loadSize / NETWORK_PAGE_SIZE)
            }
            val prevKey = if (position == STARTING_INDEX) null else position - 1
            LoadResult.Page(
                data = data.articles,
                prevKey = prevKey,
                nextKey = nextKey
            )
        } catch (e: IOException) {
            return LoadResult.Error(e)
        } catch (e: HttpException) {
            return LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, NewsResponse.Article>): Int? {
        return state.anchorPosition
    }
}