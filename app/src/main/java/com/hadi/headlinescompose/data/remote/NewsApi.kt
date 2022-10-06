package com.hadi.headlinescompose.data.remote

import com.hadi.headlinescompose.BuildConfig
import com.hadi.headlinescompose.data.model.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    companion object {
        const val BASE_URL = "https://newsapi.org/v2/"
    }

    @GET("top-headlines")
    suspend fun getTopHeadLines(
        @Query("country") country: String = "in",
        @Query("apiKey") apiKey: String = BuildConfig.API_KEY,
    ): NewsResponse


    @GET("everything?q=technology")
    suspend fun getEverything(
        @Query("apiKey") apiKey: String = BuildConfig.API_KEY,
    ): NewsResponse

    @GET("top-headlines")
    suspend fun getNewsByCategory(
        @Query("category") category: String,
        @Query("country") country: String = "in",
        @Query("apiKey") apiKey: String = BuildConfig.API_KEY,
        @Query("page") page: Int,
        @Query("pageSize") pageSize: Int
    ): NewsResponse

    @GET("everything")
    suspend fun searchNews(
        @Query("apiKey") apiKey: String = BuildConfig.API_KEY,
        @Query("q") query: String,
        @Query("page") page: Int,
        @Query("pageSize") pageSize: Int
    ): NewsResponse


}