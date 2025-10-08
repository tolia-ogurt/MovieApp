package com.example.movieapp.domain.repository

import com.example.movieapp.domain.model.PopularMovies

interface MoviesRepository {

    suspend fun getPopularMovies(): PopularMovies
}