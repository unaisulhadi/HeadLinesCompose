package com.hadi.headlinescompose.presentation.ui.screen.details

import androidx.lifecycle.ViewModel
import com.hadi.headlinescompose.domain.repository.NewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val repository: NewsRepository
) : ViewModel() {




}