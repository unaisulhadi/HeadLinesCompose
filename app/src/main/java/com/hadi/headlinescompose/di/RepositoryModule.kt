package com.hadi.headlinescompose.di

import com.hadi.headlinescompose.data.remote.NewsApi
import com.hadi.headlinescompose.data.repository.NewsRepositoryImpl
import com.hadi.headlinescompose.domain.repository.NewsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideRepository(newsApi: NewsApi): NewsRepository {
       return NewsRepositoryImpl(newsApi)
    }

}