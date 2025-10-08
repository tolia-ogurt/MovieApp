package com.example.movieapp.domain.usecase

import com.example.movieapp.domain.model.PopularMovies
import com.example.movieapp.domain.repository.MoviesRepository

class GetPopularMoviesUseCase(private val moviesRepository: MoviesRepository) {
    suspend fun invoke(): PopularMovies {
        return moviesRepository.getPopularMovies()
    }
}