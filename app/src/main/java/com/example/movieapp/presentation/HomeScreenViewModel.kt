package com.example.movieapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.domain.model.PopularMovies
import com.example.movieapp.domain.usecase.GetPopularMoviesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomeScreenViewModel(
    private val getPopularMoviesUseCase: GetPopularMoviesUseCase
) : ViewModel() {

    private val _popularMovies = MutableStateFlow<PopularMovies?>(null)
    val popularMovies = _popularMovies.asStateFlow()

    init {
        getPopularMovies()
    }
    fun getPopularMovies() {
        viewModelScope.launch {
            _popularMovies.value = getPopularMoviesUseCase.invoke()
        }
    }

}