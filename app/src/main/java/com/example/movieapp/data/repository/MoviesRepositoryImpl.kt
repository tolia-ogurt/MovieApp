package com.example.movieapp.data.repository

import com.example.movieapp.data.api.PopularMoviesApi
import com.example.movieapp.data.mappers.asDomain
import com.example.movieapp.domain.model.PopularMovies
import com.example.movieapp.domain.repository.MoviesRepository

class MoviesRepositoryImpl(private val api: PopularMoviesApi) : MoviesRepository {

    override suspend fun getPopularMovies(): PopularMovies {
        return api.getPopularMovies().asDomain()
    }
}